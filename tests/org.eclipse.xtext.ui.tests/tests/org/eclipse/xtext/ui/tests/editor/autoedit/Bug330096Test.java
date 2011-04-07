/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.autoedit;

import java.util.Collections;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.testlanguages.backtracking.ui.internal.BeeLangTestLanguageActivator;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.junit.editor.autoedit.AbstractCStyleLanguageAutoEditTest;
import org.eclipse.xtext.ui.util.PluginProjectFactory;

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
	
	public void testNoException() throws Exception {
		XtextEditor editor = openEditor("unit |a ;");
		selectText(editor, 0, 1);
		pressKey(editor, '"');
		assertState("unit \"|\" ;", editor);
	}

	public static Test suite(Class<? extends AutoEditTest> clazz) {
		return new TestSetup(new TestSuite(clazz, clazz.getCanonicalName())) {
			private IProject project;
			
			@Override
			protected void setUp() throws Exception {
				super.setUp();
				project = createPluginProject(TESTPROJECT_NAME);
			}
			@Override
			protected void tearDown() throws Exception {
				deleteProject(project);
				super.tearDown();
			}
		};
	}
	
	@Override
	protected void setUp() throws Exception {
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
			if (project.isOpen()) {
				project.close(null);
			}
			project.delete(true, true, null);
		}
	}
}
