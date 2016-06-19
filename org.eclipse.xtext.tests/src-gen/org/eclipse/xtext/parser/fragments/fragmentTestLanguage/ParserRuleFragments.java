/**
 */
package org.eclipse.xtext.parser.fragments.fragmentTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser Rule Fragments</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.FragmentTestLanguagePackage#getParserRuleFragments()
 * @model
 * @generated
 */
public interface ParserRuleFragments extends EObject
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(PRFNamed)
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.FragmentTestLanguagePackage#getParserRuleFragments_Element()
   * @model containment="true"
   * @generated
   */
  PRFNamed getElement();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(PRFNamed value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(PRFNamed)
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.FragmentTestLanguagePackage#getParserRuleFragments_Ref()
   * @model
   * @generated
   */
  PRFNamed getRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(PRFNamed value);

} // ParserRuleFragments
