/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xbase.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @since 2.7
 * @generated
 */
public class XbaseFactoryImpl extends EFactoryImpl implements XbaseFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XbaseFactory init()
	{
		try
		{
			XbaseFactory theXbaseFactory = (XbaseFactory)EPackage.Registry.INSTANCE.getEFactory(XbasePackage.eNS_URI);
			if (theXbaseFactory != null)
			{
				return theXbaseFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XbaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case XbasePackage.XIF_EXPRESSION: return createXIfExpression();
			case XbasePackage.XSWITCH_EXPRESSION: return createXSwitchExpression();
			case XbasePackage.XCASE_PART: return createXCasePart();
			case XbasePackage.XBLOCK_EXPRESSION: return createXBlockExpression();
			case XbasePackage.XVARIABLE_DECLARATION: return createXVariableDeclaration();
			case XbasePackage.XMEMBER_FEATURE_CALL: return createXMemberFeatureCall();
			case XbasePackage.XFEATURE_CALL: return createXFeatureCall();
			case XbasePackage.XCONSTRUCTOR_CALL: return createXConstructorCall();
			case XbasePackage.XBOOLEAN_LITERAL: return createXBooleanLiteral();
			case XbasePackage.XNULL_LITERAL: return createXNullLiteral();
			case XbasePackage.XNUMBER_LITERAL: return createXNumberLiteral();
			case XbasePackage.XSTRING_LITERAL: return createXStringLiteral();
			case XbasePackage.XLIST_LITERAL: return createXListLiteral();
			case XbasePackage.XSET_LITERAL: return createXSetLiteral();
			case XbasePackage.XCLOSURE: return createXClosure();
			case XbasePackage.XCASTED_EXPRESSION: return createXCastedExpression();
			case XbasePackage.XBINARY_OPERATION: return createXBinaryOperation();
			case XbasePackage.XUNARY_OPERATION: return createXUnaryOperation();
			case XbasePackage.XPOSTFIX_OPERATION: return createXPostfixOperation();
			case XbasePackage.XFOR_LOOP_EXPRESSION: return createXForLoopExpression();
			case XbasePackage.XBASIC_FOR_LOOP_EXPRESSION: return createXBasicForLoopExpression();
			case XbasePackage.XDO_WHILE_EXPRESSION: return createXDoWhileExpression();
			case XbasePackage.XWHILE_EXPRESSION: return createXWhileExpression();
			case XbasePackage.XTYPE_LITERAL: return createXTypeLiteral();
			case XbasePackage.XINSTANCE_OF_EXPRESSION: return createXInstanceOfExpression();
			case XbasePackage.XTHROW_EXPRESSION: return createXThrowExpression();
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION: return createXTryCatchFinallyExpression();
			case XbasePackage.XCATCH_CLAUSE: return createXCatchClause();
			case XbasePackage.XASSIGNMENT: return createXAssignment();
			case XbasePackage.XRETURN_EXPRESSION: return createXReturnExpression();
			case XbasePackage.XSYNCHRONIZED_EXPRESSION: return createXSynchronizedExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XIfExpression createXIfExpression()
	{
		XIfExpressionImpl xIfExpression = new XIfExpressionImpl();
		return xIfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XSwitchExpression createXSwitchExpression()
	{
		XSwitchExpressionImpl xSwitchExpression = new XSwitchExpressionImpl();
		return xSwitchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XCasePart createXCasePart()
	{
		XCasePartImplCustom xCasePart = new XCasePartImplCustom();
		return xCasePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XBlockExpression createXBlockExpression()
	{
		XBlockExpressionImplCustom xBlockExpression = new XBlockExpressionImplCustom();
		return xBlockExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XVariableDeclaration createXVariableDeclaration()
	{
		XVariableDeclarationImplCustom xVariableDeclaration = new XVariableDeclarationImplCustom();
		return xVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XMemberFeatureCall createXMemberFeatureCall()
	{
		XMemberFeatureCallImplCustom xMemberFeatureCall = new XMemberFeatureCallImplCustom();
		return xMemberFeatureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XFeatureCall createXFeatureCall()
	{
		XFeatureCallImplCustom xFeatureCall = new XFeatureCallImplCustom();
		return xFeatureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XConstructorCall createXConstructorCall()
	{
		XConstructorCallImplCustom xConstructorCall = new XConstructorCallImplCustom();
		return xConstructorCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XBooleanLiteral createXBooleanLiteral()
	{
		XBooleanLiteralImpl xBooleanLiteral = new XBooleanLiteralImpl();
		return xBooleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XNullLiteral createXNullLiteral()
	{
		XNullLiteralImplCustom xNullLiteral = new XNullLiteralImplCustom();
		return xNullLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XNumberLiteral createXNumberLiteral()
	{
		XNumberLiteralImpl xNumberLiteral = new XNumberLiteralImpl();
		return xNumberLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XStringLiteral createXStringLiteral()
	{
		XStringLiteralImpl xStringLiteral = new XStringLiteralImpl();
		return xStringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XListLiteral createXListLiteral()
	{
		XListLiteralImpl xListLiteral = new XListLiteralImpl();
		return xListLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XSetLiteral createXSetLiteral()
	{
		XSetLiteralImpl xSetLiteral = new XSetLiteralImpl();
		return xSetLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XClosure createXClosure()
	{
		XClosureImplCustom xClosure = new XClosureImplCustom();
		return xClosure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XCastedExpression createXCastedExpression()
	{
		XCastedExpressionImpl xCastedExpression = new XCastedExpressionImpl();
		return xCastedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XBinaryOperation createXBinaryOperation()
	{
		XBinaryOperationImplCustom xBinaryOperation = new XBinaryOperationImplCustom();
		return xBinaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XUnaryOperation createXUnaryOperation()
	{
		XUnaryOperationImplCustom xUnaryOperation = new XUnaryOperationImplCustom();
		return xUnaryOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XPostfixOperation createXPostfixOperation()
	{
		XPostfixOperationImplCustom xPostfixOperation = new XPostfixOperationImplCustom();
		return xPostfixOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XForLoopExpression createXForLoopExpression()
	{
		XForLoopExpressionImpl xForLoopExpression = new XForLoopExpressionImpl();
		return xForLoopExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XBasicForLoopExpression createXBasicForLoopExpression()
	{
		XBasicForLoopExpressionImpl xBasicForLoopExpression = new XBasicForLoopExpressionImpl();
		return xBasicForLoopExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XDoWhileExpression createXDoWhileExpression()
	{
		XDoWhileExpressionImpl xDoWhileExpression = new XDoWhileExpressionImpl();
		return xDoWhileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XWhileExpression createXWhileExpression()
	{
		XWhileExpressionImpl xWhileExpression = new XWhileExpressionImpl();
		return xWhileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XTypeLiteral createXTypeLiteral()
	{
		XTypeLiteralImplCustom xTypeLiteral = new XTypeLiteralImplCustom();
		return xTypeLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XInstanceOfExpression createXInstanceOfExpression()
	{
		XInstanceOfExpressionImpl xInstanceOfExpression = new XInstanceOfExpressionImpl();
		return xInstanceOfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XThrowExpression createXThrowExpression()
	{
		XThrowExpressionImpl xThrowExpression = new XThrowExpressionImpl();
		return xThrowExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XTryCatchFinallyExpression createXTryCatchFinallyExpression()
	{
		XTryCatchFinallyExpressionImpl xTryCatchFinallyExpression = new XTryCatchFinallyExpressionImpl();
		return xTryCatchFinallyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XCatchClause createXCatchClause()
	{
		XCatchClauseImpl xCatchClause = new XCatchClauseImpl();
		return xCatchClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XAssignment createXAssignment()
	{
		XAssignmentImplCustom xAssignment = new XAssignmentImplCustom();
		return xAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XReturnExpression createXReturnExpression()
	{
		XReturnExpressionImplCustom xReturnExpression = new XReturnExpressionImplCustom();
		return xReturnExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @since 2.7
	 * @generated
	 */
	@Override
	public XSynchronizedExpression createXSynchronizedExpression()
	{
		XSynchronizedExpressionImpl xSynchronizedExpression = new XSynchronizedExpressionImpl();
		return xSynchronizedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public XbasePackage getXbasePackage()
	{
		return (XbasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XbasePackage getPackage()
	{
		return XbasePackage.eINSTANCE;
	}

} //XbaseFactoryImpl
