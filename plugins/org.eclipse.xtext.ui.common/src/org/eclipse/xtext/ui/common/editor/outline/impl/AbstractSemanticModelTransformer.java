/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer;

/**
 * @author Peter Friese - Initial contribution and API
 */
public abstract class AbstractSemanticModelTransformer implements ISemanticModelTransformer {

	public ContentOutlineNode transformSemanticModel(EObject semanticModel) {
		ContentOutlineNode outlineModel = new ContentOutlineNode();
		outlineModel.setLabel("Invisible Root Node");

		// OutlineNodeAdapter adapter = (OutlineNodeAdapter)
		// OutlineNodeAdapterFactory.INSTANCE.adapt(semanticModel,
		// ContentOutlineNode.class);
		// adapter.setOutlineNode(outlineModel);
		// adapter.setTransformer(this);

		transformSemanticNode(semanticModel, outlineModel);
		return outlineModel;
	}

	public void transformSemanticNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		if (consumeSemanticNode(semanticNode)) {
			ContentOutlineNode outlineNode = createOutlineNode(semanticNode, outlineParentNode);

			// OutlineNodeAdapter adapter = (OutlineNodeAdapter)
			// OutlineNodeAdapterFactory.INSTANCE.adapt(semanticNode,
			// ContentOutlineNode.class);
			// adapter.setOutlineNode(outlineNode);
			// adapter.setTransformer(this);

			transformSemanticChildNodes(semanticNode, outlineNode);
		}
	}

	private void transformSemanticChildNodes(EObject semanticNode, ContentOutlineNode outlineNode) {
		if (consumeSemanticChildNodes(semanticNode)) {
			for (Iterator<EObject> iterator = semanticNode.eContents().iterator(); iterator.hasNext();) {
				EObject semanticChildNode = iterator.next();
				transformSemanticNode(semanticChildNode, outlineNode);
			}
		}
	}

	protected abstract ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode);

	protected abstract boolean consumeSemanticChildNodes(EObject semanticNode);

	protected abstract boolean consumeSemanticNode(EObject semanticNode);

	protected String getText(Object object) {
		if (object != null) {
			EObject eObject = (EObject) object;
			EClass eClass = eObject.eClass();

			EStructuralFeature feature = getLabelFeature(eClass);
			if (feature != null) {
				Object value = eObject.eGet(feature);
				if (value != null) {
					return value.toString();
				}
			}
			return (object.getClass().getName());
		}
		return "<unknown>";
	}

	protected EStructuralFeature getLabelFeature(EClass eClass) {
		EAttribute result = null;
		for (EAttribute eAttribute : eClass.getEAllAttributes()) {
			if (!eAttribute.isMany() && eAttribute.getEType().getInstanceClass() != FeatureMap.Entry.class) {
				if ("name".equalsIgnoreCase(eAttribute.getName())) {
					result = eAttribute;
					break;
				} else if (result == null) {
					result = eAttribute;
				} else if (eAttribute.getEAttributeType().getInstanceClass() == String.class
						&& result.getEAttributeType().getInstanceClass() != String.class) {
					result = eAttribute;
				}
			}
		}
		return result;
	}

	public void updateOutlineNode(EObject semanticNode, ContentOutlineNode outlineNode) {
		outlineNode.setLabel(getText(semanticNode));
	}

}