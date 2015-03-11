/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage
 * @generated
 */
public class HiddenTerminalsTestLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static HiddenTerminalsTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HiddenTerminalsTestLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = HiddenTerminalsTestLanguagePackage.eINSTANCE;
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
  protected HiddenTerminalsTestLanguageSwitch<Adapter> modelSwitch =
    new HiddenTerminalsTestLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseWithoutHiddens(WithoutHiddens object)
      {
        return createWithoutHiddensAdapter();
      }
      @Override
      public Adapter caseWithHiddens(WithHiddens object)
      {
        return createWithHiddensAdapter();
      }
      @Override
      public Adapter caseOverridingHiddens(OverridingHiddens object)
      {
        return createOverridingHiddensAdapter();
      }
      @Override
      public Adapter caseOverridingHiddensCall(OverridingHiddensCall object)
      {
        return createOverridingHiddensCallAdapter();
      }
      @Override
      public Adapter caseInheritingHiddens(InheritingHiddens object)
      {
        return createInheritingHiddensAdapter();
      }
      @Override
      public Adapter caseDatatypeHiddens(DatatypeHiddens object)
      {
        return createDatatypeHiddensAdapter();
      }
      @Override
      public Adapter caseHidingHiddens(HidingHiddens object)
      {
        return createHidingHiddensAdapter();
      }
      @Override
      public Adapter caseInheritingHiddensCall(InheritingHiddensCall object)
      {
        return createInheritingHiddensCallAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithoutHiddens <em>Without Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithoutHiddens
   * @generated
   */
  public Adapter createWithoutHiddensAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithHiddens <em>With Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithHiddens
   * @generated
   */
  public Adapter createWithHiddensAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens <em>Overriding Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens
   * @generated
   */
  public Adapter createOverridingHiddensAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall <em>Overriding Hiddens Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall
   * @generated
   */
  public Adapter createOverridingHiddensCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens <em>Inheriting Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens
   * @generated
   */
  public Adapter createInheritingHiddensAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.DatatypeHiddens <em>Datatype Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.DatatypeHiddens
   * @generated
   */
  public Adapter createDatatypeHiddensAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens <em>Hiding Hiddens</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens
   * @generated
   */
  public Adapter createHidingHiddensAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall <em>Inheriting Hiddens Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall
   * @generated
   */
  public Adapter createInheritingHiddensCallAdapter()
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

} //HiddenTerminalsTestLanguageAdapterFactory
