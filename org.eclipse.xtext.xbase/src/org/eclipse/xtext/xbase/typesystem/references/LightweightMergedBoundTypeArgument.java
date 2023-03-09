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
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * The result of a merge operation where different type bound type arguments are
 * incorporated into a result.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LightweightMergedBoundTypeArgument {
	private final LightweightTypeReference typeReference;

	private final VarianceInfo variance;

	public LightweightMergedBoundTypeArgument(LightweightTypeReference typeReference, VarianceInfo variance) {
		this.typeReference = typeReference;
		this.variance = variance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((typeReference == null) ? 0 : typeReference.hashCode());
		result = prime * result + ((variance == null) ? 0 : variance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LightweightMergedBoundTypeArgument other = (LightweightMergedBoundTypeArgument) obj;
		if (typeReference == null) {
			if (other.typeReference != null)
				return false;
		} else if (!typeReference.equals(other.typeReference))
			return false;
		if (variance != other.variance)
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("typeReference", typeReference);
		b.add("variance", variance);
		return b.toString();
	}

	public LightweightTypeReference getTypeReference() {
		return typeReference;
	}

	public VarianceInfo getVariance() {
		return variance;
	}
}
