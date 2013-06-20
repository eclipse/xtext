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
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.label.ILabelProviderImageDescriptorExtension;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * An outline tree (structure) provider using {@link ImageDescriptor}s instead of {@link Image}s. This allows to create
 * the tree of {@link IOutlineNode}s in a background job. Use this class instead of the
 * {@link DefaultOutlineTreeProvider} if the UI blocks too long because of the outline calculation. Note that the
 * default implementation already calculates hidden nodes on demand only.
 * 
 * It is essential that the {@link ILabelProvider} implements {@link ILabelProviderImageDescriptorExtension} and that
 * the method {@link ILabelProviderImageDescriptorExtension#getImageDescriptor(Object)} does not need to be executed in
 * the {@link Display} thread, e.g. does not create {@link Image} objects internally.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public class BackgroundOutlineTreeProvider implements IOutlineTreeStructureProvider, IOutlineTreeProvider {

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
			else if (parentNode instanceof EStructuralFeatureNode)
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
		if (labelProvider instanceof ILabelProviderImageDescriptorExtension)
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

	protected OutlineNodeFactory getOutlineNodeFactory() {
		return factory;
	}
}
