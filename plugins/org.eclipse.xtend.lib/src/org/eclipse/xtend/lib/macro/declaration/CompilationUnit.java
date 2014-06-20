/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtend.lib.macro.file.Path;

import com.google.common.annotations.Beta;

/**
 * 
 * Represents a single Xtend file and the root element of the AST.
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface CompilationUnit extends AnnotationTarget {

	/**
	 * @return the package name of this compilation unit. 
	 */
	String getPackageName();

	/**
	 * @return the JavaDoc comment
	 */
	String getDocComment();

	/**
	 * @return the source view of the <code>TypeDeclaration</code>s directly contained in the compilation unit.
	 */
	Iterable<? extends TypeDeclaration> getSourceTypeDeclarations();
	
	/**
	 * Returns the file handle for the given compilation unit.
	 * 
	 * @param compilationUnit the compilation unit
	 * @return the file handle for the given compilation unit.
	 * @see Path
	 */
	Path getFilePath();
	
}
