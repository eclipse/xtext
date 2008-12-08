package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.service.ServiceRegistry;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractParseTreeConstructor implements
		IParseTreeConstructor {

	public abstract class AbstractToken implements IAbstractToken {

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
		protected boolean required; // TODO: make this final again

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

		protected String depth(AbstractToken ele) {
			StringBuffer b = new StringBuffer();
			for (AbstractToken t = ele.predecessor; t != null; t = t.predecessor)
				b.append(" ");
			return b.toString();
		}

		private String dsl(AbstractToken ele) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
				SimpleTokenSerializer sts = new SimpleTokenSerializer();
				ServiceRegistry.injectServices(XtextStandaloneSetup
						.getServiceScope(), sts);
				sts.serialize(ele, out);
			} catch (Throwable e) {
				e.printStackTrace();
				return "Error: " + e.getMessage();
			}
			return out.toString();
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
			else
				otherSolution = required ? null : new Solution(current,
						predecessor);
			if (many) {
				AbstractToken t = newInstance(t1.getCurrent(), t1
						.getPredecessor());
				t.required = false;
				Solution t3 = t.firstSolution();

				if (t3 != null)
					return t3;
			}
			return t1;
		}

		public IInstanceDescription getCurrent() {
			return current;
		}

		public IAbstractToken getNext() {
			return predecessor;
		}

		protected Solution localNextSolution() {
			if (otherSolution != null) {
				Solution t = otherSolution;
				otherSolution = null;
				return t;
			} else if (activateNextSolution())
				return firstSolution();
			return null;
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

		public Solution nextSolution(AbstractToken limit) {
			if (log.isDebugEnabled())
				log.debug("--" + depth(limit)
						+ limit.getClass().getSimpleName()
						+ " -> nextSolution()");
			AbstractToken t = this;
			while (t != null && t != limit) {
				Solution s = t.localNextSolution();
				if (s != null) {
					if (log.isDebugEnabled())
						log.debug("--" + depth(this)
								+ getClass().getSimpleName()
								+ " -> nextSolution() -> "
								+ t.getClass().getSimpleName() + " ("
								+ s.getPredecessor().getClass().getSimpleName()
								+ ")");
					return s;
				}
				t = t.predecessor;
			}
			if (log.isDebugEnabled())
				log.debug("-- " + depth(this) + getClass().getSimpleName()
						+ " -> nextSolution() -> not found");
			if (t == null)
				throw new IllegalStateException("Bug found");
			return null;
		}
	}

	public abstract class ActionToken extends AbstractToken implements
			IActionToken {

		public ActionToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class AlternativesToken extends AbstractToken implements
			IAlternativeesToken {

		protected boolean first = true;

		protected AbstractToken last;

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

		public IAbstractToken getLast() {
			return last;
		}
	}

	public abstract class AssignmentToken extends AbstractToken implements
			IAssignmentToken {

		protected AbstractElement element;

		protected Object value;

		protected AssignmentType type;

		public AssignmentToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

		public AbstractElement getAssignmentElement() {
			return element;
		}

		public Assignment getGrammarElement() {
			return GrammarUtil.containingAssignment(element);
		}

		public AssignmentType getType() {
			return type;
		}

		public Object getValue() {
			return value;
		}

	}

	public abstract class GroupToken extends AbstractToken implements
			IGroupToken {

		protected AbstractToken last;

		public GroupToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

		public IAbstractToken getLast() {
			return last;
		}

	}

	public abstract class KeywordToken extends AbstractToken implements
			IKeywordToken {

		public KeywordToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

		protected Solution createSolution() {
			return new Solution();
		}
	}

	public abstract class RuleCallToken extends AbstractToken implements
			IRuleCallToken {

		public RuleCallToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	protected Logger log = Logger.getLogger(AbstractParseTreeConstructor.class);

	@Inject
	private IAstFactory factory;

	@Inject
	private ITransientValueService tvService;

	protected final IInstanceDescription getDescr(EObject obj) {
		return new InstanceDescription(this, obj);
	}

	protected final IInstanceDescription getDescr(IInstanceDescription obj) {
		return obj;
	}

	public IAstFactory getFactory() {
		return factory;
	}

	public ITransientValueService getTVService() {
		return tvService;
	}

}
