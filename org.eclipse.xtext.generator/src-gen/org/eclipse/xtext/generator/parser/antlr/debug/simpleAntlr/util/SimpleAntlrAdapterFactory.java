/**
 */
package org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.SimpleAntlrPackage
 * @generated
 */
public class SimpleAntlrAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SimpleAntlrPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAntlrAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SimpleAntlrPackage.eINSTANCE;
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
  protected SimpleAntlrSwitch<Adapter> modelSwitch =
    new SimpleAntlrSwitch<Adapter>()
    {
      @Override
      public Adapter caseAntlrGrammar(AntlrGrammar object)
      {
        return createAntlrGrammarAdapter();
      }
      @Override
      public Adapter caseOptions(Options object)
      {
        return createOptionsAdapter();
      }
      @Override
      public Adapter caseOptionValue(OptionValue object)
      {
        return createOptionValueAdapter();
      }
      @Override
      public Adapter caseRule(Rule object)
      {
        return createRuleAdapter();
      }
      @Override
      public Adapter caseParameter(Parameter object)
      {
        return createParameterAdapter();
      }
      @Override
      public Adapter caseRuleElement(RuleElement object)
      {
        return createRuleElementAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseReferenceOrLiteral(ReferenceOrLiteral object)
      {
        return createReferenceOrLiteralAdapter();
      }
      @Override
      public Adapter casePredicated(Predicated object)
      {
        return createPredicatedAdapter();
      }
      @Override
      public Adapter caseRuleOptions(RuleOptions object)
      {
        return createRuleOptionsAdapter();
      }
      @Override
      public Adapter caseRuleCall(RuleCall object)
      {
        return createRuleCallAdapter();
      }
      @Override
      public Adapter caseKeyword(Keyword object)
      {
        return createKeywordAdapter();
      }
      @Override
      public Adapter caseWildcard(Wildcard object)
      {
        return createWildcardAdapter();
      }
      @Override
      public Adapter caseAlternatives(Alternatives object)
      {
        return createAlternativesAdapter();
      }
      @Override
      public Adapter caseGroup(Group object)
      {
        return createGroupAdapter();
      }
      @Override
      public Adapter caseElementWithCardinality(ElementWithCardinality object)
      {
        return createElementWithCardinalityAdapter();
      }
      @Override
      public Adapter caseNegatedElement(NegatedElement object)
      {
        return createNegatedElementAdapter();
      }
      @Override
      public Adapter caseUntilElement(UntilElement object)
      {
        return createUntilElementAdapter();
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
      public Adapter caseNotExpression(NotExpression object)
      {
        return createNotExpressionAdapter();
      }
      @Override
      public Adapter caseSkip(Skip object)
      {
        return createSkipAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar <em>Antlr Grammar</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AntlrGrammar
   * @generated
   */
  public Adapter createAntlrGrammarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Options <em>Options</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Options
   * @generated
   */
  public Adapter createOptionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OptionValue <em>Option Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OptionValue
   * @generated
   */
  public Adapter createOptionValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule <em>Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Rule
   * @generated
   */
  public Adapter createRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Parameter
   * @generated
   */
  public Adapter createParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement <em>Rule Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleElement
   * @generated
   */
  public Adapter createRuleElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ReferenceOrLiteral <em>Reference Or Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ReferenceOrLiteral
   * @generated
   */
  public Adapter createReferenceOrLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Predicated <em>Predicated</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Predicated
   * @generated
   */
  public Adapter createPredicatedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions <em>Rule Options</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleOptions
   * @generated
   */
  public Adapter createRuleOptionsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleCall <em>Rule Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.RuleCall
   * @generated
   */
  public Adapter createRuleCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Keyword
   * @generated
   */
  public Adapter createKeywordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Wildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Wildcard
   * @generated
   */
  public Adapter createWildcardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Alternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Alternatives
   * @generated
   */
  public Adapter createAlternativesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Group
   * @generated
   */
  public Adapter createGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality <em>Element With Cardinality</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.ElementWithCardinality
   * @generated
   */
  public Adapter createElementWithCardinalityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NegatedElement <em>Negated Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NegatedElement
   * @generated
   */
  public Adapter createNegatedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.UntilElement <em>Until Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.UntilElement
   * @generated
   */
  public Adapter createUntilElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.OrExpression
   * @generated
   */
  public Adapter createOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.AndExpression
   * @generated
   */
  public Adapter createAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NotExpression <em>Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.NotExpression
   * @generated
   */
  public Adapter createNotExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Skip <em>Skip</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.generator.parser.antlr.debug.simpleAntlr.Skip
   * @generated
   */
  public Adapter createSkipAdapter()
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

} //SimpleAntlrAdapterFactory
