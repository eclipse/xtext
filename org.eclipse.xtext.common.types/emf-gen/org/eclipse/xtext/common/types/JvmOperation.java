/**
 * Copyright (c) 2011-2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmOperation#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmOperation#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmOperation#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmOperation#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmOperation#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmOperation#isSynchronized <em>Synchronized</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmOperation#isDefault <em>Default</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmOperation#isNative <em>Native</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmOperation#isStrictFloatingPoint <em>Strict Floating Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation()
 * @model
 * @generated
 */
public interface JvmOperation extends JvmExecutable
{
	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation_Static()
	 * @model
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmOperation#isStatic <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static</em>' attribute.
	 * @see #isStatic()
	 * @generated
	 */
	void setStatic(boolean value);

	/**
	 * Returns the value of the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation_Final()
	 * @model
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmOperation#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation_Abstract()
	 * @model
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmOperation#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JvmTypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getReturnType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmOperation#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns the default value for the annotation member represented by this JvmOperation instance.</p>
	 * <p>Returns null if no default is associated with the member, or if the operation does not represent a declared member of an annotation type.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Value</em>' containment reference.
	 * @see #setDefaultValue(JvmAnnotationValue)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation_DefaultValue()
	 * @model containment="true"
	 * @generated
	 */
	JvmAnnotationValue getDefaultValue();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmOperation#getDefaultValue <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' containment reference.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(JvmAnnotationValue value);

	/**
	 * Returns the value of the '<em><b>Synchronized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronized</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronized</em>' attribute.
	 * @see #setSynchronized(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation_Synchronized()
	 * @model
	 * @generated
	 * @since 2.4
	 */
	boolean isSynchronized();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmOperation#isSynchronized <em>Synchronized</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronized</em>' attribute.
	 * @see #isSynchronized()
	 * @generated
	 * @since 2.4
	 */
	void setSynchronized(boolean value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation_Default()
	 * @model
	 * @generated
	 * @since 2.4
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmOperation#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 * @since 2.4
	 */
	void setDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Native</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Native</em>' attribute.
	 * @see #setNative(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation_Native()
	 * @model
	 * @generated
	 * @since 2.4
	 */
	boolean isNative();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmOperation#isNative <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native</em>' attribute.
	 * @see #isNative()
	 * @generated
	 * @since 2.4
	 */
	void setNative(boolean value);

	/**
	 * Returns the value of the '<em><b>Strict Floating Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strict Floating Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #setStrictFloatingPoint(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmOperation_StrictFloatingPoint()
	 * @model
	 * @generated
	 * @since 2.4
	 */
	boolean isStrictFloatingPoint();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmOperation#isStrictFloatingPoint <em>Strict Floating Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strict Floating Point</em>' attribute.
	 * @see #isStrictFloatingPoint()
	 * @generated
	 * @since 2.4
	 */
	void setStrictFloatingPoint(boolean value);

} // JvmOperation
