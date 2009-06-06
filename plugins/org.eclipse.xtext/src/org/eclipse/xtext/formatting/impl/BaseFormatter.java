/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.TerminalRule;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class BaseFormatter extends AbstractFormatter {
	
	@Inject
	protected IGrammarAccess grammar;

	protected TerminalRule getWSRule() {
		// FIXME: make this configurable
		return (TerminalRule) GrammarUtil.findRuleForName(grammar.getGrammar(),
				"WS");
	}

}
