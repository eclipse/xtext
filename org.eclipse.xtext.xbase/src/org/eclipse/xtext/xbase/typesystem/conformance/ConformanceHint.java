/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.util.EnumSet;

/**
 * Enum to work with a type safe represenation of the {@link ConformanceFlags}.
 * Internally the flags are used but clients may decide to use {@link #fromFlags(int)}
 * or {@link #toFlags(EnumSet)} to work with the strongly typed representation.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public enum ConformanceHint {
	SUCCESS(ConformanceFlags.SUCCESS), // is compatible
	INCOMPATIBLE(ConformanceFlags.INCOMPATIBLE), // is not compatible
	EXCEPTION(ConformanceFlags.NONE), // TODO is that one necessary?
	
	SUBTYPE(ConformanceFlags.SUBTYPE), // specialized data - is subtype
	PRIMITIVE_WIDENING(ConformanceFlags.PRIMITIVE_WIDENING), // 
	BOXING(ConformanceFlags.BOXING), //
	UNBOXING(ConformanceFlags.UNBOXING), // 
	RAWTYPE_CONVERSION(ConformanceFlags.RAW_TYPE_CONVERSION), // compared to raw type
	DEMAND_CONVERSION(ConformanceFlags.DEMAND_CONVERSION), // function type conversion,
	SYNONYM(ConformanceFlags.SYNONYM), // array to list, stringConcat to string
	VAR_ARG(ConformanceFlags.VAR_ARG), // argument will be wrapped in array
	
	CHECKED(ConformanceFlags.CHECKED), // conformance computed
	SEALED(ConformanceFlags.SEALED), // conformance computed and fix, e.g. a literal can provide a sealed type 
	UNCHECKED(ConformanceFlags.UNCHECKED), // nothing computed
	
	RAW(ConformanceFlags.RAW_TYPE), // only raw conformance computed
	LAMBDA_RAW_COMPATIBLE(ConformanceFlags.LAMBDA_RAW_COMPATIBLE), // incompatible but raw types are compatible
	LAMBDA_VOID_COMPATIBLE(ConformanceFlags.LAMBDA_VOID_COMPATIBLE), // compatible but could also be compatible to non-void expectation
	LAMBDA_PARAMETER_COMPATIBLE(ConformanceFlags.LAMBDA_PARAMETER_COMPATIBLE), // incompatible but parameter list is compatible
	MERGED(ConformanceFlags.MERGED), // merged from different conformance sets
	
	/**
	 * Indicates that the announced type is not an implicit return type.
	 * 
	 * E.g. the type of a return expression is 'void' but this is not the implicit return type of the 
	 * return expression itself. The return type was computed properly from the children of the return expression.
	 */
	NO_IMPLICIT_RETURN(ConformanceFlags.NO_IMPLICIT_RETURN),
	
	/**
	 * Used to indicate an explicit void return value
	 */
	EXPLICIT_VOID_RETURN(ConformanceFlags.EXPLICIT_VOID_RETURN),
	
	/**
	 * Indicates that the type of this expression is derived from a child which can provide better conformance information.
	 */
	PROPAGATED_TYPE(ConformanceFlags.PROPAGATED_TYPE),
	
	/**
	 * Indicates that the expression will definitely throw an exception.
	 */
	THROWN_EXCEPTION(ConformanceFlags.THROWN_EXCEPTION),
	
	/**
	 * Two types are considered compatible if one of the participants is the unknown type. This flag indicates this situation.
	 */
	UNKNOWN_TYPE_PARTICIPATED(ConformanceFlags.UNKNOWN_TYPE_PARTICIPATED),
	
	/**
	 * A method is overloaded with various function interfaces. The variant with a single-arg lambda is the prefered sugar version.
	 */
	PREFERRED_LAMBDA_SUGAR(ConformanceFlags.PREFERRED_LAMBDA_SUGAR),
	;
	
	private int flag;

	ConformanceHint(int flag) {
		this.flag = flag;
	}
	
	public static int toFlags(ConformanceHint... hints) {
		int result = ConformanceFlags.NONE;
		for(ConformanceHint hint: hints) {
			result |= hint.flag;
		}
		return result;
	}
	
	public static int toFlags(EnumSet<ConformanceHint> hints) {
		int result = ConformanceFlags.NONE;
		for(ConformanceHint hint: hints) {
			result |= hint.flag;
		}
		return result;
	}
	
	public static EnumSet<ConformanceHint> fromFlags(int flags) {
		EnumSet<ConformanceHint> result = EnumSet.noneOf(ConformanceHint.class);
		for(ConformanceHint hint: values()) {
			if ((flags & hint.flag) != 0) {
				result.add(hint);
			}
		}
		return result;
	}
	
}