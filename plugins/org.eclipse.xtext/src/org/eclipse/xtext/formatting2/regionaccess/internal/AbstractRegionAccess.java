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
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.debug.TextRegionAccessToString;
import org.eclipse.xtext.formatting2.regionaccess.IHiddenRegion;
import org.eclipse.xtext.formatting2.regionaccess.ILineRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISequentialRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractRegionAccess implements ITextRegionAccess {

	@Override
	public EObject getInvokingGrammarElement(EObject obj) {
		AbstractEObjectRegion tokens = regionForEObject(obj);
		if (tokens == null)
			return null;
		return tokens.getGrammarElement();
	}

	protected abstract String getText();

	@Override
	public TextRegionRewriter getRewriter() {
		return new TextRegionRewriter(this);
	}

	@Override
	public ISemanticRegion immediatelyFollowingKeyword(EObject owner, String keyword) {
		IHiddenRegion trailingHiddenRegion = trailingHiddenRegion(owner);
		if (trailingHiddenRegion == null)
			return null;
		ISemanticRegion lastRegion = trailingHiddenRegion.getPreviousSemanticRegion();
		ISemanticRegion result = immediatelyFollowingKeyword(lastRegion, keyword);
		return result;
	}

	@Override
	public ISemanticRegion immediatelyFollowingKeyword(ISequentialRegion region, String keyword) {
		if (region == null)
			return null;
		ISemanticRegion nextregion = region.getNextSemanticRegion();
		if (nextregion == null)
			return null;
		EObject grammarElement = nextregion.getGrammarElement();
		if (grammarElement instanceof Keyword && ((Keyword) grammarElement).getValue().equals(keyword))
			return nextregion;
		return null;
	}

	@Override
	public ISemanticRegion immediatelyPrecedingKeyword(EObject owner) {
		ISemanticRegion firstRegion = leadingHiddenRegion(owner).getNextSemanticRegion();
		ISemanticRegion result = immediatelyPrecedingKeyword(firstRegion);
		return result;
	}

	@Override
	public ISemanticRegion immediatelyPrecedingKeyword(EObject owner, String keyword) {
		ISemanticRegion firstRegion = leadingHiddenRegion(owner).getNextSemanticRegion();
		ISemanticRegion result = immediatelyPrecedingKeyword(firstRegion, keyword);
		return result;
	}

	@Override
	public ISemanticRegion immediatelyPrecedingKeyword(ISequentialRegion token) {
		if (token == null)
			return null;
		ISemanticRegion previousRegion = token.getPreviousSemanticRegion();
		if (previousRegion == null)
			return null;
		EObject grammarElement = previousRegion.getGrammarElement();
		if (grammarElement instanceof Keyword)
			return previousRegion;
		return null;
	}

	@Override
	public ISemanticRegion immediatelyPrecedingKeyword(ISequentialRegion token, String keyword) {
		if (token == null)
			return null;
		ISemanticRegion previousRegion = token.getPreviousSemanticRegion();
		if (previousRegion == null)
			return null;
		EObject grammarElement = previousRegion.getGrammarElement();
		if (grammarElement instanceof Keyword && ((Keyword) grammarElement).getValue().equals(keyword))
			return previousRegion;
		return null;
	}

	protected Map<? extends EObject, ? extends AbstractEObjectRegion> initMap() {
		return null;
	}

	@Override
	public boolean isMultiline(EObject object) {
		AbstractEObjectRegion tokens = regionForEObject(object);
		if (tokens == null)
			return false;
		ISemanticRegion current = tokens.getLeadingHiddenRegion().getNextSemanticRegion();
		ISemanticRegion last = tokens.getTrailingHiddenRegion().getPreviousSemanticRegion();
		while (current != null) {
			if (current.isMultiline())
				return true;
			if (current == last)
				return false;
			IHiddenRegion next = current.getNextHiddenRegion();
			if (next.isMultiline())
				return true;
			current = current.getNextSemanticRegion();
		}
		return false;
	}

	@Override
	public IHiddenRegion leadingHiddenRegion(EObject owner) {
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return null;
		return tokens.getLeadingHiddenRegion();
	}

	@Override
	public abstract AbstractEObjectRegion regionForEObject(EObject obj);

	@Override
	public ISemanticRegion regionForFeature(EObject owner, EStructuralFeature feat) {
		assertNoContainment(feat);
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return null;
		for (ISemanticRegion region : tokens.getSemanticLeafRegions()) {
			Assignment assignment = GrammarUtil.containingAssignment(region.getGrammarElement());
			if (assignment != null && assignment.getFeature().equals(feat.getName()))
				return region;
		}
		return null;
	}

	@Override
	public ISemanticRegion regionForCrossRef(EObject owner, CrossReference crossRef) {
		return regionForRuleCall(owner, (RuleCall) crossRef.getTerminal());
	}

	@Override
	public List<ISemanticRegion> regionsForCrossRefs(EObject owner, CrossReference... crossRefs) {
		List<RuleCall> rcs = Lists.newArrayList();
		for (int i = 0; i < crossRefs.length; i++)
			rcs.add((RuleCall) crossRefs[i].getTerminal());
		return regionsForRuleCalls(owner, rcs.toArray(new RuleCall[rcs.size()]));
	}

	protected void assertNoContainment(EStructuralFeature feat) {
		if (!(feat instanceof EAttribute) && !(feat instanceof EReference && !((EReference) feat).isContainment()))
			throw new IllegalStateException("Only EAttributes and CrossReferences allowed.");
	}

	@Override
	public List<ISemanticRegion> regionsForFeatures(EObject owner, EStructuralFeature... features) {
		Set<String> names = Sets.newHashSet();
		for (int i = 0; i < features.length; i++) {
			EStructuralFeature feat = features[i];
			assertNoContainment(feat);
			names.add(feat.getName());
		}
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return Collections.emptyList();
		List<ISemanticRegion> result = Lists.newArrayList();
		for (ISemanticRegion region : tokens.getSemanticLeafRegions()) {
			Assignment assignment = GrammarUtil.containingAssignment(region.getGrammarElement());
			if (assignment != null && names.contains(assignment.getFeature()))
				result.add(region);
		}
		return ImmutableList.copyOf(result);
	}

	@Override
	public ISemanticRegion regionForKeyword(EObject owner, String keyword) {
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return null;
		for (ISemanticRegion region : tokens.getSemanticLeafRegions()) {
			EObject element = region.getGrammarElement();
			if (element instanceof Keyword) {
				Keyword kw = (Keyword) element;
				if (kw.getValue().equals(keyword))
					return region;
			}
		}
		return null;
	}

	@Override
	public ISemanticRegion regionForKeyword(EObject owner, Keyword keyword) {
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return null;
		for (ISemanticRegion region : tokens.getSemanticLeafRegions())
			if (region.getGrammarElement() == keyword)
				return region;
		return null;
	}

	@Override
	public ISemanticRegion regionForRuleCall(EObject owner, RuleCall ruleCall) {
		assertNoEObjectRuleCall(ruleCall);
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return null;
		for (ISemanticRegion region : tokens.getSemanticLeafRegions())
			if (region.getGrammarElement() == ruleCall)
				return region;
		return null;
	}

	@Override
	public List<ISemanticRegion> regionsForRuleCalls(EObject owner, RuleCall... ruleCalls) {
		for (int i = 0; i < ruleCalls.length; i++)
			assertNoEObjectRuleCall(ruleCalls[i]);
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return Collections.emptyList();
		List<ISemanticRegion> result = Lists.newArrayList();
		for (ISemanticRegion region : tokens.getSemanticLeafRegions())
			for (int i = 0; i < ruleCalls.length; i++)
				if (region.getGrammarElement() == ruleCalls[i])
					result.add(region);
		return ImmutableList.copyOf(result);
	}

	protected void assertNoEObjectRuleCall(RuleCall ruleCall) {
		if (GrammarUtil.isEObjectRuleCall(ruleCall))
			throw new IllegalStateException("Only Enum, Datatype and Terminal Rule Calls allowed.");
	}

	@Override
	public ITextSegment regionForOffset(int offset, int length) {
		return new TextSegment(this, offset, length);
	}

	@Override
	public ISemanticRegion regionForRuleCallTo(EObject owner, AbstractRule rule) {
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return null;
		for (ISemanticRegion token : tokens.getSemanticLeafRegions()) {
			EObject element = token.getGrammarElement();
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
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return Collections.emptyList();
		Collection<String> kwSet = keywords.length <= 1 ? Arrays.asList(keywords) : Sets.newHashSet(keywords);
		List<ISemanticRegion> result = Lists.newArrayList();
		for (ISemanticRegion token : tokens.getSemanticLeafRegions())
			if (token.getGrammarElement() instanceof Keyword) {
				Keyword kw = (Keyword) token.getGrammarElement();
				if (kwSet.contains(kw.getValue()))
					result.add(token);
			}
		return ImmutableList.copyOf(result);
	}

	@Override
	public List<ISemanticRegion> regionsForKeywords(EObject owner, Keyword... keywords) {
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return Collections.emptyList();
		List<ISemanticRegion> result = Lists.newArrayList();
		for (ISemanticRegion region : tokens.getSemanticLeafRegions())
			for (int i = 0; i < keywords.length; i++)
				if (region.getGrammarElement() == keywords[i])
					result.add(region);
		return ImmutableList.copyOf(result);
	}

	@Override
	public List<ISemanticRegion> regionsForRuleCallsTo(EObject owner, AbstractRule... rule) {
		HashSet<AbstractRule> set = Sets.newHashSet(rule);
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return Collections.emptyList();
		List<ISemanticRegion> result = Lists.newArrayList();
		for (ISemanticRegion region : tokens.getSemanticLeafRegions()) {
			EObject element = region.getGrammarElement();
			if (element instanceof RuleCall) {
				RuleCall rc = (RuleCall) element;
				if (set.contains(rc.getRule()))
					result.add(region);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return new TextRegionAccessToString().withRegionAccess(this).toString();
	}

	@Override
	public IHiddenRegion trailingHiddenRegion(EObject owner) {
		AbstractEObjectRegion tokens = regionForEObject(owner);
		if (tokens == null)
			return null;
		return tokens.getTrailingHiddenRegion();
	}

	@Override
	public ILineRegion lineForOffset(int offset) {
		String text = getText();
		if (offset < 0 || offset > text.length())
			return null;
		int start = text.lastIndexOf('\n', offset) + 1;
		if (start < 0)
			start = 0;
		int end = text.indexOf('\n', offset);
		if (end > 0) {
			if (text.charAt(end - 1) == '\r')
				end = end - 1;
		} else
			end = text.length();
		return new LineRegion(this, start, end - start);
	}

	@Override
	public List<ILineRegion> expandToLines(ITextSegment segment, int leadingLinesToAdd, int trailingLinesToAdd) {
		List<ILineRegion> lines = Lists.newArrayList(segment.getLineRegions());
		for (int i = 1; i < leadingLinesToAdd; i++) {
			ILineRegion line = lines.get(0).getPreviousLine();
			if (line != null)
				lines.add(0, line);
		}
		for (int i = 1; i < trailingLinesToAdd; i++) {
			ILineRegion line = lines.get(lines.size() - 1).getNextLine();
			if (line != null)
				lines.add(line);
		}
		return lines;
	}

}
