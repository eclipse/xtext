/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.OutlineLabelProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;

import com.google.inject.Inject;

public class DefaultOutlineTreeProvider implements IOutlineTreeProvider {

	@Inject
	@OutlineLabelProvider
	protected ILabelProvider labelProvider;

	@Inject
	protected ILocationInFileProvider locationInFileProvider;

	private PolymorphicDispatcher<List<IOutlineNode>> createChildrenDispatcher = PolymorphicDispatcher
			.createForSingleTarget("createChildren", 2, 2, this);

	private PolymorphicDispatcher<AbstractOutlineNode> createNodeDispatcher = PolymorphicDispatcher
			.createForSingleTarget("createNode", 2, 2, this);

	public IOutlineNode createRoot(IXtextDocument document, Resource resource) {
		DocumentRootNode documentNode = new DocumentRootNode(labelProvider.getImage(document),
				labelProvider.getText(document), true, document, this, locationInFileProvider);
		return documentNode;
	}

	public List<IOutlineNode> createChildren(IOutlineNode parent, Resource resource) {
		return createChildrenDispatcher.invoke(parent, resource);
	}

	protected List<IOutlineNode> createChildren(Object parent, Resource resource) {
		return Collections.emptyList();
	}

	protected List<IOutlineNode> createChildren(DocumentRootNode parentNode, Resource resource) {
		for (EObject childElement : resource.getContents())
			createNodeDispatcher.invoke(parentNode, childElement);
		return parentNode.getChildren();
	}

	protected List<IOutlineNode> createChildren(final EObjectNode parentNode, Resource resource) {
		EObject eObject = parentNode.getEObject(resource);
		for (EObject childElement : eObject.eContents())
			createNodeDispatcher.invoke(parentNode, childElement);
		return parentNode.getChildren();
	}

	protected List<IOutlineNode> createChildren(EReferenceNode parentNode, Resource resource) {
		Object values = parentNode.getValue(resource);
		if(values != null) {
			if(parentNode.getEReference().isMany()) {
				for(Object value: (List<?>) values) {
					createNode(parentNode, value);
				}
			} else {
				createNode(parentNode, values);
			}
		}
		return parentNode.getChildren();
	}

	protected List<IOutlineNode> createChildren(ArtificialNode parentNode, Resource resource) {
		return Collections.emptyList();
	}

	protected AbstractOutlineNode createNode(IOutlineNode parentNode, EObject eObject) {
		String text = labelProvider.getText(eObject);
		Image image = labelProvider.getImage(eObject);
		EObjectNode eObjectNode = new EObjectNode(eObject, parentNode, image, text, !eObject.eContents().isEmpty());
		return eObjectNode;
	}

	protected AbstractOutlineNode createNode(Object object0, Object object1) {
		throw new IllegalArgumentException("Could not find method createNode(" + nullSafeClassName(object0) + ","
				+ nullSafeClassName(object1));
	}

	protected String nullSafeClassName(Object object) {
		return (object != null) ? object.getClass().getName() : "null";
	}

}
