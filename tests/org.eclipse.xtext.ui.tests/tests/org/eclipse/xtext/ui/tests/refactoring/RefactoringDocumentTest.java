/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringDocument.Factory;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.editor.AbstractEditorTest;

import com.google.inject.Injector;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RefactoringDocumentTest extends AbstractEditorTest {

	private static final String TEST_FILE_CONTENT = "A";
	private static final String ALTERNATIVE_TEST_FILE_CONTENT = "A { B }";
	private static final String TEST_PROJECT = "refactoring.test";
	private static final String TEST_FILE_NAME = TEST_PROJECT + "/" + "File.refactoringtestlanguage";
	private IJavaProject project;
	private Factory factory;
	private IFile testFile;
	private RefactoringStatus status;

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage";
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		project = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		addSourceFolder(project, "src");
		Injector injector = Activator.getInstance().getInjector(getEditorId());
		factory = injector.getInstance(RefactoringDocument.Factory.class);
		status = new RefactoringStatus();
		testFile = IResourcesSetupUtil.createFile(TEST_FILE_NAME, TEST_FILE_CONTENT);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		if (project != null)
			JavaProjectSetupUtil.deleteJavaProject(project);
	}

	public void testFileResource() throws Exception {
		createAndCheckDocument(testFile, TEST_FILE_CONTENT);
	}

	public void testEditorResource() throws Exception {
		XtextEditor editor = openEditor(testFile);
		RefactoringDocument dircleanDocument = createAndCheckDocument(testFile, TEST_FILE_CONTENT);
		IXtextDocument editorDocument = editor.getDocument();
		assertEquals(editorDocument, dircleanDocument.getXtextDocument());
		editorDocument.set(ALTERNATIVE_TEST_FILE_CONTENT);
		RefactoringDocument dirtyDocument = createAndCheckDocument(testFile, ALTERNATIVE_TEST_FILE_CONTENT);
		assertEquals(editorDocument, dirtyDocument.getXtextDocument());
	}
	
	protected RefactoringDocument createAndCheckDocument(IFile testFile, String content) {
		RefactoringDocument document = factory.create(URI.createPlatformResourceURI(TEST_FILE_NAME, true), status);
		assertTrue(status.isOK());
		assertNotNull(document);
		assertEquals(testFile, document.getFileToSave());
		assertNotNull(document.getXtextDocument());
		assertEquals(content, document.getXtextDocument().get());
		return document;
	}


}
