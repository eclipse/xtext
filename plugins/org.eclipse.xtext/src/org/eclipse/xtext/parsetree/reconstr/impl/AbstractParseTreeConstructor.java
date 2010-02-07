/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.parsetree.reconstr.ICrossReferenceSerializer;
import org.eclipse.xtext.parsetree.reconstr.IInstanceDescription;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.parsetree.reconstr.IUnassignedTextSerializer;
import org.eclipse.xtext.parsetree.reconstr.XtextSerializationException;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractParseTreeConstructor implements
		IParseTreeConstructor {

	public abstract class AbstractToken {
		protected final IInstanceDescription current;
		protected final AbstractToken next;
		protected final int no;
		protected final AbstractToken parent;

		public AbstractToken(AbstractToken parent, AbstractToken next, int no,
				IInstanceDescription current) {
			this.next = next;
			this.parent = parent;
			this.no = no;
			this.current = current;
		}

		protected boolean checkForRecursion(Class<?> clazz,
				IInstanceDescription curr) {
			AbstractToken token = next;
			while (token != null) {
				if (token.getClass() == clazz)
					return token.getCurrent() == curr;
				token = token.getNext();
			}
			return false;
		}

		public AbstractToken createFollower(int index, IInstanceDescription inst) {
			return null;
		}

		public AbstractToken createParentFollower(AbstractToken next,
				int index, IInstanceDescription inst) {
			return createParentFollower(next, index, index, inst);
		}

		public AbstractToken createParentFollower(AbstractToken next,
				int actIndex, int index, IInstanceDescription inst) {
			return null;
		}

		public IInstanceDescription getCurrent() {
			return current;
		}

		public String getDiagnostic() {
			return null;
		}

		public abstract AbstractElement getGrammarElement();

		public AbstractToken getNext() {
			return next;
		}

		public int getNo() {
			return no;
		}

		public AbstractToken getParent() {
			return parent;
		}

		public String serialize(int depth, int length, boolean appendDots) {
			ArrayList<String> tokens = new ArrayList<String>();
			AbstractToken t = this;
			while (t != null && tokens.size() <= depth + 1) {
				String s = t.serializeThis();
				if (s != null)
					tokens.add(s);
				t = t.getNext();
			}
			boolean overdepth = tokens.size() > depth;
			if (overdepth)
				tokens.remove(tokens.size() - 1);
			StringBuffer r = new StringBuffer();
			for (int i = 0; i < tokens.size(); i++) {
				r.append(tokens.get(i));
				if (i != tokens.size() - 1)
					r.append(" ");
			}
			boolean overlength = r.length() > length;
			if (overlength)
				r.delete(length + 1, r.length());
			if (appendDots && (overdepth || overlength))
				r.append("...");
			return r.toString();
		}

		public String serializeThis() {
			return null;
		}

		public IInstanceDescription tryConsume() {
			return tryConsumeVal();
		}

		protected abstract IInstanceDescription tryConsumeVal();
	}

	public abstract class ActionToken extends AbstractToken {

		public ActionToken(AbstractToken parent, AbstractToken next, int no,
				IInstanceDescription current) {
			super(parent, next, no, current);
		}
	}

	public abstract class AlternativesToken extends AbstractToken {

		public AlternativesToken(AbstractToken parent, AbstractToken next,
				int no, IInstanceDescription current) {
			super(parent, next, no, current);
		}

		@Override
		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}

	public abstract class AssignmentToken extends AbstractToken {

		protected IInstanceDescription consumed;

		protected AbstractElement element;

		protected AssignmentType type;

		protected Object value;

		public AssignmentToken(AbstractToken parent, AbstractToken next,
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

		@Override
		public String getDiagnostic() {
			Assignment ass = (Assignment) getGrammarElement();
			boolean consumable = current.getConsumable(ass.getFeature(), false) != null;
			if (!consumable) {
				EStructuralFeature f = current.getDelegate().eClass()
						.getEStructuralFeature(ass.getFeature());
				if (f == null)
					return "The current object of type '"
							+ current.getDelegate().eClass().getName()
							+ "' does not have a feature named '"
							+ ass.getFeature() + "'";
				String cls = f.getEContainingClass() == current.getDelegate()
						.eClass() ? f.getEContainingClass().getName() : f
						.getEContainingClass().getName()
						+ "(" + current.getDelegate().eClass().getName() + ")";
				String feat = cls + "." + f.getName();
				if (f.isMany()) {
					int size = ((List<?>) current.getDelegate().eGet(f)).size();
					return "All " + size + " values of " + feat
							+ " have been consumed. "
							+ "More are needed to continue here.";
				} else
					return feat + " is not set.";
			}
			return null;
		}

		@Override
		public String serializeThis() {
			if (type == null)
				return null;
			switch (type) {
				case CR:
					String ref = crossRefSerializer.serializeCrossRef(current.getDelegate(), (CrossReference) element,
							(EObject) value);
					if (ref == null) {
						Assignment ass = GrammarUtil.containingAssignment(element);
						throw new XtextSerializationException("Could not serialize cross reference from "
								+ EmfFormatter.objPath(current.getDelegate()) + "." + ass.getFeature() + " to "
								+ EmfFormatter.objPath((EObject) value));
					}
					return ref;
				case KW:
					return ((Keyword) element).getValue();
				case LRC:
					return converterService.toString(value, ((RuleCall) element).getRule().getName());
				case ERC:
					EnumRule rule = (EnumRule) ((RuleCall) element).getRule();
					if (rule.getAlternatives() instanceof EnumLiteralDeclaration) {
						EnumLiteralDeclaration decl = (EnumLiteralDeclaration) rule.getAlternatives();
						return decl.getLiteral().getValue();
					} else {
						for (AbstractElement element : ((Alternatives) rule.getAlternatives()).getGroups()) {
							EnumLiteralDeclaration decl = (EnumLiteralDeclaration) element;
							if (decl.getEnumLiteral().getInstance().equals(value)) {
								return decl.getLiteral().getValue();
							}
						}
						return null;
					}
				case PRC:
					return null;
				case DRC:
					ParserRule p = (ParserRule) ((RuleCall) element).getRule();
					return converterService.toString(value, p.getName());
				default:
					return null;
			}
		}
	}

	public enum AssignmentType {
		CR, DRC, ERC, KW, LRC, PRC
	}

	public abstract class GroupToken extends AbstractToken {

		public GroupToken(AbstractToken parent, AbstractToken next, int no,
				IInstanceDescription current) {
			super(parent, next, no, current);
		}

		@Override
		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}
	
	public abstract class UnorderedGroupToken extends AbstractToken {

		public UnorderedGroupToken(AbstractToken parent, AbstractToken next, int no,
				IInstanceDescription current) {
			super(parent, next, no, current);
		}

		@Override
		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}

	public abstract class KeywordToken extends AbstractToken {

		public KeywordToken(AbstractToken parent, AbstractToken next, int no,
				IInstanceDescription current) {
			super(parent, next, no, current);
		}

		@Override
		public String serializeThis() {
			return ((Keyword) getGrammarElement()).getValue();
		}

		@Override
		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}

	public class RootToken extends AbstractToken {

		private RootToken(AbstractToken next, IInstanceDescription inst) {
			super(null, next, 0, inst);
		}

		public RootToken(IInstanceDescription inst) {
			super(null, null, 0, inst);
		}

		public boolean containsRuleCall() {
			return true;
		}

		@Override
		public AbstractToken createParentFollower(AbstractToken next,
				int actIndex, int index, IInstanceDescription i) {
			return index != 0 || !i.isConsumed() ? null
					: new RootToken(next, i);
		}

		@Override
		public AbstractElement getGrammarElement() {
			return null;
		}

		@Override
		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}

	public abstract class RuleCallToken extends AbstractToken {

		public RuleCallToken(AbstractToken parent, AbstractToken next, int no,
				IInstanceDescription current) {
			super(parent, next, no, current);
		}
	}

	public abstract class UnassignedTextToken extends AbstractToken {

		public UnassignedTextToken(AbstractToken parent, AbstractToken next,
				int no, IInstanceDescription current) {
			super(parent, next, no, current);
		}

		@Override
		public String serializeThis() {
			return unassTextSerializer.serializeUnassignedRuleCall(
					(RuleCall) getGrammarElement(), current.getDelegate());
		}

		@Override
		protected IInstanceDescription tryConsumeVal() {
			return current;
		}
	}

	@Inject
	protected IValueConverterService converterService;

	@Inject
	protected ICrossReferenceSerializer crossRefSerializer;

	private final Logger log = Logger
			.getLogger(AbstractParseTreeConstructor.class);

	@Inject
	protected ITransientValueService tvService;

	@Inject
	protected IUnassignedTextSerializer unassTextSerializer;

	protected TreeConstructionReportImpl createReport(EObject root) {
		return new TreeConstructionReportImpl(root);
	}

	protected String debug(AbstractToken t, IInstanceDescription i) {
		StringBuffer b = new StringBuffer(t.serialize(10, 50, true));
		b.append(t.getClass().getSimpleName() + ":" + t.getNo() + " -> " + i);
		return b.toString();
	}

	protected final IInstanceDescription getDescr(EObject obj) {
		return new InstanceDescription(tvService, obj);
	}

	public abstract IGrammarAccess getGrammarAccess();

	protected abstract AbstractToken getRootToken(IInstanceDescription inst);

	public TreeConstructionReport serialize(EObject object, ITokenStream out)
			throws IOException {
		TreeConstructionReportImpl rep = createReport(object);
		AbstractToken token = serialize(object, rep);
		while (token != null) {
			String s = token.serializeThis();
			if (s != null && !"".equals(s)) {
				AbstractElement e = token instanceof AssignmentToken ? ((AssignmentToken) token)
						.getAssignmentElement()
						: token.getGrammarElement();
				out.writeSemantic(e, s);
			}
			token = token.getNext();
		}
		out.close();
		return rep;
	}

	private AbstractToken serialize(EObject object,
			TreeConstructionReportImpl rep) {
		if (object == null)
			throw new NullPointerException(
					"The to-be-serialized EObject is null");
		IInstanceDescription inst = getDescr(object);
		AbstractToken f = getRootToken(inst);
		int no = 0;
		boolean lastSucc = true;
		while (f != null) {
			AbstractToken n = null;
			IInstanceDescription i = null;
			if ((n = f.createFollower(no, inst)) != null) {
				while (n != null && (i = n.tryConsume()) == null)
					n = f.createFollower(++no, inst);
			}
			if (n instanceof RootToken && n.getNext() != null)
				return n.getNext();
			if (n != null && i != null) {
				if (log.isTraceEnabled())
					log.trace(debug(f, inst) + " -> found -> "
							+ f.serializeThis());
				f = n;
				inst = i;
				no = 0;
				lastSucc = true;
			} else {
				if (log.isTraceEnabled())
					log
							.trace(debug(f, inst) + " -> fail -> "
									+ (f.getNo() + 1));
				if (lastSucc)
					rep.addDeadEnd(f);
				no = f.getNo() + 1;
				inst = f.getCurrent();
				f = f.getNext();
				lastSucc = false;
			}
		}
		throw new XtextSerializationException(rep, "Serialization failed");
	}
}
