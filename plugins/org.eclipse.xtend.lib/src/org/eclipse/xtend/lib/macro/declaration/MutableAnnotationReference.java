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
	 * @param name
	 * @param values
	 * @exception IllegalArgumentException if <code>values</code> is <code>null</code> or contains <code>null</code> 
	 */
	void set(String name, String... values);
	
	/**
	 * Sets the annotation property of the given name
	 * @param name
	 * @param values
	 * @exception IllegalArgumentException if <code>values</code> is <code>null</code> or contains <code>null</code>
	 */
	void set(String name, boolean... values);
	
	/**
	 * Sets the annotation property of the given name
	 * @param name
	 * @param values
	 * @exception IllegalArgumentException if <code>values</code> is <code>null</code> or contains <code>null</code>
	 */
	void set(String name, int... values);
	
	/**
	 * Sets the annotation property of the given name
	 * @param name
	 * @param values
	 * @exception IllegalArgumentException if <code>values</code> is <code>null</code> or contains <code>null</code>
	 */
	void set(String name, double... values);
	
	/**
	 * Sets the annotation property of the given name
	 * @param name
	 * @param values
	 * @exception IllegalArgumentException if <code>values</code> is <code>null</code> or contains <code>null</code>
	 */
	void set(String name, TypeReference... values);
	
	/**
	 * Sets the annotation property of the given name
	 * @param name
	 * @param values
	 * @exception IllegalArgumentException if <code>values</code> is <code>null</code> or contains <code>null</code>
	 */
	void set(String name, EnumerationValueDeclaration... values);
	
	/**
	 * Removes the annotation property with the given name (resets to default if existent).
	 * @param name
	 * @return whether an annotation with the given name existed and was removed.
	 */
	boolean remove(String name);
}
