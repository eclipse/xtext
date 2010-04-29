/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import java.util.List;

import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.xtext.util.Strings;

/**
 * A fuzzy comparator used to restore the expansion of the outline tree after a change.
 * 
 * @author koehnlein - Initial contribution and API
 */
public interface IContentOutlineNodeComparer extends IElementComparer {

	class Default implements IContentOutlineNodeComparer {

		public boolean equals(Object a, Object b) {
			if (a == b)
				return true;
			if (a instanceof ContentOutlineNode && b instanceof ContentOutlineNode) {
				ContentOutlineNode aNode = (ContentOutlineNode) a;
				ContentOutlineNode bNode = (ContentOutlineNode) b;
				if (aNode.getClazz() != bNode.getClazz())
					return false;
				if (!Strings.equal(aNode.getLabel(), bNode.getLabel()))
					return false;
				if (aNode.getImage() != bNode.getImage())
					return false;
				ContentOutlineNode aParent = aNode.getParent();
				ContentOutlineNode bParent = bNode.getParent();
				if (aParent != null) {
					if (!equals(aParent, bParent))
						return false;
					List<ContentOutlineNode> aSiblings = aParent.getChildren();
					List<ContentOutlineNode> bSiblings = bParent.getChildren();
					int aIndex = aSiblings.indexOf(aNode);
					int bIndex = bSiblings.indexOf(bNode);
					// cope with insertions before and after this node
					if (aIndex != bIndex && aSiblings.size() - aIndex != bSiblings.size() - bIndex)
						return false;
				} else if (bParent != null)
					return false;
				return true;
			}
			if (a != null)
				return a.equals(b);
			return b == null;
		}

		public int hashCode(Object element) {
			if (element instanceof ContentOutlineNode) {
				ContentOutlineNode node = (ContentOutlineNode) element;
				int hashCode = addHashCode(0, node.getClazz());
				hashCode = addHashCode(hashCode, node.getLabel());
				hashCode = addHashCode(hashCode, node.getImage());
				hashCode = hashCode *PRIME + ((node.getParent() == null) ? 0 : hashCode(node.getParent()));
				return hashCode;
			}
			return element.hashCode();
		}

		private static final int PRIME = 47;

		private int addHashCode(int hashCode, Object element) {
			return hashCode * PRIME + (element == null ? 0 : element.hashCode());
		}
	}
}
