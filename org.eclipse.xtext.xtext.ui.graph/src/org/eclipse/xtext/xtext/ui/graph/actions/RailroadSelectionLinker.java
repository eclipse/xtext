/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph.actions;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xtext.ui.graph.RailroadSelectionProvider;
import org.eclipse.xtext.xtext.ui.graph.RailroadView;
import org.eclipse.xtext.xtext.ui.graph.RailroadViewPreferences;
import org.eclipse.xtext.xtext.ui.graph.figures.IEObjectReferer;
import org.eclipse.xtext.xtext.ui.graph.figures.ISelectable;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class RailroadSelectionLinker implements IPropertyChangeListener {

	private static final String XTEXT_LANGUAGE_NAME = "org.eclipse.xtext.Xtext";

	@Inject
	private IURIEditorOpener uriEditorOpener;

	@Inject
	private RailroadView view;

	private XtextEditor currentEditor;

	private ISelectable currentSelectedNode;

	@Inject
	private RailroadViewPreferences preferences;

	private ISelectionChangedListener diagramSelectionChangeListener = new ISelectionChangedListener() {
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (view.getControl().isFocusControl())
				diagramSelectionChanged(event);
		}
	};

	private ISelectionChangedListener textSelectionChangeListener = new ISelectionChangedListener() {
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (preferences.isLinkWithEditor() && view.getSite().getPage().getActivePart() != view)
				textSelectionChanged(event);
		}
	};

	public void activate() {
		view.getSite().getSelectionProvider().addSelectionChangedListener(diagramSelectionChangeListener);
		preferences.getPreferenceStore().addPropertyChangeListener(this);
		if (preferences.isLinkWithEditor())
			selectGrammarText(currentSelectedNode, false);
	}

	public void deactivate() {
		view.getSite().getSelectionProvider().removeSelectionChangedListener(diagramSelectionChangeListener);
		if (currentEditor != null)
			removeTextSelectionListener(currentEditor);
		preferences.getPreferenceStore().removePropertyChangeListener(this);
	}

	protected void selectFigure(IFigure selectedFigure) {
		while (selectedFigure != null && !(selectedFigure instanceof IEObjectReferer))
			selectedFigure = selectedFigure.getParent();
		if (selectedFigure != null) {
			if (currentSelectedNode != null)
				currentSelectedNode.setSelected(false);
			if (selectedFigure instanceof ISelectable) {
				((ISelectable) selectedFigure).setSelected(true);
				currentSelectedNode = (ISelectable) selectedFigure;
			} else {
				currentSelectedNode = null;
			}
		}
	}

	protected void selectGrammarText(IFigure selectedFigure, boolean isActivateEditor) {
		if (selectedFigure != null) {
			IEObjectReferer element = (IEObjectReferer) selectedFigure;
			final URI grammarElementURI = element.getEObjectURI();
			if (grammarElementURI != null) {
				final boolean isSelectElement = selectedFigure instanceof ISelectable;
				// enqueue to make sure the diagram is updated before
				if (isActivateEditor && isSelectElement) {
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							uriEditorOpener.open(grammarElementURI, isSelectElement);
						}
					});
				} else {
					uriEditorOpener.open(grammarElementURI, isSelectElement);
					view.getSite().getPage().activate(view);
				}
			}
		}
	}

	public void diagramSelectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				Object selectedElement = structuredSelection.getFirstElement();
				if (selectedElement instanceof IFigure) {
					IFigure selectedFigure = (IFigure) selectedElement;
					selectFigure(selectedFigure);
					boolean isDoubleClick = event instanceof RailroadSelectionProvider.DoubleClickEvent;
					if ((currentEditor == null || !currentEditor.getInternalSourceViewer().getTextWidget()
							.isFocusControl())
							&& (isDoubleClick || preferences.isLinkWithEditor()))
						selectGrammarText(selectedFigure, isDoubleClick);
				}
			}
		}
	}

	public void textSelectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof ITextSelection && !selection.isEmpty()) {
			ITextSelection textSelection = (ITextSelection) selection;
			int offset = textSelection.getOffset();
			IFigure figureToBeSelected = findFigureForTextOffset(view.getContents(), offset, null);
			if (figureToBeSelected != null) {
				selectFigure(figureToBeSelected);
				view.reveal(figureToBeSelected);
			}
		}
	}

	protected ISelectable findFigureForTextOffset(IFigure figure, int offset, ISelectable currentBestFigure) {
		if(figure == null)
			return null;
		if (figure instanceof ISelectable) {
			Region textRegion = ((ISelectable) figure).getTextRegion();
			if (textRegion != null && textRegion.getOffset() <= offset
					&& textRegion.getOffset() + textRegion.getLength() >= offset) {
				if(currentBestFigure == null || currentBestFigure.getTextRegion().getLength() > textRegion.getLength()) {
					currentBestFigure = (ISelectable) figure;
				}
			}
		}
		for (Object child : figure.getChildren()) {
			if (child instanceof IFigure) {
				currentBestFigure = findFigureForTextOffset((IFigure) child, offset, currentBestFigure);
			}
		}
		return currentBestFigure;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(RailroadViewPreferences.LINK_WITH_EDITOR_KEY)
				&& event.getNewValue() == Boolean.TRUE) {
			if (currentSelectedNode != null)
				selectGrammarText(currentSelectedNode, true);
		}
	}

	public void setXtextEditor(XtextEditor xtextEditor) {
		if (currentEditor != null) {
			removeTextSelectionListener(currentEditor);
		}
		if (XTEXT_LANGUAGE_NAME.equals(xtextEditor.getLanguageName())) {
			currentEditor = xtextEditor;
			ISelectionProvider selectionProvider = xtextEditor.getSelectionProvider();
			if (selectionProvider instanceof IPostSelectionProvider)
				((IPostSelectionProvider) selectionProvider)
						.addPostSelectionChangedListener(textSelectionChangeListener);
			else
				selectionProvider.addSelectionChangedListener(textSelectionChangeListener);
		}
	}

	protected void removeTextSelectionListener(XtextEditor editor) {
		ISelectionProvider selectionProvider = editor.getSelectionProvider();
		if (selectionProvider != null) {
			if (selectionProvider instanceof IPostSelectionProvider)
				((IPostSelectionProvider) selectionProvider)
						.removePostSelectionChangedListener(textSelectionChangeListener);
			else
				selectionProvider.removeSelectionChangedListener(textSelectionChangeListener);
		}
	}
}
