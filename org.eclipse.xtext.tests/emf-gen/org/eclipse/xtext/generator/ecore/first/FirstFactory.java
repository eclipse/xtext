/**
 */
package org.eclipse.xtext.generator.ecore.first;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.ecore.first.FirstPackage
 * @generated
 */
public interface FirstFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FirstFactory eINSTANCE = org.eclipse.xtext.generator.ecore.first.impl.FirstFactoryImpl.init();

  /**
   * Returns a new object of class '<em>First</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>First</em>'.
   * @generated
   */
  First createFirst();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FirstPackage getFirstPackage();

} //FirstFactory
