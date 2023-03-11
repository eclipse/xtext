/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.parser

import com.google.inject.Inject
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*

/**
 * @author Christian Schneider - Initial contribution and API
 */
class XtendAntlrGrammarGeneratorHelper {
	
	@Inject
	extension GrammarAccessExtensions

	def String compileTokens(Grammar it, AntlrOptions options) '''
		
		tokens {
			«FOR token : it.tokens»
				KW_«token.toJavaIdentifier(true)» = '«token.toAntlrString»' ;
			«ENDFOR»
		}
	'''	

	def getTokens(Grammar it) {
		val tokens = newLinkedHashSet()
		
		for (rule : allParserRules + allEnumRules) {
			rule.collectTokens(tokens)
		}
		return tokens
	}

	def dispatch void collectTokens(Keyword it, Set<String> tokens) {
		if (!tokens.contains(value)) {
			tokens += value;
		}
	}

	def dispatch void collectTokens(AbstractRule it, Set<String> tokens) {
		alternatives.collectTokens(tokens)
	}

	def dispatch void collectTokens(EObject it, Set<String> tokens) {
		eContents.forEach [
			collectTokens(tokens)
		]
	}

}