/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class EnclosingCompositeNodeFinder {

	private int currentOffset = 0;
	private int startTokenParentIndex = -1;
	private List<NodeWithCachedOffset> nodesEnclosingRegion;
	private int offset;
	private int length;

	public EnclosingCompositeNodeFinder(CompositeNode parentNode, int offset, int length) {
		nodesEnclosingRegion = new ArrayList<NodeWithCachedOffset>();
		this.offset = offset;
		this.length = length;
		findRegion(parentNode);
	}

	/**
	 * @return the nodesEnclosingRegion
	 */
	public List<NodeWithCachedOffset> getNodesEnclosingRegion() {
		return nodesEnclosingRegion;
	}
	
	private boolean findRegion(CompositeNode parentNode) {
		boolean isLookingForStartToken = startTokenParentIndex == -1;
		nodesEnclosingRegion.add(new NodeWithCachedOffset(currentOffset, parentNode));
		int currentParentIndex = nodesEnclosingRegion.size() - 1;
		EList<AbstractNode> children = parentNode.getChildren();
		for (AbstractNode child : children) {
			if (child instanceof LeafNode) {
				currentOffset += child.length();
				if (isLookingForStartToken && currentOffset > offset) {
					isLookingForStartToken = false;
					startTokenParentIndex = currentParentIndex;
				}
				if (!isLookingForStartToken && currentOffset >= offset + length) {
					removeUncommonParents(currentParentIndex);
					return true;
				}
			}
			else {
				if (findRegion((CompositeNode) child)) {
					return true;
				}
			}
		}
		nodesEnclosingRegion.remove(currentParentIndex);
		return false;
	}

	private void removeUncommonParents(int currentParentIndex) {
		int commonParentIndex = Math.min(startTokenParentIndex, currentParentIndex);
		while (nodesEnclosingRegion.size() > commonParentIndex + 1) {
			nodesEnclosingRegion.remove(nodesEnclosingRegion.size() - 1);
		}
	}
}
