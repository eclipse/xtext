/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.EnumSet;

import org.apache.log4j.Logger;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class TypeConformanceResult {
	
	private static final Logger log = Logger.getLogger(TypeConformanceResult.class);

	public static final TypeConformanceResult SUCCESS = new TypeConformanceResult(Kind.SUCCESS);
	public static final TypeConformanceResult SUBTYPE = new TypeConformanceResult(Kind.SUBTYPE);
	public static final TypeConformanceResult FAILED = new TypeConformanceResult(Kind.FAILED);
	
	public enum Kind {
		SUCCESS, SUBTYPE, PRIMITIVE_WIDENING, BOXING, UNBOXING, SYNONYM, DEMAND_CONVERSION, FAILED, EXCEPTION
	}
	
	private final EnumSet<Kind> kinds;
	private JvmTypeReference from;
	private JvmTypeReference to;
	private int synonymIndex;
	private final Exception trace;
	
	public static TypeConformanceResult merge(TypeConformanceResult first, TypeConformanceResult second) {
		TypeConformanceResult result = new TypeConformanceResult(first.getKinds(), null);
		result.getKinds().addAll(second.getKinds());
		result.from = first.from;
		result.to = first.to;
		result.synonymIndex = first.synonymIndex;
		return result;
	}

	public TypeConformanceResult(Kind kind) {
		this(EnumSet.of(kind), null);
	}
	
	public TypeConformanceResult(Kind kind, Exception trace) {
		this(EnumSet.of(kind), trace);
	}
	
	public TypeConformanceResult(EnumSet<Kind> kinds, Exception trace) {
		this.kinds = EnumSet.copyOf(kinds);
		if (log.isDebugEnabled() && trace == null)
			this.trace = new Exception("trace");
		else
			this.trace = trace;
	}
	
	public boolean isConformant() {
		return !(kinds.contains(Kind.FAILED) || kinds.contains(Kind.EXCEPTION));
	}
	
	protected void setConversion(JvmTypeReference from, JvmTypeReference to) {
		this.from = from;
		this.to = to;
	}
	
	protected void setSynonymIndex(int synonymIndex) {
		this.synonymIndex = synonymIndex;
	}
	
	public JvmTypeReference getConvertFrom() {
		return from;
	}
	
	public JvmTypeReference getConvertTo() {
		return to;
	}
	
	public EnumSet<Kind> getKinds() {
		return kinds;
	}

	public int getSynonymIndex() {
		return synonymIndex;
	}

	public Exception getTrace() {
		return trace;
	}

	@Override
	public String toString() {
		return "TypeConformanceResult [kinds=" + kinds + "]";
	}
	
}
