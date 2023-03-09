/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * Encapsulates the information that is collected as a type hint to later
 * resolve an unbound type reference.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LightweightBoundTypeArgument {
	private final LightweightTypeReference typeReference;

	private final BoundTypeArgumentSource source;

	private final Object origin;

	private final VarianceInfo declaredVariance;

	private final VarianceInfo actualVariance;

	public boolean isValidVariancePair() {
		return declaredVariance.mergeDeclaredWithActual(actualVariance) != null;
	}

	public LightweightBoundTypeArgument(LightweightTypeReference typeReference, BoundTypeArgumentSource source,
			Object origin, VarianceInfo declaredVariance, VarianceInfo actualVariance) {
		this.typeReference = typeReference;
		this.source = source;
		this.origin = origin;
		this.declaredVariance = declaredVariance;
		this.actualVariance = actualVariance;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("typeReference", typeReference);
		b.add("source", source);
		b.add("origin", origin);
		b.add("declaredVariance", declaredVariance);
		b.add("actualVariance", actualVariance);
		return b.toString();
	}

	public LightweightTypeReference getTypeReference() {
		return typeReference;
	}

	public BoundTypeArgumentSource getSource() {
		return source;
	}

	public Object getOrigin() {
		return origin;
	}

	public VarianceInfo getDeclaredVariance() {
		return declaredVariance;
	}

	public VarianceInfo getActualVariance() {
		return actualVariance;
	}
}
