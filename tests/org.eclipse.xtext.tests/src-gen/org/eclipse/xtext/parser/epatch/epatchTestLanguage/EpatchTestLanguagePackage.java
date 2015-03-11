/**
 */
package org.eclipse.xtext.parser.epatch.epatchTestLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EpatchTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface EpatchTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "epatchTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/EpatchTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "epatchTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EpatchTestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPatchImpl <em>EPatch</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPatchImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getEPatch()
   * @generated
   */
  int EPATCH = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPATCH__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPATCH__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Resources</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPATCH__RESOURCES = 2;

  /**
   * The feature id for the '<em><b>Objects</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPATCH__OBJECTS = 3;

  /**
   * The number of structural features of the '<em>EPatch</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPATCH_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ImportImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ModelImportImpl <em>Model Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ModelImportImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getModelImport()
   * @generated
   */
  int MODEL_IMPORT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_IMPORT__NAME = IMPORT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Model Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_IMPORT_FEATURE_COUNT = IMPORT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ResourceImportImpl <em>Resource Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ResourceImportImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getResourceImport()
   * @generated
   */
  int RESOURCE_IMPORT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_IMPORT__NAME = MODEL_IMPORT__NAME;

  /**
   * The feature id for the '<em><b>Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_IMPORT__URI = MODEL_IMPORT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Resource Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOURCE_IMPORT_FEATURE_COUNT = MODEL_IMPORT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPackageImportImpl <em>EPackage Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPackageImportImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getEPackageImport()
   * @generated
   */
  int EPACKAGE_IMPORT = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPACKAGE_IMPORT__NAME = MODEL_IMPORT__NAME;

  /**
   * The feature id for the '<em><b>Ns URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPACKAGE_IMPORT__NS_URI = MODEL_IMPORT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EPackage Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EPACKAGE_IMPORT_FEATURE_COUNT = MODEL_IMPORT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.JavaImportImpl <em>Java Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.JavaImportImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getJavaImport()
   * @generated
   */
  int JAVA_IMPORT = 5;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_IMPORT__PATH = IMPORT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Java Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_IMPORT_FEATURE_COUNT = IMPORT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExtensionImportImpl <em>Extension Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExtensionImportImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getExtensionImport()
   * @generated
   */
  int EXTENSION_IMPORT = 6;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSION_IMPORT__PATH = IMPORT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Extension Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSION_IMPORT_FEATURE_COUNT = IMPORT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedResourceImpl <em>Named Resource</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedResourceImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getNamedResource()
   * @generated
   */
  int NAMED_RESOURCE = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_RESOURCE__NAME = 0;

  /**
   * The feature id for the '<em><b>Left Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_RESOURCE__LEFT_URI = 1;

  /**
   * The feature id for the '<em><b>Left Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_RESOURCE__LEFT_ROOT = 2;

  /**
   * The feature id for the '<em><b>Right Uri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_RESOURCE__RIGHT_URI = 3;

  /**
   * The feature id for the '<em><b>Right Root</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_RESOURCE__RIGHT_ROOT = 4;

  /**
   * The number of structural features of the '<em>Named Resource</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_RESOURCE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedObjectImpl <em>Named Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedObjectImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getNamedObject()
   * @generated
   */
  int NAMED_OBJECT = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_OBJECT__NAME = 0;

  /**
   * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_OBJECT__ASSIGNMENTS = 1;

  /**
   * The feature id for the '<em><b>Left Mig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_OBJECT__LEFT_MIG = 2;

  /**
   * The number of structural features of the '<em>Named Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_OBJECT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectRefImpl <em>Object Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectRefImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getObjectRef()
   * @generated
   */
  int OBJECT_REF = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REF__NAME = NAMED_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REF__ASSIGNMENTS = NAMED_OBJECT__ASSIGNMENTS;

  /**
   * The feature id for the '<em><b>Left Mig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REF__LEFT_MIG = NAMED_OBJECT__LEFT_MIG;

  /**
   * The feature id for the '<em><b>Left Res</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REF__LEFT_RES = NAMED_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Left Frag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REF__LEFT_FRAG = NAMED_OBJECT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Res</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REF__RIGHT_RES = NAMED_OBJECT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Right Frag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REF__RIGHT_FRAG = NAMED_OBJECT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Right Mig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REF__RIGHT_MIG = NAMED_OBJECT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Object Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_REF_FEATURE_COUNT = NAMED_OBJECT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 10;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__FEATURE = 0;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.SingleAssignmentImpl <em>Single Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.SingleAssignmentImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getSingleAssignment()
   * @generated
   */
  int SINGLE_ASSIGNMENT = 11;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSIGNMENT__FEATURE = ASSIGNMENT__FEATURE;

  /**
   * The feature id for the '<em><b>Left Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSIGNMENT__LEFT_VALUE = ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSIGNMENT__RIGHT_VALUE = ASSIGNMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Single Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSIGNMENT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ListAssignmentImpl <em>List Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ListAssignmentImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getListAssignment()
   * @generated
   */
  int LIST_ASSIGNMENT = 12;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_ASSIGNMENT__FEATURE = ASSIGNMENT__FEATURE;

  /**
   * The feature id for the '<em><b>Left Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_ASSIGNMENT__LEFT_VALUES = ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_ASSIGNMENT__RIGHT_VALUES = ASSIGNMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>List Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_ASSIGNMENT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl <em>Assignment Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getAssignmentValue()
   * @generated
   */
  int ASSIGNMENT_VALUE = 13;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE__VALUE = 0;

  /**
   * The feature id for the '<em><b>Ref Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE__REF_OBJECT = 1;

  /**
   * The feature id for the '<em><b>Ref Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE__REF_FEATURE = 2;

  /**
   * The feature id for the '<em><b>Ref Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE__REF_INDEX = 3;

  /**
   * The feature id for the '<em><b>New Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE__NEW_OBJECT = 4;

  /**
   * The feature id for the '<em><b>Import</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE__IMPORT = 5;

  /**
   * The feature id for the '<em><b>Imp Frag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE__IMP_FRAG = 6;

  /**
   * The feature id for the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE__INDEX = 7;

  /**
   * The feature id for the '<em><b>Keyword</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE__KEYWORD = 8;

  /**
   * The number of structural features of the '<em>Assignment Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_VALUE_FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.CreatedObjectImpl <em>Created Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.CreatedObjectImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getCreatedObject()
   * @generated
   */
  int CREATED_OBJECT = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATED_OBJECT__NAME = NAMED_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATED_OBJECT__ASSIGNMENTS = NAMED_OBJECT__ASSIGNMENTS;

  /**
   * The feature id for the '<em><b>Left Mig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATED_OBJECT__LEFT_MIG = NAMED_OBJECT__LEFT_MIG;

  /**
   * The number of structural features of the '<em>Created Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CREATED_OBJECT_FEATURE_COUNT = NAMED_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectNewImpl <em>Object New</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectNewImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getObjectNew()
   * @generated
   */
  int OBJECT_NEW = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_NEW__NAME = CREATED_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_NEW__ASSIGNMENTS = CREATED_OBJECT__ASSIGNMENTS;

  /**
   * The feature id for the '<em><b>Left Mig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_NEW__LEFT_MIG = CREATED_OBJECT__LEFT_MIG;

  /**
   * The feature id for the '<em><b>Import</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_NEW__IMPORT = CREATED_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Imp Frag</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_NEW__IMP_FRAG = CREATED_OBJECT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Object New</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_NEW_FEATURE_COUNT = CREATED_OBJECT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectCopyImpl <em>Object Copy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectCopyImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getObjectCopy()
   * @generated
   */
  int OBJECT_COPY = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_COPY__NAME = CREATED_OBJECT__NAME;

  /**
   * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_COPY__ASSIGNMENTS = CREATED_OBJECT__ASSIGNMENTS;

  /**
   * The feature id for the '<em><b>Left Mig</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_COPY__LEFT_MIG = CREATED_OBJECT__LEFT_MIG;

  /**
   * The feature id for the '<em><b>Resource</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_COPY__RESOURCE = CREATED_OBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Fragment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_COPY__FRAGMENT = CREATED_OBJECT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Object Copy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OBJECT_COPY_FEATURE_COUNT = CREATED_OBJECT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.MigrationImpl <em>Migration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.MigrationImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getMigration()
   * @generated
   */
  int MIGRATION = 17;

  /**
   * The feature id for the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIGRATION__FIRST = 0;

  /**
   * The feature id for the '<em><b>As Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIGRATION__AS_OP = 1;

  /**
   * The feature id for the '<em><b>Each Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIGRATION__EACH_OP = 2;

  /**
   * The number of structural features of the '<em>Migration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIGRATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExecutableImpl <em>Executable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExecutableImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getExecutable()
   * @generated
   */
  int EXECUTABLE = 18;

  /**
   * The number of structural features of the '<em>Executable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTABLE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.JavaExecutableImpl <em>Java Executable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.JavaExecutableImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getJavaExecutable()
   * @generated
   */
  int JAVA_EXECUTABLE = 19;

  /**
   * The feature id for the '<em><b>Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_EXECUTABLE__METHOD = EXECUTABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Java Executable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_EXECUTABLE_FEATURE_COUNT = EXECUTABLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExpressionExecutableImpl <em>Expression Executable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExpressionExecutableImpl
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getExpressionExecutable()
   * @generated
   */
  int EXPRESSION_EXECUTABLE = 20;

  /**
   * The feature id for the '<em><b>Exprstr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_EXECUTABLE__EXPRSTR = EXECUTABLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression Executable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_EXECUTABLE_FEATURE_COUNT = EXECUTABLE_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch <em>EPatch</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EPatch</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch
   * @generated
   */
  EClass getEPatch();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch#getName()
   * @see #getEPatch()
   * @generated
   */
  EAttribute getEPatch_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch#getImports()
   * @see #getEPatch()
   * @generated
   */
  EReference getEPatch_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch#getResources <em>Resources</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Resources</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch#getResources()
   * @see #getEPatch()
   * @generated
   */
  EReference getEPatch_Resources();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch#getObjects <em>Objects</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Objects</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPatch#getObjects()
   * @see #getEPatch()
   * @generated
   */
  EReference getEPatch_Objects();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ModelImport <em>Model Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Import</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ModelImport
   * @generated
   */
  EClass getModelImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ModelImport#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ModelImport#getName()
   * @see #getModelImport()
   * @generated
   */
  EAttribute getModelImport_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport <em>Resource Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Resource Import</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport
   * @generated
   */
  EClass getResourceImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport#getUri <em>Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Uri</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ResourceImport#getUri()
   * @see #getResourceImport()
   * @generated
   */
  EAttribute getResourceImport_Uri();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport <em>EPackage Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EPackage Import</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport
   * @generated
   */
  EClass getEPackageImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport#getNsURI <em>Ns URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ns URI</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.EPackageImport#getNsURI()
   * @see #getEPackageImport()
   * @generated
   */
  EAttribute getEPackageImport_NsURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaImport <em>Java Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Import</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaImport
   * @generated
   */
  EClass getJavaImport();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaImport#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Path</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaImport#getPath()
   * @see #getJavaImport()
   * @generated
   */
  EAttribute getJavaImport_Path();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExtensionImport <em>Extension Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Extension Import</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExtensionImport
   * @generated
   */
  EClass getExtensionImport();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExtensionImport#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Path</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExtensionImport#getPath()
   * @see #getExtensionImport()
   * @generated
   */
  EAttribute getExtensionImport_Path();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource <em>Named Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Resource</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource
   * @generated
   */
  EClass getNamedResource();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getName()
   * @see #getNamedResource()
   * @generated
   */
  EAttribute getNamedResource_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getLeftUri <em>Left Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Left Uri</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getLeftUri()
   * @see #getNamedResource()
   * @generated
   */
  EAttribute getNamedResource_LeftUri();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getLeftRoot <em>Left Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Root</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getLeftRoot()
   * @see #getNamedResource()
   * @generated
   */
  EReference getNamedResource_LeftRoot();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getRightUri <em>Right Uri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Right Uri</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getRightUri()
   * @see #getNamedResource()
   * @generated
   */
  EAttribute getNamedResource_RightUri();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getRightRoot <em>Right Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Root</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedResource#getRightRoot()
   * @see #getNamedResource()
   * @generated
   */
  EReference getNamedResource_RightRoot();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject <em>Named Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Object</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject
   * @generated
   */
  EClass getNamedObject();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getName()
   * @see #getNamedObject()
   * @generated
   */
  EAttribute getNamedObject_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getAssignments <em>Assignments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Assignments</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getAssignments()
   * @see #getNamedObject()
   * @generated
   */
  EReference getNamedObject_Assignments();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getLeftMig <em>Left Mig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Mig</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.NamedObject#getLeftMig()
   * @see #getNamedObject()
   * @generated
   */
  EReference getNamedObject_LeftMig();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef <em>Object Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Ref</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef
   * @generated
   */
  EClass getObjectRef();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getLeftRes <em>Left Res</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Left Res</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getLeftRes()
   * @see #getObjectRef()
   * @generated
   */
  EReference getObjectRef_LeftRes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getLeftFrag <em>Left Frag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Left Frag</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getLeftFrag()
   * @see #getObjectRef()
   * @generated
   */
  EAttribute getObjectRef_LeftFrag();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightRes <em>Right Res</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Right Res</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightRes()
   * @see #getObjectRef()
   * @generated
   */
  EReference getObjectRef_RightRes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightFrag <em>Right Frag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Right Frag</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightFrag()
   * @see #getObjectRef()
   * @generated
   */
  EAttribute getObjectRef_RightFrag();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightMig <em>Right Mig</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Mig</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectRef#getRightMig()
   * @see #getObjectRef()
   * @generated
   */
  EReference getObjectRef_RightMig();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Assignment#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Assignment#getFeature()
   * @see #getAssignment()
   * @generated
   */
  EAttribute getAssignment_Feature();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment <em>Single Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Assignment</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment
   * @generated
   */
  EClass getSingleAssignment();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment#getLeftValue <em>Left Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Value</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment#getLeftValue()
   * @see #getSingleAssignment()
   * @generated
   */
  EReference getSingleAssignment_LeftValue();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment#getRightValue <em>Right Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Value</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.SingleAssignment#getRightValue()
   * @see #getSingleAssignment()
   * @generated
   */
  EReference getSingleAssignment_RightValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment <em>List Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Assignment</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment
   * @generated
   */
  EClass getListAssignment();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment#getLeftValues <em>Left Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Left Values</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment#getLeftValues()
   * @see #getListAssignment()
   * @generated
   */
  EReference getListAssignment_LeftValues();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment#getRightValues <em>Right Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right Values</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ListAssignment#getRightValues()
   * @see #getListAssignment()
   * @generated
   */
  EReference getListAssignment_RightValues();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue <em>Assignment Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Value</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue
   * @generated
   */
  EClass getAssignmentValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getValue()
   * @see #getAssignmentValue()
   * @generated
   */
  EAttribute getAssignmentValue_Value();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getRefObject <em>Ref Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref Object</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getRefObject()
   * @see #getAssignmentValue()
   * @generated
   */
  EReference getAssignmentValue_RefObject();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getRefFeature <em>Ref Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref Feature</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getRefFeature()
   * @see #getAssignmentValue()
   * @generated
   */
  EAttribute getAssignmentValue_RefFeature();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getRefIndex <em>Ref Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ref Index</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getRefIndex()
   * @see #getAssignmentValue()
   * @generated
   */
  EAttribute getAssignmentValue_RefIndex();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getNewObject <em>New Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>New Object</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getNewObject()
   * @see #getAssignmentValue()
   * @generated
   */
  EReference getAssignmentValue_NewObject();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getImport <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Import</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getImport()
   * @see #getAssignmentValue()
   * @generated
   */
  EReference getAssignmentValue_Import();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getImpFrag <em>Imp Frag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imp Frag</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getImpFrag()
   * @see #getAssignmentValue()
   * @generated
   */
  EAttribute getAssignmentValue_ImpFrag();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getIndex()
   * @see #getAssignmentValue()
   * @generated
   */
  EAttribute getAssignmentValue_Index();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getKeyword <em>Keyword</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Keyword</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.AssignmentValue#getKeyword()
   * @see #getAssignmentValue()
   * @generated
   */
  EAttribute getAssignmentValue_Keyword();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.CreatedObject <em>Created Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Created Object</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.CreatedObject
   * @generated
   */
  EClass getCreatedObject();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew <em>Object New</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object New</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew
   * @generated
   */
  EClass getObjectNew();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew#getImport <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Import</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew#getImport()
   * @see #getObjectNew()
   * @generated
   */
  EReference getObjectNew_Import();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew#getImpFrag <em>Imp Frag</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imp Frag</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectNew#getImpFrag()
   * @see #getObjectNew()
   * @generated
   */
  EAttribute getObjectNew_ImpFrag();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy <em>Object Copy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Object Copy</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy
   * @generated
   */
  EClass getObjectCopy();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy#getResource <em>Resource</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Resource</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy#getResource()
   * @see #getObjectCopy()
   * @generated
   */
  EReference getObjectCopy_Resource();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy#getFragment <em>Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fragment</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ObjectCopy#getFragment()
   * @see #getObjectCopy()
   * @generated
   */
  EAttribute getObjectCopy_Fragment();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration <em>Migration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Migration</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration
   * @generated
   */
  EClass getMigration();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getFirst()
   * @see #getMigration()
   * @generated
   */
  EReference getMigration_First();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getAsOp <em>As Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>As Op</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getAsOp()
   * @see #getMigration()
   * @generated
   */
  EReference getMigration_AsOp();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getEachOp <em>Each Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Each Op</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Migration#getEachOp()
   * @see #getMigration()
   * @generated
   */
  EReference getMigration_EachOp();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.Executable <em>Executable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Executable</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.Executable
   * @generated
   */
  EClass getExecutable();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaExecutable <em>Java Executable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Executable</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaExecutable
   * @generated
   */
  EClass getJavaExecutable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaExecutable#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Method</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.JavaExecutable#getMethod()
   * @see #getJavaExecutable()
   * @generated
   */
  EAttribute getJavaExecutable_Method();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExpressionExecutable <em>Expression Executable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Executable</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExpressionExecutable
   * @generated
   */
  EClass getExpressionExecutable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExpressionExecutable#getExprstr <em>Exprstr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exprstr</em>'.
   * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.ExpressionExecutable#getExprstr()
   * @see #getExpressionExecutable()
   * @generated
   */
  EAttribute getExpressionExecutable_Exprstr();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EpatchTestLanguageFactory getEpatchTestLanguageFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPatchImpl <em>EPatch</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPatchImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getEPatch()
     * @generated
     */
    EClass EPATCH = eINSTANCE.getEPatch();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EPATCH__NAME = eINSTANCE.getEPatch_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EPATCH__IMPORTS = eINSTANCE.getEPatch_Imports();

    /**
     * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EPATCH__RESOURCES = eINSTANCE.getEPatch_Resources();

    /**
     * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EPATCH__OBJECTS = eINSTANCE.getEPatch_Objects();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ImportImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ModelImportImpl <em>Model Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ModelImportImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getModelImport()
     * @generated
     */
    EClass MODEL_IMPORT = eINSTANCE.getModelImport();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_IMPORT__NAME = eINSTANCE.getModelImport_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ResourceImportImpl <em>Resource Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ResourceImportImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getResourceImport()
     * @generated
     */
    EClass RESOURCE_IMPORT = eINSTANCE.getResourceImport();

    /**
     * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESOURCE_IMPORT__URI = eINSTANCE.getResourceImport_Uri();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPackageImportImpl <em>EPackage Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EPackageImportImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getEPackageImport()
     * @generated
     */
    EClass EPACKAGE_IMPORT = eINSTANCE.getEPackageImport();

    /**
     * The meta object literal for the '<em><b>Ns URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EPACKAGE_IMPORT__NS_URI = eINSTANCE.getEPackageImport_NsURI();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.JavaImportImpl <em>Java Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.JavaImportImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getJavaImport()
     * @generated
     */
    EClass JAVA_IMPORT = eINSTANCE.getJavaImport();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_IMPORT__PATH = eINSTANCE.getJavaImport_Path();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExtensionImportImpl <em>Extension Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExtensionImportImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getExtensionImport()
     * @generated
     */
    EClass EXTENSION_IMPORT = eINSTANCE.getExtensionImport();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTENSION_IMPORT__PATH = eINSTANCE.getExtensionImport_Path();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedResourceImpl <em>Named Resource</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedResourceImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getNamedResource()
     * @generated
     */
    EClass NAMED_RESOURCE = eINSTANCE.getNamedResource();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_RESOURCE__NAME = eINSTANCE.getNamedResource_Name();

    /**
     * The meta object literal for the '<em><b>Left Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_RESOURCE__LEFT_URI = eINSTANCE.getNamedResource_LeftUri();

    /**
     * The meta object literal for the '<em><b>Left Root</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_RESOURCE__LEFT_ROOT = eINSTANCE.getNamedResource_LeftRoot();

    /**
     * The meta object literal for the '<em><b>Right Uri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_RESOURCE__RIGHT_URI = eINSTANCE.getNamedResource_RightUri();

    /**
     * The meta object literal for the '<em><b>Right Root</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_RESOURCE__RIGHT_ROOT = eINSTANCE.getNamedResource_RightRoot();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedObjectImpl <em>Named Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.NamedObjectImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getNamedObject()
     * @generated
     */
    EClass NAMED_OBJECT = eINSTANCE.getNamedObject();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_OBJECT__NAME = eINSTANCE.getNamedObject_Name();

    /**
     * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_OBJECT__ASSIGNMENTS = eINSTANCE.getNamedObject_Assignments();

    /**
     * The meta object literal for the '<em><b>Left Mig</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_OBJECT__LEFT_MIG = eINSTANCE.getNamedObject_LeftMig();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectRefImpl <em>Object Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectRefImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getObjectRef()
     * @generated
     */
    EClass OBJECT_REF = eINSTANCE.getObjectRef();

    /**
     * The meta object literal for the '<em><b>Left Res</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_REF__LEFT_RES = eINSTANCE.getObjectRef_LeftRes();

    /**
     * The meta object literal for the '<em><b>Left Frag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_REF__LEFT_FRAG = eINSTANCE.getObjectRef_LeftFrag();

    /**
     * The meta object literal for the '<em><b>Right Res</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_REF__RIGHT_RES = eINSTANCE.getObjectRef_RightRes();

    /**
     * The meta object literal for the '<em><b>Right Frag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_REF__RIGHT_FRAG = eINSTANCE.getObjectRef_RightFrag();

    /**
     * The meta object literal for the '<em><b>Right Mig</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_REF__RIGHT_MIG = eINSTANCE.getObjectRef_RightMig();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT__FEATURE = eINSTANCE.getAssignment_Feature();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.SingleAssignmentImpl <em>Single Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.SingleAssignmentImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getSingleAssignment()
     * @generated
     */
    EClass SINGLE_ASSIGNMENT = eINSTANCE.getSingleAssignment();

    /**
     * The meta object literal for the '<em><b>Left Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SINGLE_ASSIGNMENT__LEFT_VALUE = eINSTANCE.getSingleAssignment_LeftValue();

    /**
     * The meta object literal for the '<em><b>Right Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SINGLE_ASSIGNMENT__RIGHT_VALUE = eINSTANCE.getSingleAssignment_RightValue();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ListAssignmentImpl <em>List Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ListAssignmentImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getListAssignment()
     * @generated
     */
    EClass LIST_ASSIGNMENT = eINSTANCE.getListAssignment();

    /**
     * The meta object literal for the '<em><b>Left Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_ASSIGNMENT__LEFT_VALUES = eINSTANCE.getListAssignment_LeftValues();

    /**
     * The meta object literal for the '<em><b>Right Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_ASSIGNMENT__RIGHT_VALUES = eINSTANCE.getListAssignment_RightValues();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl <em>Assignment Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.AssignmentValueImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getAssignmentValue()
     * @generated
     */
    EClass ASSIGNMENT_VALUE = eINSTANCE.getAssignmentValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_VALUE__VALUE = eINSTANCE.getAssignmentValue_Value();

    /**
     * The meta object literal for the '<em><b>Ref Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_VALUE__REF_OBJECT = eINSTANCE.getAssignmentValue_RefObject();

    /**
     * The meta object literal for the '<em><b>Ref Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_VALUE__REF_FEATURE = eINSTANCE.getAssignmentValue_RefFeature();

    /**
     * The meta object literal for the '<em><b>Ref Index</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_VALUE__REF_INDEX = eINSTANCE.getAssignmentValue_RefIndex();

    /**
     * The meta object literal for the '<em><b>New Object</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_VALUE__NEW_OBJECT = eINSTANCE.getAssignmentValue_NewObject();

    /**
     * The meta object literal for the '<em><b>Import</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_VALUE__IMPORT = eINSTANCE.getAssignmentValue_Import();

    /**
     * The meta object literal for the '<em><b>Imp Frag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_VALUE__IMP_FRAG = eINSTANCE.getAssignmentValue_ImpFrag();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_VALUE__INDEX = eINSTANCE.getAssignmentValue_Index();

    /**
     * The meta object literal for the '<em><b>Keyword</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_VALUE__KEYWORD = eINSTANCE.getAssignmentValue_Keyword();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.CreatedObjectImpl <em>Created Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.CreatedObjectImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getCreatedObject()
     * @generated
     */
    EClass CREATED_OBJECT = eINSTANCE.getCreatedObject();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectNewImpl <em>Object New</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectNewImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getObjectNew()
     * @generated
     */
    EClass OBJECT_NEW = eINSTANCE.getObjectNew();

    /**
     * The meta object literal for the '<em><b>Import</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_NEW__IMPORT = eINSTANCE.getObjectNew_Import();

    /**
     * The meta object literal for the '<em><b>Imp Frag</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_NEW__IMP_FRAG = eINSTANCE.getObjectNew_ImpFrag();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectCopyImpl <em>Object Copy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ObjectCopyImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getObjectCopy()
     * @generated
     */
    EClass OBJECT_COPY = eINSTANCE.getObjectCopy();

    /**
     * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OBJECT_COPY__RESOURCE = eINSTANCE.getObjectCopy_Resource();

    /**
     * The meta object literal for the '<em><b>Fragment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OBJECT_COPY__FRAGMENT = eINSTANCE.getObjectCopy_Fragment();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.MigrationImpl <em>Migration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.MigrationImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getMigration()
     * @generated
     */
    EClass MIGRATION = eINSTANCE.getMigration();

    /**
     * The meta object literal for the '<em><b>First</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MIGRATION__FIRST = eINSTANCE.getMigration_First();

    /**
     * The meta object literal for the '<em><b>As Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MIGRATION__AS_OP = eINSTANCE.getMigration_AsOp();

    /**
     * The meta object literal for the '<em><b>Each Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MIGRATION__EACH_OP = eINSTANCE.getMigration_EachOp();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExecutableImpl <em>Executable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExecutableImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getExecutable()
     * @generated
     */
    EClass EXECUTABLE = eINSTANCE.getExecutable();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.JavaExecutableImpl <em>Java Executable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.JavaExecutableImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getJavaExecutable()
     * @generated
     */
    EClass JAVA_EXECUTABLE = eINSTANCE.getJavaExecutable();

    /**
     * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_EXECUTABLE__METHOD = eINSTANCE.getJavaExecutable_Method();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExpressionExecutableImpl <em>Expression Executable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.ExpressionExecutableImpl
     * @see org.eclipse.xtext.parser.epatch.epatchTestLanguage.impl.EpatchTestLanguagePackageImpl#getExpressionExecutable()
     * @generated
     */
    EClass EXPRESSION_EXECUTABLE = eINSTANCE.getExpressionExecutable();

    /**
     * The meta object literal for the '<em><b>Exprstr</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_EXECUTABLE__EXPRSTR = eINSTANCE.getExpressionExecutable_Exprstr();

  }

} //EpatchTestLanguagePackage
