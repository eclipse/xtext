/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;

/**
 * Strategy for structural node selections based on a given root node.
 * 
 * @author Michael - Initial contribution and API
 */
public interface INodeSelectionProvider {
	String SELECT_ENCLOSING = "org.eclipse.xtext.ui.editor.select.enclosing"; //$NON-NLS-1$
	String SELECT_NEXT = "org.eclipse.xtext.ui.editor.select.next"; //$NON-NLS-1$
	String SELECT_PREVIOUS = "org.eclipse.xtext.ui.editor.select.previous"; //$NON-NLS-1$
	String SELECT_LAST = "org.eclipse.xtext.ui.editor.select.last"; //$NON-NLS-1$

	/**
	 * @param the
	 *            type of the selection to be provided (e.g. next,previous)
	 * @param currentTextSelection
	 *            the region of the currently selected text
	 * @param rootNode
	 *            the root node of the parse tree
	 * @return return the region of the new selection for the given type
	 */
	ITextRegion select(String selectionType, ICompositeNode rootNode, ITextRegion currentTextRegion);

	/**
	 * Initialize the NodeSelectionProvider with the given XtextEditor
	 */
	void initialize(XtextEditor xtextEditor);

}
