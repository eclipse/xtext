/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAssignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XAssignment#getAssignable <em>Assignable</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAssignment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXAssignment()
 * @model
 * @generated
 */
public interface XAssignment extends XAbstractFeatureCall, XImplicitReceiverCall
{
	/**
	 * Returns the value of the '<em><b>Assignable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignable</em>' containment reference.
	 * @see #setAssignable(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAssignment_Assignable()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getAssignable();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAssignment#getAssignable <em>Assignable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assignable</em>' containment reference.
	 * @see #getAssignable()
	 * @generated
	 */
	void setAssignable(XExpression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAssignment_Value()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAssignment#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(XExpression value);

} // XAssignment
