/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineNodeComparer;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XtextOutlineNodeComparer extends IOutlineNodeComparer.Default {
	@Override
	public boolean equals(IOutlineNode node1, IOutlineNode node2) {
		if (node1 instanceof EObjectNode && node2 instanceof EObjectNode) {
			return equals(node1.getParent(), node2.getParent())
					&& equalsNullSafe(node1.getImage(), node2.getImage())
					&& equalsNullSafe(((EObjectNode) node1).getEClass(), ((EObjectNode) node2).getEClass())
					&& isEquivalentText(node1.getText(), node2.getText()) && isEquivalentIndex(node1, node2);
		}
		return super.equals(node1, node2);
	}

	protected boolean isEquivalentText(Object textObject1, Object textObject2) {
		if (textObject1 == null || textObject2 == null)
			return textObject1 == null && textObject2 == null;
		String text1 = textObject1.toString();
		String text2 = textObject2.toString();
		return text1.equals(text2) 
				|| text1.startsWith(text2 + XtextOutlineTreeProvider.NAME_TYPE_SEPARATOR)
				|| text2.startsWith(text1 + XtextOutlineTreeProvider.NAME_TYPE_SEPARATOR);
	}
}
