/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Generic Array Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.JvmGenericArrayTypeReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmGenericArrayTypeReference()
 * @model
 * @generated
 */
public interface JvmGenericArrayTypeReference extends JvmTypeReference
{
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(JvmArrayType)
	 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmGenericArrayTypeReference_Type()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	JvmArrayType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.common.types.JvmGenericArrayTypeReference#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmArrayType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmTypeReference getComponentType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getDimensions();

} // JvmGenericArrayTypeReference
