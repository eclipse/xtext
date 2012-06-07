/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.typesystem.util.TraversalData;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ConstraintAwareTypeArgumentCollector extends DeclaratorTypeArgumentCollector {

	private final TypesFactory factory;

	public ConstraintAwareTypeArgumentCollector(TypesFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public Boolean doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, TraversalData data) {
		JvmType type = reference.getType();
		if (type != null && !type.eIsProxy() && data.getVisited().add(type)) {
			if (type instanceof JvmTypeParameter) {
				if (!data.getTypeParameterMapping().containsKey(type)) {
					List<JvmTypeConstraint> constraints = ((JvmTypeParameter) type).getConstraints();
					List<JvmTypeReference> upperBounds = Lists.newArrayList();
					for(JvmTypeConstraint constraint: constraints) {
						if (constraint instanceof JvmUpperBound) {
							visit(constraint.getTypeReference(), data);
							upperBounds.add(EcoreUtil2.cloneIfContained(constraint.getTypeReference()));
						}
					}
					if (upperBounds.size() > 1) {
						JvmMultiTypeReference boundReference = factory.createJvmMultiTypeReference();
						boundReference.getReferences().addAll(upperBounds);
						data.getTypeParameterMapping().put((JvmTypeParameter) type, new MergedBoundTypeArgument(boundReference, VarianceInfo.INVARIANT));
					} else if (upperBounds.size() == 1) {
						data.getTypeParameterMapping().put((JvmTypeParameter) type, new MergedBoundTypeArgument(upperBounds.get(0), VarianceInfo.INVARIANT));
					} else {
						return Boolean.FALSE;
					}
				}
			} else {
				return doVisitParameterizedTypeReference(reference, type, data);
			}
		}
		return Boolean.FALSE;
	}
	
}
