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
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementPattern;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFATransition;

import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MatcherTransition extends AbstractNFATransition<MatcherState, MatcherTransition> {

	protected Set<IElementPattern> patterns;

	public MatcherTransition(MatcherState source, MatcherState target, boolean ruleCall, AbstractElement loopCenter) {
		super(source, target, ruleCall, loopCenter);
	}

	public Set<IElementPattern> getPatterns() {
		if (patterns == null)
			patterns = Sets.newHashSet();
		return patterns;
	}

}
