/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface ITypeAssigner {

	void assignType(JvmIdentifiableElement element, LightweightTypeReference expectedType);
	
	/**
	 * TODO JavaDoc
	 *  - actualDeclaredType == the type on the lambda parameter
	 *  - expected type == the type of the parameter on the implementing operation
	 */
	void assignType(JvmIdentifiableElement element, LightweightTypeReference actualDeclaredType, LightweightTypeReference expectedType);
	
	ITypeComputationState getForkedState();
	
	LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference);
	
}
