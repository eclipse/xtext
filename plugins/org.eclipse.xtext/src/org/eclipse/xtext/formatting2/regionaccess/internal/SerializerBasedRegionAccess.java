/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.LinkedList;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerBasedRegionAccess extends AbstractRegionAccess {

	public static class Builder implements ISequenceAcceptor {
		private final LinkedList<AbstractEObjectTokens> stack = new LinkedList<AbstractEObjectTokens>();
		private SerializedHiddenRegion last;
		private SerializerBasedRegionAccess regionAccess;
		private int nextOffset;

		public Builder withRoot(EObject root) {
			this.nextOffset = 0;
			this.regionAccess = new SerializerBasedRegionAccess((XtextResource) root.eResource());
			this.regionAccess.firstRegion = this.last = new SerializedHiddenRegion(regionAccess);
			enterEObject(null, root);
			return this;
		}

		public SerializerBasedRegionAccess getRegionAccess() {
			return regionAccess;
		}

		@Override
		public void enterUnassignedParserRuleCall(RuleCall rc) {
			// not relevant
		}

		@Override
		public void leaveUnssignedParserRuleCall(RuleCall rc) {
			// not relevant
		}

		@Override
		public void acceptUnassignedAction(Action action) {
			// not relevant

		}

		@Override
		public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
			appendSemantic(datatypeRC, token);
		}

		private void appendSemantic(AbstractElement grammarElement, String token) {
			AbstractEObjectTokens tokens = stack.peek();
			EObject obj = tokens == null ? null : tokens.getSemanticElement();
			SerializedSemanticRegion semantic = new SerializedSemanticRegion(regionAccess, obj, grammarElement,
					nextOffset, token);
			nextOffset += token.length();
			last.setNext(semantic);
			semantic.setLeadingGap(last);
			last = new SerializedHiddenRegion(regionAccess);
			last.setPrevious(semantic);
			semantic.setTrailingGap(last);
			if (tokens != null) {
				tokens.getTokens().add(semantic);
				tokens.setTrailingGap(last);
			}
		}

		@Override
		public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
			appendSemantic(enumRC, token);
		}

		@Override
		public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
			appendSemantic(keyword, token);
		}

		@Override
		public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
			appendSemantic(terminalRC, token);
		}

		@Override
		public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index,
				ICompositeNode node) {
			appendSemantic(datatypeRC, token);
		}

		@Override
		public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index,
				ICompositeNode node) {
			appendSemantic(enumRC, token);
		}

		@Override
		public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
				ILeafNode node) {
			appendSemantic(terminalRC, token);
		}

		@Override
		public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
			appendSemantic(kw, token);
		}

		@Override
		public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index,
				ICompositeNode node) {
			appendSemantic(datatypeRC, token);
		}

		@Override
		public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
			appendSemantic(enumRC, token);
		}

		@Override
		public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
			appendSemantic(keyword, token);
		}

		@Override
		public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
			appendSemantic(terminalRC, token);
		}

		@Override
		public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
			enterEObject(action, semanticChild);
			return true;
		}

		protected void enterEObject(AbstractElement ele, EObject semanticChild) {
			//			System.out.println("enter: " + Thread.currentThread().getStackTrace()[2].toString());
			SerializedEObjectTokens tokens = new SerializedEObjectTokens(regionAccess, ele, semanticChild);
			regionAccess.eObjectToTokens.put(semanticChild, tokens);
			tokens.setLeadingGap(last);
			tokens.setTrailingGap(last);
			stack.push(tokens);
		}

		@Override
		public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
			enterEObject(rc, semanticChild);
			return true;
		}

		@Override
		public void finish() {
		}

		@Override
		public void leaveAssignedAction(Action action, EObject semanticChild) {
			leaveEObject();
		}

		private void leaveEObject() {
			//			System.out.println("leave: " + Thread.currentThread().getStackTrace()[2].toString());
			AbstractEObjectTokens popped = stack.pop();
			AbstractEObjectTokens peek = stack.peek();
			if (peek != null)
				peek.setTrailingGap(popped.getTrailingGap());
		}

		@Override
		public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
			leaveEObject();
		}

		@Override
		public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
			last.setUndefined(false);
			last.hiddens.add(new SerializedComment(last, rule, nextOffset, token));
			nextOffset += token.length();
		}

		@Override
		public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
			last.setUndefined(false);
			if (!Strings.isEmpty(token)) {
				last.hiddens.add(new SerializedWhitespace(last, rule, nextOffset, token));
				nextOffset += token.length();
			}
		}

	}

	private final Map<EObject, AbstractEObjectTokens> eObjectToTokens = Maps.newLinkedHashMap();
	private IHiddenRegion firstRegion;
	private final XtextResource resource;

	protected SerializerBasedRegionAccess(XtextResource resource) {
		this.resource = resource;
	}

	@Override
	public ITextSegment expandRegionsByLines(int leadingLines, int trailingLines, ITextSegment... regions) {
		return null;
	}

	@Override
	public boolean hasSyntaxError() {
		return false;
	}

	@Override
	public boolean hasSyntaxError(EObject object) {
		return false;
	}

	@Override
	public ITextSegment indentationRegion(int offset) {
		return null;
	}

	@Override
	public int getLength() {
		return 0;
	}

	@Override
	public String getText() {
		return null;
	}

	@Override
	public IHiddenRegion getFirstRegionInFile() {
		return firstRegion;
	}

	@Override
	public XtextResource getResource() {
		return resource;
	}

	@Override
	public String getText(int offset, int length) {
		return null;
	}

	@Override
	protected AbstractEObjectTokens getTokens(EObject obj) {
		return eObjectToTokens.get(obj);
	}

}
