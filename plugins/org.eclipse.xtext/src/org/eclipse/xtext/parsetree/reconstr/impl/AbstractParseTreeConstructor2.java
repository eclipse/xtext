/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractParseTreeConstructor2 implements
		IParseTreeConstructor {

	public abstract class AbstractToken2 implements IAbstractToken {
		protected final IInstanceDescription current;
		protected final AbstractToken2 next;
		protected final int no;
		protected final AbstractToken2 parent;

		public AbstractToken2(AbstractToken2 parent, AbstractToken2 next,
				int no, IInstanceDescription current) {
			this.next = next;
			this.parent = parent;
			this.no = no;
			this.current = current;
		}

		protected boolean checkForRecursion(Class<?> clazz,
				IInstanceDescription curr) {
			IAbstractToken token = next;
			while (token != null) {
				if (token.getClass() == clazz)
					return token.getCurrent() == curr;
				token = token.getNext();
			}
			return false;
		}

		public AbstractToken2 createFollower(int index,
				IInstanceDescription inst) {
			return null;
		}

		public AbstractToken2 createParentFollower(AbstractToken2 next,
				int index, IInstanceDescription inst) {
			return null;
		}

		public IInstanceDescription getCurrent() {
			return current;
		}

		public String getDiagnostic() {
			return null;
		}

		public AbstractToken2 getNext() {
			return next;
		}

		public int getNo() {
			return no;
		}

		public AbstractToken2 getParent() {
			return parent;
		}

		public AbstractParseTreeConstructor2 getParseTreeConstructor() {
			return AbstractParseTreeConstructor2.this;
		}

		public String serialize() {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
				tokenSerializer.serialize(this, out);
			} catch (Throwable e) {
				e.printStackTrace();
				return "Error: " + e.getMessage();
			}
			return out.toString();
		}

		public IInstanceDescription tryConsume() {
			return tryConsumeVal();
		}

		protected abstract IInstanceDescription tryConsumeVal();
	}

	public abstract class ActionToken extends AbstractToken2 implements
			IActionToken {

		public ActionToken(AbstractToken2 parent, AbstractToken2 next, int no,
				IInstanceDescription current) {
			super(parent, next, no, current);
		}
	}

	public abstract class AlternativesToken extends AbstractToken2 implements
			IAlternativeesToken {

		public AlternativesToken(AbstractToken2 parent, AbstractToken2 next,
				int no, IInstanceDescription current) {
			super(parent, next, no, current);
		}

		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}

	public abstract class AssignmentToken extends AbstractToken2 implements
			IAssignmentToken {

		protected IInstanceDescription consumed;

		protected AbstractElement element;

		protected AssignmentType type;

		protected Object value;

		public AssignmentToken(AbstractToken2 parent, AbstractToken2 next,
				int no, IInstanceDescription current) {
			super(parent, next, no, current);
		}

		public AbstractElement getAssignmentElement() {
			return element;
		}

		public AssignmentType getType() {
			return type;
		}

		public Object getValue() {
			return value;
		}
	}

	public abstract class GroupToken extends AbstractToken2 implements
			IGroupToken {

		public GroupToken(AbstractToken2 parent, AbstractToken2 next, int no,
				IInstanceDescription current) {
			super(parent, next, no, current);
		}

		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}

	public abstract class KeywordToken extends AbstractToken2 implements
			IKeywordToken {

		public KeywordToken(AbstractToken2 parent, AbstractToken2 next, int no,
				IInstanceDescription current) {
			super(parent, next, no, current);
		}

		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}

	public class RootToken extends AbstractToken2 {

		private RootToken(AbstractToken2 next, IInstanceDescription inst) {
			super(null, next, 0, inst);
		}

		public RootToken(IInstanceDescription inst) {
			super(null, null, 0, inst);
		}

		public boolean containsRuleCall() {
			return true;
		}

		public AbstractToken2 createParentFollower(AbstractToken2 next,
				int index, IInstanceDescription inst) {
			return index == 0 ? new RootToken(next, inst) : null;
		}

		public AbstractElement getGrammarElement() {
			return null;
		}

		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}

	public abstract class RuleCallToken extends AbstractToken2 implements
			IRuleCallToken {

		public RuleCallToken(AbstractToken2 parent, AbstractToken2 next,
				int no, IInstanceDescription current) {
			super(parent, next, no, current);
		}
	}

	protected List<IAbstractToken> fails = new ArrayList<IAbstractToken>();

	private final Logger log = Logger
			.getLogger(AbstractParseTreeConstructor2.class);

	@Inject
	protected ITokenSerializer tokenSerializer;

	@Inject
	protected ITransientValueService tvService;

	protected String debug(AbstractToken2 t, IInstanceDescription i) {
		AbstractToken2 x = t;
		StringBuffer b = new StringBuffer();
		while ((x = x.getNext()) != null)
			b.append("  ");
		b.append(t.getClass().getSimpleName() + " -> " + i);
		return b.toString();
	}

	protected final IInstanceDescription getDescr(EObject obj) {
		return new InstanceDescription(tvService, obj);
	}

	public List<IAbstractToken> getFails() {
		return fails;
	}

	public abstract IGrammarAccess getGrammarAccess();

	protected abstract AbstractToken2 getRootToken(IInstanceDescription inst);

	public IAbstractToken serialize(EObject object) {
		fails.clear();
		IInstanceDescription inst = getDescr(object);
		AbstractToken2 f = getRootToken(inst);
		int no = 0;
		while (f != null) {
			if (log.isTraceEnabled())
				log.trace(debug(f, inst));
			AbstractToken2 n = null;
			IInstanceDescription i = null;
			if ((n = f.createFollower(no, inst)) != null) {
				while (n != null && (i = n.tryConsume()) == null)
					n = f.createFollower(++no, inst);
			}
			if (n instanceof RootToken && n.getNext() != null)
				return n.getNext();
			if (n != null && i != null) {
				f = n;
				inst = i;
				no = 0;
			} else {
				fails.add(f);
				no = f.getNo() + 1;
				inst = f.getCurrent();
				f = f.getNext();
			}
		}
		// TODO: improve error reporting
		throw new XtextSerializationException(inst, "Serialization failed");
	}
}
