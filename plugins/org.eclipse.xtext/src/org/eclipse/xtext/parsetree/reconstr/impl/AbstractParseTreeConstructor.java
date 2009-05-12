/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken.Solution;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractParseTreeConstructor implements
		IParseTreeConstructor {

	public static abstract class AbstractSerializationDiagnostic implements
			Resource.Diagnostic, Comparable<AbstractSerializationDiagnostic> {

		protected String msg;

		private int prio = -1;

		protected AbstractToken token;

		protected boolean subsequentMessage = false;

		public boolean isSubsequentMessage() {
			return subsequentMessage;
		}

		public int compareTo(AbstractSerializationDiagnostic o) {
			return (getPrio() > o.getPrio() ? -1
					: (getPrio() == o.getPrio() ? 0 : 1));
		}

		public int getColumn() {
			return 0;
		}

		public int getLine() {
			return 0;
		}

		public String getLocation() {
			return token == null ? "root" : token.getClass().getSimpleName();
		}

		public String getMessage() {
			return msg;
		}

		public int getPrio() {
			if (prio < 0) {
				prio = 0;
				for (AbstractToken t = token; t != null; t = t.predecessor)
					prio++;
			}
			return prio;
		}

		@Override
		public String toString() {
			return getPrio() + ": in " + getLocation() + ": " + getMessage();
		}

	}

	@Inject
	protected ITokenSerializer tokenSerializer;

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
			if (ele == null)
				return "";
			StringBuffer b = new StringBuffer();
			for (AbstractToken t = ele.predecessor; t != null; t = t.predecessor)
				b.append(" ");
			return b.toString();
		}

		private String dsl(AbstractToken ele) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
				tokenSerializer.serialize(ele, out);
			} catch (Throwable e) {
				e.printStackTrace();
				return "Error: " + e.getMessage();
			}
			return out.toString();
		}

//		protected Object text = new Object() {

//			@Override
//			public String toString() {
//				return dsl(AbstractToken.this);
//			}

//		};

		public Solution firstSolution() {
			if (log.isTraceEnabled())
				log.trace("->" + depth(this) + getClass().getSimpleName()
						+ "\t " + current + " -> " + dsl(this));
			Solution t1 = createSolution();
			if (log.isTraceEnabled())
				log.trace("< "
						+ depth(this)
						+ getClass().getSimpleName()
						+ " -> "
						+ ((t1 == null) ? "failed" : "success" + "\t "
								+ t1.current));

			if (t1 == null)
				return required ? null : new Solution(current, predecessor);

			otherSolution = required ? null
					: new Solution(current, predecessor);
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

		public abstract AbstractElement getGrammarElement();

		public Solution nextSolution(AbstractToken limit, Solution last) {
			if (log.isTraceEnabled())
				log.trace("--"
						+ depth(limit)
						+ ((limit == null) ? "root" : limit.getClass()
								.getSimpleName()) + " -> nextSolution() -> "
						+ dsl(this));
			AbstractToken t = this;
			while (t != null && t != limit) {
				Solution s;
				do {
					s = t.localNextSolution();
					if (s != null) {
						boolean valid = last.getCurrent().getDelegate() == s
								.getCurrent().getDelegate();
						if (log.isTraceEnabled())
							log
									.trace("--"
											+ depth(this)
											+ getClass().getSimpleName()
											+ " -> nextSolution() -> "
											+ t.getClass().getSimpleName()
											+ " ("
											+ s.getPredecessor().getClass()
													.getSimpleName()
											+ ")"
											+ (valid ? ""
													: " -> delegates differ, discarding solution."));
						if (valid)
							return s;
					}
				} while (s != null);
				t = t.predecessor;
			}
			if (log.isTraceEnabled())
				log.trace("-- " + depth(this) + getClass().getSimpleName()
						+ " -> nextSolution() -> not found");
			// if (t == null)
			// throw new IllegalStateException("Bug found");
			return null;
		}
	}

	public abstract class ActionToken extends AbstractToken implements
			IActionToken {
		@Override
		public abstract Action getGrammarElement();

		public ActionToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	public abstract class AlternativesToken extends AbstractToken implements
			IAlternativeesToken {

		@Override
		public abstract Alternatives getGrammarElement();

		protected int alt = getGrammarElement().getGroups().size() - 1;

		protected AbstractToken last;

		// TODO: remove this variable
		protected boolean first = true;

		public AlternativesToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

		@Override
		protected boolean activateNextSolution() {
			return --alt > -1;
		}

		@Override
		protected Solution createSolution() {
			do {
				Solution s = createChild(alt).firstSolution();
				if (s != null) {
					last = s.getPredecessor();
					return s;
				}
			} while (activateNextSolution());
			return null;
		}

		// TODO: make this method abstract
		protected AbstractToken createChild(int id) {
			return null;
		}

		public IAbstractToken getLast() {
			return last;
		}
	}

	public abstract class AssignmentToken extends AbstractToken implements
			IAssignmentToken {

		protected AbstractElement element;

		protected AssignmentType type;

		protected Object value;
		
		public AssignmentToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

		public AbstractElement getAssignmentElement() {
			return element;
		}

		@Override
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

	public class FeatureNotConsumedDiagnostic extends
			AbstractSerializationDiagnostic {

		public FeatureNotConsumedDiagnostic(AbstractToken token, Solution s) {
			super();
			this.token = token;
			this.current = s.getCurrent();
			ArrayList<String> unconsumed = new ArrayList<String>();
			for (Entry<EStructuralFeature, Integer> e : s.getCurrent()
					.getUnconsumed().entrySet())
				unconsumed.add(e.getValue() + "x " + e.getKey().getName());
			EObject o = s.getCurrent().getDelegate();
			this.msg = "Unconsumed feature(s): " + unconsumed + " in "
					+ o.eClass().getName() + ", path:" + getPath(o);
		}

		protected IInstanceDescription current;

		public IInstanceDescription getCurrent() {
			return current;
		}

	}

	public abstract class GroupToken extends AbstractToken implements
			IGroupToken {

		@Override
		public abstract Group getGrammarElement();

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

		@Override
		public abstract Keyword getGrammarElement();

		public KeywordToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

		@Override
		protected Solution createSolution() {
			return new Solution();
		}
	}

	public abstract class RuleCallToken extends AbstractToken implements
			IRuleCallToken {

		@Override
		public abstract RuleCall getGrammarElement();

		public RuleCallToken(IInstanceDescription curr, AbstractToken pred,
				boolean many, boolean required) {
			super(curr, pred, many, required);
		}

	}

	protected List<AbstractSerializationDiagnostic> diagnostic = new ArrayList<AbstractSerializationDiagnostic>();

	private final Logger log = Logger
			.getLogger(AbstractParseTreeConstructor.class);

	private EObject rootObject;

	@Inject
	private ITransientValueService tvService;

	protected final IInstanceDescription getDescr(EObject obj) {
		return new InstanceDescription(tvService, obj);
	}

	protected final IInstanceDescription getDescr(IInstanceDescription obj) {
		return obj;
	}

	protected String getPath(EObject obj) {
		if (obj.eContainer() == null || obj == rootObject)
			return "";
		EObject c = obj.eContainer();
		EReference r = obj.eContainmentFeature();
		if (r.isMany()) {
			int index = ((List<?>) c.eGet(r)).indexOf(obj);
			return getPath(c) + "/" + r.getName() + "[" + index + "]";
		}
		return getPath(c) + "/" + r.getName();
	}

	public ITransientValueService getTVService() {
		return tvService;
	}

	protected abstract Solution internalSerialize(EObject obj);

	protected boolean isConsumed(Solution s, AbstractToken token) {
		if (s.getCurrent().isConsumed())
			return true;
		if (!isSubsequentNonconsumption(s.getCurrent().getDelegate()))
			diagnostic.add(new FeatureNotConsumedDiagnostic(token, s));
		return false;
	}

	protected boolean isSubsequentNonconsumption(EObject obj) {
		for (AbstractSerializationDiagnostic d : diagnostic)
			if (d instanceof FeatureNotConsumedDiagnostic) {
				EObject del = ((FeatureNotConsumedDiagnostic) d).getCurrent()
						.getDelegate().eContainer();
				while (del != null) {
					if (del == obj)
						return true;
					del = del.eContainer();
				}
			}
		return false;
	}

	public IAbstractToken serialize(EObject object) {
		diagnostic.clear();
		rootObject = object;
		if (object == null)
			throw new IllegalArgumentException(
					"The to-be-serialialized model is null");
		Solution t = internalSerialize(object);
		if (t == null)
			throw new XtextSerializationException(getDescr(object),
					"Serialization of " + object.eClass().getName()
							+ " failed.", diagnostic);
		return t.getPredecessor();
	}

}
