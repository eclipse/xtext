/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.util.EnumSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO document the available conformance hints
 * TODO JavaDoc, toString
 */
public enum ConformanceHint {
	SUCCESS(ConformanceHints.SUCCESS), // is conformant
	INCOMPATIBLE(ConformanceHints.INCOMPATIBLE), // is not conformant
	EXCEPTION(ConformanceHints.NONE), // TODO is that one necessary?
	
	SUBTYPE(ConformanceHints.SUBTYPE), // specialized data - is subtype
	PRIMITIVE_WIDENING(ConformanceHints.PRIMITIVE_WIDENING), // 
	BOXING(ConformanceHints.BOXING), //
	UNBOXING(ConformanceHints.UNBOXING), // 
	RAWTYPE_CONVERSION(ConformanceHints.RAW_TYPE_CONVERSION), // compared to raw type
	DEMAND_CONVERSION(ConformanceHints.DEMAND_CONVERSION), // function type conversion,
	SYNONYM(ConformanceHints.SYNONYM), // array to list, stringConcat to string
	VAR_ARG(ConformanceHints.VAR_ARG), // argument will be wrapped in array
	
	CHECKED(ConformanceHints.CHECKED), // conformance computed
	SEALED(ConformanceHints.SEALED), // conformance computed and fix, e.g. a literal can provide a sealed type 
	UNCHECKED(ConformanceHints.UNCHECKED), // nothing computed
	
	RAW(ConformanceHints.RAW_TYPE), // only raw conformance computed
	LAMBDA_RAW_COMPATIBLE(ConformanceHints.LAMBDA_RAW_COMPATIBLE), // incompatible but raw types are compatible
	LAMBDA_PARAMETER_COMPATIBLE(ConformanceHints.LAMBDA_PARAMETER_COMPATIBLE), // incompatible but parameter list is compatible
	MERGED(ConformanceHints.MERGED), // merged from different conformance sets
	EXPECTATION_INDEPENDENT(ConformanceHints.EXPECTATION_INDEPENDENT), // does not depend on the expectation
	
	/**
	 * Indicates that the announced type is not an implicit return type.
	 * 
	 * E.g. the type of a return expression is 'void' but this is not the implicit return type of the 
	 * return expression itself. The return type was computed properly from the children of the return expression.
	 */
	NO_IMPLICIT_RETURN(ConformanceHints.NO_IMPLICIT_RETURN),
	
	/**
	 * Used to indicate an explicit void return value
	 */
	EXPLICIT_VOID_RETURN(ConformanceHints.EXPLICIT_VOID_RETURN),
	
	/**
	 * Indicates that the type of this expression is derived from a child which can provide better conformance information.
	 */
	PROPAGATED_TYPE(ConformanceHints.PROPAGATED_TYPE),
	
	/**
	 * Indicates that the expression will definitely throw an exception.
	 */
	THROWN_EXCEPTION(ConformanceHints.THROWN_EXCEPTION),
	
	/**
	 * Two types are considered conformant if one of the participants is the unknown type. This flag indicates this situation.
	 */
	UNKNOWN_TYPE_PARTICIPATED(ConformanceHints.UNKNOWN_TYPE_PARTICIPATED),
	
	/**
	 * A method is overloaded with various function interfaces. The variant with a single-arg lambda is the prefered sugar version.
	 */
	PREFERRED_LAMBDA_SUGAR(ConformanceHints.PREFERRED_LAMBDA_SUGAR),
	;
	
	private int flag;

	ConformanceHint(int flag) {
		this.flag = flag;
	}
	
	public static int toFlags(EnumSet<ConformanceHint> hints) {
		int result = ConformanceHints.NONE;
		for(ConformanceHint hint: hints) {
			result |= hint.flag;
		}
		return result;
	}
	
//	protected EnumSet<ConformanceHint2> toResult(int result) {
//		EnumSet<ConformanceHint> resultFlags = EnumSet.noneOf(ConformanceHint.class);
//		if ((result & SUCCESS) != 0) {
//			resultFlags.add(ConformanceHint.SUCCESS);
//		} else {
//			resultFlags.add(ConformanceHint.INCOMPATIBLE);
//		}
//		if ((result & DEMAND_CONVERSION) != 0) {
//			resultFlags.add(ConformanceHint.DEMAND_CONVERSION);
//		}
//		if ((result & SUBTYPE) != 0) {
//			resultFlags.add(ConformanceHint.SUBTYPE);
//		}
//		if ((result & PRIMITIVE_WIDENING) != 0) {
//			resultFlags.add(ConformanceHint.PRIMITIVE_WIDENING);
//		}
//		if ((result & UNBOXING) != 0) {
//			resultFlags.add(ConformanceHint.UNBOXING);
//		}
//		if ((result & BOXING) != 0) {
//			resultFlags.add(ConformanceHint.BOXING);
//		}
//		if ((result & RAW_TYPE_CONVERSION) != 0) {
//			resultFlags.add(ConformanceHint.RAWTYPE_CONVERSION);
//		}
//		if ((result & RAW_TYPE) != 0) {
//			resultFlags.add(ConformanceHint.RAW);
//		}
//		if ((result & SYNONYM) != 0) {
//			resultFlags.add(ConformanceHint.SYNONYM);
//		}
//		if ((result & UNKNOWN_TYPE_PARTICIPATED) != 0) {
//			resultFlags.add(ConformanceHint.UNKNOWN_TYPE_PARTICIPATED);
//		}
//		return resultFlags;
//	}
	
	
}