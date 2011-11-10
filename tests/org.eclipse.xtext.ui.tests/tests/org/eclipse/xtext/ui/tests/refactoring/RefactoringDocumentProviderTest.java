/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.junit.editor.AbstractEditorTest;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRefactoringDocumentProvider.EditorDocument;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRefactoringDocumentProvider.FileDocument;
import org.eclipse.xtext.ui.refactoring.impl.DisplayChangeWrapper;
import org.eclipse.xtext.ui.refactoring.impl.IRefactoringDocument;
import org.eclipse.xtext.ui.refactoring.impl.StatusWrapper;
import org.eclipse.xtext.ui.tests.Activator;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class RefactoringDocumentProviderTest extends AbstractEditorTest {

	private static final String TEST_FILE_NAME = "File.refactoringtestlanguage";
	private static final String TEST_PROJECT = "refactoring.test";
	private static final String TEST_FILE_PATH = TEST_PROJECT + "/" + TEST_FILE_NAME;

	private static final String TEST_FILE_CONTENT = "A { B }";
	private static final String CHANGE_NAME = "Change";

	@Inject
	private IRefactoringDocument.Provider documentFactory;

	@Inject
	private StatusWrapper status;

	private IFile testFile;
	private ReplaceEdit textEdit;

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage";
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		IJavaProject project = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		Injector injector = Activator.getInstance().getInjector(getEditorId());
		injector.injectMembers(this);
		testFile = IResourcesSetupUtil.createFile(TEST_FILE_PATH, TEST_FILE_CONTENT);
		textEdit = new ReplaceEdit(0, 1, "C");
	}

	public void testFileDocument() throws Exception {
		IRefactoringDocument document = createAndCheckDocument(testFile);
		assertTrue(document instanceof FileDocument);
		assertEquals(testFile, ((FileDocument) document).getFile());
		assertEquals(TEST_FILE_CONTENT, document.getOriginalContents());

		Change change = document.createChange(CHANGE_NAME, textEdit);
		assertTrue(change instanceof TextFileChange);
		assertEquals(CHANGE_NAME, change.getName());

		Change undoChange = checkEdit(document, textEdit);
		assertNotNull(undoChange);
	}

	public void testDirtyEditorDocument() throws Exception {
		XtextEditor editor = openEditor(testFile);
		editor.getDocument().replace(0, 0, " ");
		editor.getDocument().replace(0, 1, "");
		assertTrue(editor.isDirty());
		IRefactoringDocument cleanDocument = createAndCheckDocument(testFile);
		assertTrue(cleanDocument instanceof EditorDocument);

		IXtextDocument editorDocument = editor.getDocument();
		assertEquals(editorDocument, ((EditorDocument) cleanDocument).getDocument());
		assertEquals(TEST_FILE_CONTENT, cleanDocument.getOriginalContents());

		Change change = cleanDocument.createChange(CHANGE_NAME, textEdit);
		assertTrue(change instanceof DisplayChangeWrapper);
		assertEquals(TEST_FILE_NAME + " - " + TEST_PROJECT, change.getName());
		assertTrue(((DisplayChangeWrapper) change).getDelegate() instanceof DocumentChange);

		Change undoChange = checkEdit(cleanDocument, textEdit);
		assertNotNull(undoChange);
		IRefactoringDocument dirtyDocument = createAndCheckDocument(testFile);
		assertTrue(cleanDocument instanceof EditorDocument);
		assertEquals(editorDocument, ((EditorDocument) dirtyDocument).getDocument());
	}

	public void testCleanEditorDocument() throws Exception {
		XtextEditor editor = openEditor(testFile);
		assertFalse(editor.isDirty());
		IRefactoringDocument document = createAndCheckDocument(testFile);
		assertTrue(document instanceof FileDocument);
		assertEquals(testFile, ((FileDocument) document).getFile());
		assertEquals(TEST_FILE_CONTENT, document.getOriginalContents());

		Change change = document.createChange(CHANGE_NAME, textEdit);
		assertTrue(change instanceof TextFileChange);
		assertEquals(CHANGE_NAME, change.getName());

		Change undoChange = checkEdit(document, textEdit);
		assertNotNull(undoChange);
	}

	protected IRefactoringDocument createAndCheckDocument(IFile testFile) {
		IRefactoringDocument document = documentFactory.get(
				URI.createPlatformResourceURI(testFile.getFullPath().toString(), true), status);
		assertTrue(status.getRefactoringStatus().isOK());
		assertNotNull(document);
		return document;
	}

	protected Change checkEdit(IRefactoringDocument document, TextEdit textEdit) throws CoreException {
		Change change = document.createChange("change", textEdit);
		assertNotNull(change);
		Change undoChange = change.perform(new NullProgressMonitor());
		return undoChange;
	}

}
