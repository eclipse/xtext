/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import java.util.List;

import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * @since 2.9
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NameConcatHelper {

	public enum NameType {
		ID, QUALIFIED, SIMPLE, TO_STRING
	}
	
	public static void appendConstraintsName(StringBuilder result, List<JvmTypeConstraint> constraints, char innerClassDelimiter, NameType nameType) {
		if (constraints == null || constraints.isEmpty())
			return;
		int wasLength = result.length();
		boolean hasLowerBound = false;
		if (nameType != NameType.ID) {
			for (JvmTypeConstraint constraint : constraints) {
				if (constraint instanceof JvmLowerBound) {
					hasLowerBound = true;
					break;
				}
			}
		}
		for (JvmTypeConstraint constraint : constraints) {
			if (result.length() != wasLength)
				result.append(" & ");
			if (!hasLowerBound || constraint instanceof JvmLowerBound || nameType == NameType.ID) {
				switch(nameType) {
					case ID: result.append(constraint.getIdentifier()); break;
					case QUALIFIED: result.append(constraint.getQualifiedName(innerClassDelimiter)); break;
					case SIMPLE: result.append(constraint.getSimpleName()); break;
					case TO_STRING: result.append(constraint.toString()); break;
				}
			}
		}
	}

	static String computeFor(JvmWildcardTypeReference typeReference, char innerClassDelimiter, NameType nameType) {
		if (typeReference.eIsSet(TypesPackage.Literals.JVM_CONSTRAINT_OWNER__CONSTRAINTS)) {
			if (typeReference.getConstraints().size() == 1) {
				JvmTypeConstraint onlyConstraint = typeReference.getConstraints().get(0);
				if (nameType != NameType.ID && nameType != NameType.TO_STRING) {
					JvmTypeReference reference = onlyConstraint.getTypeReference();
					if (reference == null || (onlyConstraint instanceof JvmUpperBound && 
							Object.class.getCanonicalName().equals(onlyConstraint.getTypeReference().getIdentifier()))) {
						return "?";
					}
				} else if (nameType == NameType.ID && onlyConstraint.getTypeReference() == null) {
					return "?";
				}
			}
			StringBuilder mutableResult = new StringBuilder(64);
			mutableResult.append("? ");
			appendConstraintsName(mutableResult, typeReference.getConstraints(), innerClassDelimiter, nameType);
			return mutableResult.toString();
		}
		return "?";
	}
	
	static String computeFor(JvmParameterizedTypeReference typeReference, char innerClassDelimiter, NameType nameType) {
		if (typeReference.eIsSet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)) {
			StringBuilder mutableResult = new StringBuilder(64);
			computeFor(typeReference, innerClassDelimiter, nameType, mutableResult);
			return mutableResult.toString();
		}
		return null;
	}

	private static void computeFor(JvmParameterizedTypeReference typeReference, char innerClassDelimiter,
			NameType nameType, StringBuilder result) {
		if (typeReference.eClass() == TypesPackage.Literals.JVM_INNER_TYPE_REFERENCE) {
			JvmParameterizedTypeReference outer = ((JvmInnerTypeReference) typeReference).getOuter();
			if (outer != null) {
				computeFor(outer, innerClassDelimiter, nameType, result);
				if (result.length() != 0) {
					JvmType type = typeReference.getType();
					result.append(innerClassDelimiter);
					result.append(type.getSimpleName());
				} else {
					appendType(typeReference, innerClassDelimiter, nameType, result);	
				}
			} else {
				appendType(typeReference, innerClassDelimiter, nameType, result);
			}
		} else {
			appendType(typeReference, innerClassDelimiter, nameType, result);
		}
		if (typeReference.eIsSet(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__ARGUMENTS)) {
			result.append("<");
			appendArguments(result, typeReference.getArguments(), innerClassDelimiter, nameType);
			result.append(">");
		}
	}

	private static void appendType(JvmParameterizedTypeReference typeReference, char innerClassDelimiter,
			NameType nameType, StringBuilder result) {
		JvmType type = typeReference.getType();
		if (type != null) {
			switch(nameType) {
				case ID: result.append(type.getIdentifier()); break;
				case QUALIFIED: result.append(type.getQualifiedName(innerClassDelimiter)); break;
				case SIMPLE: result.append(type.getSimpleName()); break;
				case TO_STRING: result.append(type.getIdentifier()); break;
			}
		}
	}

	public static void appendArguments(StringBuilder result, List<JvmTypeReference> arguments, char innerClassDelimiter, NameType nameType) {
		if (arguments == null || arguments.isEmpty())
			return;
		int wasLength = result.length();
		for (JvmTypeReference argument : arguments) {
			if (result.length() != wasLength)
				result.append(", ");
			switch(nameType) {
				case ID: result.append(argument.getIdentifier()); break;
				case QUALIFIED: result.append(argument.getQualifiedName(innerClassDelimiter)); break;
				case SIMPLE: result.append(argument.getSimpleName()); break;
				case TO_STRING: result.append(argument.toString()); break;
			}
		}
	}
	
}
