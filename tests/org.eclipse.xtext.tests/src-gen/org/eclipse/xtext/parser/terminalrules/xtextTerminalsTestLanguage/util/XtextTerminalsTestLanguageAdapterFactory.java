/**
 */
package org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.XtextTerminalsTestLanguagePackage
 * @generated
 */
public class XtextTerminalsTestLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XtextTerminalsTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextTerminalsTestLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = XtextTerminalsTestLanguagePackage.eINSTANCE;
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
  protected XtextTerminalsTestLanguageSwitch<Adapter> modelSwitch =
    new XtextTerminalsTestLanguageSwitch<Adapter>()
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
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
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
      public Adapter caseAssignment(Assignment object)
      {
        return createAssignmentAdapter();
      }
      @Override
      public Adapter caseCrossReference(CrossReference object)
      {
        return createCrossReferenceAdapter();
      }
      @Override
      public Adapter caseTerminalRule(TerminalRule object)
      {
        return createTerminalRuleAdapter();
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
      public Adapter caseUntilToken(UntilToken object)
      {
        return createUntilTokenAdapter();
      }
      @Override
      public Adapter caseWildcard(Wildcard object)
      {
        return createWildcardAdapter();
      }
      @Override
      public Adapter caseEnumRule(EnumRule object)
      {
        return createEnumRuleAdapter();
      }
      @Override
      public Adapter caseEnumLiteralDeclaration(EnumLiteralDeclaration object)
      {
        return createEnumLiteralDeclarationAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Grammar <em>Grammar</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Grammar
   * @generated
   */
  public Adapter createGrammarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractRule <em>Abstract Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractRule
   * @generated
   */
  public Adapter createAbstractRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractMetamodelDeclaration <em>Abstract Metamodel Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractMetamodelDeclaration
   * @generated
   */
  public Adapter createAbstractMetamodelDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.GeneratedMetamodel <em>Generated Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.GeneratedMetamodel
   * @generated
   */
  public Adapter createGeneratedMetamodelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ReferencedMetamodel <em>Referenced Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ReferencedMetamodel
   * @generated
   */
  public Adapter createReferencedMetamodelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ParserRule <em>Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.ParserRule
   * @generated
   */
  public Adapter createParserRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.TypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.TypeRef
   * @generated
   */
  public Adapter createTypeRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractElement <em>Abstract Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractElement
   * @generated
   */
  public Adapter createAbstractElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Keyword
   * @generated
   */
  public Adapter createKeywordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.RuleCall <em>Rule Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.RuleCall
   * @generated
   */
  public Adapter createRuleCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Assignment
   * @generated
   */
  public Adapter createAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.CrossReference <em>Cross Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.CrossReference
   * @generated
   */
  public Adapter createCrossReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.TerminalRule <em>Terminal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.TerminalRule
   * @generated
   */
  public Adapter createTerminalRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractNegatedToken <em>Abstract Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.AbstractNegatedToken
   * @generated
   */
  public Adapter createAbstractNegatedTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.NegatedToken <em>Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.NegatedToken
   * @generated
   */
  public Adapter createNegatedTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.UntilToken <em>Until Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.UntilToken
   * @generated
   */
  public Adapter createUntilTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Wildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Wildcard
   * @generated
   */
  public Adapter createWildcardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.EnumRule <em>Enum Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.EnumRule
   * @generated
   */
  public Adapter createEnumRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.EnumLiteralDeclaration <em>Enum Literal Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.EnumLiteralDeclaration
   * @generated
   */
  public Adapter createEnumLiteralDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Alternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Alternatives
   * @generated
   */
  public Adapter createAlternativesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.Group
   * @generated
   */
  public Adapter createGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.CharacterRange <em>Character Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.xtextTerminalsTestLanguage.CharacterRange
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

} //XtextTerminalsTestLanguageAdapterFactory
