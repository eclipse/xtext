/**
 * <copyright>
 * </copyright>
 *
 * $Id: XpressionPackage.java,v 1.3 2010/01/16 08:50:52 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

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
 * @see org.eclipse.xtext.xpression.XpressionFactory
 * @model kind="package"
 * @generated
 */
public interface XpressionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xpression";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/xbase/Xpression";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xpression";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XpressionPackage eINSTANCE = org.eclipse.xtext.xpression.impl.XpressionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XExpressionImpl <em>XExpression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XExpressionImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXExpression()
	 * @generated
	 */
	int XEXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>XExpression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XEXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XIfExpressionImpl <em>XIf Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XIfExpressionImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXIfExpression()
	 * @generated
	 */
	int XIF_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>If</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION__IF = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION__THEN = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION__ELSE = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XIf Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XSwitchExpressionImpl <em>XSwitch Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XSwitchExpressionImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXSwitchExpression()
	 * @generated
	 */
	int XSWITCH_EXPRESSION = 2;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION__SWITCH = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION__CASES = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION__DEFAULT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XSwitch Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XCasePartImpl <em>XCase Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XCasePartImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXCasePart()
	 * @generated
	 */
	int XCASE_PART = 3;

	/**
	 * The feature id for the '<em><b>Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART__CASE = 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART__THEN = 1;

	/**
	 * The number of structural features of the '<em>XCase Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XBlockExpressionImpl <em>XBlock Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XBlockExpressionImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXBlockExpression()
	 * @generated
	 */
	int XBLOCK_EXPRESSION = 4;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBLOCK_EXPRESSION__EXPRESSIONS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XBlock Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBLOCK_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XVariableDeclarationImpl <em>XVariable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XVariableDeclarationImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXVariableDeclaration()
	 * @generated
	 */
	int XVARIABLE_DECLARATION = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION__NAME = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION__RIGHT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XVariable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XDeclaredParameterImpl <em>XDeclared Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XDeclaredParameterImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXDeclaredParameter()
	 * @generated
	 */
	int XDECLARED_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDECLARED_PARAMETER__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDECLARED_PARAMETER__NAME = 1;

	/**
	 * The number of structural features of the '<em>XDeclared Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDECLARED_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XFeatureCallImpl <em>XFeature Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XFeatureCallImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXFeatureCall()
	 * @generated
	 */
	int XFEATURE_CALL = 7;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__TARGET = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__NAME = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__PARAMS = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XFeature Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XConstructorCallImpl <em>XConstructor Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XConstructorCallImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXConstructorCall()
	 * @generated
	 */
	int XCONSTRUCTOR_CALL = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__PARAMS = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__INITIALIZER = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XConstructor Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XBooleanLiteralImpl <em>XBoolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XBooleanLiteralImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXBooleanLiteral()
	 * @generated
	 */
	int XBOOLEAN_LITERAL = 9;

	/**
	 * The feature id for the '<em><b>Is True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBOOLEAN_LITERAL__IS_TRUE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XBoolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBOOLEAN_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XNullLiteralImpl <em>XNull Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XNullLiteralImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXNullLiteral()
	 * @generated
	 */
	int XNULL_LITERAL = 10;

	/**
	 * The number of structural features of the '<em>XNull Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XNULL_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XIntLiteralImpl <em>XInt Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XIntLiteralImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXIntLiteral()
	 * @generated
	 */
	int XINT_LITERAL = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINT_LITERAL__VALUE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XInt Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINT_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XStringLiteralImpl <em>XString Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XStringLiteralImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXStringLiteral()
	 * @generated
	 */
	int XSTRING_LITERAL = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSTRING_LITERAL__VALUE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XString Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSTRING_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XRichStringImpl <em>XRich String</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XRichStringImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXRichString()
	 * @generated
	 */
	int XRICH_STRING = 13;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XRICH_STRING__EXPRESSIONS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XRich String</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XRICH_STRING_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XRichStringLiteralImpl <em>XRich String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XRichStringLiteralImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXRichStringLiteral()
	 * @generated
	 */
	int XRICH_STRING_LITERAL = 14;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XRICH_STRING_LITERAL__VALUE = 0;

	/**
	 * The number of structural features of the '<em>XRich String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XRICH_STRING_LITERAL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XClosureImpl <em>XClosure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XClosureImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXClosure()
	 * @generated
	 */
	int XCLOSURE = 15;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__PARAMS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XClosure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XCastedExpressionImpl <em>XCasted Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XCastedExpressionImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXCastedExpression()
	 * @generated
	 */
	int XCASTED_EXPRESSION = 16;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASTED_EXPRESSION__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASTED_EXPRESSION__TARGET = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XCasted Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASTED_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XAssignmentImpl <em>XAssignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XAssignmentImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXAssignment()
	 * @generated
	 */
	int XASSIGNMENT = 17;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__LEFT = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__RIGHT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XAssignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XBinaryOperationImpl <em>XBinary Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XBinaryOperationImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXBinaryOperation()
	 * @generated
	 */
	int XBINARY_OPERATION = 18;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__LEFT = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__OPERATOR = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__RIGHT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XBinary Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XUnaryOperationImpl <em>XUnary Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XUnaryOperationImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXUnaryOperation()
	 * @generated
	 */
	int XUNARY_OPERATION = 19;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__OPERATOR = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__TARGET = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XUnary Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XWhileExpressionImpl <em>XWhile Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XWhileExpressionImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXWhileExpression()
	 * @generated
	 */
	int XWHILE_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWHILE_EXPRESSION__PREDICATE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWHILE_EXPRESSION__BODY = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XWhile Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWHILE_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XTypeLiteralImpl <em>XType Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XTypeLiteralImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXTypeLiteral()
	 * @generated
	 */
	int XTYPE_LITERAL = 21;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTYPE_LITERAL__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XType Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTYPE_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xpression.impl.XInstanceOfExpressionImpl <em>XInstance Of Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xpression.impl.XInstanceOfExpressionImpl
	 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXInstanceOfExpression()
	 * @generated
	 */
	int XINSTANCE_OF_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINSTANCE_OF_EXPRESSION__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINSTANCE_OF_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XInstance Of Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XINSTANCE_OF_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XExpression <em>XExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XExpression</em>'.
	 * @see org.eclipse.xtext.xpression.XExpression
	 * @generated
	 */
	EClass getXExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XIfExpression <em>XIf Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XIf Expression</em>'.
	 * @see org.eclipse.xtext.xpression.XIfExpression
	 * @generated
	 */
	EClass getXIfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XIfExpression#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see org.eclipse.xtext.xpression.XIfExpression#getIf()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EReference getXIfExpression_If();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XIfExpression#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.xtext.xpression.XIfExpression#getThen()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EReference getXIfExpression_Then();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XIfExpression#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.eclipse.xtext.xpression.XIfExpression#getElse()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EReference getXIfExpression_Else();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XSwitchExpression <em>XSwitch Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSwitch Expression</em>'.
	 * @see org.eclipse.xtext.xpression.XSwitchExpression
	 * @generated
	 */
	EClass getXSwitchExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XSwitchExpression#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch</em>'.
	 * @see org.eclipse.xtext.xpression.XSwitchExpression#getSwitch()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_Switch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xpression.XSwitchExpression#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see org.eclipse.xtext.xpression.XSwitchExpression#getCases()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_Cases();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XSwitchExpression#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see org.eclipse.xtext.xpression.XSwitchExpression#getDefault()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_Default();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XCasePart <em>XCase Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCase Part</em>'.
	 * @see org.eclipse.xtext.xpression.XCasePart
	 * @generated
	 */
	EClass getXCasePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XCasePart#getCase <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Case</em>'.
	 * @see org.eclipse.xtext.xpression.XCasePart#getCase()
	 * @see #getXCasePart()
	 * @generated
	 */
	EReference getXCasePart_Case();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XCasePart#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.xtext.xpression.XCasePart#getThen()
	 * @see #getXCasePart()
	 * @generated
	 */
	EReference getXCasePart_Then();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XBlockExpression <em>XBlock Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBlock Expression</em>'.
	 * @see org.eclipse.xtext.xpression.XBlockExpression
	 * @generated
	 */
	EClass getXBlockExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xpression.XBlockExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.xtext.xpression.XBlockExpression#getExpressions()
	 * @see #getXBlockExpression()
	 * @generated
	 */
	EReference getXBlockExpression_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XVariableDeclaration <em>XVariable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XVariable Declaration</em>'.
	 * @see org.eclipse.xtext.xpression.XVariableDeclaration
	 * @generated
	 */
	EClass getXVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XVariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xpression.XVariableDeclaration#getType()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EReference getXVariableDeclaration_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xpression.XVariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xpression.XVariableDeclaration#getName()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EAttribute getXVariableDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XVariableDeclaration#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.eclipse.xtext.xpression.XVariableDeclaration#getRight()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EReference getXVariableDeclaration_Right();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XDeclaredParameter <em>XDeclared Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XDeclared Parameter</em>'.
	 * @see org.eclipse.xtext.xpression.XDeclaredParameter
	 * @generated
	 */
	EClass getXDeclaredParameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XDeclaredParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xpression.XDeclaredParameter#getType()
	 * @see #getXDeclaredParameter()
	 * @generated
	 */
	EReference getXDeclaredParameter_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xpression.XDeclaredParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xpression.XDeclaredParameter#getName()
	 * @see #getXDeclaredParameter()
	 * @generated
	 */
	EAttribute getXDeclaredParameter_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XFeatureCall <em>XFeature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFeature Call</em>'.
	 * @see org.eclipse.xtext.xpression.XFeatureCall
	 * @generated
	 */
	EClass getXFeatureCall();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XFeatureCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.xtext.xpression.XFeatureCall#getTarget()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EReference getXFeatureCall_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xpression.XFeatureCall#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xpression.XFeatureCall#getName()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EAttribute getXFeatureCall_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xpression.XFeatureCall#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.eclipse.xtext.xpression.XFeatureCall#getParams()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EReference getXFeatureCall_Params();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XConstructorCall <em>XConstructor Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XConstructor Call</em>'.
	 * @see org.eclipse.xtext.xpression.XConstructorCall
	 * @generated
	 */
	EClass getXConstructorCall();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XConstructorCall#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xpression.XConstructorCall#getType()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EReference getXConstructorCall_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xpression.XConstructorCall#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.eclipse.xtext.xpression.XConstructorCall#getParams()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EReference getXConstructorCall_Params();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XConstructorCall#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see org.eclipse.xtext.xpression.XConstructorCall#getInitializer()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EReference getXConstructorCall_Initializer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XBooleanLiteral <em>XBoolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBoolean Literal</em>'.
	 * @see org.eclipse.xtext.xpression.XBooleanLiteral
	 * @generated
	 */
	EClass getXBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xpression.XBooleanLiteral#isIsTrue <em>Is True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is True</em>'.
	 * @see org.eclipse.xtext.xpression.XBooleanLiteral#isIsTrue()
	 * @see #getXBooleanLiteral()
	 * @generated
	 */
	EAttribute getXBooleanLiteral_IsTrue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XNullLiteral <em>XNull Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XNull Literal</em>'.
	 * @see org.eclipse.xtext.xpression.XNullLiteral
	 * @generated
	 */
	EClass getXNullLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XIntLiteral <em>XInt Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XInt Literal</em>'.
	 * @see org.eclipse.xtext.xpression.XIntLiteral
	 * @generated
	 */
	EClass getXIntLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xpression.XIntLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.xtext.xpression.XIntLiteral#getValue()
	 * @see #getXIntLiteral()
	 * @generated
	 */
	EAttribute getXIntLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XStringLiteral <em>XString Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XString Literal</em>'.
	 * @see org.eclipse.xtext.xpression.XStringLiteral
	 * @generated
	 */
	EClass getXStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xpression.XStringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.xtext.xpression.XStringLiteral#getValue()
	 * @see #getXStringLiteral()
	 * @generated
	 */
	EAttribute getXStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XRichString <em>XRich String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XRich String</em>'.
	 * @see org.eclipse.xtext.xpression.XRichString
	 * @generated
	 */
	EClass getXRichString();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xpression.XRichString#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.xtext.xpression.XRichString#getExpressions()
	 * @see #getXRichString()
	 * @generated
	 */
	EReference getXRichString_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XRichStringLiteral <em>XRich String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XRich String Literal</em>'.
	 * @see org.eclipse.xtext.xpression.XRichStringLiteral
	 * @generated
	 */
	EClass getXRichStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xpression.XRichStringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.xtext.xpression.XRichStringLiteral#getValue()
	 * @see #getXRichStringLiteral()
	 * @generated
	 */
	EAttribute getXRichStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XClosure <em>XClosure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XClosure</em>'.
	 * @see org.eclipse.xtext.xpression.XClosure
	 * @generated
	 */
	EClass getXClosure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xpression.XClosure#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.eclipse.xtext.xpression.XClosure#getParams()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_Params();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XClosure#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xpression.XClosure#getExpression()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XCastedExpression <em>XCasted Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCasted Expression</em>'.
	 * @see org.eclipse.xtext.xpression.XCastedExpression
	 * @generated
	 */
	EClass getXCastedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XCastedExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xpression.XCastedExpression#getType()
	 * @see #getXCastedExpression()
	 * @generated
	 */
	EReference getXCastedExpression_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XCastedExpression#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.xtext.xpression.XCastedExpression#getTarget()
	 * @see #getXCastedExpression()
	 * @generated
	 */
	EReference getXCastedExpression_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XAssignment <em>XAssignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAssignment</em>'.
	 * @see org.eclipse.xtext.xpression.XAssignment
	 * @generated
	 */
	EClass getXAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XAssignment#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.eclipse.xtext.xpression.XAssignment#getLeft()
	 * @see #getXAssignment()
	 * @generated
	 */
	EReference getXAssignment_Left();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XAssignment#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.eclipse.xtext.xpression.XAssignment#getRight()
	 * @see #getXAssignment()
	 * @generated
	 */
	EReference getXAssignment_Right();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XBinaryOperation <em>XBinary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBinary Operation</em>'.
	 * @see org.eclipse.xtext.xpression.XBinaryOperation
	 * @generated
	 */
	EClass getXBinaryOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XBinaryOperation#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see org.eclipse.xtext.xpression.XBinaryOperation#getLeft()
	 * @see #getXBinaryOperation()
	 * @generated
	 */
	EReference getXBinaryOperation_Left();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xpression.XBinaryOperation#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.xtext.xpression.XBinaryOperation#getOperator()
	 * @see #getXBinaryOperation()
	 * @generated
	 */
	EAttribute getXBinaryOperation_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XBinaryOperation#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.eclipse.xtext.xpression.XBinaryOperation#getRight()
	 * @see #getXBinaryOperation()
	 * @generated
	 */
	EReference getXBinaryOperation_Right();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XUnaryOperation <em>XUnary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XUnary Operation</em>'.
	 * @see org.eclipse.xtext.xpression.XUnaryOperation
	 * @generated
	 */
	EClass getXUnaryOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xpression.XUnaryOperation#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.xtext.xpression.XUnaryOperation#getOperator()
	 * @see #getXUnaryOperation()
	 * @generated
	 */
	EAttribute getXUnaryOperation_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XUnaryOperation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.xtext.xpression.XUnaryOperation#getTarget()
	 * @see #getXUnaryOperation()
	 * @generated
	 */
	EReference getXUnaryOperation_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XWhileExpression <em>XWhile Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XWhile Expression</em>'.
	 * @see org.eclipse.xtext.xpression.XWhileExpression
	 * @generated
	 */
	EClass getXWhileExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XWhileExpression#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see org.eclipse.xtext.xpression.XWhileExpression#getPredicate()
	 * @see #getXWhileExpression()
	 * @generated
	 */
	EReference getXWhileExpression_Predicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XWhileExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.xtext.xpression.XWhileExpression#getBody()
	 * @see #getXWhileExpression()
	 * @generated
	 */
	EReference getXWhileExpression_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XTypeLiteral <em>XType Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XType Literal</em>'.
	 * @see org.eclipse.xtext.xpression.XTypeLiteral
	 * @generated
	 */
	EClass getXTypeLiteral();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xpression.XTypeLiteral#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xpression.XTypeLiteral#getType()
	 * @see #getXTypeLiteral()
	 * @generated
	 */
	EReference getXTypeLiteral_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xpression.XInstanceOfExpression <em>XInstance Of Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XInstance Of Expression</em>'.
	 * @see org.eclipse.xtext.xpression.XInstanceOfExpression
	 * @generated
	 */
	EClass getXInstanceOfExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xpression.XInstanceOfExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xpression.XInstanceOfExpression#getType()
	 * @see #getXInstanceOfExpression()
	 * @generated
	 */
	EReference getXInstanceOfExpression_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xpression.XInstanceOfExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xpression.XInstanceOfExpression#getExpression()
	 * @see #getXInstanceOfExpression()
	 * @generated
	 */
	EReference getXInstanceOfExpression_Expression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XpressionFactory getXpressionFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XExpressionImpl <em>XExpression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XExpressionImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXExpression()
		 * @generated
		 */
		EClass XEXPRESSION = eINSTANCE.getXExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XIfExpressionImpl <em>XIf Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XIfExpressionImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXIfExpression()
		 * @generated
		 */
		EClass XIF_EXPRESSION = eINSTANCE.getXIfExpression();

		/**
		 * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIF_EXPRESSION__IF = eINSTANCE.getXIfExpression_If();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIF_EXPRESSION__THEN = eINSTANCE.getXIfExpression_Then();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XIF_EXPRESSION__ELSE = eINSTANCE.getXIfExpression_Else();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XSwitchExpressionImpl <em>XSwitch Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XSwitchExpressionImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXSwitchExpression()
		 * @generated
		 */
		EClass XSWITCH_EXPRESSION = eINSTANCE.getXSwitchExpression();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSWITCH_EXPRESSION__SWITCH = eINSTANCE.getXSwitchExpression_Switch();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSWITCH_EXPRESSION__CASES = eINSTANCE.getXSwitchExpression_Cases();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSWITCH_EXPRESSION__DEFAULT = eINSTANCE.getXSwitchExpression_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XCasePartImpl <em>XCase Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XCasePartImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXCasePart()
		 * @generated
		 */
		EClass XCASE_PART = eINSTANCE.getXCasePart();

		/**
		 * The meta object literal for the '<em><b>Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASE_PART__CASE = eINSTANCE.getXCasePart_Case();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASE_PART__THEN = eINSTANCE.getXCasePart_Then();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XBlockExpressionImpl <em>XBlock Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XBlockExpressionImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXBlockExpression()
		 * @generated
		 */
		EClass XBLOCK_EXPRESSION = eINSTANCE.getXBlockExpression();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBLOCK_EXPRESSION__EXPRESSIONS = eINSTANCE.getXBlockExpression_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XVariableDeclarationImpl <em>XVariable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XVariableDeclarationImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXVariableDeclaration()
		 * @generated
		 */
		EClass XVARIABLE_DECLARATION = eINSTANCE.getXVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XVARIABLE_DECLARATION__TYPE = eINSTANCE.getXVariableDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XVARIABLE_DECLARATION__NAME = eINSTANCE.getXVariableDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XVARIABLE_DECLARATION__RIGHT = eINSTANCE.getXVariableDeclaration_Right();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XDeclaredParameterImpl <em>XDeclared Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XDeclaredParameterImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXDeclaredParameter()
		 * @generated
		 */
		EClass XDECLARED_PARAMETER = eINSTANCE.getXDeclaredParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XDECLARED_PARAMETER__TYPE = eINSTANCE.getXDeclaredParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XDECLARED_PARAMETER__NAME = eINSTANCE.getXDeclaredParameter_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XFeatureCallImpl <em>XFeature Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XFeatureCallImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXFeatureCall()
		 * @generated
		 */
		EClass XFEATURE_CALL = eINSTANCE.getXFeatureCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFEATURE_CALL__TARGET = eINSTANCE.getXFeatureCall_Target();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFEATURE_CALL__NAME = eINSTANCE.getXFeatureCall_Name();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFEATURE_CALL__PARAMS = eINSTANCE.getXFeatureCall_Params();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XConstructorCallImpl <em>XConstructor Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XConstructorCallImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXConstructorCall()
		 * @generated
		 */
		EClass XCONSTRUCTOR_CALL = eINSTANCE.getXConstructorCall();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCONSTRUCTOR_CALL__TYPE = eINSTANCE.getXConstructorCall_Type();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCONSTRUCTOR_CALL__PARAMS = eINSTANCE.getXConstructorCall_Params();

		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCONSTRUCTOR_CALL__INITIALIZER = eINSTANCE.getXConstructorCall_Initializer();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XBooleanLiteralImpl <em>XBoolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XBooleanLiteralImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXBooleanLiteral()
		 * @generated
		 */
		EClass XBOOLEAN_LITERAL = eINSTANCE.getXBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>Is True</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XBOOLEAN_LITERAL__IS_TRUE = eINSTANCE.getXBooleanLiteral_IsTrue();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XNullLiteralImpl <em>XNull Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XNullLiteralImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXNullLiteral()
		 * @generated
		 */
		EClass XNULL_LITERAL = eINSTANCE.getXNullLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XIntLiteralImpl <em>XInt Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XIntLiteralImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXIntLiteral()
		 * @generated
		 */
		EClass XINT_LITERAL = eINSTANCE.getXIntLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XINT_LITERAL__VALUE = eINSTANCE.getXIntLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XStringLiteralImpl <em>XString Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XStringLiteralImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXStringLiteral()
		 * @generated
		 */
		EClass XSTRING_LITERAL = eINSTANCE.getXStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XSTRING_LITERAL__VALUE = eINSTANCE.getXStringLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XRichStringImpl <em>XRich String</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XRichStringImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXRichString()
		 * @generated
		 */
		EClass XRICH_STRING = eINSTANCE.getXRichString();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XRICH_STRING__EXPRESSIONS = eINSTANCE.getXRichString_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XRichStringLiteralImpl <em>XRich String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XRichStringLiteralImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXRichStringLiteral()
		 * @generated
		 */
		EClass XRICH_STRING_LITERAL = eINSTANCE.getXRichStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XRICH_STRING_LITERAL__VALUE = eINSTANCE.getXRichStringLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XClosureImpl <em>XClosure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XClosureImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXClosure()
		 * @generated
		 */
		EClass XCLOSURE = eINSTANCE.getXClosure();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__PARAMS = eINSTANCE.getXClosure_Params();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__EXPRESSION = eINSTANCE.getXClosure_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XCastedExpressionImpl <em>XCasted Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XCastedExpressionImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXCastedExpression()
		 * @generated
		 */
		EClass XCASTED_EXPRESSION = eINSTANCE.getXCastedExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASTED_EXPRESSION__TYPE = eINSTANCE.getXCastedExpression_Type();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASTED_EXPRESSION__TARGET = eINSTANCE.getXCastedExpression_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XAssignmentImpl <em>XAssignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XAssignmentImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXAssignment()
		 * @generated
		 */
		EClass XASSIGNMENT = eINSTANCE.getXAssignment();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XASSIGNMENT__LEFT = eINSTANCE.getXAssignment_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XASSIGNMENT__RIGHT = eINSTANCE.getXAssignment_Right();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XBinaryOperationImpl <em>XBinary Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XBinaryOperationImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXBinaryOperation()
		 * @generated
		 */
		EClass XBINARY_OPERATION = eINSTANCE.getXBinaryOperation();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBINARY_OPERATION__LEFT = eINSTANCE.getXBinaryOperation_Left();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XBINARY_OPERATION__OPERATOR = eINSTANCE.getXBinaryOperation_Operator();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBINARY_OPERATION__RIGHT = eINSTANCE.getXBinaryOperation_Right();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XUnaryOperationImpl <em>XUnary Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XUnaryOperationImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXUnaryOperation()
		 * @generated
		 */
		EClass XUNARY_OPERATION = eINSTANCE.getXUnaryOperation();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XUNARY_OPERATION__OPERATOR = eINSTANCE.getXUnaryOperation_Operator();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XUNARY_OPERATION__TARGET = eINSTANCE.getXUnaryOperation_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XWhileExpressionImpl <em>XWhile Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XWhileExpressionImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXWhileExpression()
		 * @generated
		 */
		EClass XWHILE_EXPRESSION = eINSTANCE.getXWhileExpression();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XWHILE_EXPRESSION__PREDICATE = eINSTANCE.getXWhileExpression_Predicate();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XWHILE_EXPRESSION__BODY = eINSTANCE.getXWhileExpression_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XTypeLiteralImpl <em>XType Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XTypeLiteralImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXTypeLiteral()
		 * @generated
		 */
		EClass XTYPE_LITERAL = eINSTANCE.getXTypeLiteral();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTYPE_LITERAL__TYPE = eINSTANCE.getXTypeLiteral_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xpression.impl.XInstanceOfExpressionImpl <em>XInstance Of Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xpression.impl.XInstanceOfExpressionImpl
		 * @see org.eclipse.xtext.xpression.impl.XpressionPackageImpl#getXInstanceOfExpression()
		 * @generated
		 */
		EClass XINSTANCE_OF_EXPRESSION = eINSTANCE.getXInstanceOfExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XINSTANCE_OF_EXPRESSION__TYPE = eINSTANCE.getXInstanceOfExpression_Type();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XINSTANCE_OF_EXPRESSION__EXPRESSION = eINSTANCE.getXInstanceOfExpression_Expression();

	}

} //XpressionPackage
