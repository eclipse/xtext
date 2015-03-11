/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Assignment;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.CreatedObject;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguageFactory;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Executable;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExpressionExecutable;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExtensionImport;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Import;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaExecutable;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaImport;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ModelImport;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport;
import org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EpatchTestLanguagePackageImpl extends EPackageImpl implements EpatchTestLanguagePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ePatchEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelImportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resourceImportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ePackageImportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass javaImportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extensionImportEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedResourceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass createdObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectNewEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectCopyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass migrationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass executableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass javaExecutableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionExecutableEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguagePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private EpatchTestLanguagePackageImpl()
  {
    super(eNS_URI, EpatchTestLanguageFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link EpatchTestLanguagePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static EpatchTestLanguagePackage init()
  {
    if (isInited) return (EpatchTestLanguagePackage)EPackage.Registry.INSTANCE.getEPackage(EpatchTestLanguagePackage.eNS_URI);

    // Obtain or create and register package
    EpatchTestLanguagePackageImpl theEpatchTestLanguagePackage = (EpatchTestLanguagePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EpatchTestLanguagePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EpatchTestLanguagePackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theEpatchTestLanguagePackage.createPackageContents();

    // Initialize created meta-data
    theEpatchTestLanguagePackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEpatchTestLanguagePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EpatchTestLanguagePackage.eNS_URI, theEpatchTestLanguagePackage);
    return theEpatchTestLanguagePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEPatch()
  {
    return ePatchEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEPatch_Name()
  {
    return (EAttribute)ePatchEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEPatch_Imports()
  {
    return (EReference)ePatchEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEPatch_Resources()
  {
    return (EReference)ePatchEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEPatch_Objects()
  {
    return (EReference)ePatchEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelImport()
  {
    return modelImportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelImport_Name()
  {
    return (EAttribute)modelImportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResourceImport()
  {
    return resourceImportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getResourceImport_Uri()
  {
    return (EAttribute)resourceImportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEPackageImport()
  {
    return ePackageImportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEPackageImport_NsURI()
  {
    return (EAttribute)ePackageImportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJavaImport()
  {
    return javaImportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJavaImport_Path()
  {
    return (EAttribute)javaImportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtensionImport()
  {
    return extensionImportEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtensionImport_Path()
  {
    return (EAttribute)extensionImportEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedResource()
  {
    return namedResourceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedResource_Name()
  {
    return (EAttribute)namedResourceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedResource_LeftUri()
  {
    return (EAttribute)namedResourceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedResource_LeftRoot()
  {
    return (EReference)namedResourceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedResource_RightUri()
  {
    return (EAttribute)namedResourceEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedResource_RightRoot()
  {
    return (EReference)namedResourceEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedObject()
  {
    return namedObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedObject_Name()
  {
    return (EAttribute)namedObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedObject_Assignments()
  {
    return (EReference)namedObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedObject_LeftMig()
  {
    return (EReference)namedObjectEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectRef()
  {
    return objectRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectRef_LeftRes()
  {
    return (EReference)objectRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectRef_LeftFrag()
  {
    return (EAttribute)objectRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectRef_RightRes()
  {
    return (EReference)objectRefEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectRef_RightFrag()
  {
    return (EAttribute)objectRefEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectRef_RightMig()
  {
    return (EReference)objectRefEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignment()
  {
    return assignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignment_Feature()
  {
    return (EAttribute)assignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleAssignment()
  {
    return singleAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleAssignment_LeftValue()
  {
    return (EReference)singleAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleAssignment_RightValue()
  {
    return (EReference)singleAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getListAssignment()
  {
    return listAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListAssignment_LeftValues()
  {
    return (EReference)listAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getListAssignment_RightValues()
  {
    return (EReference)listAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignmentValue()
  {
    return assignmentValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentValue_Value()
  {
    return (EAttribute)assignmentValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentValue_RefObject()
  {
    return (EReference)assignmentValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentValue_RefFeature()
  {
    return (EAttribute)assignmentValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentValue_RefIndex()
  {
    return (EAttribute)assignmentValueEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentValue_NewObject()
  {
    return (EReference)assignmentValueEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentValue_Import()
  {
    return (EReference)assignmentValueEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentValue_ImpFrag()
  {
    return (EAttribute)assignmentValueEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentValue_Index()
  {
    return (EAttribute)assignmentValueEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignmentValue_Keyword()
  {
    return (EAttribute)assignmentValueEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCreatedObject()
  {
    return createdObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectNew()
  {
    return objectNewEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectNew_Import()
  {
    return (EReference)objectNewEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectNew_ImpFrag()
  {
    return (EAttribute)objectNewEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectCopy()
  {
    return objectCopyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectCopy_Resource()
  {
    return (EReference)objectCopyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getObjectCopy_Fragment()
  {
    return (EAttribute)objectCopyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMigration()
  {
    return migrationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMigration_First()
  {
    return (EReference)migrationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMigration_AsOp()
  {
    return (EReference)migrationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMigration_EachOp()
  {
    return (EReference)migrationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExecutable()
  {
    return executableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJavaExecutable()
  {
    return javaExecutableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJavaExecutable_Method()
  {
    return (EAttribute)javaExecutableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionExecutable()
  {
    return expressionExecutableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpressionExecutable_Exprstr()
  {
    return (EAttribute)expressionExecutableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EpatchTestLanguageFactory getEpatchTestLanguageFactory()
  {
    return (EpatchTestLanguageFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    ePatchEClass = createEClass(EPATCH);
    createEAttribute(ePatchEClass, EPATCH__NAME);
    createEReference(ePatchEClass, EPATCH__IMPORTS);
    createEReference(ePatchEClass, EPATCH__RESOURCES);
    createEReference(ePatchEClass, EPATCH__OBJECTS);

    importEClass = createEClass(IMPORT);

    modelImportEClass = createEClass(MODEL_IMPORT);
    createEAttribute(modelImportEClass, MODEL_IMPORT__NAME);

    resourceImportEClass = createEClass(RESOURCE_IMPORT);
    createEAttribute(resourceImportEClass, RESOURCE_IMPORT__URI);

    ePackageImportEClass = createEClass(EPACKAGE_IMPORT);
    createEAttribute(ePackageImportEClass, EPACKAGE_IMPORT__NS_URI);

    javaImportEClass = createEClass(JAVA_IMPORT);
    createEAttribute(javaImportEClass, JAVA_IMPORT__PATH);

    extensionImportEClass = createEClass(EXTENSION_IMPORT);
    createEAttribute(extensionImportEClass, EXTENSION_IMPORT__PATH);

    namedResourceEClass = createEClass(NAMED_RESOURCE);
    createEAttribute(namedResourceEClass, NAMED_RESOURCE__NAME);
    createEAttribute(namedResourceEClass, NAMED_RESOURCE__LEFT_URI);
    createEReference(namedResourceEClass, NAMED_RESOURCE__LEFT_ROOT);
    createEAttribute(namedResourceEClass, NAMED_RESOURCE__RIGHT_URI);
    createEReference(namedResourceEClass, NAMED_RESOURCE__RIGHT_ROOT);

    namedObjectEClass = createEClass(NAMED_OBJECT);
    createEAttribute(namedObjectEClass, NAMED_OBJECT__NAME);
    createEReference(namedObjectEClass, NAMED_OBJECT__ASSIGNMENTS);
    createEReference(namedObjectEClass, NAMED_OBJECT__LEFT_MIG);

    objectRefEClass = createEClass(OBJECT_REF);
    createEReference(objectRefEClass, OBJECT_REF__LEFT_RES);
    createEAttribute(objectRefEClass, OBJECT_REF__LEFT_FRAG);
    createEReference(objectRefEClass, OBJECT_REF__RIGHT_RES);
    createEAttribute(objectRefEClass, OBJECT_REF__RIGHT_FRAG);
    createEReference(objectRefEClass, OBJECT_REF__RIGHT_MIG);

    assignmentEClass = createEClass(ASSIGNMENT);
    createEAttribute(assignmentEClass, ASSIGNMENT__FEATURE);

    singleAssignmentEClass = createEClass(SINGLE_ASSIGNMENT);
    createEReference(singleAssignmentEClass, SINGLE_ASSIGNMENT__LEFT_VALUE);
    createEReference(singleAssignmentEClass, SINGLE_ASSIGNMENT__RIGHT_VALUE);

    listAssignmentEClass = createEClass(LIST_ASSIGNMENT);
    createEReference(listAssignmentEClass, LIST_ASSIGNMENT__LEFT_VALUES);
    createEReference(listAssignmentEClass, LIST_ASSIGNMENT__RIGHT_VALUES);

    assignmentValueEClass = createEClass(ASSIGNMENT_VALUE);
    createEAttribute(assignmentValueEClass, ASSIGNMENT_VALUE__VALUE);
    createEReference(assignmentValueEClass, ASSIGNMENT_VALUE__REF_OBJECT);
    createEAttribute(assignmentValueEClass, ASSIGNMENT_VALUE__REF_FEATURE);
    createEAttribute(assignmentValueEClass, ASSIGNMENT_VALUE__REF_INDEX);
    createEReference(assignmentValueEClass, ASSIGNMENT_VALUE__NEW_OBJECT);
    createEReference(assignmentValueEClass, ASSIGNMENT_VALUE__IMPORT);
    createEAttribute(assignmentValueEClass, ASSIGNMENT_VALUE__IMP_FRAG);
    createEAttribute(assignmentValueEClass, ASSIGNMENT_VALUE__INDEX);
    createEAttribute(assignmentValueEClass, ASSIGNMENT_VALUE__KEYWORD);

    createdObjectEClass = createEClass(CREATED_OBJECT);

    objectNewEClass = createEClass(OBJECT_NEW);
    createEReference(objectNewEClass, OBJECT_NEW__IMPORT);
    createEAttribute(objectNewEClass, OBJECT_NEW__IMP_FRAG);

    objectCopyEClass = createEClass(OBJECT_COPY);
    createEReference(objectCopyEClass, OBJECT_COPY__RESOURCE);
    createEAttribute(objectCopyEClass, OBJECT_COPY__FRAGMENT);

    migrationEClass = createEClass(MIGRATION);
    createEReference(migrationEClass, MIGRATION__FIRST);
    createEReference(migrationEClass, MIGRATION__AS_OP);
    createEReference(migrationEClass, MIGRATION__EACH_OP);

    executableEClass = createEClass(EXECUTABLE);

    javaExecutableEClass = createEClass(JAVA_EXECUTABLE);
    createEAttribute(javaExecutableEClass, JAVA_EXECUTABLE__METHOD);

    expressionExecutableEClass = createEClass(EXPRESSION_EXECUTABLE);
    createEAttribute(expressionExecutableEClass, EXPRESSION_EXECUTABLE__EXPRSTR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    modelImportEClass.getESuperTypes().add(this.getImport());
    resourceImportEClass.getESuperTypes().add(this.getModelImport());
    ePackageImportEClass.getESuperTypes().add(this.getModelImport());
    javaImportEClass.getESuperTypes().add(this.getImport());
    extensionImportEClass.getESuperTypes().add(this.getImport());
    objectRefEClass.getESuperTypes().add(this.getNamedObject());
    singleAssignmentEClass.getESuperTypes().add(this.getAssignment());
    listAssignmentEClass.getESuperTypes().add(this.getAssignment());
    createdObjectEClass.getESuperTypes().add(this.getNamedObject());
    objectNewEClass.getESuperTypes().add(this.getCreatedObject());
    objectCopyEClass.getESuperTypes().add(this.getCreatedObject());
    javaExecutableEClass.getESuperTypes().add(this.getExecutable());
    expressionExecutableEClass.getESuperTypes().add(this.getExecutable());

    // Initialize classes and features; add operations and parameters
    initEClass(ePatchEClass, EPatch.class, "EPatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEPatch_Name(), theEcorePackage.getEString(), "name", null, 0, 1, EPatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEPatch_Imports(), this.getImport(), null, "imports", null, 0, -1, EPatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEPatch_Resources(), this.getNamedResource(), null, "resources", null, 0, -1, EPatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEPatch_Objects(), this.getObjectRef(), null, "objects", null, 0, -1, EPatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(modelImportEClass, ModelImport.class, "ModelImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelImport_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ModelImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resourceImportEClass, ResourceImport.class, "ResourceImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getResourceImport_Uri(), theEcorePackage.getEString(), "uri", null, 0, 1, ResourceImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ePackageImportEClass, EPackageImport.class, "EPackageImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEPackageImport_NsURI(), theEcorePackage.getEString(), "nsURI", null, 0, 1, EPackageImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(javaImportEClass, JavaImport.class, "JavaImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJavaImport_Path(), theEcorePackage.getEString(), "path", null, 0, -1, JavaImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(extensionImportEClass, ExtensionImport.class, "ExtensionImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExtensionImport_Path(), theEcorePackage.getEString(), "path", null, 0, -1, ExtensionImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedResourceEClass, NamedResource.class, "NamedResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedResource_Name(), theEcorePackage.getEString(), "name", null, 0, 1, NamedResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNamedResource_LeftUri(), theEcorePackage.getEString(), "leftUri", null, 0, 1, NamedResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedResource_LeftRoot(), this.getCreatedObject(), null, "leftRoot", null, 0, 1, NamedResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNamedResource_RightUri(), theEcorePackage.getEString(), "rightUri", null, 0, 1, NamedResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedResource_RightRoot(), this.getCreatedObject(), null, "rightRoot", null, 0, 1, NamedResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedObjectEClass, NamedObject.class, "NamedObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedObject_Name(), theEcorePackage.getEString(), "name", null, 0, 1, NamedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedObject_Assignments(), this.getAssignment(), null, "assignments", null, 0, -1, NamedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedObject_LeftMig(), this.getMigration(), null, "leftMig", null, 0, 1, NamedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectRefEClass, ObjectRef.class, "ObjectRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectRef_LeftRes(), this.getNamedResource(), null, "leftRes", null, 0, 1, ObjectRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectRef_LeftFrag(), theEcorePackage.getEString(), "leftFrag", null, 0, 1, ObjectRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectRef_RightRes(), this.getNamedResource(), null, "rightRes", null, 0, 1, ObjectRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectRef_RightFrag(), theEcorePackage.getEString(), "rightFrag", null, 0, 1, ObjectRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectRef_RightMig(), this.getMigration(), null, "rightMig", null, 0, 1, ObjectRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssignment_Feature(), theEcorePackage.getEString(), "feature", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleAssignmentEClass, SingleAssignment.class, "SingleAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSingleAssignment_LeftValue(), this.getAssignmentValue(), null, "leftValue", null, 0, 1, SingleAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSingleAssignment_RightValue(), this.getAssignmentValue(), null, "rightValue", null, 0, 1, SingleAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listAssignmentEClass, ListAssignment.class, "ListAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getListAssignment_LeftValues(), this.getAssignmentValue(), null, "leftValues", null, 0, -1, ListAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getListAssignment_RightValues(), this.getAssignmentValue(), null, "rightValues", null, 0, -1, ListAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentValueEClass, AssignmentValue.class, "AssignmentValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssignmentValue_Value(), theEcorePackage.getEString(), "value", null, 0, 1, AssignmentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentValue_RefObject(), this.getNamedObject(), null, "refObject", null, 0, 1, AssignmentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignmentValue_RefFeature(), theEcorePackage.getEString(), "refFeature", null, 0, 1, AssignmentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignmentValue_RefIndex(), theEcorePackage.getEInt(), "refIndex", null, 0, 1, AssignmentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentValue_NewObject(), this.getCreatedObject(), null, "newObject", null, 0, 1, AssignmentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentValue_Import(), this.getImport(), null, "import", null, 0, 1, AssignmentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignmentValue_ImpFrag(), theEcorePackage.getEString(), "impFrag", null, 0, 1, AssignmentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignmentValue_Index(), theEcorePackage.getEInt(), "index", null, 0, 1, AssignmentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignmentValue_Keyword(), theEcorePackage.getEString(), "keyword", null, 0, 1, AssignmentValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(createdObjectEClass, CreatedObject.class, "CreatedObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(objectNewEClass, ObjectNew.class, "ObjectNew", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectNew_Import(), this.getImport(), null, "import", null, 0, 1, ObjectNew.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectNew_ImpFrag(), theEcorePackage.getEString(), "impFrag", null, 0, 1, ObjectNew.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectCopyEClass, ObjectCopy.class, "ObjectCopy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectCopy_Resource(), this.getNamedResource(), null, "resource", null, 0, 1, ObjectCopy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getObjectCopy_Fragment(), theEcorePackage.getEString(), "fragment", null, 0, 1, ObjectCopy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(migrationEClass, Migration.class, "Migration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMigration_First(), this.getExecutable(), null, "first", null, 0, 1, Migration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMigration_AsOp(), this.getExecutable(), null, "asOp", null, 0, 1, Migration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMigration_EachOp(), this.getExecutable(), null, "eachOp", null, 0, 1, Migration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(executableEClass, Executable.class, "Executable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(javaExecutableEClass, JavaExecutable.class, "JavaExecutable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJavaExecutable_Method(), theEcorePackage.getEString(), "method", null, 0, 1, JavaExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionExecutableEClass, ExpressionExecutable.class, "ExpressionExecutable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExpressionExecutable_Exprstr(), theEcorePackage.getEString(), "exprstr", null, 0, 1, ExpressionExecutable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //EpatchTestLanguagePackageImpl
