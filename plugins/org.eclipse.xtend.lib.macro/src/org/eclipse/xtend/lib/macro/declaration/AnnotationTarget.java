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
 * An element that can be annotated
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface AnnotationTarget extends NamedElement {

	/**
	 * @return the annotations this element is annotated with
	 */
	Iterable<? extends AnnotationReference> getAnnotations();

	/**
	 * @param annotationType
	 * @return the annotation reference for the given type, or <code>null</code>
	 *         if this element is not annotated with the given annotation type
	 */
	AnnotationReference findAnnotation(Type annotationType);
}
