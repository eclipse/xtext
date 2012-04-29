/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO document the available conformance hints
 * TODO JavaDoc, toString
 */
public enum ConformanceHint {
	EXPECTATION_INDEPENDENT,
	SUBTYPE, 
	PRIMITIVE_WIDENING, 
	BOXING, 
	UNBOXING,
	RAWTYPE_CONVERSION,
	DEMAND_CONVERSION,
	INCOMPATIBLE,
	UNCHECKED,
	RAW,
	MERGED
}