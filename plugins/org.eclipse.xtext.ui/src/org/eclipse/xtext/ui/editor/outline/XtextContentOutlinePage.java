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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPageSite;
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
 * An outline page for Xtext based editors.
 * 
 * @author Peter Friese - Initial contribution and API
 */
public class XtextContentOutlinePage extends ContentOutlinePage implements IContentOutlinePage {

	public static final String XTEXT_CONTENT_OUTLINE_PAGE_SORTING_ACTION_IS_CHECKED = "XtextContentOutlinePage.SortingAction.isChecked";

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
		viewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
		viewer.setUseHashlookup(true);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				firePostSelectionChanged(event.getSelection());
			}
		});

		XtextModelContentProvider modelContentProvider = new XtextModelContentProvider(xtextBaseEditor);
		viewer.setContentProvider(modelContentProvider);
		viewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new XtextLabelProviderDelegator(ServiceRegistry
				.getService(xtextBaseEditor.getLanguageDescriptor(), ILabelProvider.class))));
		viewer.setComparer(new IElementComparer() {

			public boolean equals(Object a, Object b) {
				if (a instanceof EObject) {
					EObject ea = (EObject) a;
					if (b instanceof EObject) {
						EObject eb = (EObject) b;
						URI uriA = EcoreUtil.getURI(ea);
						URI uriB = EcoreUtil.getURI(eb);
						return uriA.equals(uriB);
					}
					else {
						return false;
					}
				}
				else {
					return a.equals(b);
				}
			}

			public int hashCode(Object element) {
				if (element instanceof EObject) {
					return EcoreUtil.getURI((EObject) element).hashCode();
				}
				else {
					return element.hashCode();
				}
			}

		});

		if (model != null) {
			setViewerInput(model);
		}
	}

	private void registerToolbarActions(IActionBars actionBars) {
		IToolBarManager toolBarManager = actionBars.getToolBarManager();
		if (toolBarManager != null) {
			toolBarManager.add(new ToggleLinkWithEditorAction(xtextBaseEditor));
			toolBarManager.add(new XtextOutlineSortingAction(this));
		}
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		registerToolbarActions(getSite().getActionBars());
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

	public void setSelection(ISelection selection) {
		if (getTreeViewer() != null) {
			getTreeViewer().setSelection(selection, true);
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

	private ViewerComparator alphaComparator = new ViewerComparator() {
		@SuppressWarnings("unchecked")
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			XtextLabelProviderDelegator labelProvider = new XtextLabelProviderDelegator(ServiceRegistry.getService(
					xtextBaseEditor.getLanguageDescriptor(), ILabelProvider.class));
			String text1 = labelProvider.getText(e1);
			String text2 = labelProvider.getText(e2);
			return getComparator().compare(text1, text2);
		}
	};

	public void sort(boolean on) {
		if (on) {
			getTreeViewer().setComparator(alphaComparator);
		}
		else {
			getTreeViewer().setComparator(null);
		}
	}
}
