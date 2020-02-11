/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Resolved representation of a {@link JvmExecutable}.
 * 
 * Parameter types and declared exceptions are put into the context of a specific declaring
 * reference, e.g. {@link List#add(Object) List#add(Object)} becomes <code>List#add(String)</code> in the context of an
 * {@link ArrayList ArrayList&lt;String&gt;}
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IResolvedExecutable extends IResolvedFeature {

	/**
	 * Returns the resolved parameter types in the current context. That is, all free type variables are bound according
	 * the the bottom of this method hierarchy.
	 * 
	 * @see #getContextType()
	 * @return the list of parameter types.
	 */
	List<LightweightTypeReference> getResolvedParameterTypes();
	
	/**
	 * Returns the resolved declared exceptions in the current context. That is, all free type variables are bound
	 * according the the bottom of this method hierarchy.
	 * 
	 * @see #getContextType()
	 * @return the declared exceptions.
	 */
	List<LightweightTypeReference> getResolvedExceptions();

	
	/**
	 * Returns the declared executable that is resolved.
	 * 
	 * @return the declaration.
	 */
	@Override
	JvmExecutable getDeclaration();


	/**
	 * Returns the list of declared type parameters of the {@link #getDeclaration() executable}.
	 * 
	 * @return the list of declared type parameters.
	 */
	List<JvmTypeParameter> getTypeParameters();
	
}
