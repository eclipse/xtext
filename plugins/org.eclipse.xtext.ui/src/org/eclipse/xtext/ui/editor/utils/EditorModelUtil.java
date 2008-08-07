/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.utils;

import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class EditorModelUtil {

	/**
	 * Pretty performance-oriented LeafNode at Offset routine
	 * 
	 * @param parseTreeRootNode
	 *            - CompositeNode to search in
	 * @param offset
	 * @return LeafNode or null if not found
	 */
	public static AbstractNode findLeafNodeAtOffset(CompositeNode parseTreeRootNode, int offset) {
		for (AbstractNode node : parseTreeRootNode.getChildren()) {
			if (node.getOffset() + node.getLength() >= offset) {
				if (node.getOffset() <= offset) {
					if (node instanceof LeafNode)
						return (LeafNode) node;
					else if (node instanceof CompositeNode)
						return findLeafNodeAtOffset((CompositeNode) node, offset);
				}
			}
		}
		return null;
	}

}
