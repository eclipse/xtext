/**
 * Copyright (c) 2011-2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.XbasePackage
 * @since 2.7
 * @generated
 */
public interface XbaseFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XbaseFactory eINSTANCE = org.eclipse.xtext.xbase.impl.XbaseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XIf Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XIf Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XIfExpression createXIfExpression();

	/**
	 * Returns a new object of class '<em>XSwitch Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSwitch Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XSwitchExpression createXSwitchExpression();

	/**
	 * Returns a new object of class '<em>XCase Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCase Part</em>'.
	 * @since 2.7
	 * @generated
	 */
	XCasePart createXCasePart();

	/**
	 * Returns a new object of class '<em>XBlock Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBlock Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XBlockExpression createXBlockExpression();

	/**
	 * Returns a new object of class '<em>XVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XVariable Declaration</em>'.
	 * @since 2.7
	 * @generated
	 */
	XVariableDeclaration createXVariableDeclaration();

	/**
	 * Returns a new object of class '<em>XMember Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XMember Feature Call</em>'.
	 * @since 2.7
	 * @generated
	 */
	XMemberFeatureCall createXMemberFeatureCall();

	/**
	 * Returns a new object of class '<em>XFeature Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFeature Call</em>'.
	 * @since 2.7
	 * @generated
	 */
	XFeatureCall createXFeatureCall();

	/**
	 * Returns a new object of class '<em>XConstructor Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XConstructor Call</em>'.
	 * @since 2.7
	 * @generated
	 */
	XConstructorCall createXConstructorCall();

	/**
	 * Returns a new object of class '<em>XBoolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBoolean Literal</em>'.
	 * @since 2.7
	 * @generated
	 */
	XBooleanLiteral createXBooleanLiteral();

	/**
	 * Returns a new object of class '<em>XNull Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XNull Literal</em>'.
	 * @since 2.7
	 * @generated
	 */
	XNullLiteral createXNullLiteral();

	/**
	 * Returns a new object of class '<em>XNumber Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XNumber Literal</em>'.
	 * @since 2.7
	 * @generated
	 */
	XNumberLiteral createXNumberLiteral();

	/**
	 * Returns a new object of class '<em>XString Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XString Literal</em>'.
	 * @since 2.7
	 * @generated
	 */
	XStringLiteral createXStringLiteral();

	/**
	 * Returns a new object of class '<em>XList Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XList Literal</em>'.
	 * @since 2.7
	 * @generated
	 */
	XListLiteral createXListLiteral();

	/**
	 * Returns a new object of class '<em>XSet Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSet Literal</em>'.
	 * @since 2.7
	 * @generated
	 */
	XSetLiteral createXSetLiteral();

	/**
	 * Returns a new object of class '<em>XClosure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XClosure</em>'.
	 * @since 2.7
	 * @generated
	 */
	XClosure createXClosure();

	/**
	 * Returns a new object of class '<em>XCasted Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCasted Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XCastedExpression createXCastedExpression();

	/**
	 * Returns a new object of class '<em>XBinary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBinary Operation</em>'.
	 * @since 2.7
	 * @generated
	 */
	XBinaryOperation createXBinaryOperation();

	/**
	 * Returns a new object of class '<em>XUnary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XUnary Operation</em>'.
	 * @since 2.7
	 * @generated
	 */
	XUnaryOperation createXUnaryOperation();

	/**
	 * Returns a new object of class '<em>XPostfix Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XPostfix Operation</em>'.
	 * @since 2.7
	 * @generated
	 */
	XPostfixOperation createXPostfixOperation();

	/**
	 * Returns a new object of class '<em>XFor Loop Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFor Loop Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XForLoopExpression createXForLoopExpression();

	/**
	 * Returns a new object of class '<em>XBasic For Loop Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBasic For Loop Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XBasicForLoopExpression createXBasicForLoopExpression();

	/**
	 * Returns a new object of class '<em>XDo While Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XDo While Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XDoWhileExpression createXDoWhileExpression();

	/**
	 * Returns a new object of class '<em>XWhile Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XWhile Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XWhileExpression createXWhileExpression();

	/**
	 * Returns a new object of class '<em>XType Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XType Literal</em>'.
	 * @since 2.7
	 * @generated
	 */
	XTypeLiteral createXTypeLiteral();

	/**
	 * Returns a new object of class '<em>XInstance Of Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XInstance Of Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XInstanceOfExpression createXInstanceOfExpression();

	/**
	 * Returns a new object of class '<em>XThrow Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XThrow Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XThrowExpression createXThrowExpression();

	/**
	 * Returns a new object of class '<em>XTry Catch Finally Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XTry Catch Finally Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XTryCatchFinallyExpression createXTryCatchFinallyExpression();

	/**
	 * Returns a new object of class '<em>XCatch Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCatch Clause</em>'.
	 * @since 2.7
	 * @generated
	 */
	XCatchClause createXCatchClause();

	/**
	 * Returns a new object of class '<em>XAssignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAssignment</em>'.
	 * @since 2.7
	 * @generated
	 */
	XAssignment createXAssignment();

	/**
	 * Returns a new object of class '<em>XReturn Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XReturn Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XReturnExpression createXReturnExpression();

	/**
	 * Returns a new object of class '<em>XSynchronized Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSynchronized Expression</em>'.
	 * @since 2.7
	 * @generated
	 */
	XSynchronizedExpression createXSynchronizedExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XbasePackage getXbasePackage();

} //XbaseFactory
