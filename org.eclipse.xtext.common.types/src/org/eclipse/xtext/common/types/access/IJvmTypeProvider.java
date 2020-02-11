/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;

/**
 * The {@link IJvmTypeProvider} allows to retrieve a {@link JvmType} for a given name.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IJvmTypeProvider {

	/**
	 * Find a type by its fully qualified name, e.g. {@code java.util.Map$Entry}, {@code int[]}, {@code void} or
	 * {@code java.lang.String[][][]}. Nested class delimiters are expected to be the {@code '$'}. This is fully
	 * equivalent to {@link #findTypeByName(String, boolean) findTypeByName(name, true)}.
	 * 
	 * @see #findTypeByName(String, boolean)
	 * @return the found {@link JvmType} or null if no such type could be found.
	 */
	JvmType findTypeByName(String name);

	/**
	 * Find a type by its fully qualified name, e.g. {@code java.util.Map.Entry}, {@code int[]}, {@code void} or
	 * {@code java.lang.String[][][]}. If {@code binaryNestedTypeDelimiter} is set to {@code true}, the char {@code '$'}
	 * is expected to be delimiter for nested classes. If it is set to false, a char {@code '.'} is assumed to be a
	 * valid nested type delimiter, too.
	 * 
	 * If the name contains a {@code '$'}, it is assumed to be a class name that uses binary delimiters for nested types.
	 * 
	 * @see #findTypeByName(String, boolean)
	 * @return the found {@link JvmType} or null if no such type could be found.
	 * @since 2.4
	 */
	JvmType findTypeByName(String name, boolean binaryNestedTypeDelimiter);

	/**
	 * Returns the resource set that will contain dynamically created resources.
	 * 
	 * @return the resource set.
	 */
	ResourceSet getResourceSet();

	interface Factory {

		IJvmTypeProvider createTypeProvider(ResourceSet resourceSet);

		IJvmTypeProvider findTypeProvider(ResourceSet resourceSet);

		IJvmTypeProvider findOrCreateTypeProvider(ResourceSet resourceSet);

		IJvmTypeProvider createTypeProvider() throws UnsupportedOperationException;

	}

}
