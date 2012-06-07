/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeParameterByConstraintSubstitutor extends TypeParameterSubstitutor {

	public TypeParameterByConstraintSubstitutor(Map<JvmTypeParameter, MergedBoundTypeArgument> typeParameterMapping,
			CommonTypeComputationServices services) {
		super(typeParameterMapping, services);
	}
	
	@Override
	public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Set<JvmTypeParameter> visiting) {
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			if (!visiting.add((JvmTypeParameter) type)) {
				return null;
			}
			try {
				MergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(type);
				if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
					JvmTypeReference result = visit(boundTypeArgument.getTypeReference(), visiting);
					if (boundTypeArgument.getVariance() == VarianceInfo.OUT) {
						JvmWildcardTypeReference wildcardTypeReference = getServices().getTypesFactory().createJvmWildcardTypeReference();
						JvmUpperBound upperBound = getServices().getTypesFactory().createJvmUpperBound();
						upperBound.setTypeReference(result);
						wildcardTypeReference.getConstraints().add(upperBound);
						result = wildcardTypeReference;
					} else if (boundTypeArgument.getVariance() == VarianceInfo.IN) {
						JvmWildcardTypeReference wildcardTypeReference = getServices().getTypesFactory().createJvmWildcardTypeReference();
						JvmUpperBound upperBound = getServices().getTypesFactory().createJvmUpperBound();
						upperBound.setTypeReference(getServices().getTypeReferences().getTypeForName(Object.class, type));
						wildcardTypeReference.getConstraints().add(upperBound);
						JvmLowerBound lowerBound = getServices().getTypesFactory().createJvmLowerBound();
						lowerBound.setTypeReference(result);
						wildcardTypeReference.getConstraints().add(lowerBound);
						result = wildcardTypeReference;
					}
					return result;
				} else {
					JvmTypeReference mappedReference = getUnmappedSubstitute(reference, (JvmTypeParameter) type, visiting);
					if (mappedReference != null) {
						getTypeParameterMapping().put((JvmTypeParameter)type, new MergedBoundTypeArgument(mappedReference, VarianceInfo.INVARIANT));
						return mappedReference;
					}
				}
			} finally {
				visiting.remove(type);
			}
		}
		JvmParameterizedTypeReference result = getServices().getTypesFactory().createJvmParameterizedTypeReference();
		result.setType(type);
		for(int i = 0; i < reference.getArguments().size(); i++) {
			JvmTypeReference argument = reference.getArguments().get(i);
			JvmTypeReference copiedArgument = visit(argument, visiting);
			if (copiedArgument == null) {
				copiedArgument = getDeclaredUpperBound(type, i, visiting);
			}
			result.getArguments().add(copiedArgument);
		}
		return result;
	}

	protected JvmTypeReference getUnmappedSubstitute(JvmParameterizedTypeReference reference, JvmTypeParameter type, Set<JvmTypeParameter> visiting) {
		ConstraintAwareTypeArgumentCollector collector = new ConstraintAwareTypeArgumentCollector(getServices().getTypesFactory());
		TraversalData data = new TraversalData();
		data.getTypeParameterMapping().putAll(getTypeParameterMapping());
		collector.visit(reference, data);
		MergedBoundTypeArgument boundTypeArgument = data.getTypeParameterMapping().get(type);
		if (boundTypeArgument != null && boundTypeArgument.getTypeReference() != reference) {
			return visit(boundTypeArgument.getTypeReference(), visiting);
		}
		if (boundTypeArgument != null)
			return boundTypeArgument.getTypeReference();
		return null;
	}
	
	protected JvmTypeReference getDeclaredUpperBound(JvmType type, int parameterIndex, Set<JvmTypeParameter> visiting) {
		JvmTypeReference result = null;
		if (type instanceof JvmTypeParameterDeclarator) {
			JvmTypeParameterDeclarator typeParameterDeclarator = (JvmTypeParameterDeclarator) type;
			if (typeParameterDeclarator.getTypeParameters().size() > parameterIndex) {
				JvmTypeParameter typeParameter = typeParameterDeclarator.getTypeParameters().get(parameterIndex);
				if (!typeParameter.getConstraints().isEmpty()) {
					JvmTypeConstraint constraint = typeParameter.getConstraints().get(0);
					if (constraint instanceof JvmUpperBound) {
						result = visit(constraint.getTypeReference(), visiting);
					}
				}
			}
		}
		if (result == null) {
			result = getServices().getTypeReferences().getTypeForName(Object.class, type);
		}
		return result;
	}
	
	@Override
	public JvmTypeReference doVisitWildcardTypeReference(JvmWildcardTypeReference reference,
			Set<JvmTypeParameter> visiting) {
		JvmWildcardTypeReference result = getServices().getTypesFactory().createJvmWildcardTypeReference();
		for(JvmTypeConstraint constraint: reference.getConstraints()) {
			JvmTypeReference copiedConstraintReference = visit(constraint.getTypeReference(), visiting);
			if (copiedConstraintReference == null)
				return null;
			JvmTypeConstraint copiedConstraint = (JvmTypeConstraint) EcoreUtil.create(constraint.eClass());
			copiedConstraint.setTypeReference(copiedConstraintReference);
			result.getConstraints().add(copiedConstraint);
		}
		return result;
	}

	@Override
	public JvmTypeReference substitute(JvmTypeReference original) {
		JvmTypeReference result = visit(original, Sets.<JvmTypeParameter>newHashSet());
		return result;
	}
}
