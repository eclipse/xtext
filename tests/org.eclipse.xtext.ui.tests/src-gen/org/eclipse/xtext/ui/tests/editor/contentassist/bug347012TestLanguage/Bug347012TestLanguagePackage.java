/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Bug347012TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug347012TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug347012TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2011/bug347012TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug347012TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug347012TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyProgramImpl <em>My Program</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyProgramImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyProgram()
   * @generated
   */
  int MY_PROGRAM = 0;

  /**
   * The feature id for the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_PROGRAM__PACKAGE = 0;

  /**
   * The number of structural features of the '<em>My Program</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_PROGRAM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyPrimaryImpl <em>My Primary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyPrimaryImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyPrimary()
   * @generated
   */
  int MY_PRIMARY = 3;

  /**
   * The number of structural features of the '<em>My Primary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_PRIMARY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.IdentifierImpl <em>Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.IdentifierImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getIdentifier()
   * @generated
   */
  int IDENTIFIER = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__NAME = MY_PRIMARY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER_FEATURE_COUNT = MY_PRIMARY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.LiteralImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 2;

  /**
   * The feature id for the '<em><b>Num</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__NUM = MY_PRIMARY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Str</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__STR = MY_PRIMARY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Bool</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__BOOL = MY_PRIMARY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = MY_PRIMARY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyPackageImpl <em>My Package</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyPackageImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyPackage()
   * @generated
   */
  int MY_PACKAGE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_PACKAGE__NAME = 0;

  /**
   * The feature id for the '<em><b>Directives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_PACKAGE__DIRECTIVES = 1;

  /**
   * The number of structural features of the '<em>My Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_PACKAGE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyClassImpl <em>My Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyClassImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyClass()
   * @generated
   */
  int MY_CLASS = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS__NAME = 0;

  /**
   * The feature id for the '<em><b>Directives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS__DIRECTIVES = 1;

  /**
   * The number of structural features of the '<em>My Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_CLASS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributeImpl <em>My Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyAttribute()
   * @generated
   */
  int MY_ATTRIBUTE = 6;

  /**
   * The feature id for the '<em><b>PUBLIC</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_ATTRIBUTE__PUBLIC = 0;

  /**
   * The feature id for the '<em><b>PRIVATE</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_ATTRIBUTE__PRIVATE = 1;

  /**
   * The number of structural features of the '<em>My Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_ATTRIBUTE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributesImpl <em>My Attributes</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributesImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyAttributes()
   * @generated
   */
  int MY_ATTRIBUTES = 7;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_ATTRIBUTES__ATTRIBUTES = 0;

  /**
   * The number of structural features of the '<em>My Attributes</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_ATTRIBUTES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyFieldImpl <em>My Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyFieldImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyField()
   * @generated
   */
  int MY_FIELD = 8;

  /**
   * The feature id for the '<em><b>Attr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_FIELD__ATTR = 0;

  /**
   * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_FIELD__BINDINGS = 1;

  /**
   * The number of structural features of the '<em>My Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_FIELD_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyBindingImpl <em>My Binding</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyBindingImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyBinding()
   * @generated
   */
  int MY_BINDING = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_BINDING__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_BINDING__TYPE = 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_BINDING__EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>My Binding</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_BINDING_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyProgram <em>My Program</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Program</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyProgram
   * @generated
   */
  EClass getMyProgram();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyProgram#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Package</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyProgram#getPackage()
   * @see #getMyProgram()
   * @generated
   */
  EReference getMyProgram_Package();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifier</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Identifier
   * @generated
   */
  EClass getIdentifier();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Identifier#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Identifier#getName()
   * @see #getIdentifier()
   * @generated
   */
  EAttribute getIdentifier_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Literal#getNum <em>Num</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Literal#getNum()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Num();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Literal#getStr <em>Str</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Str</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Literal#getStr()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Str();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Literal#getBool <em>Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bool</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.Literal#getBool()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Bool();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPrimary <em>My Primary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Primary</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPrimary
   * @generated
   */
  EClass getMyPrimary();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPackage <em>My Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Package</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPackage
   * @generated
   */
  EClass getMyPackage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPackage#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPackage#getName()
   * @see #getMyPackage()
   * @generated
   */
  EAttribute getMyPackage_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPackage#getDirectives <em>Directives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Directives</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyPackage#getDirectives()
   * @see #getMyPackage()
   * @generated
   */
  EReference getMyPackage_Directives();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyClass <em>My Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Class</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyClass
   * @generated
   */
  EClass getMyClass();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyClass#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyClass#getName()
   * @see #getMyClass()
   * @generated
   */
  EAttribute getMyClass_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyClass#getDirectives <em>Directives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Directives</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyClass#getDirectives()
   * @see #getMyClass()
   * @generated
   */
  EReference getMyClass_Directives();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute <em>My Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Attribute</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute
   * @generated
   */
  EClass getMyAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute#getPUBLIC <em>PUBLIC</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>PUBLIC</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute#getPUBLIC()
   * @see #getMyAttribute()
   * @generated
   */
  EAttribute getMyAttribute_PUBLIC();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute#getPRIVATE <em>PRIVATE</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>PRIVATE</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttribute#getPRIVATE()
   * @see #getMyAttribute()
   * @generated
   */
  EAttribute getMyAttribute_PRIVATE();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttributes <em>My Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Attributes</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttributes
   * @generated
   */
  EClass getMyAttributes();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttributes#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyAttributes#getAttributes()
   * @see #getMyAttributes()
   * @generated
   */
  EReference getMyAttributes_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyField <em>My Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Field</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyField
   * @generated
   */
  EClass getMyField();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyField#getAttr <em>Attr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Attr</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyField#getAttr()
   * @see #getMyField()
   * @generated
   */
  EReference getMyField_Attr();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyField#getBindings <em>Bindings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bindings</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyField#getBindings()
   * @see #getMyField()
   * @generated
   */
  EReference getMyField_Bindings();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyBinding <em>My Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Binding</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyBinding
   * @generated
   */
  EClass getMyBinding();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyBinding#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyBinding#getName()
   * @see #getMyBinding()
   * @generated
   */
  EAttribute getMyBinding_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyBinding#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyBinding#getType()
   * @see #getMyBinding()
   * @generated
   */
  EAttribute getMyBinding_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyBinding#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.MyBinding#getExpression()
   * @see #getMyBinding()
   * @generated
   */
  EReference getMyBinding_Expression();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug347012TestLanguageFactory getBug347012TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyProgramImpl <em>My Program</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyProgramImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyProgram()
     * @generated
     */
    EClass MY_PROGRAM = eINSTANCE.getMyProgram();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_PROGRAM__PACKAGE = eINSTANCE.getMyProgram_Package();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.IdentifierImpl <em>Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.IdentifierImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getIdentifier()
     * @generated
     */
    EClass IDENTIFIER = eINSTANCE.getIdentifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IDENTIFIER__NAME = eINSTANCE.getIdentifier_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.LiteralImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Num</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__NUM = eINSTANCE.getLiteral_Num();

    /**
     * The meta object literal for the '<em><b>Str</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__STR = eINSTANCE.getLiteral_Str();

    /**
     * The meta object literal for the '<em><b>Bool</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__BOOL = eINSTANCE.getLiteral_Bool();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyPrimaryImpl <em>My Primary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyPrimaryImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyPrimary()
     * @generated
     */
    EClass MY_PRIMARY = eINSTANCE.getMyPrimary();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyPackageImpl <em>My Package</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyPackageImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyPackage()
     * @generated
     */
    EClass MY_PACKAGE = eINSTANCE.getMyPackage();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_PACKAGE__NAME = eINSTANCE.getMyPackage_Name();

    /**
     * The meta object literal for the '<em><b>Directives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_PACKAGE__DIRECTIVES = eINSTANCE.getMyPackage_Directives();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyClassImpl <em>My Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyClassImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyClass()
     * @generated
     */
    EClass MY_CLASS = eINSTANCE.getMyClass();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_CLASS__NAME = eINSTANCE.getMyClass_Name();

    /**
     * The meta object literal for the '<em><b>Directives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_CLASS__DIRECTIVES = eINSTANCE.getMyClass_Directives();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributeImpl <em>My Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyAttribute()
     * @generated
     */
    EClass MY_ATTRIBUTE = eINSTANCE.getMyAttribute();

    /**
     * The meta object literal for the '<em><b>PUBLIC</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_ATTRIBUTE__PUBLIC = eINSTANCE.getMyAttribute_PUBLIC();

    /**
     * The meta object literal for the '<em><b>PRIVATE</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_ATTRIBUTE__PRIVATE = eINSTANCE.getMyAttribute_PRIVATE();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributesImpl <em>My Attributes</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyAttributesImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyAttributes()
     * @generated
     */
    EClass MY_ATTRIBUTES = eINSTANCE.getMyAttributes();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_ATTRIBUTES__ATTRIBUTES = eINSTANCE.getMyAttributes_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyFieldImpl <em>My Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyFieldImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyField()
     * @generated
     */
    EClass MY_FIELD = eINSTANCE.getMyField();

    /**
     * The meta object literal for the '<em><b>Attr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_FIELD__ATTR = eINSTANCE.getMyField_Attr();

    /**
     * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_FIELD__BINDINGS = eINSTANCE.getMyField_Bindings();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyBindingImpl <em>My Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.MyBindingImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug347012TestLanguage.impl.Bug347012TestLanguagePackageImpl#getMyBinding()
     * @generated
     */
    EClass MY_BINDING = eINSTANCE.getMyBinding();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_BINDING__NAME = eINSTANCE.getMyBinding_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_BINDING__TYPE = eINSTANCE.getMyBinding_Type();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_BINDING__EXPRESSION = eINSTANCE.getMyBinding_Expression();

  }

} //Bug347012TestLanguagePackage
