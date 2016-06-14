/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.refactoring;

import java.lang.reflect.InvocationTargetException;

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
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */

public class RefactoringIntegrationTest extends AbstractXtendUITestCase {

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private Provider<RenameElementProcessor> processorProvider;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Override
	public void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	@Test public void testRenameVariable() throws Exception {
		performRenameTest("Foo", "class Foo { def foo() { val bar = 7; bar + 1 }}", "bar", "baz");
	}

	@Test public void testRenameParameter() throws Exception {
		performRenameTest("Foo", "class Foo { def foo(int bar) { bar + 1 }}", "bar", "baz");
	}

	@Test public void testRenameTypeParameter() throws Exception {
		// Test with broken model
		performRenameTest("Foo", "class Foo <T> { def T foo() null }", "T", "U");
	}
	
	@Test public void testRenameTypeParameter2() throws Exception {
		performRenameTest("Foo", "class Foo <T> { def T foo() {null} }", "T", "U");
	}

	@Test public void testRenameSwitchVar() throws Exception {
		performRenameTest("Foo", "class Foo { " +
				"def foo() {\n" +
				"   val Object bar = ''\n" + 
				"   switch(bar) {\n" + 
				"      String: bar.length\n" +
				"      Object: bar.hashCode\n" +
				"      default: bar.hashCode\n" + 
				"   }" +
				"}", "bar", "baz");
	}
	
	@Test public void testRenameMethod() throws Exception {
		performRenameTestWithReferringFile("Foo", "Foo", "class Foo { def Integer foo() { foo(); 1 }}", "Bar",
				"class Baz { def baz(Foo arg) {arg.foo()} }", "foo", "bar");
	}

	@Test public void testRenameClass() throws Exception {
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
		String refferingFileContentsAfterRename = WorkbenchTestHelper.getContentsAsString(referringFile);
		assertEquals(referringFileContents.replace(oldName, newName), refferingFileContentsAfterRename);
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

	protected void doRename(EObject targetElement, String newName) throws Exception {
		URI targetElementURI = EcoreUtil.getURI(targetElement);
		RenameElementProcessor processor = processorProvider.get();
		processor
				.initialize(new IRenameElementContext.Impl(targetElementURI, targetElement.eClass(), null, null, null));
		processor.setNewName(newName);
		RefactoringStatus initialStatus = processor.checkInitialConditions(new NullProgressMonitor());
		assertTrue(initialStatus.isOK());
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
