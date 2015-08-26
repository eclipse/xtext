/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.util

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil

// TODO move this to GrammarUtil?
class GrammarUtil2 extends GrammarUtil {
	
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
		grammar.usedGrammars.findFirst[name != 'org.eclipse.xtext.common.Terminals']
	}
	
}
