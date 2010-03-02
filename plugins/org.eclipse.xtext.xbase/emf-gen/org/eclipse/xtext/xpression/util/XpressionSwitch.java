/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xpression.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xpression.*;

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
 * @see org.eclipse.xtext.xpression.XpressionPackage
 * @generated
 */
public class XpressionSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XpressionPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XpressionSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = XpressionPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case XpressionPackage.XEXPRESSION:
      {
        XExpression xExpression = (XExpression)theEObject;
        T result = caseXExpression(xExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XIF_EXPRESSION:
      {
        XIfExpression xIfExpression = (XIfExpression)theEObject;
        T result = caseXIfExpression(xIfExpression);
        if (result == null) result = caseXExpression(xIfExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XSWITCH_EXPRESSION:
      {
        XSwitchExpression xSwitchExpression = (XSwitchExpression)theEObject;
        T result = caseXSwitchExpression(xSwitchExpression);
        if (result == null) result = caseXExpression(xSwitchExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XCASE_PART:
      {
        XCasePart xCasePart = (XCasePart)theEObject;
        T result = caseXCasePart(xCasePart);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XBLOCK_EXPRESSION:
      {
        XBlockExpression xBlockExpression = (XBlockExpression)theEObject;
        T result = caseXBlockExpression(xBlockExpression);
        if (result == null) result = caseXExpression(xBlockExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XVARIABLE_DECLARATION:
      {
        XVariableDeclaration xVariableDeclaration = (XVariableDeclaration)theEObject;
        T result = caseXVariableDeclaration(xVariableDeclaration);
        if (result == null) result = caseXExpression(xVariableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XDECLARED_PARAMETER:
      {
        XDeclaredParameter xDeclaredParameter = (XDeclaredParameter)theEObject;
        T result = caseXDeclaredParameter(xDeclaredParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XFEATURE_CALL:
      {
        XFeatureCall xFeatureCall = (XFeatureCall)theEObject;
        T result = caseXFeatureCall(xFeatureCall);
        if (result == null) result = caseXExpression(xFeatureCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XCONSTRUCTOR_CALL:
      {
        XConstructorCall xConstructorCall = (XConstructorCall)theEObject;
        T result = caseXConstructorCall(xConstructorCall);
        if (result == null) result = caseXExpression(xConstructorCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XBOOLEAN_LITERAL:
      {
        XBooleanLiteral xBooleanLiteral = (XBooleanLiteral)theEObject;
        T result = caseXBooleanLiteral(xBooleanLiteral);
        if (result == null) result = caseXExpression(xBooleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XNULL_LITERAL:
      {
        XNullLiteral xNullLiteral = (XNullLiteral)theEObject;
        T result = caseXNullLiteral(xNullLiteral);
        if (result == null) result = caseXExpression(xNullLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XINT_LITERAL:
      {
        XIntLiteral xIntLiteral = (XIntLiteral)theEObject;
        T result = caseXIntLiteral(xIntLiteral);
        if (result == null) result = caseXExpression(xIntLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XSTRING_LITERAL:
      {
        XStringLiteral xStringLiteral = (XStringLiteral)theEObject;
        T result = caseXStringLiteral(xStringLiteral);
        if (result == null) result = caseXExpression(xStringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XRICH_STRING:
      {
        XRichString xRichString = (XRichString)theEObject;
        T result = caseXRichString(xRichString);
        if (result == null) result = caseXExpression(xRichString);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XRICH_STRING_LITERAL:
      {
        XRichStringLiteral xRichStringLiteral = (XRichStringLiteral)theEObject;
        T result = caseXRichStringLiteral(xRichStringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XCLOSURE:
      {
        XClosure xClosure = (XClosure)theEObject;
        T result = caseXClosure(xClosure);
        if (result == null) result = caseXExpression(xClosure);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XCASTED_EXPRESSION:
      {
        XCastedExpression xCastedExpression = (XCastedExpression)theEObject;
        T result = caseXCastedExpression(xCastedExpression);
        if (result == null) result = caseXExpression(xCastedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XASSIGNMENT:
      {
        XAssignment xAssignment = (XAssignment)theEObject;
        T result = caseXAssignment(xAssignment);
        if (result == null) result = caseXExpression(xAssignment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XBINARY_OPERATION:
      {
        XBinaryOperation xBinaryOperation = (XBinaryOperation)theEObject;
        T result = caseXBinaryOperation(xBinaryOperation);
        if (result == null) result = caseXExpression(xBinaryOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XUNARY_OPERATION:
      {
        XUnaryOperation xUnaryOperation = (XUnaryOperation)theEObject;
        T result = caseXUnaryOperation(xUnaryOperation);
        if (result == null) result = caseXExpression(xUnaryOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XWHILE_EXPRESSION:
      {
        XWhileExpression xWhileExpression = (XWhileExpression)theEObject;
        T result = caseXWhileExpression(xWhileExpression);
        if (result == null) result = caseXExpression(xWhileExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XTYPE_LITERAL:
      {
        XTypeLiteral xTypeLiteral = (XTypeLiteral)theEObject;
        T result = caseXTypeLiteral(xTypeLiteral);
        if (result == null) result = caseXExpression(xTypeLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case XpressionPackage.XINSTANCE_OF_EXPRESSION:
      {
        XInstanceOfExpression xInstanceOfExpression = (XInstanceOfExpression)theEObject;
        T result = caseXInstanceOfExpression(xInstanceOfExpression);
        if (result == null) result = caseXExpression(xInstanceOfExpression);
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
   * Returns the result of interpreting the object as an instance of '<em>XDeclared Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XDeclared Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXDeclaredParameter(XDeclaredParameter object)
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
   * Returns the result of interpreting the object as an instance of '<em>XInt Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XInt Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXIntLiteral(XIntLiteral object)
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
   * Returns the result of interpreting the object as an instance of '<em>XRich String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XRich String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXRichString(XRichString object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XRich String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XRich String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXRichStringLiteral(XRichStringLiteral object)
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
  public T defaultCase(EObject object)
  {
    return null;
  }

} //XpressionSwitch
