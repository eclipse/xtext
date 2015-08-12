/**
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.LiteralCondition#isTrue <em>True</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getLiteralCondition()
 * @model
 * @generated
 * @since 2.9
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface LiteralCondition extends Condition {
	/**
	 * Returns the value of the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>True</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>True</em>' attribute.
	 * @see #setTrue(boolean)
	 * @see org.eclipse.xtext.XtextPackage#getLiteralCondition_True()
	 * @model
	 * @generated
	 */
	boolean isTrue();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.LiteralCondition#isTrue <em>True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>True</em>' attribute.
	 * @see #isTrue()
	 * @generated
	 */
	void setTrue(boolean value);

} // LiteralCondition
