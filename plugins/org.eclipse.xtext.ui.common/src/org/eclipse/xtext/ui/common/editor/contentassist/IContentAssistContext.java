/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;

/**
 * Abstraction of a commonly used set of attributes related to the current content assist request.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public interface IContentAssistContext {
	/**
	 * @return the root node of the document which is used to compute the proposals
	 */
	CompositeNode getRootNode();

	/**
	 * @return the string that is already entered by the user prior to requesting content assist
	 */
	String getMatchString();
	
	/**
	 * @return the last node (on a none hidden channel) that starts at or spans across the cursor position the user requested content assist for
	 */
	AbstractNode getNode();
	
	/**
	 * @return the nearest node with an existing grammar element set (i.e. valid according to the underlying grammar)
	 */
	AbstractNode getReferenceNode();
	
	/**
	 * @return the most specific model element under the cursor the user requested content assist for
	 */
	EObject getModel();
	
	/**
	 * @return the position in the document described by this context.
	 */
	int getOffSet();

}
