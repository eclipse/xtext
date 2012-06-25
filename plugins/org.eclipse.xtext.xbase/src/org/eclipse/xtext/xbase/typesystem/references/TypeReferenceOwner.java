/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.util.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface TypeReferenceOwner {

	CommonTypeComputationServices getServices();

	void acceptHint(Object handle, LightweightBoundTypeArgument boundTypeArgument);
	
	List<LightweightBoundTypeArgument> getAllHints(Object handle);
	
	@Nullable
	LightweightTypeReference getCommonSuperType(List<LightweightTypeReference> subTypes);

	boolean isConformant(LightweightTypeReference declaredType, LightweightTypeReference actualType);

	boolean isConformant(LightweightTypeReference type, LightweightTypeReference inType, TypeConformanceComputationArgument argument);
	
}
