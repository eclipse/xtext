/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.util.Iterator;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @since 2.9
 */
public class LeafNodeFinder {
	private final int offset;
	private final boolean leading;
	
	public LeafNodeFinder(int offset, boolean leading) {
		this.offset = offset;
		this.leading = leading;
	}
	
	public ILeafNode searchIn(INode node) {
		if (node instanceof ICompositeNode) {
			return caseCompositeNode((ICompositeNode) node);
		} else {
			return caseLeafNode((ILeafNode) node);
		}
	}
	
	public ILeafNode caseCompositeNode(ICompositeNode object) {
		if (matchesSearchCriteria(object)) {
			return searchInChildren(object);
		}
		return null;
	}
	
	/**
	 * @since 2.13
	 */
	protected boolean matchesSearchCriteria(INode object) {
		if (leading) {
			if (object.getTotalOffset() < offset && object.getTotalLength() + object.getTotalOffset() >= offset) {
				return true;
			}
		} else {
			if (object.getTotalOffset() <= offset && object.getTotalLength() + object.getTotalOffset() > offset) {
				return true;
			}
		}
		return object.getTotalOffset() == offset && object.getTotalLength() == 0;
	}
	
	/**
	 * @since 2.13
	 */
	protected ILeafNode searchInChildren(ICompositeNode object) {
		Iterator<ILeafNode> leafNodes = object.getLeafNodes().iterator();
		ILeafNode result = null;
		while(leafNodes.hasNext()) {
			result = leafNodes.next();
			if (matchesSearchCriteria(result)) {
				break;
			}
		}
		while(leafNodes.hasNext()) {
			ILeafNode next = leafNodes.next();
			if (matchesSearchCriteria(next)) {
				result = next;
			} else {
				break;
			}
		}
		return result;
	}
	
	public ILeafNode caseLeafNode(ILeafNode object) {
		if (matchesSearchCriteria(object)) {
			return object;
		}
		return null;
	}
}
