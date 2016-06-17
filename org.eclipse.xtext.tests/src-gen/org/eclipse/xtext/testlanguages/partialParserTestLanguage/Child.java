/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getChild()
 * @model
 * @generated
 */
public interface Child extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Named)
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getChild_Value()
   * @model containment="true"
   * @generated
   */
  Named getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Named value);

} // Child
