/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Children</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren#getAbstractChildren <em>Abstract Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getAbstractChildren()
 * @model
 * @generated
 */
public interface AbstractChildren extends Content
{
  /**
   * Returns the value of the '<em><b>Abstract Children</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChild}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract Children</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getAbstractChildren_AbstractChildren()
   * @model containment="true"
   * @generated
   */
  EList<AbstractChild> getAbstractChildren();

} // AbstractChildren
