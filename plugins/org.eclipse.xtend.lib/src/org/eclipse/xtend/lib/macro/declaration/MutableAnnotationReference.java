/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtend.lib.macro.expression.Expression;

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
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setIntValue(String name, int... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setLongValue(String name, long... value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setShortValue(String name, short... value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setDoubleValue(String name, double... value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setFloatValue(String name, float... value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setByteValue(String name, byte... value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setBooleanValue(String name, boolean... value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setCharValue(String name, char... value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setStringValue(String name, String... value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setClassValue(String name, TypeReference... value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setEnumValue(String name, EnumerationValueDeclaration... value);
	
	/**
	 * Sets the given expression for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setExpression(String name, Expression value);
	
	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name
	 * @param value
	 */
	void setAnnotationValue(String name, AnnotationReference... value);
	
	/**
	 * Removes the annotation property with the given name (resets to default if existent).
	 * @param name
	 * @return whether an annotation with the given name existed and was removed.
	 */
	boolean remove(String name);
}
