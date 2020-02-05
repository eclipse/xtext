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
public interface MutableAnnotationTarget extends MutableNamedElement, AnnotationTarget {

	/**
	 * Annotate this element with the given annotation reference.
	 * 
	 * @param annotationReference the annotation reference
	 * @return a new annotation reference
	 * @throws IllegalArgumentException if the given annotation reference is <code>null</code>
	 * @since 2.6
	 */
	AnnotationReference addAnnotation(AnnotationReference annotationReference);
	
	/**
	 * Remove the given annotation reference from this element.
	 * 
	 * @param annotationReference the annotation reference
	 * @return <code>true</code> if this element contained the specified annotation
	 * @since 2.6
	 */
	boolean removeAnnotation(AnnotationReference annotationReference);

}
