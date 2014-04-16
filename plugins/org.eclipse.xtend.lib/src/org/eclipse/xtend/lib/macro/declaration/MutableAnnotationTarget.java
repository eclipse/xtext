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
