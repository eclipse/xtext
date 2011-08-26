/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.refactoring;

import junit.framework.Test;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.refactoring.RenameSupport;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.refactoring.IRenameProcessorAdapter;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.JvmModelRenameElementHandler;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JavaRefactoringIntegrationTest extends AbstractXtend2UITestCase {

	@Inject
	protected EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	protected IRenameRefactoringProvider renameRefactoringProvider;

	@Inject
	protected IRenameProcessorAdapter.Factory renameProcessorAdapterFactory;

	@Inject
	protected JvmModelRenameElementHandler renameElementHandler;

	public static Test suite() {
		return WorkbenchTestHelper.suite(JavaRefactoringIntegrationTest.class);
	}

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private IWorkbench workbench;

	@Override
	protected void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	public void testRenameReferenceToJava() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass {}");
			String xtendModel = "class XtendClass extends JavaClass {}";
			XtextEditor editor = testHelper.openEditor("XtendClass.xtend", xtendModel);
			performRenameTest(editor, xtendModel.indexOf("JavaClass"), "NewJavaClass");
			assertFileExists("src/NewJavaClass.java");
			IResourcesSetupUtil.waitForAutoBuild();
			assertTrue(editor.getDocument().get(), editor.getDocument().get().contains("NewJavaClass"));
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	public void testRenameOverriddenJavaMethod() throws Exception {
		IFile javaInterface = testHelper.createFile("JavaInterface.java",
				"public interface JavaInterface { void foo(); }");
		IFile javaClass = testHelper.createFile("JavaClass.java",
				"public class JavaClass implements JavaInterface { public void foo() {} }");
		String xtendModel = "class XtendClass extends JavaClass { override foo() {} }";
		IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		IFile referringJavaClass = testHelper.createFile("ReferringJavaClass.java",
				"public class ReferringJavaClass { public void bar() { new XtendClass().foo(); } }");
		XtextEditor editor = testHelper.openEditor(xtendClass);
		performRenameTest(editor, xtendModel.indexOf("foo"), "foobar");
		assertFileContains(javaInterface, "void foobar()");
		assertFileContains(javaClass, "void foobar()");
		assertFileContains(referringJavaClass, "new XtendClass().foobar()");
		assertTrue(editor.getDocument().get().contains("foobar()"));
	}

	public void testRenameJavaClass() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass { }");
			String xtendModel = "class XtendClass extends JavaClass {  }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IResourcesSetupUtil.waitForAutoBuild();
			IJavaProject javaProject = JavaCore.create(testHelper.getProject());
			IType javaClass = javaProject.findType("JavaClass");
			assertNotNull(javaClass);
			RenameSupport renameSupport = RenameSupport.create(javaClass, "NewJavaClass",
					RenameSupport.UPDATE_REFERENCES);
			renameSupport
					.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
			assertFileContains(xtendClass, "extends NewJavaClass");
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	public void testRenameJavaMethod() throws Exception {
		try {
			testHelper.createFile("JavaClass.java", "public class JavaClass { public void foo() {} }");
			String xtendModel = "class XtendClass { def bar() { new JavaClass().foo() }";
			IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
			IResourcesSetupUtil.waitForAutoBuild();
			IJavaProject javaProject = JavaCore.create(testHelper.getProject());
			IType javaClass = javaProject.findType("JavaClass");
			IMethod foo = javaClass.getMethod("foo", new String[0]);
			assertNotNull(foo);
			RenameSupport renameSupport = RenameSupport.create(foo, "baz",
					RenameSupport.UPDATE_REFERENCES);
			renameSupport
					.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
			assertFileContains(xtendClass, "new JavaClass().baz()");
		} finally {
			testHelper.getProject().getFile("src/NewJavaClass.java").delete(true, new NullProgressMonitor());
		}
	}

	protected IFile assertFileExists(String fileName) throws Exception {
		IResource file = testHelper.getProject().findMember(fileName);
		assertTrue(file instanceof IFile);
		assertTrue(file.exists());
		return (IFile) file;
	}

	protected void assertFileContains(IFile file, String contents) throws Exception {
		String fileContents = testHelper.getContents(file);
		assertTrue(fileContents, fileContents.contains(contents));
	}

	protected Change performRenameTest(final XtextEditor editor, final int offset, String newName) throws Exception {
		IResourcesSetupUtil.waitForAutoBuild();
		IRenameElementContext renameElementContext = editor.getDocument().readOnly(
				new IUnitOfWork<IRenameElementContext, XtextResource>() {
					public IRenameElementContext exec(XtextResource state) throws Exception {
						EObject element = eObjectAtOffsetHelper.resolveElementAt(state, offset);
						return renameElementHandler.createRenameElementContext(element, editor, new TextSelection(
								offset, 1), state);
					}
				});
		ProcessorBasedRefactoring renameRefactoring = renameRefactoringProvider
				.getRenameRefactoring(renameElementContext);
		renameProcessorAdapterFactory.create((RenameProcessor) renameRefactoring.getProcessor()).setNewName(newName);
		RefactoringStatus status = renameRefactoring.checkAllConditions(new NullProgressMonitor());
		assertTrue(status.toString(), status.isOK());
		Change change = renameRefactoring.createChange(new NullProgressMonitor());
		Change undoChange = change.perform(new NullProgressMonitor());
		return undoChange;
	}

}
