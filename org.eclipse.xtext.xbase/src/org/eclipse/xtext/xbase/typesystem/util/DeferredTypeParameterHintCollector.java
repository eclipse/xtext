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
import java.util.Set;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferenceFactory;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString - focus on differences to ActualTypeArgumentCollector and UnboundTypeParameterAwareTypeArgumentCollector
 */
public class DeferredTypeParameterHintCollector extends AbstractTypeReferencePairWalker {
	
	protected class UnboundTypeParameterHintCollector extends UnboundTypeReferenceTraverser {
		@Override
		protected void doVisitTypeReference(LightweightTypeReference reference, UnboundTypeReference declaration) {
			if (declaration.internalIsResolved() || getOwner().isResolved(declaration.getHandle())) {
				declaration.tryResolve();
				outerVisit(declaration, reference, declaration, getExpectedVariance(), getActualVariance());
			} else if (reference.isValidHint()) {
				addHint(declaration, reference);
			}
		}

		@Override
		protected void doVisitCompoundTypeReference(CompoundTypeReference reference, UnboundTypeReference param) {
			doVisitTypeReference(reference, param);
		}
	}

	public DeferredTypeParameterHintCollector(ITypeReferenceOwner owner) {
		super(owner);
	}
	
	@Override
	protected TypeParameterSubstitutor<?> createTypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping) {
		return new UnboundTypeParameterPreservingSubstitutor(mapping, getOwner());
	}

	protected LightweightTypeReference copy(UnboundTypeReference reference) {
		return reference.copyInto(getOwner());
	}
	
	@Override
	protected UnboundTypeReferenceTraverser createUnboundTypeReferenceTraverser() {
		return new UnboundTypeParameterHintCollector();
	}
	
	@Override
	protected CompoundTypeReferenceTraverser createCompoundTypeReferenceTraverser() {
		return new CompoundTypeReferenceTraverser() {
			@Override
			protected void doVisitUnboundTypeReference(UnboundTypeReference reference, CompoundTypeReference declaration) {
				if (declaration.isSynonym()) {
					super.doVisitUnboundTypeReference(reference, declaration);
				} else {
					addHint(reference, declaration);
				}
			}
		};
	}
	
	protected class DeferredParameterizedTypeReferenceHintCollector extends ParameterizedTypeReferenceTraverser {
		@Override
		public void doVisitUnboundTypeReference(UnboundTypeReference reference,
				ParameterizedTypeReference declaration) {
			addHint(reference, declaration);
		}
		
		@Override
		protected boolean shouldProcessInContextOf(JvmTypeParameter declaredTypeParameter, Set<JvmTypeParameter> boundParameters,
				Set<JvmTypeParameter> visited) {
			if (boundParameters.contains(declaredTypeParameter) && !visited.add(declaredTypeParameter)) {
				return false;
			}
			return true;
		}
		
		@Override
		protected void doVisitArrayTypeReference(ArrayTypeReference reference, ParameterizedTypeReference declaration) {
			JvmType type = declaration.getType();
			if (type instanceof JvmTypeParameter) {
				if (shouldProcess((JvmTypeParameter) type)) {
					JvmTypeParameter typeParameter = (JvmTypeParameter) type;
					processTypeParameter(typeParameter, reference);
				}
			} else {
				if (!declaration.isRawType() && (declaration.isType(List.class) || declaration.isType(Collection.class) || declaration.isType(Iterable.class))) {
					LightweightTypeReference elementType = declaration.getTypeArguments().get(0);
					LightweightTypeReference componentType = reference.getComponentType();
					outerVisit(componentType.getInvariantBoundSubstitute(), elementType);
				}
			}
		}
	}

	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new DeferredParameterizedTypeReferenceHintCollector();
	}
	
	@Override
	protected JvmTypeParameter findMappedParameter(JvmTypeParameter parameter,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping, Collection<JvmTypeParameter> visited) {
		return UnboundTypeReferences.findMappedParameter(parameter, mapping, visited);
	}

	protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
		LightweightTypeReference wrapped = getStricterConstraint(typeParameter, reference.getWrapperTypeIfPrimitive());
		if (wrapped != null) {
			typeParameter.acceptHint(wrapped, getTypeArgumentSource(), getOrigin(), getExpectedVariance(), getActualVariance());	
		}
	}

	protected BoundTypeArgumentSource getTypeArgumentSource() {
		return BoundTypeArgumentSource.INFERRED_LATER;
	}

	protected LightweightTypeReference getStricterConstraint(final UnboundTypeReference typeParameter, LightweightTypeReference hint) {
		final JvmTypeParameter parameter = typeParameter.getTypeParameter();
		List<JvmTypeConstraint> constraints = parameter.getConstraints();
		for(JvmTypeConstraint constraint: constraints) {
			JvmTypeReference constraintReference = constraint.getTypeReference();
			if (constraintReference != null) {
				final boolean[] recursive = new boolean[] { false };
				LightweightTypeReferenceFactory factory = new LightweightTypeReferenceFactory(hint.getOwner()) {
					@Override
					public LightweightTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
						JvmType type = reference.getType();
						if (type == parameter) {// recursively bound
							recursive[0] = true;
						}
						return super.doVisitParameterizedTypeReference(reference);
					}
				};
				LightweightTypeReference lightweightReference = factory.toLightweightReference(constraintReference);
				if (!recursive[0]) {
					if (hint.isAssignableFrom(lightweightReference)) {
						hint = lightweightReference;	
					} else if (hint.isResolved() && !lightweightReference.getRawTypeReference().isAssignableFrom(hint, TypeConformanceComputationArgument.RAW)) {
						return null;
					}
				}
			}
		}
		return hint;
	}

}