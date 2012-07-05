/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class BaseTypeComputationState implements LightweightTypeComputationState, LightweightTypeComputationState.LightweightFork {

	protected abstract BaseResolvedTypes getResolvedTypes();
	
	protected LightweightTypeReference toLightweightReference(JvmTypeReference reference) {
		return getResolvedTypes().getConverter().toLightweightReference(reference);
	}
	
	public final LightweightTypeComputationState assignType(JvmIdentifiableElement element, JvmTypeReference type) {
		return assignType(element, toLightweightReference(type));
	}

	public final void acceptActualType(JvmTypeReference type) {
		acceptActualType(toLightweightReference(type));
	}

	@Nullable
	public final JvmTypeReference getType(JvmIdentifiableElement element) {
		LightweightTypeReference result = internalGetType(element);
		if (result != null)
			return result.toTypeReference();
		return null;
	}

	public final void reassignType(XExpression object, JvmTypeReference type) {
		if (type == null)
			throw new IllegalArgumentException("Reassigned type may not be null");
		reassignType(object, toLightweightReference(type));
	}

	public final LightweightTypeComputationState withExpectation(JvmTypeReference expectation) {
		return withExpectation(toLightweightReference(expectation));
	}
	
}
