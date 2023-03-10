/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.external;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.testing.AbstractEditorTest;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Tests for files that do not reside in the workspace but are opened with Xtext editor.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.15
 */
public class ExternalEditorTest extends AbstractEditorTest {

	@Inject
	private IHyperlinkDetector detector;

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.TestLanguage";
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		IResourceServiceProvider rsp = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createURI("dummy.testlanguage"));
		rsp.get(Injector.class).injectMembers(this);
	}

	@Test
	public void navigateUsingHyperlinkInsideExternalFile() throws Exception {
		String content = "stuff foo stuff bar refs foo";
		XtextEditor editor = createFileAndOpenInExternalEditor(content);

		clickAtHyperlinkAt(editor, content.indexOf("refs foo") + "refs f".length());

		assertSelectionIsAtOffset(editor, "stuff ".length());
	}

	@Test
	public void saveExternalFile() throws Exception {
		XtextEditor editor = createFileAndOpenInExternalEditor("stuff foo");

		setContentAndSave(editor, "stuff foo stuff bar refs foo");

		assertEquals("stuff foo stuff bar refs foo", editor.getDocument().get());
		assertFalse(editor.isDirty());
	}

	private XtextEditor createFileAndOpenInExternalEditor(String content)
			throws CoreException, InvocationTargetException, InterruptedException, Exception {
		File file = createTempFile("foo", ".testlanguage", content);
		XtextEditor editor = openEditorForExternalFile(file);
		return editor;
	}

	private void clickAtHyperlinkAt(XtextEditor editor, int offset) {
		editor.selectAndReveal(offset, 0);
		IHyperlink[] hyperlinks = detector.detectHyperlinks(editor.getInternalSourceViewer(),
				new Region(((ITextSelection) editor.getSelectionProvider().getSelection()).getOffset(), 0), false);
		hyperlinks[0].open();
	}

	private void assertSelectionIsAtOffset(XtextEditor editor, int expectedOffset) {
		ITextSelection newSelection = (ITextSelection) editor.getSelectionProvider().getSelection();
		assertEquals(expectedOffset, newSelection.getOffset());
	}

	private void setContentAndSave(XtextEditor editor, String newContent) {
		editor.getDocument().set(newContent);
		editor.doSave(new NullProgressMonitor());
	}

}
