/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParserRule.java,v 1.6 2008/05/20 09:09:47 jkohnlein Exp $
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ParserRule#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link org.eclipse.xtext.ParserRule#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getParserRule()
 * @model
 * @generated
 */
public interface ParserRule extends AbstractRule
{
  /**
   * Returns the value of the '<em><b>Alternatives</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alternatives</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alternatives</em>' containment reference.
   * @see #setAlternatives(AbstractElement)
   * @see org.eclipse.xtext.XtextPackage#getParserRule_Alternatives()
   * @model containment="true"
   * @generated
   */
  AbstractElement getAlternatives();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ParserRule#getAlternatives <em>Alternatives</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alternatives</em>' containment reference.
   * @see #getAlternatives()
   * @generated
   */
  void setAlternatives(AbstractElement value);

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
   * @see org.eclipse.xtext.XtextPackage#getParserRule_Type()
   * @model containment="true"
   * @generated
   */
  TypeRef getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ParserRule#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeRef value);

} // ParserRule
