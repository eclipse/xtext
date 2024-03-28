/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @since 2.35
 */
public abstract class NodeModelReference {
	protected abstract ICompositeNode rootNode();

	protected abstract void release();
	
	protected abstract ICompositeNode getNode(EObject semanticObject);

	protected abstract INode getNode(int id);
	
	protected abstract int getId(INode node);
}