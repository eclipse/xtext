/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.junit.refactoring.AbstractLinkedEditingIntegrationTest;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementHandler;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringType;
import org.eclipse.xtext.ui.refactoring.ui.RenameRefactoringController;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class ToSaveOrNotToSaveTest extends AbstractLinkedEditingIntegrationTest {

	private static final String TEST_PROJECT = "refactoring.test";

	@Inject
	private IRenameElementHandler renameElementHandler;

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	@Inject
	private RenameRefactoringController controller;

	@Inject
	private RefactoringPreferences refactoringPreferences;

	private XtextEditor fooEditor;
	private XtextEditor barEditor;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		IJavaProject project = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		Injector injector = Activator.getInstance().getInjector(getEditorId());
		injector.injectMembers(this);
		IFile fooFile = IResourcesSetupUtil.createFile(TEST_PROJECT + "/foo.refactoringtestlanguage", "foo");
		IFile barFile = IResourcesSetupUtil
				.createFile(TEST_PROJECT + "/bar.refactoringtestlanguage", "bar { ref foo }");
		fooEditor = openEditor(fooFile);
		barEditor = openEditor(barFile);
		waitForAutoBuild();
		assertTrue(refactoringPreferences.useInlineRefactoring());
	}

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage";
	}

	protected void smudge(ITextEditor... editors) throws BadLocationException {
		for (ITextEditor editor : editors) {
			IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
			document.replace(document.getLength(), 0, " ");
			assertTrue(editor.isDirty());
		}
	}

	public void testBothClean_0() throws Exception {
		assertFalse(refactoringPreferences.isSaveAllBeforeRefactoring());
		renameFooToFooBar(fooEditor);
		assertFalse(fooEditor.isDirty());
		assertFalse(barEditor.isDirty());
	}

	public void testCleanDirty_1() throws Exception {
		assertFalse(refactoringPreferences.isSaveAllBeforeRefactoring());
		renameFooToFooBar(barEditor);
		assertFalse(fooEditor.isDirty());
		assertFalse(barEditor.isDirty());
	}

	public void testBothClean_2() throws Exception {
		try {
			refactoringPreferences.setSaveAllBeforeRefactoring(true);
			renameFooToFooBar(fooEditor);
			assertFalse(fooEditor.isDirty());
			assertFalse(barEditor.isDirty());
		} finally {
			refactoringPreferences.setSaveAllBeforeRefactoring(false);
		}
	}

	public void testBothClean_3() throws Exception {
		try {
			refactoringPreferences.setSaveAllBeforeRefactoring(true);
			renameFooToFooBar(barEditor);
			assertFalse(fooEditor.isDirty());
			assertFalse(barEditor.isDirty());
		} finally {
			refactoringPreferences.setSaveAllBeforeRefactoring(false);
		}
	}

	public void testBothDirty_0() throws Exception {
		assertFalse(refactoringPreferences.isSaveAllBeforeRefactoring());
		smudge(fooEditor, barEditor);
		renameFooToFooBar(fooEditor);
		assertFalse(fooEditor.isDirty());
		assertTrue(barEditor.isDirty());
	}

	public void testBothDirty_1() throws Exception {
		assertFalse(refactoringPreferences.isSaveAllBeforeRefactoring());
		smudge(fooEditor, barEditor);
		renameFooToFooBar(barEditor);
		assertFalse(fooEditor.isDirty());
		assertTrue(barEditor.isDirty());
	}

	public void testBothDirty_2() throws Exception {
		try {
			refactoringPreferences.setSaveAllBeforeRefactoring(true);
			smudge(fooEditor, barEditor);
			renameFooToFooBar(fooEditor);
			assertFalse(fooEditor.isDirty());
			assertFalse(barEditor.isDirty());
		} finally {
			refactoringPreferences.setSaveAllBeforeRefactoring(false);
		}
	}

	public void testBothDirty_3() throws Exception {
		try {
			refactoringPreferences.setSaveAllBeforeRefactoring(true);
			smudge(fooEditor, barEditor);
			renameFooToFooBar(barEditor);
			assertFalse(fooEditor.isDirty());
			assertFalse(barEditor.isDirty());
		} finally {
			refactoringPreferences.setSaveAllBeforeRefactoring(false);
		}
	}

	public void testDeclaratorDirty_0() throws Exception {
		assertFalse(refactoringPreferences.isSaveAllBeforeRefactoring());
		smudge(fooEditor);
		renameFooToFooBar(fooEditor);
		assertFalse(fooEditor.isDirty());
		assertFalse(barEditor.isDirty());
	}

	public void testDeclaratorDirty_1() throws Exception {
		assertFalse(refactoringPreferences.isSaveAllBeforeRefactoring());
		smudge(fooEditor);
		renameFooToFooBar(barEditor);
		assertFalse(fooEditor.isDirty());
		assertFalse(barEditor.isDirty());
	}

	public void testDeclaratorDirty_2() throws Exception {
		try {
			refactoringPreferences.setSaveAllBeforeRefactoring(true);
			smudge(fooEditor);
			renameFooToFooBar(fooEditor);
			assertFalse(fooEditor.isDirty());
			assertFalse(barEditor.isDirty());
		} finally {
			refactoringPreferences.setSaveAllBeforeRefactoring(false);
		}
	}

	public void testDeclaratorDirty_3() throws Exception {
		try {
			refactoringPreferences.setSaveAllBeforeRefactoring(true);
			smudge(fooEditor);
			renameFooToFooBar(barEditor);
			assertFalse(fooEditor.isDirty());
			assertFalse(barEditor.isDirty());
		} finally {
			refactoringPreferences.setSaveAllBeforeRefactoring(false);
		}
	}

	public void testReferrerDirty_0() throws Exception {
		assertFalse(refactoringPreferences.isSaveAllBeforeRefactoring());
		smudge(barEditor);
		renameFooToFooBar(fooEditor);
		assertFalse(fooEditor.isDirty());
		assertTrue(barEditor.isDirty());
	}

	public void testReferrerDirty_1() throws Exception {
		assertFalse(refactoringPreferences.isSaveAllBeforeRefactoring());
		smudge(barEditor);
		renameFooToFooBar(barEditor);
		assertFalse(fooEditor.isDirty());
		assertTrue(barEditor.isDirty());
	}

	public void testReferrerDirty_2() throws Exception {
		try {
			refactoringPreferences.setSaveAllBeforeRefactoring(true);
			smudge(barEditor);
			renameFooToFooBar(fooEditor);
			assertFalse(fooEditor.isDirty());
			assertFalse(barEditor.isDirty());
		} finally {
			refactoringPreferences.setSaveAllBeforeRefactoring(false);
		}
	}

	public void testReferrerDirty_3() throws Exception {
		try {
			refactoringPreferences.setSaveAllBeforeRefactoring(true);
			smudge(barEditor);
			renameFooToFooBar(barEditor);
			assertFalse(fooEditor.isDirty());
			assertFalse(barEditor.isDirty());
		} finally {
			refactoringPreferences.setSaveAllBeforeRefactoring(false);
		}
	}

	protected void renameFooToFooBar(final XtextEditor contextEditor) throws Exception {
		contextEditor.getEditorSite().getPage().activate(contextEditor);
		IXtextDocument document = contextEditor.getDocument();
		final int offset = document.get().indexOf("foo");
		contextEditor.selectAndReveal(offset, 3);
		IRenameElementContext context = document.readOnly(new IUnitOfWork<IRenameElementContext, XtextResource>() {
			public IRenameElementContext exec(XtextResource state) throws Exception {
				EObject target = eObjectAtOffsetHelper.resolveElementAt(state, offset);
				return renameElementHandler.createRenameElementContext(target, contextEditor, new TextSelection(offset,
						3), state);
			}
		});
		controller.initialize(context);
		waitForReconciler(contextEditor);
		waitForDisplay();
		controller.startRefactoring(RefactoringType.LINKED_EDITING);
		waitForDisplay();
		pressKeys(contextEditor, "fooBar\n");
		waitForDisplay();
		waitForReconciler(fooEditor);
		waitForReconciler(barEditor);
		waitForDisplay();
	}
}
