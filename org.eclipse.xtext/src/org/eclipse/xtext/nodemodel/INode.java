/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

/**
 * <p>A node in the parse tree. Clients will usually deal with fully initialized
 * nodes thus the expected behavior and described contracts are only valid if
 * the data structure's invariant is fulfilled.</p> 
 * <p>Nodes may be considered immutable from a clients perspective. However, clients
 * should <em>never</em> keep a reference to a node as it may be invalidated at any time and
 * the very same object could be reused in another subtree of the full parse tree.</p> 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface INode {

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
	 * @return <code>true</code> if this node has a previous sibling thus {@link #getPreviousSibling()} will
	 *   not return <code>null</code>.
	 */
	boolean hasPreviousSibling();
	
	/**
	 * Returns <code>true</code> if this node is not the last child of its parent.
	 * @return <code>true</code> if this node has a next sibling thus {@link #getNextSibling()} will
	 *   not return <code>null</code>.
	 */
	boolean hasNextSibling();
	
	/**
	 * Returns the previous sibling or <code>null</code>. The result has the same {@link #getParent() parent}
	 * as this node if it is not <code>null</code>.
	 * @return the previous sibling or <code>null</code>.
	 * @see #hasPreviousSibling()
	 * @see #hasSiblings()
	 */
	INode getPreviousSibling();
	
	/**
	 * Returns the next sibling or <code>null</code>. The result has the same {@link #getParent() parent}
	 * as this node if it is not <code>null</code>.
	 * @return the next sibling or <code>null</code>.
	 * @see #hasNextSibling()
	 * @see #hasSiblings()
	 */
	INode getNextSibling();
	
	/**
	 * Returns the root node of this parse tree. Will not return <code>null</code> in a consistent tree.
	 * @return the root node of this parse tree. Will not return <code>null</code> in a consistent tree.
	 */
	ICompositeNode getRootNode();
	
	/**
	 * Returns an iterable for all contained leaf nodes. Never <code>null</code>.
	 * @return an iterable for all contained leaf nodes. Never <code>null</code>.
	 */
	Iterable<ILeafNode> getLeafNodes();

	/**
	 * Returns the offset of this node including hidden tokens.
	 * @return the offset of this node including hidden tokens.
	 */
	int getTotalOffset();
	
	/**
	 * Returns the offset of this node excluding hidden tokens. If this node is a hidden leaf node or
	 * a composite node that does only contain hidden leaf nodes, the
	 * total offset is returned. 
	 * @return the offset of this node excluding hidden tokens.
	 */
	int getOffset();

	/**
	 * Returns the length of this node including hidden tokens.
	 * @return the length of this node including hidden tokens.
	 */
	int getTotalLength();
	
	/**
	 * Returns the length of this node excluding hidden tokens. If this node is a hidden leaf node, the
	 * total length is returned.
	 * @return the length of this node excluding hidden tokens.
	 */
	int getLength();
	
	/**
	 * Returns the end offset (exclusive) of this node including hidden tokens. 
	 * Yields the same result as {@link #getTotalOffset() offset} <code>+</code> {@link #getTotalLength() length}
	 * but may be more efficient.
	 * @return the end offset (exclusive) of this node including hidden tokens. 
	 */
	int getTotalEndOffset();
	
	/**
	 * Returns the end offset (exclusive) of this node excluding hidden tokens. 
	 * Yields the same result as {@link #getOffset() offset} <code>+</code> {@link #getLength() length}
	 * but may be more efficient.
	 * @return the end offset (exclusive) of this node excluding hidden tokens. 
	 * @since 2.5
	 */
	int getEndOffset();
	
	/**
	 * Returns the line number relative to the complete input where the node begins 
	 *   (one based, including hidden tokens).
	 * @return the line number relative to the complete input where the node begins. 
	 */
	int getTotalStartLine();
	
	/**
	 * Returns the line number relative to the complete input where the node begins 
	 *   (one based, excluding hidden tokens).
	 * @return the line number relative to the complete input where the node begins. 
	 */
	int getStartLine();
	
	/**
	 * Returns the line number relative to the complete input where the node ends 
	 *   (one based, including hidden tokens).
	 * @return the line number relative to the complete input where the node ends.
	 */
	int getTotalEndLine();
	
	/**
	 * Returns the line number relative to the complete input where the node ends 
	 *   (one based, excluding hidden tokens).
	 * @return the line number relative to the complete input where the node ends. 
	 */
	int getEndLine();

	/**
	 * Returns the parsed text that is covered by this node (including hidden tokens). The result is never <code>null</code>
	 * but may be empty.
	 * @throws IllegalStateException if the text is not available. A possible reason is, that the node is not part of a valid node model.
	 * @return the parsed text that is covered by this node (including hidden tokens). Never <code>null</code>.
	 */
	String getText();

	/**
	 * Returns the grammar element that created this node. May return <code>null</code> in case of unrecoverable syntax
	 * errors. This happens usually when a keyword occurred at an unexpected offset.
	 * @return the grammar element that created this node. May return <code>null</code>.
	 */
	EObject getGrammarElement();
	
	/**
	 * Returns the nearest semantic object that is associated with the subtree of this node. May return <code>null</code> whenever
	 * the parser refused to create any objects due to unrecoverable errors. Implementations will usually walk up the
	 * node tree to find the semantic object. As the node model structure does not reflect the containment structure of 
	 * the semantic object graph, clients should usually use the utilities in 
	 * {@link org.eclipse.xtext.nodemodel.util.NodeModelUtils#findActualSemanticObjectFor(INode) NodeModelUtils} to
	 * obtain the semantic instance.
	 * @return the nearest semantic object that is associated with the subtree of this node. May return <code>null</code>.
	 * @see #hasDirectSemanticElement()
	 * @see org.eclipse.xtext.nodemodel.util.NodeModelUtils#findActualSemanticObjectFor(INode)
	 */
	EObject getSemanticElement();
	
	/**
	 * Returns <code>true</code> if this node as a directly associated semantic element.
	 * @return <code>true</code> if this node as a directly associated semantic element.
	 * @see #getSemanticElement()
	 */
	boolean hasDirectSemanticElement();

	/**
	 * Returns the directly associated syntax error message or <code>null</code> if none.
	 * @return the directly associated syntax error message. May return <code>null</code>.
	 */
	SyntaxErrorMessage getSyntaxErrorMessage();
	
	/**
	 * Returns a tree iterable that uses this node as its origin and root instance. Its iterator will not return any
	 * siblings of this root. However, the first element returned by {@link BidiTreeIterator#previous()}
	 * or {@link BidiTreeIterator#next()} will be this instance.
	 * @return a tree iterable where this node represents the root instance.
	 */
	BidiTreeIterable<INode> getAsTreeIterable();
	
	/**
	 * <p>
	 * Returns a {@link ITextRegion region} for this node excluding hidden tokens:
	 * <ul>
	 * <li>an {@link ITextRegion#getOffset() offset} of this region is the same as an {@link #getOffset() offset} of this node;</li>
	 * <li>and a {@link ITextRegion#getLength() length} of this region is the same as a {@link #getLength() length} of this node.</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * This method could be more efficient than calculating an {@link #getOffset() offset} and a {@link #getLength() length} of this node separately.
	 * </p>
	 * 
	 * @return a {@link ITextRegion region} for this node excluding hidden tokens
	 * @since 2.5
	 */
	ITextRegion getTextRegion();

	/**
	 * <p>
	 * Returns a {@link ITextRegion region} for this node including hidden tokens:
	 * <ul>
	 * <li>an {@link ITextRegion#getOffset() offset} of this region is the same as a {@link #getTotalOffset() total offset} of this node;</li>
	 * <li>and a {@link ITextRegion#getLength() length} of this region is the same as a {@link #getTotalLength() total length} of this node.</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * This method could be more efficient than calculating a {@link #getTotalOffset() total offset} 
	 * and a {@link #getTotalLength() total length} of this node separately.
	 * </p>
	 * 
	 * @return a {@link ITextRegion region} for this node including hidden tokens
	 * @since 2.5
	 */
	ITextRegion getTotalTextRegion();
	
	/**
	 * <p>
	 * Returns a {@link ITextRegionWithLineInformation region with line information} for this node excluding hidden tokens:
	 * <ul>
	 * <li>an {@link ITextRegionWithLineInformation#getOffset() offset} of this region is the same as an {@link #getOffset() offset} of this node;</li>
	 * <li>a {@link ITextRegionWithLineInformation#getLength() length} of this region is the same as a {@link #getLength() length} of this node;</li>
	 * <li>a {@link ITextRegionWithLineInformation#getLineNumber() line number} of this region is the same as a {@link #getStartLine() start line} of this node;</li>
	 * <li>an {@link ITextRegionWithLineInformation#getEndLineNumber() end line number} of this region is the same as an {@link #getEndLine() end line} of this node.</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * A {@link ITextRegionWithLineInformation#getLineNumber() line number} and 
	 * an {@link ITextRegionWithLineInformation#getEndLineNumber() end line number} of the returned region are one based.
	 * </p>
	 * 
	 * <p>
	 * This method could be more efficient than calculating an {@link #getOffset() offset}, a {@link #getLength() length},
	 * a {@link #getStartLine() start line} and an {@link #getEndLine() end line} of this node separately.
	 * </p>
	 * 
	 * @return a {@link ITextRegionWithLineInformation region with line information} for this node excluding hidden tokens
	 * @since 2.5
	 */
	ITextRegionWithLineInformation getTextRegionWithLineInformation();
	
	/**
	 * <p>
	 * Returns a {@link ITextRegionWithLineInformation region with line information} for this node including hidden tokens:
	 * <ul>
	 * <li>an {@link ITextRegionWithLineInformation#getOffset() offset} of this region is the same as a {@link #getTotalOffset() total offset} of this node;</li>
	 * <li>a {@link ITextRegionWithLineInformation#getLength() length} of this region is the same as a {@link #getTotalLength() total length} of this node;</li>
	 * <li>a {@link ITextRegionWithLineInformation#getLineNumber() line number} of this region is the same as a {@link #getTotalStartLine() total start line} of this node;</li>
	 * <li>an {@link ITextRegionWithLineInformation#getEndLineNumber() end line number} of this region is the same as a {@link #getTotalEndLine() total end line} of this node.</li>
	 * </ul>
	 * </p>
	 * 
	 * <p>
	 * A {@link ITextRegionWithLineInformation#getLineNumber() line number} and 
	 * an {@link ITextRegionWithLineInformation#getEndLineNumber() end line number} of the returned region are one based.
	 * </p>
	 * 
	 * <p>
	 * This method could be more efficient than calculating a {@link #getTotalOffset() total offset}, a {@link #getTotalLength() total length},
	 * a {@link #getTotalStartLine() total start line} and a {@link #getTotalEndLine() total end line} of this node separately.
	 * </p>
	 * 
	 * @return a {@link ITextRegionWithLineInformation region with line information} for this node including hidden tokens
	 * @since 2.5
	 */
	ITextRegionWithLineInformation getTotalTextRegionWithLineInformation();

}
