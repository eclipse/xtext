/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.util.Arrays;
import java.util.EnumSet;

import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeConformanceResult {
	
	private final EnumSet<ConformanceHint> hints;
	private LightweightTypeReference from;
	private LightweightTypeReference to;
	
	public static TypeConformanceResult create(TypeConformanceComputationArgument argument, ConformanceHint hint) {
		if (argument.rawType) {
			if (ConformanceHint.RAW == hint) {
				throw new IllegalArgumentException();
			}
			return new TypeConformanceResult(EnumSet.of(ConformanceHint.RAW, hint));
		}
		return new TypeConformanceResult(EnumSet.of(hint));
	}
	
	public static TypeConformanceResult create(TypeConformanceComputationArgument argument, ConformanceHint hint, ConformanceHint... hints) {
		EnumSet<ConformanceHint> hintsAsSet = EnumSet.of(hint);
		hintsAsSet.addAll(Arrays.asList(hints));
		if (argument.rawType) {
			hintsAsSet.add(ConformanceHint.RAW);
		}
		return new TypeConformanceResult(hintsAsSet);
	}
	
	public static TypeConformanceResult merge(TypeConformanceResult first, TypeConformanceResult second) {
		TypeConformanceResult result = new TypeConformanceResult(first.getConformanceHints());
		result.getConformanceHints().addAll(second.getConformanceHints());
		result.from = first.from;
		result.to = first.to;
		return result;
	}

	TypeConformanceResult(EnumSet<ConformanceHint> hints) {
		this.hints = hints;
		if (isConformant()) {
			hints.add(ConformanceHint.SUCCESS);
		}
	}
	
	public boolean isConformant() {
		return !(hints.contains(ConformanceHint.INCOMPATIBLE) || hints.contains(ConformanceHint.EXCEPTION));
	}
	
	protected void setConversion(LightweightTypeReference from, LightweightTypeReference to) {
		this.from = from;
		this.to = to;
	}
	
	public LightweightTypeReference getConvertFrom() {
		return from;
	}
	
	public LightweightTypeReference getConvertTo() {
		return to;
	}
	
	public EnumSet<ConformanceHint> getConformanceHints() {
		return hints;
	}

	@Override
	public String toString() {
		return "TypeConformanceResult [hints=" + hints + "]";
	}
	
}
