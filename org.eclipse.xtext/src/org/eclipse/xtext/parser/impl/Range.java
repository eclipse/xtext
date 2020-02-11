/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.impl;

import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * A mutable (!) range object.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Range {

	private int offset;
	
	/**
	 * the end offset (exclusive).
	 */
	private int endOffset;

	public Range(INode node) {
		this(node.getTotalOffset(), node.getTotalEndOffset());
	}

	/**
	 * @param fromOffset the start offset (inclusive).
	 * @param endOffset the end offset (exclusive). 
	 */
	public Range(int fromOffset, int endOffset) {
		this.offset = fromOffset;
		this.endOffset = endOffset;
	}

	public void merge(INode node) {
		merge(node.getTotalOffset(), node.getTotalEndOffset());
	}
	
	public void merge(int fromOffset, int endOffset) {
		this.offset = Math.min(this.offset, fromOffset);
		this.endOffset = Math.max(this.endOffset, endOffset);
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int fromOffset) {
		this.offset = fromOffset;
	}

	public int getEndOffset() {
		return endOffset;
	}

	public void setEndOffset(int endOffset) {
		this.endOffset = endOffset;
	}
	
	public int getLength() {
		return endOffset - offset;
	}

	public void mergeAllSyntaxErrors(INode node) {
		if (node.getSyntaxErrorMessage() != null)
			merge(node);
		else {
			// first syntax error
			boolean errorSeen = false;
			{
				BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
				while(!errorSeen && iterator.hasNext()) {
					INode next = iterator.next();
					if (next.getSyntaxErrorMessage() != null) {
						merge(next);
						errorSeen = true;
					}
				}
			}
			// last syntax error
			if (errorSeen) {
				BidiTreeIterator<INode> iterator = node.getAsTreeIterable().iterator();
				errorSeen = false;
				while(!errorSeen && iterator.hasPrevious()) {
					INode prev = iterator.previous();
					if (prev.getSyntaxErrorMessage() != null) {
						merge(prev);
						errorSeen = true;
					} else if (prev instanceof ILeafNode) {
						// Syntax errors are sometimes followed by leaf nodes that
						// do not have a grammar element assigned
						if (prev.getGrammarElement() == null) {
							merge(prev);
							errorSeen = true;
						}
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "range [" + offset + " - " + endOffset + "]";
	}
}