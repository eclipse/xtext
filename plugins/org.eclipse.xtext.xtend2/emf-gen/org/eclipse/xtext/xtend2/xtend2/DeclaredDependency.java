/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declared Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.DeclaredDependency#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getDeclaredDependency()
 * @model
 * @generated
 */
public interface DeclaredDependency extends XtendMember
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
	 * @see #setType(JvmTypeReference)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getDeclaredDependency_Type()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.DeclaredDependency#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(JvmTypeReference value);

} // DeclaredDependency
