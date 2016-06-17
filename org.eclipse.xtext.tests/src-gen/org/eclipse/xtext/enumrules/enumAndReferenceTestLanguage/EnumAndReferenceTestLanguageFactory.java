/**
 */
package org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage
 * @generated
 */
public interface EnumAndReferenceTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EnumAndReferenceTestLanguageFactory eINSTANCE = org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.impl.EnumAndReferenceTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Entity With Enum And Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entity With Enum And Reference</em>'.
   * @generated
   */
  EntityWithEnumAndReference createEntityWithEnumAndReference();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EnumAndReferenceTestLanguagePackage getEnumAndReferenceTestLanguagePackage();

} //EnumAndReferenceTestLanguageFactory
