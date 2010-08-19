/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.linking;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.xtext.ui.editor.outline.IContentOutlineNode;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;

/**
 * This listener listens to selections in the outline and will update the editor selection accordingly.
 * 
 * @author Peter Friese - Initial contribution and API
 */
public final class OutlineSelectionChangedListener extends AbstractSelectionChangedListener implements IDoubleClickListener {

	public OutlineSelectionChangedListener(XtextContentOutlinePage outlinePage) {
		super(outlinePage);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		if (outlinePage.getControl().isFocusControl() && outlinePage.isLinkingEnabled()) {
			selectTextRegion(event.getSelection());
		}
	}

	protected void selectTextRegion(ISelection sel) {
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) sel;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IContentOutlineNode) {
				IContentOutlineNode outlineNode = (IContentOutlineNode) firstElement;
				if (outlineNode.getRegion() != null) {
					getSourceViewer().setRangeIndication(outlineNode.getSelectionOffset(),
							outlineNode.getSelectionLength(), true);
					getSourceViewer().revealRange(outlineNode.getSelectionOffset(),
							outlineNode.getSelectionLength());
					getSourceViewer().setSelectedRange(outlineNode.getSelectionOffset(),
							outlineNode.getSelectionLength());
				}
			}
		}
	}

	public void doubleClick(DoubleClickEvent event) {
		selectTextRegion(event.getSelection());
	}
}
