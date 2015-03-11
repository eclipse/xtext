/**
 */
package org.eclipse.xtext.validation.csvalidationtest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.validation.csvalidationtest.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage
 * @generated
 */
public class CsvalidationtestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static CsvalidationtestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CsvalidationtestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = CsvalidationtestPackage.eINSTANCE;
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
  protected CsvalidationtestSwitch<Adapter> modelSwitch =
    new CsvalidationtestSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseSimpleGroup(SimpleGroup object)
      {
        return createSimpleGroupAdapter();
      }
      @Override
      public Adapter caseSimpleAlternative(SimpleAlternative object)
      {
        return createSimpleAlternativeAdapter();
      }
      @Override
      public Adapter caseSimpleMultiplicities(SimpleMultiplicities object)
      {
        return createSimpleMultiplicitiesAdapter();
      }
      @Override
      public Adapter caseGroupMultiplicities(GroupMultiplicities object)
      {
        return createGroupMultiplicitiesAdapter();
      }
      @Override
      public Adapter caseAlternativeMultiplicities(AlternativeMultiplicities object)
      {
        return createAlternativeMultiplicitiesAdapter();
      }
      @Override
      public Adapter caseAssignedAction(AssignedAction object)
      {
        return createAssignedActionAdapter();
      }
      @Override
      public Adapter caseUnassignedAction1(UnassignedAction1 object)
      {
        return createUnassignedAction1Adapter();
      }
      @Override
      public Adapter caseUnassignedAction2(UnassignedAction2 object)
      {
        return createUnassignedAction2Adapter();
      }
      @Override
      public Adapter caseUnassignedAction3(UnassignedAction3 object)
      {
        return createUnassignedAction3Adapter();
      }
      @Override
      public Adapter caseUnassignedRuleCall1(UnassignedRuleCall1 object)
      {
        return createUnassignedRuleCall1Adapter();
      }
      @Override
      public Adapter caseUnassignedRuleCall1Sub(UnassignedRuleCall1Sub object)
      {
        return createUnassignedRuleCall1SubAdapter();
      }
      @Override
      public Adapter caseUnassignedRuleCall2(UnassignedRuleCall2 object)
      {
        return createUnassignedRuleCall2Adapter();
      }
      @Override
      public Adapter caseUnassignedRuleCall2Sub(UnassignedRuleCall2Sub object)
      {
        return createUnassignedRuleCall2SubAdapter();
      }
      @Override
      public Adapter caseCombination1(Combination1 object)
      {
        return createCombination1Adapter();
      }
      @Override
      public Adapter caseCombination2(Combination2 object)
      {
        return createCombination2Adapter();
      }
      @Override
      public Adapter caseCombination3(Combination3 object)
      {
        return createCombination3Adapter();
      }
      @Override
      public Adapter caseCombination4(Combination4 object)
      {
        return createCombination4Adapter();
      }
      @Override
      public Adapter caseList1(List1 object)
      {
        return createList1Adapter();
      }
      @Override
      public Adapter caseList2(List2 object)
      {
        return createList2Adapter();
      }
      @Override
      public Adapter caseList3(List3 object)
      {
        return createList3Adapter();
      }
      @Override
      public Adapter caseList4(List4 object)
      {
        return createList4Adapter();
      }
      @Override
      public Adapter caseList5(List5 object)
      {
        return createList5Adapter();
      }
      @Override
      public Adapter caseAltList1(AltList1 object)
      {
        return createAltList1Adapter();
      }
      @Override
      public Adapter caseAltList2(AltList2 object)
      {
        return createAltList2Adapter();
      }
      @Override
      public Adapter caseTransientObject(TransientObject object)
      {
        return createTransientObjectAdapter();
      }
      @Override
      public Adapter caseTransientObjectSub(TransientObjectSub object)
      {
        return createTransientObjectSubAdapter();
      }
      @Override
      public Adapter caseTransientSerializeables1(TransientSerializeables1 object)
      {
        return createTransientSerializeables1Adapter();
      }
      @Override
      public Adapter caseStaticSimplification(StaticSimplification object)
      {
        return createStaticSimplificationAdapter();
      }
      @Override
      public Adapter caseTwoVersion(TwoVersion object)
      {
        return createTwoVersionAdapter();
      }
      @Override
      public Adapter caseHeuristic1(Heuristic1 object)
      {
        return createHeuristic1Adapter();
      }
      @Override
      public Adapter caseUnassignedAction2Sub(UnassignedAction2Sub object)
      {
        return createUnassignedAction2SubAdapter();
      }
      @Override
      public Adapter caseUnassignedAction2Sub1(UnassignedAction2Sub1 object)
      {
        return createUnassignedAction2Sub1Adapter();
      }
      @Override
      public Adapter caseUnassignedAction2Sub2(UnassignedAction2Sub2 object)
      {
        return createUnassignedAction2Sub2Adapter();
      }
      @Override
      public Adapter caseUnassignedRuleCall2SubAction(UnassignedRuleCall2SubAction object)
      {
        return createUnassignedRuleCall2SubActionAdapter();
      }
      @Override
      public Adapter caseEmptyAlternativeSub(EmptyAlternativeSub object)
      {
        return createEmptyAlternativeSubAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.SimpleGroup <em>Simple Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.SimpleGroup
   * @generated
   */
  public Adapter createSimpleGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.SimpleAlternative <em>Simple Alternative</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.SimpleAlternative
   * @generated
   */
  public Adapter createSimpleAlternativeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities <em>Simple Multiplicities</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities
   * @generated
   */
  public Adapter createSimpleMultiplicitiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.GroupMultiplicities <em>Group Multiplicities</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.GroupMultiplicities
   * @generated
   */
  public Adapter createGroupMultiplicitiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.AlternativeMultiplicities <em>Alternative Multiplicities</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.AlternativeMultiplicities
   * @generated
   */
  public Adapter createAlternativeMultiplicitiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.AssignedAction <em>Assigned Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.AssignedAction
   * @generated
   */
  public Adapter createAssignedActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedAction1 <em>Unassigned Action1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedAction1
   * @generated
   */
  public Adapter createUnassignedAction1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2 <em>Unassigned Action2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2
   * @generated
   */
  public Adapter createUnassignedAction2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedAction3 <em>Unassigned Action3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedAction3
   * @generated
   */
  public Adapter createUnassignedAction3Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1 <em>Unassigned Rule Call1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1
   * @generated
   */
  public Adapter createUnassignedRuleCall1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1Sub <em>Unassigned Rule Call1 Sub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall1Sub
   * @generated
   */
  public Adapter createUnassignedRuleCall1SubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2 <em>Unassigned Rule Call2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2
   * @generated
   */
  public Adapter createUnassignedRuleCall2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2Sub <em>Unassigned Rule Call2 Sub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2Sub
   * @generated
   */
  public Adapter createUnassignedRuleCall2SubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.Combination1 <em>Combination1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.Combination1
   * @generated
   */
  public Adapter createCombination1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.Combination2 <em>Combination2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.Combination2
   * @generated
   */
  public Adapter createCombination2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.Combination3 <em>Combination3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.Combination3
   * @generated
   */
  public Adapter createCombination3Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.Combination4 <em>Combination4</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.Combination4
   * @generated
   */
  public Adapter createCombination4Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.List1 <em>List1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.List1
   * @generated
   */
  public Adapter createList1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.List2 <em>List2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.List2
   * @generated
   */
  public Adapter createList2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.List3 <em>List3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.List3
   * @generated
   */
  public Adapter createList3Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.List4 <em>List4</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.List4
   * @generated
   */
  public Adapter createList4Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.List5 <em>List5</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.List5
   * @generated
   */
  public Adapter createList5Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.AltList1 <em>Alt List1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.AltList1
   * @generated
   */
  public Adapter createAltList1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.AltList2 <em>Alt List2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.AltList2
   * @generated
   */
  public Adapter createAltList2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.TransientObject <em>Transient Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.TransientObject
   * @generated
   */
  public Adapter createTransientObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.TransientObjectSub <em>Transient Object Sub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.TransientObjectSub
   * @generated
   */
  public Adapter createTransientObjectSubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1 <em>Transient Serializeables1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.TransientSerializeables1
   * @generated
   */
  public Adapter createTransientSerializeables1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.StaticSimplification <em>Static Simplification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.StaticSimplification
   * @generated
   */
  public Adapter createStaticSimplificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.TwoVersion <em>Two Version</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.TwoVersion
   * @generated
   */
  public Adapter createTwoVersionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.Heuristic1 <em>Heuristic1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.Heuristic1
   * @generated
   */
  public Adapter createHeuristic1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub <em>Unassigned Action2 Sub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub
   * @generated
   */
  public Adapter createUnassignedAction2SubAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub1 <em>Unassigned Action2 Sub1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub1
   * @generated
   */
  public Adapter createUnassignedAction2Sub1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub2 <em>Unassigned Action2 Sub2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedAction2Sub2
   * @generated
   */
  public Adapter createUnassignedAction2Sub2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2SubAction <em>Unassigned Rule Call2 Sub Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.UnassignedRuleCall2SubAction
   * @generated
   */
  public Adapter createUnassignedRuleCall2SubActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.validation.csvalidationtest.EmptyAlternativeSub <em>Empty Alternative Sub</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.validation.csvalidationtest.EmptyAlternativeSub
   * @generated
   */
  public Adapter createEmptyAlternativeSubAdapter()
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

} //CsvalidationtestAdapterFactory
