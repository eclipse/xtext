/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;

import junit.extensions.TestSetup;
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.ErrorEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.xtend2.ui.internal.Xtend2Activator;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class Xtend2WorkbenchTestHelper extends Assert {

	public static final String TESTPROJECT_NAME = "foo";

	public static final String EDITOR_ID = "org.eclipse.xtext.xtend2.Xtend2";

	public static final String FILE_EXTENSION = "xtend";
	
	private Set<IFile> files = newHashSet();
	
	@Inject
	private IWorkbench workbench;
	
	public void tearDown() {
		workbench.getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
		for(IFile file: getFiles()) {
			try {
				file.delete(true, null);
			} catch(Exception exc) {
				exc.printStackTrace();
			}
		}
	}
	
	public Set<IFile> getFiles() {
		return files;
	}

	public XtextEditor openEditor(String fileName, String content) throws Exception {
		int cursor = content.indexOf('|');
		IFile file = createFile(fileName, content.replace("|", ""));
		XtextEditor editor = openEditor(file);
		editor.getInternalSourceViewer().setSelectedRange(cursor, 0);
		editor.getInternalSourceViewer().getTextWidget().setFocus();
		return editor;
	}
	

	public IFile createFile(String fileName, String content) throws Exception {
		IFile file = IResourcesSetupUtil.createFile(TESTPROJECT_NAME + "/src/" + fileName + "." + FILE_EXTENSION, content);
		getFiles().add(file);
		return file;
	}
	
	public String getContents(IFile file) throws Exception {
		InputStream inputStream = file.getContents();
		try {
			byte[] buffer = new byte[2048];
			int bytesRead = 0;
			StringBuffer b = new StringBuffer();
			do {
				bytesRead = inputStream.read(buffer);
				if (bytesRead != -1)
					b.append(new String(buffer, 0, bytesRead));
			} while (bytesRead != -1);
			return b.toString();
		} finally {
			inputStream.close();
		}
	}

	public static Test suite(Class<? extends AbstractXtend2UITestCase> clazz) {
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

	protected static IProject createPluginProject(String name) throws CoreException {
		Injector injector = Xtend2Activator.getInstance().getInjector("org.eclipse.xtext.xtend2.Xtend2");
		PluginProjectFactory projectFactory = injector.getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(JavaCore.BUILDER_ID, "org.eclipse.pde.ManifestBuilder",
				"org.eclipse.pde.SchemaBuilder", XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature",
				XtextProjectHelper.NATURE_ID);
		projectFactory.addRequiredBundles(newArrayList("org.eclipse.xtext.xbase.lib", "org.eclipse.xtext.xtend2.lib"));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		return result;
	}

	protected static void deleteProject(IProject project) throws CoreException {
		if (project.exists()) {
			if (project.isOpen()) {
				project.close(null);
			}
			project.delete(true, true, null);
		}
	}

	protected XtextEditor openEditor(IFile file) throws Exception {
		IEditorPart openEditor = openEditor(file, EDITOR_ID);
		XtextEditor xtextEditor = EditorUtils.getXtextEditor(openEditor);
		if (xtextEditor != null) {
			return xtextEditor;
		} else if (openEditor instanceof ErrorEditorPart) {
			Field field = openEditor.getClass().getDeclaredField("error");
			field.setAccessible(true);
			throw new IllegalStateException("Couldn't open the editor.",
					((Status) field.get(openEditor)).getException());
		} else {
			fail("Opened Editor with id:" + EDITOR_ID + ", is not an XtextEditor");
		}
		return null;
	}

	protected IEditorPart openEditor(IFile file, String editorId) throws PartInitException {
		return workbench.getActiveWorkbenchWindow().getActivePage()
				.openEditor(new FileEditorInput(file), editorId);
	}

}
