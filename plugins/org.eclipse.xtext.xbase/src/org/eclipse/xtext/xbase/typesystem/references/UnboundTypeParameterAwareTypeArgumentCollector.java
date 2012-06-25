/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString, inline into super type if only subtype and super type not used besides in tests
 */
@NonNullByDefault
public class UnboundTypeParameterAwareTypeArgumentCollector extends ActualTypeArgumentCollector {

	public UnboundTypeParameterAwareTypeArgumentCollector(List<JvmTypeParameter> parametersToBeMapped,
			BoundTypeArgumentSource defaultSource, TypeReferenceOwner owner) {
		super(parametersToBeMapped, defaultSource, owner);
	}

	@Override
	protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
		return new UnboundTypeParameterPreservingSubstitutor(mapping, getOwner());
	}

	@Override
	public void doVisitUnboundTypeReference(UnboundTypeReference reference, LightweightTypeReference param) {
		if (param instanceof UnboundTypeReference) {
			UnboundTypeReference castedParam = (UnboundTypeReference) param;
			if (castedParam.getHandle().equals(reference.getHandle()))
				return;
		}
		acceptHint(reference, param);
	}

	protected void acceptHint(UnboundTypeReference reference, LightweightTypeReference param) {
		reference.acceptHint(boundByDefaultSource(param));
	}

	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new ActualParameterizedTypeReferenceTraverser() {
			@Override
			public void doVisitUnboundTypeReference(UnboundTypeReference reference,
					ParameterizedTypeReference declaration) {
				JvmType type = declaration.getType();
				if (type instanceof JvmTypeParameter) {
					JvmTypeParameter unboundTypeParameter = (JvmTypeParameter) type;
					if (unboundTypeParameter != reference.getTypeParameter() && shouldProcess(unboundTypeParameter)) {
						processTypeParameter(unboundTypeParameter, reference);
					} else {
						// register synonym type param resolution et al for the actual type in the given UnboundTypeParameter
					}
				} else {
					acceptHint(reference, declaration);
				}
			}
		};
	}

	@Override
	protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		return UnboundTypeReferences.findMappedParameter(parameter, mapping, visited);
	}
	
}