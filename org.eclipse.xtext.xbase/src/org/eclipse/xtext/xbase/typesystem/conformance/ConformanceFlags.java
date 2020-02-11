/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.lang.reflect.Field;

/**
 * The bits that are used to indicate conformance levels during type computation.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class ConformanceFlags {
	
	private ConformanceFlags() {
		throw new AssertionError();
	}

	/**
	 * No flags given.
	 */
	public static final int NONE = 0;

	/**
	 * Indicates that the types have been checked as if they were raw types.
	 */
	public static final int RAW_TYPE = RawTypeConformanceComputer.RAW_TYPE;

	/**
	 * This bit indicates a successful check for conformance.
	 */
	public static final int SUCCESS = RawTypeConformanceComputer.SUCCESS;

	/**
	 * If the result has this bit set, a demand conversion had to be applied to make both types compatible. This is
	 * especially interesting for function types. Also a {@link #SYNONYM} may require a demand conversion.
	 */
	public static final int DEMAND_CONVERSION = RawTypeConformanceComputer.DEMAND_CONVERSION;

	/**
	 * Indicates that both types are in a subtype relationship.
	 */
	public static final int SUBTYPE = RawTypeConformanceComputer.SUBTYPE;

	/**
	 * This is set if primitive widening had to be applied.
	 */
	public static final int PRIMITIVE_WIDENING = RawTypeConformanceComputer.PRIMITIVE_WIDENING;

	/**
	 * If unboxing conversion was necessary, this bit is set.
	 */
	public static final int UNBOXING = RawTypeConformanceComputer.UNBOXING;

	/**
	 * If boxing conversion was necessary, this bit is set.
	 */
	public static final int BOXING = RawTypeConformanceComputer.BOXING;

	/**
	 * This is set if the conformance was possible due to raw type conversion.
	 */
	public static final int RAW_TYPE_CONVERSION = RawTypeConformanceComputer.RAW_TYPE_CONVERSION;

	/**
	 * If a synonym conversion was necessary, this bit is set in the result value.
	 */
	public static final int SYNONYM = RawTypeConformanceComputer.SYNONYM;

	/**
	 * Two types are considered compatible if one of the participants is the unknown type. This flag indicates this
	 * situation.
	 */
	public static final int UNKNOWN_TYPE_PARTICIPATED = RawTypeConformanceComputer.UNKNOWN_TYPE_PARTICIPATED;

	/**
	 * Indicates incompatibility.
	 */
	public static final int INCOMPATIBLE = RawTypeConformanceComputer.INCOMPATIBLE;

	/**
	 * Used to indicate a necessary var arg conversion, e.g an expression will be wrapped into an array by the compiler.
	 */
	public static final int VAR_ARG = INCOMPATIBLE << 1;

	/**
	 * Conformance has been checked.
	 */
	public static final int CHECKED = VAR_ARG << 1;
	
	/**
	 * Conformance has been checked and the result was sealed.
	 */
	public static final int SEALED = CHECKED << 1;
	
	/**
	 * Conformance was not yet checked.
	 */
	public static final int UNCHECKED = SEALED << 1;
	
	/**
	 * Lambda expression is raw compatible to its expectation.
	 */
	public static final int LAMBDA_RAW_COMPATIBLE = UNCHECKED << 1;
	
	/**
	 * Lambda expression is compatible to its expectation by its parameter types but not by its result.
	 */
	public static final int LAMBDA_PARAMETER_COMPATIBLE = LAMBDA_RAW_COMPATIBLE << 1;
	
	/**
	 * Flags have been merged from various sources.
	 */
	public static final int MERGED = LAMBDA_PARAMETER_COMPATIBLE << 1;
	
	/**
	 * Indicates that the announced type is not an implicit return type.
	 * 
	 * E.g. the type of a return expression is 'void' but this is not the implicit return type of the return expression
	 * itself. The return type was computed properly from the children of the return expression.
	 */
	public static final int NO_IMPLICIT_RETURN = MERGED << 1;

	/**
	 * Used to indicate an explicit void return value
	 */
	public static final int EXPLICIT_VOID_RETURN = NO_IMPLICIT_RETURN << 1;

	/**
	 * Indicates that the type of this expression is derived from a child which can provide better conformance
	 * information.
	 */
	public static final int PROPAGATED_TYPE = EXPLICIT_VOID_RETURN << 1;

	/**
	 * Indicates that the expression will definitely throw an exception.
	 */
	public static final int THROWN_EXCEPTION = PROPAGATED_TYPE << 1;

	/**
	 * A method is overloaded with various function interfaces. The variant with a single-arg lambda is the prefered
	 * sugar version.
	 */
	public static final int PREFERRED_LAMBDA_SUGAR = THROWN_EXCEPTION << 1;
	
	/**
	 * A lambda's last expression has a non-void implicit type but void was expected.
	 */
	public static final int LAMBDA_VOID_COMPATIBLE = PREFERRED_LAMBDA_SUGAR << 1;
	
	/**
	 * A lambda's type was computed with a valid expectation (a functional interface / SAM type was expected).
	 */
	public static final int LAMBDA_WITH_EXPECTATION = RAW_TYPE << 1; 

	// Composed flags below

	/**
	 * Default flags to announce a successfully checked conformance.
	 */
	public static final int CHECKED_SUCCESS = CHECKED | SUCCESS;
	
	private static final int SUCCESS_OR_LAMBDA = SUCCESS | LAMBDA_RAW_COMPATIBLE | LAMBDA_PARAMETER_COMPATIBLE;
	
	/**
	 * Flags that describe the result of a checked conformance, which can be
	 * one of {@link #INCOMPATIBLE}, {@link #SUCCESS}, {@link #LAMBDA_RAW_COMPATIBLE}, or {@link #LAMBDA_PARAMETER_COMPATIBLE}.
	 */
	public static final int CHECK_RESULTS = ConformanceFlags.INCOMPATIBLE | ConformanceFlags.SUCCESS_OR_LAMBDA;

	/**
	 * Simple comparison of two flags. If both indicate compatibility, the one with the 
	 * better compatibility level wins.
	 * 
	 * Returns {@code -1} for the left, {@code 1} for the right or {@code 0} if undecided.
	 */
	public static int compareFlags(int left, int right) {
		if (left == right) {
			return 0;
		}
		int leftSuccess = left & SUCCESS_OR_LAMBDA;
		int rightSuccess = right & SUCCESS_OR_LAMBDA;
		if (leftSuccess != rightSuccess) {
			if (leftSuccess == 0)
				return 1;
			if (rightSuccess == 0)
				return -1;
			if (leftSuccess < rightSuccess)
				return -1;
			return 1;
		}
		if ((left & SYNONYM) != (right & SYNONYM)) {
			if ((left & SYNONYM) != 0)
				return 1;
			return -1;
		}
		return 0;
	}

	/**
	 * Prints the names of the set bits as a list, e.g. {@code [CHECKED, SUCCESS]}.
	 */
	public static String toString(int flags) {
		Field[] fields = ConformanceFlags.class.getFields();
		try {
			StringBuilder result = new StringBuilder("[");
			for (Field f : fields) {
				int fieldValue = f.getInt(null);
				if (Integer.bitCount(fieldValue) == 1) {
					if ((fieldValue & flags) != 0) {
						if (result.length() != 1) {
							result.append(", ");
						}
						result.append(f.getName());
					}
				}
			}
			result.append("]");
			return result.toString();
		} catch (Exception e) {
			return Integer.toString(flags);
		}
	}

	/**
	 * Simple sanity check for the given flags.
	 * 
	 * Returns always {@code true} such that it can be used in Java assertions.
	 * Will throw an {@link IllegalArgumentException} if the flags appear to be bogus.
	 */
	public static boolean sanityCheck(int flags) {
		doCheck(flags, ConformanceFlags.CHECKED | ConformanceFlags.UNCHECKED);
		if ((flags & ConformanceFlags.UNCHECKED) == 0) {
			doCheck(flags, ConformanceFlags.CHECK_RESULTS);
		} else if ((flags & (ConformanceFlags.SEALED | ConformanceFlags.CHECK_RESULTS)) != 0) {
			throw new IllegalArgumentException("Invalid flags: " + toString(flags));
		}
		return true;
	}

	private static void doCheck(int flags, int bits) {
		if ((flags & bits) == 0)
			throw new IllegalArgumentException("Invalid flags: " + toString(flags));
		if (Integer.bitCount(flags & bits) != 1)
			throw new IllegalArgumentException("Invalid flags: " + toString(flags));
	}

}
