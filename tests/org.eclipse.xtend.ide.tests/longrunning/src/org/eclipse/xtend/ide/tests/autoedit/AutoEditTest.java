/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.autoedit;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.swt.SWT;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtext.junit4.ui.AbstractCStyleLanguageAutoEditTest;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.util.JREContainerProvider;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AutoEditTest extends AbstractCStyleLanguageAutoEditTest {

	private static final String TESTPROJECT_NAME = "foo";

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtend.core.Xtend";
	}

	@Override
	protected String getFileExtension() {
		return "xtend";
	}
	
	@Override
	protected XtextEditor openEditor(String string) throws Exception {
		int cursor = string.indexOf('|');
		String fileExtension = getFileExtension();
		IFile file = createFile(TESTPROJECT_NAME+"/myfile" + getFiles().size() + "." + fileExtension, string.replace("|", ""));
		getFiles().add(file);
		XtextEditor editor = openEditor(file);
		editor.getInternalSourceViewer().setSelectedRange(cursor, 0);
		editor.getInternalSourceViewer().getTextWidget().setFocus();
		return editor;
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(TESTPROJECT_NAME);
		if (!project.exists()) createPluginProject(TESTPROJECT_NAME);
	}
	
	protected IProject createPluginProject(String name) throws CoreException {
		Injector injector = XtendActivator.getInstance().getInjector("org.eclipse.xtend.core.Xtend");
		PluginProjectFactory projectFactory = injector.getInstance(PluginProjectFactory.class);
		projectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE);
		projectFactory.setProjectName(name);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(
			JavaCore.BUILDER_ID, 
			"org.eclipse.pde.ManifestBuilder",
			"org.eclipse.pde.SchemaBuilder",
			XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", XtextProjectHelper.NATURE_ID);
		projectFactory.addRequiredBundles(newArrayList("org.eclipse.xtext.xbase.lib"));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		JavaProjectSetupUtil.setUnixLineEndings(result);
		return result;
	}
	
	@Test public void testCurlyBraceBlockAndRichStrings_0() throws Exception {
		XtextEditor editor = openEditor("\n{|\n'''«{null}»'''}");
		pressKey(editor, '\n');
		assertState("\n{\n\t|\n'''«{null}»'''}", editor);
	}
	
	@Test public void testIndentationEdit_1() throws Exception {
		XtextEditor editor = openEditor("  '|'");
		pressKey(editor, '\n');
		assertState("  '\n|'", editor);
	}
	
	@Test public void testIndentationEdit_2() throws Exception {
		XtextEditor editor = openEditor("  |");
		pressKey(editor, '\n');
		assertState("  \n  |", editor);
	}
	
	@Test public void testIndentationEdit_3() throws Exception {
		XtextEditor editor = openEditor("  '''\n  |\n'''");
		pressKey(editor, '\n');
		assertState("  '''\n  \n  |\n'''", editor);
	}
	
	@Test public void testCurlyBracesBlockInRichString_1() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '{');
		assertState("'''{|'''", editor);
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
		pressKey(editor, '\n');
		assertState("'''{\n\t\n\t|\n}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_2() throws Exception {
		XtextEditor editor = openEditor("'''{|\n}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_3() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '}');
		assertState("'''}|'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_4() throws Exception {
		XtextEditor editor = openEditor("'''foo {|'''");
		pressKey(editor, '\n');
		assertState("'''foo {\n\t|\n}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_5() throws Exception {
		XtextEditor editor = openEditor("'''{|}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_6() throws Exception {
		XtextEditor editor = openEditor("'''{| }'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_7() throws Exception {
		XtextEditor editor = openEditor("'''{ |foo }'''");
		pressKey(editor, '\n');
		assertState("'''{ \n\t|foo\n}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_8() throws Exception {
		XtextEditor editor = openEditor("'''{ foo| }'''");
		pressKey(editor, '\n');
		assertState("'''{ foo\n| }'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_9() throws Exception {
		XtextEditor editor = openEditor("'''\"{\" foo| }'''");
		pressKey(editor, '\n');
		assertState("'''\"{\" foo\n| }'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_10() throws Exception {
		XtextEditor editor = openEditor("'''/*{*/ foo|'''");
		pressKey(editor, '\n');
		assertState("'''/*{*/ foo\n|'''", editor);
	}
	
	@Test public void testCurlyBracesBlockInRichString_11() throws Exception {
		XtextEditor editor = openEditor("'''{|}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\t|\n}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_12() throws Exception {
		XtextEditor editor = openEditor("'''{foo|}'''");
		pressKey(editor, '\n');
		assertState("'''{foo\n|}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_13() throws Exception {
		XtextEditor editor = openEditor("'''{foo|bar}'''");
		pressKey(editor, '\n');
		assertState("'''{foo\n|bar}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_14() throws Exception {
		XtextEditor editor = openEditor("'''{\nfoo|bar}'''");
		pressKey(editor, '\n');
		assertState("'''{\nfoo\n|bar}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_15() throws Exception {
		XtextEditor editor = openEditor("'''{\nfoo}|{bar}'''");
		pressKey(editor, '\n');
		assertState("'''{\nfoo}\n|{bar}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_16() throws Exception {
		XtextEditor editor = openEditor("'''{\n|}'''");
		pressKey(editor, '\n');
		assertState("'''{\n\n|}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_17() throws Exception {
		XtextEditor editor = openEditor("'''{\n|'''");
		pressKey(editor, '\n');
		assertState("'''{\n\n|\n}'''", editor);
	}

	@Test public void testCurlyBracesBlockInRichString_18() throws Exception {
		XtextEditor editor = openEditor("'''{{foo}|{bar}}'''");
		pressKey(editor, '\n');
		assertState("'''{{foo}\n|{bar}}'''", editor);
	}
	
	@Test public void testRichStringLiteral_01() throws Exception {
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
	
	@Test public void testRichStringLiteral_02() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '\n');
		assertState("'''\n|'''", editor);
	}
	
	@Test public void testRichStringLiteral_03() throws Exception {
		XtextEditor editor = openEditor("  '''|'''");
		pressKey(editor, '\n');
		assertState("  '''\n  |'''", editor);
	}
	
	@Test public void testRichStringLiteral_04() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '\"');
		assertState("'''\"|\"'''", editor);
	}
	
	@Test public void testRichStringLiteral_05() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '«');
		assertState("'''«|»'''", editor);
	}
	
	@Test public void testRichStringLiteral_06() throws Exception {
		XtextEditor editor = openEditor("'''«foobar|»'''");
		pressKey(editor, '»');
		assertState("'''«foobar»|'''", editor);
	}
	
	@Test public void testRichStringLiteral_07() throws Exception {
		XtextEditor editor = openEditor("'''«|»'''");
		pressKey(editor, SWT.BS);
		assertState("'''|'''", editor);
	}
	
	@Test public void testRichStringLiteral_08() throws Exception {
		XtextEditor editor = openEditor("''' foobar |'''");
		pressKey(editor, '\'');
		assertState("''' foobar '|''", editor);
		pressKey(editor, '\'');
		assertState("''' foobar ''|'", editor);
		pressKey(editor, '\'');
		assertState("''' foobar '''|", editor);
	}
	
	@Test public void testRichStringLiteral_09() throws Exception {
		XtextEditor editor = openEditor("''' |«foobar» '''");
		pressKey(editor, '«');
		assertState("''' «|»«foobar» '''", editor);
		pressKey(editor, 'a');
		assertState("''' «a|»«foobar» '''", editor);
		pressKey(editor, '»');
		assertState("''' «a»|«foobar» '''", editor);
	}
	
	@Test public void testRichStringLiteral_10() throws Exception {
		XtextEditor editor = openEditor("''' «foobar» |'''");
		pressKey(editor, '\'');
		assertState("''' «foobar» '|''", editor);
		pressKey(editor, '\'');
		assertState("''' «foobar» ''|'", editor);
		pressKey(editor, '\'');
		assertState("''' «foobar» '''|", editor);
	}
	
	public final void testRichStringLiteral_11() throws Exception {
		XtextEditor editor = openEditor("''' text ''|");
		pressKey(editor, '\'');
		assertState("''' text '''|", editor);
	}
	
	@Override
	@Test public void testSingleQuotedStringLiteral_3() throws Exception {
		XtextEditor editor = openEditor("|'");
		pressKey(editor, '\'');
		assertState("'|'", editor);
		pressKey(editor, '\'');
		assertState("''|", editor);
		pressKey(editor, '\'');
		assertState("'''|'''", editor);
	}
	
	@Test 
	public void testBug434717_01() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"		'''\n" + 
				"		|\n" +
				"		'''\n" + 
				"}\n" + 
				"");
		pasteText(editor, "foo\n" +
						  "\tbar\n"
						  + "foo");
		assertState(
				"genPlainText(Object this){\n" + 
				"		'''\n" + 
				"		foo\n" +
				"			bar\n" +
				"		foo|\n" +
				"		'''\n" + 
				"}\n" + 
				"", editor);
	}
	
	@Test 
	public void testBug434717_02() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"		'''\n" + 
				"		|\n" +
				"		'''\n" + 
				"}\n" + 
				"");
		pasteText(editor, "\tfoo\n" +
						  "\t\tbar\n"
						  + "\tfoo");
		assertState(
				"genPlainText(Object this){\n" + 
				"		'''\n" + 
				"			foo\n" +
				"				bar\n" +
				"			foo|\n" +
				"		'''\n" + 
				"}\n" + 
				"", editor);
	}
	
	@Test 
	public void testBug434717_03() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"		'''|'''\n" + 
				"}\n" + 
				"");
		pasteText(editor, "\tfoo\n" +
						  "\t\tbar\n"
						  + "\tfoo");
		assertState(
				"genPlainText(Object this){\n" + 
				"		'''	foo\n" +
				"				bar\n" +
				"			foo|'''\n" + 
				"}\n" + 
				"", editor);
	}
	
	@Test 
	public void testBug434717_04() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"		'''|'''" + 
				"");
		pasteText(editor, "\tfoo\n" +
						  "\t\tbar\n"
						  + "\tfoo");
		assertState(
				"genPlainText(Object this){\n" + 
				"		'''	foo\n" +
				"				bar\n" +
				"			foo|'''" + 
				"", editor);
	}
	
	@Test 
	public void testBug434717_05() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"		'''|'''" + 
				"");
		pasteText(editor, "\tfoo\r" +
						  "\t\tbar\r"
						  + "\tfoo");
		assertState(
				"genPlainText(Object this){\n" + 
				"		'''	foo\n" +
				"				bar\n" +
				"			foo|'''" + 
				"", editor);
	}
	
	@Test 
	public void testBug434717_06() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"		'''|'''" + 
				"");
		pasteText(editor, "\tfoo\r" +
						  "\t\tbar\r\n"
						  + "\tfoo");
		assertState(
				"genPlainText(Object this){\n" + 
				"		'''	foo\n" +
				"				bar\n" +
				"			foo|'''" + 
				"", editor);
	}
	
	@Test 
	public void testBug434717_07() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"		'''\n" + 
				"			|\n" + 
				"		'''" + 
				"");
		pasteText(editor, "aaa\n" +
						  "  \n" + 
						  "  bbb\n"+
						  " \n" + 
						  " ccc\n");
		assertState(
				"genPlainText(Object this){\n" + 
						"		'''\n" + 
						"			aaa\n" + 
						"			  \n" + 
						"			  bbb\n" + 
						"			 \n" + 
						"			 ccc|\n" + 
						"		'''" + 
						"", editor);
	}
	
	@Test 
	public void testBug434717_08() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"		'''|'''" + 
				"");
		pasteText(editor, "aaa\n" +
						  "  \n" + 
						  "  bbb\n"+
						  " \n" + 
						  " ccc\n");
		assertState(
				"genPlainText(Object this){\n" + 
						"		'''aaa\n" + 
						"		  \n" + 
						"		  bbb\n" + 
						"		 \n" + 
						"		 ccc|'''" + 
						"", editor);
	}
	
	@Test
	public void testWindowsLineDelimiter() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pasteText(editor, "\r\n");
		assertState("'''" + "\r\n" + "|'''", editor);
	}
	
	@Test public void testBug342030_01() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"    '''|'''\n" + 
				"}\n" + 
				"");
		pasteText(editor, "foo.bar");
		assertState("genPlainText(Object this){\n" + 
				"    '''foo.bar|'''\n" + 
				"}\n" + 
				"", editor);
	}
	
	@Test public void testBug342030_02() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"    '''|'''\n" + 
				"}\n" + 
				"");
		pasteText(editor, "'''");
		assertState("genPlainText(Object this){\n" + 
				"    ''''''|'''\n" + 
				"}\n" + 
				"", editor);
	}
	
	@Test public void testBug342030_03() throws Exception {
		XtextEditor editor = openEditor(
				"genPlainText(Object this){\n" + 
				"    '''|'''\n" + 
				"}\n" + 
				"");
		pressKeys(editor, "'''");
		assertState("genPlainText(Object this){\n" + 
				"    ''''''|\n" + 
				"}\n" + 
				"", editor);
	}
	
	// The following generic auto edit assumptions don't hold for xtend
	// because of the rich string delimiter '''
	@Override
	@Test public void testSingleQuotedStringLiteral_14() throws Exception {
		XtextEditor editor = openEditor("|'test'");
		pressKey(editor, '\'');
		assertState("'|''test'", editor);
//		pressKey(editor, '\'');
//		assertState("''|'test'", editor);
//		pressKey(editor, '\'');
//		assertState("'''|test'", editor);
	}
	
	@Override
	@Test public void testSingleQuotedStringLiteral_15() throws Exception {
//		XtextEditor editor = openEditor("'|''test'");
//		pressKey(editor, '\'');
//		assertState("''|'test'", editor);
//		pressKey(editor, '\'');
//		assertState("'''|''test'", editor);
	}
}