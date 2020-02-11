/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.corext.refactoring.rename.JavaRenameProcessor;
import org.eclipse.jdt.ui.refactoring.RenameSupport;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.ui.refactoring.participant.CompositeRefactoringProcessor;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.inject.Inject;
import com.google.inject.Provider;

public abstract class AbstractXtendRenameRefactoringTest extends AbstractXtendUITestCase {

	@Inject
	protected EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	protected IRenameRefactoringProvider renameRefactoringProvider;

	@Inject
	protected IRenameContextFactory renameContextFactory;

	@Inject @Extension
	protected WorkbenchTestHelper testHelper;

	@Inject
	protected IWorkbench workbench;

	@Inject @Extension
	protected FileAsserts fileAsserts;

	@Inject 
	protected SyncUtil syncUtil;

	@Inject 
	protected CompositeRefactoringProcessor.Access compositeRefactoringProcessorAccess;

	@Inject
	protected IWorkspace workspace;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private Provider<RenameElementProcessor> processorProvider;

	@Override
	public void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	protected void assertDocumentContains(XtextEditor editor, String expectedContent) throws CoreException {
		String editorContent = editor.getDocument().get();
		if (!editorContent.contains(expectedContent)) {
			assertEquals(expectedContent, editorContent);
		}
	}

	protected void assertDocumentContainsIgnoreWhitespace(XtextEditor editor, String expectedContent) throws CoreException {
		String editorContent = editor.getDocument().get();
		assertTrue("'" + expectedContent + "' not found in \n" + editorContent, 
				editorContent.replaceAll("\\s*", " ").contains(expectedContent.replaceAll("\\s*",  " ")));
	}

	protected XtextEditor openEditorSafely(String fileName, String contents) throws Exception {
		return openEditorSafely(fileName, contents, new NullProgressMonitor());
	}

	protected XtextEditor openEditorSafely(String fileName, String contents, IProgressMonitor monitor) throws Exception {
		IFile file = testHelper.createFile(fileName, contents);
		return openEditorSafely(file, monitor);
	}

	protected XtextEditor openEditorSafely(IFile file) throws Exception {
		return openEditorSafely(file, new NullProgressMonitor());
	}

	protected XtextEditor openEditorSafely(IFile file, IProgressMonitor monitor) throws Exception {
		syncUtil.waitForBuild(monitor);
		syncUtil.yieldToQueuedDisplayJobs(monitor);
		XtextEditor editor = testHelper.openEditor(file);
		syncUtil.waitForReconciler(editor);
		syncUtil.yieldToQueuedDisplayJobs(monitor);
		return editor;
	}

	protected void renameXtendElement(final XtextEditor editor, final int offset, String newName) throws Exception {
		renameXtendElement(editor, offset, newName, RefactoringStatus.OK, new NullProgressMonitor());
	}

	protected void renameXtendElement(final XtextEditor editor, final int offset, String newName, IProgressMonitor monitor) throws Exception {
		renameXtendElement(editor, offset, newName, RefactoringStatus.OK, monitor);
	}

	protected void renameXtendElement(final XtextEditor editor, final int offset, final String newName, final int allowedSeverity) throws Exception {
		renameXtendElement(editor, offset, newName, allowedSeverity, new NullProgressMonitor());
	}

	protected void renameXtendElement(final XtextEditor editor, final int offset, final String newName, final int allowedSeverity, IProgressMonitor monitor) throws Exception {
		syncUtil.totalSync(false);
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				ProcessorBasedRefactoring renameRefactoring = createXtendRenameRefactoring(editor, offset, newName);
				assertTrue("Refactoring not applicable", renameRefactoring.isApplicable());
				RefactoringStatus status = renameRefactoring.checkAllConditions(monitor);
				assertTrue(status.toString(), status.getSeverity() <= allowedSeverity);
				Change change = renameRefactoring.createChange(monitor);
				change.perform(monitor);
			}
		}.run(monitor);
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.isDisposed());
	}

	protected RefactoringStatus renameXtendElementWithError(final XtextEditor editor, final int offset, String newName) throws Exception {
		return renameXtendElementWithError(editor, offset, newName, new NullProgressMonitor());
	}

	protected RefactoringStatus renameXtendElementWithError(final XtextEditor editor, final int offset, String newName, IProgressMonitor monitor) throws Exception {
		syncUtil.totalSync(false);
		ProcessorBasedRefactoring renameRefactoring = createXtendRenameRefactoring(editor, offset, newName);
		RefactoringStatus status = renameRefactoring.checkAllConditions(monitor);
		assertFalse("Expected an error", status.isOK());
		return status;
	}

	protected ProcessorBasedRefactoring createXtendRenameRefactoring(final XtextEditor editor, final int offset,
			String newName) {
		IRenameElementContext renameElementContext = createRenameElementContext(editor, offset);
		ProcessorBasedRefactoring renameRefactoring = renameRefactoringProvider
				.getRenameRefactoring(renameElementContext);
		RefactoringProcessor processor = renameRefactoring.getProcessor();
		if (processor instanceof AbstractRenameProcessor)
			((AbstractRenameProcessor) processor).setNewName(newName);
		else if (processor instanceof JavaRenameProcessor)
			((JavaRenameProcessor) processor).setNewElementName(newName);
		return renameRefactoring;
	}

	protected IRenameElementContext createRenameElementContext(final XtextEditor editor, final int offset) {
		IRenameElementContext renameElementContext = editor.getDocument().readOnly(
				new IUnitOfWork<IRenameElementContext, XtextResource>() {
					@Override
					public IRenameElementContext exec(XtextResource state) throws Exception {
						EObject element = eObjectAtOffsetHelper.resolveElementAt(state, offset);
						return renameContextFactory.createRenameElementContext(element, editor, new TextSelection(
								offset, 1), state);
					}
				});
		return renameElementContext;
	}

	protected void renameJavaElement(IType javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		syncUtil.totalSync(false);
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.isDisposed());
	}

	protected void renameJavaElement(IMethod javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		syncUtil.totalSync(false);
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.isDisposed());
	}

	protected void renameJavaElement(IField javaElement, String newName) throws CoreException, InterruptedException,
			InvocationTargetException {
		syncUtil.totalSync(false);
		RenameSupport renameSupport = RenameSupport.create(javaElement, newName, RenameSupport.UPDATE_REFERENCES);
		renameSupport.perform(workbench.getActiveWorkbenchWindow().getShell(), workbench.getActiveWorkbenchWindow());
		syncUtil.totalSync(false);
		assertTrue(compositeRefactoringProcessorAccess.isDisposed());
	}

	protected IFile renameTo(IFile file, String newFileName) throws OperationCanceledException, CoreException {
		return renameTo(file, newFileName, new NullProgressMonitor());
	}

	protected IFile renameTo(IFile file, String newFileName, IProgressMonitor monitor) throws OperationCanceledException, CoreException {
		RenameResourceProcessor renameResourceProcessor = new RenameResourceProcessor(file);
		renameResourceProcessor.setNewResourceName(newFileName);
		RenameRefactoring renameRefactoring = new RenameRefactoring(renameResourceProcessor);
		renameRefactoring.checkAllConditions(monitor);
		Change change = renameRefactoring.createChange(monitor);
		
		workspace.run(new ICoreRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				change.perform(monitor);
				
			}
		}, monitor);
		
		IResource newFile = testHelper.getProject().findMember(new Path("src/" + newFileName));
		assertTrue(newFile.exists());
		assertTrue(newFile instanceof IFile);
		return (IFile) newFile;
	}

	protected void doRename(EObject targetElement, String newName) throws Exception {
		doRename(targetElement, newName, new NullProgressMonitor());
	}

	protected void doRename(EObject targetElement, String newName, IProgressMonitor monitor) throws Exception {
		URI targetElementURI = EcoreUtil.getURI(targetElement);
		RenameElementProcessor processor = processorProvider.get();
		processor
				.initialize(new IRenameElementContext.Impl(targetElementURI, targetElement.eClass(), null, null, null));
		processor.setNewName(newName);
		RefactoringStatus initialStatus = processor.checkInitialConditions(monitor);
		assertTrue(initialStatus.isOK());
		RefactoringStatus finalStatus = processor.checkFinalConditions(monitor, null);
		assertTrue(finalStatus.toString(), finalStatus.isOK());
		final Change change = processor.createChange(monitor);
		assertNotNull(change);
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				change.perform(monitor);
			}
		}.run(monitor);
	}

	protected void performRenameTest(String fileName, String originalContents, String oldName, String newName)
			throws Exception {
		IFile file = testHelper.createFile(fileName, originalContents);
		performRenameTest(file, originalContents, oldName, newName, file);
	}

	protected void performRenameTestWithReferringFile(String fileName, String newFileName, String originalContents, String referringFileName,
			String referringFileContents, String oldName, String newName) throws Exception {
		IFile file = testHelper.createFile(fileName, originalContents);
		IFile newFile = testHelper.getFile(newFileName);
		IFile referringFile = testHelper.createFile(referringFileName, referringFileContents);
		performRenameTest(file, originalContents, oldName, newName, newFile);
		String referringFileContentsAfterRename = WorkbenchTestHelper.getContentsAsString(referringFile);
		assertEquals(referringFileContents.replace(oldName, newName), referringFileContentsAfterRename);
	}

	protected void performRenameTest(IFile file, String originalContents, String oldName, String newName, IFile newFile)
			throws Exception {
		IResourcesSetupUtil.waitForBuild();
		ResourceSet resourceSet = resourceSetProvider.get(file.getProject());
		XtextResource resource = (XtextResource) resourceSet.getResource(
				testHelper.uri(file), true);
		EObject target = eObjectAtOffsetHelper.resolveElementAt(resource, originalContents.indexOf(oldName));
		doRename(target, newName);
		String contentsAfterRename = WorkbenchTestHelper.getContentsAsString(newFile);
		assertEquals(originalContents.replace(oldName, newName), contentsAfterRename);
	}

	protected IType findJavaType(String typeName) throws Exception {
		syncUtil.totalSync(false);
		IJavaProject javaProject = JavaCore.create(testHelper.getProject());
		IType javaClass = javaProject.findType(typeName);
		return javaClass;
	}
}
