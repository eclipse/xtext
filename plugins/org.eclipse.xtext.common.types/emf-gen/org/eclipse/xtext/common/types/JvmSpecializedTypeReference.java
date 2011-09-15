/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.common.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Specialized Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmSpecializedTypeReference()
 * @model abstract="true"
 * @since 2.1
 * @generated
 */
public interface JvmSpecializedTypeReference extends JvmTypeReference
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<JvmTypeReference> getEquivalentJvmTypeReferences();

} // JvmSpecializedTypeReference
