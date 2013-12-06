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
 * Represents an annotation.
 * 
 * @author Sven Efftinge
 */
@Beta
public interface MutableAnnotationReference extends AnnotationReference, MutableElement {
	
	/**
	 * Sets the annotation property of the given name
	 * 
	 * Depending of the respective annotation type element, the following values are permitted:
	 * <ul>
	 * 	<li>Short or short[]</li>
	 * 	<li>Integer or int[]</li>
	 * 	<li>Long or long[]</li>
	 * 	<li>Float or float[]</li>
	 * 	<li>Double or double[]</li>
	 * 	<li>Boolean or boolean[]</li>
	 * 	<li>TypeReference or TypeReference[] - for elements of type Class<?></li>
	 * 	<li>AnnotationReference or AnnotationReference[] - for elements of an annotation type</li>
	 * 	<li>EnumerationValueDeclaration or EnumerationValueDeclaration[] - for elements of an enum type</li>
	 *  <li>Expression - for any element type that matches the given expression's type</li>
	 *  <li>null - will {@link #remove()} any existing value for the given element name</li>
	 * </ul>
	 * 
	 * @param name
	 * @param value
	 * @exception IllegalArgumentException if the value is not valid. See explanation above. 
	 */
	void set(String name, Object value);
	
	/**
	 * Removes the annotation property with the given name (resets to default if existent).
	 * @param name
	 * @return whether an annotation with the given name existed and was removed.
	 */
	boolean remove(String name);
}
