/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.ImplementedBy;

/**
 * Strategy for structural node selections based on a given root node.
 * 
 * @author Michael - Initial contribution and API
 */
@ImplementedBy(DefaultAstSelectionProvider.class)
public interface INodeSelectionProvider {
	String SELECT_ENCLOSING = "org.eclipse.xtext.ui.editor.select.enclosing"; //$NON-NLS-1$
	String SELECT_NEXT = "org.eclipse.xtext.ui.editor.select.next"; //$NON-NLS-1$
	String SELECT_PREVIOUS = "org.eclipse.xtext.ui.editor.select.previous"; //$NON-NLS-1$
	String SELECT_LAST = "org.eclipse.xtext.ui.editor.select.last"; //$NON-NLS-1$

	/**
	 * @param selectionType
	 *            type of the selection to be provided (e.g. next,previous)
	 * @param xtextResource
	 *            the xtextResource
	 * @param currentEditorSelection
	 *            the region of the currently selected text
	 * @return return the region of the new selection for the given type
	 */
	ITextRegion select(String selectionType, XtextResource xtextResource, ITextRegion currentEditorSelection);

	/**
	 * Initialize the NodeSelectionProvider with the given XtextEditor
	 */
	void initialize(XtextEditor xtextEditor);

	/**
	 * Called just before the XtextEditor passed in from {@link #initialize} gets disposed
	 */
	void dispose();

}
