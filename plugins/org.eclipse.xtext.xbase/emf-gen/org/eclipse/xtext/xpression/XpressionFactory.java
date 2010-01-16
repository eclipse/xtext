/**
 * <copyright>
 * </copyright>
 *
 * $Id: XpressionFactory.java,v 1.3 2010/01/16 08:50:52 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xpression.XpressionPackage
 * @generated
 */
public interface XpressionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XpressionFactory eINSTANCE = org.eclipse.xtext.xpression.impl.XpressionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>XExpression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XExpression</em>'.
	 * @generated
	 */
	XExpression createXExpression();

	/**
	 * Returns a new object of class '<em>XIf Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XIf Expression</em>'.
	 * @generated
	 */
	XIfExpression createXIfExpression();

	/**
	 * Returns a new object of class '<em>XSwitch Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XSwitch Expression</em>'.
	 * @generated
	 */
	XSwitchExpression createXSwitchExpression();

	/**
	 * Returns a new object of class '<em>XCase Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCase Part</em>'.
	 * @generated
	 */
	XCasePart createXCasePart();

	/**
	 * Returns a new object of class '<em>XBlock Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBlock Expression</em>'.
	 * @generated
	 */
	XBlockExpression createXBlockExpression();

	/**
	 * Returns a new object of class '<em>XVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XVariable Declaration</em>'.
	 * @generated
	 */
	XVariableDeclaration createXVariableDeclaration();

	/**
	 * Returns a new object of class '<em>XDeclared Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XDeclared Parameter</em>'.
	 * @generated
	 */
	XDeclaredParameter createXDeclaredParameter();

	/**
	 * Returns a new object of class '<em>XFeature Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XFeature Call</em>'.
	 * @generated
	 */
	XFeatureCall createXFeatureCall();

	/**
	 * Returns a new object of class '<em>XConstructor Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XConstructor Call</em>'.
	 * @generated
	 */
	XConstructorCall createXConstructorCall();

	/**
	 * Returns a new object of class '<em>XBoolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBoolean Literal</em>'.
	 * @generated
	 */
	XBooleanLiteral createXBooleanLiteral();

	/**
	 * Returns a new object of class '<em>XNull Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XNull Literal</em>'.
	 * @generated
	 */
	XNullLiteral createXNullLiteral();

	/**
	 * Returns a new object of class '<em>XInt Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XInt Literal</em>'.
	 * @generated
	 */
	XIntLiteral createXIntLiteral();

	/**
	 * Returns a new object of class '<em>XString Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XString Literal</em>'.
	 * @generated
	 */
	XStringLiteral createXStringLiteral();

	/**
	 * Returns a new object of class '<em>XRich String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XRich String</em>'.
	 * @generated
	 */
	XRichString createXRichString();

	/**
	 * Returns a new object of class '<em>XRich String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XRich String Literal</em>'.
	 * @generated
	 */
	XRichStringLiteral createXRichStringLiteral();

	/**
	 * Returns a new object of class '<em>XClosure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XClosure</em>'.
	 * @generated
	 */
	XClosure createXClosure();

	/**
	 * Returns a new object of class '<em>XCasted Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XCasted Expression</em>'.
	 * @generated
	 */
	XCastedExpression createXCastedExpression();

	/**
	 * Returns a new object of class '<em>XAssignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XAssignment</em>'.
	 * @generated
	 */
	XAssignment createXAssignment();

	/**
	 * Returns a new object of class '<em>XBinary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XBinary Operation</em>'.
	 * @generated
	 */
	XBinaryOperation createXBinaryOperation();

	/**
	 * Returns a new object of class '<em>XUnary Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XUnary Operation</em>'.
	 * @generated
	 */
	XUnaryOperation createXUnaryOperation();

	/**
	 * Returns a new object of class '<em>XWhile Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XWhile Expression</em>'.
	 * @generated
	 */
	XWhileExpression createXWhileExpression();

	/**
	 * Returns a new object of class '<em>XType Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XType Literal</em>'.
	 * @generated
	 */
	XTypeLiteral createXTypeLiteral();

	/**
	 * Returns a new object of class '<em>XInstance Of Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XInstance Of Expression</em>'.
	 * @generated
	 */
	XInstanceOfExpression createXInstanceOfExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XpressionPackage getXpressionPackage();

} //XpressionFactory
