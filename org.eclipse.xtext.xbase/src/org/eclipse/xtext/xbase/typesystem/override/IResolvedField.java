/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IResolvedField extends IResolvedFeature {

	/**
	 * Returns the resolved type in the current context. That is, all free type variables are bound according
	 * to the bottom of this hierarchy.
	 * 
	 * @see #getContextType()
	 * @return the return type.
	 */
	LightweightTypeReference getResolvedType();
	
	@Override
	JvmField getDeclaration();
}
