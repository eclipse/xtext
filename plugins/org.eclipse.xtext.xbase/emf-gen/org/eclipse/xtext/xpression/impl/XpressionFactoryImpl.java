/**
 * <copyright>
 * </copyright>
 *
 * $Id: XpressionFactoryImpl.java,v 1.4 2010/01/19 19:53:08 sefftinge Exp $
 */
package org.eclipse.xtext.xpression.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xpression.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XpressionFactoryImpl extends EFactoryImpl implements XpressionFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XpressionFactory init()
  {
    try
    {
      XpressionFactory theXpressionFactory = (XpressionFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/xbase/Xpression"); 
      if (theXpressionFactory != null)
      {
        return theXpressionFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XpressionFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XpressionFactoryImpl()
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
      case XpressionPackage.XIF_EXPRESSION: return createXIfExpression();
      case XpressionPackage.XSWITCH_EXPRESSION: return createXSwitchExpression();
      case XpressionPackage.XCASE_PART: return createXCasePart();
      case XpressionPackage.XBLOCK_EXPRESSION: return createXBlockExpression();
      case XpressionPackage.XVARIABLE_DECLARATION: return createXVariableDeclaration();
      case XpressionPackage.XDECLARED_PARAMETER: return createXDeclaredParameter();
      case XpressionPackage.XFEATURE_CALL: return createXFeatureCall();
      case XpressionPackage.XCONSTRUCTOR_CALL: return createXConstructorCall();
      case XpressionPackage.XBOOLEAN_LITERAL: return createXBooleanLiteral();
      case XpressionPackage.XNULL_LITERAL: return createXNullLiteral();
      case XpressionPackage.XINT_LITERAL: return createXIntLiteral();
      case XpressionPackage.XSTRING_LITERAL: return createXStringLiteral();
      case XpressionPackage.XRICH_STRING: return createXRichString();
      case XpressionPackage.XRICH_STRING_LITERAL: return createXRichStringLiteral();
      case XpressionPackage.XCLOSURE: return createXClosure();
      case XpressionPackage.XCASTED_EXPRESSION: return createXCastedExpression();
      case XpressionPackage.XASSIGNMENT: return createXAssignment();
      case XpressionPackage.XBINARY_OPERATION: return createXBinaryOperation();
      case XpressionPackage.XUNARY_OPERATION: return createXUnaryOperation();
      case XpressionPackage.XWHILE_EXPRESSION: return createXWhileExpression();
      case XpressionPackage.XTYPE_LITERAL: return createXTypeLiteral();
      case XpressionPackage.XINSTANCE_OF_EXPRESSION: return createXInstanceOfExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XIfExpression createXIfExpression()
  {
    XIfExpressionImpl xIfExpression = new XIfExpressionImpl();
    return xIfExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XSwitchExpression createXSwitchExpression()
  {
    XSwitchExpressionImpl xSwitchExpression = new XSwitchExpressionImpl();
    return xSwitchExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XCasePart createXCasePart()
  {
    XCasePartImpl xCasePart = new XCasePartImpl();
    return xCasePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XBlockExpression createXBlockExpression()
  {
    XBlockExpressionImpl xBlockExpression = new XBlockExpressionImpl();
    return xBlockExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XVariableDeclaration createXVariableDeclaration()
  {
    XVariableDeclarationImpl xVariableDeclaration = new XVariableDeclarationImpl();
    return xVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XDeclaredParameter createXDeclaredParameter()
  {
    XDeclaredParameterImpl xDeclaredParameter = new XDeclaredParameterImpl();
    return xDeclaredParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XFeatureCall createXFeatureCall()
  {
    XFeatureCallImpl xFeatureCall = new XFeatureCallImpl();
    return xFeatureCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XConstructorCall createXConstructorCall()
  {
    XConstructorCallImpl xConstructorCall = new XConstructorCallImpl();
    return xConstructorCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XBooleanLiteral createXBooleanLiteral()
  {
    XBooleanLiteralImpl xBooleanLiteral = new XBooleanLiteralImpl();
    return xBooleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XNullLiteral createXNullLiteral()
  {
    XNullLiteralImpl xNullLiteral = new XNullLiteralImpl();
    return xNullLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XIntLiteral createXIntLiteral()
  {
    XIntLiteralImpl xIntLiteral = new XIntLiteralImpl();
    return xIntLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XStringLiteral createXStringLiteral()
  {
    XStringLiteralImpl xStringLiteral = new XStringLiteralImpl();
    return xStringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XRichString createXRichString()
  {
    XRichStringImpl xRichString = new XRichStringImpl();
    return xRichString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XRichStringLiteral createXRichStringLiteral()
  {
    XRichStringLiteralImpl xRichStringLiteral = new XRichStringLiteralImpl();
    return xRichStringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XClosure createXClosure()
  {
    XClosureImpl xClosure = new XClosureImpl();
    return xClosure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XCastedExpression createXCastedExpression()
  {
    XCastedExpressionImpl xCastedExpression = new XCastedExpressionImpl();
    return xCastedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XAssignment createXAssignment()
  {
    XAssignmentImpl xAssignment = new XAssignmentImpl();
    return xAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XBinaryOperation createXBinaryOperation()
  {
    XBinaryOperationImpl xBinaryOperation = new XBinaryOperationImpl();
    return xBinaryOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XUnaryOperation createXUnaryOperation()
  {
    XUnaryOperationImpl xUnaryOperation = new XUnaryOperationImpl();
    return xUnaryOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XWhileExpression createXWhileExpression()
  {
    XWhileExpressionImpl xWhileExpression = new XWhileExpressionImpl();
    return xWhileExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XTypeLiteral createXTypeLiteral()
  {
    XTypeLiteralImpl xTypeLiteral = new XTypeLiteralImpl();
    return xTypeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XInstanceOfExpression createXInstanceOfExpression()
  {
    XInstanceOfExpressionImpl xInstanceOfExpression = new XInstanceOfExpressionImpl();
    return xInstanceOfExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XpressionPackage getXpressionPackage()
  {
    return (XpressionPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XpressionPackage getPackage()
  {
    return XpressionPackage.eINSTANCE;
  }

} //XpressionFactoryImpl
