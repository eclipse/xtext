/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.superPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.ecore.superPackage.SuperPackageFactory
 * @model kind="package"
 * @generated
 */
public interface SuperPackagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "superPackage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/SuperTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "superPackage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SuperPackagePackage eINSTANCE = org.eclipse.xtext.generator.ecore.superPackage.impl.SuperPackagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.ecore.superPackage.impl.SuperMainImpl <em>Super Main</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.ecore.superPackage.impl.SuperMainImpl
   * @see org.eclipse.xtext.generator.ecore.superPackage.impl.SuperPackagePackageImpl#getSuperMain()
   * @generated
   */
  int SUPER_MAIN = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPER_MAIN__NAME = 0;

  /**
   * The number of structural features of the '<em>Super Main</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUPER_MAIN_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.ecore.superPackage.SuperMain <em>Super Main</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Super Main</em>'.
   * @see org.eclipse.xtext.generator.ecore.superPackage.SuperMain
   * @generated
   */
  EClass getSuperMain();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.ecore.superPackage.SuperMain#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.generator.ecore.superPackage.SuperMain#getName()
   * @see #getSuperMain()
   * @generated
   */
  EAttribute getSuperMain_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SuperPackageFactory getSuperPackageFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.xtext.generator.ecore.superPackage.impl.SuperMainImpl <em>Super Main</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.ecore.superPackage.impl.SuperMainImpl
     * @see org.eclipse.xtext.generator.ecore.superPackage.impl.SuperPackagePackageImpl#getSuperMain()
     * @generated
     */
    EClass SUPER_MAIN = eINSTANCE.getSuperMain();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUPER_MAIN__NAME = eINSTANCE.getSuperMain_Name();

  }

} //SuperPackagePackage
