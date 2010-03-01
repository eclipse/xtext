/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postfix Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression#getProperty <em>Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Bug303200TestLanguagePackage#getPostfixExpression()
 * @model
 * @generated
 */
public interface PostfixExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(PrimaryExpression)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Bug303200TestLanguagePackage#getPostfixExpression_Expression()
   * @model containment="true"
   * @generated
   */
  PrimaryExpression getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(PrimaryExpression value);

  /**
   * Returns the value of the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Property</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' containment reference.
   * @see #setProperty(PropertyOperator)
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Bug303200TestLanguagePackage#getPostfixExpression_Property()
   * @model containment="true"
   * @generated
   */
  PropertyOperator getProperty();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression#getProperty <em>Property</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' containment reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(PropertyOperator value);

} // PostfixExpression
