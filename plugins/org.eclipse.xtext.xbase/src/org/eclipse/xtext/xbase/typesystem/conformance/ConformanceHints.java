/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.lang.reflect.Field;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConformanceHints {

	public final static int NONE = 0;
	
	/**
	 * Indicates that the types have been checked as if they were raw types.
	 */
	public final static int RAW_TYPE = RawTypeConformanceComputer.RAW_TYPE;

	/**
	 * This bit indicates a successful check for conformance.
	 */
	public final static int SUCCESS = RawTypeConformanceComputer.SUCCESS;

	/**
	 * If the result has this bit set, a demand conversion had to be applied to make both types conformant. This is
	 * especially interesting for function types. Also a {@link #SYNONYM} may require a demand conversion.
	 */
	public final static int DEMAND_CONVERSION = RawTypeConformanceComputer.DEMAND_CONVERSION;

	/**
	 * Indicates that both types are in a subtype relationship.
	 */
	public final static int SUBTYPE = RawTypeConformanceComputer.SUBTYPE;

	/**
	 * This is set if primitive widening had to be applied.
	 */
	public final static int PRIMITIVE_WIDENING = RawTypeConformanceComputer.PRIMITIVE_WIDENING;

	/**
	 * If unboxing conversion was necessary, this bit is set.
	 */
	public final static int UNBOXING = RawTypeConformanceComputer.UNBOXING;

	/**
	 * If boxing conversion was necessary, this bit is set.
	 */
	public final static int BOXING = RawTypeConformanceComputer.BOXING;

	/**
	 * This is set if the conformance was possible due to raw type conversion.
	 */
	public final static int RAW_TYPE_CONVERSION = RawTypeConformanceComputer.RAW_TYPE_CONVERSION;

	/**
	 * If a synonym conversion was necessary, this bit is set in the result value.
	 */
	public final static int SYNONYM = RawTypeConformanceComputer.SYNONYM;

	/**
	 * Two types are considered conformant if one of the participants is the unknown type. This flag indicates this situation.
	 */
	public final static int UNKNOWN_TYPE_PARTICIPATED = RawTypeConformanceComputer.UNKNOWN_TYPE_PARTICIPATED;

	public final static int INCOMPATIBLE = RawTypeConformanceComputer.INCOMPATIBLE;

	public final static int VAR_ARG = INCOMPATIBLE << 1;

	public final static int CHECKED = VAR_ARG << 1;
	public final static int SEALED = CHECKED << 1;
	public final static int UNCHECKED = SEALED << 1;
	public final static int LAMBDA_RAW_COMPATIBLE = UNCHECKED << 1;
	public final static int LAMBDA_PARAMETER_COMPATIBLE = LAMBDA_RAW_COMPATIBLE << 1;
	public final static int MERGED = LAMBDA_PARAMETER_COMPATIBLE << 1;
	public final static int EXPECTATION_INDEPENDENT = MERGED << 1;

	/**
	 * Indicates that the announced type is not an implicit return type.
	 * 
	 * E.g. the type of a return expression is 'void' but this is not the implicit return type of the 
	 * return expression itself. The return type was computed properly from the children of the return expression.
	 */
	public final static int NO_IMPLICIT_RETURN = EXPECTATION_INDEPENDENT << 1;
	
	/**
	 * Used to indicate an explicit void return value
	 */
	public final static int EXPLICIT_VOID_RETURN = NO_IMPLICIT_RETURN << 1;
	
	/**
	 * Indicates that the type of this expression is derived from a child which can provide better conformance information.
	 */
	public final static int PROPAGATED_TYPE = EXPLICIT_VOID_RETURN << 1;
	
	/**
	 * Indicates that the expression will definitely throw an exception.
	 */
	public final static int THROWN_EXCEPTION = PROPAGATED_TYPE << 1;
	
	/**
	 * A method is overloaded with various function interfaces. The variant with a single-arg lambda is the prefered sugar version.
	 */
	public final static int PREFERRED_LAMBDA_SUGAR = THROWN_EXCEPTION << 1;
	
	// Additional flags have to start from RAW_TYPE << 1 again since SUCCESS is used from RawTypeConformanceComputer#SUCCESS which does not start at 1
	
	// Composed flags below
	
	public final static int CHECKED_SUCCESS = CHECKED | SUCCESS;
	
	public static int compareHints(int left, int right) {
		if (left == right) {
			return 0;
		}
		if ((left & SUCCESS) != (right & SUCCESS)) {
			if ((left & SUCCESS) != 0)
				return -1;
			return 1;
		}
		if ((left & LAMBDA_RAW_COMPATIBLE) != (right & LAMBDA_RAW_COMPATIBLE)) {
			if ((left & LAMBDA_RAW_COMPATIBLE) != 0)
				return -1;
			return 1;
		}
		if ((left & LAMBDA_PARAMETER_COMPATIBLE) != (right & LAMBDA_PARAMETER_COMPATIBLE)) {
			if ((left & LAMBDA_PARAMETER_COMPATIBLE) != 0)
				return -1;
			return 1;
		}
//		if (left.contains(EXCEPTION) != right.contains(EXCEPTION)) {
//			if (left.contains(EXCEPTION))
//				return 1;
//			return -1;
//		}
		if ((left & SYNONYM) != (right & SYNONYM)) {
			if ((left & SYNONYM) != 0)
				return 1;
			return -1;
		}
		return 0;
	}
	
	public static String toString(int hint) {
		Field[] fields = ConformanceHints.class.getFields();
		try {
			StringBuilder result = new StringBuilder("[");
			for(Field f: fields) {
				int fieldValue = f.getInt(null);
				if (Integer.bitCount(fieldValue) == 1) {
					if ((fieldValue & hint) != 0) {
						if (result.length() != 1) {
							result.append(", ");
						}
						result.append(f.getName());
					}
				}
			}
			result.append("]");
			return result.toString();
		} catch(Exception e) {
			return Integer.toString(hint);
		}
	}
	
	public static void checkAllHints(int hints) {
		checkHints(hints, ConformanceHints.CHECKED | ConformanceHints.UNCHECKED);
		if ((hints & ConformanceHints.UNCHECKED) == 0) {
			checkHints(hints, ConformanceHints.SUCCESS | ConformanceHints.LAMBDA_PARAMETER_COMPATIBLE | ConformanceHints.LAMBDA_RAW_COMPATIBLE | ConformanceHints.INCOMPATIBLE);
		}
	}

	public static void checkHints(int hints, int bits) {
		if ((hints & bits) == 0)
			throw new IllegalArgumentException("Invalid hints: " + toString(hints));
		if (Integer.bitCount(hints & bits) != 1)
			throw new IllegalArgumentException("Invalid hints: " + toString(hints));
	}

//	public static int compareHints(EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance) {
//	if (leftConformance.equals(rightConformance)) {
//		return 0;
//	}
//	if (leftConformance.contains(ConformanceHint.SUCCESS) != rightConformance.contains(ConformanceHint.SUCCESS)) {
//		if (leftConformance.contains(ConformanceHint.SUCCESS))
//			return -1;
//		return 1;
//	}
//	if (leftConformance.contains(ConformanceHint.LAMBDA_RAW_COMPATIBLE) != rightConformance.contains(ConformanceHint.LAMBDA_RAW_COMPATIBLE)) {
//		if (leftConformance.contains(ConformanceHint.LAMBDA_RAW_COMPATIBLE))
//			return -1;
//		return 1;
//	}
//	if (leftConformance.contains(ConformanceHint.LAMBDA_PARAMETER_COMPATIBLE) != rightConformance.contains(ConformanceHint.LAMBDA_PARAMETER_COMPATIBLE)) {
//		if (leftConformance.contains(ConformanceHint.LAMBDA_PARAMETER_COMPATIBLE))
//			return -1;
//		return 1;
//	}
//	if (leftConformance.contains(ConformanceHint.EXCEPTION) != rightConformance.contains(ConformanceHint.EXCEPTION)) {
//		if (leftConformance.contains(ConformanceHint.EXCEPTION))
//			return 1;
//		return -1;
//	}
//	if (leftConformance.contains(ConformanceHint.SYNONYM) != rightConformance.contains(ConformanceHint.SYNONYM)) {
//		if (leftConformance.contains(ConformanceHint.SYNONYM))
//			return 1;
//		return -1;
//	}
//	return 0;
//}
}
