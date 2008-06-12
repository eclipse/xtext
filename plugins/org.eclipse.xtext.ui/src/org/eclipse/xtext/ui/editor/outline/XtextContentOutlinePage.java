/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.ui.editor.BaseTextEditor;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener;
import org.eclipse.xtext.ui.editor.model.XtextEditorModel;
import org.eclipse.xtext.ui.editor.model.XtextEditorModelChangeEvent;
import org.eclipse.xtext.ui.service.ILabelProvider;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class XtextContentOutlinePage extends ContentOutlinePage implements IContentOutlinePage {

	private ListenerList postSelectionChangedListeners = new ListenerList();
	private IEditorModel model;
	private IXtextEditorModelListener xtextEditorModelListener;
	private final BaseTextEditor xtextBaseEditor;

	public XtextContentOutlinePage(BaseTextEditor xtextBaseEditor) {
		this.xtextBaseEditor = xtextBaseEditor;
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		TreeViewer viewer = getTreeViewer();
		viewer.setContentProvider(new XtextModelContentProvider(xtextBaseEditor));
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new XtextLabelProviderDelegator(ServiceRegistry
				.getService(model.getLanguageDescriptor(), ILabelProvider.class))));

		if (model != null) {
			setViewerInput(model);
		}
	}

	public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
		postSelectionChangedListeners.add(listener);
	}

	public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
		postSelectionChangedListeners.remove(listener);
	}

	private void firePostSelectionChanged(ISelection selection) {
		// create an event
		SelectionChangedEvent event = new SelectionChangedEvent(this, selection);

		// fire the event
		Object[] listeners = postSelectionChangedListeners.getListeners();
		for (int i = 0; i < listeners.length; ++i) {
			((ISelectionChangedListener) listeners[i]).selectionChanged(event);
		}
	}

	private void setViewerInput(Object newInput) {
		TreeViewer tree = getTreeViewer();
		Object oldInput = tree.getInput();

		boolean isXtextEditorModel = (newInput instanceof XtextEditorModel);
		boolean wasXtextEditorModel = (oldInput instanceof XtextEditorModel);

		if (isXtextEditorModel && !wasXtextEditorModel) {
			if (xtextEditorModelListener == null) {
				xtextEditorModelListener = createXtextEditorModelChangeListener();
			}
			IEditorModel xtextEditorModel = (IEditorModel) newInput;
			xtextEditorModel.addModelListener(xtextEditorModelListener);
		}
		else if (!isXtextEditorModel && wasXtextEditorModel && xtextEditorModelListener != null) {
			IEditorModel xtextEditorModel = (IEditorModel) oldInput;
			xtextEditorModel.removeModelListener(xtextEditorModelListener);
			xtextEditorModelListener = null;
		}

		Object[] expandedElements = tree.getExpandedElements();
		tree.setInput(newInput);
		tree.setExpandedElements(expandedElements);
	}

	public void setInput(IEditorModel model) {
		this.model = model;
		if (getTreeViewer() != null) {
			setViewerInput(model);
		}
	}

	private IXtextEditorModelListener createXtextEditorModelChangeListener() {
		return new IXtextEditorModelListener() {
			public void modelChanged(final XtextEditorModelChangeEvent event) {
				if (event.getModel() == model && !getControl().isDisposed()) {
					getControl().getDisplay().asyncExec(new Runnable() {
						public void run() {
							Control ctrl = getControl();
							if (ctrl != null && !ctrl.isDisposed()) {
								Object[] expandedElements = getTreeViewer().getExpandedElements();
								getTreeViewer().refresh();
								getTreeViewer().setExpandedElements(expandedElements);
							}
						}
					});
				}
			}
		};
	}

}
