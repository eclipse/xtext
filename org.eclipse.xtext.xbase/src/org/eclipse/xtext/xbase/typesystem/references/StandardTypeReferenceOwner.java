/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.common.types.TypesPackage;
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
	
	@Override
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
	@Override
	public ResourceSet getContextResourceSet() {
		return context;
	}

	/**
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public List<LightweightBoundTypeArgument> getAllHints(Object handle) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public boolean isResolved(Object handle) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @return the empty list
	 */
	@Override
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		return Collections.emptyList();
	}

	@Override
	public LightweightTypeReference toPlainTypeReference(JvmType type) {
		return factory.toPlainTypeReference(type);
	}

	@Override
	public LightweightTypeReference toLightweightTypeReference(JvmType type) {
		return factory.toLightweightReference(type);
	}

	@Override
	public LightweightTypeReference toLightweightTypeReference(JvmTypeReference type) {
		return factory.toLightweightReference(type);
	}
	
	@Override
	public CompoundTypeReference newCompoundTypeReference(boolean synonym) {
		return new CompoundTypeReference(this, synonym);
	}
	
	@Override
	public WildcardTypeReference newWildcardTypeReference() {
		return new WildcardTypeReference(this);
	}
	
	@Override
	public ArrayTypeReference newArrayTypeReference(LightweightTypeReference componentTypeReference) {
		return new ArrayTypeReference(this, componentTypeReference);
	}

	@Override
	public FunctionTypeReference newFunctionTypeReference(JvmType type) {
		FunctionTypeReference result;
		if (factory.isInner(type)) {
			ParameterizedTypeReference outer = newParameterizedTypeReference((JvmDeclaredType)type.eContainer());
			result = new InnerFunctionTypeReference(this, outer, type);
		} else {
			result = new FunctionTypeReference(this, type);
		}
		return result;
	}
	
	@Override
	public InnerFunctionTypeReference newFunctionTypeReference(LightweightTypeReference outer, JvmType type) {
		if (!factory.isInner(type)) {
			throw new IllegalArgumentException(String.valueOf(type));
		}
		return new InnerFunctionTypeReference(this, outer, type);
	}
	
	@Override
	public ParameterizedTypeReference newParameterizedTypeReference(JvmType type) {
		ParameterizedTypeReference result;
		if (factory.isInner(type)) {
			ParameterizedTypeReference outer = newParameterizedTypeReference((JvmDeclaredType)type.eContainer());
			result = new InnerTypeReference(this, outer, type);
		} else {
			result = new ParameterizedTypeReference(this, type);
		}
		return result;
	}
	
	@Override
	public InnerTypeReference newParameterizedTypeReference(LightweightTypeReference outer, JvmType type) {
		if (!factory.isInner(type)) {
			throw new IllegalArgumentException(String.valueOf(type));
		}
		return new InnerTypeReference(this, outer, type);
	}

	@Override
	public UnknownTypeReference newUnknownTypeReference() {
		return new UnknownTypeReference(this);
	}

	@Override
	public UnknownTypeReference newUnknownTypeReference(String name) {
		return new UnknownTypeReference(this, name);
	}

	@Override
	public AnyTypeReference newAnyTypeReference() {
		return new AnyTypeReference(this);
	}
	
	/**
	 * Creates a references to {@link Object} or returns an {@link UnknownTypeReference} if no
	 * JRE is available.
	 */
	@Override
	public LightweightTypeReference newReferenceToObject() {
		return newReferenceTo(Object.class);
	}
	
	/**
	 * Creates a wildcard reference to {@link Object} or returns a wildcard to an {@link UnknownTypeReference} if no
	 * JRE is available.
	 */
	@Override
	public WildcardTypeReference newWildcardExtendsObject() {
		WildcardTypeReference result = newWildcardTypeReference();
		result.addUpperBound(newReferenceToObject());
		return result;
	}
	
	/**
	 * Creates a references to the given class or returns an {@link UnknownTypeReference} if no
	 * JRE is available.
	 */
	@Override
	public LightweightTypeReference newReferenceTo(Class<?> type) {
		JvmType rawType = getServices().getTypeReferences().findDeclaredType(type, getContextResourceSet());
		if (rawType == null) {
			return newUnknownTypeReference(type.getName());
		}
		return toPlainTypeReference(rawType);
	}
	
	/**
	 * Creates a references to the given class or returns an {@link UnknownTypeReference} if no
	 * JRE is available. If the type is available, the given acceptor is used to initialize it further.
	 */
	@Override
	public LightweightTypeReference newReferenceTo(Class<?> type, TypeReferenceInitializer<? super ParameterizedTypeReference> init) {
		if (init == null) {
			throw new NullPointerException("initializer");
		}
		JvmType rawType = getServices().getTypeReferences().findDeclaredType(type, getContextResourceSet());
		if (rawType == null) {
			return newUnknownTypeReference(type.getName());
		}
		if (rawType.eClass() == TypesPackage.Literals.JVM_ARRAY_TYPE) {
			throw new IllegalArgumentException("given type is an array type: " + type);
		}
		ParameterizedTypeReference result = newParameterizedTypeReference(rawType);
		return init.enhance(result);
	}

}