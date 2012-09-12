/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;

import com.google.common.collect.ListMultimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ActualTypeArgumentCollector extends AbstractTypeReferencePairWalker {

	protected class ActualParameterizedTypeReferenceTraverser extends ParameterizedTypeReferenceTraverser {
		@Override
		protected boolean shouldProcessInContextOf(JvmTypeParameter declaredTypeParameter, Set<JvmTypeParameter> boundParameters, Set<JvmTypeParameter> visited) {
			if (!shouldProcess(declaredTypeParameter)) {
				if (boundParameters.contains(declaredTypeParameter) && !visited.add(declaredTypeParameter))
					return false;
			}
			return true;
		}
	}

	private final ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> typeParameterMapping;
	private final Collection<JvmTypeParameter> parametersToBeMapped;
	private final BoundTypeArgumentSource defaultSource;

	public ActualTypeArgumentCollector(Collection<JvmTypeParameter> parametersToBeMapped, BoundTypeArgumentSource defaultSource, ITypeReferenceOwner owner) {
		super(owner);
		this.parametersToBeMapped = parametersToBeMapped;
		this.defaultSource = defaultSource;
		typeParameterMapping = Multimaps2.newLinkedHashListMultimap(parametersToBeMapped.size(), 3);
	}

	public void populateTypeParameterMapping(LightweightTypeReference declaredType, LightweightTypeReference actualType) {
		processPairedReferences(declaredType, actualType);
	}
	
	protected LightweightBoundTypeArgument boundByConstraint(LightweightTypeReference reference, Object origin) {
		return new LightweightBoundTypeArgument(reference.getWrapperTypeIfPrimitive(), BoundTypeArgumentSource.CONSTRAINT, origin, VarianceInfo.OUT, VarianceInfo.OUT);
	}
	
	protected LightweightBoundTypeArgument boundByDefaultSource(LightweightTypeReference reference) {
		return new LightweightBoundTypeArgument(reference.getWrapperTypeIfPrimitive(), defaultSource, getOrigin(), getExpectedVariance(), getActualVariance());
	}
	
	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new ActualParameterizedTypeReferenceTraverser();
	}
	
	@Override
	protected void processTypeParameter(JvmTypeParameter typeParameter, LightweightTypeReference reference) {
		typeParameterMapping.put(typeParameter, boundByDefaultSource(reference));
	}
	
	public ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> rawGetTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	protected Collection<JvmTypeParameter> getParametersToProcess() {
		return parametersToBeMapped;
	}
	
	@Override
	protected boolean shouldProcess(JvmTypeParameter type) {
		return parametersToBeMapped.contains(type);
	}
	
	@Override
	public void processPairedReferences(LightweightTypeReference declaredType, LightweightTypeReference actualType) {
		if (parametersToBeMapped.isEmpty())
			return;
		super.processPairedReferences(declaredType, actualType);
	}
	
	public ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> getTypeParameterMapping() {
		if (typeParameterMapping.keySet().containsAll(getParametersToProcess())) {
			return typeParameterMapping;
		}
		ListMultimap<JvmTypeParameter, LightweightBoundTypeArgument> result = Multimaps2.newLinkedHashListMultimap(typeParameterMapping);
		OwnedConverter converter = new OwnedConverter(getOwner());
		for(JvmTypeParameter pendingParameter: getParametersToProcess()) {
			if (!result.containsKey(pendingParameter)) {
				for(JvmTypeConstraint constraint: pendingParameter.getConstraints()) {
					if (!(constraint instanceof JvmUpperBound)) {
						throw new IllegalStateException("Type parameters may not be declared with a lower bound");
					}
					JvmTypeReference constraintReference = constraint.getTypeReference();
					if (constraintReference != null) {
						JvmType constraintType = constraintReference.getType();
						if (!result.containsKey(constraintType)) {
							if (!getParametersToProcess().contains(constraintType)) {
								LightweightTypeReference lightweightReference = converter.toLightweightReference(constraintReference);
								Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> constraintParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(lightweightReference);
								LightweightTypeReference resolvedConstraint = lightweightReference.accept(
										new TypeParameterByConstraintSubstitutor(constraintParameterMapping, getOwner()), 
										new ConstraintVisitingInfo(pendingParameter));
								result.put(pendingParameter, boundByConstraint(resolvedConstraint, pendingParameter));
							} else {
								ParameterizedTypeReference lightweightReference = new ParameterizedTypeReference(getOwner(), getOwner().getServices().getTypeReferences().findDeclaredType(Object.class, constraintType));
								result.put(pendingParameter, boundByConstraint(lightweightReference, pendingParameter));
							}
						} else {
							result.putAll(pendingParameter, result.get((JvmTypeParameter) constraintType));
						}
					}
				}
			}
		}
		return result;
	}
}