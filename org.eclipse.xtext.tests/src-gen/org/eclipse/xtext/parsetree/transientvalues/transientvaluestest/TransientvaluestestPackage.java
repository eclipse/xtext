/**
 */
package org.eclipse.xtext.parsetree.transientvalues.transientvaluestest;

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
 * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TransientvaluestestFactory
 * @model kind="package"
 * @generated
 */
public interface TransientvaluestestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "transientvaluestest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://simple/transientvaluestest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "transientvaluestest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TransientvaluestestPackage eINSTANCE = org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.RootImpl
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestPackageImpl#getRoot()
   * @generated
   */
  int ROOT = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestRequiredImpl <em>Test Required</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestRequiredImpl
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestPackageImpl#getTestRequired()
   * @generated
   */
  int TEST_REQUIRED = 1;

  /**
   * The feature id for the '<em><b>Required1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_REQUIRED__REQUIRED1 = ROOT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Required2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_REQUIRED__REQUIRED2 = ROOT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Test Required</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_REQUIRED_FEATURE_COUNT = ROOT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestOptionalImpl <em>Test Optional</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestOptionalImpl
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestPackageImpl#getTestOptional()
   * @generated
   */
  int TEST_OPTIONAL = 2;

  /**
   * The feature id for the '<em><b>Opt1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_OPTIONAL__OPT1 = ROOT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Opt2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_OPTIONAL__OPT2 = ROOT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Test Optional</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_OPTIONAL_FEATURE_COUNT = ROOT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestListImpl <em>Test List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestListImpl
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestPackageImpl#getTestList()
   * @generated
   */
  int TEST_LIST = 3;

  /**
   * The feature id for the '<em><b>Item</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LIST__ITEM = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Test List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LIST_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestRequired <em>Test Required</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Required</em>'.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestRequired
   * @generated
   */
  EClass getTestRequired();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestRequired#getRequired1 <em>Required1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required1</em>'.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestRequired#getRequired1()
   * @see #getTestRequired()
   * @generated
   */
  EAttribute getTestRequired_Required1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestRequired#getRequired2 <em>Required2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required2</em>'.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestRequired#getRequired2()
   * @see #getTestRequired()
   * @generated
   */
  EAttribute getTestRequired_Required2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestOptional <em>Test Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Optional</em>'.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestOptional
   * @generated
   */
  EClass getTestOptional();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestOptional#getOpt1 <em>Opt1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Opt1</em>'.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestOptional#getOpt1()
   * @see #getTestOptional()
   * @generated
   */
  EAttribute getTestOptional_Opt1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestOptional#getOpt2 <em>Opt2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Opt2</em>'.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestOptional#getOpt2()
   * @see #getTestOptional()
   * @generated
   */
  EAttribute getTestOptional_Opt2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestList <em>Test List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test List</em>'.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestList
   * @generated
   */
  EClass getTestList();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestList#getItem <em>Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Item</em>'.
   * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.TestList#getItem()
   * @see #getTestList()
   * @generated
   */
  EAttribute getTestList_Item();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TransientvaluestestFactory getTransientvaluestestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.RootImpl
     * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestPackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestRequiredImpl <em>Test Required</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestRequiredImpl
     * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestPackageImpl#getTestRequired()
     * @generated
     */
    EClass TEST_REQUIRED = eINSTANCE.getTestRequired();

    /**
     * The meta object literal for the '<em><b>Required1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_REQUIRED__REQUIRED1 = eINSTANCE.getTestRequired_Required1();

    /**
     * The meta object literal for the '<em><b>Required2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_REQUIRED__REQUIRED2 = eINSTANCE.getTestRequired_Required2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestOptionalImpl <em>Test Optional</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestOptionalImpl
     * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestPackageImpl#getTestOptional()
     * @generated
     */
    EClass TEST_OPTIONAL = eINSTANCE.getTestOptional();

    /**
     * The meta object literal for the '<em><b>Opt1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_OPTIONAL__OPT1 = eINSTANCE.getTestOptional_Opt1();

    /**
     * The meta object literal for the '<em><b>Opt2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_OPTIONAL__OPT2 = eINSTANCE.getTestOptional_Opt2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestListImpl <em>Test List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TestListImpl
     * @see org.eclipse.xtext.parsetree.transientvalues.transientvaluestest.impl.TransientvaluestestPackageImpl#getTestList()
     * @generated
     */
    EClass TEST_LIST = eINSTANCE.getTestList();

    /**
     * The meta object literal for the '<em><b>Item</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_LIST__ITEM = eINSTANCE.getTestList_Item();

  }

} //TransientvaluestestPackage
