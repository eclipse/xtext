/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.detachable;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.INodeReference;

/**
 * @since 2.35
 */
public class NodeReferenceAdapter extends AdapterImpl implements INodeReference {

	private final DetachableParseResult delegate;

	public NodeReferenceAdapter(DetachableParseResult delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public ICompositeNode getNode() {
		return delegate.getNode((EObject) getTarget());
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type instanceof Class<?> && INode.class.isAssignableFrom((Class<?>)type);
	}
	
}
