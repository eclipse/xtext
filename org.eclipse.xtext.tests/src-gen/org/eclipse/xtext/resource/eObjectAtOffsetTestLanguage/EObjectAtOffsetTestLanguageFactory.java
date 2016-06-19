/**
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguagePackage
 * @generated
 */
public interface EObjectAtOffsetTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EObjectAtOffsetTestLanguageFactory eINSTANCE = org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Abstract Bar</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Bar</em>'.
   * @generated
   */
  AbstractBar createAbstractBar();

  /**
   * Returns a new object of class '<em>Bar</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bar</em>'.
   * @generated
   */
  Bar createBar();

  /**
   * Returns a new object of class '<em>Foo</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Foo</em>'.
   * @generated
   */
  Foo createFoo();

  /**
   * Returns a new object of class '<em>Foo Bar</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Foo Bar</em>'.
   * @generated
   */
  FooBar createFooBar();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  EObjectAtOffsetTestLanguagePackage getEObjectAtOffsetTestLanguagePackage();

} //EObjectAtOffsetTestLanguageFactory
