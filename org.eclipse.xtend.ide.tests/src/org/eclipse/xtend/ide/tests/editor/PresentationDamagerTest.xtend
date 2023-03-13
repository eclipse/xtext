/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.jface.text.Document
import org.eclipse.xtend.core.parser.antlr.XtendAntlrTokenFileProvider
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
import org.eclipse.xtend.ide.editor.model.XtendDocumentTokenSource
import org.eclipse.xtend.ide.tests.RuntimeInjectorProvider
import org.eclipse.xtext.ui.testing.AbstractDamagerRepairerTest
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class PresentationDamagerTest extends AbstractDamagerRepairerTest {
	
	@Inject
	FlexerFactory flexerFactory
	
	override protected createLexer() {
		new InternalXtendLexer()
	}
	
	@Test
	def void testRichString_0() {
		assertEquals(5, 14, check("text '''rich\ntext'''", 6, 1, ""))
	}
	
	@Test
	def void testRichString_1() {
		assertEquals(5, 14, check("text '''rich\ntext'''", 7, 1, ""))
	}

	@Test
	def void testRichString_2() {
		assertEquals(4, 16, check("text ''rich\ntext'''", 5, 0, "'"))
	}
	
	@Test
	def void testRichString_3() {
		assertEquals(5, 15, check("text ''rich\ntext'''", 6, 0, "'"))
	}
	
	@Test
	def void testRichString_4() {
		assertEquals(0, 19, check("'''rich\ntext''' text", 14, 1, ""))
	}
	
	@Test
	def void testRichString_5() {
		assertEquals(0, 19, check("'''rich\ntext''' text", 13, 1, ""))
	}
	
	@Test
	def void testRichString_6() {
		assertEquals(0, 20, check("'''rich\ntext'' text", 14, 0, "'"))
	}
	
	@Test
	def void testRichString_7() {
		assertEquals(0, 20, check("'''rich\ntext'' text", 13, 0, "'"))
	}
	
	@Test
	def void testRichString_8() {
		assertEquals(5, 20, check("text '''rich\ntext''' text", 11, 1, "«text»"))
	}
	
	@Test
	def void testRichString_9() {
		assertEquals(4, 20, check("text'''rich\ntext''' text", 10, 1, "«text»"))
	}
	
	@Test
	def void testString_0() {
		assertEquals(4, 17, check("text 'string\ntext'text", 5, 1, ""))
	}
	
	@Test
	def void testString_1() {
		assertEquals(4, 17, check("text string\ntext'text", 5, 1, "'"))
	}
	
	@Test
	def void testString_2() {
		assertEquals(4, 26, check("text string\ntext'text''string", 5, 0, "'"))
	}
	
	@Test 
	def void testOverlapingMultilineTokens() {
		assertEquals(4, 37, check("text/* comment\ncomment' */\n'string'text", 14, 0, "*/"))
	}
	
	override Document createDocument(String before) throws Exception {
		val source = new XtendDocumentTokenSource => [
			tokenDefProvider = new AntlrTokenDefProvider => [
				antlrTokenFileProvider = new XtendAntlrTokenFileProvider
			]
			lexer = [|createLexer]
			it.flexerFactory = this.flexerFactory
		]
		val document = new XtextDocument(source, null, outdatedStateManager, operationCanceledManager)
		document.set(before)
		document
	}
}