/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class BaseTypeComputationResult implements LightweightTypeComputationResult {

	public final JvmTypeReference getActualExpressionType() {
		LightweightTypeReference result = internalGetActualExpressionType();
		if (result != null)
			return result.toTypeReference();
		return null;
	}

	@Nullable
	public final JvmTypeReference getExpectedExpressionType() {
		LightweightTypeReference result = internalGetExpectedExpressionType();
		if (result != null)
			return result.toTypeReference();
		return null;
	}

	@Nullable
	public final JvmTypeReference getActualType(JvmIdentifiableElement element) {
		LightweightTypeReference result = internalGetActualType(element);
		if (result != null)
			return result.toTypeReference();
		return null;
	}

}
