/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Bug307519TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug307519TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug307519TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2010/bug307519TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug307519TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug307519TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Bug307519TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Bug307519TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>E1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__E1 = 0;

  /**
   * The feature id for the '<em><b>E2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__E2 = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Elem1Impl <em>Elem1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Elem1Impl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Bug307519TestLanguagePackageImpl#getElem1()
   * @generated
   */
  int ELEM1 = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEM1__VALUE = 0;

  /**
   * The number of structural features of the '<em>Elem1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEM1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Elem2Impl <em>Elem2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Elem2Impl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Bug307519TestLanguagePackageImpl#getElem2()
   * @generated
   */
  int ELEM2 = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEM2__VALUE = 0;

  /**
   * The number of structural features of the '<em>Elem2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEM2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.EnumT <em>Enum T</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.EnumT
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Bug307519TestLanguagePackageImpl#getEnumT()
   * @generated
   */
  int ENUM_T = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Model#getE1 <em>E1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>E1</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Model#getE1()
   * @see #getModel()
   * @generated
   */
  EReference getModel_E1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Model#getE2 <em>E2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>E2</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Model#getE2()
   * @see #getModel()
   * @generated
   */
  EReference getModel_E2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem1 <em>Elem1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Elem1</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem1
   * @generated
   */
  EClass getElem1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem1#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem1#getValue()
   * @see #getElem1()
   * @generated
   */
  EAttribute getElem1_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem2 <em>Elem2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Elem2</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem2
   * @generated
   */
  EClass getElem2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem2#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.Elem2#getValue()
   * @see #getElem2()
   * @generated
   */
  EAttribute getElem2_Value();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.EnumT <em>Enum T</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Enum T</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.EnumT
   * @generated
   */
  EEnum getEnumT();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug307519TestLanguageFactory getBug307519TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Bug307519TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>E1</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__E1 = eINSTANCE.getModel_E1();

    /**
     * The meta object literal for the '<em><b>E2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__E2 = eINSTANCE.getModel_E2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Elem1Impl <em>Elem1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Elem1Impl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Bug307519TestLanguagePackageImpl#getElem1()
     * @generated
     */
    EClass ELEM1 = eINSTANCE.getElem1();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEM1__VALUE = eINSTANCE.getElem1_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Elem2Impl <em>Elem2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Elem2Impl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Bug307519TestLanguagePackageImpl#getElem2()
     * @generated
     */
    EClass ELEM2 = eINSTANCE.getElem2();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEM2__VALUE = eINSTANCE.getElem2_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.EnumT <em>Enum T</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.EnumT
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug307519TestLanguage.impl.Bug307519TestLanguagePackageImpl#getEnumT()
     * @generated
     */
    EEnum ENUM_T = eINSTANCE.getEnumT();

  }

} //Bug307519TestLanguagePackage
