/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase;

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
 * <!-- begin-model-doc -->
 * @since 2.7
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * <!-- end-model-doc -->
 * @see org.eclipse.xtext.xbase.XbaseFactory
 * @model kind="package"
 * @generated
 */
public interface XbasePackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xbase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/xtext/xbase/Xbase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xbase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XbasePackage eINSTANCE = org.eclipse.xtext.xbase.impl.XbasePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XExpressionImpl <em>XExpression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXExpression()
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
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XIfExpressionImpl <em>XIf Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XIfExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXIfExpression()
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
	 * The feature id for the '<em><b>Conditional Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * @since 2.18
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION__CONDITIONAL_EXPRESSION = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XIf Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * @since 2.18
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XIF_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XSwitchExpressionImpl <em>XSwitch Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XSwitchExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXSwitchExpression()
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
	 * The feature id for the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION__DECLARED_PARAM = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XSwitch Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSWITCH_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XCasePartImpl <em>XCase Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XCasePartImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXCasePart()
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
	 * The feature id for the '<em><b>Type Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART__TYPE_GUARD = 2;

	/**
	 * The feature id for the '<em><b>Fall Through</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART__FALL_THROUGH = 3;

	/**
	 * The number of structural features of the '<em>XCase Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCASE_PART_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XBlockExpressionImpl <em>XBlock Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XBlockExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXBlockExpression()
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
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XVariableDeclarationImpl <em>XVariable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XVariableDeclarationImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXVariableDeclaration()
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
	 * The feature id for the '<em><b>Writeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION__WRITEABLE = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XVariable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XVARIABLE_DECLARATION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl <em>XAbstract Feature Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXAbstractFeatureCall()
	 * @generated
	 */
	int XABSTRACT_FEATURE_CALL = 6;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__FEATURE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__VALID_FEATURE = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT = XEXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>XAbstract Feature Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_FEATURE_CALL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XMemberFeatureCallImpl <em>XMember Feature Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XMemberFeatureCallImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXMemberFeatureCall()
	 * @generated
	 */
	int XMEMBER_FEATURE_CALL = 7;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Member Call Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member Call Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Explicit Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__EXPLICIT_STATIC = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Null Safe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__NULL_SAFE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Type Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__TYPE_LITERAL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Static With Declaring Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__STATIC_WITH_DECLARING_TYPE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Package Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL__PACKAGE_FRAGMENT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>XMember Feature Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMEMBER_FEATURE_CALL_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XFeatureCallImpl <em>XFeature Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XFeatureCallImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXFeatureCall()
	 * @generated
	 */
	int XFEATURE_CALL = 8;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Feature Call Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__FEATURE_CALL_ARGUMENTS = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Explicit Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__EXPLICIT_OPERATION_CALL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__TYPE_LITERAL = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Package Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL__PACKAGE_FRAGMENT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XFeature Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFEATURE_CALL_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XConstructorCallImpl <em>XConstructor Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XConstructorCallImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXConstructorCall()
	 * @generated
	 */
	int XCONSTRUCTOR_CALL = 9;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__CONSTRUCTOR = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__ARGUMENTS = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__TYPE_ARGUMENTS = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__VALID_FEATURE = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Explicit Constructor Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__EXPLICIT_CONSTRUCTOR_CALL = XEXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Anonymous Class Constructor Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL__ANONYMOUS_CLASS_CONSTRUCTOR_CALL = XEXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>XConstructor Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCONSTRUCTOR_CALL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XBooleanLiteralImpl <em>XBoolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XBooleanLiteralImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXBooleanLiteral()
	 * @generated
	 */
	int XBOOLEAN_LITERAL = 10;

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
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XNullLiteralImpl <em>XNull Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XNullLiteralImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXNullLiteral()
	 * @generated
	 */
	int XNULL_LITERAL = 11;

	/**
	 * The number of structural features of the '<em>XNull Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XNULL_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XNumberLiteralImpl <em>XNumber Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XNumberLiteralImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXNumberLiteral()
	 * @generated
	 */
	int XNUMBER_LITERAL = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XNUMBER_LITERAL__VALUE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XNumber Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XNUMBER_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XStringLiteralImpl <em>XString Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XStringLiteralImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXStringLiteral()
	 * @generated
	 */
	int XSTRING_LITERAL = 13;

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
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XCollectionLiteralImpl <em>XCollection Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XCollectionLiteralImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXCollectionLiteral()
	 * @generated
	 */
	int XCOLLECTION_LITERAL = 14;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOLLECTION_LITERAL__ELEMENTS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XCollection Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCOLLECTION_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XListLiteralImpl <em>XList Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XListLiteralImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXListLiteral()
	 * @generated
	 */
	int XLIST_LITERAL = 15;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIST_LITERAL__ELEMENTS = XCOLLECTION_LITERAL__ELEMENTS;

	/**
	 * The number of structural features of the '<em>XList Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XLIST_LITERAL_FEATURE_COUNT = XCOLLECTION_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XSetLiteralImpl <em>XSet Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XSetLiteralImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXSetLiteral()
	 * @generated
	 */
	int XSET_LITERAL = 16;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSET_LITERAL__ELEMENTS = XCOLLECTION_LITERAL__ELEMENTS;

	/**
	 * The number of structural features of the '<em>XSet Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSET_LITERAL_FEATURE_COUNT = XCOLLECTION_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XClosureImpl <em>XClosure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XClosureImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXClosure()
	 * @generated
	 */
	int XCLOSURE = 17;

	/**
	 * The feature id for the '<em><b>Declared Formal Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__DECLARED_FORMAL_PARAMETERS = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Explicit Syntax</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__EXPLICIT_SYNTAX = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Implicit Formal Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE__IMPLICIT_FORMAL_PARAMETERS = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XClosure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCLOSURE_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XCastedExpressionImpl <em>XCasted Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XCastedExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXCastedExpression()
	 * @generated
	 */
	int XCASTED_EXPRESSION = 18;

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
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XBinaryOperationImpl <em>XBinary Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XBinaryOperationImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXBinaryOperation()
	 * @generated
	 */
	int XBINARY_OPERATION = 19;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__LEFT_OPERAND = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__RIGHT_OPERAND = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reassign First Argument</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION__REASSIGN_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XBinary Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBINARY_OPERATION_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XUnaryOperationImpl <em>XUnary Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XUnaryOperationImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXUnaryOperation()
	 * @generated
	 */
	int XUNARY_OPERATION = 20;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION__OPERAND = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XUnary Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XUNARY_OPERATION_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XPostfixOperationImpl <em>XPostfix Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XPostfixOperationImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXPostfixOperation()
	 * @generated
	 */
	int XPOSTFIX_OPERATION = 21;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION__OPERAND = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XPostfix Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XPOSTFIX_OPERATION_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XForLoopExpressionImpl <em>XFor Loop Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XForLoopExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXForLoopExpression()
	 * @generated
	 */
	int XFOR_LOOP_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>For Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_LOOP_EXPRESSION__FOR_EXPRESSION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_LOOP_EXPRESSION__EACH_EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_LOOP_EXPRESSION__DECLARED_PARAM = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>XFor Loop Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XFOR_LOOP_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XBasicForLoopExpressionImpl <em>XBasic For Loop Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XBasicForLoopExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXBasicForLoopExpression()
	 * @generated
	 */
	int XBASIC_FOR_LOOP_EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBASIC_FOR_LOOP_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Each Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBASIC_FOR_LOOP_EXPRESSION__EACH_EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Init Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBASIC_FOR_LOOP_EXPRESSION__INIT_EXPRESSIONS = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Update Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBASIC_FOR_LOOP_EXPRESSION__UPDATE_EXPRESSIONS = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XBasic For Loop Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XBASIC_FOR_LOOP_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XAbstractWhileExpressionImpl <em>XAbstract While Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XAbstractWhileExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXAbstractWhileExpression()
	 * @generated
	 */
	int XABSTRACT_WHILE_EXPRESSION = 24;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_WHILE_EXPRESSION__PREDICATE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_WHILE_EXPRESSION__BODY = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XAbstract While Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XABSTRACT_WHILE_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XDoWhileExpressionImpl <em>XDo While Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XDoWhileExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXDoWhileExpression()
	 * @generated
	 */
	int XDO_WHILE_EXPRESSION = 25;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDO_WHILE_EXPRESSION__PREDICATE = XABSTRACT_WHILE_EXPRESSION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDO_WHILE_EXPRESSION__BODY = XABSTRACT_WHILE_EXPRESSION__BODY;

	/**
	 * The number of structural features of the '<em>XDo While Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XDO_WHILE_EXPRESSION_FEATURE_COUNT = XABSTRACT_WHILE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XWhileExpressionImpl <em>XWhile Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XWhileExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXWhileExpression()
	 * @generated
	 */
	int XWHILE_EXPRESSION = 26;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWHILE_EXPRESSION__PREDICATE = XABSTRACT_WHILE_EXPRESSION__PREDICATE;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWHILE_EXPRESSION__BODY = XABSTRACT_WHILE_EXPRESSION__BODY;

	/**
	 * The number of structural features of the '<em>XWhile Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XWHILE_EXPRESSION_FEATURE_COUNT = XABSTRACT_WHILE_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XTypeLiteralImpl <em>XType Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XTypeLiteralImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXTypeLiteral()
	 * @generated
	 */
	int XTYPE_LITERAL = 27;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTYPE_LITERAL__TYPE = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Array Dimensions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTYPE_LITERAL__ARRAY_DIMENSIONS = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XType Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTYPE_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XInstanceOfExpressionImpl <em>XInstance Of Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XInstanceOfExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXInstanceOfExpression()
	 * @generated
	 */
	int XINSTANCE_OF_EXPRESSION = 28;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
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
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XThrowExpressionImpl <em>XThrow Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XThrowExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXThrowExpression()
	 * @generated
	 */
	int XTHROW_EXPRESSION = 29;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTHROW_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XThrow Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTHROW_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XTryCatchFinallyExpressionImpl <em>XTry Catch Finally Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XTryCatchFinallyExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXTryCatchFinallyExpression()
	 * @generated
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION = 30;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Finally Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Catch Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES = XEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * @since 2.18
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES = XEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XTry Catch Finally Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * @since 2.18
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XTRY_CATCH_FINALLY_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XCatchClauseImpl <em>XCatch Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XCatchClauseImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXCatchClause()
	 * @generated
	 */
	int XCATCH_CLAUSE = 31;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCATCH_CLAUSE__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Declared Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCATCH_CLAUSE__DECLARED_PARAM = 1;

	/**
	 * The number of structural features of the '<em>XCatch Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XCATCH_CLAUSE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XAssignmentImpl <em>XAssignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XAssignmentImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXAssignment()
	 * @generated
	 */
	int XASSIGNMENT = 32;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__FEATURE = XABSTRACT_FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__TYPE_ARGUMENTS = XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__IMPLICIT_RECEIVER = XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER;

	/**
	 * The feature id for the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__INVALID_FEATURE_ISSUE_CODE = XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE;

	/**
	 * The feature id for the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__VALID_FEATURE = XABSTRACT_FEATURE_CALL__VALID_FEATURE;

	/**
	 * The feature id for the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__IMPLICIT_FIRST_ARGUMENT = XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT;

	/**
	 * The feature id for the '<em><b>Assignable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__ASSIGNABLE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__VALUE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Explicit Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__EXPLICIT_STATIC = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Static With Declaring Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT__STATIC_WITH_DECLARING_TYPE = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XAssignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XASSIGNMENT_FEATURE_COUNT = XABSTRACT_FEATURE_CALL_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XReturnExpressionImpl <em>XReturn Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XReturnExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXReturnExpression()
	 * @generated
	 */
	int XRETURN_EXPRESSION = 33;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XRETURN_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>XReturn Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XRETURN_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.xtext.xbase.impl.XSynchronizedExpressionImpl <em>XSynchronized Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.xtext.xbase.impl.XSynchronizedExpressionImpl
	 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXSynchronizedExpression()
	 * @generated
	 */
	int XSYNCHRONIZED_EXPRESSION = 34;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSYNCHRONIZED_EXPRESSION__PARAM = XEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSYNCHRONIZED_EXPRESSION__EXPRESSION = XEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>XSynchronized Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XSYNCHRONIZED_EXPRESSION_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XExpression <em>XExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XExpression</em>'.
	 * @see org.eclipse.xtext.xbase.XExpression
	 * @generated
	 */
	EClass getXExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XIfExpression <em>XIf Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XIf Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XIfExpression
	 * @generated
	 */
	EClass getXIfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XIfExpression#getIf <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If</em>'.
	 * @see org.eclipse.xtext.xbase.XIfExpression#getIf()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EReference getXIfExpression_If();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XIfExpression#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.xtext.xbase.XIfExpression#getThen()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EReference getXIfExpression_Then();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XIfExpression#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.eclipse.xtext.xbase.XIfExpression#getElse()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EReference getXIfExpression_Else();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XIfExpression#isConditionalExpression <em>Conditional Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 2.18
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Conditional Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XIfExpression#isConditionalExpression()
	 * @see #getXIfExpression()
	 * @generated
	 */
	EAttribute getXIfExpression_ConditionalExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XSwitchExpression <em>XSwitch Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSwitch Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XSwitchExpression
	 * @generated
	 */
	EClass getXSwitchExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XSwitchExpression#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch</em>'.
	 * @see org.eclipse.xtext.xbase.XSwitchExpression#getSwitch()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_Switch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XSwitchExpression#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see org.eclipse.xtext.xbase.XSwitchExpression#getCases()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_Cases();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XSwitchExpression#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see org.eclipse.xtext.xbase.XSwitchExpression#getDefault()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_Default();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XSwitchExpression#getDeclaredParam <em>Declared Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Param</em>'.
	 * @see org.eclipse.xtext.xbase.XSwitchExpression#getDeclaredParam()
	 * @see #getXSwitchExpression()
	 * @generated
	 */
	EReference getXSwitchExpression_DeclaredParam();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XCasePart <em>XCase Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCase Part</em>'.
	 * @see org.eclipse.xtext.xbase.XCasePart
	 * @generated
	 */
	EClass getXCasePart();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XCasePart#getCase <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Case</em>'.
	 * @see org.eclipse.xtext.xbase.XCasePart#getCase()
	 * @see #getXCasePart()
	 * @generated
	 */
	EReference getXCasePart_Case();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XCasePart#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.xtext.xbase.XCasePart#getThen()
	 * @see #getXCasePart()
	 * @generated
	 */
	EReference getXCasePart_Then();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XCasePart#getTypeGuard <em>Type Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Guard</em>'.
	 * @see org.eclipse.xtext.xbase.XCasePart#getTypeGuard()
	 * @see #getXCasePart()
	 * @generated
	 */
	EReference getXCasePart_TypeGuard();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XCasePart#isFallThrough <em>Fall Through</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fall Through</em>'.
	 * @see org.eclipse.xtext.xbase.XCasePart#isFallThrough()
	 * @see #getXCasePart()
	 * @generated
	 */
	EAttribute getXCasePart_FallThrough();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XBlockExpression <em>XBlock Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBlock Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XBlockExpression
	 * @generated
	 */
	EClass getXBlockExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XBlockExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.xtext.xbase.XBlockExpression#getExpressions()
	 * @see #getXBlockExpression()
	 * @generated
	 */
	EReference getXBlockExpression_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XVariableDeclaration <em>XVariable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XVariable Declaration</em>'.
	 * @see org.eclipse.xtext.xbase.XVariableDeclaration
	 * @generated
	 */
	EClass getXVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XVariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xbase.XVariableDeclaration#getType()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EReference getXVariableDeclaration_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XVariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.xtext.xbase.XVariableDeclaration#getName()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EAttribute getXVariableDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XVariableDeclaration#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see org.eclipse.xtext.xbase.XVariableDeclaration#getRight()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EReference getXVariableDeclaration_Right();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XVariableDeclaration#isWriteable <em>Writeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Writeable</em>'.
	 * @see org.eclipse.xtext.xbase.XVariableDeclaration#isWriteable()
	 * @see #getXVariableDeclaration()
	 * @generated
	 */
	EAttribute getXVariableDeclaration_Writeable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall <em>XAbstract Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAbstract Feature Call</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractFeatureCall
	 * @generated
	 */
	EClass getXAbstractFeatureCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractFeatureCall#getFeature()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EReference getXAbstractFeatureCall_Feature();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getTypeArguments <em>Type Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Arguments</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractFeatureCall#getTypeArguments()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EReference getXAbstractFeatureCall_TypeArguments();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitReceiver <em>Implicit Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implicit Receiver</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitReceiver()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EReference getXAbstractFeatureCall_ImplicitReceiver();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invalid Feature Issue Code</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractFeatureCall#getInvalidFeatureIssueCode()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EAttribute getXAbstractFeatureCall_InvalidFeatureIssueCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#isValidFeature <em>Valid Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid Feature</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractFeatureCall#isValidFeature()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EAttribute getXAbstractFeatureCall_ValidFeature();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitFirstArgument <em>Implicit First Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Implicit First Argument</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitFirstArgument()
	 * @see #getXAbstractFeatureCall()
	 * @generated
	 */
	EReference getXAbstractFeatureCall_ImplicitFirstArgument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XMemberFeatureCall <em>XMember Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMember Feature Call</em>'.
	 * @see org.eclipse.xtext.xbase.XMemberFeatureCall
	 * @generated
	 */
	EClass getXMemberFeatureCall();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#getMemberCallTarget <em>Member Call Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Member Call Target</em>'.
	 * @see org.eclipse.xtext.xbase.XMemberFeatureCall#getMemberCallTarget()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EReference getXMemberFeatureCall_MemberCallTarget();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#getMemberCallArguments <em>Member Call Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member Call Arguments</em>'.
	 * @see org.eclipse.xtext.xbase.XMemberFeatureCall#getMemberCallArguments()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EReference getXMemberFeatureCall_MemberCallArguments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Operation Call</em>'.
	 * @see org.eclipse.xtext.xbase.XMemberFeatureCall#isExplicitOperationCall()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_ExplicitOperationCall();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isExplicitStatic <em>Explicit Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Static</em>'.
	 * @see org.eclipse.xtext.xbase.XMemberFeatureCall#isExplicitStatic()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_ExplicitStatic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isNullSafe <em>Null Safe</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Null Safe</em>'.
	 * @see org.eclipse.xtext.xbase.XMemberFeatureCall#isNullSafe()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_NullSafe();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isTypeLiteral <em>Type Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XMemberFeatureCall#isTypeLiteral()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_TypeLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isStaticWithDeclaringType <em>Static With Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static With Declaring Type</em>'.
	 * @see org.eclipse.xtext.xbase.XMemberFeatureCall#isStaticWithDeclaringType()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_StaticWithDeclaringType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XMemberFeatureCall#isPackageFragment <em>Package Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Fragment</em>'.
	 * @see org.eclipse.xtext.xbase.XMemberFeatureCall#isPackageFragment()
	 * @see #getXMemberFeatureCall()
	 * @generated
	 */
	EAttribute getXMemberFeatureCall_PackageFragment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XFeatureCall <em>XFeature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFeature Call</em>'.
	 * @see org.eclipse.xtext.xbase.XFeatureCall
	 * @generated
	 */
	EClass getXFeatureCall();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XFeatureCall#getFeatureCallArguments <em>Feature Call Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Call Arguments</em>'.
	 * @see org.eclipse.xtext.xbase.XFeatureCall#getFeatureCallArguments()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EReference getXFeatureCall_FeatureCallArguments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Operation Call</em>'.
	 * @see org.eclipse.xtext.xbase.XFeatureCall#isExplicitOperationCall()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EAttribute getXFeatureCall_ExplicitOperationCall();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XFeatureCall#isTypeLiteral <em>Type Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XFeatureCall#isTypeLiteral()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EAttribute getXFeatureCall_TypeLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XFeatureCall#isPackageFragment <em>Package Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Fragment</em>'.
	 * @see org.eclipse.xtext.xbase.XFeatureCall#isPackageFragment()
	 * @see #getXFeatureCall()
	 * @generated
	 */
	EAttribute getXFeatureCall_PackageFragment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XConstructorCall <em>XConstructor Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XConstructor Call</em>'.
	 * @see org.eclipse.xtext.xbase.XConstructorCall
	 * @generated
	 */
	EClass getXConstructorCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xbase.XConstructorCall#getConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constructor</em>'.
	 * @see org.eclipse.xtext.xbase.XConstructorCall#getConstructor()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EReference getXConstructorCall_Constructor();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XConstructorCall#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipse.xtext.xbase.XConstructorCall#getArguments()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EReference getXConstructorCall_Arguments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XConstructorCall#getTypeArguments <em>Type Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Arguments</em>'.
	 * @see org.eclipse.xtext.xbase.XConstructorCall#getTypeArguments()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EReference getXConstructorCall_TypeArguments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XConstructorCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invalid Feature Issue Code</em>'.
	 * @see org.eclipse.xtext.xbase.XConstructorCall#getInvalidFeatureIssueCode()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EAttribute getXConstructorCall_InvalidFeatureIssueCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XConstructorCall#isValidFeature <em>Valid Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valid Feature</em>'.
	 * @see org.eclipse.xtext.xbase.XConstructorCall#isValidFeature()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EAttribute getXConstructorCall_ValidFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XConstructorCall#isExplicitConstructorCall <em>Explicit Constructor Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Constructor Call</em>'.
	 * @see org.eclipse.xtext.xbase.XConstructorCall#isExplicitConstructorCall()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EAttribute getXConstructorCall_ExplicitConstructorCall();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XConstructorCall#isAnonymousClassConstructorCall <em>Anonymous Class Constructor Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Anonymous Class Constructor Call</em>'.
	 * @see org.eclipse.xtext.xbase.XConstructorCall#isAnonymousClassConstructorCall()
	 * @see #getXConstructorCall()
	 * @generated
	 */
	EAttribute getXConstructorCall_AnonymousClassConstructorCall();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XBooleanLiteral <em>XBoolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBoolean Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XBooleanLiteral
	 * @generated
	 */
	EClass getXBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XBooleanLiteral#isIsTrue <em>Is True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is True</em>'.
	 * @see org.eclipse.xtext.xbase.XBooleanLiteral#isIsTrue()
	 * @see #getXBooleanLiteral()
	 * @generated
	 */
	EAttribute getXBooleanLiteral_IsTrue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XNullLiteral <em>XNull Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XNull Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XNullLiteral
	 * @generated
	 */
	EClass getXNullLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XNumberLiteral <em>XNumber Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XNumber Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XNumberLiteral
	 * @generated
	 */
	EClass getXNumberLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XNumberLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.xtext.xbase.XNumberLiteral#getValue()
	 * @see #getXNumberLiteral()
	 * @generated
	 */
	EAttribute getXNumberLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XStringLiteral <em>XString Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XString Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XStringLiteral
	 * @generated
	 */
	EClass getXStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XStringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.xtext.xbase.XStringLiteral#getValue()
	 * @see #getXStringLiteral()
	 * @generated
	 */
	EAttribute getXStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XCollectionLiteral <em>XCollection Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCollection Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XCollectionLiteral
	 * @generated
	 */
	EClass getXCollectionLiteral();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XCollectionLiteral#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.xtext.xbase.XCollectionLiteral#getElements()
	 * @see #getXCollectionLiteral()
	 * @generated
	 */
	EReference getXCollectionLiteral_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XListLiteral <em>XList Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XList Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XListLiteral
	 * @generated
	 */
	EClass getXListLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XSetLiteral <em>XSet Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSet Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XSetLiteral
	 * @generated
	 */
	EClass getXSetLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XClosure <em>XClosure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XClosure</em>'.
	 * @see org.eclipse.xtext.xbase.XClosure
	 * @generated
	 */
	EClass getXClosure();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XClosure#getDeclaredFormalParameters <em>Declared Formal Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Formal Parameters</em>'.
	 * @see org.eclipse.xtext.xbase.XClosure#getDeclaredFormalParameters()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_DeclaredFormalParameters();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XClosure#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XClosure#getExpression()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XClosure#isExplicitSyntax <em>Explicit Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Syntax</em>'.
	 * @see org.eclipse.xtext.xbase.XClosure#isExplicitSyntax()
	 * @see #getXClosure()
	 * @generated
	 */
	EAttribute getXClosure_ExplicitSyntax();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XClosure#getImplicitFormalParameters <em>Implicit Formal Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implicit Formal Parameters</em>'.
	 * @see org.eclipse.xtext.xbase.XClosure#getImplicitFormalParameters()
	 * @see #getXClosure()
	 * @generated
	 */
	EReference getXClosure_ImplicitFormalParameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XCastedExpression <em>XCasted Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCasted Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XCastedExpression
	 * @generated
	 */
	EClass getXCastedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XCastedExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xbase.XCastedExpression#getType()
	 * @see #getXCastedExpression()
	 * @generated
	 */
	EReference getXCastedExpression_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XCastedExpression#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.xtext.xbase.XCastedExpression#getTarget()
	 * @see #getXCastedExpression()
	 * @generated
	 */
	EReference getXCastedExpression_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XBinaryOperation <em>XBinary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBinary Operation</em>'.
	 * @see org.eclipse.xtext.xbase.XBinaryOperation
	 * @generated
	 */
	EClass getXBinaryOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XBinaryOperation#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipse.xtext.xbase.XBinaryOperation#getLeftOperand()
	 * @see #getXBinaryOperation()
	 * @generated
	 */
	EReference getXBinaryOperation_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XBinaryOperation#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipse.xtext.xbase.XBinaryOperation#getRightOperand()
	 * @see #getXBinaryOperation()
	 * @generated
	 */
	EReference getXBinaryOperation_RightOperand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XBinaryOperation#isReassignFirstArgument <em>Reassign First Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reassign First Argument</em>'.
	 * @see org.eclipse.xtext.xbase.XBinaryOperation#isReassignFirstArgument()
	 * @see #getXBinaryOperation()
	 * @generated
	 */
	EAttribute getXBinaryOperation_ReassignFirstArgument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XUnaryOperation <em>XUnary Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XUnary Operation</em>'.
	 * @see org.eclipse.xtext.xbase.XUnaryOperation
	 * @generated
	 */
	EClass getXUnaryOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XUnaryOperation#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.eclipse.xtext.xbase.XUnaryOperation#getOperand()
	 * @see #getXUnaryOperation()
	 * @generated
	 */
	EReference getXUnaryOperation_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XPostfixOperation <em>XPostfix Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XPostfix Operation</em>'.
	 * @see org.eclipse.xtext.xbase.XPostfixOperation
	 * @generated
	 */
	EClass getXPostfixOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XPostfixOperation#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.eclipse.xtext.xbase.XPostfixOperation#getOperand()
	 * @see #getXPostfixOperation()
	 * @generated
	 */
	EReference getXPostfixOperation_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XForLoopExpression <em>XFor Loop Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XFor Loop Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XForLoopExpression
	 * @generated
	 */
	EClass getXForLoopExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XForLoopExpression#getForExpression <em>For Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>For Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XForLoopExpression#getForExpression()
	 * @see #getXForLoopExpression()
	 * @generated
	 */
	EReference getXForLoopExpression_ForExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XForLoopExpression#getEachExpression <em>Each Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Each Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XForLoopExpression#getEachExpression()
	 * @see #getXForLoopExpression()
	 * @generated
	 */
	EReference getXForLoopExpression_EachExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XForLoopExpression#getDeclaredParam <em>Declared Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Param</em>'.
	 * @see org.eclipse.xtext.xbase.XForLoopExpression#getDeclaredParam()
	 * @see #getXForLoopExpression()
	 * @generated
	 */
	EReference getXForLoopExpression_DeclaredParam();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XBasicForLoopExpression <em>XBasic For Loop Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XBasic For Loop Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XBasicForLoopExpression
	 * @generated
	 */
	EClass getXBasicForLoopExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XBasicForLoopExpression#getExpression()
	 * @see #getXBasicForLoopExpression()
	 * @generated
	 */
	EReference getXBasicForLoopExpression_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getEachExpression <em>Each Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Each Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XBasicForLoopExpression#getEachExpression()
	 * @see #getXBasicForLoopExpression()
	 * @generated
	 */
	EReference getXBasicForLoopExpression_EachExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getInitExpressions <em>Init Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Init Expressions</em>'.
	 * @see org.eclipse.xtext.xbase.XBasicForLoopExpression#getInitExpressions()
	 * @see #getXBasicForLoopExpression()
	 * @generated
	 */
	EReference getXBasicForLoopExpression_InitExpressions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XBasicForLoopExpression#getUpdateExpressions <em>Update Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Update Expressions</em>'.
	 * @see org.eclipse.xtext.xbase.XBasicForLoopExpression#getUpdateExpressions()
	 * @see #getXBasicForLoopExpression()
	 * @generated
	 */
	EReference getXBasicForLoopExpression_UpdateExpressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XAbstractWhileExpression <em>XAbstract While Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAbstract While Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractWhileExpression
	 * @generated
	 */
	EClass getXAbstractWhileExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XAbstractWhileExpression#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractWhileExpression#getPredicate()
	 * @see #getXAbstractWhileExpression()
	 * @generated
	 */
	EReference getXAbstractWhileExpression_Predicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XAbstractWhileExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.xtext.xbase.XAbstractWhileExpression#getBody()
	 * @see #getXAbstractWhileExpression()
	 * @generated
	 */
	EReference getXAbstractWhileExpression_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XDoWhileExpression <em>XDo While Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XDo While Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XDoWhileExpression
	 * @generated
	 */
	EClass getXDoWhileExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XWhileExpression <em>XWhile Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XWhile Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XWhileExpression
	 * @generated
	 */
	EClass getXWhileExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XTypeLiteral <em>XType Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XType Literal</em>'.
	 * @see org.eclipse.xtext.xbase.XTypeLiteral
	 * @generated
	 */
	EClass getXTypeLiteral();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.xtext.xbase.XTypeLiteral#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xbase.XTypeLiteral#getType()
	 * @see #getXTypeLiteral()
	 * @generated
	 */
	EReference getXTypeLiteral_Type();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.xtext.xbase.XTypeLiteral#getArrayDimensions <em>Array Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Array Dimensions</em>'.
	 * @see org.eclipse.xtext.xbase.XTypeLiteral#getArrayDimensions()
	 * @see #getXTypeLiteral()
	 * @generated
	 */
	EAttribute getXTypeLiteral_ArrayDimensions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XInstanceOfExpression <em>XInstance Of Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XInstance Of Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XInstanceOfExpression
	 * @generated
	 */
	EClass getXInstanceOfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XInstanceOfExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipse.xtext.xbase.XInstanceOfExpression#getType()
	 * @see #getXInstanceOfExpression()
	 * @generated
	 */
	EReference getXInstanceOfExpression_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XInstanceOfExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XInstanceOfExpression#getExpression()
	 * @see #getXInstanceOfExpression()
	 * @generated
	 */
	EReference getXInstanceOfExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XThrowExpression <em>XThrow Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XThrow Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XThrowExpression
	 * @generated
	 */
	EClass getXThrowExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XThrowExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XThrowExpression#getExpression()
	 * @see #getXThrowExpression()
	 * @generated
	 */
	EReference getXThrowExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression <em>XTry Catch Finally Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XTry Catch Finally Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XTryCatchFinallyExpression
	 * @generated
	 */
	EClass getXTryCatchFinallyExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getExpression()
	 * @see #getXTryCatchFinallyExpression()
	 * @generated
	 */
	EReference getXTryCatchFinallyExpression_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getFinallyExpression <em>Finally Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Finally Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getFinallyExpression()
	 * @see #getXTryCatchFinallyExpression()
	 * @generated
	 */
	EReference getXTryCatchFinallyExpression_FinallyExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getCatchClauses <em>Catch Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Catch Clauses</em>'.
	 * @see org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getCatchClauses()
	 * @see #getXTryCatchFinallyExpression()
	 * @generated
	 */
	EReference getXTryCatchFinallyExpression_CatchClauses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * @since 2.18
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see org.eclipse.xtext.xbase.XTryCatchFinallyExpression#getResources()
	 * @see #getXTryCatchFinallyExpression()
	 * @generated
	 */
	EReference getXTryCatchFinallyExpression_Resources();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XCatchClause <em>XCatch Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XCatch Clause</em>'.
	 * @see org.eclipse.xtext.xbase.XCatchClause
	 * @generated
	 */
	EClass getXCatchClause();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XCatchClause#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XCatchClause#getExpression()
	 * @see #getXCatchClause()
	 * @generated
	 */
	EReference getXCatchClause_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XCatchClause#getDeclaredParam <em>Declared Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Param</em>'.
	 * @see org.eclipse.xtext.xbase.XCatchClause#getDeclaredParam()
	 * @see #getXCatchClause()
	 * @generated
	 */
	EReference getXCatchClause_DeclaredParam();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XAssignment <em>XAssignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XAssignment</em>'.
	 * @see org.eclipse.xtext.xbase.XAssignment
	 * @generated
	 */
	EClass getXAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XAssignment#getAssignable <em>Assignable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assignable</em>'.
	 * @see org.eclipse.xtext.xbase.XAssignment#getAssignable()
	 * @see #getXAssignment()
	 * @generated
	 */
	EReference getXAssignment_Assignable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.xtext.xbase.XAssignment#getValue()
	 * @see #getXAssignment()
	 * @generated
	 */
	EReference getXAssignment_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XAssignment#isExplicitStatic <em>Explicit Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Explicit Static</em>'.
	 * @see org.eclipse.xtext.xbase.XAssignment#isExplicitStatic()
	 * @see #getXAssignment()
	 * @generated
	 */
	EAttribute getXAssignment_ExplicitStatic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.xtext.xbase.XAssignment#isStaticWithDeclaringType <em>Static With Declaring Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static With Declaring Type</em>'.
	 * @see org.eclipse.xtext.xbase.XAssignment#isStaticWithDeclaringType()
	 * @see #getXAssignment()
	 * @generated
	 */
	EAttribute getXAssignment_StaticWithDeclaringType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XReturnExpression <em>XReturn Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XReturn Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XReturnExpression
	 * @generated
	 */
	EClass getXReturnExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XReturnExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XReturnExpression#getExpression()
	 * @see #getXReturnExpression()
	 * @generated
	 */
	EReference getXReturnExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.xtext.xbase.XSynchronizedExpression <em>XSynchronized Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XSynchronized Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XSynchronizedExpression
	 * @generated
	 */
	EClass getXSynchronizedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XSynchronizedExpression#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Param</em>'.
	 * @see org.eclipse.xtext.xbase.XSynchronizedExpression#getParam()
	 * @see #getXSynchronizedExpression()
	 * @generated
	 */
	EReference getXSynchronizedExpression_Param();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xbase.XSynchronizedExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.xtext.xbase.XSynchronizedExpression#getExpression()
	 * @see #getXSynchronizedExpression()
	 * @generated
	 */
	EReference getXSynchronizedExpression_Expression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	XbaseFactory getXbaseFactory();

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
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XExpressionImpl <em>XExpression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXExpression()
		 * @generated
		 */
		EClass XEXPRESSION = eINSTANCE.getXExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XIfExpressionImpl <em>XIf Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XIfExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXIfExpression()
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
		 * The meta object literal for the '<em><b>Conditional Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XIF_EXPRESSION__CONDITIONAL_EXPRESSION = eINSTANCE.getXIfExpression_ConditionalExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XSwitchExpressionImpl <em>XSwitch Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XSwitchExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXSwitchExpression()
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
		 * The meta object literal for the '<em><b>Declared Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSWITCH_EXPRESSION__DECLARED_PARAM = eINSTANCE.getXSwitchExpression_DeclaredParam();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XCasePartImpl <em>XCase Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XCasePartImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXCasePart()
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
		 * The meta object literal for the '<em><b>Type Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCASE_PART__TYPE_GUARD = eINSTANCE.getXCasePart_TypeGuard();

		/**
		 * The meta object literal for the '<em><b>Fall Through</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCASE_PART__FALL_THROUGH = eINSTANCE.getXCasePart_FallThrough();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XBlockExpressionImpl <em>XBlock Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XBlockExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXBlockExpression()
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
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XVariableDeclarationImpl <em>XVariable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XVariableDeclarationImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXVariableDeclaration()
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
		 * The meta object literal for the '<em><b>Writeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XVARIABLE_DECLARATION__WRITEABLE = eINSTANCE.getXVariableDeclaration_Writeable();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl <em>XAbstract Feature Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XAbstractFeatureCallImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXAbstractFeatureCall()
		 * @generated
		 */
		EClass XABSTRACT_FEATURE_CALL = eINSTANCE.getXAbstractFeatureCall();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_FEATURE_CALL__FEATURE = eINSTANCE.getXAbstractFeatureCall_Feature();

		/**
		 * The meta object literal for the '<em><b>Type Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_FEATURE_CALL__TYPE_ARGUMENTS = eINSTANCE.getXAbstractFeatureCall_TypeArguments();

		/**
		 * The meta object literal for the '<em><b>Implicit Receiver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER = eINSTANCE.getXAbstractFeatureCall_ImplicitReceiver();

		/**
		 * The meta object literal for the '<em><b>Invalid Feature Issue Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XABSTRACT_FEATURE_CALL__INVALID_FEATURE_ISSUE_CODE = eINSTANCE.getXAbstractFeatureCall_InvalidFeatureIssueCode();

		/**
		 * The meta object literal for the '<em><b>Valid Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XABSTRACT_FEATURE_CALL__VALID_FEATURE = eINSTANCE.getXAbstractFeatureCall_ValidFeature();

		/**
		 * The meta object literal for the '<em><b>Implicit First Argument</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_FEATURE_CALL__IMPLICIT_FIRST_ARGUMENT = eINSTANCE.getXAbstractFeatureCall_ImplicitFirstArgument();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XMemberFeatureCallImpl <em>XMember Feature Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XMemberFeatureCallImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXMemberFeatureCall()
		 * @generated
		 */
		EClass XMEMBER_FEATURE_CALL = eINSTANCE.getXMemberFeatureCall();

		/**
		 * The meta object literal for the '<em><b>Member Call Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET = eINSTANCE.getXMemberFeatureCall_MemberCallTarget();

		/**
		 * The meta object literal for the '<em><b>Member Call Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XMEMBER_FEATURE_CALL__MEMBER_CALL_ARGUMENTS = eINSTANCE.getXMemberFeatureCall_MemberCallArguments();

		/**
		 * The meta object literal for the '<em><b>Explicit Operation Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__EXPLICIT_OPERATION_CALL = eINSTANCE.getXMemberFeatureCall_ExplicitOperationCall();

		/**
		 * The meta object literal for the '<em><b>Explicit Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__EXPLICIT_STATIC = eINSTANCE.getXMemberFeatureCall_ExplicitStatic();

		/**
		 * The meta object literal for the '<em><b>Null Safe</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__NULL_SAFE = eINSTANCE.getXMemberFeatureCall_NullSafe();

		/**
		 * The meta object literal for the '<em><b>Type Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__TYPE_LITERAL = eINSTANCE.getXMemberFeatureCall_TypeLiteral();

		/**
		 * The meta object literal for the '<em><b>Static With Declaring Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__STATIC_WITH_DECLARING_TYPE = eINSTANCE.getXMemberFeatureCall_StaticWithDeclaringType();

		/**
		 * The meta object literal for the '<em><b>Package Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMEMBER_FEATURE_CALL__PACKAGE_FRAGMENT = eINSTANCE.getXMemberFeatureCall_PackageFragment();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XFeatureCallImpl <em>XFeature Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XFeatureCallImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXFeatureCall()
		 * @generated
		 */
		EClass XFEATURE_CALL = eINSTANCE.getXFeatureCall();

		/**
		 * The meta object literal for the '<em><b>Feature Call Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFEATURE_CALL__FEATURE_CALL_ARGUMENTS = eINSTANCE.getXFeatureCall_FeatureCallArguments();

		/**
		 * The meta object literal for the '<em><b>Explicit Operation Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFEATURE_CALL__EXPLICIT_OPERATION_CALL = eINSTANCE.getXFeatureCall_ExplicitOperationCall();

		/**
		 * The meta object literal for the '<em><b>Type Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFEATURE_CALL__TYPE_LITERAL = eINSTANCE.getXFeatureCall_TypeLiteral();

		/**
		 * The meta object literal for the '<em><b>Package Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XFEATURE_CALL__PACKAGE_FRAGMENT = eINSTANCE.getXFeatureCall_PackageFragment();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XConstructorCallImpl <em>XConstructor Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XConstructorCallImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXConstructorCall()
		 * @generated
		 */
		EClass XCONSTRUCTOR_CALL = eINSTANCE.getXConstructorCall();

		/**
		 * The meta object literal for the '<em><b>Constructor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCONSTRUCTOR_CALL__CONSTRUCTOR = eINSTANCE.getXConstructorCall_Constructor();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCONSTRUCTOR_CALL__ARGUMENTS = eINSTANCE.getXConstructorCall_Arguments();

		/**
		 * The meta object literal for the '<em><b>Type Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCONSTRUCTOR_CALL__TYPE_ARGUMENTS = eINSTANCE.getXConstructorCall_TypeArguments();

		/**
		 * The meta object literal for the '<em><b>Invalid Feature Issue Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCONSTRUCTOR_CALL__INVALID_FEATURE_ISSUE_CODE = eINSTANCE.getXConstructorCall_InvalidFeatureIssueCode();

		/**
		 * The meta object literal for the '<em><b>Valid Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCONSTRUCTOR_CALL__VALID_FEATURE = eINSTANCE.getXConstructorCall_ValidFeature();

		/**
		 * The meta object literal for the '<em><b>Explicit Constructor Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCONSTRUCTOR_CALL__EXPLICIT_CONSTRUCTOR_CALL = eINSTANCE.getXConstructorCall_ExplicitConstructorCall();

		/**
		 * The meta object literal for the '<em><b>Anonymous Class Constructor Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCONSTRUCTOR_CALL__ANONYMOUS_CLASS_CONSTRUCTOR_CALL = eINSTANCE.getXConstructorCall_AnonymousClassConstructorCall();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XBooleanLiteralImpl <em>XBoolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XBooleanLiteralImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXBooleanLiteral()
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
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XNullLiteralImpl <em>XNull Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XNullLiteralImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXNullLiteral()
		 * @generated
		 */
		EClass XNULL_LITERAL = eINSTANCE.getXNullLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XNumberLiteralImpl <em>XNumber Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XNumberLiteralImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXNumberLiteral()
		 * @generated
		 */
		EClass XNUMBER_LITERAL = eINSTANCE.getXNumberLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XNUMBER_LITERAL__VALUE = eINSTANCE.getXNumberLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XStringLiteralImpl <em>XString Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XStringLiteralImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXStringLiteral()
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
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XCollectionLiteralImpl <em>XCollection Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XCollectionLiteralImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXCollectionLiteral()
		 * @generated
		 */
		EClass XCOLLECTION_LITERAL = eINSTANCE.getXCollectionLiteral();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCOLLECTION_LITERAL__ELEMENTS = eINSTANCE.getXCollectionLiteral_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XListLiteralImpl <em>XList Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XListLiteralImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXListLiteral()
		 * @generated
		 */
		EClass XLIST_LITERAL = eINSTANCE.getXListLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XSetLiteralImpl <em>XSet Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XSetLiteralImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXSetLiteral()
		 * @generated
		 */
		EClass XSET_LITERAL = eINSTANCE.getXSetLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XClosureImpl <em>XClosure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XClosureImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXClosure()
		 * @generated
		 */
		EClass XCLOSURE = eINSTANCE.getXClosure();

		/**
		 * The meta object literal for the '<em><b>Declared Formal Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__DECLARED_FORMAL_PARAMETERS = eINSTANCE.getXClosure_DeclaredFormalParameters();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__EXPRESSION = eINSTANCE.getXClosure_Expression();

		/**
		 * The meta object literal for the '<em><b>Explicit Syntax</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XCLOSURE__EXPLICIT_SYNTAX = eINSTANCE.getXClosure_ExplicitSyntax();

		/**
		 * The meta object literal for the '<em><b>Implicit Formal Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCLOSURE__IMPLICIT_FORMAL_PARAMETERS = eINSTANCE.getXClosure_ImplicitFormalParameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XCastedExpressionImpl <em>XCasted Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XCastedExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXCastedExpression()
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
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XBinaryOperationImpl <em>XBinary Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XBinaryOperationImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXBinaryOperation()
		 * @generated
		 */
		EClass XBINARY_OPERATION = eINSTANCE.getXBinaryOperation();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBINARY_OPERATION__LEFT_OPERAND = eINSTANCE.getXBinaryOperation_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBINARY_OPERATION__RIGHT_OPERAND = eINSTANCE.getXBinaryOperation_RightOperand();

		/**
		 * The meta object literal for the '<em><b>Reassign First Argument</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XBINARY_OPERATION__REASSIGN_FIRST_ARGUMENT = eINSTANCE.getXBinaryOperation_ReassignFirstArgument();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XUnaryOperationImpl <em>XUnary Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XUnaryOperationImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXUnaryOperation()
		 * @generated
		 */
		EClass XUNARY_OPERATION = eINSTANCE.getXUnaryOperation();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XUNARY_OPERATION__OPERAND = eINSTANCE.getXUnaryOperation_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XPostfixOperationImpl <em>XPostfix Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XPostfixOperationImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXPostfixOperation()
		 * @generated
		 */
		EClass XPOSTFIX_OPERATION = eINSTANCE.getXPostfixOperation();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XPOSTFIX_OPERATION__OPERAND = eINSTANCE.getXPostfixOperation_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XForLoopExpressionImpl <em>XFor Loop Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XForLoopExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXForLoopExpression()
		 * @generated
		 */
		EClass XFOR_LOOP_EXPRESSION = eINSTANCE.getXForLoopExpression();

		/**
		 * The meta object literal for the '<em><b>For Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_LOOP_EXPRESSION__FOR_EXPRESSION = eINSTANCE.getXForLoopExpression_ForExpression();

		/**
		 * The meta object literal for the '<em><b>Each Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_LOOP_EXPRESSION__EACH_EXPRESSION = eINSTANCE.getXForLoopExpression_EachExpression();

		/**
		 * The meta object literal for the '<em><b>Declared Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XFOR_LOOP_EXPRESSION__DECLARED_PARAM = eINSTANCE.getXForLoopExpression_DeclaredParam();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XBasicForLoopExpressionImpl <em>XBasic For Loop Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XBasicForLoopExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXBasicForLoopExpression()
		 * @generated
		 */
		EClass XBASIC_FOR_LOOP_EXPRESSION = eINSTANCE.getXBasicForLoopExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBASIC_FOR_LOOP_EXPRESSION__EXPRESSION = eINSTANCE.getXBasicForLoopExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Each Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBASIC_FOR_LOOP_EXPRESSION__EACH_EXPRESSION = eINSTANCE.getXBasicForLoopExpression_EachExpression();

		/**
		 * The meta object literal for the '<em><b>Init Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBASIC_FOR_LOOP_EXPRESSION__INIT_EXPRESSIONS = eINSTANCE.getXBasicForLoopExpression_InitExpressions();

		/**
		 * The meta object literal for the '<em><b>Update Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XBASIC_FOR_LOOP_EXPRESSION__UPDATE_EXPRESSIONS = eINSTANCE.getXBasicForLoopExpression_UpdateExpressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XAbstractWhileExpressionImpl <em>XAbstract While Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XAbstractWhileExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXAbstractWhileExpression()
		 * @generated
		 */
		EClass XABSTRACT_WHILE_EXPRESSION = eINSTANCE.getXAbstractWhileExpression();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_WHILE_EXPRESSION__PREDICATE = eINSTANCE.getXAbstractWhileExpression_Predicate();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XABSTRACT_WHILE_EXPRESSION__BODY = eINSTANCE.getXAbstractWhileExpression_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XDoWhileExpressionImpl <em>XDo While Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XDoWhileExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXDoWhileExpression()
		 * @generated
		 */
		EClass XDO_WHILE_EXPRESSION = eINSTANCE.getXDoWhileExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XWhileExpressionImpl <em>XWhile Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XWhileExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXWhileExpression()
		 * @generated
		 */
		EClass XWHILE_EXPRESSION = eINSTANCE.getXWhileExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XTypeLiteralImpl <em>XType Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XTypeLiteralImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXTypeLiteral()
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
		 * The meta object literal for the '<em><b>Array Dimensions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XTYPE_LITERAL__ARRAY_DIMENSIONS = eINSTANCE.getXTypeLiteral_ArrayDimensions();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XInstanceOfExpressionImpl <em>XInstance Of Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XInstanceOfExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXInstanceOfExpression()
		 * @generated
		 */
		EClass XINSTANCE_OF_EXPRESSION = eINSTANCE.getXInstanceOfExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
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

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XThrowExpressionImpl <em>XThrow Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XThrowExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXThrowExpression()
		 * @generated
		 */
		EClass XTHROW_EXPRESSION = eINSTANCE.getXThrowExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTHROW_EXPRESSION__EXPRESSION = eINSTANCE.getXThrowExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XTryCatchFinallyExpressionImpl <em>XTry Catch Finally Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XTryCatchFinallyExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXTryCatchFinallyExpression()
		 * @generated
		 */
		EClass XTRY_CATCH_FINALLY_EXPRESSION = eINSTANCE.getXTryCatchFinallyExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTRY_CATCH_FINALLY_EXPRESSION__EXPRESSION = eINSTANCE.getXTryCatchFinallyExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Finally Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTRY_CATCH_FINALLY_EXPRESSION__FINALLY_EXPRESSION = eINSTANCE.getXTryCatchFinallyExpression_FinallyExpression();

		/**
		 * The meta object literal for the '<em><b>Catch Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTRY_CATCH_FINALLY_EXPRESSION__CATCH_CLAUSES = eINSTANCE.getXTryCatchFinallyExpression_CatchClauses();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XTRY_CATCH_FINALLY_EXPRESSION__RESOURCES = eINSTANCE.getXTryCatchFinallyExpression_Resources();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XCatchClauseImpl <em>XCatch Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XCatchClauseImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXCatchClause()
		 * @generated
		 */
		EClass XCATCH_CLAUSE = eINSTANCE.getXCatchClause();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCATCH_CLAUSE__EXPRESSION = eINSTANCE.getXCatchClause_Expression();

		/**
		 * The meta object literal for the '<em><b>Declared Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XCATCH_CLAUSE__DECLARED_PARAM = eINSTANCE.getXCatchClause_DeclaredParam();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XAssignmentImpl <em>XAssignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XAssignmentImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXAssignment()
		 * @generated
		 */
		EClass XASSIGNMENT = eINSTANCE.getXAssignment();

		/**
		 * The meta object literal for the '<em><b>Assignable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XASSIGNMENT__ASSIGNABLE = eINSTANCE.getXAssignment_Assignable();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XASSIGNMENT__VALUE = eINSTANCE.getXAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Explicit Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XASSIGNMENT__EXPLICIT_STATIC = eINSTANCE.getXAssignment_ExplicitStatic();

		/**
		 * The meta object literal for the '<em><b>Static With Declaring Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XASSIGNMENT__STATIC_WITH_DECLARING_TYPE = eINSTANCE.getXAssignment_StaticWithDeclaringType();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XReturnExpressionImpl <em>XReturn Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XReturnExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXReturnExpression()
		 * @generated
		 */
		EClass XRETURN_EXPRESSION = eINSTANCE.getXReturnExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XRETURN_EXPRESSION__EXPRESSION = eINSTANCE.getXReturnExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.xtext.xbase.impl.XSynchronizedExpressionImpl <em>XSynchronized Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.xtext.xbase.impl.XSynchronizedExpressionImpl
		 * @see org.eclipse.xtext.xbase.impl.XbasePackageImpl#getXSynchronizedExpression()
		 * @generated
		 */
		EClass XSYNCHRONIZED_EXPRESSION = eINSTANCE.getXSynchronizedExpression();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSYNCHRONIZED_EXPRESSION__PARAM = eINSTANCE.getXSynchronizedExpression_Param();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference XSYNCHRONIZED_EXPRESSION__EXPRESSION = eINSTANCE.getXSynchronizedExpression_Expression();

	}

} //XbasePackage
