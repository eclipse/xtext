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
	SUCCESS, // is conformant
	INCOMPATIBLE, // is not conformant
	EXCEPTION, // TODO is that one necessary?
	
	SUBTYPE, // specialized data - is subtype
	PRIMITIVE_WIDENING, // 
	BOXING, //
	UNBOXING, // 
	RAWTYPE_CONVERSION, // compared to raw type
	DEMAND_CONVERSION, // function type conversion,
	SYNONYM, // array to list, stringConcat to string
	VAR_ARG, // argument will be wrapped in array
	
	CHECKED, // conformance computed
	SEALED, // conformance computed and fix, e.g. a literal can provide a sealed type 
	UNCHECKED, // nothing computed
	
//	UNDECIDED, // more than one type computed, results should not be merged but the better one should be used
	
	RAW, // only raw conformance computed
	LAMBDA_RAW_COMPATIBLE, // incompatible but raw types are compatible
	LAMBDA_PARAMETER_COMPATIBLE, // incompatible but parameter list is compatible
	MERGED, // merged from different conformance sets
	EXPECTATION_INDEPENDENT, // does not depend on the expectation
	
	/**
	 * Indicates that the announced type is not an implicit return type.
	 * 
	 * E.g. the type of a return expression is 'void' but this is not the implicit return type of the 
	 * return expression itself. The return type was computed properly from the children of the return expression.
	 */
	NO_IMPLICIT_RETURN,
	
	/**
	 * Used to indicate an explicit void return value
	 */
	EXPLICIT_VOID_RETURN,
	
	/**
	 * Indicates that the type of this expression is derived from a child which can provide better conformance information.
	 */
	PROPAGATED_TYPE;  
	
	
	public static int compareHints(EnumSet<ConformanceHint> leftConformance, EnumSet<ConformanceHint> rightConformance) {
		if (leftConformance.equals(rightConformance)) {
			return 0;
		}
		if (leftConformance.contains(ConformanceHint.SUCCESS) != rightConformance.contains(ConformanceHint.SUCCESS)) {
			if (leftConformance.contains(ConformanceHint.SUCCESS))
				return -1;
			return 1;
		}
		if (leftConformance.contains(ConformanceHint.LAMBDA_RAW_COMPATIBLE) != rightConformance.contains(ConformanceHint.LAMBDA_RAW_COMPATIBLE)) {
			if (leftConformance.contains(ConformanceHint.LAMBDA_RAW_COMPATIBLE))
				return -1;
			return 1;
		}
		if (leftConformance.contains(ConformanceHint.LAMBDA_PARAMETER_COMPATIBLE) != rightConformance.contains(ConformanceHint.LAMBDA_PARAMETER_COMPATIBLE)) {
			if (leftConformance.contains(ConformanceHint.LAMBDA_PARAMETER_COMPATIBLE))
				return -1;
			return 1;
		}
		if (leftConformance.contains(ConformanceHint.EXCEPTION) != rightConformance.contains(ConformanceHint.EXCEPTION)) {
			if (leftConformance.contains(ConformanceHint.EXCEPTION))
				return 1;
			return -1;
		}
		if (leftConformance.contains(ConformanceHint.SYNONYM) != rightConformance.contains(ConformanceHint.SYNONYM)) {
			if (leftConformance.contains(ConformanceHint.SYNONYM))
				return 1;
			return -1;
		}
		return 0;
	}
	
}