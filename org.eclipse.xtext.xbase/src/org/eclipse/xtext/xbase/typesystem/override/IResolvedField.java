/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	 * the the bottom of this hierarchy.
	 * 
	 * @see #getContextType()
	 * @return the return type.
	 */
	LightweightTypeReference getResolvedType();
	
	@Override
	JvmField getDeclaration();
}
