/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestPackage
 * @generated
 */
public interface AnotherSimpleTestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AnotherSimpleTestFactory eINSTANCE = org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl.AnotherSimpleTestFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Foo</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Foo</em>'.
   * @generated
   */
  Foo createFoo();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AnotherSimpleTestPackage getAnotherSimpleTestPackage();

} //AnotherSimpleTestFactory
