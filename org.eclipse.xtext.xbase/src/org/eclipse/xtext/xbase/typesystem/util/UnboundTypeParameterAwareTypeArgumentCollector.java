/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString, inline into super type if only subtype and super type not used besides in tests
 */
public class UnboundTypeParameterAwareTypeArgumentCollector extends ActualTypeArgumentCollector {

	protected class UnboundTypeParameterAwareUnboundTypeReferenceTraverser extends UnboundTypeReferenceTraverser {
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
		protected void doVisitUnboundTypeReference(UnboundTypeReference reference, UnboundTypeReference declaration) {
			if (declaration.internalIsResolved() || getOwner().isResolved(declaration.getHandle())) {
				declaration.tryResolve();
				outerVisit(declaration, reference, declaration, getExpectedVariance(), getActualVariance());
			} else {
				if (getParametersToProcess().contains(declaration.getTypeParameter()) && VarianceInfo.OUT == getActualVariance() && VarianceInfo.OUT == getExpectedVariance()) {
					if (getDefaultSource() == BoundTypeArgumentSource.EXPECTATION) {
						List<LightweightBoundTypeArgument> hints = reference.getAllHints();
						for(int i = 0; i < hints.size(); i++) {
							if (hints.get(i).getSource() == BoundTypeArgumentSource.INFERRED) {
								return;
							}
						}
					}
				}
				acceptHint(declaration, reference);
			}
		}
		
		@Override
		protected void doVisitCompoundTypeReference(CompoundTypeReference reference, UnboundTypeReference param) {
			doVisitTypeReference(reference, param);
		}
	}

	protected class UnboundTypeParameterAwareParameterizedTypeReferenceTraverser extends
			ActualParameterizedTypeReferenceTraverser {
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

		@Override
		protected void doVisitCompoundTypeReference(CompoundTypeReference reference,
				ParameterizedTypeReference declaration) {
			JvmType type = declaration.getType();
			if (type instanceof JvmTypeParameter) {
				JvmTypeParameter unboundTypeParameter = (JvmTypeParameter) type;
				if (shouldProcess(unboundTypeParameter)) {
					processTypeParameter(unboundTypeParameter, reference);
				}
			} else {
				super.doVisitCompoundTypeReference(reference, declaration);
			}
		}
	}

	public UnboundTypeParameterAwareTypeArgumentCollector(Collection<JvmTypeParameter> parametersToBeMapped,
			BoundTypeArgumentSource defaultSource, ITypeReferenceOwner owner) {
		super(parametersToBeMapped, defaultSource, owner);
	}

	@Override
	protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
		return new UnboundTypeParameterPreservingSubstitutor(mapping, getOwner());
	}

	@Override
	protected UnboundTypeReferenceTraverser createUnboundTypeReferenceTraverser() {
		return new UnboundTypeParameterAwareUnboundTypeReferenceTraverser();
	}
	
	protected void acceptHint(UnboundTypeReference reference, LightweightTypeReference param) {
		reference.acceptHint(boundByDefaultSource(param));
	}

	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new UnboundTypeParameterAwareParameterizedTypeReferenceTraverser();
	}

	@Override
	protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		return UnboundTypeReferences.findMappedParameter(parameter, mapping, visited);
	}
	
}