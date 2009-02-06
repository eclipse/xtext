/**
 * <copyright>
 * </copyright>
 *
 * $Id: XtextTestAdapterFactory.java,v 1.1 2009/02/06 09:46:54 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.XtextTestPackage
 * @generated
 */
public class XtextTestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XtextTestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextTestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = XtextTestPackage.eINSTANCE;
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
  protected XtextTestSwitch<Adapter> modelSwitch =
    new XtextTestSwitch<Adapter>()
    {
      @Override
      public Adapter caseGrammar(Grammar object)
      {
        return createGrammarAdapter();
      }
      @Override
      public Adapter caseAbstractRule(AbstractRule object)
      {
        return createAbstractRuleAdapter();
      }
      @Override
      public Adapter caseAbstractMetamodelDeclaration(AbstractMetamodelDeclaration object)
      {
        return createAbstractMetamodelDeclarationAdapter();
      }
      @Override
      public Adapter caseGeneratedMetamodel(GeneratedMetamodel object)
      {
        return createGeneratedMetamodelAdapter();
      }
      @Override
      public Adapter caseReferencedMetamodel(ReferencedMetamodel object)
      {
        return createReferencedMetamodelAdapter();
      }
      @Override
      public Adapter caseLexerRule(LexerRule object)
      {
        return createLexerRuleAdapter();
      }
      @Override
      public Adapter caseParserRule(ParserRule object)
      {
        return createParserRuleAdapter();
      }
      @Override
      public Adapter caseTypeRef(TypeRef object)
      {
        return createTypeRefAdapter();
      }
      @Override
      public Adapter caseAbstractElement(AbstractElement object)
      {
        return createAbstractElementAdapter();
      }
      @Override
      public Adapter caseAssignment(Assignment object)
      {
        return createAssignmentAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter caseAbstractNegatedToken(AbstractNegatedToken object)
      {
        return createAbstractNegatedTokenAdapter();
      }
      @Override
      public Adapter caseNegatedToken(NegatedToken object)
      {
        return createNegatedTokenAdapter();
      }
      @Override
      public Adapter caseUpToToken(UpToToken object)
      {
        return createUpToTokenAdapter();
      }
      @Override
      public Adapter caseWildcard(Wildcard object)
      {
        return createWildcardAdapter();
      }
      @Override
      public Adapter caseCrossReference(CrossReference object)
      {
        return createCrossReferenceAdapter();
      }
      @Override
      public Adapter caseKeyword(Keyword object)
      {
        return createKeywordAdapter();
      }
      @Override
      public Adapter caseRuleCall(RuleCall object)
      {
        return createRuleCallAdapter();
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
      public Adapter caseCharacterRange(CharacterRange object)
      {
        return createCharacterRangeAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Grammar <em>Grammar</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Grammar
   * @generated
   */
  public Adapter createGrammarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractRule <em>Abstract Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractRule
   * @generated
   */
  public Adapter createAbstractRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractMetamodelDeclaration <em>Abstract Metamodel Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractMetamodelDeclaration
   * @generated
   */
  public Adapter createAbstractMetamodelDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.GeneratedMetamodel <em>Generated Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.GeneratedMetamodel
   * @generated
   */
  public Adapter createGeneratedMetamodelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.ReferencedMetamodel <em>Referenced Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.ReferencedMetamodel
   * @generated
   */
  public Adapter createReferencedMetamodelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.LexerRule <em>Lexer Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.LexerRule
   * @generated
   */
  public Adapter createLexerRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.ParserRule <em>Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.ParserRule
   * @generated
   */
  public Adapter createParserRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.TypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.TypeRef
   * @generated
   */
  public Adapter createTypeRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractElement <em>Abstract Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractElement
   * @generated
   */
  public Adapter createAbstractElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Assignment
   * @generated
   */
  public Adapter createAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractNegatedToken <em>Abstract Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.AbstractNegatedToken
   * @generated
   */
  public Adapter createAbstractNegatedTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.NegatedToken <em>Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.NegatedToken
   * @generated
   */
  public Adapter createNegatedTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.UpToToken <em>Up To Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.UpToToken
   * @generated
   */
  public Adapter createUpToTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Wildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Wildcard
   * @generated
   */
  public Adapter createWildcardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.CrossReference <em>Cross Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.CrossReference
   * @generated
   */
  public Adapter createCrossReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Keyword
   * @generated
   */
  public Adapter createKeywordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.RuleCall <em>Rule Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.RuleCall
   * @generated
   */
  public Adapter createRuleCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Alternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Alternatives
   * @generated
   */
  public Adapter createAlternativesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.Group
   * @generated
   */
  public Adapter createGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.CharacterRange <em>Character Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xtextGrammarTestLanguage.XtextTest.CharacterRange
   * @generated
   */
  public Adapter createCharacterRangeAdapter()
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

} //XtextTestAdapterFactory
