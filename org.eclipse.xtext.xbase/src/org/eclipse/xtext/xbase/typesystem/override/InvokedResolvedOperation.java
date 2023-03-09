/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InvokedResolvedOperation extends BottomResolvedOperation {

	public static class Provider {
		
		@Inject private OverrideTester overrideTester;
		@Inject private IBatchTypeResolver batchTypeResolver;
		@Inject private CommonTypeComputationServices services;
		
		public InvokedResolvedOperation resolve(XAbstractFeatureCall featureCall) {
			IResolvedTypes resolvedTypes = batchTypeResolver.resolveTypes(featureCall);
			ITypeReferenceOwner owner = new StandardTypeReferenceOwner(services, featureCall);
			return resolve(featureCall, resolvedTypes, owner);
		}
		
		protected InvokedResolvedOperation resolve(XAbstractFeatureCall featureCall, IResolvedTypes resolvedTypes, ITypeReferenceOwner owner) {
			JvmIdentifiableElement feature = featureCall.getFeature();
			if (feature instanceof JvmOperation) {
				LightweightTypeReference contextType = getReceiverType(featureCall, resolvedTypes, owner);
				return new InvokedResolvedOperation((JvmOperation) feature, contextType, resolvedTypes.getActualTypeArguments(featureCall), overrideTester);
			} else {
				throw new IllegalArgumentException();
			}
		}
		
		protected LightweightTypeReference getReceiverType(XAbstractFeatureCall featureCall, IResolvedTypes resolvedTypes, ITypeReferenceOwner owner) {
			XExpression receiver = featureCall.getActualReceiver();
			if (receiver == null) {
				// static feature call
				JvmOperation operation = (JvmOperation) featureCall.getFeature();
				JvmDeclaredType declaringType = operation.getDeclaringType();
				return owner.newParameterizedTypeReference(declaringType);
			}
			return resolvedTypes.getActualType(receiver);
		}
	}
	
	private final List<LightweightTypeReference> typeArguments;
	
	protected InvokedResolvedOperation(JvmOperation operation, LightweightTypeReference contextType, List<LightweightTypeReference> typeArguments, OverrideTester overrideTester) {
		super(operation, contextType, overrideTester);
		this.typeArguments = typeArguments;
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> computeContextTypeParameterMapping() {
		if (typeArguments.isEmpty()) {
			return super.computeContextTypeParameterMapping();
		}
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> result = Maps.newHashMap(super.computeContextTypeParameterMapping());
		List<JvmTypeParameter> typeParameters = getDeclaration().getTypeParameters();
		for(int i = 0; i < Math.min(typeParameters.size(), typeArguments.size()); i++) {
			result.put(typeParameters.get(i), new LightweightMergedBoundTypeArgument(typeArguments.get(i), VarianceInfo.INVARIANT));
		}
		return result;
	}

	public List<LightweightTypeReference> getResolvedTypeArguments() {
		return Collections.unmodifiableList(typeArguments);
	}
}
