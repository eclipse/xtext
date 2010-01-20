/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.subPackage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.ecore.subPackage.SubPackagePackage
 * @generated
 */
public interface SubPackageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SubPackageFactory eINSTANCE = org.eclipse.xtext.generator.ecore.subPackage.impl.SubPackageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Sub Main</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sub Main</em>'.
   * @generated
   */
  SubMain createSubMain();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SubPackagePackage getSubPackagePackage();

} //SubPackageFactory
