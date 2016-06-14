/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

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
		if (leading) {
			if (object.getTotalOffset() < offset && object.getTotalLength() + object.getTotalOffset() >= offset) {
				for (INode node: object.getChildren()) {
					ILeafNode result = searchIn(node);
					if (result != null)
						return result;
				}
			}
		} else {
			if (object.getTotalOffset() <= offset && object.getTotalLength() + object.getTotalOffset() > offset) {
				for (INode node: object.getChildren()) {
					ILeafNode result = searchIn(node);
					if (result != null)
						return result;
				}
			}
		}
		return null;
	}
	
	public ILeafNode caseLeafNode(ILeafNode object) {
		if (leading) {
			if (object.getTotalOffset() < offset && object.getTotalLength() + object.getTotalOffset() >= offset)
				return object;
		} else {
			if (object.getTotalOffset() <= offset && object.getTotalLength() + object.getTotalOffset() > offset)
				return object;
		}
		return null;
	}
}