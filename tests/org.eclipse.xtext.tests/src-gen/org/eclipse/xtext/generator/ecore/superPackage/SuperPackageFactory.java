/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.superPackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.ecore.superPackage.SuperPackagePackage
 * @generated
 */
public interface SuperPackageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SuperPackageFactory eINSTANCE = org.eclipse.xtext.generator.ecore.superPackage.impl.SuperPackageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Super Main</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Super Main</em>'.
   * @generated
   */
  SuperMain createSuperMain();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SuperPackagePackage getSuperPackagePackage();

} //SuperPackageFactory
