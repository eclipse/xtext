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
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.tests.AbstractActivator;
import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.Model;
import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.ReferenceHolder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.junit.editor.AbstractEditorTest;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementHandler;
import org.eclipse.xtext.ui.refactoring.ui.IRenameSupport;
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
	private String languageNameSuffix = "";
	private IWorkbenchWindow activeWorkbenchWindow;

	public static class LanguageServices {
		@Inject(optional=true)
		IRenameSupport.Factory renameSupportFactory;

		@Inject(optional=true)
		IRenameElementHandler renameElementHandler;
		
		public boolean hasRefactoring() {
			return renameSupportFactory != null && renameElementHandler != null;
		}
	}

	@Override
	protected void setUp() throws Exception {
		closeWelcomePage();
		closeEditors();
		javaProject = createJavaProject("RefactoringTest");
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	}
	
	@Override
	protected void tearDown() throws Exception {
		closeEditors();
		javaProject.getProject().delete(true, new NullProgressMonitor());
		waitForAutoBuild();
	}
	
	protected void setLanguageConfig(boolean hasRefactoring, boolean usesJdtRefactoring) throws Exception {
		if(!hasRefactoring)
			languageNameSuffix = "";
		else if(usesJdtRefactoring) 
			languageNameSuffix = "2";
		else 
			languageNameSuffix = "1";
		javaFile = createFile("RefactoringTest/src/test/JavaClass.java", "package test; public class JavaClass {}");
		xtextFile = createFile("RefactoringTest/src/test/test.typesRefactoring" + languageNameSuffix, "testName test.JavaClass");
		languageServices = AbstractActivator.getInstance().getInjector(getEditorId()).getInstance(LanguageServices.class);
		editor = openEditor(xtextFile);
		waitForAutoBuild();
	}
	
	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.common.types.xtext.ui.RefactoringTestLanguage" + languageNameSuffix;
	}

	public void testRenameElement() throws Exception {
		setLanguageConfig(false, false);
		IRenameSupport renameSupport = createRenameSupportForElement();
		assertNull(renameSupport);
	}

	public void testRenameJvmReference() throws Exception {
		setLanguageConfig(false, false);
		IRenameSupport renameSupport = createRenameSupportForJvmReference();
		assertNull(renameSupport);
	}

	// TODO: disable warning dialog
//	public void testRenameJavaClass() throws Exception {
//		setLanguageConfig(false, false);
//		renameJavaClass();	
//		assertJavaRefactored();
//		assertXtextUnchanged();
//	}

	public void testRenameElement_1() throws Exception {
		setLanguageConfig(true, false);
		IRenameSupport renameSupport = createRenameSupportForElement();
		assertNotNull(renameSupport);
		renameSupport.startDirectRefactoring();
		waitForAutoBuild();
		assertXtextElementRefactored();
		assertJavaUnchanged();
	}

	public void testRenameJvmReference_1() throws Exception {
		setLanguageConfig(true, false);
		IRenameSupport renameSupport = createRenameSupportForJvmReference();
		assertNull(renameSupport);
	}

	public void testRenameJavaClass_1() throws Exception {
		setLanguageConfig(true, false);
		renameJavaClass();	
		assertJavaRefactored();
		assertXtextJvmRefRefactored();
	}

	public void testRenameElement_2() throws Exception {
		setLanguageConfig(true, true);
		IRenameSupport renameSupport = createRenameSupportForElement();
		assertNotNull(renameSupport);
		renameSupport.startDirectRefactoring();
		waitForAutoBuild();
		assertXtextElementRefactored();
		assertJavaUnchanged();
	}

	public void testRenameJvmReference_2() throws Exception {
		setLanguageConfig(true, true);
		IRenameSupport renameSupport = createRenameSupportForJvmReference();
		assertNotNull(renameSupport);
		renameSupport.startDirectRefactoring();
		waitForAutoBuild();
		assertXtextJvmRefRefactored();
		assertJavaRefactored();
	}

	public void testRenameJavaClass_2() throws Exception {
		setLanguageConfig(true, true);
		renameJavaClass();	
		assertXtextJvmRefRefactored();
		assertJavaRefactored();
	}

	protected void assertXtextJvmRefRefactored() {
		assertEquals("testName test.NewJavaClass", editor.getDocument().get());
	}

	protected void assertXtextElementRefactored() {
		assertEquals("newTestName test.JavaClass", editor.getDocument().get());
	}

	protected void assertXtextUnchanged() {
		assertFalse(editor.isDirty());
		assertEquals("testName test.JavaClass", editor.getDocument().get());
	}
		
	protected void assertJavaRefactored() throws JavaModelException {
		assertFalse(javaFile.exists());
		assertNull(javaProject.findType("test.JavaClass"));
		assertTrue(javaProject.findType("test.NewJavaClass").exists());
	}

	protected void assertJavaUnchanged() throws JavaModelException {
		assertTrue(javaFile.exists());
		assertTrue(javaProject.findType("test.JavaClass").exists());
		assertNull(javaProject.findType("test.NewJavaClass"));
	}

	protected IRenameSupport createRenameSupportForJvmReference() {
		if(!languageServices.hasRefactoring())
			return null;
		IRenameElementContext renameElementContext = editor.getDocument().readOnly(
				new IUnitOfWork<IRenameElementContext, XtextResource>() {
					public IRenameElementContext exec(XtextResource state) throws Exception {
						Model model = (Model) state.getContents().get(0);
						JvmType defaultReference = model.getReferenceHolder().get(0).getDefaultReference();
						return languageServices.renameElementHandler.createRenameElementContext(defaultReference,
								editor, null, state);
					}
				});
		IRenameSupport renameSupport = languageServices.renameSupportFactory.create(renameElementContext,
				"NewJavaClass");
		return renameSupport;
	}

	protected IRenameSupport createRenameSupportForElement() {
		if(!languageServices.hasRefactoring())
			return null;
		IRenameElementContext renameElementContext = editor.getDocument().readOnly(
				new IUnitOfWork<IRenameElementContext, XtextResource>() {
					public IRenameElementContext exec(XtextResource state) throws Exception {
						Model model = (Model) state.getContents().get(0);
						ReferenceHolder referenceHolder = model.getReferenceHolder().get(0);
						return languageServices.renameElementHandler.createRenameElementContext(referenceHolder,
								editor, null, state);
					}
				});
		IRenameSupport renameSupport = languageServices.renameSupportFactory.create(renameElementContext,
				"newTestName");
		return renameSupport;
	}

	protected void renameJavaClass() throws Exception {
		RenameSupport renameSupport = RenameSupport.create(javaProject.findType("test.JavaClass"), "NewJavaClass", RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(activeWorkbenchWindow.getShell(), activeWorkbenchWindow);
		waitForAutoBuild();
	}
}
