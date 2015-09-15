/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.parser

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.psi.tree.TokenSet
import org.eclipse.xtext.idea.parser.TokenTypeProvider
import org.eclipse.xtext.parser.antlr.ITokenDefProvider
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping

/**
 * @author kosyakov - Initial contribution and API
 */
@ImplementedBy(DefaultOperatorTokenTypeProvider)
interface OperatorTokenTypeProvider {

	def TokenSet getOperatorTokens()

}

@Singleton
class DefaultOperatorTokenTypeProvider implements OperatorTokenTypeProvider {

	static val char SINGLE_QUOTE = "'"

	val TokenSet operatorTokens

	@Inject
	new(OperatorMapping operatorMapping, TokenTypeProvider tokenTypeProvider, ITokenDefProvider tokenDefProvider) {
		val tokenTypes = newHashSet
		val operators = operatorMapping.operators.map[toString].toSet
		val tokenDefMap = tokenDefProvider.tokenDefMap
		for (antlrTokenType : tokenDefMap.keySet) {
			val value = tokenDefMap.get(antlrTokenType)
			if (value.charAt(0) == SINGLE_QUOTE) {
				val keyword = value.substring(1, value.length - 1)
				if (operators.exists[contains(keyword)])
					tokenTypes += tokenTypeProvider.getIElementType(antlrTokenType)
			}
		}
		operatorTokens = TokenSet.create(tokenTypes)
	}

	override getOperatorTokens() {
		operatorTokens
	}

}