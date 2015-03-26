/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Action;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Expression;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Named;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedDelegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Simple;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Unassigned;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage
 * @generated
 */
public class RegionaccesstestlanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RegionaccesstestlanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegionaccesstestlanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = RegionaccesstestlanguagePackage.eINSTANCE;
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
  protected RegionaccesstestlanguageSwitch<Adapter> modelSwitch =
    new RegionaccesstestlanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseRoot(Root object)
      {
        return createRootAdapter();
      }
      @Override
      public Adapter caseSimple(Simple object)
      {
        return createSimpleAdapter();
      }
      @Override
      public Adapter caseDelegation(Delegation object)
      {
        return createDelegationAdapter();
      }
      @Override
      public Adapter caseUnassigned(Unassigned object)
      {
        return createUnassignedAdapter();
      }
      @Override
      public Adapter casePrefixedUnassigned(PrefixedUnassigned object)
      {
        return createPrefixedUnassignedAdapter();
      }
      @Override
      public Adapter casePrefixedDelegate(PrefixedDelegate object)
      {
        return createPrefixedDelegateAdapter();
      }
      @Override
      public Adapter caseDelegate(Delegate object)
      {
        return createDelegateAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseMixed(Mixed object)
      {
        return createMixedAdapter();
      }
      @Override
      public Adapter caseAdd(Add object)
      {
        return createAddAdapter();
      }
      @Override
      public Adapter caseNamed(Named object)
      {
        return createNamedAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter caseAssignedAction(AssignedAction object)
      {
        return createAssignedActionAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
   * @generated
   */
  public Adapter createRootAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Simple <em>Simple</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Simple
   * @generated
   */
  public Adapter createSimpleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation <em>Delegation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation
   * @generated
   */
  public Adapter createDelegationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Unassigned <em>Unassigned</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Unassigned
   * @generated
   */
  public Adapter createUnassignedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned <em>Prefixed Unassigned</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned
   * @generated
   */
  public Adapter createPrefixedUnassignedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedDelegate <em>Prefixed Delegate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedDelegate
   * @generated
   */
  public Adapter createPrefixedDelegateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate <em>Delegate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate
   * @generated
   */
  public Adapter createDelegateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed
   * @generated
   */
  public Adapter createMixedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add <em>Add</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add
   * @generated
   */
  public Adapter createAddAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Named <em>Named</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Named
   * @generated
   */
  public Adapter createNamedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction <em>Assigned Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction
   * @generated
   */
  public Adapter createAssignedActionAdapter()
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

} //RegionaccesstestlanguageAdapterFactory
