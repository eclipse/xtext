/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmTypeReference()
 * @model abstract="true"
 * @generated
 */
public interface JvmTypeReference extends EObject
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	JvmType getType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSimpleName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getQualifiedName();

} // JvmTypeReference
