/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableTypeParameterDeclarator extends MutableMemberDeclaration, TypeParameterDeclarator {
	
	Iterable<? extends MutableTypeParameterDeclaration> getTypeParameters();

	/**
	 * Creates and adds a new {@link MutableTypeParameterDeclaration} to this
	 * declarator.
	 * 
	 * @param name
	 *            the name of the type parameter
	 * @param upperBounds
	 *            the upperbounds
	 * @return the created and attached {@link MutableTypeParameterDeclaration}
	 * @exception IllegalArgumentException
	 *                <ol><li>if the <code>name</code> is not a valid java identifier</li>
	 *                <li>if the <code>upperBounds</code> is <code>null</code> or contains <code>null</code></li></ol>
	 */
	MutableTypeParameterDeclaration addTypeParameter(String name, TypeReference... upperBounds);
}
