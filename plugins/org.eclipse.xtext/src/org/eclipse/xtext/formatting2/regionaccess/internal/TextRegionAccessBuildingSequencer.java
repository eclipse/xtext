/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.util.Strings;

public class TextRegionAccessBuildingSequencer implements ISequenceAcceptor {
	private StringHiddenRegion last;
	private StringBasedRegionAccess regionAccess;
	private final LinkedList<AbstractEObjectTokens> stack = new LinkedList<AbstractEObjectTokens>();

	@Override
	public void acceptAssignedCrossRefDatatype(RuleCall rc, String token, EObject value, int index, ICompositeNode node) {
		appendSemantic(rc, token);
	}

	@Override
	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		appendSemantic(enumRC, token);
	}

	@Override
	public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
		appendSemantic(kw, token);
	}

	@Override
	public void acceptAssignedCrossRefTerminal(RuleCall rc, String token, EObject value, int index, ILeafNode node) {
		appendSemantic(rc, token);
	}

	@Override
	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
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
	public void acceptComment(AbstractRule rule, String token, ILeafNode node) {
		int offset = regionAccess.append(token);
		last.setUndefined(false);
		last.addPart(createComment(rule, token, offset));
	}

	@Override
	public void acceptUnassignedAction(Action action) {
		// not relevant
	}

	@Override
	public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
		appendSemantic(datatypeRC, token);
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
	public void acceptWhitespace(AbstractRule rule, String token, ILeafNode node) {
		last.setUndefined(false);
		if (!Strings.isEmpty(token)) {
			int offset = regionAccess.append(token);
			last.addPart(createWhitespace(rule, token, offset));
		}
	}

	private void appendSemantic(AbstractElement element, String token) {
		AbstractEObjectTokens tokens = stack.peek();
		EObject obj = tokens == null ? null : tokens.getSemanticElement();
		int offset = regionAccess.append(token);
		StringSemanticRegion semantic = createSemanticRegion(element, token, obj, offset);
		last.setNext(semantic);
		semantic.setLeadingGap(last);
		last = createHiddenRegion();
		last.setPrevious(semantic);
		semantic.setTrailingGap(last);
		if (tokens != null) {
			tokens.getTokens().add(semantic);
			tokens.setTrailingGap(last);
		}
	}

	protected StringComment createComment(AbstractRule rule, String token, int offset) {
		return new StringComment(last, rule, offset, token.length());
	}

	protected StringHiddenRegion createHiddenRegion() {
		return new StringHiddenRegion(regionAccess);
	}

	protected StringSemanticRegion createSemanticRegion(AbstractElement element, String token, EObject obj, int offset) {
		return new StringSemanticRegion(regionAccess, obj, element, offset, token.length());
	}

	protected StringWhitespace createWhitespace(AbstractRule rule, String token, int offset) {
		return new StringWhitespace(last, rule, offset, token.length());
	}

	@Override
	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		enterEObject(action, semanticChild);
		return true;
	}

	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		enterEObject(rc, semanticChild);
		return true;
	}

	protected StringEObjectTokens enterEObject(AbstractElement ele, EObject semanticChild) {
		StringEObjectTokens tokens = new StringEObjectTokens(regionAccess, ele, semanticChild);
		regionAccess.add(tokens);
		tokens.setLeadingGap(last);
		tokens.setTrailingGap(last);
		stack.push(tokens);
		return tokens;
	}

	@Override
	public void enterUnassignedParserRuleCall(RuleCall rc) {
		// not relevant
	}

	@Override
	public void finish() {
	}

	public StringBasedRegionAccess getRegionAccess() {
		return regionAccess;
	}

	@Override
	public void leaveAssignedAction(Action action, EObject semanticChild) {
		leaveEObject();
	}

	@Override
	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		leaveEObject();
	}

	private void leaveEObject() {
		AbstractEObjectTokens popped = stack.pop();
		AbstractEObjectTokens peek = stack.peek();
		if (peek != null)
			peek.setTrailingGap(popped.getTrailingGap());
	}

	@Override
	public void leaveUnssignedParserRuleCall(RuleCall rc) {
		// not relevant
	}

	public TextRegionAccessBuildingSequencer withRoot(EObject root) {
		this.regionAccess = new StringBasedRegionAccess((XtextResource) root.eResource());
		this.last = createHiddenRegion();
		this.regionAccess.setRootEObject(enterEObject(null, root));
		return this;
	}

}