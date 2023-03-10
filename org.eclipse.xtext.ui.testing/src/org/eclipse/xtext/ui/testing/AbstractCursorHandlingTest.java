/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.12
 */
public abstract class AbstractCursorHandlingTest extends AbstractEditorTest {

	private List<IFile> files = Lists.newArrayList();
	
	protected abstract String getFileExtension();
	
	@Override
	@Before @BeforeEach
	public void setUp() throws Exception {
		super.setUp();
		closeWelcomePage();
	}
	
	@Override
	@After @AfterEach
	public void tearDown() throws Exception {
		files.clear();
		closeEditors();
		super.tearDown();
	}

	protected XtextEditor openEditor(String content) throws Exception {
		int cursor = content.indexOf('|');
		String fileExtension = getFileExtension();
		IFile file = createFile("foo/myfile" + files.size() + "." + fileExtension, content.replace("|", ""));
		files.add(file);
		XtextEditor editor = openEditor(file);
		editor.getInternalSourceViewer().setSelectedRange(cursor, 0);
		editor.getInternalSourceViewer().getTextWidget().setFocus();
		return editor;
	}

	protected void assertState(String string, XtextEditor editor) {
		int cursor = string.indexOf('|');
		assertEquals(string.replace("|", ""), editor.getDocument().get());
		ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
		assertEquals("unexpected cursor position:",cursor, selection.getOffset());
	}
	
	protected void navigateLeft(XtextEditor editor) {
		IAction action = editor.getAction(ITextEditorActionDefinitionIds.WORD_PREVIOUS);
		action.run();
	}
	
	protected void navigateRight(XtextEditor editor) {
		IAction action = editor.getAction(ITextEditorActionDefinitionIds.WORD_NEXT);
		action.run();
	}
	
	protected void toLineStart(XtextEditor editor) {
		IAction action = editor.getAction(ITextEditorActionDefinitionIds.LINE_START);
		action.run();
	}
}
