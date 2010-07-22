/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline;

import org.apache.commons.lang.ArrayUtils;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.xtext.util.Strings;

/**
 * A fuzzy comparator used to restore the expansion of the outline tree after a change.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IContentOutlineNodeComparer extends IElementComparer {

	class Default implements IContentOutlineNodeComparer {

		public boolean equals(Object a, Object b) {
			if (a == b)
				return true;
			if (a instanceof IContentOutlineNode && b instanceof IContentOutlineNode) {
				IContentOutlineNode aNode = (IContentOutlineNode) a;
				IContentOutlineNode bNode = (IContentOutlineNode) b;
				if (aNode.getClazz() != bNode.getClazz())
					return false;
				if (!Strings.equal(aNode.getLabel(), bNode.getLabel()))
					return false;
				if (aNode.getImage() != bNode.getImage())
					return false;
				IContentOutlineNode aParent = aNode.getParent();
				IContentOutlineNode bParent = bNode.getParent();
				if (aParent != null) {
					if (!equals(aParent, bParent))
						return false;
					IContentOutlineNode[] aSiblings = aParent.getChildrenAsArray();
					IContentOutlineNode[] bSiblings = bParent.getChildrenAsArray();
					int aIndex = ArrayUtils.indexOf(aSiblings, aNode);
					int bIndex = ArrayUtils.indexOf(bSiblings, bNode);
					// cope with insertions before and after this node
					if (aIndex != bIndex && aSiblings.length - aIndex != bSiblings.length - bIndex)
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
			if (element instanceof IContentOutlineNode) {
				IContentOutlineNode node = (IContentOutlineNode) element;
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
