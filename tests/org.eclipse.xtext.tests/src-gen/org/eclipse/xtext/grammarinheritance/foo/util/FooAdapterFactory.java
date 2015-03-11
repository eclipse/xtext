/**
 */
package org.eclipse.xtext.grammarinheritance.foo.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.grammarinheritance.ametamodel.AType;

import org.eclipse.xtext.grammarinheritance.foo.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage
 * @generated
 */
public class FooAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static FooPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FooAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = FooPackage.eINSTANCE;
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
  protected FooSwitch<Adapter> modelSwitch =
    new FooSwitch<Adapter>()
    {
      @Override
      public Adapter caseRootRule(RootRule object)
      {
        return createRootRuleAdapter();
      }
      @Override
      public Adapter caseConcreteParserRule(ConcreteParserRule object)
      {
        return createConcreteParserRuleAdapter();
      }
      @Override
      public Adapter caseCallOverridenParserRule(CallOverridenParserRule object)
      {
        return createCallOverridenParserRuleAdapter();
      }
      @Override
      public Adapter caseAType2(AType2 object)
      {
        return createAType2Adapter();
      }
      @Override
      public Adapter caseSubrule1(Subrule1 object)
      {
        return createSubrule1Adapter();
      }
      @Override
      public Adapter caseSubrule2(Subrule2 object)
      {
        return createSubrule2Adapter();
      }
      @Override
      public Adapter caseSubrule3(Subrule3 object)
      {
        return createSubrule3Adapter();
      }
      @Override
      public Adapter caseCallExtendedParserRule(CallExtendedParserRule object)
      {
        return createCallExtendedParserRuleAdapter();
      }
      @Override
      public Adapter caseAType(AType object)
      {
        return createATypeAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.grammarinheritance.foo.RootRule <em>Root Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.grammarinheritance.foo.RootRule
   * @generated
   */
  public Adapter createRootRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule <em>Concrete Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.grammarinheritance.foo.ConcreteParserRule
   * @generated
   */
  public Adapter createConcreteParserRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule <em>Call Overriden Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.grammarinheritance.foo.CallOverridenParserRule
   * @generated
   */
  public Adapter createCallOverridenParserRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.grammarinheritance.foo.AType2 <em>AType2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.grammarinheritance.foo.AType2
   * @generated
   */
  public Adapter createAType2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.grammarinheritance.foo.Subrule1 <em>Subrule1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.grammarinheritance.foo.Subrule1
   * @generated
   */
  public Adapter createSubrule1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.grammarinheritance.foo.Subrule2 <em>Subrule2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.grammarinheritance.foo.Subrule2
   * @generated
   */
  public Adapter createSubrule2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.grammarinheritance.foo.Subrule3 <em>Subrule3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.grammarinheritance.foo.Subrule3
   * @generated
   */
  public Adapter createSubrule3Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule <em>Call Extended Parser Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule
   * @generated
   */
  public Adapter createCallExtendedParserRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.grammarinheritance.ametamodel.AType <em>AType</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.grammarinheritance.ametamodel.AType
   * @generated
   */
  public Adapter createATypeAdapter()
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

} //FooAdapterFactory
