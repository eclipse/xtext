/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IAfterElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBeforeElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBetweenElements;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;

import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MatcherState extends AbstractNFAState<MatcherState, MatcherTransition> {

	protected Set<IBetweenElements> afterBetweenElements;

	protected Set<IAfterElement> afterPatterns;

	protected Set<IBetweenElements> beforeBetweenElements;

	protected Set<IBeforeElement> beforePatterns;

	public MatcherState(AbstractElement element, NFABuilder<MatcherState, MatcherTransition> builder) {
		super(element, builder);
	}

	public Set<IBetweenElements> getAfterBetweenElements() {
		if (afterBetweenElements == null)
			afterBetweenElements = Sets.newHashSet();
		return afterBetweenElements;
	}

	public Set<IAfterElement> getAfterPatterns() {
		if (afterPatterns == null)
			afterPatterns = Sets.newHashSet();
		return afterPatterns;
	}

	public Set<IBetweenElements> getBeforeBetweenElements() {
		if (beforeBetweenElements == null)
			beforeBetweenElements = Sets.newHashSet();
		return beforeBetweenElements;
	}

	public Set<IBeforeElement> getBeforePatterns() {
		if (beforePatterns == null)
			beforePatterns = Sets.newHashSet();
		return beforePatterns;
	}

}
