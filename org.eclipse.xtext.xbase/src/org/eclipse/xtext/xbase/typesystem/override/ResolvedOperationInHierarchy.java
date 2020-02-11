/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.RawTypeSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResolvedOperationInHierarchy extends AbstractResolvedOperation {

	private BottomResolvedOperation bottom;
	private IOverrideCheckResult checkResult;
	
	protected ResolvedOperationInHierarchy(JvmOperation declaration, BottomResolvedOperation bottom) {
		super(declaration, bottom.getContextType());
		this.bottom = bottom;
	}
	
	@Override
	public List<JvmTypeParameter> getResolvedTypeParameters() {
		return bottom.getResolvedTypeParameters();
	}

	@Override
	public boolean isBottomInContext() {
		return false;
	}
	
	@Override
	protected BottomResolvedOperation getBottom() {
		return bottom;
	}

	@Override
	public IResolvedOperation getAsBottom() {
		JvmOperation operation = getDeclaration();
		JvmDeclaredType declaringType = operation.getDeclaringType();
		List<LightweightTypeReference> superTypes = getContextType().getAllSuperTypes();
		for(LightweightTypeReference superType: superTypes) {
			if (superType.getType() == declaringType) {
				return new BottomResolvedOperation(operation, superType, getBottom().getOverrideTester());
			}
		}
		throw new IllegalStateException(String.format("Could not find declaring type of method %s in hierarchy of %s", 
				operation.getIdentifier(), getContextType().getIdentifier()));
	}

	@Override
	protected TypeParameterSubstitutor<?> getSubstitutor() {
		if (isRawTypeInheritance()) {
			return new RawTypeSubstitutor(getContextType().getOwner());
		}
		TypeParameterSubstitutor<?> result = super.getSubstitutor();
		List<JvmTypeParameter> typeParameters = getTypeParameters();
		if (!typeParameters.isEmpty()) {
			List<JvmTypeParameter> resolvedTypeParameters = getResolvedTypeParameters();
			int max = Math.min(typeParameters.size(), resolvedTypeParameters.size());
			ITypeReferenceOwner owner = getContextType().getOwner();
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> additionalMapping = Maps.newHashMapWithExpectedSize(max);
			for(int i = 0; i < max; i++) {
				LightweightTypeReference localReference = owner.newParameterizedTypeReference(resolvedTypeParameters.get(i));
				additionalMapping.put(typeParameters.get(i), new LightweightMergedBoundTypeArgument(localReference, VarianceInfo.INVARIANT));
			}
			result.enhanceMapping(additionalMapping);
		}
		return result;
	}
	
	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getContextTypeParameterMapping()  {
		return getBottom().getContextTypeParameterMapping();
	}
	
	@Override
	public IOverrideCheckResult getOverrideCheckResult() {
		return checkResult;
	}

	protected void setCheckResult(IOverrideCheckResult checkResult) {
		this.checkResult = checkResult;
	}
	
	@Override
	public String toString() {
		return String.format("%s overridden by %s", getDeclaration().getIdentifier(), getBottom());
	}
}
