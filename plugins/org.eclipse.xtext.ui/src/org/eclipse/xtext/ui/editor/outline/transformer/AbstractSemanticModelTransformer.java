/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.transformer;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.outline.ContentOutlineNode;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Michael Clay
 */
public abstract class AbstractSemanticModelTransformer implements ISemanticModelTransformer {
	public static final String INVISIBLE_ROOT_NODE = "Invisible Root Node";
	public static final List<EObject> NO_CHILDREN = Collections.emptyList();

	public ContentOutlineNode transformSemanticModel(EObject semanticModel) {
		ContentOutlineNode outlineModel = new ContentOutlineNode(INVISIBLE_ROOT_NODE);
		if (semanticModel != null)
			transformSemanticNode(semanticModel, outlineModel);
		return outlineModel;
	}

	public void transformSemanticNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode;
		if (consumeSemanticNode(semanticNode)) {
			outlineNode = createOutlineNode(semanticNode, outlineParentNode);
		} else {
			outlineNode = outlineParentNode;
		}
		transformSemanticChildNodes(semanticNode, outlineNode);

	}

	private void transformSemanticChildNodes(EObject semanticNode, ContentOutlineNode outlineNode) {
		if (consumeSemanticChildNodes(semanticNode)) {
			List<EObject> list = getChildNodes(semanticNode);
			for (EObject semanticChildNode : list) {
				transformSemanticNode(semanticChildNode, outlineNode);
			}
		}
	}

	protected List<EObject> getChildNodes(EObject semanticNode) {
		return getChildren(semanticNode);
	}

	protected List<EObject> getChildren(EObject semanticNode) {
		return semanticNode.eContents();
	}

	protected abstract ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode);

	protected abstract boolean consumeSemanticChildNodes(EObject semanticNode);

	protected abstract boolean consumeSemanticNode(EObject semanticNode);

}