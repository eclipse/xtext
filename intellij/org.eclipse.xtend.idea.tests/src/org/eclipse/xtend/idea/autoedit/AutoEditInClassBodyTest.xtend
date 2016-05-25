/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

/**
 * @author kosyakov - Initial contribution and API
 */
class AutoEditInClassBodyTest extends AutoEditTest {

	static val PREFIX = "class Foo {\n"

	static val SUFFIX = "\n}"
	
	override protected configureByText(String code) {
		super.configureByText(PREFIX + code + SUFFIX)
	}
	
	override protected assertState(String editorState) {
		super.assertState(PREFIX + editorState + SUFFIX)
	}
	
	override testCurlyBracesBlock_1() {
		configureByText('|')
		myFixture.type('{')
		assertState('\t{|}')
		myFixture.type('\n')
		assertState('\t{\n\t\t|\n\t}')
		myFixture.type('\n')
		assertState('\t{\n\t\t\n\t\t|\n\t}')
	}
	
	override testIndentationEdit_2() {
		configureByText("  |")
		myFixture.type('\n')
		assertState("  \n	|")
	}
	
	override testBug341093_01() {
		configureByText("/**/\n" + "//test|")

		myFixture.type('\n')
		assertState("/**/\n" + "//test\n" + "	|")
	}
	
	override testBug341093_02() {
		configureByText("/*\n" + " **/\n" + "//test|")

		myFixture.type('\n')
		assertState("/*\n" + " **/\n" + "//test\n" + "	|")
	}
	
	override testMLComments_07() {
		configureByText("/* */|")

		myFixture.type('\n')
		assertState("/* */\n\t|")
	}
	
	override testMLComments_11() {
		configureByText("/* */\n * |")

		myFixture.type('\n')
		assertState("/* */\n * \n\t|")
	}
	
	override testSingleLineComment_03() {
		configureByText("  // test|")

		myFixture.type('\n')
		assertState("  // test\n\t|")
	}
	
	override testSingleLineComment_04() {
		configureByText("  // test|\n")

		myFixture.type('\n')
		assertState("  // test\n\t|\n")
	}

	override void testCurlyBracesBlock_10() {
		configureByText('/*{*/ foo|')
		myFixture.type('\n')
		assertState('/*{*/ foo\n|')
	}
	
	override testCurlyBracesBlock_17() {
		configureByText('{\n|')
		myFixture.type('\n')
		assertState('{\n\n\t|')
	}
	
	override testCurlyBracesBlock_19() {
		configureByText('{{|')
		myFixture.type('\n')
		assertState('{{\n\t|\n}}')
		myFixture.type('\n')
		assertState('{{\n\t\n\t|\n}}')
	}
	
	override testParenthesis_1() {
		configureByText("|")
		myFixture.type('(')
		assertState("\t(|)")
		myFixture.type('(')
		assertState("\t((|))")
		myFixture.type(BS)
		assertState("\t(|)")
		myFixture.type(BS)
		assertState("\t|")
	}
	
	override testParenthesis_2() {
		configureByText("|")
		myFixture.type('(')
		assertState("\t(|)")
		myFixture.type(')')
		assertState("\t()|")
		myFixture.type(BS)
		assertState("\t(|")
		myFixture.type(BS)
		assertState("\t|")
	}
	
	override testParenthesis_3() {
		configureByText("|")
		myFixture.type('(')
		assertState("\t(|)")
		myFixture.type(BS)
		assertState("\t|")
	}
	
	override testParenthesis_4() {
		configureByText("|foobar")
		myFixture.type('(')
		assertState("\t(|foobar")
	}
	
	override testParenthesis_5() {
		configureByText("|")
		myFixture.type(')')
		assertState("\t)|")
		myFixture.type(')')
		assertState("\t))|")
		myFixture.type(BS)
		assertState("\t)|")
		myFixture.type(BS)
		assertState("\t|")
	}
	
	override testParenthesis_9() {
		configureByText("|'')")
		myFixture.type('(')
		assertState("\t(|'')")
	}

}