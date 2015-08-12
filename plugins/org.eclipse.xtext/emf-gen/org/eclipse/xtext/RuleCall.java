/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.RuleCall#getRule <em>Rule</em>}</li>
 *   <li>{@link org.eclipse.xtext.RuleCall#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.RuleCall#isExplicitlyCalled <em>Explicitly Called</em>}</li>
 * </ul>
 *
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
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

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.NamedArgument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.XtextPackage#getRuleCall_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<NamedArgument> getArguments();

	/**
	 * Returns the value of the '<em><b>Explicitly Called</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicitly Called</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicitly Called</em>' attribute.
	 * @see #setExplicitlyCalled(boolean)
	 * @see org.eclipse.xtext.XtextPackage#getRuleCall_ExplicitlyCalled()
	 * @model
	 * @generated
	 */
	boolean isExplicitlyCalled();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.RuleCall#isExplicitlyCalled <em>Explicitly Called</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicitly Called</em>' attribute.
	 * @see #isExplicitlyCalled()
	 * @generated
	 */
	void setExplicitlyCalled(boolean value);

} // RuleCall
