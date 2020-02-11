/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class UnboundTypeParameterPreservingSubstitutor extends TypeParameterSubstitutor<Set<JvmTypeParameter>> {
	
	public UnboundTypeParameterPreservingSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			ITypeReferenceOwner owner) {
		super(typeParameterMapping, owner);
	}

	@Override
	protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference,
			Set<JvmTypeParameter> visiting) {
		return reference.copyInto(getOwner());
	}

	@Override
	/* @Nullable */
	protected LightweightTypeReference getBoundTypeArgument(ParameterizedTypeReference reference, JvmTypeParameter type, Set<JvmTypeParameter> visiting) {
		LightweightMergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(type);
		if (boundTypeArgument != null) {
			LightweightTypeReference boundReference = boundTypeArgument.getTypeReference();
			if (boundReference != null && reference != boundReference) {
				if (boundReference instanceof UnboundTypeReference)
					return boundReference.copyInto(getOwner());
				JvmType boundType = boundReference.getType();
				if (boundType != type) {
					if (visiting.add(type)) {
						try {
							LightweightTypeReference result = boundReference.accept(this, visiting);
							return result;
						} finally {
							visiting.remove(type);
						}
					} else {
						return reference;
					}
				} 
			}
		}
		return null;
	}

	@Override
	protected Set<JvmTypeParameter> createVisiting() {
		return Sets.newHashSetWithExpectedSize(3);
	}
	
}