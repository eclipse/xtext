/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.common.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jvm Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.xtext.common.types.TypesPackage#getJvmFeature()
 * @model abstract="true"
 * @generated
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface JvmFeature extends JvmMember
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Returns <code>true</code> if the feature is a static field or static operation.</p>
	 * 
	 * @since 2.4
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStatic();

} // JvmFeature
