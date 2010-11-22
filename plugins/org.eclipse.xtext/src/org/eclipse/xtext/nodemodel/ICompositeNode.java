/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

/**
 * A composite node in the parse tree. A composite node may or may not contain child nodes.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ICompositeNode extends INode {

	/**
	 * @return an iterable that provides access to the children of the composite node. Never <code>null</code>. 
	 *   May be empty.
	 */
	BidiIterable<INode> getChildren();
	
	/**
	 * @return <code>true</code> if this node has any children. 
	 */
	boolean hasChildren();
	
	/**
	 * @return the first child of this node. May be <code>null</code>. May be the same as the last child.
	 */
	INode getFirstChild();
	
	/**
	 * @return the last child of this node. May be <code>null</code>. May be the same as the first child.
	 */
	INode getLastChild();

	/**
	 * @return the number of tokens that the parser had to peek before it could decide to create this node. Never
	 *   negative.
	 */
	int getLookAhead();

}
