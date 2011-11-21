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
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.ErrorEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtend2.ui.internal.Xtend2Activator;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
@Singleton
public class WorkbenchTestHelper extends Assert {
	
	public static final Logger log = Logger.getLogger(WorkbenchTestHelper.class);  
	
	public static final String TESTPROJECT_NAME = "test.project";

	private Set<IFile> files = newHashSet();

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private IWorkbench workbench;

	@Inject
	private IWorkspace workspace;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	private boolean isLazyCreatedProject = false;

	public void tearDown() throws Exception {
		workbench.getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
		for (IFile file : getFiles()) {
			try {
				file.delete(true, null);
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		getFiles().clear();
		IFolder binFolder = getProject().getFolder("bin");
		if (binFolder.exists()) {
			for (IResource binMember : binFolder.members()) {
				try {
					binMember.delete(IResource.DEPTH_INFINITE, null);
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		}
		if (isLazyCreatedProject) {
			getProject().delete(true, null);
			isLazyCreatedProject = false;
		} 
	}

	public Set<IFile> getFiles() {
		return files;
	}

	public IProject getProject() {
		IProject project = workspace.getRoot().getProject(TESTPROJECT_NAME);
		if (!project.exists()) {
			try {
				isLazyCreatedProject = true;
				project = createPluginProject(TESTPROJECT_NAME);
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
		return project;
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
		String fullFileName = getFullFileName(fileName);
		return createFileImpl(fullFileName, content);
	}
	
	public IFile createFileImpl(String fullFileName, String content) throws Exception {
		IFile file = IResourcesSetupUtil.createFile(fullFileName,
				content);
		getFiles().add(file);
		return file;
	}
	
	public IFile getFile(String fileName) {
		return workspace.getRoot().getFile(new Path(getFullFileName(fileName)));
	}

	protected String getFullFileName(String fileName) {
		String extension = (fileName.indexOf(".") != -1) ? "" : "." + getFileExtension();
		String fullFileName = TESTPROJECT_NAME + "/src/" + fileName + extension;
		return fullFileName;
	}
	
	public String getFileExtension() {
		return fileExtensionProvider.getFileExtensions().iterator().next();
	}
	
	public URI uri(IFile file) {
		return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	}
	
	public XtendFile xtendFile(String fileName, String content) throws Exception {
		IFile file = createFile(fileName, content);
		Resource resource = getResourceSet().createResource(uri(file));
		resource.load(new StringInputStream(content), null);
		assertEquals(resource.getErrors().toString(), 0, resource.getErrors().size());
		XtendFile xtendFile = (XtendFile) resource.getContents().get(0);
		return xtendFile;
	}

	public ResourceSet getResourceSet() {
		ResourceSet resourceSet = resourceSetProvider.get(getProject());
		return resourceSet;
	}
	
	public String getEditorID() {
		return languageName;
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

	public static Test suite(Class<? extends TestCase> clazz) {
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

	public static IProject createPluginProject(String name) throws CoreException {
		Injector injector = Xtend2Activator.getInstance().getInjector("org.eclipse.xtext.xtend2.Xtend2");
		PluginProjectFactory projectFactory = injector.getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(JavaCore.BUILDER_ID, "org.eclipse.pde.ManifestBuilder",
				"org.eclipse.pde.SchemaBuilder", XtextProjectHelper.BUILDER_ID);
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature",
				XtextProjectHelper.NATURE_ID);
		projectFactory.addRequiredBundles(newArrayList(
				"com.google.inject",
				"org.eclipse.xtext.xbase.lib", 
				"org.eclipse.xtend2.lib",
				"org.junit4"));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		IJavaProject javaProject = JavaCore.create(result);
		JavaProjectSetupUtil.makeJava5Compliant(javaProject);
		JavaProjectSetupUtil.addJre15ClasspathEntry(javaProject);
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

	public XtextEditor openEditor(IFile file) throws Exception {
		IEditorPart openEditor = openEditor(file, getEditorID());
		XtextEditor xtextEditor = EditorUtils.getXtextEditor(openEditor);
		if (xtextEditor != null) {
			return xtextEditor;
		} else if (openEditor instanceof ErrorEditorPart) {
			Field field = openEditor.getClass().getDeclaredField("error");
			field.setAccessible(true);
			throw new IllegalStateException("Couldn't open the editor.",
					((Status) field.get(openEditor)).getException());
		} else {
			fail("Opened Editor with id:" + getEditorID() + ", is not an XtextEditor");
		}
		return null;
	}

	protected IEditorPart openEditor(IFile file, String editorId) throws PartInitException {
		return workbench.getActiveWorkbenchWindow().getActivePage().openEditor(new FileEditorInput(file), editorId);
	}

	public void setUp() {
		getProject();
	}

}
