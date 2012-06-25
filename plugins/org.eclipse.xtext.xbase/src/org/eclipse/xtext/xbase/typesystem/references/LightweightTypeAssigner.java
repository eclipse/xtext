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
import org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface LightweightTypeAssigner extends ITypeAssigner {

	void assignType(JvmIdentifiableElement element, @Nullable LightweightTypeReference declaredType);
	
	void assignType(JvmIdentifiableElement element, @Nullable LightweightTypeReference declaredType, @Nullable LightweightTypeReference expectedType);
	
	LightweightTypeComputationState getForkedState();
	
	LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference);
	
}
