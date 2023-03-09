/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceInitializer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeLiteralHelper {
	
	private ExpressionTypeComputationState state;

	protected TypeLiteralHelper(ExpressionTypeComputationState state) {
		this.state = state;
	}

	/**
	 * @deprecated use {@link ITypeReferenceOwner#newReferenceTo(Class)} instead.
	 */
	@Deprecated
	/* @Nullable */
	protected LightweightTypeReference getRawTypeForName(Class<?> clazz, ITypeReferenceOwner owner) {
		return owner.newReferenceTo(clazz);
	}
	
	protected LightweightTypeReference getAsClassLiteral(final JvmIdentifiableElement feature) {
		if (feature instanceof JvmType) {
			final ITypeReferenceOwner owner = state.getReferenceOwner();
			return owner.newReferenceTo(Class.class, new TypeReferenceInitializer<ParameterizedTypeReference>() {
				@Override
				public LightweightTypeReference enhance(ParameterizedTypeReference reference) {
					LightweightTypeReference argumentType = owner.newParameterizedTypeReference((JvmType) feature);
					if (argumentType.isPrimitiveVoid()) {
						argumentType = owner.newReferenceTo(Void.class);
					} else {
						argumentType = argumentType.getWrapperTypeIfPrimitive();
					}
					reference.addTypeArgument(argumentType);
					return reference;
				}
			});
		}
		throw new IllegalArgumentException(String.valueOf(feature));
	}
	
	protected void applyPackageFragment(XMemberFeatureCall memberFeatureCall, JvmDeclaredType type) {
		XExpression target = memberFeatureCall.getMemberCallTarget();
		state.getResolvedTypes().acceptType(
				target, 
				new NoExpectation(state, false),
				state.getReferenceOwner().newParameterizedTypeReference(type),
				false,
				ConformanceFlags.CHECKED_SUCCESS);
		if (target instanceof XMemberFeatureCall) {
			applyPackageFragment((XMemberFeatureCall) target, type);
		}
	}
	
}
