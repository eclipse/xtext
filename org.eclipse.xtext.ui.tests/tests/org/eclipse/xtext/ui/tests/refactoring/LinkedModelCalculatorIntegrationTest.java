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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.xtext.junit4.ui.AbstractEditorTest;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.refactoring.ILinkedPositionGroupCalculator;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class LinkedModelCalculatorIntegrationTest extends AbstractEditorTest {
	private static final String TEST_PROJECT = "refactore.linkedtest";
	private static final String pathToFile1 = TEST_PROJECT + "/file1.refactoringtestlanguage";
	private static final String pathToFile2 = TEST_PROJECT + "/file2.refactoringtestlanguage";
	private static final URI uriToFile1 = URI.createURI("platform:/resource/" + pathToFile1);
	private static final URI uriToFile2 = URI.createURI("platform:/resource/" + pathToFile2);
	
	private IProject project;
	
	@Inject
	private ILinkedPositionGroupCalculator linkedModelCalculator;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage";
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		project = createProject(TEST_PROJECT);
		IJavaProject javaProject = makeJavaProject(project);
		addNature(javaProject.getProject(), XtextProjectHelper.NATURE_ID);
		Injector injector = Activator.getInstance().getInjector(getEditorId());
		injector.injectMembers(this);
	}

	@Test public void testCorrectTextEditsDeclarationInFile() throws Exception {
		String initialModel1 = "A { B ref A } C { D ref A }";
		createFile(pathToFile1, initialModel1);
		String initialModel2 = "E { ref A } F { ref E ref A}";
		IFile file1 = createFile(pathToFile1, initialModel1);
		createFile(pathToFile2, initialModel2);
		waitForBuild();
		XtextEditor editor = openEditor(file1);
		EObject a = editor.getDocument().readOnly(new IUnitOfWork<EObject, XtextResource>() {
			@Override
			public EObject exec(XtextResource state) throws Exception {
				return state.getContents().get(0).eContents().get(0);
			}
		});
		URI uri = EcoreUtil.getURI(a);
		selectElementInEditor(a, uri, editor, (XtextResource) a.eResource());
		IRenameElementContext renameElementContext = new IRenameElementContext.Impl(uri, a.eClass(), editor, editor
				.getSelectionProvider().getSelection(), uriToFile1);
		LinkedPositionGroup linkedPositionGroup = linkedModelCalculator.getLinkedPositionGroup(renameElementContext,
				new NullProgressMonitor()).get();
		LinkedPosition[] positions = linkedPositionGroup.getPositions();
		assertEquals(3, positions.length);
		int[] offsets = { 0, 10, 24 };
		for (int i = 0; i < positions.length; i++) {
			assertEquals(offsets[i], positions[i].getOffset());
		}
	}

	@Test public void testCorrectTextEditsDeclarationNotInFile() throws Exception {
		String initialModel1 = "A { B ref A } C { D ref A }";
		createFile(pathToFile1, initialModel1);
		String initialModel2 = "E { ref A } F { ref E ref A}";
		IFile file2 = createFile(pathToFile2, initialModel2);
		waitForBuild();
		XtextEditor editor = openEditor(file2);
		EObject a = editor.getDocument().readOnly(new IUnitOfWork<EObject, XtextResource>() {

			@Override
			public EObject exec(XtextResource state) throws Exception {
				return ((Element) state.getContents().get(0).eContents().get(0)).getReferenced().get(0);
			}

		});

		URI uri = EcoreUtil.getURI(a);
		selectElementInEditor(a, uri, editor, (XtextResource) a.eResource());
		IRenameElementContext renameElementContext = new IRenameElementContext.Impl(uri, a.eClass(), editor, editor
				.getSelectionProvider().getSelection(), uriToFile2);
		LinkedPositionGroup linkedPositionGroup = linkedModelCalculator.getLinkedPositionGroup(renameElementContext,
				new NullProgressMonitor()).get();
		LinkedPosition[] positions = linkedPositionGroup.getPositions();
		assertEquals(2, positions.length);

		int[] offsets = { 8, 26 };
		for (int i = 0; i < positions.length; i++) {
			assertEquals(offsets[i], positions[i].getOffset());
		}
	}

	protected void selectElementInEditor(EObject targetElement, final URI targetElementURI, final XtextEditor editor,
			XtextResource editorResource) {
		if (targetElementURI != null && targetElementURI.trimFragment().equals(editorResource.getURI())) {
			ITextRegion region = locationInFileProvider.getSignificantTextRegion(targetElement);
			editor.selectAndReveal(region.getOffset(), region.getLength());
		}
	}

}
