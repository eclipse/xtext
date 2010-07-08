/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmComponentType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;

import org.eclipse.xtext.xbase.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.XbasePackage
 * @generated
 */
public class XbaseAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static XbasePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XbaseAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = XbasePackage.eINSTANCE;
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
  protected XbaseSwitch<Adapter> modelSwitch =
    new XbaseSwitch<Adapter>()
    {
      @Override
      public Adapter caseXFile(XFile object)
      {
        return createXFileAdapter();
      }
      @Override
      public Adapter caseXImport(XImport object)
      {
        return createXImportAdapter();
      }
      @Override
      public Adapter caseXFunction(XFunction object)
      {
        return createXFunctionAdapter();
      }
      @Override
      public Adapter caseXClass(XClass object)
      {
        return createXClassAdapter();
      }
      @Override
      public Adapter caseJvmAnnotationTarget(JvmAnnotationTarget object)
      {
        return createJvmAnnotationTargetAdapter();
      }
      @Override
      public Adapter caseJvmIdentifyableElement(JvmIdentifyableElement object)
      {
        return createJvmIdentifyableElementAdapter();
      }
      @Override
      public Adapter caseJvmMember(JvmMember object)
      {
        return createJvmMemberAdapter();
      }
      @Override
      public Adapter caseJvmTypeParameterDeclarator(JvmTypeParameterDeclarator object)
      {
        return createJvmTypeParameterDeclaratorAdapter();
      }
      @Override
      public Adapter caseJvmExecutable(JvmExecutable object)
      {
        return createJvmExecutableAdapter();
      }
      @Override
      public Adapter caseJvmFeature(JvmFeature object)
      {
        return createJvmFeatureAdapter();
      }
      @Override
      public Adapter caseJvmOperation(JvmOperation object)
      {
        return createJvmOperationAdapter();
      }
      @Override
      public Adapter caseJvmType(JvmType object)
      {
        return createJvmTypeAdapter();
      }
      @Override
      public Adapter caseJvmComponentType(JvmComponentType object)
      {
        return createJvmComponentTypeAdapter();
      }
      @Override
      public Adapter caseJvmDeclaredType(JvmDeclaredType object)
      {
        return createJvmDeclaredTypeAdapter();
      }
      @Override
      public Adapter caseJvmGenericType(JvmGenericType object)
      {
        return createJvmGenericTypeAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XFile <em>XFile</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xbase.XFile
   * @generated
   */
  public Adapter createXFileAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XImport <em>XImport</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xbase.XImport
   * @generated
   */
  public Adapter createXImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XFunction <em>XFunction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xbase.XFunction
   * @generated
   */
  public Adapter createXFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.xbase.XClass <em>XClass</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.xbase.XClass
   * @generated
   */
  public Adapter createXClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmAnnotationTarget <em>Jvm Annotation Target</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmAnnotationTarget
   * @generated
   */
  public Adapter createJvmAnnotationTargetAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmIdentifyableElement <em>Jvm Identifyable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmIdentifyableElement
   * @generated
   */
  public Adapter createJvmIdentifyableElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmMember <em>Jvm Member</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmMember
   * @generated
   */
  public Adapter createJvmMemberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmTypeParameterDeclarator <em>Jvm Type Parameter Declarator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
   * @generated
   */
  public Adapter createJvmTypeParameterDeclaratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmExecutable <em>Jvm Executable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmExecutable
   * @generated
   */
  public Adapter createJvmExecutableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmFeature <em>Jvm Feature</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmFeature
   * @generated
   */
  public Adapter createJvmFeatureAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmOperation <em>Jvm Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmOperation
   * @generated
   */
  public Adapter createJvmOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmType <em>Jvm Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmType
   * @generated
   */
  public Adapter createJvmTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmComponentType <em>Jvm Component Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmComponentType
   * @generated
   */
  public Adapter createJvmComponentTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmDeclaredType <em>Jvm Declared Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmDeclaredType
   * @generated
   */
  public Adapter createJvmDeclaredTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmGenericType <em>Jvm Generic Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmGenericType
   * @generated
   */
  public Adapter createJvmGenericTypeAdapter()
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

} //XbaseAdapterFactory
