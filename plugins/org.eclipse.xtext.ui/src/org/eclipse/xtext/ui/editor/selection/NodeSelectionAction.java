/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class NodeSelectionAction extends Action {
	private XtextEditor xtextEditor;
	private SelectionHistory selectionHistory;
	private INodeSelectionProvider nodeSelectionProvider;

	public XtextEditor getXtextEditor() {
		return xtextEditor;
	}

	public SelectionHistory getSelectionHistory() {
		return selectionHistory;
	}

	public INodeSelectionProvider getNodeSelectionProvider() {
		return nodeSelectionProvider;
	}

	public NodeSelectionAction(String text, XtextEditor xtextEditor, SelectionHistory selectionHistory,
			INodeSelectionProvider nodeSelectionProvider) {
		super(text);
		Assert.isNotNull(xtextEditor);
		Assert.isNotNull(selectionHistory);
		Assert.isNotNull(nodeSelectionProvider);
		this.xtextEditor = xtextEditor;
		this.selectionHistory = selectionHistory;
		this.nodeSelectionProvider = nodeSelectionProvider;
	}

	@Override
	public void run() {
		final ITextRegion selection = getTextSelection();
		ITextRegion nextSelection = xtextEditor.getDocument().readOnly(createTextSelectionWork(selection));
		if (selection.getOffset() == nextSelection.getOffset() && selection.getLength() == nextSelection.getLength()) {
			return;
		}
		selectionHistory.remember(new TextRegion(selection.getOffset(), selection.getLength()));
		try {
			selectionHistory.ignoreSelectionChanges();
			xtextEditor.selectAndReveal(nextSelection.getOffset(), nextSelection.getLength());
		} finally {
			selectionHistory.listenToSelectionChanges();
		}
	}

	protected IUnitOfWork<ITextRegion, XtextResource> createTextSelectionWork(final ITextRegion selection) {
		return new IUnitOfWork<ITextRegion, XtextResource>() {
			public ITextRegion exec(XtextResource xtextResource) throws Exception {
				return select(xtextResource.getParseResult().getRootNode(), selection);
			}
		};
	}

	protected ITextRegion select(ICompositeNode rootNode, ITextRegion textRegion) {
		return nodeSelectionProvider.select(rootNode, textRegion);
	}

	private ITextRegion getTextSelection() {
		ITextSelection selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
		return new TextRegion(selection.getOffset(), selection.getLength());
	}
}
