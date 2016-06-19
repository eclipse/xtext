/**
 */
package org.eclipse.xtext.testlanguages.referenceGrammar.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.testlanguages.referenceGrammar.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage
 * @generated
 */
public class ReferenceGrammarAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ReferenceGrammarPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceGrammarAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ReferenceGrammarPackage.eINSTANCE;
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
  protected ReferenceGrammarSwitch<Adapter> modelSwitch =
    new ReferenceGrammarSwitch<Adapter>()
    {
      @Override
      public Adapter caseSpielplatz(Spielplatz object)
      {
        return createSpielplatzAdapter();
      }
      @Override
      public Adapter casePerson(Person object)
      {
        return createPersonAdapter();
      }
      @Override
      public Adapter caseKind(Kind object)
      {
        return createKindAdapter();
      }
      @Override
      public Adapter caseErwachsener(Erwachsener object)
      {
        return createErwachsenerAdapter();
      }
      @Override
      public Adapter caseSpielzeug(Spielzeug object)
      {
        return createSpielzeugAdapter();
      }
      @Override
      public Adapter caseFarbe(Farbe object)
      {
        return createFarbeAdapter();
      }
      @Override
      public Adapter caseFamilie(Familie object)
      {
        return createFamilieAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Spielplatz <em>Spielplatz</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.Spielplatz
   * @generated
   */
  public Adapter createSpielplatzAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Person <em>Person</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.Person
   * @generated
   */
  public Adapter createPersonAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Kind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.Kind
   * @generated
   */
  public Adapter createKindAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Erwachsener <em>Erwachsener</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.Erwachsener
   * @generated
   */
  public Adapter createErwachsenerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Spielzeug <em>Spielzeug</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.Spielzeug
   * @generated
   */
  public Adapter createSpielzeugAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Farbe <em>Farbe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.Farbe
   * @generated
   */
  public Adapter createFarbeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.referenceGrammar.Familie <em>Familie</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.referenceGrammar.Familie
   * @generated
   */
  public Adapter createFamilieAdapter()
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

} //ReferenceGrammarAdapterFactory
