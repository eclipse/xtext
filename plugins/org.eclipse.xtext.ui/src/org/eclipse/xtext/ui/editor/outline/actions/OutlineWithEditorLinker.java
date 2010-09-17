/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author koehnlein - Initial contribution and API
 */
public class OutlineWithEditorLinker {

	private ISourceViewer textViewer;

	private StructuredViewer treeViewer;

	private TreeListener treeListener;

	private TextListener textListener;

	private boolean isLinkingEnabled;

	protected class TreeListener implements ISelectionChangedListener, IDoubleClickListener {
		public void selectionChanged(SelectionChangedEvent event) {
			if (isLinkingEnabled && treeViewer.getControl().isFocusControl())
				selectInTextEditor(event.getSelection());
		}

		public void doubleClick(DoubleClickEvent event) {
			selectInTextEditor(event.getSelection());
		}
	}

	protected class TextListener implements ISelectionChangedListener {
		public void selectionChanged(SelectionChangedEvent event) {
			if (isLinkingEnabled)
				selectInTreeView(event.getSelection());
		}
	}

	public OutlineWithEditorLinker() {
	}

	public void activate(OutlinePage outlinePage)  {
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

		treeViewer.removePostSelectionChangedListener(treeListener);
		treeViewer.removeDoubleClickListener(treeListener);
		treeListener = null;
	}

	public void setLinkingEnabled(boolean enabled) {
		isLinkingEnabled = enabled;
		if (enabled) {
			ISelection selection = treeViewer.getSelection();
			selectInTextEditor(selection);
		}
	}
	
	protected void selectInTextEditor(ISelection selection) {
		IOutlineNode selectedOutlineNode = getSelectedOutlineNode(selection);
		if (selectedOutlineNode != null) {
			ITextRegion textRegion = selectedOutlineNode.getShortTextRegion();
			if (textRegion != null) {
				int offset = textRegion.getOffset();
				int length = textRegion.getLength();
				textViewer.setRangeIndication(offset, length, true);
				textViewer.revealRange(offset, length);
				textViewer.setSelectedRange(offset, length);
			}
		}
	}

	protected void selectInTreeView(ISelection selection) {
		if (selection instanceof ITextSelection) {
			ITextSelection textSelection = (ITextSelection) selection;
			ITextRegion selectedTextRegion = new TextRegion(textSelection.getOffset(), textSelection.getLength());
			Object input = treeViewer.getInput();
			if (input instanceof IOutlineNode) {
				IOutlineNode nodeToBeSelected = findBestNode((IOutlineNode) input, selectedTextRegion);
				if (nodeToBeSelected != null)
					treeViewer.setSelection(new StructuredSelection(nodeToBeSelected));
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
						&& (currentBestNode.getFullTextRegion() == null || currentBestNode.getFullTextRegion().getLength() > candidate
								.getFullTextRegion().getLength())) {
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
}
