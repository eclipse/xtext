/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.mpe;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Injector;

/**
 * A very simple multi page editor, used as a test bed.
 * 
 * @author Peter Friese - Initial contribution and API
 */
public class MultiPageEditor extends MultiPageEditorPart {
	
	private XtextEditor editor;

	public MultiPageEditor() {
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {
			@Override
			public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
				if (adaptableObject instanceof MultiPageEditor) {
					MultiPageEditor mpe = (MultiPageEditor) adaptableObject;
					return adapterType.cast(mpe.editor);
				}
				return null;
			}
			@Override
			public Class<?>[] getAdapterList() {
				return new Class[]{XtextEditor.class};
			}
		}, MultiPageEditor.class);
	}

	@Override
	protected void createPages() {
		createXtextPage();
	}
	
	void createXtextPage() {
		try {
			Injector injector = org.eclipse.xtext.ui.tests.internal.TestsActivator.getInstance().getInjector("org.eclipse.xtext.ui.tests.TestLanguage");
			editor = injector.getInstance(XtextEditor.class);
			int index = addPage(editor, getEditorInput());
			setPageText(index, editor.getTitle());
		} catch (PartInitException e) {
			ErrorDialog.openError(
				getSite().getShell(),
				"Error creating nested text editor",
				null,
				e.getStatus());
		}
	}
	

	@Override
	public void doSave(IProgressMonitor monitor) {
		getEditor(0).doSave(monitor);
	}

	@Override
	public void doSaveAs() {
		IEditorPart editor = getEditor(0);
		editor.doSaveAs();
		setPageText(0, editor.getTitle());
		setInput(editor.getEditorInput());
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

}
