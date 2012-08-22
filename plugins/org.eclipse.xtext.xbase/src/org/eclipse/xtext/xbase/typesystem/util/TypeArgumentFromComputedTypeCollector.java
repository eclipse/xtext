/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;

import com.google.common.collect.ListMultimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeArgumentFromComputedTypeCollector extends UnboundTypeParameterAwareTypeArgumentCollector {

	public static void resolveAgainstActualType(LightweightTypeReference declaredType, LightweightTypeReference actualType,
			List<JvmTypeParameter> typeParameters, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			BoundTypeArgumentSource source,
			ITypeReferenceOwner owner) {
		TypeArgumentFromComputedTypeCollector implementation = new TypeArgumentFromComputedTypeCollector(typeParameters, source, owner);
		implementation.populateTypeParameterMapping(declaredType, actualType);
		ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> parameterMapping = implementation.rawGetTypeParameterMapping();
		for(Map.Entry<JvmTypeParameter, LightweightBoundTypeArgument> entry: parameterMapping.entries()) {
			LightweightMergedBoundTypeArgument boundTypeArgument = typeParameterMapping.get(entry.getKey());
			if (boundTypeArgument != null ) {
				LightweightBoundTypeArgument computedBoundTypeArgument = entry.getValue();
				if (computedBoundTypeArgument.getSource() == BoundTypeArgumentSource.RESOLVED) {
					VarianceInfo varianceInfo = computedBoundTypeArgument.getDeclaredVariance().mergeDeclaredWithActual(computedBoundTypeArgument.getActualVariance());
					typeParameterMapping.put(entry.getKey(), new LightweightMergedBoundTypeArgument(computedBoundTypeArgument.getTypeReference(), varianceInfo));
				} else if (boundTypeArgument.getTypeReference() instanceof UnboundTypeReference) {
					UnboundTypeReference typeReference = (UnboundTypeReference) boundTypeArgument.getTypeReference();
					if (!typeReference.internalIsResolved()) {
						typeReference.acceptHint(entry.getValue());
					}
				}
			}
		}
	}
	
	public TypeArgumentFromComputedTypeCollector(List<JvmTypeParameter> parametersToBeMapped,
			BoundTypeArgumentSource defaultSource, ITypeReferenceOwner owner) {
		super(parametersToBeMapped, defaultSource, owner);
	}

	@Override
	@NonNullByDefault
	protected void acceptHint(UnboundTypeReference reference, LightweightTypeReference param) {
		if (!shouldProcess(reference.getTypeParameter())) {
			UnboundTypeReference casted = reference;
			casted.tryResolve();
			if (casted.internalIsResolved()) {
				outerVisit(reference, param);
			} else {
				super.acceptHint(reference, param);
			}
		} else {
			reference.acceptHint(boundByInference(param));
		}
	}
	@Override
	@NonNullByDefault
	protected UnboundTypeReferenceTraverser createUnboundTypeReferenceTraverser() {
		return new UnboundTypeReferenceTraverser() {
			@Override
			protected void doVisitTypeReference(LightweightTypeReference reference, UnboundTypeReference declaration) {
				if (declaration.internalIsResolved() || getOwner().isResolved(declaration.getHandle())) {
					declaration.tryResolve();
					outerVisit(declaration, reference, declaration, getExpectedVariance(), getActualVariance());
				} else {
					acceptHint(declaration, reference);
				}
			}
			
			@Override
			protected void doVisitCompoundTypeReference(CompoundTypeReference reference, UnboundTypeReference param) {
				doVisitTypeReference(reference, param);
			}
			
			@Override
			protected void doVisitWildcardTypeReference(WildcardTypeReference reference,
					UnboundTypeReference declaration) {
				if (shouldProcess(declaration.getTypeParameter())) {
					declaration.acceptHint(boundByInference(reference));
				} else {
					super.doVisitWildcardTypeReference(reference, declaration);
				}
			}
		};
	}
	private LightweightBoundTypeArgument boundByInference(LightweightTypeReference reference) {
		return new LightweightBoundTypeArgument(reference.getWrapperTypeIfPrimitive(), BoundTypeArgumentSource.INFERRED, getOrigin(), getExpectedVariance(), getActualVariance());
	}
}

