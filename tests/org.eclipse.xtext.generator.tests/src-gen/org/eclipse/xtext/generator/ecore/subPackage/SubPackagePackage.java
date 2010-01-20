/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.generator.ecore.subPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.xtext.generator.ecore.subPackage.SubPackageFactory
 * @model kind="package"
 * @generated
 */
public interface SubPackagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "subPackage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/SubTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "subPackage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SubPackagePackage eINSTANCE = org.eclipse.xtext.generator.ecore.subPackage.impl.SubPackagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.ecore.subPackage.impl.SubMainImpl <em>Sub Main</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.ecore.subPackage.impl.SubMainImpl
   * @see org.eclipse.xtext.generator.ecore.subPackage.impl.SubPackagePackageImpl#getSubMain()
   * @generated
   */
  int SUB_MAIN = 0;

  /**
   * The feature id for the '<em><b>Super Mains</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_MAIN__SUPER_MAINS = 0;

  /**
   * The number of structural features of the '<em>Sub Main</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_MAIN_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.ecore.subPackage.SubMain <em>Sub Main</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Main</em>'.
   * @see org.eclipse.xtext.generator.ecore.subPackage.SubMain
   * @generated
   */
  EClass getSubMain();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.generator.ecore.subPackage.SubMain#getSuperMains <em>Super Mains</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Super Mains</em>'.
   * @see org.eclipse.xtext.generator.ecore.subPackage.SubMain#getSuperMains()
   * @see #getSubMain()
   * @generated
   */
  EReference getSubMain_SuperMains();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SubPackageFactory getSubPackageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.generator.ecore.subPackage.impl.SubMainImpl <em>Sub Main</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.ecore.subPackage.impl.SubMainImpl
     * @see org.eclipse.xtext.generator.ecore.subPackage.impl.SubPackagePackageImpl#getSubMain()
     * @generated
     */
    EClass SUB_MAIN = eINSTANCE.getSubMain();

    /**
     * The meta object literal for the '<em><b>Super Mains</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUB_MAIN__SUPER_MAINS = eINSTANCE.getSubMain_SuperMains();

  }

} //SubPackagePackage
