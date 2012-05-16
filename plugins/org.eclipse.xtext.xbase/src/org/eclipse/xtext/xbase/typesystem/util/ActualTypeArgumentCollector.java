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

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
public class ActualTypeArgumentCollector extends AbstractTypeReferencePairWalker {

	private final ListMultimap<JvmTypeParameter, BoundTypeArgument> typeParameterMapping;

	public ActualTypeArgumentCollector(List<JvmTypeParameter> parametersToBeMapped, CommonTypeComputationServices services) {
		super(parametersToBeMapped, services);
		typeParameterMapping = ArrayListMultimap.create(parametersToBeMapped.size(), 3);
	}

	public void populateTypeParameterMapping(JvmTypeReference declaredType, JvmTypeReference actualType) {
		processPairedReferences(declaredType, actualType);
	}
	
	protected BoundTypeArgument createBoundTypeArgument(JvmTypeReference reference, BoundTypeArgumentSource source, Object origin, VarianceInfo declaredVariance, VarianceInfo actualVariance) {
		return new BoundTypeArgument(reference, source, origin, declaredVariance, actualVariance);
	}
	
	protected BoundTypeArgument boundByConstraint(JvmTypeReference reference, Object origin) {
		return new BoundTypeArgument(reference, BoundTypeArgumentSource.CONSTRAINT, origin, VarianceInfo.OUT, VarianceInfo.OUT);
	}
	
	protected BoundTypeArgument boundByInferrence(JvmTypeReference reference) {
		return new BoundTypeArgument(reference, BoundTypeArgumentSource.INFERRED, getOrigin(), getExpectedVariance(), getActualVariance());
	}
	
	@Override
	protected void processTypeParameter(JvmTypeParameter typeParameter, JvmTypeReference reference) {
		typeParameterMapping.put(typeParameter, boundByInferrence(reference));
	}
	
	public ListMultimap<JvmTypeParameter, BoundTypeArgument> rawGetTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	public ListMultimap<JvmTypeParameter, BoundTypeArgument> getTypeParameterMapping() {
		if (typeParameterMapping.keySet().containsAll(getParametersToProcess())) {
			return typeParameterMapping;
		}
		ListMultimap<JvmTypeParameter, BoundTypeArgument> result = ArrayListMultimap.create(typeParameterMapping);
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
								Map<JvmTypeParameter, JvmTypeReference> constraintParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(constraintReference);
								JvmTypeReference resolvedConstraint = new UnboundTypeParameterSubstitutor(constraintParameterMapping, getServices()).visit(constraintReference, Sets.newHashSet(pendingParameter));
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