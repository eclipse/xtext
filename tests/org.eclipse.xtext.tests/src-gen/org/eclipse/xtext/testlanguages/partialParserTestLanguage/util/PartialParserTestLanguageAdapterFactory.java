/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.testlanguages.partialParserTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage
 * @generated
 */
public class PartialParserTestLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PartialParserTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PartialParserTestLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PartialParserTestLanguagePackage.eINSTANCE;
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
  protected PartialParserTestLanguageSwitch<Adapter> modelSwitch =
    new PartialParserTestLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseSomeContainer(SomeContainer object)
      {
        return createSomeContainerAdapter();
      }
      @Override
      public Adapter caseNested(Nested object)
      {
        return createNestedAdapter();
      }
      @Override
      public Adapter caseContent(Content object)
      {
        return createContentAdapter();
      }
      @Override
      public Adapter caseChildren(Children object)
      {
        return createChildrenAdapter();
      }
      @Override
      public Adapter caseChild(Child object)
      {
        return createChildAdapter();
      }
      @Override
      public Adapter caseAbstractChildren(AbstractChildren object)
      {
        return createAbstractChildrenAdapter();
      }
      @Override
      public Adapter caseAbstractChild(AbstractChild object)
      {
        return createAbstractChildAdapter();
      }
      @Override
      public Adapter caseFirstConcrete(FirstConcrete object)
      {
        return createFirstConcreteAdapter();
      }
      @Override
      public Adapter caseSecondConcrete(SecondConcrete object)
      {
        return createSecondConcreteAdapter();
      }
      @Override
      public Adapter caseNamed(Named object)
      {
        return createNamedAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer <em>Some Container</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer
   * @generated
   */
  public Adapter createSomeContainerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested <em>Nested</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested
   * @generated
   */
  public Adapter createNestedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Content <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Content
   * @generated
   */
  public Adapter createContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children
   * @generated
   */
  public Adapter createChildrenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child
   * @generated
   */
  public Adapter createChildAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren <em>Abstract Children</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren
   * @generated
   */
  public Adapter createAbstractChildrenAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChild <em>Abstract Child</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChild
   * @generated
   */
  public Adapter createAbstractChildAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete <em>First Concrete</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete
   * @generated
   */
  public Adapter createFirstConcreteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete <em>Second Concrete</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete
   * @generated
   */
  public Adapter createSecondConcreteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Named <em>Named</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Named
   * @generated
   */
  public Adapter createNamedAdapter()
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

} //PartialParserTestLanguageAdapterFactory
