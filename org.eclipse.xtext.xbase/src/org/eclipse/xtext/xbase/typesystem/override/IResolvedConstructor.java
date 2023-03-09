/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.List;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmTypeParameter;

/**
 * Resolved representation of a {@link JvmConstructor}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IResolvedConstructor extends IResolvedExecutable {

	/**
	 * Returns the declared constructor that is resolved.
	 * 
	 * @return the declaration.
	 */
	@Override
	JvmConstructor getDeclaration();
	
	/**
	 * Returns the list of declared type parameters of the {@link #getDeclaration() constructor}.
	 * This is not the list of type parameters on the type that declares
	 * this constructor.
	 * 
	 * @return the list of declared type parameters.
	 */
	@Override
	List<JvmTypeParameter> getTypeParameters();
	
}
