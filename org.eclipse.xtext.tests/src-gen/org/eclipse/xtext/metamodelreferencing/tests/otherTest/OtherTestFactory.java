/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.otherTest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.metamodelreferencing.tests.otherTest.OtherTestPackage
 * @generated
 */
public interface OtherTestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  OtherTestFactory eINSTANCE = org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl.OtherTestFactoryImpl.init();

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
  OtherTestPackage getOtherTestPackage();

} //OtherTestFactory
