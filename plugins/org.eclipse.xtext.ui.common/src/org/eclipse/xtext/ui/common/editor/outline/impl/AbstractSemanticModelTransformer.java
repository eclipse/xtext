/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.impl;

import java.util.Arrays;
import java.util.Comparator;

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

	private boolean sorted = false;

	public ContentOutlineNode transformSemanticModel(EObject semanticModel) {
		ContentOutlineNode outlineModel = new ContentOutlineNode();
		outlineModel.setLabel("Invisible Root Node");

		transformSemanticNode(semanticModel, outlineModel);
		return outlineModel;
	}

	public void transformSemanticNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode;
		if (consumeSemanticNode(semanticNode)) {
			outlineNode = createOutlineNode(semanticNode, outlineParentNode);
		}
		else {
			outlineNode = outlineParentNode;
		}
		transformSemanticChildNodes(semanticNode, outlineNode);

	}

	private void transformSemanticChildNodes(EObject semanticNode, ContentOutlineNode outlineNode) {
		if (consumeSemanticChildNodes(semanticNode)) {
			EObject[] array = sortChildren(semanticNode);
			for (EObject semanticChildNode : array) {
				transformSemanticNode(semanticChildNode, outlineNode);
			}
		}
	}

	private EObject[] sortChildren(EObject semanticNode) {
		EObject[] result = semanticNode.eContents().toArray(new EObject[semanticNode.eContents().size()]);
		if (sorted) {
			Arrays.sort(result, new Comparator<EObject>() {
				public int compare(EObject arg0, EObject arg1) {
					String txt0 = getText(arg0);
					String txt1 = getText(arg1);
					return txt0.compareTo(txt1);
				}
			});
		}
		return result;
	}

	public void setSorted(boolean on) {
		this.sorted = on;
	}

	protected abstract boolean doSortChildren(EObject semanticNode);

	protected abstract ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode);

	protected abstract boolean consumeSemanticChildNodes(EObject semanticNode);

	protected abstract boolean consumeSemanticNode(EObject semanticNode);

	public String getText(Object object) {
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
				}
				else if (result == null) {
					result = eAttribute;
				}
				else if (eAttribute.getEAttributeType().getInstanceClass() == String.class
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