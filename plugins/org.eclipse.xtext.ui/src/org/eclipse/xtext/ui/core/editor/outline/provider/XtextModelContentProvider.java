/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.outline.provider;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.ui.core.editor.model.XtextEditorModel;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class XtextModelContentProvider extends StaticTreeContentProvider implements ITreeContentProvider {

	protected static final Object[] EMPTY_ARRAY = new Object[0];

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof EObject) {
			EObject parentNode = (EObject) parentElement;
			EList<EObject> contents = parentNode.eContents();
			return contents.toArray();
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
			return (eobject.eContents().size() > 0);
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof XtextEditorModel) {
			XtextEditorModel xtextEditorModel = (XtextEditorModel) inputElement;
			Notifier astRoot = xtextEditorModel.getAstRoot();
			return new Object[] { astRoot };
		}
		return EMPTY_ARRAY;
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

}
