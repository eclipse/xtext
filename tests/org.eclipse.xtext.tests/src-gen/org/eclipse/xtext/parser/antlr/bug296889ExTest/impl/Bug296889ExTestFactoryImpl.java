/**
 */
package org.eclipse.xtext.parser.antlr.bug296889ExTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.antlr.bug296889ExTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug296889ExTestFactoryImpl extends EFactoryImpl implements Bug296889ExTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug296889ExTestFactory init()
  {
    try
    {
      Bug296889ExTestFactory theBug296889ExTestFactory = (Bug296889ExTestFactory)EPackage.Registry.INSTANCE.getEFactory(Bug296889ExTestPackage.eNS_URI);
      if (theBug296889ExTestFactory != null)
      {
        return theBug296889ExTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug296889ExTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug296889ExTestFactoryImpl()
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
      case Bug296889ExTestPackage.MODEL: return createModel();
      case Bug296889ExTestPackage.EXPRESSION: return createExpression();
      case Bug296889ExTestPackage.PREOP: return createPreop();
      case Bug296889ExTestPackage.POSTOP: return createPostop();
      case Bug296889ExTestPackage.VARIABLE: return createVariable();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Preop createPreop()
  {
    PreopImpl preop = new PreopImpl();
    return preop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Postop createPostop()
  {
    PostopImpl postop = new PostopImpl();
    return postop;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug296889ExTestPackage getBug296889ExTestPackage()
  {
    return (Bug296889ExTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug296889ExTestPackage getPackage()
  {
    return Bug296889ExTestPackage.eINSTANCE;
  }

} //Bug296889ExTestFactoryImpl
