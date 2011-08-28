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
 * Strategy for structural node selections based on the (parse-tree) node model.
 * 
 * @author Michael - Initial contribution and API
 */
public interface INodeSelectionProvider {
	/**
	 * @param currentTextSelection
	 *            the region of the currently selected text
	 * @param rootNode
	 *            the root node of the parse tree
	 * @return return the new text selection
	 */
	ITextRegion select(ICompositeNode rootNode, ITextRegion currentTextRegion);

	void initialize(XtextEditor xtextEditor);
}
