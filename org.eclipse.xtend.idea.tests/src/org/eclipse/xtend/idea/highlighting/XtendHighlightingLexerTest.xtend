/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.highlighting

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtend.core.idea.highlighting.XtendHighlightingLexer
import org.eclipse.xtend.idea.LightXtendTest

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendHighlightingLexerTest extends LightXtendTest {

	@Inject
	Provider<XtendHighlightingLexer> lexerProvider

	def void testStart_01() {
		val lexer = lexerProvider.get
		lexer.start('package mypackage')
		assertEquals(0, lexer.tokenStart)

		lexer.advance
		assertNotSame(0, lexer.tokenStart)

		lexer.start('package mypackage')
		assertEquals(0, lexer.tokenStart)
	}

	def void testStart_02() {
		val lexer = lexerProvider.get
		lexer.start("''' «» '''")
		assertEquals(0, lexer.tokenStart)

		lexer.advance
		assertNotSame(0, lexer.tokenStart)

		lexer.start("''' «» '''")
		assertEquals(0, lexer.tokenStart)
	}

}