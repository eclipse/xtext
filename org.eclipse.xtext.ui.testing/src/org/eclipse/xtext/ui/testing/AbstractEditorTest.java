/*******************************************************************************
 * Copyright (c) 2008, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import java.io.File;
import java.lang.reflect.Field;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.internal.ErrorEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Arne Deutsch - Added support for external files
 * 
 * @since 2.12
 */
public abstract class AbstractEditorTest extends AbstractWorkbenchTest {

	static final long STEP_DELAY = 0;

	@Inject protected XtextEditorInfo editorInfo;

	protected String getEditorId() {
		return editorInfo.getEditorId();
	}

	protected XtextEditor openEditor(IFile file) throws Exception {
		return getXtextEditor(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new FileEditorInput(file), getEditorId()));
	}

	protected XtextEditor openEditorForExternalFile(File file) throws Exception {
		IFileStore store = EFS.getLocalFileSystem().getStore(file.toURI());
		return getXtextEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.openEditor(new FileStoreEditorInput(store), getEditorId()));
	}

	private XtextEditor getXtextEditor(IEditorPart openEditor) throws NoSuchFieldException, IllegalAccessException {
		XtextEditor xtextEditor = EditorUtils.getXtextEditor(openEditor);
		if (xtextEditor != null) {
			ISourceViewer sourceViewer = xtextEditor.getInternalSourceViewer();
			((ProjectionViewer) sourceViewer).doOperation(ProjectionViewer.EXPAND_ALL);
			return xtextEditor;
		} else if (openEditor instanceof ErrorEditorPart) {
			Field field = openEditor.getClass().getDeclaredField("error");
			field.setAccessible(true);
			throw new IllegalStateException("Couldn't open the editor.", ((Status) field.get(openEditor)).getException());
		} else {
			fail("Opened Editor with id:" + getEditorId() + ", is not an XtextEditor");
		}
		return null;
	}

}