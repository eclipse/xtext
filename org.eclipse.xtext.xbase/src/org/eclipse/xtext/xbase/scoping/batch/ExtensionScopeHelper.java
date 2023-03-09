/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceVisitorWithResult;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExtensionScopeHelper {

	private LightweightTypeReference rawArgumentType;
	private LightweightTypeReference argumentType;
	private boolean resolvedComputed;
	private boolean resolved;

	public ExtensionScopeHelper(LightweightTypeReference argumentType) {
		this.argumentType = argumentType;
		this.rawArgumentType = argumentType.getRawTypeReference();
		
	}
	
	/**
	 * Features that are valid extensions are all {@link JvmOperation operations}
	 * with at least one {@link JvmExecutable#getParameters() parameter}.
	 */
	protected boolean isPossibleExtension(JvmFeature feature) {
		if (!(feature instanceof JvmOperation)) {
			return false;
		}
		List<JvmFormalParameter> parameters = ((JvmExecutable) feature).getParameters();
		if (parameters.isEmpty()) {
			return false;
		}
		return true;
	}
	
	protected boolean isResolvedReceiverType() {
		if (resolvedComputed) {
			return resolved;
		}
		resolvedComputed = true;
		return resolved = isResolvedOrKnownTypeParam(argumentType);
	}

	/**
	 * Check the type of the first parameter against the argument type rather
	 * than the {@link #rawArgumentType}. Should not be used during linking
	 * since we need proper error messages there for type mismatches.
	 */
	protected boolean isMatchingFirstParameterDeepCheck(JvmOperation feature) {
		if (isMatchingFirstParameter(feature)) {
			if (isResolvedReceiverType()) {
				LightweightTypeReference parameterType = argumentType.getOwner().toLightweightTypeReference(feature.getParameters().get(0).getParameterType());
				if (isResolvedOrKnownTypeParam(parameterType) && !parameterType.isAssignableFrom(argumentType)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	protected boolean isMatchingFirstParameter(JvmOperation feature) {
		List<JvmFormalParameter> parameters = feature.getParameters();
		JvmFormalParameter firstParameter = parameters.get(0);
		JvmTypeReference type = firstParameter.getParameterType();
		if (type == null)
			return false;
		JvmType rawParameterType = type.getType();
		if (rawParameterType == null || rawParameterType.eIsProxy())
			return false;
		if (!(rawParameterType instanceof JvmTypeParameter)) {
			if (rawArgumentType.isResolved()) {
				// short circuit - limit extension scope entries to real candidates
				LightweightTypeReference parameterTypeReference = rawArgumentType.getOwner().toPlainTypeReference(rawParameterType);
				if (parameterTypeReference.isResolved() && !parameterTypeReference.isAssignableFrom(rawArgumentType)) {
					if (parameterTypeReference.isArray() && !rawArgumentType.isArray() && rawArgumentType.isSubtypeOf(Iterable.class)) {
						return true;
					}
					return false;
				}
				if (parameterTypeReference.isArray() && !rawArgumentType.isArray() && !rawArgumentType.isSubtypeOf(Iterable.class)) {
					return false;
				}
			} else if (isArrayTypeMismatch(rawArgumentType, rawParameterType)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isArrayTypeMismatch(LightweightTypeReference rawReceiverType, JvmType rawParameterType) {
		if (rawReceiverType.isArray()) {
			LightweightTypeReference parameterTypeReference = rawReceiverType.getOwner().toPlainTypeReference(rawParameterType);
			if (parameterTypeReference.getSuperType(Iterable.class) == null && isArrayTypeMismatch(rawReceiverType, parameterTypeReference)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isArrayTypeMismatch(LightweightTypeReference receiverType, LightweightTypeReference parameterType) {
		if (receiverType.isArray()) {
			if (parameterType.isArray()) {
				LightweightTypeReference componentType = parameterType.getComponentType();
				if (isArrayTypeMismatch(receiverType.getComponentType(), componentType)) {
					return true;
				}
				return false;
			}
			return true;
		} else {
			if (!parameterType.isArray() && parameterType.isPrimitive()) {
				return true;
			}
		}
		return false;
	}
	
	protected boolean isResolvedOrKnownTypeParam(LightweightTypeReference type) {
		return type.accept(new IsResolvedKnownTypeParamHelper());
	}
	
	/**
	 * Determines if a reference is fully resolved or uses only type parameters from the
	 * current context.
	 */
	protected static class IsResolvedKnownTypeParamHelper extends TypeReferenceVisitorWithResult<Boolean> {
		@Override
		protected Boolean doVisitTypeReference(LightweightTypeReference reference) {
			return reference.isResolved();
		}
		
		@Override
		protected Boolean doVisitArrayTypeReference(ArrayTypeReference reference) {
			return reference.getComponentType().accept(this);
		}
		
		@Override
		protected Boolean doVisitWildcardTypeReference(WildcardTypeReference reference) {
			if (reference.isResolved()) {
				return true;
			}
			if (!visit(reference.getUpperBounds())) {
				return false;
			}
			LightweightTypeReference lowerBound = reference.getLowerBound();
			if (lowerBound != null) {
				return lowerBound.accept(this);
			}
			return true;
		}
		
		@Override
		protected Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
			if (reference.isResolved()) {
				return true;
			}
			if (reference.getOwner().getDeclaredTypeParameters().contains(reference.getType())) {
				return true;
			}
			if (!visit(reference.getTypeArguments())) {
				return false;
			}
			return !(reference.getType() instanceof JvmTypeParameter);
		}
		
		@Override
		protected Boolean doVisitCompoundTypeReference(CompoundTypeReference reference) {
			if (reference.isResolved()) {
				return true;
			}
			return visit(reference.getMultiTypeComponents());
		}
		
		protected boolean visit(List<LightweightTypeReference> list) {
			for(LightweightTypeReference arg: list) {
				if (!arg.accept(this)) {
					return false;
				}
			}
			return true;
		}
	}
	
}
