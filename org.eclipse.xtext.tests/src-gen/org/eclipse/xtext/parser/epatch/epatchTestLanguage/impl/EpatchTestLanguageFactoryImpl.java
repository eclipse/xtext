/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EpatchTestLanguageFactoryImpl extends EFactoryImpl implements EpatchTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EpatchTestLanguageFactory init()
  {
    try
    {
      EpatchTestLanguageFactory theEpatchTestLanguageFactory = (EpatchTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(EpatchTestLanguagePackage.eNS_URI);
      if (theEpatchTestLanguageFactory != null)
      {
        return theEpatchTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EpatchTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EpatchTestLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case EpatchTestLanguagePackage.EPATCH: return createEPatch();
      case EpatchTestLanguagePackage.IMPORT: return createImport();
      case EpatchTestLanguagePackage.MODEL_IMPORT: return createModelImport();
      case EpatchTestLanguagePackage.RESOURCE_IMPORT: return createResourceImport();
      case EpatchTestLanguagePackage.EPACKAGE_IMPORT: return createEPackageImport();
      case EpatchTestLanguagePackage.JAVA_IMPORT: return createJavaImport();
      case EpatchTestLanguagePackage.EXTENSION_IMPORT: return createExtensionImport();
      case EpatchTestLanguagePackage.NAMED_RESOURCE: return createNamedResource();
      case EpatchTestLanguagePackage.NAMED_OBJECT: return createNamedObject();
      case EpatchTestLanguagePackage.OBJECT_REF: return createObjectRef();
      case EpatchTestLanguagePackage.ASSIGNMENT: return createAssignment();
      case EpatchTestLanguagePackage.SINGLE_ASSIGNMENT: return createSingleAssignment();
      case EpatchTestLanguagePackage.LIST_ASSIGNMENT: return createListAssignment();
      case EpatchTestLanguagePackage.ASSIGNMENT_VALUE: return createAssignmentValue();
      case EpatchTestLanguagePackage.CREATED_OBJECT: return createCreatedObject();
      case EpatchTestLanguagePackage.OBJECT_NEW: return createObjectNew();
      case EpatchTestLanguagePackage.OBJECT_COPY: return createObjectCopy();
      case EpatchTestLanguagePackage.MIGRATION: return createMigration();
      case EpatchTestLanguagePackage.EXECUTABLE: return createExecutable();
      case EpatchTestLanguagePackage.JAVA_EXECUTABLE: return createJavaExecutable();
      case EpatchTestLanguagePackage.EXPRESSION_EXECUTABLE: return createExpressionExecutable();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPatch createEPatch()
  {
    EPatchImpl ePatch = new EPatchImpl();
    return ePatch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelImport createModelImport()
  {
    ModelImportImpl modelImport = new ModelImportImpl();
    return modelImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ResourceImport createResourceImport()
  {
    ResourceImportImpl resourceImport = new ResourceImportImpl();
    return resourceImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackageImport createEPackageImport()
  {
    EPackageImportImpl ePackageImport = new EPackageImportImpl();
    return ePackageImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaImport createJavaImport()
  {
    JavaImportImpl javaImport = new JavaImportImpl();
    return javaImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtensionImport createExtensionImport()
  {
    ExtensionImportImpl extensionImport = new ExtensionImportImpl();
    return extensionImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedResource createNamedResource()
  {
    NamedResourceImpl namedResource = new NamedResourceImpl();
    return namedResource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedObject createNamedObject()
  {
    NamedObjectImpl namedObject = new NamedObjectImpl();
    return namedObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectRef createObjectRef()
  {
    ObjectRefImpl objectRef = new ObjectRefImpl();
    return objectRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assignment createAssignment()
  {
    AssignmentImpl assignment = new AssignmentImpl();
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleAssignment createSingleAssignment()
  {
    SingleAssignmentImpl singleAssignment = new SingleAssignmentImpl();
    return singleAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListAssignment createListAssignment()
  {
    ListAssignmentImpl listAssignment = new ListAssignmentImpl();
    return listAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentValue createAssignmentValue()
  {
    AssignmentValueImpl assignmentValue = new AssignmentValueImpl();
    return assignmentValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CreatedObject createCreatedObject()
  {
    CreatedObjectImpl createdObject = new CreatedObjectImpl();
    return createdObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectNew createObjectNew()
  {
    ObjectNewImpl objectNew = new ObjectNewImpl();
    return objectNew;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ObjectCopy createObjectCopy()
  {
    ObjectCopyImpl objectCopy = new ObjectCopyImpl();
    return objectCopy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Migration createMigration()
  {
    MigrationImpl migration = new MigrationImpl();
    return migration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Executable createExecutable()
  {
    ExecutableImpl executable = new ExecutableImpl();
    return executable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaExecutable createJavaExecutable()
  {
    JavaExecutableImpl javaExecutable = new JavaExecutableImpl();
    return javaExecutable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionExecutable createExpressionExecutable()
  {
    ExpressionExecutableImpl expressionExecutable = new ExpressionExecutableImpl();
    return expressionExecutable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EpatchTestLanguagePackage getEpatchTestLanguagePackage()
  {
    return (EpatchTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EpatchTestLanguagePackage getPackage()
  {
    return EpatchTestLanguagePackage.eINSTANCE;
  }

} //EpatchTestLanguageFactoryImpl
