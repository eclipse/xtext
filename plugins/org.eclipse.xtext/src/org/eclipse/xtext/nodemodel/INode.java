/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface INode extends BidiTreeIterable<INode> {

	ICompositeNode getParent();

	int getTotalOffset();

	int getTotalLength();
	
	int getTotalEndOffset();

	String getText();

	EObject getGrammarElement();
	
	EObject getSemanticElement();

	SyntaxErrorMessage getSyntaxErrorMessage();
	
	/**
	 * Returns an iterator that will provide this node itself as its next element
	 * or its predecessor as its previous element. If this node is the first child of its parent,
	 * the previous element will be the last child. If this node is the last child the iterator
	 * will returns the first child as its first element. If this node is neither the first
	 * nor the last child, the iterator will be finished when it hits the first or last child depending 
	 * on the direction.
	 * 
	 * {@inheritDoc}
	 */
	BidiIterator<INode> iterator();
	
	/**
	 * Returns a tree iterator that uses this node as its origin and root instance. It will not return any
	 * siblings of this root. However, the first element of invocations of {@link BidiTreeIterator#previous()}
	 * or {@link BidiTreeIterator#next()} will be this instance.
	 * 
	 * {@inheritDoc}
	 */
	BidiTreeIterator<INode> treeIterator();

}
