/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.junit.editor;

import java.lang.reflect.Field;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.ErrorEditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 * @deprecated use org.eclipse.xtext.junit4.ui.AbstractEditorTest instead. This class will be removed in Xtext 2.9.
 */
@Deprecated
@SuppressWarnings("restriction")
public abstract class AbstractEditorTest extends AbstractWorkbenchTest {

	static final long STEP_DELAY = 0;
	
	protected abstract String getEditorId();

	protected AbstractEditorTest() {
		super();
	}

	protected AbstractEditorTest(String name) {
		super(name);
	}

	protected XtextEditor openEditor(IFile file) throws Exception {
		IEditorPart openEditor = openEditor(file, getEditorId());
		XtextEditor xtextEditor = EditorUtils.getXtextEditor(openEditor);
		if (xtextEditor != null) {
			return xtextEditor;
		}
		else if (openEditor instanceof ErrorEditorPart) {
			Field field = openEditor.getClass().getDeclaredField("error");
			field.setAccessible(true);
			throw new IllegalStateException("Couldn't open the editor.",((Status)field.get(openEditor)).getException());
		}
		else {
			fail("Opened Editor with id:" + getEditorId() + ", is not an XtextEditor");
		}
		return null;
	}

	private IEditorPart openEditor(IFile file, String editorId) throws PartInitException {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
				new FileEditorInput(file), editorId);
	}

}