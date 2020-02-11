/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.12
 */
public abstract class AbstractCStyleLanguageAutoEditTest extends AbstractAutoEditTest {

	@Test public void testParenthesis_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '(');
		assertState("(|)", editor);
		pressKey(editor, '(');
		assertState("((|))", editor);
		pressKey(editor, SWT.BS);
		assertState("(|)", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	@Test public void testParenthesis_2() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '(');
		assertState("(|)", editor);
		pressKey(editor, ')');
		assertState("()|", editor);
		pressKey(editor, SWT.BS);
		assertState("(|", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	@Test public void testParenthesis_3() throws Exception {
		XtextEditor editor = openEditor("|)");
		pressKey(editor, '(');
		assertState("(|)", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	@Test public void testParenthesis_4() throws Exception {
		XtextEditor editor = openEditor("|foobar");
		pressKey(editor, '(');
		assertState("(|foobar", editor);
	}

	@Test public void testParenthesis_5() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, ')');
		assertState(")|", editor);
		pressKey(editor, ')');
		assertState("))|", editor);
		pressKey(editor, SWT.BS);
		assertState(")|", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	@Test public void testParenthesis_6() throws Exception {
		XtextEditor editor = openEditor("(|\n)");
		pressKey(editor, ')');
		assertState("()|\n)", editor);
		pressKey(editor, SWT.BS);
		assertState("(|\n)", editor);
	}

	@Test public void testParenthesis_7() throws Exception {
		XtextEditor editor = openEditor("(((|)");
		pressKey(editor, ')');
		assertState("((()|)", editor);
		pressKey(editor, ')');
		assertState("((())|)", editor);
		pressKey(editor, ')');
		assertState("((()))|", editor);
	}
	
	@Test public void testParenthesis_8() throws Exception {
		XtextEditor editor = openEditor("(foobar|)");
		pressKey(editor, ')');
		assertState("(foobar)|", editor);
	}
	
	@Ignore
	@Test public void testParenthesis_9() throws Exception {
		XtextEditor editor = openEditor("|'')");
		pressKey(editor, '(');
		assertState("(|'')", editor);
	}
	
	@Test public void testParenthesis_10() throws Exception {
		XtextEditor editor = openEditor("(|'')");
		pressKey(editor, '(');
		assertState("((|'')", editor);
	}

	@Test public void testSingleQuotedStringLiteral_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '\'');
		assertState("\'|\'", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	@Test public void testSingleQuotedStringLiteral_2() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '\'');
		assertState("\'|\'", editor);
		pressKey(editor, '\'');
		assertState("\'\'|", editor);
		pressKey(editor, SWT.BS);
		assertState("\'|", editor);
	}

	@Test public void testSingleQuotedStringLiteral_3() throws Exception {
		XtextEditor editor = openEditor("|'");
		pressKey(editor, '\'');
		assertState("'|'", editor);
		pressKey(editor, '\'');
		assertState("''|", editor);
		pressKey(editor, '\'');
		assertState("'''|'", editor);
	}

	@Test public void testSingleQuotedStringLiteral_4() throws Exception {
		XtextEditor editor = openEditor("|foo");
		pressKey(editor, '\'');
		assertState("'|foo", editor);
		pressKey(editor, '\'');
		assertState("''|foo", editor);
	}

	@Test public void testSingleQuotedStringLiteral_5() throws Exception {
		XtextEditor editor = openEditor("|foo");
		pressKey(editor, '\'');
		assertState("'|foo", editor);
		pressKey(editor, '\'');
		assertState("''|foo", editor);
		pressKey(editor, SWT.BS);
		assertState("'|foo", editor);
		pressKey(editor, SWT.BS);
		assertState("|foo", editor);
	}

	@Test public void testSingleQuotedStringLiteral_6() throws Exception {
		XtextEditor editor = openEditor("'| '");
		pressKey(editor, '\'');
		assertState("''| '", editor);
		pressKey(editor, SWT.BS);
		assertState("'| '", editor);
	}

	@Test public void testSingleQuotedStringLiteral_7() throws Exception {
		XtextEditor editor = openEditor("'' '| '");
		pressKey(editor, '\'');
		assertState("'' ''| '", editor);
		pressKey(editor, SWT.BS);
		assertState("'' '| '", editor);
	}

	@Test public void testSingleQuotedStringLiteral_8() throws Exception {
		XtextEditor editor = openEditor("'| ' ' '");
		pressKey(editor, '\'');
		assertState("''| ' ' '", editor);
		pressKey(editor, SWT.BS);
		assertState("'| ' ' '", editor);
	}

	@Test public void testSingleQuotedStringLiteral_9() throws Exception {
		XtextEditor editor = openEditor("foo|{}");
		selectText(editor, -3,3);
		pressKey(editor, '\'');
		assertState("'|'{}", editor);
		pressKey(editor, SWT.BS);
		assertState("|{}", editor);
	}

	@Test public void testSingleQuotedStringLiteral_10() throws Exception {
		XtextEditor editor = openEditor("foo|{}");
		selectText(editor, -2,2);
		pressKey(editor, '\'');
		assertState("f'|'{}", editor);
		pressKey(editor, SWT.BS);
		assertState("f|{}", editor);
	}

	@Test public void testSingleQuotedStringLiteral_11() throws Exception {
		XtextEditor editor = openEditor("|foo{}");
		selectText(editor, 0, 2);
		pressKey(editor, '\'');
		assertState("'|o{}", editor);
	}

	@Test public void testSingleQuotedStringLiteral_12() throws Exception {
		XtextEditor editor = openEditor("|foo{}");
		selectText(editor, 0, 1);
		pressKey(editor, '\'');
		assertState("'|oo{}", editor);
	}
	
	@Test public void testSingleQuotedStringLiteral_13() throws Exception {
		XtextEditor editor = openEditor("'a|");
		pressKey(editor, '\'');
		assertState("'a'|", editor);
	}
	
	@Test public void testSingleQuotedStringLiteral_14() throws Exception {
		XtextEditor editor = openEditor("|'test'");
		pressKey(editor, '\'');
		assertState("'|''test'", editor);
		pressKey(editor, '\'');
		assertState("''|'test'", editor);
		pressKey(editor, '\'');
		assertState("'''|''test'", editor);
	}
	
	@Test public void testSingleQuotedStringLiteral_15() throws Exception {
		XtextEditor editor = openEditor("'|''test'");
		pressKey(editor, '\'');
		assertState("''|'test'", editor);
		pressKey(editor, '\'');
		assertState("'''|''test'", editor);
	}

	@Test public void testDoubleQuotedStringLiteral_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '"');
		assertState("\"|\"", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	@Test public void testDoubleQuotedStringLiteral_2() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '"');
		assertState("\"|\"", editor);
		pressKey(editor, '"');
		assertState("\"\"|", editor);
		pressKey(editor, SWT.BS);
		assertState("\"|", editor);
	}

	@Test public void testDoubleQuotedStringLiteral_3() throws Exception {
		XtextEditor editor = openEditor("|\"");
		pressKey(editor, '\"');
		assertState("\"|\"", editor);
		pressKey(editor, '\"');
		assertState("\"\"|", editor);
		pressKey(editor, '\"');
		assertState("\"\"\"|\"", editor);
	}

	@Test public void testDoubleQuotedStringLiteral_4() throws Exception {
		XtextEditor editor = openEditor("|foo");
		pressKey(editor, '\"');
		assertState("\"|foo", editor);
		pressKey(editor, '\"');
		assertState("\"\"|foo", editor);
	}

	@Test public void testDoubleQuotedStringLiteral_5() throws Exception {
		XtextEditor editor = openEditor("|foo");
		pressKey(editor, '\"');
		assertState("\"|foo", editor);
		pressKey(editor, '\"');
		assertState("\"\"|foo", editor);
		pressKey(editor, SWT.BS);
		assertState("\"|foo", editor);
		pressKey(editor, SWT.BS);
		assertState("|foo", editor);
	}

	@Test public void testDoubleQuotedStringLiteral_6() throws Exception {
		XtextEditor editor = openEditor("\"| \"");
		pressKey(editor, '\"');
		assertState("\"\"| \"", editor);
		pressKey(editor, SWT.BS);
		assertState("\"| \"", editor);
	}

	@Test public void testDoubleQuotedStringLiteral_7() throws Exception {
		XtextEditor editor = openEditor("\"\" \"| \"");
		pressKey(editor, '\"');
		assertState("\"\" \"\"| \"", editor);
		pressKey(editor, SWT.BS);
		assertState("\"\" \"| \"", editor);
	}

	@Test public void testDoubleQuotedStringLiteral_8() throws Exception {
		XtextEditor editor = openEditor("\"| \" \" \"");
		pressKey(editor, '\"');
		assertState("\"\"| \" \" \"", editor);
		pressKey(editor, SWT.BS);
		assertState("\"| \" \" \"", editor);
	}
	
	@Test public void testDoubleQuotedStringLiteral_9() throws Exception {
		XtextEditor editor = openEditor("\"a|");
		pressKey(editor, '"');
		assertState("\"a\"|", editor);
	}
	
	@Test public void testDoubleQuotedStringLiteral_10() throws Exception {
		XtextEditor editor = openEditor("|\"test\"");
		pressKey(editor, '"');
		assertState("\"|\"\"test\"", editor);
	}
	
	@Test public void testCurlyBracesBlock_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '{');
		assertState("{|}", editor);
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
		pressKey(editor, '\n');
		assertState("{\n\t\n\t|\n}", editor);
	}

	@Test public void testCurlyBracesBlock_2() throws Exception {
		XtextEditor editor = openEditor("{|\n}");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	@Test public void testCurlyBracesBlock_3() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '}');
		assertState("}|", editor);
	}

	@Test public void testCurlyBracesBlock_4() throws Exception {
		XtextEditor editor = openEditor("foo {|");
		pressKey(editor, '\n');
		assertState("foo {\n\t|\n}", editor);
	}

	@Test public void testCurlyBracesBlock_5() throws Exception {
		XtextEditor editor = openEditor("{|}");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	@Test public void testCurlyBracesBlock_6() throws Exception {
		XtextEditor editor = openEditor("{| }");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	@Test public void testCurlyBracesBlock_7() throws Exception {
		XtextEditor editor = openEditor("{ |foo }");
		pressKey(editor, '\n');
		assertState("{ \n\t|foo\n}", editor);
	}

	@Test public void testCurlyBracesBlock_8() throws Exception {
		XtextEditor editor = openEditor("{ foo| }");
		pressKey(editor, '\n');
		assertState("{ foo\n\t|\n}", editor);
	}

	@Test public void testCurlyBracesBlock_9() throws Exception {
		XtextEditor editor = openEditor("'{' foo| }");
		pressKey(editor, '\n');
		assertState("'{' foo\n| }", editor);
	}

	@Test public void testCurlyBracesBlock_10() throws Exception {
		XtextEditor editor = openEditor("/*{*/ foo|");
		pressKey(editor, '\n');
		assertState("/*{*/ foo\n|", editor);
	}
	
	@Test public void testCurlyBracesBlock_11() throws Exception {
		XtextEditor editor = openEditor("{|}");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	@Test public void testCurlyBracesBlock_12() throws Exception {
		XtextEditor editor = openEditor("{foo|}");
		pressKey(editor, '\n');
		assertState("{foo\n\t|\n}", editor);
	}

	@Test public void testCurlyBracesBlock_13() throws Exception {
		XtextEditor editor = openEditor("{foo|bar}");
		pressKey(editor, '\n');
		assertState("{foo\n\t|bar\n}", editor);
	}

	@Test public void testCurlyBracesBlock_14() throws Exception {
		XtextEditor editor = openEditor("{\nfoo|bar}");
		pressKey(editor, '\n');
		assertState("{\nfoo\n|bar}", editor);
	}

	@Test public void testCurlyBracesBlock_15() throws Exception {
		XtextEditor editor = openEditor("{\nfoo}|{bar}");
		pressKey(editor, '\n');
		assertState("{\nfoo}\n|{bar}", editor);
	}

	@Test public void testCurlyBracesBlock_16() throws Exception {
		XtextEditor editor = openEditor("{\n|}");
		pressKey(editor, '\n');
		assertState("{\n\n|}", editor);
	}

	@Test public void testCurlyBracesBlock_17() throws Exception {
		XtextEditor editor = openEditor("{\n|");
		pressKey(editor, '\n');
		assertState("{\n\n|\n}", editor);
	}

	@Test public void testCurlyBracesBlock_18() throws Exception {
		XtextEditor editor = openEditor("{{foo}|{bar}}");
		pressKey(editor, '\n');
		assertState("{{foo}\n\t|{bar}\n}", editor);
	}
	
	@Test
	public void testCurlyBracesBlock_19() throws Exception {
		XtextEditor editor = openEditor("{{|");
		pressKey(editor, '\n');
		assertState("{{\n\t|\n}", editor);
		pressKey(editor, '\n');
		assertState("{{\n\t\n\t|\n\t}\n}", editor);
		pressKey(editor, '\n');
		assertState("{{\n\t\n\t\n\t|\n\t}\n}", editor);
	}

	@Test public void testCurlyBracesWithSelection_1() throws Exception {
		XtextEditor editor = openEditor("{|foo}");
		selectText(editor,0,3);
		pressKey(editor, '{');
		assertState("{{|}}", editor);
		pressKey(editor, SWT.BS);
		assertState("{|}", editor);
	}

	@Test public void testCurlyBracesWithSelection_2() throws Exception {
		XtextEditor editor = openEditor("{|foo}");
		selectText(editor,0,2);
		pressKey(editor, '{');
		assertState("{{|o}", editor);
		pressKey(editor, SWT.BS);
		assertState("{|o}", editor);
	}

	@Test public void testCurlyBracesWithSelection_3() throws Exception {
		XtextEditor editor = openEditor("{|foo}");
		selectText(editor,0,1);
		pressKey(editor, '{');
		assertState("{{|oo}", editor);
		pressKey(editor, SWT.BS);
		assertState("{|oo}", editor);
	}

	@Test public void testCurlyBracesWithSelection_4() throws Exception {
		XtextEditor editor = openEditor("{{|foo}}");
		selectText(editor,0,3);
		pressKey(editor, '}');
		assertState("{{}|}", editor);
		pressKey(editor, SWT.BS);
		assertState("{{|}", editor);
	}

	@Test public void testCurlyBracesWithSelection_5() throws Exception {
		XtextEditor editor = openEditor("{{|foo}}");
		selectText(editor,0,2);
		pressKey(editor, '}');
		assertState("{{}|o}}", editor);
		pressKey(editor, SWT.BS);
		assertState("{{|o}}", editor);
		pressKey(editor, '{');
		assertState("{{{|o}}", editor);
	}

	@Test public void testMLComments_01() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '/');
		pressKey(editor, '*');
		assertState("/*| */", editor);

		pressKey(editor, '\n');
		assertState("/*\n * |\n */", editor);

		pressKey(editor, '\n');
		assertState("/*\n * \n * |\n */", editor);

		pressKeys(editor, "foo bar");
		pressKey(editor, '\n');
		assertState("/*\n * \n * foo bar\n * |\n */", editor);
	}

	@Test public void testMLComments_02() throws Exception {
		XtextEditor editor = openEditor("   |");
		pressKey(editor, '/');
		pressKey(editor, '*');
		assertState("   /*| */", editor);

		pressKey(editor, '\n');
		assertState("   /*\n    * |\n    */", editor);

		pressKey(editor, '\n');
		assertState("   /*\n    * \n    * |\n    */", editor);

		pressKeys(editor, "foo bar");
		pressKey(editor, '\n');
		assertState("   /*\n    * \n    * foo bar\n    * |\n    */", editor);
	}

	@Test public void testMLComments_03() throws Exception {
		XtextEditor editor = openEditor("/*\n *| */");

		pressKey(editor, '\n');
		assertState("/*\n *\n * | */", editor);
	}

	@Test public void testMLComments_04() throws Exception {
		XtextEditor editor = openEditor("\t/*\n\t *|\n\t */");

		pressKey(editor, '\n');
		assertState("\t/*\n\t *\n\t * |\n\t */", editor);
	}

	@Test public void testMLComments_05() throws Exception {
		XtextEditor editor = openEditor("foo /*\n     *|\n      */");

		pressKey(editor, '\n');
		assertState("foo /*\n     *\n     * |\n      */", editor);
	}

	@Test public void testMLComments_07() throws Exception {
		XtextEditor editor = openEditor("/* */|");

		pressKey(editor, '\n');
		assertState("/* */\n|", editor);
	}

	@Test public void testMLComments_08() throws Exception {
		XtextEditor editor = openEditor("  /* foo | */");

		pressKey(editor, '\n');
		assertState("  /* foo \n   * |\n   */", editor);
	}

	@Test public void testMLComments_09() throws Exception {
		XtextEditor editor = openEditor("/* foo |*/");

		pressKey(editor, '\n');
		assertState("/* foo \n * |*/", editor);
	}

	@Test public void testMLComments_10() throws Exception {
		XtextEditor editor = openEditor("   /* foo |*/");

		pressKey(editor, '\n');
		assertState("   /* foo \n    * |*/", editor);
	}

	@Test public void testMLComments_11() throws Exception {
		XtextEditor editor = openEditor("/* */\n * |");

		pressKey(editor, '\n');
		assertState("/* */\n * \n |", editor);
	}

	@Test public void testMLComments_12() throws Exception {
		XtextEditor editor = openEditor("foo /*| */");

		pressKey(editor, '\n');
		assertState("foo /*\n * |\n */", editor);
	}

	@Test public void testMLComments_13() throws Exception {
		XtextEditor editor = openEditor("/* foo| */");
		pressKey(editor, '\n');
		assertState("/* foo\n * |\n */", editor);
	}

	@Test public void testMLComments_14() throws Exception {
		XtextEditor editor = openEditor("/* foo|*/");
		pressKey(editor, '\n');
		assertState("/* foo\n * |*/", editor);
	}

	@Test public void testMLComments_15() throws Exception {
		XtextEditor editor = openEditor("  /* foo| */");
		pressKey(editor, '\n');
		assertState("  /* foo\n   * |\n   */", editor);
	}

	@Test public void testMLComments_16() throws Exception {
		XtextEditor editor = openEditor("  /* foo|*/");
		pressKey(editor, '\n');
		assertState("  /* foo\n   * |*/", editor);
	}

	@Test public void testMLComments_17() throws Exception {
		XtextEditor editor = openEditor("  /*\n| *\n */");
		pressKey(editor, '\n');
		assertState("  /*\n\n| *\n */", editor);
	}

	@Test public void testBug453205_01() throws Exception {
		XtextEditor editor = openEditor("/*|\n" + 
				"* comment\n" + 
				"*/");
		pressKey(editor, '\n');
		assertState("/*\n" + 
				" * |\n" + 
				"* comment\n" + 
				"*/", editor);
	}
	
	@Test public void testBug453205_02() throws Exception {
		XtextEditor editor = openEditor("/**********|\n" + 
				" * \"Fancy\"\n" + 
				"**********/");
		pressKey(editor, '\n');
		assertState("/**********\n" + 
				" * |\n" + 
				" * \"Fancy\"\n" + 
				"**********/", editor);
	}
	
	@Test public void testBug341093_01() throws Exception {
		XtextEditor editor = openEditor(
				"/**/\n" + 
				"//test|");
		pressKey(editor, '\n');
		assertState(
				"/**/\n" + 
				"//test\n" +
				"|", editor);
	}
	
	@Test public void testBug341093_02() throws Exception {
		XtextEditor editor = openEditor(
				"/*\n" + 
				" **/\n" + 
				"//test|");
		pressKey(editor, '\n');
		assertState(
				"/*\n" + 
				" **/\n" + 
				"//test\n" +
				"|", editor);
	}
	
	@Test public void testBug341093_03() throws Exception {
		XtextEditor editor = openEditor(
				"/***********\n" + 
				" * text|\n" + 
				"\n" + 
				"***********/");
		pressKey(editor, '\n');
		assertState(
				"/***********\n" + 
				" * text\n" +
				" * |\n" + 
				"\n" + 
				"***********/", editor);
	}
	
	@Test public void testBug335634_01() throws Exception {
		XtextEditor editor = openEditor("// /*|\ntest");
		pressKey(editor, '\n');
		assertState("// /*\n|\ntest", editor);
	}
	
	@Test public void testBug335634_02() throws Exception {
		XtextEditor editor = openEditor("// /|");
		pressKey(editor, '*');
		assertState("// /*|", editor);
	}
	
	@Test public void testBug335634_03() throws Exception {
		XtextEditor editor = openEditor(" // /|");
		pressKey(editor, '*');
		assertState(" // /*|", editor);
	}
	
	@Test public void testBug335634_04() throws Exception {
		XtextEditor editor = openEditor(" // /|\n");
		pressKey(editor, '*');
		assertState(" // /*|\n", editor);
	}
	
	@Test public void testBug335634_05() throws Exception {
		XtextEditor editor = openEditor("// /|");
		pressKey(editor, '{');
		assertState("// /{|", editor);
	}
	
	@Test public void testBug335634_06() throws Exception {
		XtextEditor editor = openEditor(" // /|");
		pressKey(editor, '{');
		assertState(" // /{|", editor);
	}
	
	@Test public void testBug335634_07() throws Exception {
		XtextEditor editor = openEditor(" // /\n|");
		pressKey(editor, '{');
		assertState(" // /\n{|}", editor);
	}
	
	@Test public void testSingleLineComment_01() throws Exception {
		XtextEditor editor = openEditor("  // test|test");
		pressKey(editor, '\n');
		assertState("  // test\n  |test", editor);
	}
	
	@Test public void testSingleLineComment_02() throws Exception {
		XtextEditor editor = openEditor("  // test|test\n");
		pressKey(editor, '\n');
		assertState("  // test\n  |test\n", editor);
	}
	
	@Test public void testSingleLineComment_03() throws Exception {
		XtextEditor editor = openEditor("  // test|");
		pressKey(editor, '\n');
		assertState("  // test\n  |", editor);
	}
	
	@Test public void testSingleLineComment_04() throws Exception {
		XtextEditor editor = openEditor("  // test|\n");
		pressKey(editor, '\n');
		assertState("  // test\n  |\n", editor);
	}
	
	@Test public void testBug338423_01() throws Exception {
		XtextEditor editor = openEditor("[{|}]");
		pressKey(editor, '\n');
		assertState("[{\n\t|\n}]", editor);
	}
	
	@Test public void testBug338423_02() throws Exception {
		XtextEditor editor = openEditor("[{}|]");
		pressKey(editor, '\n');
		assertState("[{}\n\t|\n]", editor);
	}
	
	@Test public void testBug358555() throws Exception {
		XtextEditor editor = openEditor("/* | /**/");
		pressKey(editor, '\n');
		assertState("/* \n * | /**/", editor);
	}
}
