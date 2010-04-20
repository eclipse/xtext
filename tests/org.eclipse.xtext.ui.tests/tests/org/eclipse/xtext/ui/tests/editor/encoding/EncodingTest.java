/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.encoding;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.tests.editor.AbstractEditorTest;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EncodingTest extends AbstractEditorTest {

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.editor.encoding.EncodingUiTestLanguage";
	}

	@Override
	protected void tearDown() throws Exception {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
		super.tearDown();
	}

	public void testFileEncodingIsUsedInEMFResource() throws Exception {
		IFile file = createFile("foo/x_default.encodinguitestlanguage", "");
		openEditorAndCheckEncoding(file, ResourcesPlugin.getWorkspace().getRoot().getDefaultCharset());
		file = createFile("foo/x_utf.encodinguitestlanguage", "");
		file.setCharset("UTF-8", null);
		openEditorAndCheckEncoding(file, "UTF-8");
		file = createFile("foo/x_iso.encodinguitestlanguage", "");
		file.setCharset("ISO-8859-1", null);
		openEditorAndCheckEncoding(file, "ISO-8859-1");
	}

	protected void openEditorAndCheckEncoding(IFile file, final String charset) throws CoreException, Exception {
		XtextEditor openedEditor = openEditor(file);
		assertNotNull(openedEditor);
		IXtextDocument document = openedEditor.getDocument();
		document.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource resource) throws Exception {
				assertEquals(charset, resource.getEncoding());
			}
		});
		openedEditor.close(false);
		openedEditor.dispose();
	}

}
