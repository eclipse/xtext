/**
 */
package org.eclipse.xtext.resource.bug385636.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.resource.bug385636.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.resource.bug385636.Bug385636Package
 * @generated
 */
public class Bug385636AdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Bug385636Package modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug385636AdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = Bug385636Package.eINSTANCE;
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
  protected Bug385636Switch<Adapter> modelSwitch =
    new Bug385636Switch<Adapter>()
    {
      @Override
      public Adapter caseProgram(Program object)
      {
        return createProgramAdapter();
      }
      @Override
      public Adapter caseDefineVariables(DefineVariables object)
      {
        return createDefineVariablesAdapter();
      }
      @Override
      public Adapter caseDefineVariable(DefineVariable object)
      {
        return createDefineVariableAdapter();
      }
      @Override
      public Adapter caseNVariableAccess(NVariableAccess object)
      {
        return createNVariableAccessAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseExpression_VariableName(Expression_VariableName object)
      {
        return createExpression_VariableNameAdapter();
      }
      @Override
      public Adapter caseExpression_Larger_Equal(Expression_Larger_Equal object)
      {
        return createExpression_Larger_EqualAdapter();
      }
      @Override
      public Adapter caseExpression_Smaller(Expression_Smaller object)
      {
        return createExpression_SmallerAdapter();
      }
      @Override
      public Adapter caseExpression_Smaller_Equal(Expression_Smaller_Equal object)
      {
        return createExpression_Smaller_EqualAdapter();
      }
      @Override
      public Adapter caseExpression_Equal(Expression_Equal object)
      {
        return createExpression_EqualAdapter();
      }
      @Override
      public Adapter caseExpression_Not_Equal(Expression_Not_Equal object)
      {
        return createExpression_Not_EqualAdapter();
      }
      @Override
      public Adapter caseExpression_Not_Less(Expression_Not_Less object)
      {
        return createExpression_Not_LessAdapter();
      }
      @Override
      public Adapter caseExpression_Not_Greater(Expression_Not_Greater object)
      {
        return createExpression_Not_GreaterAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Program
   * @generated
   */
  public Adapter createProgramAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.DefineVariables <em>Define Variables</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.DefineVariables
   * @generated
   */
  public Adapter createDefineVariablesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.DefineVariable <em>Define Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.DefineVariable
   * @generated
   */
  public Adapter createDefineVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.NVariableAccess <em>NVariable Access</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.NVariableAccess
   * @generated
   */
  public Adapter createNVariableAccessAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Expression_VariableName <em>Expression Variable Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Expression_VariableName
   * @generated
   */
  public Adapter createExpression_VariableNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal <em>Expression Larger Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal
   * @generated
   */
  public Adapter createExpression_Larger_EqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Expression_Smaller <em>Expression Smaller</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Smaller
   * @generated
   */
  public Adapter createExpression_SmallerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal <em>Expression Smaller Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal
   * @generated
   */
  public Adapter createExpression_Smaller_EqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Expression_Equal <em>Expression Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Equal
   * @generated
   */
  public Adapter createExpression_EqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Equal <em>Expression Not Equal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Equal
   * @generated
   */
  public Adapter createExpression_Not_EqualAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Less <em>Expression Not Less</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Less
   * @generated
   */
  public Adapter createExpression_Not_LessAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.resource.bug385636.Expression_Not_Greater <em>Expression Not Greater</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.resource.bug385636.Expression_Not_Greater
   * @generated
   */
  public Adapter createExpression_Not_GreaterAdapter()
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

} //Bug385636AdapterFactory
