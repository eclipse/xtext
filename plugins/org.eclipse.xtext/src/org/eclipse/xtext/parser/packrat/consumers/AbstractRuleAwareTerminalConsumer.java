/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractRuleAwareTerminalConsumer extends TerminalConsumer {
	
	private AbstractRule rule;
	
	protected AbstractRuleAwareTerminalConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}
	
	public final AbstractRule getGrammarElement() {
		if (rule == null) {
			rule = doGetRule();
		}
		return rule;
	}
	
	@Override
	protected String getRuleName() {
		return getGrammarElement().getName();
	}
	
	protected abstract AbstractRule doGetRule();
	
	@Override
	public String toString() {
		return super.toString() + " for rule " + getGrammarElement().getName();
	}
	
}