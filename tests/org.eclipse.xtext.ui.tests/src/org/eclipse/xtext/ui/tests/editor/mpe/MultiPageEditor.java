/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
			@SuppressWarnings("rawtypes")
			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof MultiPageEditor) {
					MultiPageEditor mpe = (MultiPageEditor) adaptableObject;
					return mpe.editor;
				}
				return null;
			}
			@SuppressWarnings("rawtypes")
			public Class[] getAdapterList() {
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
			Injector injector = org.eclipse.xtext.ui.tests.Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.TestLanguage");
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
