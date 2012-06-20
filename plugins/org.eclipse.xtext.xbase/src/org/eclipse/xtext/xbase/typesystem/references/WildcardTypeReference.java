/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class WildcardTypeReference extends LightweightTypeReference {

	private List<LightweightTypeReference> upperBounds;
	private LightweightTypeReference lowerBound;
	private boolean resolved;
	
	protected WildcardTypeReference(ResolvedTypes types) {
		super(types);
		resolved = true;
	}
	
	@Override
	public boolean isResolved() {
		return resolved;
	}

	@Override
	protected WildcardTypeReference doCopyInto(ResolvedTypes types) {
		WildcardTypeReference result = new WildcardTypeReference(types);
		if (upperBounds != null && !upperBounds.isEmpty()) {
			for(LightweightTypeReference typeArgument: upperBounds) {
				result.addUpperBound(typeArgument.copyInto(types));
			}
		}
		if (lowerBound != null) {
			result.lowerBound = lowerBound.copyInto(types);
		}
		return null;
	}
	
	protected void addUpperBound(LightweightTypeReference upperBound) {
		if (upperBound == null) {
			throw new NullPointerException("upperBound may not be null");
		}
		if (!upperBound.isValidInContext(getContext())) {
			throw new NullPointerException("upperBound is not valid in current context");
		}
		if (upperBounds == null)
			upperBounds = Lists.newArrayListWithCapacity(2);
		upperBounds.add(upperBound);
		resolved &= upperBound.isResolved();
	}
	
	protected void setLowerBound(LightweightTypeReference lowerBound) {
		if (lowerBound == null) {
			throw new NullPointerException("lowerBound may not be null");
		}
		if (!lowerBound.isValidInContext(getContext())) {
			throw new NullPointerException("lowerBound is not valid in current context");
		}
		this.lowerBound = lowerBound;
		resolved &= lowerBound.isResolved();
	}

	@Override
	public String toString() {
		return "?" + ( upperBounds != null ? " extends " + Joiner.on(" & ").join(upperBounds) : "") + (lowerBound != null ? " super " + lowerBound : "");
	}
}
