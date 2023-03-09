/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.util;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;

import com.google.common.base.Objects;

public class GrammarUtil2 extends GrammarUtil {
	public static final String TERMINALS = "org.eclipse.xtext.common.Terminals";

	public static boolean inherits(Grammar grammar, String languageID) {
		if (Objects.equal(grammar.getName(), languageID)) {
			return true;
		}
		for (Grammar g : grammar.getUsedGrammars()) {
			if (GrammarUtil2.inherits(g, languageID)) {
				return true;
			}
		}
		return false;
	}

	public static Grammar getNonTerminalsSuperGrammar(Grammar grammar) {
		for (Grammar g : grammar.getUsedGrammars()) {
			if (!TERMINALS.equals(g.getName())) {
				return g;
			}
		}
		return null;
	}
}
