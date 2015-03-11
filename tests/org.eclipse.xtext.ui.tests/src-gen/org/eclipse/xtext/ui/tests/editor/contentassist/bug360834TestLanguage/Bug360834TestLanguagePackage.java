/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Bug360834TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug360834TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug360834TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2011/bug360834TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug360834TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug360834TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENT = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.AlternativeImpl <em>Alternative</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.AlternativeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getAlternative()
   * @generated
   */
  int ALTERNATIVE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVE__NAME = 0;

  /**
   * The feature id for the '<em><b>Root Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVE__ROOT_DECLARATION = 1;

  /**
   * The number of structural features of the '<em>Alternative</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALTERNATIVE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.RecursiveClassDeclarationImpl <em>Recursive Class Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.RecursiveClassDeclarationImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getRecursiveClassDeclaration()
   * @generated
   */
  int RECURSIVE_CLASS_DECLARATION = 2;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECURSIVE_CLASS_DECLARATION__MODIFIERS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECURSIVE_CLASS_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECURSIVE_CLASS_DECLARATION__MEMBERS = 2;

  /**
   * The number of structural features of the '<em>Recursive Class Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECURSIVE_CLASS_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedModifiersImpl <em>Unordered Modifiers</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedModifiersImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getUnorderedModifiers()
   * @generated
   */
  int UNORDERED_MODIFIERS = 7;

  /**
   * The number of structural features of the '<em>Unordered Modifiers</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_MODIFIERS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ModifiersImpl <em>Modifiers</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ModifiersImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getModifiers()
   * @generated
   */
  int MODIFIERS = 3;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIERS__FINAL = UNORDERED_MODIFIERS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIERS__ABSTRACT = UNORDERED_MODIFIERS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Extern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIERS__EXTERN = UNORDERED_MODIFIERS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIERS__VISIBILITY = UNORDERED_MODIFIERS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Modifiers</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODIFIERS_FEATURE_COUNT = UNORDERED_MODIFIERS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedImpl <em>Unordered</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getUnordered()
   * @generated
   */
  int UNORDERED = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED__NAME = 0;

  /**
   * The feature id for the '<em><b>Root Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED__ROOT_DECLARATION = 1;

  /**
   * The number of structural features of the '<em>Unordered</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.SimpleClassDeclarationImpl <em>Simple Class Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.SimpleClassDeclarationImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getSimpleClassDeclaration()
   * @generated
   */
  int SIMPLE_CLASS_DECLARATION = 5;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_CLASS_DECLARATION__MODIFIERS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_CLASS_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_CLASS_DECLARATION__MEMBERS = 2;

  /**
   * The number of structural features of the '<em>Simple Class Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_CLASS_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ClassMemberImpl <em>Class Member</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ClassMemberImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getClassMember()
   * @generated
   */
  int CLASS_MEMBER = 6;

  /**
   * The feature id for the '<em><b>Modifiers</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MEMBER__MODIFIERS = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MEMBER__NAME = 1;

  /**
   * The number of structural features of the '<em>Class Member</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MEMBER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Visibility <em>Visibility</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Visibility
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getVisibility()
   * @generated
   */
  int VISIBILITY = 8;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Model#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Model#getElement()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Alternative <em>Alternative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alternative</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Alternative
   * @generated
   */
  EClass getAlternative();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Alternative#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Alternative#getName()
   * @see #getAlternative()
   * @generated
   */
  EAttribute getAlternative_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Alternative#getRootDeclaration <em>Root Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Root Declaration</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Alternative#getRootDeclaration()
   * @see #getAlternative()
   * @generated
   */
  EReference getAlternative_RootDeclaration();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration <em>Recursive Class Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Recursive Class Declaration</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration
   * @generated
   */
  EClass getRecursiveClassDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modifiers</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration#getModifiers()
   * @see #getRecursiveClassDeclaration()
   * @generated
   */
  EReference getRecursiveClassDeclaration_Modifiers();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration#getName()
   * @see #getRecursiveClassDeclaration()
   * @generated
   */
  EAttribute getRecursiveClassDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration#getMembers()
   * @see #getRecursiveClassDeclaration()
   * @generated
   */
  EReference getRecursiveClassDeclaration_Members();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modifiers</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers
   * @generated
   */
  EClass getModifiers();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers#isFinal()
   * @see #getModifiers()
   * @generated
   */
  EAttribute getModifiers_Final();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers#isAbstract()
   * @see #getModifiers()
   * @generated
   */
  EAttribute getModifiers_Abstract();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers#isExtern <em>Extern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extern</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers#isExtern()
   * @see #getModifiers()
   * @generated
   */
  EAttribute getModifiers_Extern();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers#getVisibility()
   * @see #getModifiers()
   * @generated
   */
  EAttribute getModifiers_Visibility();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered <em>Unordered</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unordered</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered
   * @generated
   */
  EClass getUnordered();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered#getName()
   * @see #getUnordered()
   * @generated
   */
  EAttribute getUnordered_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered#getRootDeclaration <em>Root Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Root Declaration</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered#getRootDeclaration()
   * @see #getUnordered()
   * @generated
   */
  EReference getUnordered_RootDeclaration();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration <em>Simple Class Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Class Declaration</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration
   * @generated
   */
  EClass getSimpleClassDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modifiers</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration#getModifiers()
   * @see #getSimpleClassDeclaration()
   * @generated
   */
  EReference getSimpleClassDeclaration_Modifiers();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration#getName()
   * @see #getSimpleClassDeclaration()
   * @generated
   */
  EAttribute getSimpleClassDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration#getMembers()
   * @see #getSimpleClassDeclaration()
   * @generated
   */
  EReference getSimpleClassDeclaration_Members();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.ClassMember <em>Class Member</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Member</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.ClassMember
   * @generated
   */
  EClass getClassMember();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.ClassMember#getModifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modifiers</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.ClassMember#getModifiers()
   * @see #getClassMember()
   * @generated
   */
  EReference getClassMember_Modifiers();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.ClassMember#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.ClassMember#getName()
   * @see #getClassMember()
   * @generated
   */
  EAttribute getClassMember_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.UnorderedModifiers <em>Unordered Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unordered Modifiers</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.UnorderedModifiers
   * @generated
   */
  EClass getUnorderedModifiers();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Visibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Visibility</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Visibility
   * @generated
   */
  EEnum getVisibility();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug360834TestLanguageFactory getBug360834TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENT = eINSTANCE.getModel_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.AlternativeImpl <em>Alternative</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.AlternativeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getAlternative()
     * @generated
     */
    EClass ALTERNATIVE = eINSTANCE.getAlternative();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALTERNATIVE__NAME = eINSTANCE.getAlternative_Name();

    /**
     * The meta object literal for the '<em><b>Root Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALTERNATIVE__ROOT_DECLARATION = eINSTANCE.getAlternative_RootDeclaration();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.RecursiveClassDeclarationImpl <em>Recursive Class Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.RecursiveClassDeclarationImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getRecursiveClassDeclaration()
     * @generated
     */
    EClass RECURSIVE_CLASS_DECLARATION = eINSTANCE.getRecursiveClassDeclaration();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECURSIVE_CLASS_DECLARATION__MODIFIERS = eINSTANCE.getRecursiveClassDeclaration_Modifiers();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECURSIVE_CLASS_DECLARATION__NAME = eINSTANCE.getRecursiveClassDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECURSIVE_CLASS_DECLARATION__MEMBERS = eINSTANCE.getRecursiveClassDeclaration_Members();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ModifiersImpl <em>Modifiers</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ModifiersImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getModifiers()
     * @generated
     */
    EClass MODIFIERS = eINSTANCE.getModifiers();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODIFIERS__FINAL = eINSTANCE.getModifiers_Final();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODIFIERS__ABSTRACT = eINSTANCE.getModifiers_Abstract();

    /**
     * The meta object literal for the '<em><b>Extern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODIFIERS__EXTERN = eINSTANCE.getModifiers_Extern();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODIFIERS__VISIBILITY = eINSTANCE.getModifiers_Visibility();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedImpl <em>Unordered</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getUnordered()
     * @generated
     */
    EClass UNORDERED = eINSTANCE.getUnordered();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNORDERED__NAME = eINSTANCE.getUnordered_Name();

    /**
     * The meta object literal for the '<em><b>Root Declaration</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNORDERED__ROOT_DECLARATION = eINSTANCE.getUnordered_RootDeclaration();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.SimpleClassDeclarationImpl <em>Simple Class Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.SimpleClassDeclarationImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getSimpleClassDeclaration()
     * @generated
     */
    EClass SIMPLE_CLASS_DECLARATION = eINSTANCE.getSimpleClassDeclaration();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_CLASS_DECLARATION__MODIFIERS = eINSTANCE.getSimpleClassDeclaration_Modifiers();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_CLASS_DECLARATION__NAME = eINSTANCE.getSimpleClassDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_CLASS_DECLARATION__MEMBERS = eINSTANCE.getSimpleClassDeclaration_Members();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ClassMemberImpl <em>Class Member</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.ClassMemberImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getClassMember()
     * @generated
     */
    EClass CLASS_MEMBER = eINSTANCE.getClassMember();

    /**
     * The meta object literal for the '<em><b>Modifiers</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_MEMBER__MODIFIERS = eINSTANCE.getClassMember_Modifiers();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_MEMBER__NAME = eINSTANCE.getClassMember_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedModifiersImpl <em>Unordered Modifiers</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.UnorderedModifiersImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getUnorderedModifiers()
     * @generated
     */
    EClass UNORDERED_MODIFIERS = eINSTANCE.getUnorderedModifiers();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Visibility <em>Visibility</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Visibility
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguagePackageImpl#getVisibility()
     * @generated
     */
    EEnum VISIBILITY = eINSTANCE.getVisibility();

  }

} //Bug360834TestLanguagePackage
