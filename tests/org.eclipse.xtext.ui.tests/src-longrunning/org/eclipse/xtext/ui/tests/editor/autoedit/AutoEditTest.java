/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.autoedit;

import java.util.Collections;

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
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AutoEditTest extends AbstractCStyleLanguageAutoEditTest {
	
	private static final String TESTPROJECT_NAME = "foo";

	private IProject autoEditTestProject;

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.editor.bracketmatching.BmTestLanguage";
	}

	@Override
	protected String getFileExtension() {
		return "bmtestlanguage";
	}

	@Test public void testLongTerminalsBlock_1() throws Exception {
		XtextEditor editor = openEditor("begin|");
		pressKey(editor, '\n');
		assertState("begin\n\t|\nend", editor);
	}

	@Test public void testLongTerminalsBlock_2() throws Exception {
		XtextEditor editor = openEditor("begin|\nend");
		pressKey(editor, '\n');
		assertState("begin\n\t|\nend", editor);
	}

	@Test public void testShortcut_1() throws Exception {
		XtextEditor editor = openEditor("fb|");
		pressKey(editor, 'b');
		assertState("foobarbaz|", editor);
		// Don't know how to simulate the press ESC scenario. The following does not work.
		pressKey(editor, SWT.ESC);
		assertState("fbb|", editor);
	}
	
	@Test public void testClosingTerminalNextToDifferentPartition() throws Exception {
		XtextEditor editor = openEditor("{|\n}'foo'");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}'foo'", editor);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		autoEditTestProject = ResourcesPlugin.getWorkspace().getRoot().getProject(TESTPROJECT_NAME);
		if (!autoEditTestProject.exists())
			createPluginProject(TESTPROJECT_NAME);
	}

	protected IProject createPluginProject(String name) throws CoreException {
		Injector injector = org.eclipse.xtext.ui.tests.Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.editor.bracketmatching.BmTestLanguage");
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
