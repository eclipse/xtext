/**
 */
package org.eclipse.xtext.resource.bug385636.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.resource.bug385636.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug385636FactoryImpl extends EFactoryImpl implements Bug385636Factory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug385636Factory init()
  {
    try
    {
      Bug385636Factory theBug385636Factory = (Bug385636Factory)EPackage.Registry.INSTANCE.getEFactory(Bug385636Package.eNS_URI);
      if (theBug385636Factory != null)
      {
        return theBug385636Factory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug385636FactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug385636FactoryImpl()
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
      case Bug385636Package.PROGRAM: return createProgram();
      case Bug385636Package.DEFINE_VARIABLES: return createDefineVariables();
      case Bug385636Package.DEFINE_VARIABLE: return createDefineVariable();
      case Bug385636Package.NVARIABLE_ACCESS: return createNVariableAccess();
      case Bug385636Package.EXPRESSION: return createExpression();
      case Bug385636Package.EXPRESSION_VARIABLE_NAME: return createExpression_VariableName();
      case Bug385636Package.EXPRESSION_LARGER_EQUAL: return createExpression_Larger_Equal();
      case Bug385636Package.EXPRESSION_SMALLER: return createExpression_Smaller();
      case Bug385636Package.EXPRESSION_SMALLER_EQUAL: return createExpression_Smaller_Equal();
      case Bug385636Package.EXPRESSION_EQUAL: return createExpression_Equal();
      case Bug385636Package.EXPRESSION_NOT_EQUAL: return createExpression_Not_Equal();
      case Bug385636Package.EXPRESSION_NOT_LESS: return createExpression_Not_Less();
      case Bug385636Package.EXPRESSION_NOT_GREATER: return createExpression_Not_Greater();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Program createProgram()
  {
    ProgramImpl program = new ProgramImpl();
    return program;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineVariables createDefineVariables()
  {
    DefineVariablesImpl defineVariables = new DefineVariablesImpl();
    return defineVariables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineVariable createDefineVariable()
  {
    DefineVariableImpl defineVariable = new DefineVariableImpl();
    return defineVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NVariableAccess createNVariableAccess()
  {
    NVariableAccessImpl nVariableAccess = new NVariableAccessImpl();
    return nVariableAccess;
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
  public Expression_VariableName createExpression_VariableName()
  {
    Expression_VariableNameImpl expression_VariableName = new Expression_VariableNameImpl();
    return expression_VariableName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression_Larger_Equal createExpression_Larger_Equal()
  {
    Expression_Larger_EqualImpl expression_Larger_Equal = new Expression_Larger_EqualImpl();
    return expression_Larger_Equal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression_Smaller createExpression_Smaller()
  {
    Expression_SmallerImpl expression_Smaller = new Expression_SmallerImpl();
    return expression_Smaller;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression_Smaller_Equal createExpression_Smaller_Equal()
  {
    Expression_Smaller_EqualImpl expression_Smaller_Equal = new Expression_Smaller_EqualImpl();
    return expression_Smaller_Equal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression_Equal createExpression_Equal()
  {
    Expression_EqualImpl expression_Equal = new Expression_EqualImpl();
    return expression_Equal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression_Not_Equal createExpression_Not_Equal()
  {
    Expression_Not_EqualImpl expression_Not_Equal = new Expression_Not_EqualImpl();
    return expression_Not_Equal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression_Not_Less createExpression_Not_Less()
  {
    Expression_Not_LessImpl expression_Not_Less = new Expression_Not_LessImpl();
    return expression_Not_Less;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression_Not_Greater createExpression_Not_Greater()
  {
    Expression_Not_GreaterImpl expression_Not_Greater = new Expression_Not_GreaterImpl();
    return expression_Not_Greater;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug385636Package getBug385636Package()
  {
    return (Bug385636Package)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug385636Package getPackage()
  {
    return Bug385636Package.eINSTANCE;
  }

} //Bug385636FactoryImpl
