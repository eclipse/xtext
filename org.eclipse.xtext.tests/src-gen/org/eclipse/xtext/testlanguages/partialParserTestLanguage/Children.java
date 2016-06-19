/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Children</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getChildren()
 * @model
 * @generated
 */
public interface Children extends Content
{
  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getChildren_Children()
   * @model containment="true"
   * @generated
   */
  EList<Child> getChildren();

} // Children
