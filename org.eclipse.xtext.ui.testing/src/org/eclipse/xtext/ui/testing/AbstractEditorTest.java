/*******************************************************************************
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.testing;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.internal.ErrorEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;

import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Arne Deutsch - Added support for external files
 * 
 * @since 2.12
 */
public abstract class AbstractEditorTest extends AbstractWorkbenchTest {

	static final long STEP_DELAY = 0;

	@Inject
	protected XtextEditorInfo editorInfo;

	protected String getEditorId() {
		return editorInfo.getEditorId();
	}

	protected XtextEditor openEditor(IFile file) throws Exception {
		IEditorPart editor = getActivePage().openEditor(new FileEditorInput(file), getEditorId());
		return getXtextEditor(editor);
	}

	protected XtextEditor openEditorForExternalFile(File file) throws Exception {
		IFileStore store = EFS.getLocalFileSystem().getStore(file.toURI());
		IEditorPart editor = getActivePage().openEditor(new FileStoreEditorInput(store), getEditorId());
		return getXtextEditor(editor);
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

	protected IFile dslFile(String projectName, String fileName, String fileExtension, CharSequence content) {
		try {
			IFile file = IResourcesSetupUtil.createFile(projectName, fileName, fileExtension, content.toString());
			IProject project = file.getProject();
			if (!project.hasNature(XtextProjectHelper.NATURE_ID)) {
				IResourcesSetupUtil.addNature(project, XtextProjectHelper.NATURE_ID);
			}
			return file;
		} catch (InvocationTargetException | CoreException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
