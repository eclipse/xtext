/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

/**
 * @author Eva Poell - Initial contribution and API
 */
class XtendConditionalExpressionFormatterTest extends AbstractXtendFormatterTest {
	
	@Test
	def formatIfElseCondExpSL1() {
		assertFormattedExpression('''
				c = (a < b) ? 3 : 4
			''',
			'''
				c = (a < b) ? 3 : 4
			''')
	}
	
	@Test
	def formatIfElseCondExpSL2() {
		assertFormattedExpression('''
				c = (a < b) ? 3 : 4
			''',
			'''
				c =(a<b)?3:4
			''')
	}
	
	@Test
	def formatIfElseCondExpSL3() {
		assertFormattedExpression('''
				c = (a < b) ? (b < d) ? 5 : (b < d) ? 7 : 8
			''',
			'''
				c =(a<b)?(b<d)?5:(b<d)?7:8
			''')
	}
	
	@Test
	def formatIfElseCondExpML() {
		assertFormattedExpression('''
				c = (a < b)
					? 3
					: 4
			''',
			'''
				c=(a<b)?
					3:
					4
			''')
	}
}