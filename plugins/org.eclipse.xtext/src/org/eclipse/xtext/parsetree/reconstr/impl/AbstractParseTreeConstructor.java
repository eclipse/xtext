package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback;
import org.eclipse.xtext.parsetree.reconstr.callbacks.SimpleSerializingCallback;
import org.eclipse.xtext.service.Inject;

public abstract class AbstractParseTreeConstructor implements
		IParseTreeConstructor {
	public abstract class AbstractToken {
		protected final static boolean IS_MANY = true;
		protected final static boolean IS_REQUIRED = true;
		protected boolean many;

		// TODO: rename to current
		protected InstanceDescription object;
		protected AbstractToken otherSolution;

		protected AbstractToken predecessor;
		protected boolean required;

		public AbstractToken(AbstractToken predecessor, boolean many,
				boolean required) {
			super();
			this.predecessor = predecessor;
			this.many = many;
			this.required = required;
		}

		protected boolean activateNextOption() {
			return false;
		}

		protected boolean checkForRecursion() {
			Class<?> clazz = getClass();
			AbstractToken token = predecessor;
			while (token != null) {
				if (token.getClass() == clazz)
					return token.object == object;
				token = token.predecessor;
			}
			return false;
		}

		public AbstractToken createFirstSolution(InstanceDescription obj) {
			System.out.println("->" + depth(this) + getClass().getSimpleName()
					+ "\t " + obj + " -> " + dsl(this));
			object = obj;
			AbstractToken t1 = createOneChild(this);
			System.out
					.println("< "
							+ depth(this)
							+ getClass().getSimpleName()
							+ " -> "
							+ ((t1 == null) ? "failed" : "success" + "\t "
									+ t1.object));
			if (t1 == null)
				return required ? null : predecessor;
			if (many) {
				AbstractToken t2 = newInstance(t1);
				AbstractToken t3 = t2.createFirstSolution(t1.object);

				if (t3 != null) {
					otherSolution = t1;
					object = t2.object;
					return t3;
				}
			}
			return t1;
		}

		public AbstractToken createNextSolution() {
			if (otherSolution != null) {
				AbstractToken t = otherSolution;
				otherSolution = null;
				return t;
			} else if (activateNextOption())
				return createFirstSolution(object);
			return null;
		}

		protected abstract AbstractToken createOneChild(
				AbstractToken predecessor);

		private String depth(AbstractToken ele) {
			StringBuffer b = new StringBuffer();
			for (AbstractToken t = ele.predecessor; t != null; t = t.predecessor)
				b.append(" ");
			return b.toString();
		}

		private String dsl(AbstractToken ele) {
			SimpleSerializingCallback cb = new SimpleSerializingCallback(
					converterService);
			executeAllCallbacks(cb);
			return cb.toString();
		}

		public void executeAllCallbacks(IParseTreeConstructorCallback callback) {
			AbstractToken ele = this;
			while (ele != null) {
				ele.executeCallback(callback);
				ele = ele.predecessor;
			}
		}

		protected abstract void executeCallback(
				IParseTreeConstructorCallback callback);

		public InstanceDescription getObject() {
			return object;
		}

		protected abstract AbstractToken newInstance(AbstractToken predecessor);
	}

	public abstract class ActionToken extends AbstractToken {

		public ActionToken(AbstractToken predecessor, boolean many,
				boolean optional) {
			super(predecessor, many, optional);
		}

	}

	public abstract class AlternativeToken extends AbstractToken {

		public AlternativeToken(AbstractToken predecessor, boolean many,
				boolean optional) {
			super(predecessor, many, optional);
		}

	}

	public abstract class AssignmentToken extends AbstractToken {

		public AssignmentToken(AbstractToken predecessor, boolean many,
				boolean optional) {
			super(predecessor, many, optional);
		}

	}

	public abstract class GroupToken extends AbstractToken {

		public GroupToken(AbstractToken predecessor, boolean many,
				boolean optional) {
			super(predecessor, many, optional);
		}

	}

	public abstract class KeywordToken extends AbstractToken {

		public KeywordToken(AbstractToken predecessor, boolean many,
				boolean optional) {
			super(predecessor, many, optional);
		}

	}

	public abstract class RuleCallToken extends AbstractToken {

		public RuleCallToken(AbstractToken predecessor, boolean many,
				boolean optional) {
			super(predecessor, many, optional);
		}

	}

	@Inject
	protected IValueConverterService converterService;

	@Inject
	private IAstFactory factory;

	@Inject
	private IGrammarAccess grammar;

	protected final InstanceDescription getDescr(EObject obj) {
		return new InstanceDescription(this, obj);
	}

	protected final IInstanceDescription getDescr(IInstanceDescription obj) {
		return obj;
	}

	public IAstFactory getFactory() {
		return factory;
	}

	protected Grammar getGrammar() {
		return grammar.getGrammar();
	}

	protected EObject getGrammarElement(String string) {
		return grammar.getGrammar().eResource().getResourceSet().getEObject(
				URI.createURI(string), true);
	}

	protected IValueConverterService getValueConverterService() {
		return converterService;
	}

	protected abstract void internalDoUpdate(EObject obj, String ruleToCall,
			IParseTreeConstructorCallback callback);

	public void update(EObject object, IParseTreeConstructorCallback callback) {
		EObject root = EcoreUtil.getRootContainer(object);
		ParserRule parserRule = GrammarUtil.getDefaultEntryRule(getGrammar());
		String ruleToCall = parserRule.getName();
		internalDoUpdate(root, ruleToCall, callback);
	}

}
