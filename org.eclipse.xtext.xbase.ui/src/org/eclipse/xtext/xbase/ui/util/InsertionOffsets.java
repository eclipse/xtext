/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class InsertionOffsets {

	public int before(EObject element) {
		return NodeModelUtils.findActualNodeFor(element).getOffset();
	}

	public int after(EObject element) {
		return NodeModelUtils.findActualNodeFor(element).getEndOffset();
	}

	public int inEmpty(EObject element) {
		ICompositeNode compositeNode = NodeModelUtils.findActualNodeFor(element);
		for (ILeafNode leafNode : compositeNode.getLeafNodes()) {
			if ("{".equals(leafNode.getText())) {
				return leafNode.getOffset() + 1;
			}
		}
		return compositeNode.getEndOffset();
	}
}
