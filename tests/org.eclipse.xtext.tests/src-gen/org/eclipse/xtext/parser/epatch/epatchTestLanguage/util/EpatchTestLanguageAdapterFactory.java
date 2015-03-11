/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage
 * @generated
 */
public class EpatchTestLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static EpatchTestLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EpatchTestLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = EpatchTestLanguagePackage.eINSTANCE;
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
  protected EpatchTestLanguageSwitch<Adapter> modelSwitch =
    new EpatchTestLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseEPatch(EPatch object)
      {
        return createEPatchAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseModelImport(ModelImport object)
      {
        return createModelImportAdapter();
      }
      @Override
      public Adapter caseResourceImport(ResourceImport object)
      {
        return createResourceImportAdapter();
      }
      @Override
      public Adapter caseEPackageImport(EPackageImport object)
      {
        return createEPackageImportAdapter();
      }
      @Override
      public Adapter caseJavaImport(JavaImport object)
      {
        return createJavaImportAdapter();
      }
      @Override
      public Adapter caseExtensionImport(ExtensionImport object)
      {
        return createExtensionImportAdapter();
      }
      @Override
      public Adapter caseNamedResource(NamedResource object)
      {
        return createNamedResourceAdapter();
      }
      @Override
      public Adapter caseNamedObject(NamedObject object)
      {
        return createNamedObjectAdapter();
      }
      @Override
      public Adapter caseObjectRef(ObjectRef object)
      {
        return createObjectRefAdapter();
      }
      @Override
      public Adapter caseAssignment(Assignment object)
      {
        return createAssignmentAdapter();
      }
      @Override
      public Adapter caseSingleAssignment(SingleAssignment object)
      {
        return createSingleAssignmentAdapter();
      }
      @Override
      public Adapter caseListAssignment(ListAssignment object)
      {
        return createListAssignmentAdapter();
      }
      @Override
      public Adapter caseAssignmentValue(AssignmentValue object)
      {
        return createAssignmentValueAdapter();
      }
      @Override
      public Adapter caseCreatedObject(CreatedObject object)
      {
        return createCreatedObjectAdapter();
      }
      @Override
      public Adapter caseObjectNew(ObjectNew object)
      {
        return createObjectNewAdapter();
      }
      @Override
      public Adapter caseObjectCopy(ObjectCopy object)
      {
        return createObjectCopyAdapter();
      }
      @Override
      public Adapter caseMigration(Migration object)
      {
        return createMigrationAdapter();
      }
      @Override
      public Adapter caseExecutable(Executable object)
      {
        return createExecutableAdapter();
      }
      @Override
      public Adapter caseJavaExecutable(JavaExecutable object)
      {
        return createJavaExecutableAdapter();
      }
      @Override
      public Adapter caseExpressionExecutable(ExpressionExecutable object)
      {
        return createExpressionExecutableAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch <em>EPatch</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch
   * @generated
   */
  public Adapter createEPatchAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ModelImport <em>Model Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ModelImport
   * @generated
   */
  public Adapter createModelImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport <em>Resource Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport
   * @generated
   */
  public Adapter createResourceImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport <em>EPackage Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport
   * @generated
   */
  public Adapter createEPackageImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaImport <em>Java Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaImport
   * @generated
   */
  public Adapter createJavaImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExtensionImport <em>Extension Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExtensionImport
   * @generated
   */
  public Adapter createExtensionImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource <em>Named Resource</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource
   * @generated
   */
  public Adapter createNamedResourceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject <em>Named Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject
   * @generated
   */
  public Adapter createNamedObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef <em>Object Ref</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef
   * @generated
   */
  public Adapter createObjectRefAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Assignment
   * @generated
   */
  public Adapter createAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment <em>Single Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment
   * @generated
   */
  public Adapter createSingleAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment <em>List Assignment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment
   * @generated
   */
  public Adapter createListAssignmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue <em>Assignment Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue
   * @generated
   */
  public Adapter createAssignmentValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.CreatedObject <em>Created Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.CreatedObject
   * @generated
   */
  public Adapter createCreatedObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew <em>Object New</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew
   * @generated
   */
  public Adapter createObjectNewAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy <em>Object Copy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy
   * @generated
   */
  public Adapter createObjectCopyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration <em>Migration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration
   * @generated
   */
  public Adapter createMigrationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Executable <em>Executable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Executable
   * @generated
   */
  public Adapter createExecutableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaExecutable <em>Java Executable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaExecutable
   * @generated
   */
  public Adapter createJavaExecutableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExpressionExecutable <em>Expression Executable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExpressionExecutable
   * @generated
   */
  public Adapter createExpressionExecutableAdapter()
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

} //EpatchTestLanguageAdapterFactory
