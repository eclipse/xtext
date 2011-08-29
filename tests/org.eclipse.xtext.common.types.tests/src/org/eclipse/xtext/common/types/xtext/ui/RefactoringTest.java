/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.refactoring.RenameSupport;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.tests.AbstractActivator;
import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.junit.editor.AbstractEditorTest;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.IRenameSupport;
import org.eclipse.xtext.ui.refactoring.ui.RenameElementHandler;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class RefactoringTest extends AbstractEditorTest {

	private IFile javaFile;
	private IFile xtextFile;
	private LanguageServices languageServices;
	private XtextEditor editor;
	private IJavaProject javaProject;

	public static class LanguageServices {
		@Inject
		IRenameSupport.Factory renameSupportFactory;

		@Inject
		RenameElementHandler renameElementHandler;
	}

	@Override
	protected void setUp() throws Exception {
		closeWelcomePage();
		closeEditors();
		waitForAutoBuild();
		javaProject = createJavaProject("RefactoringTest");
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		javaFile = createFile("RefactoringTest/src/test/JavaClass.java", "package test; public class JavaClass {}");
		xtextFile = createFile("RefactoringTest/src/test/test.typesAssistTest", "default test.JavaClass");
		languageServices = AbstractActivator.getInstance().getInjector(getEditorId()).getInstance(LanguageServices.class);
		editor = openEditor(xtextFile);
		waitForAutoBuild();
	}
	
	
	@Override
	protected void tearDown() throws Exception {
		closeEditors();
		javaProject.getProject().delete(true, new NullProgressMonitor());
		waitForAutoBuild();
	}
	
	public void testRenameFromXtext() throws Exception {
		IRenameElementContext renameElementContext = editor.getDocument().readOnly(
				new IUnitOfWork<IRenameElementContext, XtextResource>() {
					public IRenameElementContext exec(XtextResource state) throws Exception {
						Model model = (Model) state.getContents().get(0);
						JvmType defaultReference = model.getReferenceHolder().getDefaultReference();
						return languageServices.renameElementHandler.createRenameElementContext(defaultReference,
								editor, null, state);
					}
				});
		IRenameSupport renameSupport = languageServices.renameSupportFactory.create(renameElementContext,
				"NewJavaClass");
		assertNotNull(renameSupport);
		renameSupport.startDirectRefactoring();
		assertRefactoringSuccessful();
	}

	public void testRenameFromJava() throws Exception {
		IWorkbench workbench = PlatformUI.getWorkbench();
		RenameSupport renameSupport = RenameSupport.create(javaProject.findType("test.JavaClass"), "NewJavaClass", RenameSupport.UPDATE_REFERENCES);
		renameSupport
			.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());	
		assertRefactoringSuccessful();		
	}

	protected void assertRefactoringSuccessful() throws JavaModelException {
		waitForAutoBuild();
		assertEquals("default test.NewJavaClass", editor.getDocument().get());
		assertFalse(javaFile.exists());
		assertNull(javaProject.findType("test.JavaClass"));
		assertTrue(javaProject.findType("test.NewJavaClass").exists());
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.common.types.xtext.ui.ContentAssistTestLanguage";
	}
}
