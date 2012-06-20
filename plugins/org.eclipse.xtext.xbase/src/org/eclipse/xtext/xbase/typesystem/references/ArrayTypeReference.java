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
 */
public class ArrayTypeReference extends LightweightTypeReference {

	private LightweightTypeReference component;

	protected ArrayTypeReference(ResolvedTypes types, LightweightTypeReference component) {
		super(types);
		this.component = component;
	}
	
	@Override
	public boolean isResolved() {
		return component.isResolved();
	}

	@Override
	protected LightweightTypeReference doCopyInto(ResolvedTypes types) {
		LightweightTypeReference copiedComponent = component.copyInto(types);
		return new ArrayTypeReference(types, copiedComponent);
	}
	
	@Override
	public String toString() {
		return component + "[]";
	}

}
