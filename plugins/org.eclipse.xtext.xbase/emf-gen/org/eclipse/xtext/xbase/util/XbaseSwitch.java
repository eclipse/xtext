/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

import org.eclipse.xtext.xbase.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.XbasePackage
 * @generated
 */
public class XbaseSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XbasePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XbaseSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = XbasePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case XbasePackage.XEXPRESSION:
			{
				XExpression xExpression = (XExpression)theEObject;
				T result = caseXExpression(xExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XIF_EXPRESSION:
			{
				XIfExpression xIfExpression = (XIfExpression)theEObject;
				T result = caseXIfExpression(xIfExpression);
				if (result == null) result = caseXExpression(xIfExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XSWITCH_EXPRESSION:
			{
				XSwitchExpression xSwitchExpression = (XSwitchExpression)theEObject;
				T result = caseXSwitchExpression(xSwitchExpression);
				if (result == null) result = caseXExpression(xSwitchExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCASE_PART:
			{
				XCasePart xCasePart = (XCasePart)theEObject;
				T result = caseXCasePart(xCasePart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XBLOCK_EXPRESSION:
			{
				XBlockExpression xBlockExpression = (XBlockExpression)theEObject;
				T result = caseXBlockExpression(xBlockExpression);
				if (result == null) result = caseXExpression(xBlockExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XVARIABLE_DECLARATION:
			{
				XVariableDeclaration xVariableDeclaration = (XVariableDeclaration)theEObject;
				T result = caseXVariableDeclaration(xVariableDeclaration);
				if (result == null) result = caseXExpression(xVariableDeclaration);
				if (result == null) result = caseJvmIdentifiableElement(xVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XABSTRACT_FEATURE_CALL:
			{
				XAbstractFeatureCall xAbstractFeatureCall = (XAbstractFeatureCall)theEObject;
				T result = caseXAbstractFeatureCall(xAbstractFeatureCall);
				if (result == null) result = caseXExpression(xAbstractFeatureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XMEMBER_FEATURE_CALL:
			{
				XMemberFeatureCall xMemberFeatureCall = (XMemberFeatureCall)theEObject;
				T result = caseXMemberFeatureCall(xMemberFeatureCall);
				if (result == null) result = caseXAbstractFeatureCall(xMemberFeatureCall);
				if (result == null) result = caseXExpression(xMemberFeatureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XFEATURE_CALL:
			{
				XFeatureCall xFeatureCall = (XFeatureCall)theEObject;
				T result = caseXFeatureCall(xFeatureCall);
				if (result == null) result = caseXAbstractFeatureCall(xFeatureCall);
				if (result == null) result = caseXExpression(xFeatureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCONSTRUCTOR_CALL:
			{
				XConstructorCall xConstructorCall = (XConstructorCall)theEObject;
				T result = caseXConstructorCall(xConstructorCall);
				if (result == null) result = caseXExpression(xConstructorCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XBOOLEAN_LITERAL:
			{
				XBooleanLiteral xBooleanLiteral = (XBooleanLiteral)theEObject;
				T result = caseXBooleanLiteral(xBooleanLiteral);
				if (result == null) result = caseXExpression(xBooleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XNULL_LITERAL:
			{
				XNullLiteral xNullLiteral = (XNullLiteral)theEObject;
				T result = caseXNullLiteral(xNullLiteral);
				if (result == null) result = caseXExpression(xNullLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XNUMBER_LITERAL:
			{
				XNumberLiteral xNumberLiteral = (XNumberLiteral)theEObject;
				T result = caseXNumberLiteral(xNumberLiteral);
				if (result == null) result = caseXExpression(xNumberLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XSTRING_LITERAL:
			{
				XStringLiteral xStringLiteral = (XStringLiteral)theEObject;
				T result = caseXStringLiteral(xStringLiteral);
				if (result == null) result = caseXExpression(xStringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCOLLECTION_LITERAL:
			{
				XCollectionLiteral xCollectionLiteral = (XCollectionLiteral)theEObject;
				T result = caseXCollectionLiteral(xCollectionLiteral);
				if (result == null) result = caseXExpression(xCollectionLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XLIST_LITERAL:
			{
				XListLiteral xListLiteral = (XListLiteral)theEObject;
				T result = caseXListLiteral(xListLiteral);
				if (result == null) result = caseXCollectionLiteral(xListLiteral);
				if (result == null) result = caseXExpression(xListLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XSET_LITERAL:
			{
				XSetLiteral xSetLiteral = (XSetLiteral)theEObject;
				T result = caseXSetLiteral(xSetLiteral);
				if (result == null) result = caseXCollectionLiteral(xSetLiteral);
				if (result == null) result = caseXExpression(xSetLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCLOSURE:
			{
				XClosure xClosure = (XClosure)theEObject;
				T result = caseXClosure(xClosure);
				if (result == null) result = caseXExpression(xClosure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCASTED_EXPRESSION:
			{
				XCastedExpression xCastedExpression = (XCastedExpression)theEObject;
				T result = caseXCastedExpression(xCastedExpression);
				if (result == null) result = caseXExpression(xCastedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XBINARY_OPERATION:
			{
				XBinaryOperation xBinaryOperation = (XBinaryOperation)theEObject;
				T result = caseXBinaryOperation(xBinaryOperation);
				if (result == null) result = caseXAbstractFeatureCall(xBinaryOperation);
				if (result == null) result = caseXExpression(xBinaryOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XUNARY_OPERATION:
			{
				XUnaryOperation xUnaryOperation = (XUnaryOperation)theEObject;
				T result = caseXUnaryOperation(xUnaryOperation);
				if (result == null) result = caseXAbstractFeatureCall(xUnaryOperation);
				if (result == null) result = caseXExpression(xUnaryOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XPOSTFIX_OPERATION:
			{
				XPostfixOperation xPostfixOperation = (XPostfixOperation)theEObject;
				T result = caseXPostfixOperation(xPostfixOperation);
				if (result == null) result = caseXAbstractFeatureCall(xPostfixOperation);
				if (result == null) result = caseXExpression(xPostfixOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XFOR_LOOP_EXPRESSION:
			{
				XForLoopExpression xForLoopExpression = (XForLoopExpression)theEObject;
				T result = caseXForLoopExpression(xForLoopExpression);
				if (result == null) result = caseXExpression(xForLoopExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XBASIC_FOR_LOOP_EXPRESSION:
			{
				XBasicForLoopExpression xBasicForLoopExpression = (XBasicForLoopExpression)theEObject;
				T result = caseXBasicForLoopExpression(xBasicForLoopExpression);
				if (result == null) result = caseXExpression(xBasicForLoopExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XABSTRACT_WHILE_EXPRESSION:
			{
				XAbstractWhileExpression xAbstractWhileExpression = (XAbstractWhileExpression)theEObject;
				T result = caseXAbstractWhileExpression(xAbstractWhileExpression);
				if (result == null) result = caseXExpression(xAbstractWhileExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XDO_WHILE_EXPRESSION:
			{
				XDoWhileExpression xDoWhileExpression = (XDoWhileExpression)theEObject;
				T result = caseXDoWhileExpression(xDoWhileExpression);
				if (result == null) result = caseXAbstractWhileExpression(xDoWhileExpression);
				if (result == null) result = caseXExpression(xDoWhileExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XWHILE_EXPRESSION:
			{
				XWhileExpression xWhileExpression = (XWhileExpression)theEObject;
				T result = caseXWhileExpression(xWhileExpression);
				if (result == null) result = caseXAbstractWhileExpression(xWhileExpression);
				if (result == null) result = caseXExpression(xWhileExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XTYPE_LITERAL:
			{
				XTypeLiteral xTypeLiteral = (XTypeLiteral)theEObject;
				T result = caseXTypeLiteral(xTypeLiteral);
				if (result == null) result = caseXExpression(xTypeLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
			{
				XInstanceOfExpression xInstanceOfExpression = (XInstanceOfExpression)theEObject;
				T result = caseXInstanceOfExpression(xInstanceOfExpression);
				if (result == null) result = caseXExpression(xInstanceOfExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XTHROW_EXPRESSION:
			{
				XThrowExpression xThrowExpression = (XThrowExpression)theEObject;
				T result = caseXThrowExpression(xThrowExpression);
				if (result == null) result = caseXExpression(xThrowExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION:
			{
				XTryCatchFinallyExpression xTryCatchFinallyExpression = (XTryCatchFinallyExpression)theEObject;
				T result = caseXTryCatchFinallyExpression(xTryCatchFinallyExpression);
				if (result == null) result = caseXExpression(xTryCatchFinallyExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XCATCH_CLAUSE:
			{
				XCatchClause xCatchClause = (XCatchClause)theEObject;
				T result = caseXCatchClause(xCatchClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XASSIGNMENT:
			{
				XAssignment xAssignment = (XAssignment)theEObject;
				T result = caseXAssignment(xAssignment);
				if (result == null) result = caseXAbstractFeatureCall(xAssignment);
				if (result == null) result = caseXExpression(xAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XRETURN_EXPRESSION:
			{
				XReturnExpression xReturnExpression = (XReturnExpression)theEObject;
				T result = caseXReturnExpression(xReturnExpression);
				if (result == null) result = caseXExpression(xReturnExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XbasePackage.XSYNCHRONIZED_EXPRESSION:
			{
				XSynchronizedExpression xSynchronizedExpression = (XSynchronizedExpression)theEObject;
				T result = caseXSynchronizedExpression(xSynchronizedExpression);
				if (result == null) result = caseXExpression(xSynchronizedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XExpression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXExpression(XExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XIf Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XIf Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXIfExpression(XIfExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSwitch Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSwitch Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSwitchExpression(XSwitchExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XCase Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XCase Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCasePart(XCasePart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XBlock Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBlock Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXBlockExpression(XBlockExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XVariable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXVariableDeclaration(XVariableDeclaration object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAbstract Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAbstract Feature Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAbstractFeatureCall(XAbstractFeatureCall object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMember Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMember Feature Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMemberFeatureCall(XMemberFeatureCall object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XFeature Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XFeature Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXFeatureCall(XFeatureCall object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XConstructor Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XConstructor Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXConstructorCall(XConstructorCall object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XBoolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBoolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXBooleanLiteral(XBooleanLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XNull Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XNull Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXNullLiteral(XNullLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XNumber Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XNumber Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXNumberLiteral(XNumberLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XString Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XString Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXStringLiteral(XStringLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XCollection Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XCollection Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCollectionLiteral(XCollectionLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XList Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XList Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXListLiteral(XListLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSet Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSet Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSetLiteral(XSetLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XClosure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XClosure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXClosure(XClosure object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XCasted Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XCasted Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCastedExpression(XCastedExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XBinary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBinary Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXBinaryOperation(XBinaryOperation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XUnary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XUnary Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXUnaryOperation(XUnaryOperation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XPostfix Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XPostfix Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXPostfixOperation(XPostfixOperation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XFor Loop Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XFor Loop Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXForLoopExpression(XForLoopExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XBasic For Loop Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XBasic For Loop Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXBasicForLoopExpression(XBasicForLoopExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAbstract While Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAbstract While Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAbstractWhileExpression(XAbstractWhileExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XDo While Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XDo While Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXDoWhileExpression(XDoWhileExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XWhile Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XWhile Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXWhileExpression(XWhileExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XType Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XType Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXTypeLiteral(XTypeLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XInstance Of Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XInstance Of Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXInstanceOfExpression(XInstanceOfExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XThrow Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XThrow Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXThrowExpression(XThrowExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XTry Catch Finally Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XTry Catch Finally Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXTryCatchFinallyExpression(XTryCatchFinallyExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XCatch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XCatch Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXCatchClause(XCatchClause object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XAssignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XAssignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXAssignment(XAssignment object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XReturn Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XReturn Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXReturnExpression(XReturnExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XSynchronized Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XSynchronized Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXSynchronizedExpression(XSynchronizedExpression object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJvmIdentifiableElement(JvmIdentifiableElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //XbaseSwitch
