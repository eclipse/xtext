/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.util.EnumSet;

import org.apache.log4j.Logger;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class TypeConformanceResult {
	
	private static final Logger log = Logger.getLogger(TypeConformanceResult.class);

	public static final TypeConformanceResult SUCCESS = new TypeConformanceResult(ConformanceHint.SUCCESS);
	public static final TypeConformanceResult SUBTYPE = new TypeConformanceResult(ConformanceHint.SUBTYPE);
	public static final TypeConformanceResult FAILED = new TypeConformanceResult(ConformanceHint.INCOMPATIBLE);
	
	private final EnumSet<ConformanceHint> kinds;
	private LightweightTypeReference from;
	private LightweightTypeReference to;
	private int synonymIndex;
	private final Exception trace;
	
	public static TypeConformanceResult merge(TypeConformanceResult first, TypeConformanceResult second) {
		TypeConformanceResult result = new TypeConformanceResult(first.getConformanceHints(), null);
		result.getConformanceHints().addAll(second.getConformanceHints());
		result.from = first.from;
		result.to = first.to;
		result.synonymIndex = first.synonymIndex;
		return result;
	}

	public TypeConformanceResult(ConformanceHint hint) {
		this(EnumSet.of(hint), null);
	}
	
	public TypeConformanceResult(ConformanceHint hint, Exception trace) {
		this(EnumSet.of(hint), trace);
	}
	
	public TypeConformanceResult(EnumSet<ConformanceHint> hints, @Nullable Exception stackTrace) {
		this.kinds = EnumSet.copyOf(hints);
		if (isConformant()) {
			kinds.add(ConformanceHint.SUCCESS);
		}
		if (log.isDebugEnabled() && stackTrace == null)
			this.trace = new Exception("trace");
		else
			this.trace = stackTrace;
	}
	
	public boolean isConformant() {
		return !(kinds.contains(ConformanceHint.INCOMPATIBLE) || kinds.contains(ConformanceHint.EXCEPTION));
	}
	
	protected void setConversion(LightweightTypeReference from, LightweightTypeReference to) {
		this.from = from;
		this.to = to;
	}
	
	protected void setSynonymIndex(int synonymIndex) {
		this.synonymIndex = synonymIndex;
	}
	
	public LightweightTypeReference getConvertFrom() {
		return from;
	}
	
	public LightweightTypeReference getConvertTo() {
		return to;
	}
	
	public EnumSet<ConformanceHint> getConformanceHints() {
		return kinds;
	}

	public int getSynonymIndex() {
		return synonymIndex;
	}

	public Exception getStackTrace() {
		return trace;
	}

	@Override
	public String toString() {
		return "TypeConformanceResult [kinds=" + kinds + "]";
	}
	
}
