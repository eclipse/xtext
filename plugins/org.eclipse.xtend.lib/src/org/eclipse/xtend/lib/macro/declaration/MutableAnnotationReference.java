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
 * Represents an annotation reference with its values.
 * 
 * @author Sven Efftinge
 */
@Beta
public interface MutableAnnotationReference extends AnnotationReference,
		MutableElement {

	/**
	 * Sets the annotation property of the given name
	 * 
	 * Depending of the respective annotation type element, the following values
	 * are permitted:
	 * <ul>
	 * <li>Short or short[]</li>
	 * <li>Integer or int[]</li>
	 * <li>Long or long[]</li>
	 * <li>Float or float[]</li>
	 * <li>Double or double[]</li>
	 * <li>Boolean or boolean[]</li>
	 * <li>TypeReference or TypeReference[] - for elements of type Class<?></li>
	 * <li>AnnotationReference or AnnotationReference[] - for elements of an
	 * annotation type</li>
	 * <li>EnumerationValueDeclaration or EnumerationValueDeclaration[] - for
	 * elements of an enum type</li>
	 * <li>Expression - for any element type that matches the given expression's
	 * type</li>
	 * <li>null - will {@link #remove()} any existing value for the given
	 * element name</li>
	 * </ul>
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value an annotation value or null if the annotation value should be removed.
	 * @exception IllegalArgumentException
	 *                if the value is not valid. See explanation above or if the
	 *                name does not identify a method in the referenced
	 *                annotation type.
	 */
	void set(String name, Object value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setIntValue(String name, int... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setLongValue(String name, long... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setShortValue(String name, short... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setDoubleValue(String name, double... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setFloatValue(String name, float... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setByteValue(String name, byte... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setBooleanValue(String name, boolean... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setCharValue(String name, char... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array without any null entries
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setStringValue(String name, String... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array without any null entries
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setClassValue(String name, TypeReference... value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array without any null entries
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setEnumValue(String name, EnumerationValueDeclaration... value);

	/**
	 * Sets the given expression for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value.
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setExpression(String name, Expression value);

	/**
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array without any null entries
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setAnnotationValue(String name, AnnotationReference... value);

	/**
	 * Removes the annotation property with the given name (resets to default if
	 * existent).
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @return whether an annotation with the given name existed and was
	 *         removed.
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	boolean remove(String name);
}
