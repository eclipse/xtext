/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * Plain instantiable implementation of the {@link ITypeReferenceOwner}.
 * It is not capable of handling reference resolution or unbound type argument hints.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StandardTypeReferenceOwner implements ITypeReferenceOwner {

	private CommonTypeComputationServices services;
	private ResourceSet context;

	public StandardTypeReferenceOwner(CommonTypeComputationServices services, /* @Nullable */ ResourceSet context) {
		this.services = services;
		this.context = context;
	}
	
	public StandardTypeReferenceOwner(CommonTypeComputationServices services, EObject context) {
		this(services, context.eResource());
	}
	
	public StandardTypeReferenceOwner(CommonTypeComputationServices services, Resource context) {
		this(services, context.getResourceSet());
	}
	
	public CommonTypeComputationServices getServices() {
		return services;
	}

	/**
	 * Returns the context resource set if any.
	 */
	public ResourceSet getContextResourceSet() {
		return context;
	}

	public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		throw new UnsupportedOperationException();
	}

	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		throw new UnsupportedOperationException();
	}

	public boolean isResolved(Object handle) {
		throw new UnsupportedOperationException();
	}
	
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		return Collections.emptyList();
	}
	
}