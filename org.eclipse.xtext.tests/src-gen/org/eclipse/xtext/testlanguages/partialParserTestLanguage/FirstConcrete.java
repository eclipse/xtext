/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>First Concrete</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete#getReferencedContainer <em>Referenced Container</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getFirstConcrete()
 * @model
 * @generated
 */
public interface FirstConcrete extends AbstractChild
{
  /**
   * Returns the value of the '<em><b>Referenced Container</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced Container</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced Container</em>' reference.
   * @see #setReferencedContainer(SomeContainer)
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage#getFirstConcrete_ReferencedContainer()
   * @model
   * @generated
   */
  SomeContainer getReferencedContainer();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete#getReferencedContainer <em>Referenced Container</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced Container</em>' reference.
   * @see #getReferencedContainer()
   * @generated
   */
  void setReferencedContainer(SomeContainer value);

} // FirstConcrete
