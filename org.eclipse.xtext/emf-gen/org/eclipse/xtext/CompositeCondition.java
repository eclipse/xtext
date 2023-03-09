/**
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.CompositeCondition#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.xtext.CompositeCondition#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getCompositeCondition()
 * @model
 * @generated
 * @since 2.9
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface CompositeCondition extends Condition {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Condition)
	 * @see org.eclipse.xtext.XtextPackage#getCompositeCondition_Left()
	 * @model containment="true"
	 * @generated
	 */
	Condition getLeft();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.CompositeCondition#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Condition value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Condition)
	 * @see org.eclipse.xtext.XtextPackage#getCompositeCondition_Right()
	 * @model containment="true"
	 * @generated
	 */
	Condition getRight();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.CompositeCondition#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Condition value);

} // CompositeCondition
