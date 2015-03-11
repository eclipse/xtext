/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.generator.parser.antlr.AntlrGrammarGenUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class TokenNames {

	@Inject
	extension GrammarAccess

	def dispatch List<String> getTokens(Grammar it, Set<String> known) {
		val tokens = newArrayList
		for (rule : allParserRules + allEnumRules) {
			val ruleTokens = rule.getTokens(known)
			tokens += ruleTokens
		}
		tokens
	}

	def dispatch List<String> getTokens(AbstractRule it, Set<String> known) {
		alternatives.getTokens(known)
	}

	def dispatch List<String> getTokens(EObject it, Set<String> known) {
		eContents.map [
			getTokens(known)
		].flatten.toList
	}

	protected def dispatch List<String> getTokens(Keyword it, Set<String> known) {
		if (!known.contains(value) && known.add(value)) {
			newArrayList('''KW_«value.toJavaIdentifier(true)» = '«value.toAntlrString»'«»''')
		} else {
			emptyList
		}
	}

}
