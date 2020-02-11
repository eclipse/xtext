/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.util

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil

class GrammarUtil2 extends GrammarUtil {
	
	public static val TERMINALS = 'org.eclipse.xtext.common.Terminals'
	
	static def boolean inherits(Grammar grammar, String languageID) {
		if (grammar.name == languageID)
			return true
		for (grammar2 : grammar.usedGrammars) {
			if (grammar2.inherits(languageID)) {
				return true
			}
		}
		return false
	}
	
	static def Grammar getNonTerminalsSuperGrammar(Grammar grammar) {
		grammar.usedGrammars.findFirst[name != TERMINALS]
	}
	
}
