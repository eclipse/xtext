/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementPattern;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFATransition;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MatcherTransition extends AbstractNFATransition<MatcherState, MatcherTransition> {

	protected Set<IElementPattern> commonPatterns;

	protected Map<MatcherState, Set<IElementPattern>> guardedPatterns;

	public MatcherTransition(MatcherState source, MatcherState target, boolean ruleCall, AbstractElement loopCenter) {
		super(source, target, ruleCall, loopCenter);
	}

	public void addPattern(IElementPattern pattern) {
		if (commonPatterns == null)
			commonPatterns = Sets.newHashSet();
		commonPatterns.add(pattern);
	}

	public void addPattern(MatcherState guard, IElementPattern pattern) {
		if (guardedPatterns == null)
			guardedPatterns = Maps.newHashMap();
		Set<IElementPattern> patterns = guardedPatterns.get(guard);
		if (patterns == null)
			guardedPatterns.put(guard, patterns = Sets.<IElementPattern> newHashSet());
		patterns.add(pattern);
	}

	public Set<IElementPattern> getCommonPatterns() {
		return commonPatterns == null ? Collections.<IElementPattern> emptySet() : commonPatterns;
	}

	public Map<MatcherState, Set<IElementPattern>> getGuardPatterns() {
		return guardedPatterns == null ? Collections.<MatcherState, Set<IElementPattern>> emptyMap() : guardedPatterns;
	}

	public List<IElementPattern> getPatterns(Collection<MatcherState> from) {
		if (guardedPatterns == null && commonPatterns == null)
			return Collections.<IElementPattern> emptyList();
		List<IElementPattern> result = Lists.newArrayList();
		if (commonPatterns != null)
			result.addAll(commonPatterns);
		if (guardedPatterns != null)
			for (MatcherState state : from) {
				Set<IElementPattern> guard = guardedPatterns.get(state);
				if (guard != null)
					result.addAll(guard);
			}
		return result;
	}

}
