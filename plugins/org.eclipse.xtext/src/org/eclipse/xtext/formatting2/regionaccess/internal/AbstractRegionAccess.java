/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.formatting2.debug.TokenAccessToString;
import org.eclipse.xtext.formatting2.internal.AbstractTextSegment;
import org.eclipse.xtext.formatting2.internal.TextSegment;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractRegionAccess extends AbstractTextSegment implements ITextRegionAccess {

	@Override
	public AbstractElement getInvokingGrammarElement(EObject obj) {
		AbstractEObjectTokens tokens = getTokens(obj);
		if (tokens == null)
			return null;
		return tokens.getGrammarElement();
	}

	@Override
	public int getOffset() {
		return 0;
	}

	@Override
	public ITextRegionAccess getTextRegionAccess() {
		return this;
	}

	protected abstract AbstractEObjectTokens getTokens(EObject obj);

	@Override
	public ISemanticRegion immediatelyFollowingKeyword(EObject owner, String keyword) {
		IHiddenRegion trailingHiddenRegion = trailingHiddenRegion(owner);
		if (trailingHiddenRegion == null)
			return null;
		ISemanticRegion lastToken = trailingHiddenRegion.getPreviousSemanticRegion();
		ISemanticRegion result = immediatelyFollowingKeyword(lastToken, keyword);
		return result;
	}

	@Override
	public ISemanticRegion immediatelyFollowingKeyword(ISequentialRegion token, String keyword) {
		if (token == null)
			return null;
		ISemanticRegion nextToken = token.getNextSemanticRegion();
		if (nextToken == null)
			return null;
		AbstractElement grammarElement = nextToken.getGrammarElement();
		if (grammarElement instanceof Keyword && ((Keyword) grammarElement).getValue().equals(keyword))
			return nextToken;
		return null;
	}

	@Override
	public ISemanticRegion immediatelyPrecedingKeyword(EObject owner) {
		ISemanticRegion firstToken = leadingHiddenRegion(owner).getNextSemanticRegion();
		ISemanticRegion result = immediatelyPrecedingKeyword(firstToken);
		return result;
	}

	@Override
	public ISemanticRegion immediatelyPrecedingKeyword(EObject owner, String keyword) {
		ISemanticRegion firstToken = leadingHiddenRegion(owner).getNextSemanticRegion();
		ISemanticRegion result = immediatelyPrecedingKeyword(firstToken, keyword);
		return result;
	}

	@Override
	public ISemanticRegion immediatelyPrecedingKeyword(ISequentialRegion token) {
		if (token == null)
			return null;
		ISemanticRegion previousToken = token.getPreviousSemanticRegion();
		if (previousToken == null)
			return null;
		AbstractElement grammarElement = previousToken.getGrammarElement();
		if (grammarElement instanceof Keyword)
			return previousToken;
		return null;
	}

	@Override
	public ISemanticRegion immediatelyPrecedingKeyword(ISequentialRegion token, String keyword) {
		if (token == null)
			return null;
		ISemanticRegion previousToken = token.getPreviousSemanticRegion();
		if (previousToken == null)
			return null;
		AbstractElement grammarElement = previousToken.getGrammarElement();
		if (grammarElement instanceof Keyword && ((Keyword) grammarElement).getValue().equals(keyword))
			return previousToken;
		return null;
	}

	protected Map<? extends EObject, ? extends AbstractEObjectTokens> initMap() {
		return null;
	}

	@Override
	public boolean isMultiline(EObject object) {
		AbstractEObjectTokens tokens = getTokens(object);
		if (tokens == null)
			return false;
		ISemanticRegion current = tokens.getLeadingGap().getNextSemanticRegion();
		ISemanticRegion last = tokens.getTrailingGap().getPreviousSemanticRegion();
		while (current != null) {
			if (current.isMultiline())
				return true;
			if (current == last)
				return false;
			IHiddenRegion gap = current.getNextHiddenRegion();
			if (gap.isMultiline())
				return true;
			current = current.getNextSemanticRegion();
		}
		return false;
	}

	@Override
	public IHiddenRegion leadingHiddenRegion(EObject owner) {
		AbstractEObjectTokens tokens = getTokens(owner);
		if (tokens == null)
			return null;
		return tokens.getLeadingGap();
	}

	@Override
	public ITextSegment regionForEObject(EObject object) {
		AbstractEObjectTokens tokens = getTokens(object);
		int offset = tokens.leadingGap.getEndOffset();
		int endOffset = tokens.trailingGap.getOffset();
		return new TextSegment(this, offset, endOffset - offset);
	}

	@Override
	public ISemanticRegion regionForFeature(EObject owner, EStructuralFeature feat) {
		if (!(feat instanceof EAttribute) && !(feat instanceof EReference && !((EReference) feat).isContainment()))
			throw new IllegalStateException("Only EAttributes and CrossReferences allowed.");
		AbstractEObjectTokens tokens = getTokens(owner);
		if (tokens == null)
			return null;
		for (ISemanticRegion token : tokens.getTokens()) {
			Assignment assignment = GrammarUtil.containingAssignment(token.getGrammarElement());
			if (assignment != null && assignment.getFeature().equals(feat.getName()))
				return token;
		}
		return null;
	}

	@Override
	public ISemanticRegion regionForKeyword(EObject owner, String keyword) {
		AbstractEObjectTokens tokens = getTokens(owner);
		if (tokens == null)
			return null;
		for (ISemanticRegion token : tokens.getTokens()) {
			AbstractElement element = token.getGrammarElement();
			if (element instanceof Keyword) {
				Keyword kw = (Keyword) element;
				if (kw.getValue().equals(keyword))
					return token;
			}
		}
		return null;
	}

	@Override
	public ISemanticRegion regionForRuleCallTo(EObject owner, AbstractRule rule) {
		AbstractEObjectTokens tokens = getTokens(owner);
		if (tokens == null)
			return null;
		for (ISemanticRegion token : tokens.getTokens()) {
			AbstractElement element = token.getGrammarElement();
			if (element instanceof RuleCall) {
				RuleCall rc = (RuleCall) element;
				if (rc.getRule() == rule)
					return token;
			}
		}
		return null;
	}

	@Override
	public List<ISemanticRegion> regionsForKeywords(EObject owner, String... keywords) {
		AbstractEObjectTokens tokens = getTokens(owner);
		if (tokens == null)
			return Collections.emptyList();
		Collection<String> kwSet = keywords.length <= 1 ? Arrays.asList(keywords) : Sets.newHashSet(keywords);
		List<ISemanticRegion> result = Lists.newArrayList();
		for (ISemanticRegion token : tokens.getTokens())
			if (token.getGrammarElement() instanceof Keyword) {
				Keyword kw = (Keyword) token.getGrammarElement();
				if (kwSet.contains(kw.getValue()))
					result.add(token);
			}
		return result;
	}

	@Override
	public List<ISemanticRegion> regionsForRuleCallsTo(EObject owner, AbstractRule... rule) {
		HashSet<AbstractRule> set = Sets.newHashSet(rule);
		AbstractEObjectTokens tokens = getTokens(owner);
		if (tokens == null)
			return Collections.emptyList();
		List<ISemanticRegion> result = Lists.newArrayList();
		for (ISemanticRegion token : tokens.getTokens()) {
			AbstractElement element = token.getGrammarElement();
			if (element instanceof RuleCall) {
				RuleCall rc = (RuleCall) element;
				if (set.contains(rc.getRule()))
					result.add(token);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return new TokenAccessToString().withOrigin(this).toString();
	}

	@Override
	public IHiddenRegion trailingHiddenRegion(EObject owner) {
		AbstractEObjectTokens tokens = getTokens(owner);
		if (tokens == null)
			return null;
		return tokens.getTrailingGap();
	}

}
