/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeElementOpener;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OutlineWithEditorLinker implements IPropertyChangeListener {

	protected ISourceViewer textViewer;

	protected TreeViewer treeViewer;

	protected TreeListener treeListener;

	protected TextListener textListener;

	protected boolean isLinkingEnabled;

	protected OutlinePage outlinePage;
	
	@Inject
	private OutlineNodeElementOpener elementOpener;
	
	protected class TreeListener implements ISelectionChangedListener, IDoubleClickListener {
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (isLinkingEnabled && isOutlineViewActive())
				selectInTextEditor(event.getSelection());
		}

		@Override
		public void doubleClick(DoubleClickEvent event) {
			selectInTextEditor(event.getSelection());
			textViewer.getTextWidget().setFocus();
		}
	}

	protected class TextListener implements ISelectionChangedListener {
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (isLinkingEnabled && !isOutlineViewActive())
				selectInTreeView(event.getSelection());
		}
	}

	public OutlineWithEditorLinker() {
	}

	public void activate(OutlinePage outlinePage) {
		this.outlinePage = outlinePage;
		treeViewer = outlinePage.getTreeViewer();
		treeListener = new TreeListener();
		treeViewer.addPostSelectionChangedListener(treeListener);
		treeViewer.addDoubleClickListener(treeListener);
		textViewer = outlinePage.getSourceViewer();
		textListener = new TextListener();
		ISelectionProvider textSelectionProvider = textViewer.getSelectionProvider();
		if (textSelectionProvider instanceof IPostSelectionProvider)
			((IPostSelectionProvider) textSelectionProvider).addPostSelectionChangedListener(textListener);
		else
			textSelectionProvider.addSelectionChangedListener(textListener);
	}

	public void deactivate() {
		ISelectionProvider textSelectionProvider = textViewer.getSelectionProvider();
		if (textSelectionProvider instanceof IPostSelectionProvider)
			((IPostSelectionProvider) textSelectionProvider).removePostSelectionChangedListener(textListener);
		else
			textSelectionProvider.removeSelectionChangedListener(textListener);
		textListener = null;
		textViewer = null;
		treeViewer.removePostSelectionChangedListener(treeListener);
		treeViewer.removeDoubleClickListener(treeListener);
		treeViewer = null;
		treeListener = null;
		outlinePage = null;
	}

	public void setLinkingEnabled(boolean enabled) {
		isLinkingEnabled = enabled;
		if (enabled && treeViewer != null && !treeViewer.getTree().isDisposed()) {
			ISelection selection = treeViewer.getSelection();
			selectInTextEditor(selection);
		}
	}

	protected void selectInTextEditor(ISelection selection) {
		IOutlineNode selectedOutlineNode = getSelectedOutlineNode(selection);
		elementOpener.open(selectedOutlineNode, textViewer);
	}

	protected void selectInTreeView(ISelection selection) {
		if (selection instanceof ITextSelection && !treeViewer.getTree().isDisposed()) {
			ITextSelection textSelection = (ITextSelection) selection;
			ITextRegion selectedTextRegion = new TextRegion(textSelection.getOffset(), textSelection.getLength());
			Object input = treeViewer.getInput();
			if (input instanceof IOutlineNode) {
				try {
					IOutlineNode nodeToBeSelected = findBestNode((IOutlineNode) input, selectedTextRegion);
					if (nodeToBeSelected != null)
						treeViewer.setSelection(new StructuredSelection(nodeToBeSelected));
				} catch(Exception exc) {
					// ignore, editor can have a different state than the tree
				}
			}
		}
	}

	protected IOutlineNode findBestNode(IOutlineNode input, ITextRegion selectedTextRegion) {
		ITextRegion textRegion = input.getFullTextRegion();
		if (textRegion == null || textRegion.contains(selectedTextRegion)) {
			IOutlineNode currentBestNode = input;
			for (IOutlineNode child : input.getChildren()) {
				IOutlineNode candidate = findBestNode(child, selectedTextRegion);
				if (candidate != null
						&& (currentBestNode.getFullTextRegion() == null || candidate.getFullTextRegion() != null
								&& currentBestNode.getFullTextRegion().getLength() >= candidate.getFullTextRegion().getLength())) {
					currentBestNode = candidate;
				}
			}
			return currentBestNode;
		}
		return null;
	}

	protected IOutlineNode getSelectedOutlineNode(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
			if (selectedElement instanceof IOutlineNode)
				return (IOutlineNode) selectedElement;
		}
		return null;
	}
	
	protected boolean isOutlineViewActive() {
		IWorkbenchPart activePart = outlinePage.getSite().getPage().getActivePart();
		return activePart instanceof ContentOutline;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(LinkWithEditorOutlineContribution.PREFERENCE_KEY.equals(event.getProperty())) {
			setLinkingEnabled(Boolean.parseBoolean(event.getNewValue().toString()));
		}
	}
}
