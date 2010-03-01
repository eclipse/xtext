/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.ArrayType;
import org.eclipse.xtext.common.types.DeclaredType;
import org.eclipse.xtext.common.types.LowerBound;
import org.eclipse.xtext.common.types.ParameterizedTypeReference;
import org.eclipse.xtext.common.types.PrimitiveType;
import org.eclipse.xtext.common.types.ReferenceTypeArgument;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypeArgument;
import org.eclipse.xtext.common.types.TypeConstraint;
import org.eclipse.xtext.common.types.TypeReference;
import org.eclipse.xtext.common.types.UpperBound;
import org.eclipse.xtext.common.types.WildcardTypeArgument;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * 
 * 
 */
public class AssignabilityComputer implements IAssignabilityComputer{

	private SuperTypeCollector superTypeCollector;

	@Inject
	public AssignabilityComputer(SuperTypeCollector superTypeCollector) {
		super();
		this.superTypeCollector = superTypeCollector;
	}

	public boolean isAssignableFrom(TypeReference left, TypeReference right) {
		Type typeA = left.getType();
		Type typeB = right.getType();
		if (typeA instanceof ArrayType) {
			if (typeB instanceof ArrayType) {
				TypeReference componentTypeA = ((ArrayType) typeA).getComponentType();
				TypeReference componentTypeB = ((ArrayType) typeB).getComponentType();
				return isAssignableFrom(componentTypeA, componentTypeB);
			}
			return false;
		} else if (right instanceof ParameterizedTypeReference) {
			ParameterizedTypeReference refA = (ParameterizedTypeReference) left;
			ParameterizedTypeReference refB = (ParameterizedTypeReference) right;
			if (typeA == typeB) {
				return areArgumentsAssignableFrom(refA, refB);
			}
			if (typeA instanceof PrimitiveType) {
				return isUnBoxing(typeA, typeB);
			} else if (typeA instanceof DeclaredType) {
				if (superTypeCollector.collectSuperTypes(typeB).contains(typeA)) {
					return areArgumentsAssignableFrom(refA, refB);
				}
				return isBoxing(typeA, typeB);
			}
		}
		return false;
	}

	protected boolean areArgumentsAssignableFrom(ParameterizedTypeReference left, ParameterizedTypeReference right) {
		// raw type
		if (left.getArguments().size() == 0) {
			return true;
		}
		if (left.getArguments().size() != right.getArguments().size()) {
			return false;
		}

		if (left.getArguments().size() == right.getArguments().size()) {
			for (int i = 0; i < left.getArguments().size(); i++) {
				TypeArgument argumentA = left.getArguments().get(i);
				TypeArgument argumentB = right.getArguments().get(i);
				if (!isAssignable(argumentA, argumentB))
					return false;
			}
			return true;
		}
		return false;
	}

	protected boolean isAssignable(TypeArgument argumentA, TypeArgument argumentB) {
		TypeReference upperA = getUpper(argumentA);
		TypeReference upperB = getUpper(argumentB);
		TypeReference lowerA = getLower(argumentA);
		TypeReference lowerB = getLower(argumentB);
		TypeReference refA = getRef(argumentA);
		TypeReference refB = getRef(argumentB);
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

	protected boolean isUnconstraintWildcard(TypeArgument argumentA) {
		return argumentA instanceof WildcardTypeArgument
				&& ((WildcardTypeArgument) argumentA).getConstraints().isEmpty();
	}

	protected TypeReference getRef(TypeArgument argumentA) {
		if (argumentA instanceof ReferenceTypeArgument) {
			return ((ReferenceTypeArgument) argumentA).getTypeReference();
		}
		return null;
	}

	protected TypeReference getLower(TypeArgument argumentA) {
		if (argumentA instanceof WildcardTypeArgument) {
			EList<TypeConstraint> list = ((WildcardTypeArgument) argumentA).getConstraints();
			for (TypeConstraint constraint : list) {
				if (constraint instanceof LowerBound) {
					return constraint.getTypeReference();
				}
			}
		}
		return null;
	}

	protected TypeReference getUpper(TypeArgument argumentA) {
		if (argumentA instanceof WildcardTypeArgument) {
			EList<TypeConstraint> list = ((WildcardTypeArgument) argumentA).getConstraints();
			for (TypeConstraint constraint : list) {
				if (constraint instanceof UpperBound) {
					return constraint.getTypeReference();
				}
			}
		}
		return null;
	}

	protected boolean isBoxing(Type typeA, Type typeB) {
		return is(typeA, Integer.class) && is(typeB, Integer.TYPE) || is(typeA, Boolean.class)
				&& is(typeB, Boolean.TYPE) || is(typeA, Long.class) && is(typeB, Long.TYPE) || is(typeA, Float.class)
				&& is(typeB, Float.TYPE) || is(typeA, Double.class) && is(typeB, Double.TYPE) || is(typeA, Byte.class)
				&& is(typeB, Byte.TYPE);
	}

	protected boolean isUnBoxing(Type typeA, Type typeB) {
		return is(typeB, Integer.class) && is(typeA, Integer.TYPE) || is(typeB, Boolean.class)
				&& is(typeA, Boolean.TYPE) || is(typeB, Long.class) && is(typeA, Long.TYPE) || is(typeB, Float.class)
				&& is(typeA, Float.TYPE) || is(typeB, Double.class) && is(typeA, Double.TYPE) || is(typeB, Byte.class)
				&& is(typeA, Byte.TYPE);
	}

	protected boolean is(Type typeA, Class<?> class1) {
		return typeA.getCanonicalName().equals(class1.getCanonicalName());
	}

}
