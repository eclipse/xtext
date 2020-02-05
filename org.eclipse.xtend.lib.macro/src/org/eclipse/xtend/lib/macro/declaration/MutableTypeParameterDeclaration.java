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
public interface MutableTypeParameterDeclaration extends MutableDeclaration, TypeParameterDeclaration {
	public MutableTypeParameterDeclarator getTypeParameterDeclarator();

	/**
	 * @param upperBounds - the upper bounds, must not be <code>null</code>
	 * @exception IllegalArgumentException if <code>upperBounds</code> is <code>null</code> or contains <code>null</code>
	 */
	public void setUpperBounds(Iterable<? extends TypeReference> upperBounds);
	
	/**
	 * This operation is not supported.
	 * @exception UnsupportedOperationException always 
	 */
	public AnnotationReference addAnnotation(AnnotationReference annotationReference);
	
	/**
	 * This operation is not supported.
	 * @exception UnsupportedOperationException always 
	 */
	public boolean removeAnnotation(AnnotationReference annotationReference);

}
