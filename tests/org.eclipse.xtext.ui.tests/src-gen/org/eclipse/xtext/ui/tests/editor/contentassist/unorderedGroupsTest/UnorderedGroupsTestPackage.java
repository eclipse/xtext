/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.UnorderedGroupsTestFactory
 * @model kind="package"
 * @generated
 */
public interface UnorderedGroupsTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "unorderedGroupsTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/tests/2010/UnorderedGroupsTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "unorderedGroupsTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnorderedGroupsTestPackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__VISIBILITY = 0;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__STATIC = 1;

  /**
   * The feature id for the '<em><b>Synchronized</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SYNCHRONIZED = 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ABSTRACT = 3;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FINAL = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 5;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 6;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getVisibility()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Visibility();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#isStatic()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Static();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#isSynchronized <em>Synchronized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Synchronized</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#isSynchronized()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Synchronized();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#isAbstract()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#isFinal()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UnorderedGroupsTestFactory getUnorderedGroupsTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl.UnorderedGroupsTestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__VISIBILITY = eINSTANCE.getModel_Visibility();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__STATIC = eINSTANCE.getModel_Static();

    /**
     * The meta object literal for the '<em><b>Synchronized</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__SYNCHRONIZED = eINSTANCE.getModel_Synchronized();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__ABSTRACT = eINSTANCE.getModel_Abstract();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__FINAL = eINSTANCE.getModel_Final();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

  }

} //UnorderedGroupsTestPackage
