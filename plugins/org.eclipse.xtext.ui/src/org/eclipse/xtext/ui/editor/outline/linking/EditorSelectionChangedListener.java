/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.linking;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.xtext.ui.editor.outline.XtextContentOutlinePage;

/**
 * This listener listens to selections in the text editor and will update the outline selection accordingly.
 * 
 * @author Peter Friese - Initial contribution and API
 * @author Michael Clay
 */
public final class EditorSelectionChangedListener extends AbstractSelectionChangedListener {

	public EditorSelectionChangedListener(XtextContentOutlinePage outlinePage) {
		super(outlinePage);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (!selection.isEmpty() && selection instanceof ITextSelection) {
			outlinePage.synchronizeOutlinePage();
		}
	}

}
