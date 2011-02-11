/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.common.types.TypesPackage;

import org.eclipse.xtext.xbase.XbasePackage;

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
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Factory
 * @model kind="package"
 * @generated
 */
public interface Xtend2Package extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xtend2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/Xtend2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xtend2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Xtend2Package eINSTANCE = org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendFileImpl <em>Xtend File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendFileImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendFile()
	 * @generated
	 */
	int XTEND_FILE = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FILE__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Xtend Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FILE__XTEND_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FILE__PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Xtend File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FILE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendImportImpl <em>Xtend Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendImportImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendImport()
	 * @generated
	 */
	int XTEND_IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_IMPORT__IMPORTED_NAMESPACE = 0;

	/**
	 * The feature id for the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_IMPORT__WILDCARD = 1;

	/**
	 * The number of structural features of the '<em>Xtend Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_IMPORT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl <em>Xtend Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendClass()
	 * @generated
	 */
	int XTEND_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__TYPE_PARAMETERS = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__NAME = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__EXTENDS = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__IMPLEMENTS = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Super Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__SUPER_TYPES = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS__MEMBERS = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Xtend Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_CLASS_FEATURE_COUNT = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendMemberImpl <em>Xtend Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendMemberImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendMember()
	 * @generated
	 */
	int XTEND_MEMBER = 3;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__DECLARING_TYPE = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER__NAME = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Xtend Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_MEMBER_FEATURE_COUNT = TypesPackage.JVM_IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendFunctionImpl <em>Xtend Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendFunctionImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendFunction()
	 * @generated
	 */
	int XTEND_FUNCTION = 4;

	/**
	 * The feature id for the '<em><b>Declaring Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__DECLARING_TYPE = XTEND_MEMBER__DECLARING_TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__NAME = XTEND_MEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Type Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__TYPE_PARAMETERS = XTEND_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__EXPRESSION = XTEND_MEMBER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__RETURN_TYPE = XTEND_MEMBER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__PARAMETERS = XTEND_MEMBER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__OVERRIDE = XTEND_MEMBER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Dispatch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION__DISPATCH = XTEND_MEMBER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Xtend Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTEND_FUNCTION_FEATURE_COUNT = XTEND_MEMBER_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringImpl <em>Rich String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichString()
	 * @generated
	 */
	int RICH_STRING = 5;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING__ELEMENTS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rich String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringLiteralImpl <em>Rich String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringLiteralImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichStringLiteral()
	 * @generated
	 */
	int RICH_STRING_LITERAL = 6;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_LITERAL__VALUE = XbasePackage.XSTRING_LITERAL__VALUE;

	/**
	 * The number of structural features of the '<em>Rich String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_LITERAL_FEATURE_COUNT = XbasePackage.XSTRING_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringForLoopImpl <em>Rich String For Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringForLoopImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichStringForLoop()
	 * @generated
	 */
	int RICH_STRING_FOR_LOOP = 7;

	/**
	 * The feature id for the '<em><b>For Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__FOR_EXPRESSION = XbasePackage.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__EACH_EXPRESSION = XbasePackage.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP__DECLARED_PARAM = XbasePackage.XFOR_LOOP_EXPRESSION__DECLARED_PARAM;

	/**
	 * The number of structural features of the '<em>Rich String For Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_FOR_LOOP_FEATURE_COUNT = XbasePackage.XFOR_LOOP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringIfImpl <em>Rich String If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringIfImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichStringIf()
	 * @generated
	 */
	int RICH_STRING_IF = 8;

	/**
	 * The feature id for the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__IF = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__THEN = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Ifs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__ELSE_IFS = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF__ELSE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rich String If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_IF_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringElseIfImpl <em>Rich String Else If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringElseIfImpl
	 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichStringElseIf()
	 * @generated
	 */
	int RICH_STRING_ELSE_IF = 9;

	/**
	 * The feature id for the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_ELSE_IF__IF = 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_ELSE_IF__THEN = 1;

	/**
	 * The number of structural features of the '<em>Rich String Else If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RICH_STRING_ELSE_IF_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.XtendFile <em>Xtend File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend File</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFile
	 * @generated
	 */
	EClass getXtendFile();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtend2.xtend2.XtendFile#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFile#getImports()
	 * @see #getXtendFile()
	 * @generated
	 */
	EReference getXtendFile_Imports();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtend2.xtend2.XtendFile#getXtendClass <em>Xtend Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Xtend Class</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFile#getXtendClass()
	 * @see #getXtendFile()
	 * @generated
	 */
	EReference getXtendFile_XtendClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtend2.xtend2.XtendFile#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFile#getPackage()
	 * @see #getXtendFile()
	 * @generated
	 */
	EAttribute getXtendFile_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.XtendImport <em>Xtend Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Import</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendImport
	 * @generated
	 */
	EClass getXtendImport();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtend2.xtend2.XtendImport#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Namespace</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendImport#getImportedNamespace()
	 * @see #getXtendImport()
	 * @generated
	 */
	EAttribute getXtendImport_ImportedNamespace();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtend2.xtend2.XtendImport#isWildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wildcard</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendImport#isWildcard()
	 * @see #getXtendImport()
	 * @generated
	 */
	EAttribute getXtendImport_Wildcard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass <em>Xtend Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Class</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClass
	 * @generated
	 */
	EClass getXtendClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClass#getName()
	 * @see #getXtendClass()
	 * @generated
	 */
	EAttribute getXtendClass_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClass#getExtends()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_Extends();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implements</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClass#getImplements()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_Implements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getSuperTypes <em>Super Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Types</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClass#getSuperTypes()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_SuperTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtend2.xtend2.XtendClass#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendClass#getMembers()
	 * @see #getXtendClass()
	 * @generated
	 */
	EReference getXtendClass_Members();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.XtendMember <em>Xtend Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Member</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendMember
	 * @generated
	 */
	EClass getXtendMember();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.xtext.xtend2.xtend2.XtendMember#getDeclaringType <em>Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Declaring Type</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendMember#getDeclaringType()
	 * @see #getXtendMember()
	 * @generated
	 */
	EReference getXtendMember_DeclaringType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtend2.xtend2.XtendMember#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendMember#getName()
	 * @see #getXtendMember()
	 * @generated
	 */
	EAttribute getXtendMember_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction <em>Xtend Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xtend Function</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFunction
	 * @generated
	 */
	EClass getXtendFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFunction#getExpression()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFunction#getReturnType()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFunction#getParameters()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EReference getXtendFunction_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#isOverride <em>Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Override</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFunction#isOverride()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EAttribute getXtendFunction_Override();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#isDispatch <em>Dispatch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dispatch</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.XtendFunction#isDispatch()
	 * @see #getXtendFunction()
	 * @generated
	 */
	EAttribute getXtendFunction_Dispatch();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.RichString <em>Rich String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichString
	 * @generated
	 */
	EClass getRichString();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtend2.xtend2.RichString#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichString#getElements()
	 * @see #getRichString()
	 * @generated
	 */
	EReference getRichString_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.RichStringLiteral <em>Rich String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String Literal</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringLiteral
	 * @generated
	 */
	EClass getRichStringLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.RichStringForLoop <em>Rich String For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String For Loop</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringForLoop
	 * @generated
	 */
	EClass getRichStringForLoop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.RichStringIf <em>Rich String If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String If</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringIf
	 * @generated
	 */
	EClass getRichStringIf();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtend2.xtend2.RichStringIf#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringIf#getIf()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_If();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtend2.xtend2.RichStringIf#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringIf#getThen()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_Then();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtend2.xtend2.RichStringIf#getElseIfs <em>Else Ifs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Else Ifs</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringIf#getElseIfs()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_ElseIfs();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtend2.xtend2.RichStringIf#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringIf#getElse()
	 * @see #getRichStringIf()
	 * @generated
	 */
	EReference getRichStringIf_Else();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xtend2.xtend2.RichStringElseIf <em>Rich String Else If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rich String Else If</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringElseIf
	 * @generated
	 */
	EClass getRichStringElseIf();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtend2.xtend2.RichStringElseIf#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringElseIf#getIf()
	 * @see #getRichStringElseIf()
	 * @generated
	 */
	EReference getRichStringElseIf_If();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtend2.xtend2.RichStringElseIf#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.xtext.xtend2.xtend2.RichStringElseIf#getThen()
	 * @see #getRichStringElseIf()
	 * @generated
	 */
	EReference getRichStringElseIf_Then();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Xtend2Factory getXtend2Factory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendFileImpl <em>Xtend File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendFileImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendFile()
		 * @generated
		 */
		EClass XTEND_FILE = eINSTANCE.getXtendFile();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FILE__IMPORTS = eINSTANCE.getXtendFile_Imports();

		/**
		 * The meta object literal for the '<em><b>Xtend Class</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FILE__XTEND_CLASS = eINSTANCE.getXtendFile_XtendClass();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FILE__PACKAGE = eINSTANCE.getXtendFile_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendImportImpl <em>Xtend Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendImportImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendImport()
		 * @generated
		 */
		EClass XTEND_IMPORT = eINSTANCE.getXtendImport();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getXtendImport_ImportedNamespace();

		/**
		 * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_IMPORT__WILDCARD = eINSTANCE.getXtendImport_Wildcard();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl <em>Xtend Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendClassImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendClass()
		 * @generated
		 */
		EClass XTEND_CLASS = eINSTANCE.getXtendClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_CLASS__NAME = eINSTANCE.getXtendClass_Name();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__EXTENDS = eINSTANCE.getXtendClass_Extends();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__IMPLEMENTS = eINSTANCE.getXtendClass_Implements();

		/**
		 * The meta object literal for the '<em><b>Super Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__SUPER_TYPES = eINSTANCE.getXtendClass_SuperTypes();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_CLASS__MEMBERS = eINSTANCE.getXtendClass_Members();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendMemberImpl <em>Xtend Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendMemberImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendMember()
		 * @generated
		 */
		EClass XTEND_MEMBER = eINSTANCE.getXtendMember();

		/**
		 * The meta object literal for the '<em><b>Declaring Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_MEMBER__DECLARING_TYPE = eINSTANCE.getXtendMember_DeclaringType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_MEMBER__NAME = eINSTANCE.getXtendMember_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.XtendFunctionImpl <em>Xtend Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.XtendFunctionImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getXtendFunction()
		 * @generated
		 */
		EClass XTEND_FUNCTION = eINSTANCE.getXtendFunction();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__EXPRESSION = eINSTANCE.getXtendFunction_Expression();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__RETURN_TYPE = eINSTANCE.getXtendFunction_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTEND_FUNCTION__PARAMETERS = eINSTANCE.getXtendFunction_Parameters();

		/**
		 * The meta object literal for the '<em><b>Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FUNCTION__OVERRIDE = eINSTANCE.getXtendFunction_Override();

		/**
		 * The meta object literal for the '<em><b>Dispatch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTEND_FUNCTION__DISPATCH = eINSTANCE.getXtendFunction_Dispatch();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringImpl <em>Rich String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichString()
		 * @generated
		 */
		EClass RICH_STRING = eINSTANCE.getRichString();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING__ELEMENTS = eINSTANCE.getRichString_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringLiteralImpl <em>Rich String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringLiteralImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichStringLiteral()
		 * @generated
		 */
		EClass RICH_STRING_LITERAL = eINSTANCE.getRichStringLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringForLoopImpl <em>Rich String For Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringForLoopImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichStringForLoop()
		 * @generated
		 */
		EClass RICH_STRING_FOR_LOOP = eINSTANCE.getRichStringForLoop();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringIfImpl <em>Rich String If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringIfImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichStringIf()
		 * @generated
		 */
		EClass RICH_STRING_IF = eINSTANCE.getRichStringIf();

		/**
		 * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__IF = eINSTANCE.getRichStringIf_If();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__THEN = eINSTANCE.getRichStringIf_Then();

		/**
		 * The meta object literal for the '<em><b>Else Ifs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__ELSE_IFS = eINSTANCE.getRichStringIf_ElseIfs();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_IF__ELSE = eINSTANCE.getRichStringIf_Else();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xtend2.xtend2.impl.RichStringElseIfImpl <em>Rich String Else If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.RichStringElseIfImpl
		 * @see org.eclipse.xtext.xtend2.xtend2.impl.Xtend2PackageImpl#getRichStringElseIf()
		 * @generated
		 */
		EClass RICH_STRING_ELSE_IF = eINSTANCE.getRichStringElseIf();

		/**
		 * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_ELSE_IF__IF = eINSTANCE.getRichStringElseIf_If();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RICH_STRING_ELSE_IF__THEN = eINSTANCE.getRichStringElseIf_Then();

	}

} //Xtend2Package
