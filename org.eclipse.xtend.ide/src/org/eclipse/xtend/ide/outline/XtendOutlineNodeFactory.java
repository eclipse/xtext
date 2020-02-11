/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeFactory;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendOutlineNodeFactory extends OutlineNodeFactory {
	
	@Inject
	private IXtendJvmAssociations associations;

	public XtendFeatureNode createXtendFeatureNode(IOutlineNode parentNode, EObject modelElement,
			ImageDescriptor imageDescriptor, Object text, boolean isLeaf, boolean synthetic, int inheritanceDepth) {
		XtendFeatureNode featureNode = new XtendFeatureNode(modelElement, parentNode, imageDescriptor, text, isLeaf);
		configureNode(parentNode, modelElement, inheritanceDepth, featureNode);
		featureNode.setSynthetic(synthetic);
		return featureNode;
	}

	public XtendEObjectNode createXtendEObjectNode(IOutlineNode parentNode, EObject modelElement,
			ImageDescriptor imageDescriptor, Object text, boolean isLeaf, int inheritanceDepth) {
		XtendEObjectNode featureNode = new XtendEObjectNode(modelElement, parentNode, imageDescriptor, text, isLeaf);
		configureNode(parentNode, modelElement, inheritanceDepth, featureNode);
		return featureNode;
	}

	private void configureNode(IOutlineNode parentNode, EObject modelElement, int inheritanceDepth,
			XtendEObjectNode featureNode) {
		EObject primarySourceElement = associations.getPrimarySourceElement(modelElement);
		ICompositeNode parserNode = NodeModelUtils.getNode(primarySourceElement==null?modelElement:primarySourceElement);
		if (parserNode != null)
			featureNode.setTextRegion(parserNode.getTextRegion());
		if (isLocalElement(parentNode, modelElement))
			featureNode.setShortTextRegion(getLocationInFileProvider().getSignificantTextRegion(primarySourceElement==null?modelElement:primarySourceElement));
		featureNode.setStatic(isStatic(modelElement));
		featureNode.setInheritanceDepth(inheritanceDepth);
	}

	protected boolean isStatic(EObject element) {
		if (element instanceof JvmFeature)
			return ((JvmFeature) element).isStatic();
		else if (element instanceof JvmDeclaredType)
			return ((JvmDeclaredType) element).isStatic();
		else if (element instanceof XtendMember)
			return ((XtendMember) element).isStatic();
		else
			return false;
	}

}
