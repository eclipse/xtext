/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XDelegate Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.XDelegateTypeReference#getDelegate <em>Delegate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getXDelegateTypeReference()
 * @model
 * @generated
 */
public interface XDelegateTypeReference extends JvmTypeReference
{
	/**
	 * Returns the value of the '<em><b>Delegate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegate</em>' reference.
	 * @see #setDelegate(JvmTypeReference)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXDelegateTypeReference_Delegate()
	 * @model
	 * @generated
	 */
	JvmTypeReference getDelegate();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XDelegateTypeReference#getDelegate <em>Delegate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegate</em>' reference.
	 * @see #getDelegate()
	 * @generated
	 */
	void setDelegate(JvmTypeReference value);

} // XDelegateTypeReference
