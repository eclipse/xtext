/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.List;

import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.util.TypeConformanceComputationArgument.Internal;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class WildcardConformanceStrategy extends TypeConformanceStrategy<JvmWildcardTypeReference> {
	
	public WildcardConformanceStrategy(TypeConformanceComputer conformanceComputer) {
		super(conformanceComputer);
	}

	@Override
	public TypeConformanceResult doVisitTypeReference(JvmWildcardTypeReference leftWildcard, JvmTypeReference right, TypeConformanceComputationArgument.Internal<JvmWildcardTypeReference> param) {
		if (param.asTypeArgument) {
			List<JvmTypeConstraint> constraints = leftWildcard.getConstraints();
			if (!constraints.isEmpty()) {
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmUpperBound) {
						TypeConformanceResult result = conformanceComputer.isConformant(constraint.getTypeReference(), right, new TypeConformanceComputationArgument(false, false, false));
						if (!result.isConformant()) {
							return result;
						}
					} else if (constraint instanceof JvmLowerBound) {
						TypeConformanceResult result = conformanceComputer.isConformant(right, constraint.getTypeReference(), new TypeConformanceComputationArgument(false, false, false));
						if (!result.isConformant()) {
							return result;
						}
					}
				}
				return TypeConformanceResult.SUCCESS;
			} else { // no constraints found
				return TypeConformanceResult.SUCCESS;
			}
		}
		return TypeConformanceResult.FAILED;
	}
	
	@Override
	public TypeConformanceResult doVisitMultiTypeReference(JvmWildcardTypeReference left, JvmMultiTypeReference right,
			Internal<JvmWildcardTypeReference> param) {
		return doVisitTypeReference(left, right, param);
	}

	@Override
	public TypeConformanceResult doVisitWildcardTypeReference(JvmWildcardTypeReference leftWildcard, JvmWildcardTypeReference rightWildcard, TypeConformanceComputationArgument.Internal<JvmWildcardTypeReference> param) {
		if (param.asTypeArgument) {
			List<JvmTypeConstraint> leftConstraints = leftWildcard.getConstraints();
			if (leftConstraints.isEmpty()) {
				return TypeConformanceResult.SUCCESS;
			} else {
				List<JvmTypeConstraint> rightConstraints = rightWildcard.getConstraints();
				for(JvmTypeConstraint leftConstraint: leftConstraints) {
					if (leftConstraint instanceof JvmUpperBound) {
						JvmTypeReference leftUpperBound = leftConstraint.getTypeReference();
						if (!rightConstraints.isEmpty()) {
							for(JvmTypeConstraint rightConstraint: rightConstraints) {
								if (rightConstraint instanceof JvmUpperBound) {
									TypeConformanceResult result = conformanceComputer.isConformant(leftUpperBound, rightConstraint.getTypeReference(), new TypeConformanceComputationArgument(false, false, false));
									if (!result.isConformant()) {
										return result;
									}
								} else if (rightConstraint instanceof JvmLowerBound) {
									if (!conformanceComputer.getTypeReferences().is(leftUpperBound, Object.class))
										return TypeConformanceResult.FAILED;
								}
							}
						} else {
							if (!conformanceComputer.getTypeReferences().is(leftUpperBound, Object.class))
								return TypeConformanceResult.FAILED;
						}
					} else {
						JvmTypeReference leftLowerBound = leftConstraint.getTypeReference();
						if (!rightConstraints.isEmpty()) {
							boolean lowerBoundSeen = false;
							for(JvmTypeConstraint rightConstraint: rightConstraints) {
								if (rightConstraint instanceof JvmUpperBound) {
									if (!conformanceComputer.getTypeReferences().is(rightConstraint.getTypeReference(), Object.class))
										return TypeConformanceResult.FAILED;
								} else if (rightConstraint instanceof JvmLowerBound) {
									lowerBoundSeen = true;
									TypeConformanceResult result = conformanceComputer.isConformant(rightConstraint.getTypeReference(), leftLowerBound, new TypeConformanceComputationArgument(false, false, false));
									if (!result.isConformant()) {
										return TypeConformanceResult.FAILED;
									}
								}
							}
							if (!lowerBoundSeen)
								return TypeConformanceResult.FAILED;
						} else {
							return TypeConformanceResult.FAILED;
						}
					}
				}
			}
			return TypeConformanceResult.SUCCESS;
		}
		return TypeConformanceResult.FAILED;
	}
}