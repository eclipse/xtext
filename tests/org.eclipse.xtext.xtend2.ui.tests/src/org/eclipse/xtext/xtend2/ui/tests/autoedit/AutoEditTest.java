/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.autoedit;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.junit.editor.autoedit.AbstractCStyleLanguageAutoEditTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AutoEditTest extends AbstractCStyleLanguageAutoEditTest {

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.xtend2.Xtend2";
	}

	@Override
	protected String getFileExtension() {
		return "xtend";
	}
	
	@Override
	protected XtextEditor openEditor(String string) throws Exception {
		int cursor = string.indexOf('|');
		String fileExtension = getFileExtension();
		IJavaProject javaProject = createJavaProject("foo");
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		IFile file = createFile("foo/src/myfile" + getFiles().size() + "." + fileExtension, string.replace("|", ""));
		getFiles().add(file);
		XtextEditor editor = openEditor(file);
		editor.getInternalSourceViewer().setSelectedRange(cursor, 0);
		editor.getInternalSourceViewer().getTextWidget().setFocus();
		return editor;
	}
	
	public void testIndentationEdit_1() throws Exception {
		XtextEditor editor = openEditor("  '|'");
		pressKey(editor, '\n');
		assertState("  '\n|'", editor);
	}
	
	public void testIndentationEdit_2() throws Exception {
		XtextEditor editor = openEditor("  |");
		pressKey(editor, '\n');
		assertState("  \n  |", editor);
	}
	
	public void testIndentationEdit_3() throws Exception {
		XtextEditor editor = openEditor("  '''\n  |\n'''");
		pressKey(editor, '\n');
		assertState("  '''\n  \n  |\n'''", editor);
	}
	
	public void testCurlyBracesBlockInRichString_1() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '{');
		assertState("'''{|'''", editor);
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
		pressKey(editor, '\n');
		assertState("'''{\n\t\n\t|\n}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_2() throws Exception {
		XtextEditor editor = openEditor("'''{|\n}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_3() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '}');
		assertState("'''}|'''", editor);
	}

	public void testCurlyBracesBlockInRichString_4() throws Exception {
		XtextEditor editor = openEditor("'''foo {|'''");
		pressKey(editor, '\n');
		assertState("'''foo {\n\t|\n}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_5() throws Exception {
		XtextEditor editor = openEditor("'''{|}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_6() throws Exception {
		XtextEditor editor = openEditor("'''{| }'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_7() throws Exception {
		XtextEditor editor = openEditor("'''{ |foo }'''");
		pressKey(editor, '\n');
		assertState("'''{ \n\t|foo\n}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_8() throws Exception {
		XtextEditor editor = openEditor("'''{ foo| }'''");
		pressKey(editor, '\n');
		assertState("'''{ foo\n| }'''", editor);
	}

	public void testCurlyBracesBlockInRichString_9() throws Exception {
		XtextEditor editor = openEditor("'''\"{\" foo| }'''");
		pressKey(editor, '\n');
		assertState("'''\"{\" foo\n| }'''", editor);
	}

	public void testCurlyBracesBlockInRichString_10() throws Exception {
		XtextEditor editor = openEditor("'''/*{*/ foo|'''");
		pressKey(editor, '\n');
		assertState("'''/*{*/ foo\n|'''", editor);
	}
	
	public void testCurlyBracesBlockInRichString_11() throws Exception {
		XtextEditor editor = openEditor("'''{|}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_12() throws Exception {
		XtextEditor editor = openEditor("'''{foo|}'''");
		pressKey(editor, '\n');
		assertState("'''{foo\n|}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_13() throws Exception {
		XtextEditor editor = openEditor("'''{foo|bar}'''");
		pressKey(editor, '\n');
		assertState("'''{foo\n|bar}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_14() throws Exception {
		XtextEditor editor = openEditor("'''{\nfoo|bar}'''");
		pressKey(editor, '\n');
		assertState("'''{\nfoo\n|bar}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_15() throws Exception {
		XtextEditor editor = openEditor("'''{\nfoo}|{bar}'''");
		pressKey(editor, '\n');
		assertState("'''{\nfoo}\n|{bar}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_16() throws Exception {
		XtextEditor editor = openEditor("'''{\n|}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\n|}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_17() throws Exception {
		XtextEditor editor = openEditor("'''{\n|'''");
		pressKey(editor, '\n');
		assertState("'''{\n\n|\n}'''", editor);
	}

	public void testCurlyBracesBlockInRichString_18() throws Exception {
		XtextEditor editor = openEditor("'''{{foo}|{bar}}'''");
		pressKey(editor, '\n');
		assertState("'''{{foo}\n|{bar}}'''", editor);
	}
	
	public void testRichStringLiteral_01() throws Exception {
		XtextEditor editor = openEditor("''|");
		pressKey(editor, '\'');
		assertState("'''|'''", editor);
		pressKey(editor, '\'');
		assertState("''''|''", editor);
		pressKey(editor, '\'');
		assertState("'''''|'", editor);
		pressKey(editor, '\'');
		assertState("''''''|", editor);
	}
	
	public void testRichStringLiteral_02() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '\n');
		assertState("'''\n|'''", editor);
	}
	
	public void testRichStringLiteral_03() throws Exception {
		XtextEditor editor = openEditor("  '''|'''");
		pressKey(editor, '\n');
		assertState("  '''\n  |'''", editor);
	}
	
	public void testRichStringLiteral_04() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '\"');
		assertState("'''\"|\"'''", editor);
	}
	
	public void testRichStringLiteral_05() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '«');
		assertState("'''«|»'''", editor);
	}
	
	public void testRichStringLiteral_06() throws Exception {
		XtextEditor editor = openEditor("'''«foobar|»'''");
		pressKey(editor, '»');
		assertState("'''«foobar»|'''", editor);
	}
	
	public void testRichStringLiteral_07() throws Exception {
		XtextEditor editor = openEditor("'''«|»'''");
		pressKey(editor, SWT.BS);
		assertState("'''|'''", editor);
	}
	
	public void testRichStringLiteral_08() throws Exception {
		XtextEditor editor = openEditor("''' foobar |'''");
		pressKey(editor, '\'');
		assertState("''' foobar '|''", editor);
		pressKey(editor, '\'');
		assertState("''' foobar ''|'", editor);
		pressKey(editor, '\'');
		assertState("''' foobar '''|", editor);
	}
	
	public void testRichStringLiteral_09() throws Exception {
		XtextEditor editor = openEditor("''' |«foobar» '''");
		pressKey(editor, '«');
		assertState("''' «|»«foobar» '''", editor);
		pressKey(editor, 'a');
		assertState("''' «a|»«foobar» '''", editor);
		pressKey(editor, '»');
		assertState("''' «a»|«foobar» '''", editor);
	}
	
	public void testRichStringLiteral_10() throws Exception {
		XtextEditor editor = openEditor("''' «foobar» |'''");
		pressKey(editor, '\'');
		assertState("''' «foobar» '|''", editor);
		pressKey(editor, '\'');
		assertState("''' «foobar» ''|'", editor);
		pressKey(editor, '\'');
		assertState("''' «foobar» '''|", editor);
	}
	
	@Override
	public void testSingleQuotedStringLiteral_3() throws Exception {
		XtextEditor editor = openEditor("|'");
		pressKey(editor, '\'');
		assertState("'|'", editor);
		pressKey(editor, '\'');
		assertState("''|", editor);
		pressKey(editor, '\'');
		assertState("'''|'''", editor);
	}
	
}