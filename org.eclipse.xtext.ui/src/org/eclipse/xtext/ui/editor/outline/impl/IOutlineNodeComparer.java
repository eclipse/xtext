/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;

import com.google.inject.ImplementedBy;

/**
 * A fuzzy comparator used to restore the expansion of the outline tree after a change.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IOutlineNodeComparer.Default.class)
public interface IOutlineNodeComparer {

	boolean equals(IOutlineNode node1, IOutlineNode node2);

	class Default implements IOutlineNodeComparer {
		@Override
		public boolean equals(IOutlineNode node1, IOutlineNode node2) {
			if (node1 == null || node2 == null)
				return node1 == null && node2 == null;
			return node1.getClass() == node2.getClass() && equals(node1.getParent(), node2.getParent())
					&& equalsNullSafe(node1.getText().toString(), node2.getText().toString())
					&& equalsNullSafe(node1.getImage(), node2.getImage()) 
					&& equalsNullSafe(getImageDescriptor(node1), getImageDescriptor(node2)) 
					&& isEquivalentIndex(node1, node2);
		}

		protected boolean isEquivalentIndex(IOutlineNode node1, IOutlineNode node2) {
			IOutlineNode parent1 = node1.getParent();
			IOutlineNode parent2 = node2.getParent();
			if (parent1 == null && parent2 == null)
				return true;
			if (parent1 != null && parent2 != null) {
				List<IOutlineNode> siblings1 = parent1.getChildren();
				List<IOutlineNode> siblings2 = parent2.getChildren();
				int index1 = siblings1.indexOf(node1);
				int index2 = siblings2.indexOf(node2);
				// same siblings =>  same index
				// sibling inserted after => same index
				// sibling inserted before => same # of following siblings
				if (index1 == index2 || siblings1.size() - index1 == siblings2.size() - index2)
					return true;
			}
			return false;
		}
		
		/**
		 * @since 2.4
		 */
		protected ImageDescriptor getImageDescriptor(IOutlineNode node) {
			return (node instanceof IOutlineNode.Extension) 
					? ((IOutlineNode.Extension)node).getImageDescriptor()
					: null;
		}

		protected boolean equalsNullSafe(Object o1, Object o2) {
			return (o1 == null) ? o2 == null : o1.equals(o2);
		}
	}
}
