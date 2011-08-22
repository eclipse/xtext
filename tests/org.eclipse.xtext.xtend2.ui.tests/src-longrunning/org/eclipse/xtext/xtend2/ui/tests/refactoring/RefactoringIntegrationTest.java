/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.refactoring;

import java.lang.reflect.InvocationTargetException;

import junit.framework.Test;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class RefactoringIntegrationTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(RefactoringIntegrationTest.class);
	}

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private Provider<RenameElementProcessor> processorProvider;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Override
	protected void tearDown() throws Exception {
		testHelper.tearDown();
	}

	public void testRenameVariable() throws Exception {
		performRenameTest("Foo", "class Foo { def foo() { val bar = 7; bar + 1 }}", "bar", "baz");
	}

	public void testRenameParamter() throws Exception {
		performRenameTest("Foo", "class Foo { def foo(int bar) { bar + 1 }}", "bar", "baz");
	}

	public void testRefactorTypeParameter() throws Exception {
		performRenameTest("Foo", "class Foo <T> { def T foo() null }", "T", "U");
	}

	public void testRenameMethod() throws Exception {
		performRenameTestWithReferringFile("Foo", "Foo", "class Foo { def Integer foo() { foo(); 1 }}", "Bar",
				"class Baz { def baz(Foo arg) {arg.foo()} }", "foo", "bar");
	}

	public void testRenameClass() throws Exception {
		performRenameTestWithReferringFile("Foo", "Bar", "class Foo { def Foo foo() {this} }", "Baz", "class Baz { def Foo foo() {new Foo()} }", "Foo",
				"Bar");
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
		String refferingFileContentsAfterRename = testHelper.getContents(referringFile);
		assertEquals(referringFileContents.replace(oldName, newName), refferingFileContentsAfterRename);
	}

	protected void performRenameTest(IFile file, String originalContents, String oldName, String newName, IFile newFile)
			throws Exception {
		IResourcesSetupUtil.waitForAutoBuild();
		ResourceSet resourceSet = resourceSetProvider.get(file.getProject());
		XtextResource resource = (XtextResource) resourceSet.getResource(
				testHelper.uri(file), true);
		EObject target = eObjectAtOffsetHelper.resolveElementAt(resource, originalContents.indexOf(oldName));
		doRename(target, newName);
		String contentsAfterRename = testHelper.getContents(newFile);
		assertEquals(originalContents.replace(oldName, newName), contentsAfterRename);
	}

	protected void doRename(EObject targetElement, String newName) throws Exception {
		URI targetElementURI = EcoreUtil.getURI(targetElement);
		RenameElementProcessor processor = processorProvider.get();
		processor
				.initialize(new IRenameElementContext.Impl(targetElementURI, targetElement.eClass(), null, null, null));
		RefactoringStatus initialStatus = processor.checkInitialConditions(new NullProgressMonitor());
		assertTrue(initialStatus.isOK());
		processor.setNewName(newName);
		RefactoringStatus finalStatus = processor.checkFinalConditions(new NullProgressMonitor(), null);
		assertTrue(finalStatus.toString(), finalStatus.isOK());
		final Change change = processor.createChange(new NullProgressMonitor());
		assertNotNull(change);
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				change.perform(monitor);
			}
		}.run(null);
	}

}
