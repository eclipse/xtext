/**
 */
package org.eclipse.xtext.parser.fragments.fragmentTestLanguage;

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
 * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.FragmentTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface FragmentTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "fragmentTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2015/tmf/xtext/fragments";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fragmentTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FragmentTestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.FragmentTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.ParserRuleFragmentsImpl <em>Parser Rule Fragments</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.ParserRuleFragmentsImpl
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.FragmentTestLanguagePackageImpl#getParserRuleFragments()
   * @generated
   */
  int PARSER_RULE_FRAGMENTS = 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE_FRAGMENTS__ELEMENT = 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE_FRAGMENTS__REF = 1;

  /**
   * The number of structural features of the '<em>Parser Rule Fragments</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARSER_RULE_FRAGMENTS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedImpl <em>PRF Named</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedImpl
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.FragmentTestLanguagePackageImpl#getPRFNamed()
   * @generated
   */
  int PRF_NAMED = 1;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRF_NAMED__REF = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRF_NAMED__NAME = 1;

  /**
   * The number of structural features of the '<em>PRF Named</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRF_NAMED_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedWithActionImpl <em>PRF Named With Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedWithActionImpl
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.FragmentTestLanguagePackageImpl#getPRFNamedWithAction()
   * @generated
   */
  int PRF_NAMED_WITH_ACTION = 2;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRF_NAMED_WITH_ACTION__REF = PRF_NAMED__REF;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRF_NAMED_WITH_ACTION__NAME = PRF_NAMED__NAME;

  /**
   * The feature id for the '<em><b>Prev</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRF_NAMED_WITH_ACTION__PREV = PRF_NAMED_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRF_NAMED_WITH_ACTION__REF2 = PRF_NAMED_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>PRF Named With Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRF_NAMED_WITH_ACTION_FEATURE_COUNT = PRF_NAMED_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments <em>Parser Rule Fragments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parser Rule Fragments</em>'.
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments
   * @generated
   */
  EClass getParserRuleFragments();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments#getElement()
   * @see #getParserRuleFragments()
   * @generated
   */
  EReference getParserRuleFragments_Element();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.ParserRuleFragments#getRef()
   * @see #getParserRuleFragments()
   * @generated
   */
  EReference getParserRuleFragments_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed <em>PRF Named</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PRF Named</em>'.
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed
   * @generated
   */
  EClass getPRFNamed();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed#getRef()
   * @see #getPRFNamed()
   * @generated
   */
  EReference getPRFNamed_Ref();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamed#getName()
   * @see #getPRFNamed()
   * @generated
   */
  EAttribute getPRFNamed_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction <em>PRF Named With Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>PRF Named With Action</em>'.
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction
   * @generated
   */
  EClass getPRFNamedWithAction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction#getPrev <em>Prev</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Prev</em>'.
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction#getPrev()
   * @see #getPRFNamedWithAction()
   * @generated
   */
  EReference getPRFNamedWithAction_Prev();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction#getRef2 <em>Ref2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref2</em>'.
   * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.PRFNamedWithAction#getRef2()
   * @see #getPRFNamedWithAction()
   * @generated
   */
  EReference getPRFNamedWithAction_Ref2();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FragmentTestLanguageFactory getFragmentTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.ParserRuleFragmentsImpl <em>Parser Rule Fragments</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.ParserRuleFragmentsImpl
     * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.FragmentTestLanguagePackageImpl#getParserRuleFragments()
     * @generated
     */
    EClass PARSER_RULE_FRAGMENTS = eINSTANCE.getParserRuleFragments();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARSER_RULE_FRAGMENTS__ELEMENT = eINSTANCE.getParserRuleFragments_Element();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARSER_RULE_FRAGMENTS__REF = eINSTANCE.getParserRuleFragments_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedImpl <em>PRF Named</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedImpl
     * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.FragmentTestLanguagePackageImpl#getPRFNamed()
     * @generated
     */
    EClass PRF_NAMED = eINSTANCE.getPRFNamed();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRF_NAMED__REF = eINSTANCE.getPRFNamed_Ref();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRF_NAMED__NAME = eINSTANCE.getPRFNamed_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedWithActionImpl <em>PRF Named With Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.PRFNamedWithActionImpl
     * @see org.eclipse.xtext.parser.fragments.fragmentTestLanguage.impl.FragmentTestLanguagePackageImpl#getPRFNamedWithAction()
     * @generated
     */
    EClass PRF_NAMED_WITH_ACTION = eINSTANCE.getPRFNamedWithAction();

    /**
     * The meta object literal for the '<em><b>Prev</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRF_NAMED_WITH_ACTION__PREV = eINSTANCE.getPRFNamedWithAction_Prev();

    /**
     * The meta object literal for the '<em><b>Ref2</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRF_NAMED_WITH_ACTION__REF2 = eINSTANCE.getPRFNamedWithAction_Ref2();

  }

} //FragmentTestLanguagePackage
