/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * An EMF object might store the node model information differently from the default adapter
 * based approach. If it implements {@link INodeReference}, it will be queried by 
 * {@link NodeModelUtils#getNode(org.eclipse.emf.ecore.EObject)}.
 * 
 * Alternatively, the {@link EObject} might contain an adapter for the {@link ICompositeNode ICompositeNode.class}
 * which also implements {@link INodeReference}. This is mostly meant as a compatiblity mode
 * for existing EMF packages that cannot be altered in a way that the EObject itself fulfills this
 * interface.
 * 
 * @see NodeModelBuilder#associateWithSemanticElement(ICompositeNode, org.eclipse.emf.ecore.EObject)
 * @see NodeModelUtils#getNode(org.eclipse.emf.ecore.EObject)
 * 
 * @since 2.34
 */
public interface INodeReference {

	/**
	 * Return the referenced node, if any.
	 */
	/* @Nullable */ ICompositeNode getNode();
	

}
