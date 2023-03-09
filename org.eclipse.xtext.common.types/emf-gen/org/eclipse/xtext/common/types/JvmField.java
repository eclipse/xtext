/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmField#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmField#isFinal <em>Final</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmField#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmField#isVolatile <em>Volatile</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmField#isTransient <em>Transient</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmField#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.JvmField#getConstantValue <em>Constant Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmField()
 * @model
 * @generated
 */
public interface JvmField extends JvmFeature
{
	/**
	 * Returns the value of the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static</em>' attribute.
	 * @see #setStatic(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmField_Static()
	 * @model
	 * @generated
	 */
	boolean isStatic();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmField#isStatic <em>Static</em>}' attribute.
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
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final</em>' attribute.
	 * @see #setFinal(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmField_Final()
	 * @model
	 * @generated
	 */
	boolean isFinal();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmField#isFinal <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Final</em>' attribute.
	 * @see #isFinal()
	 * @generated
	 */
	void setFinal(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(JvmTypeReference)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmField_Type()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmField#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Volatile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volatile</em>' attribute.
	 * @see #setVolatile(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmField_Volatile()
	 * @model
	 * @generated
	 */
	boolean isVolatile();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmField#isVolatile <em>Volatile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volatile</em>' attribute.
	 * @see #isVolatile()
	 * @generated
	 */
	void setVolatile(boolean value);

	/**
	 * Returns the value of the '<em><b>Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transient</em>' attribute.
	 * @see #setTransient(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmField_Transient()
	 * @model
	 * @generated
	 */
	boolean isTransient();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmField#isTransient <em>Transient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transient</em>' attribute.
	 * @see #isTransient()
	 * @generated
	 */
	void setTransient(boolean value);

	/**
	 * Returns the value of the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant</em>' attribute.
	 * @see #isSetConstant()
	 * @see #unsetConstant()
	 * @see #setConstant(boolean)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmField_Constant()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isConstant();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmField#isConstant <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant</em>' attribute.
	 * @see #isSetConstant()
	 * @see #unsetConstant()
	 * @see #isConstant()
	 * @generated
	 */
	void setConstant(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.xtext.common.types.JvmField#isConstant <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetConstant()
	 * @see #isConstant()
	 * @see #setConstant(boolean)
	 * @generated
	 */
	void unsetConstant();

	/**
	 * Returns whether the value of the '{@link org.eclipse.xtext.common.types.JvmField#isConstant <em>Constant</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Constant</em>' attribute is set.
	 * @see #unsetConstant()
	 * @see #isConstant()
	 * @see #setConstant(boolean)
	 * @generated
	 */
	boolean isSetConstant();

	/**
	 * Returns the value of the '<em><b>Constant Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Value</em>' attribute.
	 * @see #setConstantValue(Object)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmField_ConstantValue()
	 * @model
	 * @generated
	 */
	Object getConstantValue();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmField#getConstantValue <em>Constant Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Value</em>' attribute.
	 * @see #getConstantValue()
	 * @generated
	 */
	void setConstantValue(Object value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	long getConstantValueAsLong();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getConstantValueAsInt();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	short getConstantValueAsShort();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	byte getConstantValueAsByte();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	double getConstantValueAsDouble();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	float getConstantValueAsFloat();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	char getConstantValueAsChar();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean getConstantValueAsBoolean();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getConstantValueAsString();

} // JvmField
