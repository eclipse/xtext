/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.testing;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;

import com.google.inject.Inject;

/**
 * @author miklossy - Initial contribution and API
 * 
 * @since 2.14
 */
public abstract class AbstractEditorDoubleClickTextSelectionTest extends AbstractEditorTest {

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	/**
	 * @return the special symbol indicating the current cursor position.
	 */
	public String c() {
		return "|";
	}

	/**
	 * @param charSequence
	 *            The editor's input text. The text must contain the {@link #c} special symbol indicating the current cursor position.
	 * 
	 * @param expected
	 *            The text that is expected to be selected after double clicking in the Xtext editor on the current cursor position.
	 */
	public void assertSelectedTextAfterDoubleClicking(CharSequence charSequence, String expected) {
		IFile file = createFile(getContent(charSequence));
		try {
			XtextEditor xtextEditor = openEditor(file);
			xtextEditor = doubleClick(xtextEditor, getCursorPosition(charSequence));
			assertSelectedText(xtextEditor, expected);
		} catch (Exception e) {
			throw new RuntimeException("Error opening editor associated with the file " + file.getName());
		}
	}

	protected void assertSelectedText(AbstractTextEditor textEditor, CharSequence expectedSelectedText) {
		ISelection selection = textEditor.getSelectionProvider().getSelection();
		String actualSelectedText = ((ITextSelection) selection).getText();
		assertEquals(expectedSelectedText, actualSelectedText);
	}

	protected String getContent(CharSequence text) {
		return text.toString().replace(c(), "");
	}

	protected IFile createFile(String content) {
		try {
			return IResourcesSetupUtil.createFile(getProjectName(), getFileName(), getFileExtension(), content);
		} catch (InvocationTargetException | CoreException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	protected String getProjectName() {
		return "Test";
	}

	protected String getFileName() {
		return "Foo";
	}

	protected String getFileExtension() {
		return fileExtensionProvider.getPrimaryFileExtension();
	}

	protected int getCursorPosition(CharSequence text) {
		int cursorPosition = text.toString().indexOf(c());
		if (cursorPosition == -1) {
			String message = "The input text\n%s\nmust contain the '%s' special symbol indicating the current cursor position!\n";
			fail(String.format(message, text, c()));
		}
		return cursorPosition;
	}

	protected XtextEditor doubleClick(XtextEditor xtextEditor, int cursorPosition) {
		ISourceViewer viewer = xtextEditor.getInternalSourceViewer();

		// Set the cursor position
		viewer.setSelectedRange(cursorPosition, 0);

		// Fire a mouse down event with the left mouse button
		Event event = new Event();
		event.button = 1;
		viewer.getTextWidget().notifyListeners(SWT.MouseDown, event);

		return xtextEditor;
	}

}
