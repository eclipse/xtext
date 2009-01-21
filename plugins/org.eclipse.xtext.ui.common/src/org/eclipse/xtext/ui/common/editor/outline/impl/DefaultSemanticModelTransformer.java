/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DefaultSemanticModelTransformer extends AbstractSemanticModelTransformer {
	
	public boolean consumeSemanticNode(EObject semanticNode) {
		String name = semanticNode.eClass().getName();
		if (LazyTransformingTreeProvider.logger.isDebugEnabled()) {
			LazyTransformingTreeProvider.logger.debug("Consume semantic node type [" + name + "]?");
		}
		return true;
	}

	public boolean consumeSemanticChildNodes(EObject semanticNode) {
		String name = semanticNode.eClass().getName();
		if (LazyTransformingTreeProvider.logger.isDebugEnabled()) {
			LazyTransformingTreeProvider.logger.debug("Consume semantic chidlren of node type [" + name + "]?");
		}
		return true;
	}

	@Override
	protected ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = new ContentOutlineNode();

		outlineNode.setLabel(getText(semanticNode));
		outlineNode.setImage("DefaultOutlineNode");
		outlineNode.setSemanticNode(semanticNode);
		outlineParentNode.getChildren().add(outlineNode);
		outlineNode.setParent(outlineParentNode);

		return outlineNode;
	}
}