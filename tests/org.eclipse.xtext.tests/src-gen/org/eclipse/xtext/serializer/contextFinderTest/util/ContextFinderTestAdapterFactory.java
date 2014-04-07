/**
 */
package org.eclipse.xtext.serializer.contextFinderTest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.serializer.contextFinderTest.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage
 * @generated
 */
public class ContextFinderTestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ContextFinderTestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextFinderTestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ContextFinderTestPackage.eINSTANCE;
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
  protected ContextFinderTestSwitch<Adapter> modelSwitch =
    new ContextFinderTestSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseAttributeExclusionTest(AttributeExclusionTest object)
      {
        return createAttributeExclusionTestAdapter();
      }
      @Override
      public Adapter caseNestedTypeTest(NestedTypeTest object)
      {
        return createNestedTypeTestAdapter();
      }
      @Override
      public Adapter caseNestedTypeChild(NestedTypeChild object)
      {
        return createNestedTypeChildAdapter();
      }
      @Override
      public Adapter caseNestedTypeChild1(NestedTypeChild1 object)
      {
        return createNestedTypeChild1Adapter();
      }
      @Override
      public Adapter caseNestedTypeChild2(NestedTypeChild2 object)
      {
        return createNestedTypeChild2Adapter();
      }
      @Override
      public Adapter caseNestedTypeRecursiveTest(NestedTypeRecursiveTest object)
      {
        return createNestedTypeRecursiveTestAdapter();
      }
      @Override
      public Adapter caseParentRefTest1(ParentRefTest1 object)
      {
        return createParentRefTest1Adapter();
      }
      @Override
      public Adapter caseParentRefTest2(ParentRefTest2 object)
      {
        return createParentRefTest2Adapter();
      }
      @Override
      public Adapter caseParentRefTestChild(ParentRefTestChild object)
      {
        return createParentRefTestChildAdapter();
      }
      @Override
      public Adapter caseQuantityExclusionTest(QuantityExclusionTest object)
      {
        return createQuantityExclusionTestAdapter();
      }
      @Override
      public Adapter caseValueExclusionTest(ValueExclusionTest object)
      {
        return createValueExclusionTestAdapter();
      }
      @Override
      public Adapter caseNodeExclusion(NodeExclusion object)
      {
        return createNodeExclusionAdapter();
      }
      @Override
      public Adapter caseNodeExclusionList(NodeExclusionList object)
      {
        return createNodeExclusionListAdapter();
      }
      @Override
      public Adapter caseNestedTypeRecursiveTest1(NestedTypeRecursiveTest1 object)
      {
        return createNestedTypeRecursiveTest1Adapter();
      }
      @Override
      public Adapter caseNestedTypeRecursiveTest2(NestedTypeRecursiveTest2 object)
      {
        return createNestedTypeRecursiveTest2Adapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest <em>Attribute Exclusion Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.AttributeExclusionTest
   * @generated
   */
  public Adapter createAttributeExclusionTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest <em>Nested Type Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeTest
   * @generated
   */
  public Adapter createNestedTypeTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild <em>Nested Type Child</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild
   * @generated
   */
  public Adapter createNestedTypeChildAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild1 <em>Nested Type Child1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild1
   * @generated
   */
  public Adapter createNestedTypeChild1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild2 <em>Nested Type Child2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeChild2
   * @generated
   */
  public Adapter createNestedTypeChild2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest <em>Nested Type Recursive Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest
   * @generated
   */
  public Adapter createNestedTypeRecursiveTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1 <em>Parent Ref Test1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest1
   * @generated
   */
  public Adapter createParentRefTest1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2 <em>Parent Ref Test2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ParentRefTest2
   * @generated
   */
  public Adapter createParentRefTest2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild <em>Parent Ref Test Child</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild
   * @generated
   */
  public Adapter createParentRefTestChildAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.QuantityExclusionTest <em>Quantity Exclusion Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.QuantityExclusionTest
   * @generated
   */
  public Adapter createQuantityExclusionTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTest <em>Value Exclusion Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.ValueExclusionTest
   * @generated
   */
  public Adapter createValueExclusionTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.NodeExclusion <em>Node Exclusion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NodeExclusion
   * @generated
   */
  public Adapter createNodeExclusionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.NodeExclusionList <em>Node Exclusion List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NodeExclusionList
   * @generated
   */
  public Adapter createNodeExclusionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest1 <em>Nested Type Recursive Test1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest1
   * @generated
   */
  public Adapter createNestedTypeRecursiveTest1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest2 <em>Nested Type Recursive Test2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.serializer.contextFinderTest.NestedTypeRecursiveTest2
   * @generated
   */
  public Adapter createNestedTypeRecursiveTest2Adapter()
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

} //ContextFinderTestAdapterFactory
