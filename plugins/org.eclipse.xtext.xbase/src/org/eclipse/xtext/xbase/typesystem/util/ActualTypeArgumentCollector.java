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
import java.util.Set;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
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

	private final ListMultimap<JvmTypeParameter, BoundTypeArgument> typeParameterMapping;
	private final List<JvmTypeParameter> parametersToBeMapped;
	private final BoundTypeArgumentSource defaultSource;

	public ActualTypeArgumentCollector(List<JvmTypeParameter> parametersToBeMapped, BoundTypeArgumentSource defaultSource, CommonTypeComputationServices services) {
		super(services);
		this.parametersToBeMapped = parametersToBeMapped;
		this.defaultSource = defaultSource;
		typeParameterMapping = Multimaps2.newLinkedHashListMultimap(parametersToBeMapped.size(), 3);
	}

	public void populateTypeParameterMapping(JvmTypeReference declaredType, JvmTypeReference actualType) {
		processPairedReferences(declaredType, actualType);
	}
	
	protected BoundTypeArgument boundByConstraint(JvmTypeReference reference, Object origin) {
		return new BoundTypeArgument(reference, BoundTypeArgumentSource.CONSTRAINT, origin, VarianceInfo.OUT, VarianceInfo.OUT);
	}
	
	protected BoundTypeArgument boundByDefaultSource(JvmTypeReference reference) {
		return new BoundTypeArgument(reference, defaultSource, getOrigin(), getExpectedVariance(), getActualVariance());
	}
	
	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new ActualParameterizedTypeReferenceTraverser();
	}
	
	@Override
	protected ParameterizedTypeReferenceTraverser createParameterizedTypeReferenceTraverser() {
		return new ActualParameterizedTypeReferenceTraverser();
	}
	
	@Override
	protected void processTypeParameter(JvmTypeParameter typeParameter, JvmTypeReference reference) {
		typeParameterMapping.put(typeParameter, boundByDefaultSource(reference));
	}
	
	public ListMultimap<JvmTypeParameter, BoundTypeArgument> rawGetTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	protected List<JvmTypeParameter> getParametersToProcess() {
		return parametersToBeMapped;
	}
	
	@Override
	protected boolean shouldProcess(JvmTypeParameter type) {
		return parametersToBeMapped.contains(type);
	}
	
	@Override
	public void processPairedReferences(JvmTypeReference declaredType, JvmTypeReference actualType) {
		if (parametersToBeMapped.isEmpty())
			return;
		super.processPairedReferences(declaredType, actualType);
	}
	
	public ListMultimap<JvmTypeParameter, BoundTypeArgument> getTypeParameterMapping() {
		if (typeParameterMapping.keySet().containsAll(getParametersToProcess())) {
			return typeParameterMapping;
		}
		ListMultimap<JvmTypeParameter, BoundTypeArgument> result = Multimaps2.newLinkedHashListMultimap(typeParameterMapping);
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
								Map<JvmTypeParameter, MergedBoundTypeArgument> constraintParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(constraintReference);
								JvmTypeReference resolvedConstraint = new TypeParameterByConstraintSubstitutor(constraintParameterMapping, getServices()).visit(constraintReference, Sets.newHashSet(pendingParameter));
								result.put(pendingParameter, boundByConstraint(resolvedConstraint, pendingParameter));
							} else {
								result.put(pendingParameter, boundByConstraint(getServices().getTypeReferences().getTypeForName(Object.class, pendingParameter), pendingParameter));
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