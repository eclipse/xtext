/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage;

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
 * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface ContentAssistTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "contentAssistTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/xtext/ui/common/tests/ContentAssist";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "contentAssistTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContentAssistTestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.StartImpl <em>Start</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.StartImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getStart()
   * @generated
   */
  int START = 0;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START__RULES = 0;

  /**
   * The number of structural features of the '<em>Start</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.AbstractRuleImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getAbstractRule()
   * @generated
   */
  int ABSTRACT_RULE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE__NAME = 0;

  /**
   * The number of structural features of the '<em>Abstract Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.FirstAbstractRuleChildImpl <em>First Abstract Rule Child</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.FirstAbstractRuleChildImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getFirstAbstractRuleChild()
   * @generated
   */
  int FIRST_ABSTRACT_RULE_CHILD = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_ABSTRACT_RULE_CHILD__NAME = ABSTRACT_RULE__NAME;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_ABSTRACT_RULE_CHILD__ELEMENTS = ABSTRACT_RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>First Abstract Rule Child</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_ABSTRACT_RULE_CHILD_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.SecondAbstractRuleChildImpl <em>Second Abstract Rule Child</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.SecondAbstractRuleChildImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getSecondAbstractRuleChild()
   * @generated
   */
  int SECOND_ABSTRACT_RULE_CHILD = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_ABSTRACT_RULE_CHILD__NAME = ABSTRACT_RULE__NAME;

  /**
   * The feature id for the '<em><b>Rule</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_ABSTRACT_RULE_CHILD__RULE = ABSTRACT_RULE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Second Abstract Rule Child</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_ABSTRACT_RULE_CHILD_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.AbstractRuleCallImpl <em>Abstract Rule Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.AbstractRuleCallImpl
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getAbstractRuleCall()
   * @generated
   */
  int ABSTRACT_RULE_CALL = 4;

  /**
   * The feature id for the '<em><b>Rule</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE_CALL__RULE = 0;

  /**
   * The number of structural features of the '<em>Abstract Rule Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE_CALL_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.Start <em>Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Start</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.Start
   * @generated
   */
  EClass getStart();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.Start#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.Start#getRules()
   * @see #getStart()
   * @generated
   */
  EReference getStart_Rules();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRule <em>Abstract Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Rule</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRule
   * @generated
   */
  EClass getAbstractRule();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRule#getName()
   * @see #getAbstractRule()
   * @generated
   */
  EAttribute getAbstractRule_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.FirstAbstractRuleChild <em>First Abstract Rule Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>First Abstract Rule Child</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.FirstAbstractRuleChild
   * @generated
   */
  EClass getFirstAbstractRuleChild();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.FirstAbstractRuleChild#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.FirstAbstractRuleChild#getElements()
   * @see #getFirstAbstractRuleChild()
   * @generated
   */
  EReference getFirstAbstractRuleChild_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.SecondAbstractRuleChild <em>Second Abstract Rule Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Second Abstract Rule Child</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.SecondAbstractRuleChild
   * @generated
   */
  EClass getSecondAbstractRuleChild();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.SecondAbstractRuleChild#getRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rule</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.SecondAbstractRuleChild#getRule()
   * @see #getSecondAbstractRuleChild()
   * @generated
   */
  EReference getSecondAbstractRuleChild_Rule();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRuleCall <em>Abstract Rule Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Rule Call</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRuleCall
   * @generated
   */
  EClass getAbstractRuleCall();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRuleCall#getRule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Rule</em>'.
   * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.AbstractRuleCall#getRule()
   * @see #getAbstractRuleCall()
   * @generated
   */
  EReference getAbstractRuleCall_Rule();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ContentAssistTestLanguageFactory getContentAssistTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.StartImpl <em>Start</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.StartImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getStart()
     * @generated
     */
    EClass START = eINSTANCE.getStart();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference START__RULES = eINSTANCE.getStart_Rules();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.AbstractRuleImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getAbstractRule()
     * @generated
     */
    EClass ABSTRACT_RULE = eINSTANCE.getAbstractRule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABSTRACT_RULE__NAME = eINSTANCE.getAbstractRule_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.FirstAbstractRuleChildImpl <em>First Abstract Rule Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.FirstAbstractRuleChildImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getFirstAbstractRuleChild()
     * @generated
     */
    EClass FIRST_ABSTRACT_RULE_CHILD = eINSTANCE.getFirstAbstractRuleChild();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIRST_ABSTRACT_RULE_CHILD__ELEMENTS = eINSTANCE.getFirstAbstractRuleChild_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.SecondAbstractRuleChildImpl <em>Second Abstract Rule Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.SecondAbstractRuleChildImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getSecondAbstractRuleChild()
     * @generated
     */
    EClass SECOND_ABSTRACT_RULE_CHILD = eINSTANCE.getSecondAbstractRuleChild();

    /**
     * The meta object literal for the '<em><b>Rule</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECOND_ABSTRACT_RULE_CHILD__RULE = eINSTANCE.getSecondAbstractRuleChild_Rule();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.AbstractRuleCallImpl <em>Abstract Rule Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.AbstractRuleCallImpl
     * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguagePackageImpl#getAbstractRuleCall()
     * @generated
     */
    EClass ABSTRACT_RULE_CALL = eINSTANCE.getAbstractRuleCall();

    /**
     * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_RULE_CALL__RULE = eINSTANCE.getAbstractRuleCall_Rule();

  }

} //ContentAssistTestLanguagePackage
