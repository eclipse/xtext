/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecoreReference;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferencePackage
 * @generated
 */
public interface EcoreReferenceFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EcoreReferenceFactory eINSTANCE = org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.impl.EcoreReferenceFactoryImpl.init();

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
  EcoreReferencePackage getEcoreReferencePackage();

} //EcoreReferenceFactory
