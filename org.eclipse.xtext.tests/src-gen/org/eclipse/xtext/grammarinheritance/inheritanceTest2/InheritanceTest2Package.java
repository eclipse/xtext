/**
 */
package org.eclipse.xtext.grammarinheritance.inheritanceTest2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.xtext.grammarinheritance.inheritanceTest.InheritanceTestPackage;

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
 * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.InheritanceTest2Factory
 * @model kind="package"
 * @generated
 */
public interface InheritanceTest2Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "inheritanceTest2";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/InheritanceTest2Language";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "inheritanceTest2";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  InheritanceTest2Package eINSTANCE = org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.InheritanceTest2PackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelImpl
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.InheritanceTest2PackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = InheritanceTestPackage.MODEL__NAME;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENTS = InheritanceTestPackage.MODEL__ELEMENTS;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IDS = InheritanceTestPackage.MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = InheritanceTestPackage.MODEL_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.Model#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ids</em>'.
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.Model#getIds()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Ids();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  InheritanceTest2Factory getInheritanceTest2Factory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelImpl
     * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.InheritanceTest2PackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__IDS = eINSTANCE.getModel_Ids();

  }

} //InheritanceTest2Package
