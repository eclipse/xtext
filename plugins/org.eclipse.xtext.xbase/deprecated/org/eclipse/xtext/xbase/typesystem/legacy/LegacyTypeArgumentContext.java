/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.legacy;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.StandardTypeParameterSubstitutor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class LegacyTypeArgumentContext implements ITypeArgumentContext {

	private final CommonTypeComputationServices services;
	private final TypeArgumentContextProvider.Request request;
	private final JvmTypeReference receiver;
	private final Resource resource;
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;

	public LegacyTypeArgumentContext(TypeArgumentContextProvider.Request request, CommonTypeComputationServices services) {
		this.request = request;
		this.services = services;
		this.receiver = request.getReceiverType();
		if (this.receiver != null && receiver.getType() != null) {
			this.resource = receiver.getType().eResource();
			if (resource == null) {
//				throw new IllegalArgumentException();
			}
		} else {
			resource = null;
		}
	}
	
	public TypeArgumentContextProvider.Request getRequest() {
		return request;
	}
	
	public JvmTypeReference getBoundArgument(JvmTypeParameter parameter) {
		LightweightMergedBoundTypeArgument argument = getTypeParameterMapping().get(parameter);
		if (argument != null) {
			return argument.getTypeReference().toTypeReference();
		}
		return null;
	}
	
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
		if (receiver == null || resource == null)
			return Collections.emptyMap();
		if (typeParameterMapping != null)
			return typeParameterMapping;
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, resource);
		LightweightTypeReference lightweightReceiver = new OwnedConverter(owner).toLightweightReference(receiver).getLowerBoundSubstitute();
		return typeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(lightweightReceiver);
	}

	public JvmTypeReference getLowerBound(JvmTypeReference reference) {
		LightweightTypeReference result = substitute(reference);
		if (result == null) {
			return reference;
		}
		result = result.getLowerBoundSubstitute();
		return result.toTypeReference();
	}

	@Nullable
	protected LightweightTypeReference substitute(JvmTypeReference reference) {
		Resource resource = this.resource;
		if (resource == null) {
			resource = reference.eResource();
			if (resource == null && reference.getType() != null) {
				resource = reference.getType().eResource();
			}
		}
		if (resource == null)
			return null;
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = getTypeParameterMapping();
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, resource);
		LightweightTypeReference lightweightReference = new OwnedConverter(owner).toLightweightReference(reference);
		StandardTypeParameterSubstitutor substitutor = new StandardTypeParameterSubstitutor(mapping, owner);
		LightweightTypeReference result = substitutor.substitute(lightweightReference);
		return result;
	}

	public JvmTypeReference getUpperBound(JvmTypeReference element, Notifier context) {
		throw new UnsupportedOperationException("Only valid operation is #getRequest");
	}

	public JvmTypeReference resolve(JvmTypeReference reference) {
		throw new UnsupportedOperationException("Only valid operation is #getRequest");
	}

	public boolean isRawTypeContext() {
		throw new UnsupportedOperationException("Only valid operation is #getRequest");
	}

}
