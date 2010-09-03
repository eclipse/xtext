/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.outline;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.PolymorphicDispatcher;

/**
 * customization of the default outline structure
 * 
 */
public class ArithmeticsOutlineTreeProvider extends DefaultOutlineTreeProvider {

	private PolymorphicDispatcher<Iterable<? extends EObject>> semanticChildrenIterator = PolymorphicDispatcher
			.createForSingleTarget("getSemanticChildren", 1, 1, this);

	@Override
	protected List<IOutlineNode> createChildren(final EObjectNode parentNode,
			Resource resource) {
		EObject eObject = parentNode.getEObject(resource);
		for (EObject childElement : semanticChildrenIterator.invoke(eObject))
			createNode(parentNode, childElement);
		return parentNode.getChildren();
	}

	protected Iterable<? extends EObject> getSemanticChildren(Module module) {
		return EcoreUtil2.typeSelect(module.eContents(), Definition.class);
	}

	protected Iterable<? extends EObject> getSemanticChildren(Definition definition) {
		return Collections.emptyList();
	}
	
	protected Iterable<? extends EObject> getSemanticChildren(EObject eObject) {
		return eObject.eContents();
	}
	
}
