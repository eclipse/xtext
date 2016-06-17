/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.simpleTest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.metamodelreferencing.tests.simpleTest.SimpleTestPackage
 * @generated
 */
public interface SimpleTestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SimpleTestFactory eINSTANCE = org.eclipse.xtext.metamodelreferencing.tests.simpleTest.impl.SimpleTestFactoryImpl.init();

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
  SimpleTestPackage getSimpleTestPackage();

} //SimpleTestFactory
