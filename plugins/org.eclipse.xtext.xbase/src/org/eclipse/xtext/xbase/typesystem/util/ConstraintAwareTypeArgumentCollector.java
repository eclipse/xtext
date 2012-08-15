/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTraversalData;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ConstraintAwareTypeArgumentCollector extends DeclaratorTypeArgumentCollector {

	private ITypeReferenceOwner owner;

	public ConstraintAwareTypeArgumentCollector(ITypeReferenceOwner owner) {
		this.owner = owner;
	}
	
	@Override
	public Boolean doVisitParameterizedTypeReference(ParameterizedTypeReference reference, LightweightTraversalData data) {
		JvmType type = reference.getType();
		if (!type.eIsProxy() && data.getVisited().add(type)) {
			if (type instanceof JvmTypeParameter) {
				if (!data.getTypeParameterMapping().containsKey(type)) {
					List<JvmTypeConstraint> constraints = ((JvmTypeParameter) type).getConstraints();
					List<LightweightTypeReference> upperBounds = Lists.newArrayList();
					OwnedConverter converter = new OwnedConverter(owner);
					for(JvmTypeConstraint constraint: constraints) {
						if (constraint instanceof JvmUpperBound && constraint.getTypeReference() != null) {
							upperBounds.add(converter.toLightweightReference(constraint.getTypeReference()));
						}
					}
					if (upperBounds.size() > 1) {
						CompoundTypeReference result = new CompoundTypeReference(owner, false);
						for(LightweightTypeReference upperBound: upperBounds) {
							result.addComponent(upperBound);
						}
						data.getTypeParameterMapping().put((JvmTypeParameter) type, new LightweightMergedBoundTypeArgument(result, VarianceInfo.INVARIANT));
					} else if (upperBounds.size() == 1) {
						data.getTypeParameterMapping().put((JvmTypeParameter) type, new LightweightMergedBoundTypeArgument(upperBounds.get(0), VarianceInfo.INVARIANT));
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
