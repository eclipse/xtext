/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatter.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.xtext.formatter.ITokenAccess;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTokenAccess extends AbstractRegion implements ITokenAccess {

	public static abstract class Builder {
		protected abstract Map<EObject, EObjectTokens> getEObjectToTokensMap(ITokenAccess tokenAccess);

		protected abstract XtextResource getXtextResource();
	}

	protected abstract static class EObjectTokens {
		private IGap leadingGap;
		private final List<IToken> tokens = Lists.newArrayList();
		private IGap trailingGap;

		public EObjectTokens() {
			super();
		}

		public abstract AbstractElement getGrammarElement();

		public IGap getLeadingGap() {
			return leadingGap;
		}

		public abstract EObject getSemanticElement();

		public List<IToken> getTokens() {
			return tokens;
		}

		public IGap getTrailingGap() {
			return trailingGap;
		}

		protected void setLeadingGap(IGap leadingGap) {
			this.leadingGap = leadingGap;
		}

		protected void setTrailingGap(IGap trailingGap) {
			this.trailingGap = trailingGap;
		}
	}

	private final Map<EObject, EObjectTokens> eObjectToTokens;
	private final XtextResource resource;

	protected AbstractTokenAccess(Builder builder) {
		this.resource = builder.getXtextResource();
		this.eObjectToTokens = ImmutableMap.copyOf(builder.getEObjectToTokensMap(this));
	}

	protected IToken getAnyToken() {
		for (EObjectTokens tokens : eObjectToTokens.values())
			for (IToken token : tokens.getTokens())
				return token;
		return null;
	}

	public AbstractElement getInvokingGrammarElement(EObject obj) {
		EObjectTokens tokens = eObjectToTokens.get(obj);
		if (tokens == null)
			return null;
		return tokens.getGrammarElement();
	}

	public int getOffset() {
		return 0;
	}

	public XtextResource getResource() {
		return resource;
	}

	@Override
	public abstract String getText();

	public String getText(int offset, int length) {
		return resource.getParseResult().getRootNode().getText().substring(offset, offset + length);
	}

	public ITokenAccess getTokenAccess() {
		return this;
	}

	public IToken immediatelyPrecedingKeyword(EObject owner) {
		IToken firstToken = leadingGap(owner).getNextToken();
		IToken result = immediatelyPrecedingKeyword(firstToken);
		return result;
	}

	public IToken immediatelyPrecedingKeyword(IToken token) {
		if (token == null)
			return null;
		IToken previousToken = token.getPreviousToken();
		if (previousToken == null)
			return null;
		AbstractElement grammarElement = previousToken.getGrammarElement();
		if (grammarElement instanceof Keyword)
			return previousToken;
		return null;
	}

	public IToken immediatelyPrecedingKeyword(EObject owner, String keyword) {
		IToken firstToken = leadingGap(owner).getNextToken();
		IToken result = immediatelyPrecedingKeyword(firstToken, keyword);
		return result;
	}

	public IToken immediatelyPrecedingKeyword(IToken token, String keyword) {
		if (token == null)
			return null;
		IToken previousToken = token.getPreviousToken();
		if (previousToken == null)
			return null;
		AbstractElement grammarElement = previousToken.getGrammarElement();
		if (grammarElement instanceof Keyword && ((Keyword) grammarElement).getValue().equals(keyword))
			return previousToken;
		return null;
	}

	public IToken immediatelyFollowingKeyword(EObject owner, String keyword) {
		IToken lastToken = trailingGap(owner).getPreviousToken();
		IToken result = immediatelyFollowingKeyword(lastToken, keyword);
		return result;
	}

	public IToken immediatelyFollowingKeyword(IToken token, String keyword) {
		if (token == null)
			return null;
		IToken nextToken = token.getNextToken();
		if (nextToken == null)
			return null;
		AbstractElement grammarElement = nextToken.getGrammarElement();
		if (grammarElement instanceof Keyword && ((Keyword) grammarElement).getValue().equals(keyword))
			return nextToken;
		return null;
	}

	protected Map<? extends EObject, ? extends EObjectTokens> initMap() {
		return null;
	}

	public boolean isMultiline(EObject object) {
		EObjectTokens tokens = eObjectToTokens.get(object);
		if (tokens == null)
			return false;
		IToken current = tokens.getLeadingGap().getNextToken();
		IToken last = tokens.getTrailingGap().getPreviousToken();
		while (current != null) {
			if (current.isMultiline())
				return true;
			if (current == last)
				return false;
			IGap gap = current.getTrailingGap();
			if (gap.isMultiline())
				return true;
			current = current.getNextToken();
		}
		return false;
	}

	public IGap leadingGap(EObject owner) {
		EObjectTokens tokens = eObjectToTokens.get(owner);
		if (tokens == null)
			return null;
		return tokens.getLeadingGap();
	}

	public IToken tokenForFeature(EObject owner, EStructuralFeature feat) {
		if (!(feat instanceof EAttribute) && !(feat instanceof EReference && !((EReference) feat).isContainment()))
			throw new IllegalStateException("Only EAttributes and CrossReferences allowed.");
		EObjectTokens tokens = eObjectToTokens.get(owner);
		if (tokens == null)
			return null;
		for (IToken token : tokens.getTokens()) {
			Assignment assignment = GrammarUtil.containingAssignment(token.getGrammarElement());
			if (assignment != null && assignment.getFeature().equals(feat.getName()))
				return token;
		}
		return null;
	}

	public IToken tokenForKeyword(EObject owner, String keyword) {
		EObjectTokens tokens = eObjectToTokens.get(owner);
		if (tokens == null)
			return null;
		for (IToken token : tokens.getTokens()) {
			AbstractElement element = token.getGrammarElement();
			if (element instanceof Keyword) {
				Keyword kw = (Keyword) element;
				if (kw.getValue().equals(keyword))
					return token;
			}
		}
		return null;
	}

	public List<IToken> tokensForRuleCallsTo(EObject owner, AbstractRule... rule) {
		HashSet<AbstractRule> set = Sets.newHashSet(rule);
		EObjectTokens tokens = eObjectToTokens.get(owner);
		if (tokens == null)
			return Collections.emptyList();
		List<IToken> result = Lists.newArrayList();
		for (IToken token : tokens.getTokens()) {
			AbstractElement element = token.getGrammarElement();
			if (element instanceof RuleCall) {
				RuleCall rc = (RuleCall) element;
				if (set.contains(rc.getRule()))
					result.add(token);
			}
		}
		return result;
	}

	public IToken tokenForRuleCallTo(EObject owner, AbstractRule rule) {
		EObjectTokens tokens = eObjectToTokens.get(owner);
		if (tokens == null)
			return null;
		for (IToken token : tokens.getTokens()) {
			AbstractElement element = token.getGrammarElement();
			if (element instanceof RuleCall) {
				RuleCall rc = (RuleCall) element;
				if (rc.getRule() == rule)
					return token;
			}
		}
		return null;
	}

	public List<IToken> tokensForKeywords(EObject owner, String... keywords) {
		EObjectTokens tokens = eObjectToTokens.get(owner);
		if (tokens == null)
			return null;
		Set<String> set = Sets.newHashSet(keywords);
		List<IToken> result = Lists.newArrayList();
		for (IToken token : tokens.getTokens())
			if (token.getGrammarElement() instanceof Keyword) {
				Keyword kw = (Keyword) token.getGrammarElement();
				if (set.contains(kw.getValue()))
					result.add(token);
			}
		return result;
	}

	@Override
	public String toString() {
		IToken token = getAnyToken();
		if (token != null)
			return new TokenToString().withOrigin(token).toString();
		return "(empty)";
	}

	public IGap trailingGap(EObject owner) {
		EObjectTokens tokens = eObjectToTokens.get(owner);
		if (tokens == null)
			return null;
		return tokens.getTrailingGap();
	}

}
