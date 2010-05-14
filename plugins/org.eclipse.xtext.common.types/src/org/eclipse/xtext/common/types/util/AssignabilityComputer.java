/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmReferenceTypeArgument;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeArgument;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeArgument;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class AssignabilityComputer implements IAssignabilityComputer{

	private SuperTypeCollector superTypeCollector;

	@Inject
	public AssignabilityComputer(SuperTypeCollector superTypeCollector) {
		super();
		this.superTypeCollector = superTypeCollector;
	}

	public boolean isAssignableFrom(JvmTypeReference left, JvmTypeReference right) {
		JvmType typeA = left.getType();
		JvmType typeB = right.getType();
		if (typeA instanceof JvmArrayType) {
			if (typeB instanceof JvmArrayType) {
				JvmTypeReference componentTypeA = ((JvmArrayType) typeA).getComponentType();
				JvmTypeReference componentTypeB = ((JvmArrayType) typeB).getComponentType();
				return isAssignableFrom(componentTypeA, componentTypeB);
			}
			return false;
		} else if (right instanceof JvmParameterizedTypeReference) {
			JvmParameterizedTypeReference refA = (JvmParameterizedTypeReference) left;
			JvmParameterizedTypeReference refB = (JvmParameterizedTypeReference) right;
			if (typeA == typeB) {
				return areArgumentsAssignableFrom(refA, refB);
			}
			if (typeA instanceof JvmPrimitiveType) {
				return isUnBoxing(typeA, typeB);
			} else if (typeA instanceof JvmDeclaredType) {
				if (superTypeCollector.collectSuperTypes(typeB).contains(typeA)) {
					return areArgumentsAssignableFrom(refA, refB);
				}
				return isBoxing(typeA, typeB);
			}
		}
		return false;
	}

	protected boolean areArgumentsAssignableFrom(JvmParameterizedTypeReference left, JvmParameterizedTypeReference right) {
		// raw type
		if (left.getArguments().size() == 0 || right.getArguments().size() == 0) {
			return true;
		}
		if (left.getArguments().size() != right.getArguments().size()) {
			return false;
		}

		if (left.getArguments().size() == right.getArguments().size()) {
			for (int i = 0; i < left.getArguments().size(); i++) {
				JvmTypeArgument argumentA = left.getArguments().get(i);
				JvmTypeArgument argumentB = right.getArguments().get(i);
				if (!isAssignable(argumentA, argumentB))
					return false;
			}
			return true;
		}
		return false;
	}

	protected boolean isAssignable(JvmTypeArgument argumentA, JvmTypeArgument argumentB) {
		JvmTypeReference upperA = getUpper(argumentA);
		JvmTypeReference upperB = getUpper(argumentB);
		JvmTypeReference lowerA = getLower(argumentA);
		JvmTypeReference lowerB = getLower(argumentB);
		JvmTypeReference refA = getRef(argumentA);
		JvmTypeReference refB = getRef(argumentB);
		if (isUnconstraintWildcard(argumentA)) {
			return true;
		}
		if (upperA != null) {
			if (upperB != null) {
				return isAssignableFrom(upperA, upperB);
			} else if (refB != null) {
				return isAssignableFrom(upperA, refB);
			}
		} else if (refA != null) {
			if (refB != null) {
				return isAssignableFrom(refA, refB);
			}
		} else if (lowerA != null) {
			if (lowerB != null && isAssignableFrom(lowerB, lowerA)) {
				return true;
			}
		}
		return false;
	}

	protected boolean isUnconstraintWildcard(JvmTypeArgument argumentA) {
		return argumentA instanceof JvmWildcardTypeArgument
				&& ((JvmWildcardTypeArgument) argumentA).getConstraints().isEmpty();
	}

	protected JvmTypeReference getRef(JvmTypeArgument argumentA) {
		if (argumentA instanceof JvmReferenceTypeArgument) {
			return ((JvmReferenceTypeArgument) argumentA).getTypeReference();
		}
		return null;
	}

	protected JvmTypeReference getLower(JvmTypeArgument argumentA) {
		if (argumentA instanceof JvmWildcardTypeArgument) {
			EList<JvmTypeConstraint> list = ((JvmWildcardTypeArgument) argumentA).getConstraints();
			for (JvmTypeConstraint constraint : list) {
				if (constraint instanceof JvmLowerBound) {
					return constraint.getTypeReference();
				}
			}
		}
		return null;
	}

	protected JvmTypeReference getUpper(JvmTypeArgument argumentA) {
		if (argumentA instanceof JvmWildcardTypeArgument) {
			EList<JvmTypeConstraint> list = ((JvmWildcardTypeArgument) argumentA).getConstraints();
			for (JvmTypeConstraint constraint : list) {
				if (constraint instanceof JvmUpperBound) {
					return constraint.getTypeReference();
				}
			}
		}
		return null;
	}

	protected boolean isBoxing(JvmType typeA, JvmType typeB) {
		return is(typeA, Integer.class) && is(typeB, Integer.TYPE) || is(typeA, Boolean.class)
				&& is(typeB, Boolean.TYPE) || is(typeA, Long.class) && is(typeB, Long.TYPE) || is(typeA, Float.class)
				&& is(typeB, Float.TYPE) || is(typeA, Double.class) && is(typeB, Double.TYPE) || is(typeA, Byte.class)
				&& is(typeB, Byte.TYPE);
	}

	protected boolean isUnBoxing(JvmType typeA, JvmType typeB) {
		return is(typeB, Integer.class) && is(typeA, Integer.TYPE) || is(typeB, Boolean.class)
				&& is(typeA, Boolean.TYPE) || is(typeB, Long.class) && is(typeA, Long.TYPE) || is(typeB, Float.class)
				&& is(typeA, Float.TYPE) || is(typeB, Double.class) && is(typeA, Double.TYPE) || is(typeB, Byte.class)
				&& is(typeA, Byte.TYPE);
	}

	protected boolean is(JvmType typeA, Class<?> class1) {
		return typeA.getCanonicalName().equals(class1.getCanonicalName());
	}

}
