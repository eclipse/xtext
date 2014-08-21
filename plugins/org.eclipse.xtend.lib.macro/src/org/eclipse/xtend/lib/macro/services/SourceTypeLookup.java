/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;

import com.google.common.annotations.Beta;

/**
 * Facilities to lookup Xtend type declarations declared within the currently
 * processed {@link CompilationUnit}.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface SourceTypeLookup {

	/**
	 * @param qualifiedName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the <code>ClassDeclaration</code> with given qualified
	 *         name, or <code>null</code> if no such class declaration is
	 *         contained in the currently processed <code>CompilationUnit</code>
	 */
	ClassDeclaration findSourceClass(String qualifiedName);

	/**
	 * @param qualifiedName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the <code>InterfaceDeclaration</code> with given qualified
	 *         name, or <code>null</code> if no such interface declaration is
	 *         contained in the currently processed <code>CompilationUnit</code>
	 */
	InterfaceDeclaration findSourceInterface(String qualifiedName);

	/**
	 * @param qualifiedName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the <code>EnumerationTypeDeclaration</code> with given
	 *         qualified name, or <code>null</code> if no such class declaration
	 *         is contained in the currently processed
	 *         <code>CompilationUnit</code>
	 */
	EnumerationTypeDeclaration findSourceEnumerationType(String qualifiedName);

	/**
	 * @param qualifiedName
	 *            the qualified name of the type to look up. Nested class delimiter is expected to be the '.' (dot).
	 * @return the <code>AnnotationTypeDeclaration</code> with given
	 *         qualified name, or <code>null</code> if no such class declaration
	 *         is contained in the currently processed
	 *         <code>CompilationUnit</code>
	 */
	AnnotationTypeDeclaration findSourceAnnotationType(String qualifiedName);
}
