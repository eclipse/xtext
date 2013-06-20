/**
 */
package org.eclipse.xtext.linking.ignoreCaseImportsTest;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.linking.ignoreCaseLinkingTest.IgnoreCaseLinkingTestPackage;

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
 * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.IgnoreCaseImportsTestFactory
 * @model kind="package"
 * @generated
 */
public interface IgnoreCaseImportsTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "ignoreCaseImportsTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://eclipse.org/xtext/ignoreCaseImportsTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "ignoreCaseImportsTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IgnoreCaseImportsTestPackage eINSTANCE = org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.IgnoreCaseImportsTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.ModelImpl
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.IgnoreCaseImportsTestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENTS = IgnoreCaseLinkingTestPackage.MODEL__ELEMENTS;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPORTS = IgnoreCaseLinkingTestPackage.MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = IgnoreCaseLinkingTestPackage.MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.ImportImpl
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.IgnoreCaseImportsTestPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORT_URI = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.ignoreCaseImportsTest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.linking.ignoreCaseImportsTest.Model#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.Model#getImports()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Imports();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.ignoreCaseImportsTest.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.linking.ignoreCaseImportsTest.Import#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.Import#getImportURI()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportURI();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  IgnoreCaseImportsTestFactory getIgnoreCaseImportsTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.ModelImpl
     * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.IgnoreCaseImportsTestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPORTS = eINSTANCE.getModel_Imports();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.ImportImpl
     * @see org.eclipse.xtext.linking.ignoreCaseImportsTest.impl.IgnoreCaseImportsTestPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORT_URI = eINSTANCE.getImport_ImportURI();

  }

} //IgnoreCaseImportsTestPackage
