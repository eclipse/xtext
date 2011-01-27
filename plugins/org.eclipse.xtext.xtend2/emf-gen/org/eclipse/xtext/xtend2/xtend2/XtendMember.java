/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtend Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendMember#getDeclaringType <em>Declaring Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendMember#getInferredJvmMember <em>Inferred Jvm Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendMember()
 * @model abstract="true"
 * @generated
 */
public interface XtendMember extends JvmIdentifiableElement
{
	/**
	 * Returns the value of the '<em><b>Declaring Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaring Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaring Type</em>' container reference.
	 * @see #setDeclaringType(XtendClass)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendMember_DeclaringType()
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClass#getMembers
	 * @model opposite="members" transient="false"
	 * @generated
	 */
	XtendClass getDeclaringType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendMember#getDeclaringType <em>Declaring Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Type</em>' container reference.
	 * @see #getDeclaringType()
	 * @generated
	 */
	void setDeclaringType(XtendClass value);

	/**
	 * Returns the value of the '<em><b>Inferred Jvm Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inferred Jvm Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inferred Jvm Member</em>' reference.
	 * @see #setInferredJvmMember(JvmMember)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendMember_InferredJvmMember()
	 * @model transient="true"
	 * @generated
	 */
	JvmMember getInferredJvmMember();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendMember#getInferredJvmMember <em>Inferred Jvm Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inferred Jvm Member</em>' reference.
	 * @see #getInferredJvmMember()
	 * @generated
	 */
	void setInferredJvmMember(JvmMember value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getSimpleName();

} // XtendMember
