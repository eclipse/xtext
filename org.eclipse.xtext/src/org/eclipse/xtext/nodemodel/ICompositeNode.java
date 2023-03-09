/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

/**
 * A composite node in the parse tree. A composite node may or may not contain child nodes.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ICompositeNode extends INode {

	/**
	 * Returns an iterable that provides access to the children of the composite node. Will never 
	 * return <code>null</code> but may be empty.
	 * @return an iterable that provides access to the children of the composite node.
	 * @see #hasChildren()
	 * @see #getFirstChild()
	 * @see #getLastChild()
	 */
	BidiIterable<INode> getChildren();
	
	/**
	 * Returns <code>true</code> if this node has any children.
	 * @return <code>true</code> if this node has any children.
	 * @see #getChildren()
	 * @see #getFirstChild()
	 * @see #getLastChild()
	 */
	boolean hasChildren();
	
	/**
	 * Returns the first child of this node. May be <code>null</code> or may be the same as the {@link #getLastChild() last child}.
	 * @return the first child of this node if any.
	 * @see #hasChildren()
	 * @see #getChildren()
	 */
	INode getFirstChild();
	
	/**
	 * Returns the last child of this node. May be <code>null</code> or may be the same as the {@link #getFirstChild() first child}.
	 * @return the last child of this node if any.
	 * @see #hasChildren()
	 * @see #getChildren()
	 */
	INode getLastChild();

	/**
	 * Return the number of tokens that the parser had to peek before it could decide to create this node. Never
	 * negative. Clients will usually not have to deal with {@link #getLookAhead()}.
	 * @return the number of tokens that the parser had to peek before it could decide to create this node.
	 */
	int getLookAhead();

}
