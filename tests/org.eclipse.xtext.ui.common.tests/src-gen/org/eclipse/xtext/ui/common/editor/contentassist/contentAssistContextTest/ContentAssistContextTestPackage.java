/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ContentAssistContextTestFactory
 * @model kind="package"
 * @generated
 */
public interface ContentAssistContextTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "contentAssistContextTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/tmf/tests/2009/contentAssistContextTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "contentAssistContextTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContentAssistContextTestPackage eINSTANCE = org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.FirstLevelImpl <em>First Level</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.FirstLevelImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getFirstLevel()
   * @generated
   */
  int FIRST_LEVEL = 0;

  /**
   * The feature id for the '<em><b>Second Level A</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_LEVEL__SECOND_LEVEL_A = 0;

  /**
   * The feature id for the '<em><b>Second Level B</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_LEVEL__SECOND_LEVEL_B = 1;

  /**
   * The number of structural features of the '<em>First Level</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_LEVEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelAImpl <em>Second Level A</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelAImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getSecondLevelA()
   * @generated
   */
  int SECOND_LEVEL_A = 1;

  /**
   * The feature id for the '<em><b>Third Level A1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_LEVEL_A__THIRD_LEVEL_A1 = 0;

  /**
   * The feature id for the '<em><b>Third Level A2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_LEVEL_A__THIRD_LEVEL_A2 = 1;

  /**
   * The number of structural features of the '<em>Second Level A</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_LEVEL_A_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelBImpl <em>Second Level B</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelBImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getSecondLevelB()
   * @generated
   */
  int SECOND_LEVEL_B = 2;

  /**
   * The feature id for the '<em><b>Third Level B1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_LEVEL_B__THIRD_LEVEL_B1 = 0;

  /**
   * The feature id for the '<em><b>Third Level B2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_LEVEL_B__THIRD_LEVEL_B2 = 1;

  /**
   * The number of structural features of the '<em>Second Level B</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_LEVEL_B_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelA1Impl <em>Third Level A1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelA1Impl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getThirdLevelA1()
   * @generated
   */
  int THIRD_LEVEL_A1 = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_A1__NAME = 0;

  /**
   * The number of structural features of the '<em>Third Level A1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_A1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelA2Impl <em>Third Level A2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelA2Impl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getThirdLevelA2()
   * @generated
   */
  int THIRD_LEVEL_A2 = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_A2__NAME = 0;

  /**
   * The number of structural features of the '<em>Third Level A2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_A2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelB1Impl <em>Third Level B1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelB1Impl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getThirdLevelB1()
   * @generated
   */
  int THIRD_LEVEL_B1 = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_B1__NAME = 0;

  /**
   * The number of structural features of the '<em>Third Level B1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_B1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelB2Impl <em>Third Level B2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelB2Impl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getThirdLevelB2()
   * @generated
   */
  int THIRD_LEVEL_B2 = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_B2__NAME = 0;

  /**
   * The number of structural features of the '<em>Third Level B2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_B2_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.FirstLevel <em>First Level</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>First Level</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.FirstLevel
   * @generated
   */
  EClass getFirstLevel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.FirstLevel#getSecondLevelA <em>Second Level A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Second Level A</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.FirstLevel#getSecondLevelA()
   * @see #getFirstLevel()
   * @generated
   */
  EReference getFirstLevel_SecondLevelA();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.FirstLevel#getSecondLevelB <em>Second Level B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Second Level B</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.FirstLevel#getSecondLevelB()
   * @see #getFirstLevel()
   * @generated
   */
  EReference getFirstLevel_SecondLevelB();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA <em>Second Level A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Second Level A</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA
   * @generated
   */
  EClass getSecondLevelA();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA#getThirdLevelA1 <em>Third Level A1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Third Level A1</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA#getThirdLevelA1()
   * @see #getSecondLevelA()
   * @generated
   */
  EReference getSecondLevelA_ThirdLevelA1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA#getThirdLevelA2 <em>Third Level A2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Third Level A2</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelA#getThirdLevelA2()
   * @see #getSecondLevelA()
   * @generated
   */
  EReference getSecondLevelA_ThirdLevelA2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelB <em>Second Level B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Second Level B</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelB
   * @generated
   */
  EClass getSecondLevelB();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelB#getThirdLevelB1 <em>Third Level B1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Third Level B1</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelB#getThirdLevelB1()
   * @see #getSecondLevelB()
   * @generated
   */
  EReference getSecondLevelB_ThirdLevelB1();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelB#getThirdLevelB2 <em>Third Level B2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Third Level B2</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.SecondLevelB#getThirdLevelB2()
   * @see #getSecondLevelB()
   * @generated
   */
  EReference getSecondLevelB_ThirdLevelB2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA1 <em>Third Level A1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Third Level A1</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA1
   * @generated
   */
  EClass getThirdLevelA1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA1#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA1#getName()
   * @see #getThirdLevelA1()
   * @generated
   */
  EAttribute getThirdLevelA1_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA2 <em>Third Level A2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Third Level A2</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA2
   * @generated
   */
  EClass getThirdLevelA2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA2#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelA2#getName()
   * @see #getThirdLevelA2()
   * @generated
   */
  EAttribute getThirdLevelA2_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelB1 <em>Third Level B1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Third Level B1</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelB1
   * @generated
   */
  EClass getThirdLevelB1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelB1#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelB1#getName()
   * @see #getThirdLevelB1()
   * @generated
   */
  EAttribute getThirdLevelB1_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelB2 <em>Third Level B2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Third Level B2</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelB2
   * @generated
   */
  EClass getThirdLevelB2();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelB2#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.ThirdLevelB2#getName()
   * @see #getThirdLevelB2()
   * @generated
   */
  EAttribute getThirdLevelB2_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ContentAssistContextTestFactory getContentAssistContextTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.FirstLevelImpl <em>First Level</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.FirstLevelImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getFirstLevel()
     * @generated
     */
    EClass FIRST_LEVEL = eINSTANCE.getFirstLevel();

    /**
     * The meta object literal for the '<em><b>Second Level A</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIRST_LEVEL__SECOND_LEVEL_A = eINSTANCE.getFirstLevel_SecondLevelA();

    /**
     * The meta object literal for the '<em><b>Second Level B</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIRST_LEVEL__SECOND_LEVEL_B = eINSTANCE.getFirstLevel_SecondLevelB();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelAImpl <em>Second Level A</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelAImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getSecondLevelA()
     * @generated
     */
    EClass SECOND_LEVEL_A = eINSTANCE.getSecondLevelA();

    /**
     * The meta object literal for the '<em><b>Third Level A1</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECOND_LEVEL_A__THIRD_LEVEL_A1 = eINSTANCE.getSecondLevelA_ThirdLevelA1();

    /**
     * The meta object literal for the '<em><b>Third Level A2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECOND_LEVEL_A__THIRD_LEVEL_A2 = eINSTANCE.getSecondLevelA_ThirdLevelA2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelBImpl <em>Second Level B</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.SecondLevelBImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getSecondLevelB()
     * @generated
     */
    EClass SECOND_LEVEL_B = eINSTANCE.getSecondLevelB();

    /**
     * The meta object literal for the '<em><b>Third Level B1</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECOND_LEVEL_B__THIRD_LEVEL_B1 = eINSTANCE.getSecondLevelB_ThirdLevelB1();

    /**
     * The meta object literal for the '<em><b>Third Level B2</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECOND_LEVEL_B__THIRD_LEVEL_B2 = eINSTANCE.getSecondLevelB_ThirdLevelB2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelA1Impl <em>Third Level A1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelA1Impl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getThirdLevelA1()
     * @generated
     */
    EClass THIRD_LEVEL_A1 = eINSTANCE.getThirdLevelA1();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THIRD_LEVEL_A1__NAME = eINSTANCE.getThirdLevelA1_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelA2Impl <em>Third Level A2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelA2Impl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getThirdLevelA2()
     * @generated
     */
    EClass THIRD_LEVEL_A2 = eINSTANCE.getThirdLevelA2();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THIRD_LEVEL_A2__NAME = eINSTANCE.getThirdLevelA2_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelB1Impl <em>Third Level B1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelB1Impl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getThirdLevelB1()
     * @generated
     */
    EClass THIRD_LEVEL_B1 = eINSTANCE.getThirdLevelB1();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THIRD_LEVEL_B1__NAME = eINSTANCE.getThirdLevelB1_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelB2Impl <em>Third Level B2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ThirdLevelB2Impl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.contentAssistContextTest.impl.ContentAssistContextTestPackageImpl#getThirdLevelB2()
     * @generated
     */
    EClass THIRD_LEVEL_B2 = eINSTANCE.getThirdLevelB2();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THIRD_LEVEL_B2__NAME = eINSTANCE.getThirdLevelB2_Name();

  }

} //ContentAssistContextTestPackage
