/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.autoedit;

import org.eclipse.xtext.ui.editor.XtextEditor;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AutoEditInCodeBlockTest extends AutoEditTest {
	
	private static String PREFIX = "class Foo {\n\tfoo() ";
	
	private static String SUFFIX = "\n}";
	
	@Override
	protected XtextEditor openEditor(String string) throws Exception {
		return super.openEditor(PREFIX + string + SUFFIX);
	}
	
	@Override
	protected void assertState(String string, XtextEditor editor) {
		super.assertState(PREFIX + string + SUFFIX, editor);
	}
	
	
	@Override
	@Test public void testIndentationEdit_2() throws Exception {
		// indentation from prefix
		XtextEditor editor = openEditor("  |");
		pressKey(editor, '\n');
		assertState("  \n\t|", editor);
	}
	
	@Override
	@Test public void testCurlyBracesBlockInRichString_1() throws Exception {
		// added indentation from prefix
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '{');
		assertState("'''{|'''", editor);
		pressKey(editor, '\n');
		assertState("'''{\n\t\t|\n\t}'''", editor);
		pressKey(editor, '\n');
		assertState("'''{\n\t\t\n\t\t|\n\t}'''", editor);
	}

	@Override
	@Test public void testCurlyBracesBlockInRichString_2() throws Exception {
		// added indentation from prefix
		XtextEditor editor = openEditor("'''{|\n\t}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t\t|\n\t}'''", editor);
	}
	
	@Override
	@Test public void testCurlyBracesBlockInRichString_4() throws Exception {
		XtextEditor editor = openEditor("'''foo {|'''");
		pressKey(editor, '\n');
		assertState("'''foo {\n\t\t|\n\t}'''", editor);
	}

	@Override
	@Test public void testCurlyBracesBlockInRichString_5() throws Exception {
		XtextEditor editor = openEditor("'''{|}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t\t|\n\t}'''", editor);
	}

	@Override
	@Test public void testCurlyBracesBlockInRichString_6() throws Exception {
		XtextEditor editor = openEditor("'''{| }'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t\t|\n\t}'''", editor);
	}

	@Override
	@Test public void testCurlyBracesBlockInRichString_7() throws Exception {
		XtextEditor editor = openEditor("'''{ |foo }'''");
		pressKey(editor, '\n');
		assertState("'''{ \n\t\t|foo\n\t}'''", editor);
	}

	@Override
	@Test public void testCurlyBracesBlockInRichString_8() throws Exception {
		XtextEditor editor = openEditor("'''{ foo| }'''");
		pressKey(editor, '\n');
		assertState("'''{ foo\n\t| }'''", editor);
	}

	@Override
	@Test public void testCurlyBracesBlockInRichString_9() throws Exception {
		XtextEditor editor = openEditor("'''\"{\" foo| }'''");
		pressKey(editor, '\n');
		assertState("'''\"{\" foo\n\t| }'''", editor);
	}

	@Override
	@Test public void testCurlyBracesBlockInRichString_10() throws Exception {
		XtextEditor editor = openEditor("'''/*{*/ foo|'''");
		pressKey(editor, '\n');
		assertState("'''/*{*/ foo\n\t|'''", editor);
	}
	
	@Override
	@Test public void testCurlyBracesBlockInRichString_11() throws Exception {
		XtextEditor editor = openEditor("'''{|}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t\t|\n\t}'''", editor);
	}

	@Override
	@Test public void testCurlyBracesBlockInRichString_12() throws Exception {
		XtextEditor editor = openEditor("'''{foo|}'''");
		pressKey(editor, '\n');
		assertState("'''{foo\n\t|}'''", editor);
	}

	@Override
	@Test public void testCurlyBracesBlockInRichString_13() throws Exception {
		XtextEditor editor = openEditor("'''{foo|bar}'''");
		pressKey(editor, '\n');
		assertState("'''{foo\n\t|bar}'''", editor);
	}
	
	@Override
	@Test public void testCurlyBracesBlockInRichString_18() throws Exception {
		XtextEditor editor = openEditor("'''{{foo}|{bar}}'''");
		pressKey(editor, '\n');
		assertState("'''{{foo}\n\t|{bar}}'''", editor);
	}
	
	@Override
	@Test public void testRichStringLiteral_02() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '\n');
		assertState("'''\n\t|'''", editor);
	}
	
	@Override
	@Test public void testRichStringLiteral_03() throws Exception {
		XtextEditor editor = openEditor("  '''|'''");
		pressKey(editor, '\n');
		assertState("  '''\n\t|'''", editor);
	}
	
	@Override
	@Test public void testCurlyBracesBlock_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '{');
		assertState("{|}", editor);
		pressKey(editor, '\n');
		assertState("{\n\t\t|\n\t}", editor);
		pressKey(editor, '\n');
		assertState("{\n\t\t\n\t\t|\n\t}", editor);
	}

	@Override
	@Test public void testCurlyBracesBlock_2() throws Exception {
		XtextEditor editor = openEditor("{|\n\t}");
		pressKey(editor, '\n');
		assertState("{\n\t\t|\n\t}", editor);
	}
	
	@Override
	@Test public void testCurlyBracesBlock_4() throws Exception {
		XtextEditor editor = openEditor("foo {|");
		pressKey(editor, '\n');
		assertState("foo {\n\t\t|\n\t}", editor);
	}

	@Override
	@Test public void testCurlyBracesBlock_5() throws Exception {
		XtextEditor editor = openEditor("{|}");
		pressKey(editor, '\n');
		assertState("{\n\t\t|\n\t}", editor);
	}

	@Override
	@Test public void testCurlyBracesBlock_6() throws Exception {
		XtextEditor editor = openEditor("{| }");
		pressKey(editor, '\n');
		assertState("{\n\t\t|\n\t}", editor);
	}

	@Override
	@Test public void testCurlyBracesBlock_7() throws Exception {
		XtextEditor editor = openEditor("{ |foo }");
		pressKey(editor, '\n');
		assertState("{ \n\t\t|foo\n\t}", editor);
	}

	@Override
	@Test public void testCurlyBracesBlock_8() throws Exception {
		XtextEditor editor = openEditor("{ foo| }");
		pressKey(editor, '\n');
		assertState("{ foo\n\t\t|\n\t}", editor);
	}

	@Override
	@Test public void testCurlyBracesBlock_9() throws Exception {
		XtextEditor editor = openEditor("'{' foo| }");
		pressKey(editor, '\n');
		assertState("'{' foo\n\t| }", editor);
	}

	@Override
	@Test public void testCurlyBracesBlock_10() throws Exception {
		XtextEditor editor = openEditor("/*{*/ foo|");
		pressKey(editor, '\n');
		assertState("/*{*/ foo\n\t|", editor);
	}
	
	@Override
	@Test public void testCurlyBracesBlock_11() throws Exception {
		XtextEditor editor = openEditor("{|}");
		pressKey(editor, '\n');
		assertState("{\n\t\t|\n\t}", editor);
	}

	@Override
	@Test public void testCurlyBracesBlock_12() throws Exception {
		XtextEditor editor = openEditor("{foo|}");
		pressKey(editor, '\n');
		assertState("{foo\n\t\t|\n\t}", editor);
	}

	@Override
	@Test public void testCurlyBracesBlock_13() throws Exception {
		XtextEditor editor = openEditor("{foo|bar}");
		pressKey(editor, '\n');
		assertState("{foo\n\t\t|bar\n\t}", editor);
	}
	
	@Override
	@Test public void testCurlyBracesBlock_17() throws Exception {
		XtextEditor editor = openEditor("{\n|");
		pressKey(editor, '\n');
		assertState("{\n\n|\n}", editor); 
	}

	@Override
	@Test public void testCurlyBracesBlock_18() throws Exception {
		XtextEditor editor = openEditor("{{foo}|{bar}}");
		pressKey(editor, '\n');
		assertState("{{foo}\n\t\t|{bar}\n\t}", editor);
	}
	
	@Override
	public void testCurlyBracesBlock_19() throws Exception {
		XtextEditor editor = openEditor("{{|");
		pressKey(editor, '\n');
		assertState("{{\n\t\t|\n\t}", editor);
		pressKey(editor, '\n');
		assertState("{{\n\t\t\n\t\t|\n\t\t}\n\t}", editor);
		pressKey(editor, '\n');
		assertState("{{\n\t\t\n\t\t\n\t\t|\n\t\t}\n\t}", editor);
	}
	
	@Test public void testCurlyBracesBlock_20() throws Exception {
		XtextEditor editor = openEditor("{|\n}");
		pressKey(editor, '\n');
		assertState("{\n\t\t|\n}", editor);
	}
	
	@Test public void testCurlyBracesBlock_21() throws Exception {
		XtextEditor editor = openEditor("{\n\t|");
		pressKey(editor, '\n');
		assertState("{\n\t\n\t|\n\t}", editor); 
	}
	
	@Override
	@Test public void testMLComments_01() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '/');
		pressKey(editor, '*');
		assertState("/*| */", editor);

		pressKey(editor, '\n');
		assertState("/*\n\t * |\n\t */", editor);

		pressKey(editor, '\n');
		assertState("/*\n\t * \n\t * |\n\t */", editor);

		pressKeys(editor, "foo bar");
		pressKey(editor, '\n');
		assertState("/*\n\t * \n\t * foo bar\n\t * |\n\t */", editor);
	}

	@Override
	@Test public void testMLComments_02() throws Exception {
		XtextEditor editor = openEditor("   |");
		pressKey(editor, '/');
		pressKey(editor, '*');
		assertState("   /*| */", editor);

		pressKey(editor, '\n');
		assertState("   /*\n\t * |\n\t */", editor);

		pressKey(editor, '\n');
		assertState("   /*\n\t * \n\t * |\n\t */", editor);

		pressKeys(editor, "foo bar");
		pressKey(editor, '\n');
		assertState("   /*\n\t * \n\t * foo bar\n\t * |\n\t */", editor);
	}
	
	@Override
	@Test public void testMLComments_07() throws Exception {
		XtextEditor editor = openEditor("/* */|");

		pressKey(editor, '\n');
		assertState("/* */\n\t|", editor);
	}

	@Override
	@Test public void testMLComments_08() throws Exception {
		XtextEditor editor = openEditor("  /* foo | */");

		pressKey(editor, '\n');
		assertState("  /* foo \n\t * |\n\t */", editor);
	}

	@Override
	@Test public void testMLComments_09() throws Exception {
		XtextEditor editor = openEditor("/* foo |*/");

		pressKey(editor, '\n');
		assertState("/* foo \n\t * |*/", editor);
	}

	@Override
	@Test public void testMLComments_10() throws Exception {
		XtextEditor editor = openEditor("   /* foo |*/");

		pressKey(editor, '\n');
		assertState("   /* foo \n\t * |*/", editor);
	}
	
	@Override
	@Test public void testMLComments_12() throws Exception {
		XtextEditor editor = openEditor("foo /*| */");

		pressKey(editor, '\n');
		assertState("foo /*\n\t * |\n\t */", editor);
	}

	@Override
	@Test public void testMLComments_13() throws Exception {
		XtextEditor editor = openEditor("/* foo| */");
		pressKey(editor, '\n');
		assertState("/* foo\n\t * |\n\t */", editor);
	}

	@Override
	@Test public void testMLComments_14() throws Exception {
		XtextEditor editor = openEditor("/* foo|*/");
		pressKey(editor, '\n');
		assertState("/* foo\n\t * |*/", editor);
	}

	@Override
	@Test public void testMLComments_15() throws Exception {
		XtextEditor editor = openEditor("  /* foo| */");
		pressKey(editor, '\n');
		assertState("  /* foo\n\t * |\n\t */", editor);
	}

	@Override
	@Test public void testMLComments_16() throws Exception {
		XtextEditor editor = openEditor("  /* foo|*/");
		pressKey(editor, '\n');
		assertState("  /* foo\n\t * |*/", editor);
	}
	
	@Override
	@Test public void testBug453205_01() throws Exception {
		XtextEditor editor = openEditor("/*|\n" + 
				"* comment\n" + 
				"*/");
		pressKey(editor, '\n');
		assertState("/*\n" + 
				"\t * |\n" + 
				"* comment\n" + 
				"*/", editor);
	}
	
	@Override
	@Test public void testBug453205_02() throws Exception {
		XtextEditor editor = openEditor("/**********|\n" + 
				" * \"Fancy\"\n" + 
				"**********/");
		pressKey(editor, '\n');
		assertState("/**********\n" + 
				"\t * |\n" + 
				" * \"Fancy\"\n" + 
				"**********/", editor);
	}
	
	@Override
	@Test public void testBug335634_01() throws Exception {
		XtextEditor editor = openEditor("// /*|\ntest");
		pressKey(editor, '\n');
		assertState("// /*\n\t|\ntest", editor);
	}
	
	@Override
	@Test public void testSingleLineComment_01() throws Exception {
		XtextEditor editor = openEditor("  // test|test");
		pressKey(editor, '\n');
		assertState("  // test\n\t|test", editor);
	}
	
	@Override
	@Test public void testSingleLineComment_02() throws Exception {
		XtextEditor editor = openEditor("  // test|test\n");
		pressKey(editor, '\n');
		assertState("  // test\n\t|test\n", editor);
	}
	
	@Override
	@Test public void testSingleLineComment_03() throws Exception {
		XtextEditor editor = openEditor("  // test|");
		pressKey(editor, '\n');
		assertState("  // test\n\t|", editor);
	}
	
	@Override
	@Test public void testSingleLineComment_04() throws Exception {
		XtextEditor editor = openEditor("  // test|\n");
		pressKey(editor, '\n');
		assertState("  // test\n\t|\n", editor);
	}
	
	@Override
	@Test public void testBug338423_01() throws Exception {
		XtextEditor editor = openEditor("[{|}]");
		pressKey(editor, '\n');
		assertState("[{\n\t\t|\n\t}]", editor);
	}
	
	@Override
	@Test public void testBug338423_02() throws Exception {
		XtextEditor editor = openEditor("[{}|]");
		pressKey(editor, '\n');
		assertState("[{}\n\t\t|\n\t]", editor);
	}
	
	@Override
	@Test public void testBug358555() throws Exception {
		XtextEditor editor = openEditor("/* | /**/");
		pressKey(editor, '\n');
		assertState("/* \n\t * | /**/", editor);
	}
	
	@Override
	public void testWindowsLineDelimiter() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pasteText(editor, "\r\n");
		assertState("'''" + "\r\n" + "\t|'''", editor);
	}
}