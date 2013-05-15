/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.label.ILabelProviderImageDescriptorExtension;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * A default outline provider using {@link ImageDescriptor}s instead of {@link Image}s.
 *  
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public class DefaultOutlineTreeProvider2 implements IOutlineTreeStructureProvider, IOutlineTreeProvider,
		IOutlineTreeProvider.Extension {

	@Inject
	private ILabelProvider labelProvider;

	@Inject
	private OutlineNodeFactory factory;
	
	public IOutlineNode createRoot(IXtextDocument document) {
		return factory.createRoot(document, getImageDescriptor(document), getText(document), this);
	}

	public void createChildren(IOutlineNode parentNode, EObject modelElement) {
		if (modelElement != null && parentNode.hasChildren()) {
			if (parentNode instanceof DocumentRootNode)
				internalCreateChildren((DocumentRootNode) parentNode, modelElement);
			else if(parentNode instanceof EStructuralFeatureNode)
				internalCreateChildren((EStructuralFeatureNode) parentNode, modelElement);
			else 
				internalCreateChildren(parentNode, modelElement);
		}
	}

	protected void internalCreateChildren(DocumentRootNode parentNode, EObject modelElement) {
		Object text = getText(modelElement);
		if (text == null) 
			text = modelElement.eResource().getURI().trimFileExtension().lastSegment();
		ImageDescriptor imageDescriptor = getImageDescriptor(modelElement);
		factory.createEObjectNode(parentNode, modelElement, imageDescriptor, text, isLeaf(modelElement));
	}

	protected void internalCreateChildren(EStructuralFeatureNode parentNode, EObject modelElement) {
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

	protected void internalCreateChildren(IOutlineNode parentNode, EObject modelElement) {
		for (EObject childElement : modelElement.eContents())
			createNode(parentNode, childElement);
	}

	protected EObjectNode createNode(IOutlineNode parentNode, EObject modelElement) {
		Object text = getText(modelElement);
		boolean isLeaf = isLeaf(modelElement);
		if (text == null && isLeaf)
			return null;
		ImageDescriptor image = getImageDescriptor(modelElement);
		return factory.createEObjectNode(parentNode, modelElement, image, text, isLeaf);
	}

	protected ImageDescriptor getImageDescriptor(Object modelElement) {
		if(labelProvider instanceof ILabelProviderImageDescriptorExtension)
			return ((ILabelProviderImageDescriptorExtension) labelProvider).getImageDescriptor(modelElement);
		else 
			return null;
	}
	
	protected Object getText(Object modelElement) {
		if (labelProvider instanceof IStyledLabelProvider)
			return ((IStyledLabelProvider) labelProvider).getStyledText(modelElement);
		else
			return labelProvider.getText(modelElement);
	}

	protected boolean isLeaf(final EObject modelElement) {
		return !Iterables.any(modelElement.eClass().getEAllContainments(), new Predicate<EReference>() {
			public boolean apply(EReference containmentRef) {
				return modelElement.eIsSet(containmentRef);
			}
		});
	}
	
	public boolean needsDisplayThread() {
		return false;
	}
	
	protected OutlineNodeFactory getOutlineNodeFactory() {
		return factory;
	}
}
