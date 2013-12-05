/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.lib.macro.declaration;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 */
@Beta
public interface AnnotationTypeDeclaration extends TypeDeclaration {
	
	/**
	 * @param name the name of the annotation element
	 * @return the annotation type element with the given name, declared by this annotation type declaration or <code>null</code> if no such annotation type element exists
	 */
	AnnotationTypeElementDeclaration findDeclaredAnnotationTypeElement(String name);
	
	/**
	 * @return the annotation type elements declared by this annotation type declaration
	 */
	Iterable<? extends AnnotationTypeElementDeclaration> getDeclaredAnnotationTypeElements();
}