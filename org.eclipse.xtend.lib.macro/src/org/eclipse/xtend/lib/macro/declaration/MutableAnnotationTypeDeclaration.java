/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableAnnotationTypeDeclaration extends MutableTypeDeclaration, AnnotationTypeDeclaration {

	MutableAnnotationTypeElementDeclaration findDeclaredAnnotationTypeElement(String name);
	
	Iterable<? extends MutableAnnotationTypeElementDeclaration> getDeclaredAnnotationTypeElements();
	
	/**
	 * Adds a new annotation type element with the given name. 
	 * 
	 * @param name the name of the annotation type element to be added, must not be <code>null</code>
	 * @param initializer a callback for further initialization of the created annotation type element, must not be <code>null</code>
	 * 
	 * @return the created annotation type element declaration
	 * @throws UnsupportedOperationException if the underlying type declaration is not capable of containing an annotation type element.
	 * @exception IllegalArgumentException if the <code>name</code> is not a valid java identifier or the <code>initializer</code> is <code>null</code>
	 */
	public MutableAnnotationTypeElementDeclaration addAnnotationTypeElement(String name,
			Procedures.Procedure1<MutableAnnotationTypeElementDeclaration> initializer);
}
