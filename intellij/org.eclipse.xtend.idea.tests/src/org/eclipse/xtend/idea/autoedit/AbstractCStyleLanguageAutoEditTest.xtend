/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

import com.intellij.openapi.fileTypes.LanguageFileType
import org.eclipse.xtext.idea.tests.AbstractAutoEditTest

/**
 * @author kosyakov - Initial contribution and API
 */
abstract class AbstractCStyleLanguageAutoEditTest extends AbstractAutoEditTest {

	protected static val BS = '\b'

	new(LanguageFileType fileType) {
		super(fileType)
	}

	def void testParenthesis_1() {
		configureByText("|")
		myFixture.type('(')
		assertState("(|)")
		myFixture.type('(')
		assertState("((|))")
		myFixture.type(BS)
		assertState("(|)")
		myFixture.type(BS)
		assertState("|")
	}

	def void testParenthesis_2() {
		configureByText("|")
		myFixture.type('(')
		assertState("(|)")
		myFixture.type(')')
		assertState("()|")
		myFixture.type(BS)
		assertState("(|")
		myFixture.type(BS)
		assertState("|")
	}

	def void testParenthesis_3() {
		configureByText("|")
		myFixture.type('(')
		assertState("(|)")
		myFixture.type(BS)
		assertState("|")
	}

	def void testParenthesis_4() {
		configureByText("|foobar")
		myFixture.type('(')
		assertState("(|foobar")
	}

	def void testParenthesis_5() {
		configureByText("|")
		myFixture.type(')')
		assertState(")|")
		myFixture.type(')')
		assertState("))|")
		myFixture.type(BS)
		assertState(")|")
		myFixture.type(BS)
		assertState("|")
	}

	def void testParenthesis_6() {
		configureByText("(|\n)")
		myFixture.type(')')
		assertState("()|\n)")
		myFixture.type(BS)
		assertState("(|\n)")
	}

	def void testParenthesis_7() {
		configureByText("(((|)")
		myFixture.type(')')
		assertState("((()|)")
		myFixture.type(')')
		assertState("((())|)")
		myFixture.type(')')
		assertState("((()))|")
	}

	def void testParenthesis_8() {
		configureByText("(foobar|)")
		myFixture.type(')')
		assertState("(foobar)|")
	}

	def void testParenthesis_9() {
		configureByText("|'')")
		myFixture.type('(')
		assertState("(|'')")
	}

	def void testParenthesis_10() {
		configureByText("(|'')")
		myFixture.type('(')
		assertState("((|'')")
	}

	def void testSingleQuotedStringLiteral_1() {
		configureByText("|")
		myFixture.type("'")
		assertState("'|'")
		myFixture.type(BS)
		assertState("|")
	}

	def void testSingleQuotedStringLiteral_2() {
		configureByText("|")
		myFixture.type("'")
		assertState("'|'")
		myFixture.type("'")
		assertState("''|")
		myFixture.type(BS)
		assertState("'|")
	}

	def void testSingleQuotedStringLiteral_3() {
		configureByText("|'")
		myFixture.type("'")
		assertState("'|'")
		myFixture.type("'")
		assertState("''|")
		myFixture.type("'")
		assertState("'''|'")
	}

	def void testSingleQuotedStringLiteral_4() {
		configureByText("|foo")
		myFixture.type("'")
		assertState("'|foo")
		myFixture.type("'")
		assertState("''|foo")
	}

	def void testSingleQuotedStringLiteral_5() {
		configureByText("|foo")
		myFixture.type("'")
		assertState("'|foo")
		myFixture.type("'")
		assertState("''|foo")
		myFixture.type(BS)
		assertState("'|foo")
		myFixture.type(BS)
		assertState("|foo")
	}

	def void testSingleQuotedStringLiteral_6() {
		configureByText("'| '")
		myFixture.type("'")
		assertState("''| '")
		myFixture.type(BS)
		assertState("'| '")
	}

	def void testSingleQuotedStringLiteral_7() {
		configureByText("'' '| '")
		myFixture.type("'")
		assertState("'' ''| '")
		myFixture.type(BS)
		assertState("'' '| '")
	}

	def void testSingleQuotedStringLiteral_8() {
		configureByText("'| ' ' '")
		myFixture.type("'")
		assertState("''| ' ' '")
		myFixture.type(BS)
		assertState("'| ' ' '")
	}

	def void testSingleQuotedStringLiteral_9() {
		configureByText("foo|{}")
		selectText(-3, 3)
		myFixture.type("'")
		assertState("'|'{}")
		myFixture.type(BS)
		assertState("|{}")
	}

	def void testSingleQuotedStringLiteral_10() {
		configureByText("foo|{}")
		selectText(-2, 2)
		myFixture.type("'")
		assertState("f'|'{}")
		myFixture.type(BS)
		assertState("f|{}")
	}

	def void testSingleQuotedStringLiteral_11() {
		configureByText("|foo{}")
		selectText(0, 2)
		myFixture.type("'")
		assertState("'|o{}")
	}

	def void testSingleQuotedStringLiteral_12() {
		configureByText("|foo{}")
		selectText(0, 1)
		myFixture.type("'")
		assertState("'|oo{}")
	}

	def void testSingleQuotedStringLiteral_13() {
		configureByText("'a|")
		myFixture.type("'")
		assertState("'a'|")
	}

	def void testSingleQuotedStringLiteral_14() {
		configureByText("|'test'")
		myFixture.type("'")
		assertState("'|''test'")
	}

	def void testSingleQuotedStringLiteral_15() {
		configureByText("'|''test'")
		myFixture.type("'")
		assertState("''|'test'")
		myFixture.type("'")
		assertState("'''|''test'")
	}

	def void testDoubleQuotedStringLiteral_1() {
		configureByText("|")
		myFixture.type('"')
		assertState('"|"')
		myFixture.type(BS)
		assertState("|")
	}

	def void testDoubleQuotedStringLiteral_2() {
		configureByText("|")
		myFixture.type('"')
		assertState('"|"')
		myFixture.type('"')
		assertState('""|')
		myFixture.type(BS)
		assertState('"|')
	}

	def void testDoubleQuotedStringLiteral_3() {
		configureByText('|"')
		myFixture.type('"')
		assertState('"|"')
		myFixture.type('"')
		assertState('""|')
		myFixture.type('"')
		assertState('"""|"')
	}

	def void testDoubleQuotedStringLiteral_4() {
		configureByText('|foo')
		myFixture.type('"')
		assertState('"|foo')
		myFixture.type('"')
		assertState('""|foo')
	}

	def void testDoubleQuotedStringLiteral_5() {
		configureByText('|foo')
		myFixture.type('"')
		assertState('"|foo')
		myFixture.type('"')
		assertState('""|foo')
		myFixture.type(BS)
		assertState('"|foo')
		myFixture.type(BS)
		assertState('|foo')
	}

	def void testDoubleQuotedStringLiteral_6() {
		configureByText('"| "')
		myFixture.type('"')
		assertState('""| "')
		myFixture.type(BS)
		assertState('"| "')
	}

	def void testDoubleQuotedStringLiteral_7() {
		configureByText('"" "| "')
		myFixture.type('"')
		assertState('"" ""| "')
		myFixture.type(BS)
		assertState('"" "| "')
	}

	def void testDoubleQuotedStringLiteral_8() {
		configureByText('"| " " "')
		myFixture.type('"')
		assertState('""| " " "')
		myFixture.type(BS)
		assertState('"| " " "')
	}

	def void testDoubleQuotedStringLiteral_9() {
		configureByText('"a|')
		myFixture.type('"')
		assertState('"a"|')
	}

	def void testDoubleQuotedStringLiteral_10() {
		configureByText('|"test"')
		myFixture.type('"')
		assertState('"|""test"')
	}

	def void testCurlyBracesBlock_1() {
		configureByText('|')
		myFixture.type('{')
		assertState('{|}')
		myFixture.type('\n')
		assertState('{\n\t|\n}')
		myFixture.type('\n')
		assertState('{\n\t\n\t|\n}')
	}

	def void testCurlyBracesBlock_2() {
		configureByText('{|\n}')
		myFixture.type('\n')
		assertState("{\n\t|\n}")
	}

	def void testCurlyBracesBlock_3() {
		configureByText('|')
		myFixture.type('}')
		assertState("}|")
	}

	def void testCurlyBracesBlock_4() {
		configureByText('foo {|')
		myFixture.type('\n')
		assertState("foo {\n\t|\n}")
	}

	def void testCurlyBracesBlock_5() {
		configureByText('{|}')
		myFixture.type('\n')
		assertState("{\n\t|\n}")
	}

	def void testCurlyBracesBlock_6() {
		configureByText('{| }')
		myFixture.type('\n')
		assertState("{\n\t|\n}")
	}

	def void testCurlyBracesBlock_7() {
		configureByText('{ |foo }')
		myFixture.type('\n')
		assertState("{ \n\t|foo }")
	}

	def void testCurlyBracesBlock_8() {
		configureByText('{ foo| }')
		myFixture.type('\n')
		assertState("{ foo\n|}")
	}

	def void testCurlyBracesBlock_9() {
		configureByText("'{' foo| }")
		myFixture.type('\n')
		assertState("'{' foo\n|}")
	}

	def void testCurlyBracesBlock_10() {
		configureByText('/*{*/ foo|')
		myFixture.type('\n')
		assertState('/*{*/ foo\n|\n */')
	}

	def void testCurlyBracesBlock_11() {
		configureByText('{|}')
		myFixture.type('\n')
		assertState('{\n\t|\n}')
	}

	def void testCurlyBracesBlock_12() {
		configureByText('{foo|}')
		myFixture.type('\n')
		assertState('{foo\n|}')
	}

	def void testCurlyBracesBlock_13() {
		configureByText('{foo|bar}')
		myFixture.type('\n')
		assertState('{foo\n\t|bar}')
	}

	def void testCurlyBracesBlock_14() {
		configureByText('{\nfoo|bar}')
		myFixture.type('\n')
		// TODO assertState('{\nfoo\n\t|bar}')
		assertState('{\nfoo\n|bar}')
	}

	def void testCurlyBracesBlock_15() {
		configureByText('{\nfoo}|{bar}')
		myFixture.type('\n')
		assertState('{\nfoo}\n|{bar}')
	}

	def void testCurlyBracesBlock_16() {
		configureByText('{\n|}')
		myFixture.type('\n')
		assertState('{\n\n|}')
	}

	def void testCurlyBracesBlock_17() {
		configureByText('{\n|')
		myFixture.type('\n')
		assertState('{\n\n\t|')
	}

	def void testCurlyBracesBlock_18() {
		configureByText('{{foo}|{bar}}')
		myFixture.type('\n')
		assertState('{{foo}\n\t|{bar}}')
	}

	def void testCurlyBracesBlock_19() {
		configureByText('{{|')
		myFixture.type('\n')
		assertState('{{\n\t|\n}}')
		myFixture.type('\n')
		assertState('{{\n\t\n\t|\n}}')
	}

	def void testCurlyBracesWithSelection_1() {
		configureByText("{|foo}")
		selectText(0, 3)
		myFixture.type('{')
		assertState("{{|}}")
		myFixture.type(BS)
		assertState("{|}")
	}

	def void testCurlyBracesWithSelection_2() {
		configureByText("{|foo}")
		selectText(0, 2)
		myFixture.type('{')
		assertState("{{|o}")
		myFixture.type(BS)
		assertState("{|o}")
	}

	def void testCurlyBracesWithSelection_3() {
		configureByText("{|foo}")
		selectText(0, 1)
		myFixture.type('{')
		assertState("{{|oo}")
		myFixture.type(BS)
		assertState("{|oo}")
	}

	def void testCurlyBracesWithSelection_4() {
		configureByText("{{|foo}}")
		selectText(0, 3)
		myFixture.type('}')
		assertState("{{}|}")
		myFixture.type(BS)
		assertState("{{|}")
	}

	def void testCurlyBracesWithSelection_5() {
		configureByText("{{|foo}}")
		selectText(0, 2)
		myFixture.type('}')
		assertState("{{}|o}}")
		myFixture.type(BS)
		assertState("{{|o}}")
		myFixture.type('{')
		assertState("{{{|o}}")
	}

	/** 
	 * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=472623">Ignored because of 472623</a>
	 */ 
	def void ignore_testMLComments_01() {
		configureByText("|")
		myFixture.type('/')
		myFixture.type('*')
		assertState("/*|")

		myFixture.type('\n')
		assertState("/*\n|\n */")
	}

	def void testMLComments_01() {
		configureByText("/*\n * |\n */")
		myFixture.type('\n')
		assertState("/*\n * \n * |\n */")

		myFixture.type('foo bar')
		myFixture.type('\n')
		assertState("/*\n * \n * foo bar\n * |\n */")
	}

	/** 
	 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=472623">Ignored because of 472623</a>
	 */ 
	def void ignore_testMLComments_02() {
		configureByText("   |")
		myFixture.type('/')
		myFixture.type('*')
		assertState("   /*|")

		myFixture.type('\n')
		assertState("   /*\n   |\n    */")
	}

	def void testMLComments_02() {
		configureByText("   /*\n    * |\n    */")
		myFixture.type('\n')
		assertState("   /*\n    * \n    * |\n    */")

		myFixture.type('foo bar')
		myFixture.type('\n')
		assertState("   /*\n    * \n    * foo bar\n    * |\n    */")
	}

	def void testMLComments_03() {
		configureByText("/*\n *| */")

		myFixture.type('\n')
		assertState("/*\n *\n  * | */")
	}

	def void testMLComments_04() {
		configureByText("\t/*\n\t *|\n\t */")

		myFixture.type('\n')
		assertState("\t/*\n\t *\n\t * |\n\t */")
	}

	def void testMLComments_05() {
		configureByText("foo /*\n     *|\n      */")

		myFixture.type('\n')
		assertState("foo /*\n     *\n     * |\n      */")
	}

	def void testMLComments_07() {
		configureByText("/* */|")

		myFixture.type('\n')
		assertState("/* */\n|")
	}

	def void testMLComments_08() {
		configureByText("  /* foo | */")

		myFixture.type('\n')
		assertState("  /* foo \n   * | */")
	}

	def void testMLComments_09() {
		configureByText("/* foo |*/")

		myFixture.type('\n')
		assertState("/* foo \n* |*/")
	}

	def void testMLComments_10() {
		configureByText("   /* foo |*/")

		myFixture.type('\n')
		assertState("   /* foo \n   * |*/")
	}

	def void testMLComments_11() {
		configureByText("/* */\n * |")

		myFixture.type('\n')
		assertState("/* */\n * \n|")
	}

	def void testMLComments_12() {
		configureByText("foo /*| */")

		myFixture.type('\n')
		assertState("foo /*\n |*/")
	}

	def void testMLComments_13() {
		configureByText("/* foo| */")

		myFixture.type('\n')
		assertState("/* foo\n * | */")
	}

	def void testMLComments_14() {
		configureByText("/* foo|*/")

		myFixture.type('\n')
		assertState("/* foo\n* |*/")
	}

	def void testMLComments_15() {
		configureByText("  /* foo| */")

		myFixture.type('\n')
		assertState("  /* foo\n   * | */")
	}

	def void testMLComments_16() {
		configureByText("  /* foo|*/")

		myFixture.type('\n')
		assertState("  /* foo\n  * |*/")
	}

	def void testMLComments_17() {
		configureByText("  /*\n| *\n */")

		myFixture.type('\n')
		assertState("  /*\n\n| *\n */")
	}

	def void testBug453205_01() {
		configureByText("/*|\n" + "* comment\n" + "*/")

		myFixture.type('\n')
		assertState("/*\n" + "|\n" + "* comment\n" + "*/")
	}

	def void testBug453205_02() {
		configureByText("/**********|\n" + " * \"Fancy\"\n" + "**********/")

		myFixture.type('\n')
		assertState("/**********\n" + "|\n" + " * \"Fancy\"\n" + "**********/")
	}

	def void testBug341093_01() {
		configureByText("/**/\n" + "//test|")

		myFixture.type('\n')
		assertState("/**/\n" + "//test\n" + "|")
	}

	def void testBug341093_02() {
		configureByText("/*\n" + " **/\n" + "//test|")

		myFixture.type('\n')
		assertState("/*\n" + " **/\n" + "//test\n" + "|")
	}

	def void testBug341093_03() {
		configureByText("/***********\n" + " * text|\n" + "\n" + "***********/")

		myFixture.type('\n')
		assertState("/***********\n" + " * text\n" + " * |\n" + "\n" + "***********/")
	}

	def void testBug335634_01() {
		configureByText("// /*|\ntest")

		myFixture.type('\n')
		assertState("// /*\n|\ntest")
	}

	def void testBug335634_02() {
		configureByText("// /|")

		myFixture.type('*')
		assertState("// /*|")
	}

	def void testBug335634_03() {
		configureByText(" // /|")

		myFixture.type('*')
		assertState(" // /*|")
	}

	def void testBug335634_04() {
		configureByText(" // /|\n")

		myFixture.type('*')
		assertState(" // /*|\n")
	}

	def void testBug335634_05() {
		configureByText("// /|")

		myFixture.type('{')
		assertState("// /{|")
	}

	def void testBug335634_06() {
		configureByText(" // /|")

		myFixture.type('{')
		assertState(" // /{|")
	}

	def void testBug335634_07() {
		configureByText(" // /\n|")

		myFixture.type('{')
		assertState(" // /\n {|}")
	}

	def void testSingleLineComment_01() {
		configureByText("  // test|test")

		myFixture.type('\n')
		assertState("  // test\n  // |test")
	}

	def void testSingleLineComment_02() {
		configureByText("  // test|test\n")

		myFixture.type('\n')
		assertState("  // test\n  // |test\n")
	}

	def void testSingleLineComment_03() {
		configureByText("  // test|")

		myFixture.type('\n')
		assertState("  // test\n  |")
	}

	def void testSingleLineComment_04() {
		configureByText("  // test|\n")

		myFixture.type('\n')
		assertState("  // test\n  |\n")
	}

	def void testBug338423_01() {
		configureByText("[{|}]")

		myFixture.type('\n')
		assertState("[{\n\t|\n}]")
	}

	def void testBug338423_02() {
		configureByText("[{}|]")

		myFixture.type('\n')
		assertState("[{}\n|]")
	}

	def void testBug358555() {
		configureByText("/* | /**/")

		myFixture.type('\n')
		assertState("/* \n |/**/\n  */")
	}

}