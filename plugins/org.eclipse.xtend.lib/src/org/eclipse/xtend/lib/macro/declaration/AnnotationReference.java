/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.xtend.lib.macro.declaration;

import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.services.Tracability;

import com.google.common.annotations.Beta;

/**
 * Represents an annotation.
 * 
 * @author Sven Efftinge
 */
@Beta
public interface AnnotationReference extends Element {

	/**
	 * @return the annotation type
	 */
	AnnotationTypeDeclaration getAnnotationTypeDeclaration();

	/**
	 * Returns the value for the given property.
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned. 
	 * 
	 * @param property the name of the property
	 * @return the value set on this annotation reference, the default value of the annotation type element or <code>null</code>.
	 */
	Object getValue(String property);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	int getIntValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	int[] getIntArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	long getLongValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	long[] getLongArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	short getShortValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	short[] getShortArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	float getFloatValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	float[] getFloatArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	double getDoubleValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	double[] getDoubleArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	byte getByteValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	byte[] getByteArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	boolean getBooleanValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	boolean[] getBooleanArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	char getCharValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	char[] getCharArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	String getStringValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	String[] getStringArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	TypeReference getClassValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	TypeReference[] getClassArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	EnumerationValueDeclaration getEnumValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	EnumerationValueDeclaration[] getEnumArrayValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	AnnotationReference getAnnotationValue(String name);
	
	/**
	 * Returns the value for the given property.
	 * 
	 * If no value was specified on the reference the default value of the corresponding {@link AnnotationTypeElementDeclaration}
	 * will be returned.
	 * 
	 * @param name
	 * @return the value set on this annotation reference or the default value of the annotation type element.
	 */
	AnnotationReference[] getAnnotationArrayValue(String name);
	
	/**
	 * Returns the expression for the given annotation property.
	 * Returns <code>null</code> if no expression is set, or this annotation reference is an external element
	 * (i.e. {@link Tracability#isExternal(NamedElement)} returns <code>true</code>). 
	 * 
	 * @param name
	 * @return the expression
	 */
	Expression getExpression(String name);

	
}