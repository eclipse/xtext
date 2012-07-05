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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public interface ITypeAssigner {

	void assignType(JvmIdentifiableElement element, JvmTypeReference declaredType);
	
	void assignType(JvmIdentifiableElement element, JvmTypeReference declaredType, JvmTypeReference expectedType);
	
	ITypeComputationState getForkedState();
	
}
