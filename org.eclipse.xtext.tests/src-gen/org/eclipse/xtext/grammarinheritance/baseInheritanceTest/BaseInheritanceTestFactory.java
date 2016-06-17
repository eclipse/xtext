/**
 */
package org.eclipse.xtext.grammarinheritance.baseInheritanceTest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.grammarinheritance.baseInheritanceTest.BaseInheritanceTestPackage
 * @generated
 */
public interface BaseInheritanceTestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BaseInheritanceTestFactory eINSTANCE = org.eclipse.xtext.grammarinheritance.baseInheritanceTest.impl.BaseInheritanceTestFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  BaseInheritanceTestPackage getBaseInheritanceTestPackage();

} //BaseInheritanceTestFactory
