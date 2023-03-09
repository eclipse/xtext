/**
 */
package org.eclipse.xtext.generator.ecore.second;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.ecore.second.SecondPackage
 * @generated
 */
public interface SecondFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SecondFactory eINSTANCE = org.eclipse.xtext.generator.ecore.second.impl.SecondFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Second</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Second</em>'.
   * @generated
   */
  Second createSecond();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SecondPackage getSecondPackage();

} //SecondFactory
