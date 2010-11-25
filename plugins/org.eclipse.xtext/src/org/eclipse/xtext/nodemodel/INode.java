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
 * <p>A node in the parse tree. Clients will usually deal with fully initialized
 * nodes thus the expected behavior and described contracts are only valid if
 * the invariant is fulfilled.</p> 
 * <p>Nodes may be considered immutable from a clients perspective. However, clients
 * should never keep a reference to a node as it may be invalidated at any time and
 * the very same object could be reused in another subtree of the full parse tree.</p> 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface INode extends BidiTreeIterable<INode> {

	/**
	 * Returns the parent of the node or <code>null</code> if and only if this is the root node.
	 * @return the parent of this node or <code>null</code>.
	 */
	ICompositeNode getParent();
	
	/**
	 * Returns <code>true</code> if this node has any siblings.
	 * @return <code>true</code> if this node has any siblings.
	 * @see #hasPreviousSibling()
	 * @see #hasNextSibling()
	 */
	boolean hasSiblings();
	
	/**
	 * Returns <code>true</code> if this node is not the first child of its parent.
	 * @returns <code>true</code> if this node has a previous sibling thus {@link #getPreviousSibling()} will
	 *   not return <code>null</code>.
	 */
	boolean hasPreviousSibling();
	
	/**
	 * Returns <code>true</code> if this node is not the last child of its parent.
	 * @returns <code>true</code> if this node has a next sibling thus {@link #getNextSibling()} will
	 *   not return <code>null</code>.
	 */
	boolean hasNextSibling();
	
	/**
	 * @return the previous sibling or <code>null</code>.
	 */
	INode getPreviousSibling();
	
	/**
	 * @return the next sibling or <code>null</code>.
	 */
	INode getNextSibling();
	
	/**
	 * @return the root node of this parse tree. Will not return <code>null</code> in a consistent tree.
	 */
	ICompositeNode getRootNode();

	/**
	 * @return the offset of this node including hidden tokens.
	 */
	int getTotalOffset();
	
	/**
	 * @return the offset of this node excluding hidden tokens. If this node is a hidden leaf node or
	 * a composite node that does only contain hidden leaf nodes, the
	 * total offset is returned. 
	 */
	int getOffset();

	/**
	 * @return the length of this node including hidden tokens.
	 */
	int getTotalLength();
	
	/**
	 * @return the length of this node excluding hidden tokens. If this node is a hidden leaf node, the
	 * total length is returned.
	 */
	int getLength();
	
	/**
	 * @return the end offset (exclusive) of this node including hidden tokens. 
	 *   Yields the same result as {@link #getTotalOffset() offset} <code>+</code> {@link #getTotalLength() length}
	 *   but may be more efficient.
	 */
	int getTotalEndOffset();
	
	/**
	 * @return the line number relative to the complete input where the node begins 
	 *   (one based, including hidden tokens).
	 */
	int getTotalStartLine();
	
	/**
	 * @return the line number relative to the complete input where the node begins 
	 *   (one based, excluding hidden tokens).
	 */
	int getStartLine();
	
	/**
	 * @return the line number relative to the complete input where the node ends 
	 *   (one based, including hidden tokens).
	 */
	int getTotalEndLine();
	
	/**
	 * @return the line number relative to the complete input where the node ends 
	 *   (one based, excluding hidden tokens).
	 */
	int getEndLine();

	/**
	 * @return the parsed text that is covered by this node (including hidden tokens). Never <code>null</code>.
	 */
	String getText();

	/**
	 * @return the grammar element that created this node. May return <code>null</code> in case of unrecoverable syntax
	 *   errors. This happens usually when a keyword occurred at an unexpected offset.
	 */
	EObject getGrammarElement();
	
	/**
	 * @return the nearest semantic object that is associated with the subtree of this node. May return <code>null</code> whenever
	 *   the parser refused to create an object due to unrecoverable errors.
	 * @see #hasDirectSemanticElement()
	 */
	EObject getSemanticElement();
	
	/**
	 * @return <code>true</code> if this node as a directly associated semantic element.
	 */
	boolean hasDirectSemanticElement();

	/**
	 * @return the directly associated syntax error message. May return <code>null</code>.
	 */
	SyntaxErrorMessage getSyntaxErrorMessage();
	
	/**
	 * Returns a tree iterator that uses this node as its origin and root instance. It will not return any
	 * siblings of this root. However, the first element returned by {@link BidiTreeIterator#previous()}
	 * or {@link BidiTreeIterator#next()} will be this instance.
	 * 
	 * {@inheritDoc}
	 */
	BidiTreeIterator<INode> iterator();

}
