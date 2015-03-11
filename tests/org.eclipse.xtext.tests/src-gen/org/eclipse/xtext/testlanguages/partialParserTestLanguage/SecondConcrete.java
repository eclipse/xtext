/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Second Concrete</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete#getReferencedChildren <em>Referenced Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getSecondConcrete()
 * @model
 * @generated
 */
public interface SecondConcrete extends AbstractChild
{
  /**
   * Returns the value of the '<em><b>Referenced Children</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced Children</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Children</em>' reference list.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getSecondConcrete_ReferencedChildren()
   * @model
   * @generated
   */
  EList<Child> getReferencedChildren();

} // SecondConcrete
