/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.Type;

import com.google.common.annotations.Beta;

/**
 * Facilities to lookup of Java type declarations in upstream 
 * dependencies of the current {@link CompilationUnit}. 
 * This means that types defined in the same project will not be found.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.7
 */
@Beta
public interface UpstreamTypeLookup {
	/**
	 * @param clazz
	 *            the clazz representing the type to look up
	 * @return the type with the same qualified name as the given
	 *         <code>Class</code> object, or <code>null</code> if that type
	 *         couldn't be found on the compilation unit's upstream dependencies.
	 */
	Type findUpstreamType(Class<?> clazz);

	/**
	 * @param typeName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the type with the given qualified name, or <code>null</code> if such a type
	 *         couldn't be found on the compilation unit's upstream dependencies.
	 */
	Type findUpstreamType(String typeName);
}
