/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.autoedit;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.junit.editor.autoedit.AbstractAutoEditTest;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.xtext.ui.internal.Activator;

import com.google.inject.Injector;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextAutoEditStrategyTest extends AbstractAutoEditTest {
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

	public void testParenthesis_1() throws Exception {
		XtextEditor editor = openEditor(SAMPLE_HEADER + "Greeting|: 'Hello' name=ID'!';");
		pressKey(editor, '(');
		assertState(SAMPLE_HEADER + "Greeting(|): 'Hello' name=ID'!';", editor);
		pressKey(editor, SWT.BS);
		assertState(SAMPLE_HEADER + "Greeting|: 'Hello' name=ID'!';", editor);
	}

	public void testParenthesis_2() throws Exception {
		XtextEditor editor = openEditor(SAMPLE_HEADER + "Greeting: 'Hello' name=ID'!'|;");
		pressKey(editor, '(');
		assertState(SAMPLE_HEADER + "Greeting: 'Hello' name=ID'!'(|);", editor);
		pressKey(editor, SWT.BS);
		assertState(SAMPLE_HEADER + "Greeting: 'Hello' name=ID'!'|;", editor);
	}

	public void testParenthesis_3() throws Exception {
		XtextEditor editor = openEditor(SAMPLE_HEADER + "Greeting:| 'Hello' name=ID'!';");
		pressKey(editor, '(');
		assertState(SAMPLE_HEADER + "Greeting:(|) 'Hello' name=ID'!';", editor);
		pressKey(editor, SWT.BS);
		assertState(SAMPLE_HEADER + "Greeting:| 'Hello' name=ID'!';", editor);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		autoEditTestProject = ResourcesPlugin.getWorkspace().getRoot().getProject(TESTPROJECT_NAME);
		if (!autoEditTestProject.exists()) {
			createPluginProject(TESTPROJECT_NAME);
		}
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		deleteProject(autoEditTestProject);
	}

	public void deleteProject(IProject project) throws CoreException {
		if (project.exists()) {
			if (project.isOpen()) {
				project.close(null);
			}
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
		return result;
	}

}
