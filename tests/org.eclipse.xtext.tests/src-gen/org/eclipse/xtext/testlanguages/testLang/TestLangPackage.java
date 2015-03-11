/**
 */
package org.eclipse.xtext.testlanguages.testLang;

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
 * @see org.eclipse.xtext.testlanguages.testLang.TestLangFactory
 * @model kind="package"
 * @generated
 */
public interface TestLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "testLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/xtext/TestLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "testLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TestLangPackage eINSTANCE = org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.testLang.impl.ModelImpl
   * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Multi Feature</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MULTI_FEATURE = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.testLang.impl.AbstractElementImpl
   * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getAbstractElement()
   * @generated
   */
  int ABSTRACT_ELEMENT = 1;

  /**
   * The number of structural features of the '<em>Abstract Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.ChoiceElementImpl <em>Choice Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.testLang.impl.ChoiceElementImpl
   * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getChoiceElement()
   * @generated
   */
  int CHOICE_ELEMENT = 2;

  /**
   * The feature id for the '<em><b>Optional Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_ELEMENT__OPTIONAL_KEYWORD = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_ELEMENT__NAME = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Choice Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHOICE_ELEMENT_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.ReducibleElementImpl <em>Reducible Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.testLang.impl.ReducibleElementImpl
   * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getReducibleElement()
   * @generated
   */
  int REDUCIBLE_ELEMENT = 3;

  /**
   * The number of structural features of the '<em>Reducible Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REDUCIBLE_ELEMENT_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.TerminalElementImpl <em>Terminal Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.testLang.impl.TerminalElementImpl
   * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getTerminalElement()
   * @generated
   */
  int TERMINAL_ELEMENT = 4;

  /**
   * The feature id for the '<em><b>String Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_ELEMENT__STRING_FEATURE = REDUCIBLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Terminal Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERMINAL_ELEMENT_FEATURE_COUNT = REDUCIBLE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.ReducibleCompositeImpl <em>Reducible Composite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.testLang.impl.ReducibleCompositeImpl
   * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getReducibleComposite()
   * @generated
   */
  int REDUCIBLE_COMPOSITE = 5;

  /**
   * The feature id for the '<em><b>Action Feature</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REDUCIBLE_COMPOSITE__ACTION_FEATURE = REDUCIBLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reducible Composite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REDUCIBLE_COMPOSITE_FEATURE_COUNT = REDUCIBLE_ELEMENT_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.testLang.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.testLang.Model#getMultiFeature <em>Multi Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multi Feature</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.Model#getMultiFeature()
   * @see #getModel()
   * @generated
   */
  EReference getModel_MultiFeature();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.testLang.AbstractElement <em>Abstract Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Element</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.AbstractElement
   * @generated
   */
  EClass getAbstractElement();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.testLang.ChoiceElement <em>Choice Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Choice Element</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.ChoiceElement
   * @generated
   */
  EClass getChoiceElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.testLang.ChoiceElement#isOptionalKeyword <em>Optional Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional Keyword</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.ChoiceElement#isOptionalKeyword()
   * @see #getChoiceElement()
   * @generated
   */
  EAttribute getChoiceElement_OptionalKeyword();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.testLang.ChoiceElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.ChoiceElement#getName()
   * @see #getChoiceElement()
   * @generated
   */
  EAttribute getChoiceElement_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.testLang.ReducibleElement <em>Reducible Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reducible Element</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.ReducibleElement
   * @generated
   */
  EClass getReducibleElement();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.testLang.TerminalElement <em>Terminal Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Terminal Element</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.TerminalElement
   * @generated
   */
  EClass getTerminalElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.testLang.TerminalElement#getStringFeature <em>String Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String Feature</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.TerminalElement#getStringFeature()
   * @see #getTerminalElement()
   * @generated
   */
  EAttribute getTerminalElement_StringFeature();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.testLang.ReducibleComposite <em>Reducible Composite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reducible Composite</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.ReducibleComposite
   * @generated
   */
  EClass getReducibleComposite();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.testLang.ReducibleComposite#getActionFeature <em>Action Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Action Feature</em>'.
   * @see org.eclipse.xtext.testlanguages.testLang.ReducibleComposite#getActionFeature()
   * @see #getReducibleComposite()
   * @generated
   */
  EReference getReducibleComposite_ActionFeature();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TestLangFactory getTestLangFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.testLang.impl.ModelImpl
     * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Multi Feature</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MULTI_FEATURE = eINSTANCE.getModel_MultiFeature();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.testLang.impl.AbstractElementImpl
     * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getAbstractElement()
     * @generated
     */
    EClass ABSTRACT_ELEMENT = eINSTANCE.getAbstractElement();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.ChoiceElementImpl <em>Choice Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.testLang.impl.ChoiceElementImpl
     * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getChoiceElement()
     * @generated
     */
    EClass CHOICE_ELEMENT = eINSTANCE.getChoiceElement();

    /**
     * The meta object literal for the '<em><b>Optional Keyword</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHOICE_ELEMENT__OPTIONAL_KEYWORD = eINSTANCE.getChoiceElement_OptionalKeyword();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHOICE_ELEMENT__NAME = eINSTANCE.getChoiceElement_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.ReducibleElementImpl <em>Reducible Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.testLang.impl.ReducibleElementImpl
     * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getReducibleElement()
     * @generated
     */
    EClass REDUCIBLE_ELEMENT = eINSTANCE.getReducibleElement();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.TerminalElementImpl <em>Terminal Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.testLang.impl.TerminalElementImpl
     * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getTerminalElement()
     * @generated
     */
    EClass TERMINAL_ELEMENT = eINSTANCE.getTerminalElement();

    /**
     * The meta object literal for the '<em><b>String Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TERMINAL_ELEMENT__STRING_FEATURE = eINSTANCE.getTerminalElement_StringFeature();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.testLang.impl.ReducibleCompositeImpl <em>Reducible Composite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.testLang.impl.ReducibleCompositeImpl
     * @see org.eclipse.xtext.testlanguages.testLang.impl.TestLangPackageImpl#getReducibleComposite()
     * @generated
     */
    EClass REDUCIBLE_COMPOSITE = eINSTANCE.getReducibleComposite();

    /**
     * The meta object literal for the '<em><b>Action Feature</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REDUCIBLE_COMPOSITE__ACTION_FEATURE = eINSTANCE.getReducibleComposite_ActionFeature();

  }

} //TestLangPackage
