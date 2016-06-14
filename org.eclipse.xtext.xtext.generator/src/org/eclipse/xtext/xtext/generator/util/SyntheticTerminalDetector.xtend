/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.util

import org.eclipse.xtext.Keyword
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil

/** 
 * Helper to identify synthetic terminal rules.
 * This implementation answers <code>true</code> for any terminal rule that has a body in the form
 * <code>terminal MY_TERMINAL: 'synthetic:MY_TERMINAL';</code>.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SyntheticTerminalDetector {
	
	/** 
	 * Answers {@code true} if the given terminal rule is synthetic. That is,
	 * the tokens for this rule will not be produced by the generated Antlr lexer
	 * but manually in a custom token source.
	 */
	def boolean isSyntheticTerminalRule(TerminalRule rule) {
		if (rule.alternatives instanceof Keyword) {
			var String value = (rule.alternatives as Keyword).value
			return 'synthetic:' + AntlrGrammarGenUtil.getOriginalElement(rule).name == value
		}
		return false
	}
	
}
