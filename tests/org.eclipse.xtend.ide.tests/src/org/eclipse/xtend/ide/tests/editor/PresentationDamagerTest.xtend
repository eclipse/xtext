package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.jface.text.Document
import org.eclipse.xtend.core.parser.antlr.XtendAntlrTokenFileProvider
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtend.ide.editor.model.XtendDocumentTokenSource
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.ui.AbstractDamagerRepairerTest
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider
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
		val document = new XtextDocument(source, null)
		document.set(before)
		document
	}
}