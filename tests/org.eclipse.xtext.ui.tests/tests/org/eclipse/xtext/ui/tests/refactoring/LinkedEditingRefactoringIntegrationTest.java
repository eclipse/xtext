/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtext.junit4.ui.AbstractLinkedEditingIntegrationTest;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.refactoring.referring.Reference;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class LinkedEditingRefactoringIntegrationTest extends AbstractLinkedEditingIntegrationTest {

	private static final String TEST_CLASS = "TestClass";
	private static final String TEST_PROJECT = "test";
	private IProject project;

	@Inject
	private RenameRefactoringController renameRefactoringController;
	
	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage";
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		project = createProject(TEST_PROJECT);
		IJavaProject javaProject = makeJavaProject(project);
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		Activator.getInstance().getInjector(getEditorId()).injectMembers(this);
	}
	
	@Test public void testTwice() throws Exception {
		testRefactorEcoreCrossLanguage();
	}

	@Test public void testRefactorEcoreCrossLanguage() throws Exception {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");
		ePackage.setNsPrefix("test");
		ePackage.setNsURI("http://test");
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName(TEST_CLASS);
		ePackage.getEClassifiers().add(eClass);
		Resource ecoreResource = new ResourceSetImpl().createResource(URI.createPlatformResourceURI(TEST_PROJECT + "/Test.ecore", true));
		ecoreResource.getContents().add(ePackage);
		ecoreResource.save(null);
		ecoreResource.unload();
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
		
		String model = "ref test." + TEST_CLASS;
		IFile file = createFile(TEST_PROJECT + "/ref.referringtestlanguage", model);
		waitForBuild();
		final XtextEditor editor = openEditor(file);
		final TextSelection selection = new TextSelection(model.indexOf(TEST_CLASS), TEST_CLASS.length());
		editor.getSelectionProvider().setSelection(selection);
		waitForDisplay();
		IRenameElementContext context = editor.getDocument().readOnly(new IUnitOfWork<IRenameElementContext, XtextResource>() {
			@Override
			public IRenameElementContext exec(XtextResource state) throws Exception {
				Reference ref = (Reference) state.getContents().get(0).eContents().get(0);
				EObject referenced = ref.getReferenced();
				assertNotNull(referenced);
				return new IRenameElementContext.Impl(EcoreUtil.getURI(referenced), referenced.eClass(), editor, selection, state.getURI());
			}
		});
		renameRefactoringController.startRefactoring(context);
		waitForDisplay();
		pressKeys(editor, "NewTestClass\n");
		waitForReconciler(editor);
		waitForDisplay();
		waitForBuild();
		ecoreResource.load(null);
		assertEquals("NewTestClass", ((EPackage)ecoreResource.getContents().get(0)).getEClassifiers().get(0).getName());
	}

	
}
