/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Type;

import com.google.common.annotations.Beta;

/**
 * Facilities to lookup Java type declarations generated within the currently
 * processed <code>CompilationUnit</code>.
 * 
 * @author Sven Efftinge
 */
@Beta
public interface TypeLookup {

	/**
	 * @param qualifiedName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the <code>MutableClassDeclaration</code> with given qualified
	 *         name, or <code>null</code> if no such class declaration is
	 *         contained in the currently processed <code>CompilationUnit</code>
	 */
	MutableClassDeclaration findClass(String qualifiedName);

	/**
	 * @param qualifiedName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the <code>MutableInterfaceDeclaration</code> with given qualified
	 *         name, or <code>null</code> if no such interface declaration is
	 *         contained in the currently processed <code>CompilationUnit</code>
	 */
	MutableInterfaceDeclaration findInterface(String qualifiedName);

	/**
	 * @param qualifiedName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the <code>MutableEnumerationTypeDeclaration</code> with given
	 *         qualified name, or <code>null</code> if no such class declaration
	 *         is contained in the currently processed
	 *         <code>CompilationUnit</code>
	 */
	MutableEnumerationTypeDeclaration findEnumerationType(String qualifiedName);

	/**
	 * @param qualifiedName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the <code>MutableAnnotationTypeDeclaration</code> with given
	 *         qualified name, or <code>null</code> if no such class declaration
	 *         is contained in the currently processed
	 *         <code>CompilationUnit</code>
	 */
	MutableAnnotationTypeDeclaration findAnnotationType(String qualifiedName);

	/**
	 * @param clazz
	 *            the clazz representing the type to look up
	 * @return the type with the same qualified name as the given
	 *         <code>Class</code> object, or <code>null</code> if that type
	 *         couldn't be found on the compilation units classpath.
	 */
	Type findTypeGlobally(Class<?> clazz);

	/**
	 * @param typeName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the type with the given qualified name, or <code>null</code> if such a type
	 *         couldn't be found on the compilation units classpath.
	 */
	Type findTypeGlobally(String typeName);
}
