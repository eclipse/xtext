/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.XtextGrammarTestPackage
 * @generated
 */
public class XtextGrammarTestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XtextGrammarTestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextGrammarTestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = XtextGrammarTestPackage.eINSTANCE;
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
  protected XtextGrammarTestSwitch<Adapter> modelSwitch =
    new XtextGrammarTestSwitch<Adapter>()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Grammar <em>Grammar</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Grammar
   * @generated
   */
  public Adapter createGrammarAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.AbstractRule <em>Abstract Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.AbstractRule
   * @generated
   */
  public Adapter createAbstractRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.AbstractMetamodelDeclaration <em>Abstract Metamodel Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.AbstractMetamodelDeclaration
   * @generated
   */
  public Adapter createAbstractMetamodelDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.GeneratedMetamodel <em>Generated Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.GeneratedMetamodel
   * @generated
   */
  public Adapter createGeneratedMetamodelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.ReferencedMetamodel <em>Referenced Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.ReferencedMetamodel
   * @generated
   */
  public Adapter createReferencedMetamodelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.ParserRule <em>Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.ParserRule
   * @generated
   */
  public Adapter createParserRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.TypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.TypeRef
   * @generated
   */
  public Adapter createTypeRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.AbstractElement <em>Abstract Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.AbstractElement
   * @generated
   */
  public Adapter createAbstractElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Keyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Keyword
   * @generated
   */
  public Adapter createKeywordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.RuleCall <em>Rule Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.RuleCall
   * @generated
   */
  public Adapter createRuleCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Assignment
   * @generated
   */
  public Adapter createAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.CrossReference <em>Cross Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.CrossReference
   * @generated
   */
  public Adapter createCrossReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.TerminalRule <em>Terminal Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.TerminalRule
   * @generated
   */
  public Adapter createTerminalRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.AbstractNegatedToken <em>Abstract Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.AbstractNegatedToken
   * @generated
   */
  public Adapter createAbstractNegatedTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.NegatedToken <em>Negated Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.NegatedToken
   * @generated
   */
  public Adapter createNegatedTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.UntilToken <em>Until Token</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.UntilToken
   * @generated
   */
  public Adapter createUntilTokenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Wildcard <em>Wildcard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Wildcard
   * @generated
   */
  public Adapter createWildcardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.EnumRule <em>Enum Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.EnumRule
   * @generated
   */
  public Adapter createEnumRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.EnumLiteralDeclaration <em>Enum Literal Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.EnumLiteralDeclaration
   * @generated
   */
  public Adapter createEnumLiteralDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Alternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Alternatives
   * @generated
   */
  public Adapter createAlternativesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Group <em>Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.Group
   * @generated
   */
  public Adapter createGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.CharacterRange <em>Character Range</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.xtextgrammar.xtextGrammarTest.CharacterRange
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

} //XtextGrammarTestAdapterFactory
