/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.editor.BaseTextEditor;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.model.XtextEditorModel;
import org.eclipse.xtext.ui.service.IOutlineProvider;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class XtextModelContentProvider implements ITreeContentProvider {

	protected static final Object[] EMPTY_ARRAY = new Object[0];
	
	private IOutlineProvider delegate;
    private IServiceScope languageDescriptor;

    public XtextModelContentProvider(BaseTextEditor editor) {
	    languageDescriptor = editor.getLanguageDescriptor();
	    delegate = ServiceRegistry.getService(languageDescriptor, IOutlineProvider.class);
	}
	
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof EObject) {
			EObject parentNode = (EObject) parentElement;
			return delegate.getChildren(parentNode);
		}
		else {
			return EMPTY_ARRAY;
		}
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		if (element instanceof EObject) {
			EObject eobject = (EObject) element;
			return delegate.hasChildren(eobject);
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof XtextEditorModel) {
			IEditorModel xtextEditorModel = (IEditorModel) inputElement;
			return delegate.getRootObjects(xtextEditorModel);
		}
		return EMPTY_ARRAY;
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

}
