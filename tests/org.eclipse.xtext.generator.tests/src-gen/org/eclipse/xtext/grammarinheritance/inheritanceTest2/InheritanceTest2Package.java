/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.grammarinheritance.inheritanceTest2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
   * The meta object id for the '{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelXImpl <em>Model X</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelXImpl
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.InheritanceTest2PackageImpl#getModelX()
   * @generated
   */
  int MODEL_X = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_X__NAME = InheritanceTestPackage.ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Elements2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_X__ELEMENTS2 = InheritanceTestPackage.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ids</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_X__IDS = InheritanceTestPackage.ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Model X</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_X_FEATURE_COUNT = InheritanceTestPackage.ELEMENT_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX <em>Model X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model X</em>'.
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX
   * @generated
   */
  EClass getModelX();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX#getElements2 <em>Elements2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements2</em>'.
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX#getElements2()
   * @see #getModelX()
   * @generated
   */
  EReference getModelX_Elements2();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX#getIds <em>Ids</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ids</em>'.
   * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.ModelX#getIds()
   * @see #getModelX()
   * @generated
   */
  EAttribute getModelX_Ids();

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
     * The meta object literal for the '{@link org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelXImpl <em>Model X</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.ModelXImpl
     * @see org.eclipse.xtext.grammarinheritance.inheritanceTest2.impl.InheritanceTest2PackageImpl#getModelX()
     * @generated
     */
    EClass MODEL_X = eINSTANCE.getModelX();

    /**
     * The meta object literal for the '<em><b>Elements2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_X__ELEMENTS2 = eINSTANCE.getModelX_Elements2();

    /**
     * The meta object literal for the '<em><b>Ids</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_X__IDS = eINSTANCE.getModelX_Ids();

  }

} //InheritanceTest2Package
