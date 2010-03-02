/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xpression.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xpression.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xpression.XpressionPackage
 * @generated
 */
public class XpressionAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XpressionPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XpressionAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = XpressionPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XpressionSwitch<Adapter> modelSwitch =
    new XpressionSwitch<Adapter>()
    {
      @Override
      public Adapter caseXExpression(XExpression object)
      {
        return createXExpressionAdapter();
      }
      @Override
      public Adapter caseXIfExpression(XIfExpression object)
      {
        return createXIfExpressionAdapter();
      }
      @Override
      public Adapter caseXSwitchExpression(XSwitchExpression object)
      {
        return createXSwitchExpressionAdapter();
      }
      @Override
      public Adapter caseXCasePart(XCasePart object)
      {
        return createXCasePartAdapter();
      }
      @Override
      public Adapter caseXBlockExpression(XBlockExpression object)
      {
        return createXBlockExpressionAdapter();
      }
      @Override
      public Adapter caseXVariableDeclaration(XVariableDeclaration object)
      {
        return createXVariableDeclarationAdapter();
      }
      @Override
      public Adapter caseXDeclaredParameter(XDeclaredParameter object)
      {
        return createXDeclaredParameterAdapter();
      }
      @Override
      public Adapter caseXFeatureCall(XFeatureCall object)
      {
        return createXFeatureCallAdapter();
      }
      @Override
      public Adapter caseXConstructorCall(XConstructorCall object)
      {
        return createXConstructorCallAdapter();
      }
      @Override
      public Adapter caseXBooleanLiteral(XBooleanLiteral object)
      {
        return createXBooleanLiteralAdapter();
      }
      @Override
      public Adapter caseXNullLiteral(XNullLiteral object)
      {
        return createXNullLiteralAdapter();
      }
      @Override
      public Adapter caseXIntLiteral(XIntLiteral object)
      {
        return createXIntLiteralAdapter();
      }
      @Override
      public Adapter caseXStringLiteral(XStringLiteral object)
      {
        return createXStringLiteralAdapter();
      }
      @Override
      public Adapter caseXRichString(XRichString object)
      {
        return createXRichStringAdapter();
      }
      @Override
      public Adapter caseXRichStringLiteral(XRichStringLiteral object)
      {
        return createXRichStringLiteralAdapter();
      }
      @Override
      public Adapter caseXClosure(XClosure object)
      {
        return createXClosureAdapter();
      }
      @Override
      public Adapter caseXCastedExpression(XCastedExpression object)
      {
        return createXCastedExpressionAdapter();
      }
      @Override
      public Adapter caseXAssignment(XAssignment object)
      {
        return createXAssignmentAdapter();
      }
      @Override
      public Adapter caseXBinaryOperation(XBinaryOperation object)
      {
        return createXBinaryOperationAdapter();
      }
      @Override
      public Adapter caseXUnaryOperation(XUnaryOperation object)
      {
        return createXUnaryOperationAdapter();
      }
      @Override
      public Adapter caseXWhileExpression(XWhileExpression object)
      {
        return createXWhileExpressionAdapter();
      }
      @Override
      public Adapter caseXTypeLiteral(XTypeLiteral object)
      {
        return createXTypeLiteralAdapter();
      }
      @Override
      public Adapter caseXInstanceOfExpression(XInstanceOfExpression object)
      {
        return createXInstanceOfExpressionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XExpression <em>XExpression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XExpression
   * @generated
   */
  public Adapter createXExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XIfExpression <em>XIf Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XIfExpression
   * @generated
   */
  public Adapter createXIfExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XSwitchExpression <em>XSwitch Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XSwitchExpression
   * @generated
   */
  public Adapter createXSwitchExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XCasePart <em>XCase Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XCasePart
   * @generated
   */
  public Adapter createXCasePartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XBlockExpression <em>XBlock Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XBlockExpression
   * @generated
   */
  public Adapter createXBlockExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XVariableDeclaration <em>XVariable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XVariableDeclaration
   * @generated
   */
  public Adapter createXVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XDeclaredParameter <em>XDeclared Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XDeclaredParameter
   * @generated
   */
  public Adapter createXDeclaredParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XFeatureCall <em>XFeature Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XFeatureCall
   * @generated
   */
  public Adapter createXFeatureCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XConstructorCall <em>XConstructor Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XConstructorCall
   * @generated
   */
  public Adapter createXConstructorCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XBooleanLiteral <em>XBoolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XBooleanLiteral
   * @generated
   */
  public Adapter createXBooleanLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XNullLiteral <em>XNull Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XNullLiteral
   * @generated
   */
  public Adapter createXNullLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XIntLiteral <em>XInt Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XIntLiteral
   * @generated
   */
  public Adapter createXIntLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XStringLiteral <em>XString Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XStringLiteral
   * @generated
   */
  public Adapter createXStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XRichString <em>XRich String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XRichString
   * @generated
   */
  public Adapter createXRichStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XRichStringLiteral <em>XRich String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XRichStringLiteral
   * @generated
   */
  public Adapter createXRichStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XClosure <em>XClosure</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XClosure
   * @generated
   */
  public Adapter createXClosureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XCastedExpression <em>XCasted Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XCastedExpression
   * @generated
   */
  public Adapter createXCastedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XAssignment <em>XAssignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XAssignment
   * @generated
   */
  public Adapter createXAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XBinaryOperation <em>XBinary Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XBinaryOperation
   * @generated
   */
  public Adapter createXBinaryOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XUnaryOperation <em>XUnary Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XUnaryOperation
   * @generated
   */
  public Adapter createXUnaryOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XWhileExpression <em>XWhile Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XWhileExpression
   * @generated
   */
  public Adapter createXWhileExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XTypeLiteral <em>XType Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XTypeLiteral
   * @generated
   */
  public Adapter createXTypeLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xpression.XInstanceOfExpression <em>XInstance Of Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xpression.XInstanceOfExpression
   * @generated
   */
  public Adapter createXInstanceOfExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //XpressionAdapterFactory
