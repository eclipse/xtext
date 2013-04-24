/**
 */
package org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguagePackage
 * @generated
 */
public interface UnorderedGroupsTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnorderedGroupsTestLanguageFactory eINSTANCE = org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedGroupsTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Nested Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nested Model</em>'.
   * @generated
   */
  NestedModel createNestedModel();

  /**
   * Returns a new object of class '<em>Unordered Serialization</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unordered Serialization</em>'.
   * @generated
   */
  UnorderedSerialization createUnorderedSerialization();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UnorderedGroupsTestLanguagePackage getUnorderedGroupsTestLanguagePackage();

} //UnorderedGroupsTestLanguageFactory
