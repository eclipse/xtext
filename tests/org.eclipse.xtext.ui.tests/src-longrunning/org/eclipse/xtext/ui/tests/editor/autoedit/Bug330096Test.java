/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.junit4.ui.AbstractCStyleLanguageAutoEditTest;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.testlanguages.backtracking.ui.internal.BeeLangTestLanguageActivator;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Bug330096Test extends AbstractCStyleLanguageAutoEditTest {

	private static final String TESTPROJECT_NAME = "foo";
	
	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguage";
	}

	@Override
	protected String getFileExtension() {
		return "simplebeelangtestlanguage";
	}
	
	@Test public void testNoException() throws Exception {
		XtextEditor editor = openEditor("unit |a ;");
		selectText(editor, 0, 1);
		pressKey(editor, '"');
		assertState("unit \"|\" ;", editor);
	}
	
	private static IProject staticProject;
	
	@BeforeClass
	public static void createProject() throws Exception {
		staticProject = createPluginProject(TESTPROJECT_NAME);
		JavaProjectSetupUtil.setUnixLineEndings(staticProject);
	}
	
	public static void deleteProject() throws Exception {
		deleteProject(staticProject);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(TESTPROJECT_NAME);
		if (!project.exists())
			createPluginProject(TESTPROJECT_NAME);
	}
	
	protected static IProject createPluginProject(String name) throws CoreException {
		Injector injector = BeeLangTestLanguageActivator.getInstance().getInjector("org.eclipse.xtext.testlanguages.backtracking.SimpleBeeLangTestLanguage");
		PluginProjectFactory projectFactory = injector.getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(
			JavaCore.BUILDER_ID, 
			"org.eclipse.pde.ManifestBuilder",
			"org.eclipse.pde.SchemaBuilder",
			XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature", XtextProjectHelper.NATURE_ID);
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		return result;
	}
	
	public static void deleteProject(IProject project) throws CoreException {
		if (project.exists()) {
			project.delete(true, true, null);
		}
	}
}
