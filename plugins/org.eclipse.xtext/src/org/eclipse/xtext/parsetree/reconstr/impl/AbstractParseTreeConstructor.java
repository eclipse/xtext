package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructorCallback;
import org.eclipse.xtext.service.Inject;

public abstract class AbstractParseTreeConstructor implements
		IParseTreeConstructor {

	protected enum AssignmentType {
		KW, PRC, LRC, CR
	};

	public abstract class AbstractToken {

		public class Solution {
			private final IInstanceDescription current;
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

			public Solution(final IInstanceDescription current) {
				super();
				this.current = current;
				this.predecessor = AbstractToken.this;
			}

			public Solution(IInstanceDescription current,
					AbstractToken predecessor) {
				super();
				this.current = current;
				this.predecessor = predecessor;
			}

			public IInstanceDescription getCurrent() {
				return current;
			}

			public AbstractToken getPredecessor() {
				return predecessor;
			}
		}

		protected final static boolean IS_MANY = true;
		protected final static boolean IS_REQUIRED = true;
		protected final IInstanceDescription current;
		protected final boolean many;
		protected Solution otherSolution;
		protected final AbstractToken predecessor;
		protected final boolean required;

		public AbstractToken(IInstanceDescription curr, AbstractToken pred,
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
			// ByteArrayOutputStream out = new ByteArrayOutputStream();
			// SimpleSerializingCallback cb = new SimpleSerializingCallback(out,
			// converterService);
			// executeAllCallbacks(cb);
			// return out.toString();
			return "";
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
			if (log.isDebugEnabled())
				log.debug("->" + depth(this) + getClass().getSimpleName()
						+ "\t " + current + " -> " + dsl(this));
			Solution t1 = createSolution();
			if (log.isDebugEnabled())
				log.debug("< "
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

		protected AbstractToken newInstance(IInstanceDescription curr,
				AbstractToken pred) {
			try {
				Constructor<?> c = getClass().getConstructor(
						getClass().getEnclosingClass(),
						IInstanceDescription.class, AbstractToken.class);
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

		public ActionToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class AlternativesToken extends AbstractToken {

		protected boolean first = true;

		public AlternativesToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

		protected boolean activateNextSolution() {
			if (first) {
				first = false;
				return true;
			}
			return false;
		}
	}

	public abstract class AssignmentToken extends AbstractToken {
		protected AbstractElement element;
		protected Object value;
		protected AssignmentType type;

		public AssignmentToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

		public void executeCallback(IParseTreeConstructorCallback callback) {
			if (type != null)
				switch (type) {
				case KW:
					callback.keywordCall(current, (Keyword) element);
					return;
				case PRC: /* noting to do for parser rule calls */
					return;
				case LRC:
					callback.lexerRuleCall(current, (RuleCall) element, value);
					return;
				case CR:
					callback.crossRefCall(current, (CrossReference) element,
							(EObject) value);
					return;
				}
		}
	}

	public abstract class GroupToken extends AbstractToken {

		public GroupToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class KeywordToken extends AbstractToken {

		public KeywordToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class RuleCallToken extends AbstractToken {

		public RuleCallToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	protected Logger log = Logger.getLogger(AbstractParseTreeConstructor.class);

	@Inject
	private IParseTreeConstructorCallback serializerStrategy;

	@Inject
	private IValueConverterService converterService;

	@Inject
	private IAstFactory factory;

	@Inject
	private IGrammarAccess grammar;

	protected final IInstanceDescription getDescr(EObject obj) {
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

	public IValueConverterService getValueConverterService() {
		return converterService;
	}

	public static final String OPTION_SERIALIZER_STRATEGY = "OPTION_SERIALIZER_STRATEGY";

	private IParseTreeConstructorCallback getSerializerStrategy(
			Map<?, ?> options) {
		Object serObj = options.get(OPTION_SERIALIZER_STRATEGY);
		if (serObj == null)
			return serializerStrategy;
		if (serObj instanceof IParseTreeConstructorCallback)
			return (IParseTreeConstructorCallback) serObj;
		throw new IllegalStateException("The Object supplied with "
				+ OPTION_SERIALIZER_STRATEGY + " needs to be of type "
				+ IParseTreeConstructorCallback.class.getName());
	}

	public void serialize(OutputStream outputStream, EObject object,
			Map<?, ?> options) {
		IParseTreeConstructorCallback ser = getSerializerStrategy(options);
		ser.beginSerialize(outputStream);
		internalSerialize(object, ser);
		ser.endSerialize();
	}

	protected abstract void internalSerialize(EObject object,
			IParseTreeConstructorCallback strategy);

}
