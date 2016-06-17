/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage
 * @generated
 */
public interface PartialParserTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PartialParserTestLanguageFactory eINSTANCE = org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Some Container</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Some Container</em>'.
   * @generated
   */
  SomeContainer createSomeContainer();

  /**
   * Returns a new object of class '<em>Nested</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nested</em>'.
   * @generated
   */
  Nested createNested();

  /**
   * Returns a new object of class '<em>Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Content</em>'.
   * @generated
   */
  Content createContent();

  /**
   * Returns a new object of class '<em>Children</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Children</em>'.
   * @generated
   */
  Children createChildren();

  /**
   * Returns a new object of class '<em>Child</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Child</em>'.
   * @generated
   */
  Child createChild();

  /**
   * Returns a new object of class '<em>Abstract Children</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Children</em>'.
   * @generated
   */
  AbstractChildren createAbstractChildren();

  /**
   * Returns a new object of class '<em>Abstract Child</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Child</em>'.
   * @generated
   */
  AbstractChild createAbstractChild();

  /**
   * Returns a new object of class '<em>First Concrete</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>First Concrete</em>'.
   * @generated
   */
  FirstConcrete createFirstConcrete();

  /**
   * Returns a new object of class '<em>Second Concrete</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Second Concrete</em>'.
   * @generated
   */
  SecondConcrete createSecondConcrete();

  /**
   * Returns a new object of class '<em>Named</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named</em>'.
   * @generated
   */
  Named createNamed();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PartialParserTestLanguagePackage getPartialParserTestLanguagePackage();

} //PartialParserTestLanguageFactory
