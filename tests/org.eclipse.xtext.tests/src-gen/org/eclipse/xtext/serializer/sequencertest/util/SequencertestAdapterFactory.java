/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.serializer.sequencertest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.serializer.sequencertest.AltList1;
import org.eclipse.xtext.serializer.sequencertest.AltList2;
import org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative1;
import org.eclipse.xtext.serializer.sequencertest.DependentAlternative2;
import org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.List1;
import org.eclipse.xtext.serializer.sequencertest.List2;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywords;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.MultiTerminals;
import org.eclipse.xtext.serializer.sequencertest.Optional;
import org.eclipse.xtext.serializer.sequencertest.SequencertestPackage;
import org.eclipse.xtext.serializer.sequencertest.SimpleAlternative;
import org.eclipse.xtext.serializer.sequencertest.SimpleGroup;
import org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild1;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild2;
import org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild3;
import org.eclipse.xtext.serializer.sequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.sequencertest.SingleEnum;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywords;
import org.eclipse.xtext.serializer.sequencertest.SingleKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.SingleTerminals;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.serializer.sequencertest.SequencertestPackage
 * @generated
 */
public class SequencertestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static SequencertestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SequencertestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = SequencertestPackage.eINSTANCE;
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
  protected SequencertestSwitch<Adapter> modelSwitch =
    new SequencertestSwitch<Adapter>()
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
      public Adapter caseSingleKeywords(SingleKeywords object)
      {
        return createSingleKeywordsAdapter();
      }
      @Override
      public Adapter caseSingleKeywordsOrID(SingleKeywordsOrID object)
      {
        return createSingleKeywordsOrIDAdapter();
      }
      @Override
      public Adapter caseSingleTerminals(SingleTerminals object)
      {
        return createSingleTerminalsAdapter();
      }
      @Override
      public Adapter caseSingleEnum(SingleEnum object)
      {
        return createSingleEnumAdapter();
      }
      @Override
      public Adapter caseSingleCrossReference(SingleCrossReference object)
      {
        return createSingleCrossReferenceAdapter();
      }
      @Override
      public Adapter caseSingleContainmentReference(SingleContainmentReference object)
      {
        return createSingleContainmentReferenceAdapter();
      }
      @Override
      public Adapter caseSingleContainmentReferenceChild1(SingleContainmentReferenceChild1 object)
      {
        return createSingleContainmentReferenceChild1Adapter();
      }
      @Override
      public Adapter caseSingleContainmentReferenceChild2(SingleContainmentReferenceChild2 object)
      {
        return createSingleContainmentReferenceChild2Adapter();
      }
      @Override
      public Adapter caseSingleContainmentReferenceChild3(SingleContainmentReferenceChild3 object)
      {
        return createSingleContainmentReferenceChild3Adapter();
      }
      @Override
      public Adapter caseMultiKeywords(MultiKeywords object)
      {
        return createMultiKeywordsAdapter();
      }
      @Override
      public Adapter caseMultiKeywordsOrID(MultiKeywordsOrID object)
      {
        return createMultiKeywordsOrIDAdapter();
      }
      @Override
      public Adapter caseMultiTerminals(MultiTerminals object)
      {
        return createMultiTerminalsAdapter();
      }
      @Override
      public Adapter caseDependentAlternative1(DependentAlternative1 object)
      {
        return createDependentAlternative1Adapter();
      }
      @Override
      public Adapter caseDependentAlternative2(DependentAlternative2 object)
      {
        return createDependentAlternative2Adapter();
      }
      @Override
      public Adapter caseOptional(Optional object)
      {
        return createOptionalAdapter();
      }
      @Override
      public Adapter caseFloat(org.eclipse.xtext.serializer.sequencertest.Float object)
      {
        return createFloatAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SimpleGroup <em>Simple Group</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SimpleGroup
   * @generated
   */
  public Adapter createSimpleGroupAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SimpleAlternative <em>Simple Alternative</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SimpleAlternative
   * @generated
   */
  public Adapter createSimpleAlternativeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities <em>Simple Multiplicities</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities
   * @generated
   */
  public Adapter createSimpleMultiplicitiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities <em>Group Multiplicities</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.GroupMultiplicities
   * @generated
   */
  public Adapter createGroupMultiplicitiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities <em>Alternative Multiplicities</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.AlternativeMultiplicities
   * @generated
   */
  public Adapter createAlternativeMultiplicitiesAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.List1 <em>List1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.List1
   * @generated
   */
  public Adapter createList1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.List2 <em>List2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.List2
   * @generated
   */
  public Adapter createList2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.AltList1 <em>Alt List1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.AltList1
   * @generated
   */
  public Adapter createAltList1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.AltList2 <em>Alt List2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.AltList2
   * @generated
   */
  public Adapter createAltList2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SingleKeywords <em>Single Keywords</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SingleKeywords
   * @generated
   */
  public Adapter createSingleKeywordsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SingleKeywordsOrID <em>Single Keywords Or ID</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SingleKeywordsOrID
   * @generated
   */
  public Adapter createSingleKeywordsOrIDAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SingleTerminals <em>Single Terminals</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SingleTerminals
   * @generated
   */
  public Adapter createSingleTerminalsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SingleEnum <em>Single Enum</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SingleEnum
   * @generated
   */
  public Adapter createSingleEnumAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SingleCrossReference <em>Single Cross Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SingleCrossReference
   * @generated
   */
  public Adapter createSingleCrossReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference <em>Single Containment Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SingleContainmentReference
   * @generated
   */
  public Adapter createSingleContainmentReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild1 <em>Single Containment Reference Child1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild1
   * @generated
   */
  public Adapter createSingleContainmentReferenceChild1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild2 <em>Single Containment Reference Child2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild2
   * @generated
   */
  public Adapter createSingleContainmentReferenceChild2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild3 <em>Single Containment Reference Child3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.SingleContainmentReferenceChild3
   * @generated
   */
  public Adapter createSingleContainmentReferenceChild3Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.MultiKeywords <em>Multi Keywords</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.MultiKeywords
   * @generated
   */
  public Adapter createMultiKeywordsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID <em>Multi Keywords Or ID</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID
   * @generated
   */
  public Adapter createMultiKeywordsOrIDAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.MultiTerminals <em>Multi Terminals</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.MultiTerminals
   * @generated
   */
  public Adapter createMultiTerminalsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.DependentAlternative1 <em>Dependent Alternative1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.DependentAlternative1
   * @generated
   */
  public Adapter createDependentAlternative1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.DependentAlternative2 <em>Dependent Alternative2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.DependentAlternative2
   * @generated
   */
  public Adapter createDependentAlternative2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.Optional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.Optional
   * @generated
   */
  public Adapter createOptionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.sequencertest.Float <em>Float</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.sequencertest.Float
   * @generated
   */
  public Adapter createFloatAdapter()
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

} //SequencertestAdapterFactory
