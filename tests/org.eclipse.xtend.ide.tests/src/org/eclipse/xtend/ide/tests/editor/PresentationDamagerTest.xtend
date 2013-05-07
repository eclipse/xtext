package org.eclipse.xtend.ide.tests.editor

import org.eclipse.xtext.junit4.ui.AbstractDamagerRepairerTest
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer
import org.junit.Test

class PresentationDamagerTest extends AbstractDamagerRepairerTest {
	
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
		assertEquals(5, 15, check("text ''rich\ntext'''", 5, 0, "'"))
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
		assertEquals(5, 16, check("text 'string\ntext'text", 5, 1, ""))
	}
	
	@Test
	def void testString_1() {
		assertEquals(5, 16, check("text string\ntext'text", 5, 1, "'"))
	}
	
	@Test
	def void testString_2() {
		assertEquals(5, 25, check("text string\ntext'text''string", 5, 0, "'"))
	}
	
	@Test 
	def void testOverlapingMultilineTokens() {
		assertEquals(4, 37, check("text/* comment\ncomment' */\n'string'text", 14, 0, "*/"))
	}
	
}