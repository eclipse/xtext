package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;

import com.google.common.annotations.Beta;

/**
 * Services provided during an annotation reference initialization.  
 * 
 * @author Anton Kosyakov
 * @since 2.6
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface AnnotationReferenceBuildContext {

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
	 * <li>AnnotationReference or AnnotationReference[] - for elements of an annotation type</li>
	 * <li>EnumerationValueDeclaration or EnumerationValueDeclaration[] - for elements of an enum type</li>
	 * <li>Expression - for any element type that matches the given expression's type</li>
	 * <li>null - will remove any existing value for the given element name</li>
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
	 * Sets the given value for the given annotation element name.
	 * 
	 * @param name a valid name of a property of the annotation type.
	 * @param value a non-null value array without any null entries
	 * @throws IllegalArgumentException
	 *             if the name does not point to a valid member of the
	 *             referenced annotation type.
	 */
	void setAnnotationValue(String name, AnnotationReference... value);
	
}
