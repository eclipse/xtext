/**
 */
package org.eclipse.xtext.serializer.syntacticsequencertest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.serializer.syntacticsequencertest.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage
 * @generated
 */
public class SyntacticsequencertestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SyntacticsequencertestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SyntacticsequencertestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SyntacticsequencertestPackage.eINSTANCE;
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
  protected SyntacticsequencertestSwitch<Adapter> modelSwitch =
    new SyntacticsequencertestSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseMandatoryKeywords(MandatoryKeywords object)
      {
        return createMandatoryKeywordsAdapter();
      }
      @Override
      public Adapter caseExp0(Exp0 object)
      {
        return createExp0Adapter();
      }
      @Override
      public Adapter caseExp1(Exp1 object)
      {
        return createExp1Adapter();
      }
      @Override
      public Adapter caseExp2(Exp2 object)
      {
        return createExp2Adapter();
      }
      @Override
      public Adapter caseSingleCrossReference(SingleCrossReference object)
      {
        return createSingleCrossReferenceAdapter();
      }
      @Override
      public Adapter caseBooleanAlternative(BooleanAlternative object)
      {
        return createBooleanAlternativeAdapter();
      }
      @Override
      public Adapter caseBooleanAlternativeLiteral(BooleanAlternativeLiteral object)
      {
        return createBooleanAlternativeLiteralAdapter();
      }
      @Override
      public Adapter caseUnassignedDatatype(UnassignedDatatype object)
      {
        return createUnassignedDatatypeAdapter();
      }
      @Override
      public Adapter caseOptionalSingleTransition(OptionalSingleTransition object)
      {
        return createOptionalSingleTransitionAdapter();
      }
      @Override
      public Adapter caseOptionalManyTransition(OptionalManyTransition object)
      {
        return createOptionalManyTransitionAdapter();
      }
      @Override
      public Adapter caseMandatoryManyTransition(MandatoryManyTransition object)
      {
        return createMandatoryManyTransitionAdapter();
      }
      @Override
      public Adapter caseAlternativeTransition(AlternativeTransition object)
      {
        return createAlternativeTransitionAdapter();
      }
      @Override
      public Adapter caseBooleanValues(BooleanValues object)
      {
        return createBooleanValuesAdapter();
      }
      @Override
      public Adapter caseLongAlternative(LongAlternative object)
      {
        return createLongAlternativeAdapter();
      }
      @Override
      public Adapter caseActionOnly(ActionOnly object)
      {
        return createActionOnlyAdapter();
      }
      @Override
      public Adapter caseFragmentCallerType(FragmentCallerType object)
      {
        return createFragmentCallerTypeAdapter();
      }
      @Override
      public Adapter caseAdd0(Add0 object)
      {
        return createAdd0Adapter();
      }
      @Override
      public Adapter caseVal0(Val0 object)
      {
        return createVal0Adapter();
      }
      @Override
      public Adapter caseAdd1(Add1 object)
      {
        return createAdd1Adapter();
      }
      @Override
      public Adapter caseVal1(Val1 object)
      {
        return createVal1Adapter();
      }
      @Override
      public Adapter caseAdd2(Add2 object)
      {
        return createAdd2Adapter();
      }
      @Override
      public Adapter caseMult2(Mult2 object)
      {
        return createMult2Adapter();
      }
      @Override
      public Adapter caseVal2(Val2 object)
      {
        return createVal2Adapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryKeywords <em>Mandatory Keywords</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryKeywords
   * @generated
   */
  public Adapter createMandatoryKeywordsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Exp0 <em>Exp0</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Exp0
   * @generated
   */
  public Adapter createExp0Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Exp1 <em>Exp1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Exp1
   * @generated
   */
  public Adapter createExp1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Exp2 <em>Exp2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Exp2
   * @generated
   */
  public Adapter createExp2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.SingleCrossReference <em>Single Cross Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.SingleCrossReference
   * @generated
   */
  public Adapter createSingleCrossReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.BooleanAlternative <em>Boolean Alternative</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.BooleanAlternative
   * @generated
   */
  public Adapter createBooleanAlternativeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.BooleanAlternativeLiteral <em>Boolean Alternative Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.BooleanAlternativeLiteral
   * @generated
   */
  public Adapter createBooleanAlternativeLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.UnassignedDatatype <em>Unassigned Datatype</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.UnassignedDatatype
   * @generated
   */
  public Adapter createUnassignedDatatypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.OptionalSingleTransition <em>Optional Single Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.OptionalSingleTransition
   * @generated
   */
  public Adapter createOptionalSingleTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.OptionalManyTransition <em>Optional Many Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.OptionalManyTransition
   * @generated
   */
  public Adapter createOptionalManyTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryManyTransition <em>Mandatory Many Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryManyTransition
   * @generated
   */
  public Adapter createMandatoryManyTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.AlternativeTransition <em>Alternative Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.AlternativeTransition
   * @generated
   */
  public Adapter createAlternativeTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.BooleanValues <em>Boolean Values</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.BooleanValues
   * @generated
   */
  public Adapter createBooleanValuesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.LongAlternative <em>Long Alternative</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.LongAlternative
   * @generated
   */
  public Adapter createLongAlternativeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.ActionOnly <em>Action Only</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.ActionOnly
   * @generated
   */
  public Adapter createActionOnlyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.FragmentCallerType <em>Fragment Caller Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.FragmentCallerType
   * @generated
   */
  public Adapter createFragmentCallerTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Add0 <em>Add0</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Add0
   * @generated
   */
  public Adapter createAdd0Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Val0 <em>Val0</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Val0
   * @generated
   */
  public Adapter createVal0Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Add1 <em>Add1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Add1
   * @generated
   */
  public Adapter createAdd1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Val1 <em>Val1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Val1
   * @generated
   */
  public Adapter createVal1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Add2 <em>Add2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Add2
   * @generated
   */
  public Adapter createAdd2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Mult2 <em>Mult2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Mult2
   * @generated
   */
  public Adapter createMult2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.syntacticsequencertest.Val2 <em>Val2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.syntacticsequencertest.Val2
   * @generated
   */
  public Adapter createVal2Adapter()
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

} //SyntacticsequencertestAdapterFactory
