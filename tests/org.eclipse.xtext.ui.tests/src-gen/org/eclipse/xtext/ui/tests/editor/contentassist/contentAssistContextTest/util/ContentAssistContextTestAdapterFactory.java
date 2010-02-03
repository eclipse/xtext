/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ContentAssistContextTestPackage
 * @generated
 */
public class ContentAssistContextTestAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ContentAssistContextTestPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContentAssistContextTestAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ContentAssistContextTestPackage.eINSTANCE;
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
  protected ContentAssistContextTestSwitch<Adapter> modelSwitch =
    new ContentAssistContextTestSwitch<Adapter>()
    {
      @Override
      public Adapter caseFirstLevel(FirstLevel object)
      {
        return createFirstLevelAdapter();
      }
      @Override
      public Adapter caseSecondLevelA(SecondLevelA object)
      {
        return createSecondLevelAAdapter();
      }
      @Override
      public Adapter caseSecondLevelB(SecondLevelB object)
      {
        return createSecondLevelBAdapter();
      }
      @Override
      public Adapter caseThirdLevelA1(ThirdLevelA1 object)
      {
        return createThirdLevelA1Adapter();
      }
      @Override
      public Adapter caseThirdLevelA2(ThirdLevelA2 object)
      {
        return createThirdLevelA2Adapter();
      }
      @Override
      public Adapter caseThirdLevelB1(ThirdLevelB1 object)
      {
        return createThirdLevelB1Adapter();
      }
      @Override
      public Adapter caseThirdLevelB2(ThirdLevelB2 object)
      {
        return createThirdLevelB2Adapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.FirstLevel <em>First Level</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.FirstLevel
   * @generated
   */
  public Adapter createFirstLevelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelA <em>Second Level A</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelA
   * @generated
   */
  public Adapter createSecondLevelAAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelB <em>Second Level B</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.SecondLevelB
   * @generated
   */
  public Adapter createSecondLevelBAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelA1 <em>Third Level A1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelA1
   * @generated
   */
  public Adapter createThirdLevelA1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelA2 <em>Third Level A2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelA2
   * @generated
   */
  public Adapter createThirdLevelA2Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB1 <em>Third Level B1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB1
   * @generated
   */
  public Adapter createThirdLevelB1Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB2 <em>Third Level B2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.contentAssistContextTest.ThirdLevelB2
   * @generated
   */
  public Adapter createThirdLevelB2Adapter()
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

} //ContentAssistContextTestAdapterFactory
