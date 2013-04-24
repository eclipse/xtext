/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug348427TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug348427TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2011/bug348427TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug348427TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug348427TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Element1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENT1 = 0;

  /**
   * The feature id for the '<em><b>Element2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENT2 = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Scenario1Impl <em>Scenario1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Scenario1Impl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getScenario1()
   * @generated
   */
  int SCENARIO1 = 1;

  /**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO1__CHILD = 0;

  /**
   * The number of structural features of the '<em>Scenario1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child1Impl <em>Child1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child1Impl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getChild1()
   * @generated
   */
  int CHILD1 = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD1__NAME = 0;

  /**
   * The feature id for the '<em><b>Bool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD1__BOOL = 1;

  /**
   * The feature id for the '<em><b>Enum Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD1__ENUM_TYPE = 2;

  /**
   * The number of structural features of the '<em>Child1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD1_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Scenario2Impl <em>Scenario2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Scenario2Impl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getScenario2()
   * @generated
   */
  int SCENARIO2 = 3;

  /**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO2__CHILD = 0;

  /**
   * The number of structural features of the '<em>Scenario2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCENARIO2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child2Impl <em>Child2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child2Impl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getChild2()
   * @generated
   */
  int CHILD2 = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD2__NAME = 0;

  /**
   * The feature id for the '<em><b>Bool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD2__BOOL = 1;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD2__STRING = 2;

  /**
   * The number of structural features of the '<em>Child2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD2_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType <em>Enum Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getEnumType()
   * @generated
   */
  int ENUM_TYPE = 5;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model#getElement1 <em>Element1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element1</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model#getElement1()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Element1();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model#getElement2 <em>Element2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element2</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Model#getElement2()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Element2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario1 <em>Scenario1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scenario1</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario1
   * @generated
   */
  EClass getScenario1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario1#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario1#getChild()
   * @see #getScenario1()
   * @generated
   */
  EReference getScenario1_Child();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1 <em>Child1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Child1</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1
   * @generated
   */
  EClass getChild1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#getName()
   * @see #getChild1()
   * @generated
   */
  EAttribute getChild1_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#isBool <em>Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bool</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#isBool()
   * @see #getChild1()
   * @generated
   */
  EAttribute getChild1_Bool();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#getEnumType <em>Enum Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Enum Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1#getEnumType()
   * @see #getChild1()
   * @generated
   */
  EAttribute getChild1_EnumType();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario2 <em>Scenario2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scenario2</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario2
   * @generated
   */
  EClass getScenario2();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario2#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario2#getChild()
   * @see #getScenario2()
   * @generated
   */
  EReference getScenario2_Child();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child2 <em>Child2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Child2</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child2
   * @generated
   */
  EClass getChild2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child2#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child2#getName()
   * @see #getChild2()
   * @generated
   */
  EAttribute getChild2_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child2#isBool <em>Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bool</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child2#isBool()
   * @see #getChild2()
   * @generated
   */
  EAttribute getChild2_Bool();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child2#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child2#getString()
   * @see #getChild2()
   * @generated
   */
  EAttribute getChild2_String();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType <em>Enum Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Enum Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType
   * @generated
   */
  EEnum getEnumType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug348427TestLanguageFactory getBug348427TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Element1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENT1 = eINSTANCE.getModel_Element1();

    /**
     * The meta object literal for the '<em><b>Element2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENT2 = eINSTANCE.getModel_Element2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Scenario1Impl <em>Scenario1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Scenario1Impl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getScenario1()
     * @generated
     */
    EClass SCENARIO1 = eINSTANCE.getScenario1();

    /**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCENARIO1__CHILD = eINSTANCE.getScenario1_Child();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child1Impl <em>Child1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child1Impl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getChild1()
     * @generated
     */
    EClass CHILD1 = eINSTANCE.getChild1();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHILD1__NAME = eINSTANCE.getChild1_Name();

    /**
     * The meta object literal for the '<em><b>Bool</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHILD1__BOOL = eINSTANCE.getChild1_Bool();

    /**
     * The meta object literal for the '<em><b>Enum Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHILD1__ENUM_TYPE = eINSTANCE.getChild1_EnumType();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Scenario2Impl <em>Scenario2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Scenario2Impl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getScenario2()
     * @generated
     */
    EClass SCENARIO2 = eINSTANCE.getScenario2();

    /**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCENARIO2__CHILD = eINSTANCE.getScenario2_Child();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child2Impl <em>Child2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Child2Impl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getChild2()
     * @generated
     */
    EClass CHILD2 = eINSTANCE.getChild2();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHILD2__NAME = eINSTANCE.getChild2_Name();

    /**
     * The meta object literal for the '<em><b>Bool</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHILD2__BOOL = eINSTANCE.getChild2_Bool();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHILD2__STRING = eINSTANCE.getChild2_String();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType <em>Enum Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.EnumType
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.impl.Bug348427TestLanguagePackageImpl#getEnumType()
     * @generated
     */
    EEnum ENUM_TYPE = eINSTANCE.getEnumType();

  }

} //Bug348427TestLanguagePackage
