/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage
 * @generated
 */
public class BacktrackingTestLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static BacktrackingTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingTestLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = BacktrackingTestLanguagePackage.eINSTANCE;
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
  protected BacktrackingTestLanguageSwitch<Adapter> modelSwitch =
    new BacktrackingTestLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseUnit(Unit object)
      {
        return createUnitAdapter();
      }
      @Override
      public Adapter caseProvidedCapability(ProvidedCapability object)
      {
        return createProvidedCapabilityAdapter();
      }
      @Override
      public Adapter caseAliasedRequiredCapability(AliasedRequiredCapability object)
      {
        return createAliasedRequiredCapabilityAdapter();
      }
      @Override
      public Adapter caseRequiredCapability(RequiredCapability object)
      {
        return createRequiredCapabilityAdapter();
      }
      @Override
      public Adapter caseParameterList(ParameterList object)
      {
        return createParameterListAdapter();
      }
      @Override
      public Adapter caseParameter(Parameter object)
      {
        return createParameterAdapter();
      }
      @Override
      public Adapter caseClosureParameter(ClosureParameter object)
      {
        return createClosureParameterAdapter();
      }
      @Override
      public Adapter caseParameterDeclaration(ParameterDeclaration object)
      {
        return createParameterDeclarationAdapter();
      }
      @Override
      public Adapter caseFunction(Function object)
      {
        return createFunctionAdapter();
      }
      @Override
      public Adapter caseGuardExpression(GuardExpression object)
      {
        return createGuardExpressionAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseTypeRef(TypeRef object)
      {
        return createTypeRefAdapter();
      }
      @Override
      public Adapter caseSimpleTypeRef(SimpleTypeRef object)
      {
        return createSimpleTypeRefAdapter();
      }
      @Override
      public Adapter caseClosureTypeRef(ClosureTypeRef object)
      {
        return createClosureTypeRefAdapter();
      }
      @Override
      public Adapter caseWithExpression(WithExpression object)
      {
        return createWithExpressionAdapter();
      }
      @Override
      public Adapter caseWithContextExpression(WithContextExpression object)
      {
        return createWithContextExpressionAdapter();
      }
      @Override
      public Adapter caseCallExpression(CallExpression object)
      {
        return createCallExpressionAdapter();
      }
      @Override
      public Adapter caseValueLiteral(ValueLiteral object)
      {
        return createValueLiteralAdapter();
      }
      @Override
      public Adapter caseAssignmentExpression(AssignmentExpression object)
      {
        return createAssignmentExpressionAdapter();
      }
      @Override
      public Adapter caseDefValue(DefValue object)
      {
        return createDefValueAdapter();
      }
      @Override
      public Adapter caseCachedExpression(CachedExpression object)
      {
        return createCachedExpressionAdapter();
      }
      @Override
      public Adapter caseOrExpression(OrExpression object)
      {
        return createOrExpressionAdapter();
      }
      @Override
      public Adapter caseAndExpression(AndExpression object)
      {
        return createAndExpressionAdapter();
      }
      @Override
      public Adapter caseBinaryOpExpression(BinaryOpExpression object)
      {
        return createBinaryOpExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryOpExpression(UnaryOpExpression object)
      {
        return createUnaryOpExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryPreOpExpression(UnaryPreOpExpression object)
      {
        return createUnaryPreOpExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryPostOpExpression(UnaryPostOpExpression object)
      {
        return createUnaryPostOpExpressionAdapter();
      }
      @Override
      public Adapter caseCallFeature(CallFeature object)
      {
        return createCallFeatureAdapter();
      }
      @Override
      public Adapter caseAtExpression(AtExpression object)
      {
        return createAtExpressionAdapter();
      }
      @Override
      public Adapter caseFeatureExpression(FeatureExpression object)
      {
        return createFeatureExpressionAdapter();
      }
      @Override
      public Adapter caseCallFunction(CallFunction object)
      {
        return createCallFunctionAdapter();
      }
      @Override
      public Adapter caseChainedExpression(ChainedExpression object)
      {
        return createChainedExpressionAdapter();
      }
      @Override
      public Adapter caseVariableExpression(VariableExpression object)
      {
        return createVariableExpressionAdapter();
      }
      @Override
      public Adapter caseCallNamedFunction(CallNamedFunction object)
      {
        return createCallNamedFunctionAdapter();
      }
      @Override
      public Adapter caseCreateExpression(CreateExpression object)
      {
        return createCreateExpressionAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Unit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Unit
   * @generated
   */
  public Adapter createUnitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ProvidedCapability <em>Provided Capability</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ProvidedCapability
   * @generated
   */
  public Adapter createProvidedCapabilityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AliasedRequiredCapability <em>Aliased Required Capability</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AliasedRequiredCapability
   * @generated
   */
  public Adapter createAliasedRequiredCapabilityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.RequiredCapability <em>Required Capability</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.RequiredCapability
   * @generated
   */
  public Adapter createRequiredCapabilityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ParameterList <em>Parameter List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ParameterList
   * @generated
   */
  public Adapter createParameterListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Parameter
   * @generated
   */
  public Adapter createParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ClosureParameter <em>Closure Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ClosureParameter
   * @generated
   */
  public Adapter createClosureParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ParameterDeclaration <em>Parameter Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ParameterDeclaration
   * @generated
   */
  public Adapter createParameterDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Function
   * @generated
   */
  public Adapter createFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.GuardExpression <em>Guard Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.GuardExpression
   * @generated
   */
  public Adapter createGuardExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.TypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.TypeRef
   * @generated
   */
  public Adapter createTypeRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.SimpleTypeRef <em>Simple Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.SimpleTypeRef
   * @generated
   */
  public Adapter createSimpleTypeRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ClosureTypeRef <em>Closure Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ClosureTypeRef
   * @generated
   */
  public Adapter createClosureTypeRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.WithExpression <em>With Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.WithExpression
   * @generated
   */
  public Adapter createWithExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.WithContextExpression <em>With Context Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.WithContextExpression
   * @generated
   */
  public Adapter createWithContextExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CallExpression <em>Call Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CallExpression
   * @generated
   */
  public Adapter createCallExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ValueLiteral <em>Value Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ValueLiteral
   * @generated
   */
  public Adapter createValueLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AssignmentExpression <em>Assignment Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AssignmentExpression
   * @generated
   */
  public Adapter createAssignmentExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue <em>Def Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.DefValue
   * @generated
   */
  public Adapter createDefValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CachedExpression <em>Cached Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CachedExpression
   * @generated
   */
  public Adapter createCachedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.OrExpression
   * @generated
   */
  public Adapter createOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BinaryOpExpression <em>Binary Op Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BinaryOpExpression
   * @generated
   */
  public Adapter createBinaryOpExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.UnaryOpExpression <em>Unary Op Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.UnaryOpExpression
   * @generated
   */
  public Adapter createUnaryOpExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.UnaryPreOpExpression <em>Unary Pre Op Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.UnaryPreOpExpression
   * @generated
   */
  public Adapter createUnaryPreOpExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.UnaryPostOpExpression <em>Unary Post Op Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.UnaryPostOpExpression
   * @generated
   */
  public Adapter createUnaryPostOpExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CallFeature <em>Call Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CallFeature
   * @generated
   */
  public Adapter createCallFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AtExpression <em>At Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.AtExpression
   * @generated
   */
  public Adapter createAtExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.FeatureExpression <em>Feature Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.FeatureExpression
   * @generated
   */
  public Adapter createFeatureExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CallFunction <em>Call Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CallFunction
   * @generated
   */
  public Adapter createCallFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ChainedExpression <em>Chained Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ChainedExpression
   * @generated
   */
  public Adapter createChainedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.VariableExpression <em>Variable Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.VariableExpression
   * @generated
   */
  public Adapter createVariableExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CallNamedFunction <em>Call Named Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CallNamedFunction
   * @generated
   */
  public Adapter createCallNamedFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CreateExpression <em>Create Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.CreateExpression
   * @generated
   */
  public Adapter createCreateExpressionAdapter()
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

} //BacktrackingTestLanguageAdapterFactory
