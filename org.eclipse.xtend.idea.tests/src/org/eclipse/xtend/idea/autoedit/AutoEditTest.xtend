/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtend.core.idea.lang.XtendFileType

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class AutoEditTest extends AbstractCStyleLanguageAutoEditTest {
	
	new() {
		super(XtendFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXtendLibrary
	}

	override testSingleQuotedStringLiteral_15() {
//		super.testSingleQuotedStringLiteral_15()
	}

	def void testCurlyBraceBlockAndRichStrings_0() {
		configureByText("\n{|\n'''«{null}»'''}")
		myFixture.type('\n')
		assertState("\n{\n\t|\n'''«{null}»'''}")
	}

	def void testIndentationEdit_1() {
		configureByText("   '|'")
		myFixture.type('\n')
		assertState("   '\n   |'")
	}

	def void testIndentationEdit_2() {
		configureByText("  |")
		myFixture.type('\n')
		assertState("  \n  |")
	}

	def void testIndentationEdit_3() {
		configureByText("  '''\n  |\n'''")
		myFixture.type('\n')
		assertState("  '''\n  \n  |\n'''")
	}

	def void testCurlyBracesBlockInRichString_1() {
		configureByText("'''|'''")
		myFixture.type('{')
		assertState("'''{|'''")
		myFixture.type('\n')
		assertState("'''{\n\t|\n}'''")
		myFixture.type('\n')
		assertState("'''{\n\t\n\t|\n}'''")
	}

	def void testCurlyBracesBlockInRichString_2() {
		configureByText("'''{|\n}'''")
		myFixture.type('\n')
		assertState("'''{\n\t|\n}'''")
	}

	def void testCurlyBracesBlockInRichString_3() {
		configureByText("'''|'''")
		myFixture.type('}')
		assertState("'''}|'''")
	}

	def void testCurlyBracesBlockInRichString_4() {
		configureByText("'''foo {|'''")
		myFixture.type('\n')
		assertState("'''foo {\n\t|\n}'''")
	}

	def void testCurlyBracesBlockInRichString_5() {
		configureByText("'''{|}'''")
		myFixture.type('\n')
		assertState("'''{\n\t|\n}'''")
	}

	def void testCurlyBracesBlockInRichString_6() {
		configureByText("'''{| }'''")
		myFixture.type('\n')
		assertState("'''{\n\t|\n}'''")
	}

	def void testCurlyBracesBlockInRichString_7() {
		configureByText("'''{ |foo }'''")
		myFixture.type('\n')
		assertState("'''{ \n\t|foo\n}'''")
	}

	def void testCurlyBracesBlockInRichString_8() {
		configureByText("'''{ foo| }'''")
		myFixture.type('\n')
		assertState("'''{ foo\n |}'''")
	}

	def void testCurlyBracesBlockInRichString_9() {
		configureByText("'''\"{\" foo| }'''")
		myFixture.type('\n')
		assertState("'''\"{\" foo\n |}'''")
	}

	def void testCurlyBracesBlockInRichString_10() {
		configureByText("'''/*{*/ foo|'''")
		myFixture.type('\n')
		assertState("'''/*{*/ foo\n|'''")
	}

	def void testCurlyBracesBlockInRichString_11() {
		configureByText("'''{|}'''")
		myFixture.type('\n')
		assertState("'''{\n\t|\n}'''")
	}

	def void testCurlyBracesBlockInRichString_12() {
		configureByText("'''{foo|}'''")
		myFixture.type('\n')
		assertState("'''{foo\n|}'''")
	}

	def void testCurlyBracesBlockInRichString_13() {
		configureByText("'''{foo|bar}'''")
		myFixture.type('\n')
		assertState("'''{foo\n|bar}'''")
	}

	def void testCurlyBracesBlockInRichString_14() {
		configureByText("'''{\nfoo|bar}'''")
		myFixture.type('\n')
		assertState("'''{\nfoo\n|bar}'''")
	}

	def void testCurlyBracesBlockInRichString_15() {
		configureByText("'''{\nfoo}|{bar}'''")
		myFixture.type('\n')
		assertState("'''{\nfoo}\n|{bar}'''")
	}

	def void testCurlyBracesBlockInRichString_16() {
		configureByText("'''{\n|}'''")
		myFixture.type('\n')
		assertState("'''{\n\n|}'''")
	}

	def void testCurlyBracesBlockInRichString_17() {
		configureByText("'''{\n|'''")
		myFixture.type('\n')
		assertState("'''{\n\n|\n}'''")
	}

	def void testCurlyBracesBlockInRichString_18() {
		configureByText("'''{{foo}|{bar}}'''")
		myFixture.type('\n')
		assertState("'''{{foo}\n|{bar}}'''")
	}

	def void testRichStringLiteral_01() {
		configureByText("''|")
		myFixture.type("'")
		assertState("'''|'''")
		myFixture.type("'")
		assertState("''''|''")
		myFixture.type("'")
		assertState("'''''|'")
		myFixture.type("'")
		assertState("''''''|")
	}

	def void testRichStringLiteral_02() {
		configureByText("'''|'''")
		myFixture.type('\n')
		assertState("'''\n|'''")
	}

	def void testRichStringLiteral_03() {
		configureByText("  '''|'''")
		myFixture.type('\n')
		assertState("  '''\n  |'''")
	}

	def void testRichStringLiteral_04() {
		configureByText("'''|'''")
		myFixture.type('"')
		assertState("'''\"|\"'''")
	}

	def void testRichStringLiteral_05() {
		configureByText("'''|'''")
		myFixture.type('«')
		assertState("'''«|»'''")
	}

	def void testRichStringLiteral_06() {
		configureByText("'''«foobar|»'''")
		myFixture.type('»')
		assertState("'''«foobar»|'''")
	}

	def void testRichStringLiteral_07() {
		configureByText("'''«|»'''")
		myFixture.type(BS)
		assertState("'''|'''")
	}

	def void testRichStringLiteral_08() {
		configureByText("''' foobar |'''")
		myFixture.type("'")
		assertState("''' foobar '|''")
		myFixture.type("'")
		assertState("''' foobar ''|'")
		myFixture.type("'")
		assertState("''' foobar '''|")
	}

	def void testRichStringLiteral_09() {
		configureByText("''' |«foobar» '''")
		myFixture.type('«')
		assertState("''' «|»«foobar» '''")
		myFixture.type('a')
		assertState("''' «a|»«foobar» '''")
		myFixture.type('»')
		assertState("''' «a»|«foobar» '''")
	}

	def void testRichStringLiteral_10() {
		configureByText("''' «foobar» |'''")
		myFixture.type("'")
		assertState("''' «foobar» '|''")
		myFixture.type("'")
		assertState("''' «foobar» ''|'")
		myFixture.type("'")
		assertState("''' «foobar» '''|")
	}

	def void testRichStringLiteral_11() {
		configureByText("''' text ''|")
		myFixture.type("'")
		assertState("''' text '''|")
	}
	
	override testSingleQuotedStringLiteral_3() {
		configureByText("|'")
		myFixture.type("'")
		assertState("'|'")
		myFixture.type("'")
		assertState("''|")
		myFixture.type("'")
		assertState("'''|'''")
	}

//	def void testBug434717_01() {
//		configureByText(
//				"genPlainText(Object this){\n" + 
//				"		'''\n" + 
//				"		|\n" +
//				"		'''\n" + 
//				"}\n" + 
//				"")
//		pasteText(
//				"foo\n" +
//				"\tbar\n"
//				+ "foo")
//
//		assertState(
//				"genPlainText(Object this){\n" + 
//				"		'''\n" + 
//				"		foo\n" +
//				"			bar\n" +
//				"		foo|\n" +
//				"		'''\n" + 
//				"}\n" + 
//				"")
//	}
//	
//	def void testBug434717_02() {
//		configureByText(
//				"genPlainText(Object this){\n" + 
//				"		'''\n" + 
//				"		|\n" +
//				"		'''\n" + 
//				"}\n" + 
//				"")
//		pasteText(
//				"\tfoo\n" +
//				"\t\tbar\n"
//				+ "\tfoo")
//
//		assertState(
//				"genPlainText(Object this){\n" + 
//				"		'''\n" + 
//				"			foo\n" +
//				"				bar\n" +
//				"			foo|\n" +
//				"		'''\n" + 
//				"}\n" + 
//				"")
//	}
//	
//	def void testBug434717_03() {
//		configureByText(
//				"genPlainText(Object this){\n" + 
//				"		'''|'''\n" + 
//				"}\n" + 
//				"")
//		pasteText(
//				"\tfoo\n" +
//				"\t\tbar\n"
//				+ "\tfoo")
//
//		assertState(
//				"genPlainText(Object this){\n" + 
//				"		'''	foo\n" +
//				"				bar\n" +
//				"			foo|'''\n" + 
//				"}\n" + 
//				"")
//	}
//	
//	def void testBug434717_04() {
//		configureByText(
//				"genPlainText(Object this){\n" + 
//				"		'''|'''" + 
//				"")
//		pasteText(
//				"\tfoo\n" +
//				"\t\tbar\n"
//				+ "\tfoo")
//
//		assertState(
//				"genPlainText(Object this){\n" + 
//				"		'''	foo\n" +
//				"				bar\n" +
//				"			foo|'''" + 
//				"")
//	}
//	
//	def void testBug434717_05() {
//		configureByText(
//				"genPlainText(Object this){\n" + 
//				"		'''|'''" + 
//				"")
//		pasteText(
//				"\tfoo\r" +
//				"\t\tbar\r"
//				+ "\tfoo")
//
//		assertState(
//				"genPlainText(Object this){\n" + 
//				"		'''	foo\n" +
//				"				bar\n" +
//				"			foo|'''" + 
//				"")
//	}
//	
//	def void testBug434717_06() {
//		configureByText(
//				"genPlainText(Object this){\n" + 
//				"		'''|'''" + 
//				"")
//		pasteText(
//				"\tfoo\r" +
//				"\t\tbar\r\n"
//				+ "\tfoo")
//
//		assertState(
//				"genPlainText(Object this){\n" + 
//				"		'''	foo\n" +
//				"				bar\n" +
//				"			foo|'''" + 
//				"")
//	}
//	
//	def void testBug342030_01() {
//		configureByText(
//				"genPlainText(Object this){\n" + 
//				"    '''|'''\n" + 
//				"}\n" + 
//				"")
//		pasteText("foo.bar")
//
//		assertState("genPlainText(Object this){\n" + 
//				"    '''foo.bar|'''\n" + 
//				"}\n" + 
//				"")
//	}
//	
//	def void testBug342030_02() {
//		configureByText(
//				"genPlainText(Object this){\n" + 
//				"    '''|'''\n" + 
//				"}\n" + 
//				"")
//		pasteText("'''")
//
//		assertState("genPlainText(Object this){\n" + 
//				"    ''''''|'''\n" + 
//				"}\n" + 
//				"")
//	}
//
//	def void testBug342030_03() {
//		configureByText(
//				"genPlainText(Object this){\n" + 
//				"    '''|'''\n" + 
//				"}\n" + 
//				"")
//		pasteText("'''")
//
//		assertState("genPlainText(Object this){\n" + 
//				"    ''''''|\n" + 
//				"}\n" + 
//				"")
//	}

}
