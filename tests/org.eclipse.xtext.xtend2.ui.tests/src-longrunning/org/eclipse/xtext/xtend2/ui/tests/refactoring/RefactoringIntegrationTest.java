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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.Xtend2WorkbenchTestHelper;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactoringIntegrationTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return Xtend2WorkbenchTestHelper.suite(RefactoringIntegrationTest.class);
	}

	@Inject
	private Xtend2WorkbenchTestHelper testHelper;

	@Inject
	private Provider<RenameElementProcessor> processorProvider;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Override
	protected void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	public void testRenameVariable() throws Exception {
		performRenameTest("Foo", "class Foo { foo() { val bar = 7; bar + 1 }", "bar", "baz");
	}

	public void testRenameParamter() throws Exception {
		performRenameTest("Foo", "class Foo { foo(int bar) { bar + 1 }", "bar", "baz");
	}

	public void testRenameMethod() throws Exception {
		performRenameTest("Foo", "class Foo { foo() { foo(); bar + 1 }", "foo", "bar");
	}

	public void testRefactorClass() throws Exception {
		performRenameTest("Foo", "class Foo { Foo foo() { this }", "Foo", "Bar");
	}

	public void testRefactorTypeParameter() throws Exception {
		performRenameTest("Foo", "class Foo <T> { T foo() { null }", "T", "U");
	}

	protected void performRenameTest(String fileName, String originalContents, String oldName, String newName) throws Exception {
		IFile file = testHelper.createFile(fileName, originalContents);
		ResourceSet resourceSet = new ResourceSetImpl();
		XtextResource resource = (XtextResource) resourceSet.getResource(
				URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
		EObject target = eObjectAtOffsetHelper.resolveElementAt(resource, originalContents.indexOf(oldName));
		doRename(target, newName);
		String contentsAfterDo = testHelper.getContents(file);
		assertEquals(originalContents.replace(oldName, newName), contentsAfterDo);
	}

	protected void doRename(EObject target, String newName) throws Exception {
		IResourcesSetupUtil.waitForAutoBuild();
		final Change change = createChange(target, newName);
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				change.perform(monitor);
			}
		}.run(null);
	}

	protected Change createChange(EObject targetElement, String newName) throws Exception {
		URI targetElementURI = EcoreUtil.getURI(targetElement);
		RenameElementProcessor processor = processorProvider.get();
		processor
				.initialize(new IRenameElementContext.Impl(targetElementURI, targetElement.eClass(), null, null, null));
		RefactoringStatus initialStatus = processor.checkInitialConditions(new NullProgressMonitor());
		assertTrue(initialStatus.isOK());
		processor.setNewName(newName);
		RefactoringStatus finalStatus = processor.checkFinalConditions(new NullProgressMonitor(), null);
		assertTrue(finalStatus.isOK());
		final Change change = processor.createChange(new NullProgressMonitor());
		assertNotNull(change);
		return change;
	}
}
