/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Bug360834TestLanguagePackage
 * @generated
 */
public class Bug360834TestLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static Bug360834TestLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug360834TestLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = Bug360834TestLanguagePackage.eINSTANCE;
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
  protected Bug360834TestLanguageSwitch<Adapter> modelSwitch =
    new Bug360834TestLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseAlternative(Alternative object)
      {
        return createAlternativeAdapter();
      }
      @Override
      public Adapter caseRecursiveClassDeclaration(RecursiveClassDeclaration object)
      {
        return createRecursiveClassDeclarationAdapter();
      }
      @Override
      public Adapter caseModifiers(Modifiers object)
      {
        return createModifiersAdapter();
      }
      @Override
      public Adapter caseUnordered(Unordered object)
      {
        return createUnorderedAdapter();
      }
      @Override
      public Adapter caseSimpleClassDeclaration(SimpleClassDeclaration object)
      {
        return createSimpleClassDeclarationAdapter();
      }
      @Override
      public Adapter caseClassMember(ClassMember object)
      {
        return createClassMemberAdapter();
      }
      @Override
      public Adapter caseUnorderedModifiers(UnorderedModifiers object)
      {
        return createUnorderedModifiersAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Alternative <em>Alternative</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Alternative
   * @generated
   */
  public Adapter createAlternativeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration <em>Recursive Class Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.RecursiveClassDeclaration
   * @generated
   */
  public Adapter createRecursiveClassDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers <em>Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Modifiers
   * @generated
   */
  public Adapter createModifiersAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered <em>Unordered</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Unordered
   * @generated
   */
  public Adapter createUnorderedAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration <em>Simple Class Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.SimpleClassDeclaration
   * @generated
   */
  public Adapter createSimpleClassDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.ClassMember <em>Class Member</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.ClassMember
   * @generated
   */
  public Adapter createClassMemberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.UnorderedModifiers <em>Unordered Modifiers</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.UnorderedModifiers
   * @generated
   */
  public Adapter createUnorderedModifiersAdapter()
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

} //Bug360834TestLanguageAdapterFactory
