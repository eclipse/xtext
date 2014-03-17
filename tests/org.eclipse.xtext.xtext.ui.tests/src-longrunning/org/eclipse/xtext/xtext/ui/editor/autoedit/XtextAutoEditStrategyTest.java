/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.autoedit;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.junit4.ui.AbstractCStyleLanguageAutoEditTest;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.xtext.ui.internal.Activator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Michael Clay - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XtextAutoEditStrategyTest extends AbstractCStyleLanguageAutoEditTest {
	private static final String SAMPLE_HEADER = "grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals\ngenerate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"\n";
	private static final String TESTPROJECT_NAME = "autoedit";
	private IProject autoEditTestProject;

	@Override
	protected String getFileExtension() {
		return "xtext";
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.Xtext";
	}
	
	private static IProject project;
	
	@BeforeClass
	public static void setUpProject() throws Exception {
		project = createPluginProject(TESTPROJECT_NAME);
		JavaProjectSetupUtil.setUnixLineEndings(project);
	}
	
	@AfterClass
	public static void tearDownProject() throws Exception {
		deleteProject(project);
	}

	@Override
	protected XtextEditor openEditor(String string) throws Exception {
		int cursor = string.indexOf('|');
		String fileExtension = getFileExtension();
		IFile file = createFile(TESTPROJECT_NAME + "/myfile" + getFiles().size() + "." + fileExtension,
				string.replace("|", ""));
		getFiles().add(file);
		XtextEditor editor = openEditor(file);
		editor.getInternalSourceViewer().setSelectedRange(cursor, 0);
		editor.getInternalSourceViewer().getTextWidget().setFocus();
		return editor;
	}

	@Test public void testParenthesis___01() throws Exception {
		XtextEditor editor = openEditor(SAMPLE_HEADER + "Greeting|: 'Hello' name=ID'!';");
		pressKey(editor, '(');
		assertState(SAMPLE_HEADER + "Greeting(|): 'Hello' name=ID'!';", editor);
		pressKey(editor, SWT.BS);
		assertState(SAMPLE_HEADER + "Greeting|: 'Hello' name=ID'!';", editor);
	}

	@Test public void testParenthesis___02() throws Exception {
		XtextEditor editor = openEditor(SAMPLE_HEADER + "Greeting: 'Hello' name=ID'!'|;");
		pressKey(editor, '(');
		assertState(SAMPLE_HEADER + "Greeting: 'Hello' name=ID'!'(|);", editor);
		pressKey(editor, SWT.BS);
		assertState(SAMPLE_HEADER + "Greeting: 'Hello' name=ID'!'|;", editor);
	}

	@Test public void testParenthesis___03() throws Exception {
		XtextEditor editor = openEditor(SAMPLE_HEADER + "Greeting:| 'Hello' name=ID'!';");
		pressKey(editor, '(');
		assertState(SAMPLE_HEADER + "Greeting:(|) 'Hello' name=ID'!';", editor);
		pressKey(editor, SWT.BS);
		assertState(SAMPLE_HEADER + "Greeting:| 'Hello' name=ID'!';", editor);
	}

	@Test public void testBug338838() throws Exception {
		XtextEditor editor = openEditor(SAMPLE_HEADER + 
				"Statemachine:\n" + 
				"    {Statemachine}\n" + 
				"    'events' 'end' 'xyzzy|\n" + 
				";");
		pressKey(editor, '\'');
		assertState(SAMPLE_HEADER + 
				"Statemachine:\n" + 
				"    {Statemachine}\n" + 
				"    'events' 'end' 'xyzzy'|\n" + 
				";", editor);
	}
	
	@Override
	@Test public void testBug335634_04() throws Exception {
		XtextEditor editor = openEditor(
				"// ML_COMMENT PATTERN: '/ *' '/'* ( !('*' '/') !'*' '/' '*' !'/')* '*'+ '/'\n" + 
				"//|");
		pressKey(editor, '\n');
		assertState(
				"// ML_COMMENT PATTERN: '/ *' '/'* ( !('*' '/') !'*' '/' '*' !'/')* '*'+ '/'\n" + 
				"//\n|", editor);
	}
	
	@Test public void testBug346032_00() throws Exception {
		XtextEditor editor = openEditor(
				"grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar|");
		pressKey(editor, ':');
		assertState("grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar:|;", 
				editor);
	}

	@Test public void testBug346032_01() throws Exception {
		XtextEditor editor = openEditor(
				"grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar:|");
		pressKey(editor, ':');
		assertState("grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar::|", 
				editor);
	}
	
	@Test public void testBug346032_02() throws Exception {
		XtextEditor editor = openEditor(
				"grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar returns foo|");
		pressKey(editor, ':');
		assertState("grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar returns foo:|", 
				editor);
	}
	
	@Test public void testBug346032_03() throws Exception {
		XtextEditor editor = openEditor(
				"grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar returns foo|");
		pressKey(editor, ':');
		assertState("grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar returns foo:|", 
				editor);
	}
	
	@Test public void testBug346032_04() throws Exception {
		XtextEditor editor = openEditor(
				"grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar // returns foo\n" +
				"|");
		pressKey(editor, ':');
		assertState("grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar // returns foo\n" +
				":|;", 
				editor);
	}
	
	@Test public void testBug346032_05() throws Exception {
		XtextEditor editor = openEditor(
				"grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar returns foo::bar|");
		pressKey(editor, ':');
		assertState("grammar foo\n" +
				"generate foo 'foo' as foo" + 
				"Bar returns foo::bar:|;", 
				editor);
	}
	
	@Test public void testBug346652_01() throws Exception {
		XtextEditor editor = openEditor(
				SAMPLE_HEADER  +
				"Greeting:\n" +
				"\t('Hello' name=ID '!'|");
		pressKey(editor, '\n');
		assertState(SAMPLE_HEADER  +
				"Greeting:\n" +
				"\t('Hello' name=ID '!'\n" +
				"\t\t|\n" +
				"\t)", 
				editor);
	}
	
	@Test public void testBug346652_02() throws Exception {
		XtextEditor editor = openEditor(
				SAMPLE_HEADER  +
				"Greeting:\n" +
				"\t|'Hello' name=ID '!';");
		pressKey(editor, '(');
		assertState(SAMPLE_HEADER  +
				"Greeting:\n" +
				"\t(|'Hello' name=ID '!';", 
				editor);
	}
	
	@Test public void testBug369087() throws Exception {
		XtextEditor editor = openEditor(
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.xbase.Xbase\n" +
			    "\n" +
			    "generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"\n" +
			    "\n" +
				"Model:\n" +
				"    'package' name=QualifiedName '{'|" +
				";");
		pressKey(editor, ' ');
		pressKey(editor, '\n');
		assertState(
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.xbase.Xbase\n" +
			    "\n" +
			    "generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"\n" +
			    "\n" +
				"Model:\n" +
				"    'package' name=QualifiedName '{' \n" +
				"    |;",
				editor);
	}
	
	@Test public void testBug412779() throws Exception {
		XtextEditor editor = openEditor(
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.xbase.Xbase\n" +
				"\n" +
				"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"\n" +
				"\n" +
				"A:\n" +
				"\n" +
				"B:|");
		pressKey(editor, '\n');
		assertState(
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.xbase.Xbase\n" +
				"\n" +
				"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"\n" +
				"\n" +
				"A:\n" +
				"\n" +
				"B:\n" +
				"\t|\n" +
				";" , editor);
		pressKey(editor, '\n');
		assertState(
				"grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.xbase.Xbase\n" +
				"\n" +
				"generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"\n" +
				"\n" +
				"A:\n" +
				"\n" +
				"B:\n" +
				"\t\n" +
				"\t|\n" +
				";" , editor);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		autoEditTestProject = ResourcesPlugin.getWorkspace().getRoot().getProject(TESTPROJECT_NAME);
		if (!autoEditTestProject.exists())
			createPluginProject(TESTPROJECT_NAME);
	}

	public static void deleteProject(IProject project) throws CoreException {
		if (project.exists()) {
			project.delete(true, true, null);
		}
	}

	protected static IProject createPluginProject(String name) throws CoreException {
		Injector injector = Activator.getInstance().getInjector("org.eclipse.xtext.Xtext");
		PluginProjectFactory projectFactory = injector.getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(XtextProjectHelper.NATURE_ID);
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		JavaProjectSetupUtil.setUnixLineEndings(result);
		return result;
	}
	
}
