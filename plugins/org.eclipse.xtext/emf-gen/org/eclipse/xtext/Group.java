/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.Group#getGuardCondition <em>Guard Condition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getGroup()
 * @model
 * @generated
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface Group extends CompoundElement {
	/**
	 * Returns the value of the '<em><b>Guard Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard Condition</em>' containment reference.
	 * @see #setGuardCondition(Condition)
	 * @see org.eclipse.xtext.XtextPackage#getGroup_GuardCondition()
	 * @model containment="true"
	 * @generated
	 */
	Condition getGuardCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.Group#getGuardCondition <em>Guard Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard Condition</em>' containment reference.
	 * @see #getGuardCondition()
	 * @generated
	 */
	void setGuardCondition(Condition value);

} // Group
