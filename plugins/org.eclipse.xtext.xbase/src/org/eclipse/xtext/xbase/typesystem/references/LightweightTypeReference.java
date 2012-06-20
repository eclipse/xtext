/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtext.xbase.typesystem.internal.ResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO document the purpose of this class
 *  - get rid of containment constraints
 *  - easier copying
 *  - isResolved
 */
public abstract class LightweightTypeReference {
	
	private ResolvedTypes resolvedTypes;
	
	protected LightweightTypeReference(ResolvedTypes types) {
		this.resolvedTypes = types;
	}

	public boolean isResolved() {
		return true;
	}
	
	protected ResolvedTypes getContext() {
		return resolvedTypes;
	}
	
	protected boolean isValidInContext(ResolvedTypes types) {
		if (isResolved()) {
			return true;
		}
		return types == getContext();
	}
	
	protected LightweightTypeReference copyInto(ResolvedTypes types) {
		if (isResolved()) {
			return this;
		}
		return doCopyInto(types);
	}

	protected abstract LightweightTypeReference doCopyInto(ResolvedTypes types);
	
	@Override
	public abstract String toString();
	
}
