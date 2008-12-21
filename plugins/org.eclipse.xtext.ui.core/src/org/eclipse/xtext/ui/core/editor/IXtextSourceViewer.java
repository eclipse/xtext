/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;

/**
 * Source viewer interface with a 'node-centric' view of the underlying document.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public interface IXtextSourceViewer {

	/**
	 * @return the root node of the underlying document
	 */
	CompositeNode getRootNode();

	/**
	 * @param offset
	 *            matching position for the reference node
	 * @return the nearest node with an existing grammar element set (i.e. valid
	 *         according to the underlying grammar)
	 */
	AbstractNode getReferenceNode(int offset);

	/**
	 * @param offset
	 *            matching position for the node
	 * @return the last node (on a none hidden channel) that starts at or spans
	 *         across the given offset position
	 */
	AbstractNode getNode(int offset);

	/**
	 * @param offset
	 *            matching position for the model
	 * @return the most specific model element for the given offset position
	 */
	EObject getModel(int offset);

}
