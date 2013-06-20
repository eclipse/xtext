/**
 */
package org.eclipse.xtext.grammarinheritance.inheritanceTest2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Package
 * @generated
 */
public interface InheritanceTest2Factory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  InheritanceTest2Factory eINSTANCE = org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.InheritanceTest2FactoryImpl.init();

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
  InheritanceTest2Package getInheritanceTest2Package();

} //InheritanceTest2Factory
