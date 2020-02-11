/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
