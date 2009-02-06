/**
 * <copyright>
 * </copyright>
 *
 * $Id: CrossReference.java,v 1.1 2009/02/06 09:46:50 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cross Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.CrossReference#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.CrossReference#getRule <em>Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getCrossReference()
 * @model
 * @generated
 */
public interface CrossReference extends AbstractElement
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
   * @see #setType(TypeRef)
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getCrossReference_Type()
   * @model containment="true"
   * @generated
   */
  TypeRef getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.CrossReference#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeRef value);

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
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage#getCrossReference_Rule()
   * @model
   * @generated
   */
  AbstractRule getRule();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.CrossReference#getRule <em>Rule</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rule</em>' reference.
   * @see #getRule()
   * @generated
   */
  void setRule(AbstractRule value);

} // CrossReference
