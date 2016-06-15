/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class InsertionOffsets {

	def before(EObject element) {
		NodeModelUtils.findActualNodeFor(element).offset
	}

	def after(EObject element) {
		val node = NodeModelUtils.findActualNodeFor(element)
		node.endOffset
	}

	def inEmpty(EObject element) {
		val node = NodeModelUtils.findActualNodeFor(element)
		val openingBraceNode = node.leafNodes.findFirst[text == "{"]
		if (openingBraceNode != null)
			openingBraceNode.offset + 1
		else
			node.endOffset
	}

}
