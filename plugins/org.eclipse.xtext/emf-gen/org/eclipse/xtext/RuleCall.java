/**
 * <copyright>
 * </copyright>
 *
 * $Id: RuleCall.java,v 1.15 2010/04/06 14:10:16 sefftinge Exp $
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.RuleCall#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getRuleCall()
 * @model
 * @generated
 */
public interface RuleCall extends AbstractElement {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' reference.
	 * @see #setRule(AbstractRule)
	 * @see org.eclipse.xtext.XtextPackage#getRuleCall_Rule()
	 * @model
	 * @generated
	 */
	AbstractRule getRule();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.RuleCall#getRule <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(AbstractRule value);

} // RuleCall
