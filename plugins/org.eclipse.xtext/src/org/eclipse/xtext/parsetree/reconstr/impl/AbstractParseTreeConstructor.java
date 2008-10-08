package org.eclipse.xtext.parsetree.reconstr.impl;


import java.io.ByteArrayOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

		public class Solution {
			private final InstanceDescription current;
			private final AbstractToken predecessor;

			public Solution() {
				super();
				this.current = AbstractToken.this.current;
				this.predecessor = AbstractToken.this;
			}

			public Solution(AbstractToken predecessor) {
				super();
				this.current = AbstractToken.this.current;
				this.predecessor = predecessor;
			}

			public Solution(final InstanceDescription current) {
				super();
				this.current = current;
				this.predecessor = AbstractToken.this;
			}

			public Solution(InstanceDescription current,
					AbstractToken predecessor) {
				super();
				this.current = current;
				this.predecessor = predecessor;
			}

			public InstanceDescription getCurrent() {
				return current;
			}

			public AbstractToken getPredecessor() {
				return predecessor;
			}
		}

		protected final static boolean IS_MANY = true;
		protected final static boolean IS_REQUIRED = true;
		protected final InstanceDescription current;
		protected final boolean many;
		protected Solution otherSolution;
		protected final AbstractToken predecessor;
		protected final boolean required;

		public AbstractToken(InstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super();
			this.current = curr;
			this.predecessor = pred;
			this.many = many;
			this.required = required;
		}

		protected boolean activateNextSolution() {
			return false;
		}

		protected boolean checkForRecursion(Class<?> clazz,
				IInstanceDescription curr) {
			AbstractToken token = predecessor;
			while (token != null) {
				if (token.getClass() == clazz)
					return token.current == curr;
				token = token.predecessor;
			}
			return false;
		}

		protected abstract Solution createSolution();

		private String depth(AbstractToken ele) {
			StringBuffer b = new StringBuffer();
			for (AbstractToken t = ele.predecessor; t != null; t = t.predecessor)
				b.append(" ");
			return b.toString();
		}

		private String dsl(AbstractToken ele) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			SimpleSerializingCallback cb = new SimpleSerializingCallback(out,
					converterService);
			executeAllCallbacks(cb);
			return out.toString();
		}

		public void executeAllCallbacks(IParseTreeConstructorCallback callback) {
			AbstractToken ele = this;
			while (ele != null) {
				ele.executeCallback(callback);
				ele = ele.predecessor;
			}
		}

		protected void executeCallback(IParseTreeConstructorCallback callback) {
		}

		public Solution firstSolution() {
			System.out.println("->" + depth(this) + getClass().getSimpleName()
					+ "\t " + current + " -> " + dsl(this));
			Solution t1 = createSolution();
			System.out
					.println("< "
							+ depth(this)
							+ getClass().getSimpleName()
							+ " -> "
							+ ((t1 == null) ? "failed" : "success" + "\t "
									+ t1.current));
			if (t1 == null)
				return required ? null : new Solution(current, predecessor);
			if (many) {
				Solution t3 = newInstance(t1.getCurrent(), t1.getPredecessor())
						.firstSolution();

				if (t3 != null) {
					otherSolution = t1;
					return t3;
				}
			}
			return t1;
		}

		protected AbstractToken newInstance(InstanceDescription curr,
				AbstractToken pred) {
			try {
				Constructor<?> c = getClass().getConstructor(
						getClass().getEnclosingClass(),
						InstanceDescription.class, AbstractToken.class);
				return (AbstractToken) c.newInstance(
						AbstractParseTreeConstructor.this, curr, pred);
			} catch (SecurityException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e);
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			}
		}

		public Solution nextSolution() {
			if (otherSolution != null) {
				Solution t = otherSolution;
				otherSolution = null;
				return t;
			} else if (activateNextSolution())
				return firstSolution();
			return null;
		}
	}

	public abstract class ActionToken extends AbstractToken {

		public ActionToken(InstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class AlternativeToken extends AbstractToken {

		public AlternativeToken(InstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class AssignmentToken extends AbstractToken {

		public AssignmentToken(InstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class GroupToken extends AbstractToken {

		public GroupToken(InstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class KeywordToken extends AbstractToken {

		public KeywordToken(InstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class RuleCallToken extends AbstractToken {

		public RuleCallToken(InstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
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
