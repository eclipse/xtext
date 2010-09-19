/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.TextRegion;

import com.google.inject.Inject;

public class DefaultOutlineTreeProvider implements IOutlineTreeStructureProvider, IOutlineTreeProvider {

	@Inject
	protected ILabelProvider labelProvider;

	@Inject
	protected ILocationInFileProvider locationInFileProvider;

	private PolymorphicDispatcher<Void> createChildrenDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"doCreateChildren", 2, 2, this);

	private PolymorphicDispatcher<Void> createNodeDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"doCreateNode", 2, 2, this);

	private PolymorphicDispatcher<Object> textDispatcher = PolymorphicDispatcher.createForSingleTarget("text", 1, 1,
			this);

	private PolymorphicDispatcher<Image> imageDispatcher = PolymorphicDispatcher.createForSingleTarget("image", 1, 1,
			this);

	public IOutlineNode createRoot(IXtextDocument document) {
		DocumentRootNode documentNode = new DocumentRootNode(labelProvider.getImage(document),
				labelProvider.getText(document), document, this);
		return documentNode;
	}

	public void createChildren(IOutlineNode parent, EObject modelElement) {
		if (modelElement != null && parent.hasChildren())
			createChildrenDispatcher.invoke(parent, modelElement);
	}

	protected void doCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
		createNode(parentNode, modelElement);
	}

	protected void doCreateChildren(IOutlineNode parentNode, EObject modelElement) {
		for (EObject childElement : modelElement.eContents())
			createNode(parentNode, childElement);
	}

	protected void doCreateChildren(EStructuralFeatureNode parentNode, EObject modelElement) {
		Object values = modelElement.eGet(parentNode.getEStructuralFeature());
		if (values != null) {
			if (parentNode.getEStructuralFeature().isMany()) {
				for (EObject value : EcoreUtil2.typeSelect((List<?>) values, EObject.class)) {
					createNode(parentNode, value);
				}
			} else {
				if (values instanceof EObject)
					createNode(parentNode, (EObject) values);
			}
		}
	}

	/**
	 * Default for createChildrenDispatcher
	 */
	protected void doCreateChildren(Object parent, Object element) {
		// do nothing
	}

	protected void createNode(IOutlineNode parent, EObject modelElement) {
		createNodeDispatcher.invoke(parent, modelElement);
	}

	protected void doCreateNode(IOutlineNode parentNode, EObject modelElement) {
		Object text = textDispatcher.invoke(modelElement);
		if (text != null) {
			Image image = imageDispatcher.invoke(modelElement);
			EObjectNode eObjectNode = new EObjectNode(modelElement, parentNode, image, text, modelElement.eContents()
					.isEmpty());
			CompositeNode parserNode = NodeUtil.getNode(modelElement);
			if (parserNode != null)
				eObjectNode.setTextRegion(new TextRegion(parserNode.getOffset(), parserNode.getLength()));
			eObjectNode.setShortTextRegion(locationInFileProvider.getLocation(modelElement));
		}
	}

	/**
	 * Default for createNodeDispatcher
	 */
	protected void doCreateNode(Object object0, EObject object1) {
		throw new IllegalArgumentException("Could not find method createNode(" + nullSafeClassName(object0) + ","
				+ nullSafeClassName(object1));
	}

	protected void createEStructuralFeatureNode(IOutlineNode parentNode, EObject owner, EStructuralFeature feature,
			Image image, Object text) {
		boolean isFeatureSet = owner.eIsSet(feature);
		EStructuralFeatureNode eStructuralFeatureNode = new EStructuralFeatureNode(owner, feature, parentNode, image,
				text, !isFeatureSet);
		if (isFeatureSet) {
			ITextRegion region = locationInFileProvider.getLocation(owner, feature, 0);
			if (feature.isMany()) {
				int numValues = ((Collection<?>) owner.eGet(feature)).size();
				region.merge(locationInFileProvider.getLocation(owner, feature, numValues - 1));
			}
			eStructuralFeatureNode.setTextRegion(region);
		}
	}

	/**
	 * Default for textDispatcher
	 */
	protected Object text(Object modelElement) {
		if (labelProvider instanceof IStyledLabelProvider)
			return ((IStyledLabelProvider) labelProvider).getStyledText(modelElement);
		else
			return labelProvider.getText(modelElement);
	}

	/**
	 * Default for imageDispatcher
	 */
	protected Image image(Object modelElement) {
		return labelProvider.getImage(modelElement);
	}

	protected String nullSafeClassName(Object object) {
		return (object != null) ? object.getClass().getName() : "null";
	}

}
