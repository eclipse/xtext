/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.jdt.annotation.Nullable;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LightweightTypeReferences {

	@Nullable
	public LightweightTypeReference getUpperBoundOrInvariant(LightweightTypeReference reference) {
		if (reference instanceof WildcardTypeReference) {
			List<LightweightTypeReference> bounds = ((WildcardTypeReference) reference).getUpperBounds();
			if (bounds.size() == 0) {
				return null;
			}
			if (bounds.size() > 1) {
				CompoundTypeReference result = new CompoundTypeReference(reference.getOwner(), false);
				for(LightweightTypeReference bound: bounds)
					result.addComponent(bound.copyInto(reference.getOwner()));
				return result;
			} else {
				return bounds.get(0);
			}
		}
		return reference;
	}
	
	@Nullable
	public LightweightTypeReference getLowerBoundOrInvariant(LightweightTypeReference reference) {
		if (reference instanceof WildcardTypeReference) {
			LightweightTypeReference lowerBound = ((WildcardTypeReference) reference).getLowerBound();
			if (lowerBound != null)
				return lowerBound.copyInto(reference.getOwner());
			return null;
		}
		return reference;
	}
	
}
