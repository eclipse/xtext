/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Extension Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo#getCreateExpression <em>Create Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getCreateExtensionInfo()
 * @model
 * @generated
 */
public interface CreateExtensionInfo extends JvmIdentifiableElement
{
	/**
	 * Returns the value of the '<em><b>Create Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Expression</em>' containment reference.
	 * @see #setCreateExpression(XExpression)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getCreateExtensionInfo_CreateExpression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getCreateExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo#getCreateExpression <em>Create Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Expression</em>' containment reference.
	 * @see #getCreateExpression()
	 * @generated
	 */
	void setCreateExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"this"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getCreateExtensionInfo_Name()
	 * @model default="this"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.CreateExtensionInfo#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // CreateExtensionInfo
