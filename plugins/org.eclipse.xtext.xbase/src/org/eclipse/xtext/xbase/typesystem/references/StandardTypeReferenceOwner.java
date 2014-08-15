/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
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

	private final CommonTypeComputationServices services;
	private final ResourceSet context;
	private LightweightTypeReferenceFactory factory;

	public StandardTypeReferenceOwner(CommonTypeComputationServices services, /* @Nullable */ ResourceSet context) {
		this.services = services;
		this.context = context;
		this.factory = new LightweightTypeReferenceFactory(this);
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
	
	public LightweightTypeReferenceFactory getFactory() {
		return factory;
	}
	
	public void setFactory(LightweightTypeReferenceFactory factory) {
		if (factory == null) {
			throw new IllegalArgumentException("Factory may not be null");
		}
		this.factory = factory;
	}

	/**
	 * Returns the context resource set if any.
	 */
	public ResourceSet getContextResourceSet() {
		return context;
	}

	/**
	 * @throws UnsupportedOperationException always
	 */
	public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @throws UnsupportedOperationException always
	 */
	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @throws UnsupportedOperationException always
	 */
	public boolean isResolved(Object handle) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @return the empty list
	 */
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		return Collections.emptyList();
	}

	public LightweightTypeReference toPlainTypeReference(JvmType type) {
		return factory.toRawLightweightReference(type);
	}

	public LightweightTypeReference toPlainTypeReference(JvmTypeReference type) {
		return factory.toRawLightweightReference(type);
	}

	public LightweightTypeReference toLightweightTypeReference(JvmType type) {
		return factory.toLightweightReference(type);
	}

	public LightweightTypeReference toLightweightTypeReference(JvmTypeReference type) {
		return factory.toLightweightReference(type);
	}
	
	public CompoundTypeReference newCompoundTypeReference(boolean synonym) {
		return new CompoundTypeReference(this, synonym);
	}
	
	public WildcardTypeReference newWildcardTypeReference() {
		return new WildcardTypeReference(this);
	}
	
	public ArrayTypeReference newArrayTypeReference(LightweightTypeReference componentTypeReference) {
		return new ArrayTypeReference(this, componentTypeReference);
	}

	public FunctionTypeReference newFunctionTypeReference(JvmType type) {
		FunctionTypeReference result;
		if (factory.isInner(type)) {
			ParameterizedTypeReference outer = createOuterTypeReference((JvmDeclaredType)type.eContainer());
			result = new InnerFunctionTypeReference(this, outer, type);
		} else {
			result = new FunctionTypeReference(this, type);
		}
		return result;
	}
	
	public InnerFunctionTypeReference newFunctionTypeReference(LightweightTypeReference outer, JvmType type) {
		return new InnerFunctionTypeReference(this, outer, type);
	}
	
	public ParameterizedTypeReference newParameterizedTypeReference(JvmType type) {
		ParameterizedTypeReference result;
		if (factory.isInner(type)) {
			ParameterizedTypeReference outer = createOuterTypeReference((JvmDeclaredType)type.eContainer());
			result = new InnerTypeReference(this, outer, type);
		} else {
			result = new ParameterizedTypeReference(this, type);
		}
		return result;
	}
	
	protected ParameterizedTypeReference createOuterTypeReference(JvmDeclaredType outerType) {
		ParameterizedTypeReference result;
		if (factory.isInner(outerType)) {
			ParameterizedTypeReference outer = createOuterTypeReference((JvmDeclaredType)outerType.eContainer());
			result = new InnerTypeReference(this, outer, outerType);
		} else {
			result = new ParameterizedTypeReference(this, outerType);
		}
		return result;
	}
	
	public InnerTypeReference newParameterizedTypeReference(LightweightTypeReference outer, JvmType type) {
		return new InnerTypeReference(this, outer, type);
	}

	public UnknownTypeReference newUnknownTypeReference() {
		return new UnknownTypeReference(this);
	}

	public UnknownTypeReference newUnknownTypeReference(String name) {
		return new UnknownTypeReference(this, name);
	}

	public AnyTypeReference newAnyTypeReference() {
		return new AnyTypeReference(this);
	}

}