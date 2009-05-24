/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.index.indexTestLanguage;

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
 * @see org.eclipse.xtext.index.indexTestLanguage.IndexTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface IndexTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "indexTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/indexTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "indexTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IndexTestLanguagePackage eINSTANCE = org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.FileImpl <em>File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.FileImpl
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getFile()
   * @generated
   */
  int FILE = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__IMPORTS = 0;

  /**
   * The feature id for the '<em><b>Name Spaces</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__NAME_SPACES = 1;

  /**
   * The number of structural features of the '<em>File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.ImportImpl
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getImport()
   * @generated
   */
  int IMPORT = 1;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.NamedElementImpl <em>Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.NamedElementImpl
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getNamedElement()
   * @generated
   */
  int NAMED_ELEMENT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT__NAME = 0;

  /**
   * The number of structural features of the '<em>Named Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.NamespaceImpl <em>Namespace</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.NamespaceImpl
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getNamespace()
   * @generated
   */
  int NAMESPACE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Named Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE__NAMED_ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Namespace</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.TypeImpl
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getType()
   * @generated
   */
  int TYPE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = NAMED_ELEMENT__NAME;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.EntityImpl
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = TYPE__NAME;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__PROPERTIES = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.DatatypeImpl <em>Datatype</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.DatatypeImpl
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getDatatype()
   * @generated
   */
  int DATATYPE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE__NAME = TYPE__NAME;

  /**
   * The number of structural features of the '<em>Datatype</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.PropertyImpl
   * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 7;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__NAME = 1;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.index.indexTestLanguage.File <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.File
   * @generated
   */
  EClass getFile();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.index.indexTestLanguage.File#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.File#getImports()
   * @see #getFile()
   * @generated
   */
  EReference getFile_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.index.indexTestLanguage.File#getNameSpaces <em>Name Spaces</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Name Spaces</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.File#getNameSpaces()
   * @see #getFile()
   * @generated
   */
  EReference getFile_NameSpaces();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.index.indexTestLanguage.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.index.indexTestLanguage.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.index.indexTestLanguage.Namespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Namespace</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Namespace
   * @generated
   */
  EClass getNamespace();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.index.indexTestLanguage.Namespace#getNamedElements <em>Named Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Named Elements</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Namespace#getNamedElements()
   * @see #getNamespace()
   * @generated
   */
  EReference getNamespace_NamedElements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.index.indexTestLanguage.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Element</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.NamedElement
   * @generated
   */
  EClass getNamedElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.index.indexTestLanguage.NamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.NamedElement#getName()
   * @see #getNamedElement()
   * @generated
   */
  EAttribute getNamedElement_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.index.indexTestLanguage.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.index.indexTestLanguage.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.index.indexTestLanguage.Entity#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Entity#getProperties()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Properties();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.index.indexTestLanguage.Datatype <em>Datatype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Datatype</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Datatype
   * @generated
   */
  EClass getDatatype();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.index.indexTestLanguage.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.index.indexTestLanguage.Property#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Property#getType()
   * @see #getProperty()
   * @generated
   */
  EReference getProperty_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.index.indexTestLanguage.Property#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.index.indexTestLanguage.Property#getName()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  IndexTestLanguageFactory getIndexTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.FileImpl <em>File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.FileImpl
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getFile()
     * @generated
     */
    EClass FILE = eINSTANCE.getFile();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE__IMPORTS = eINSTANCE.getFile_Imports();

    /**
     * The meta object literal for the '<em><b>Name Spaces</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE__NAME_SPACES = eINSTANCE.getFile_NameSpaces();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.ImportImpl
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.NamespaceImpl <em>Namespace</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.NamespaceImpl
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getNamespace()
     * @generated
     */
    EClass NAMESPACE = eINSTANCE.getNamespace();

    /**
     * The meta object literal for the '<em><b>Named Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMESPACE__NAMED_ELEMENTS = eINSTANCE.getNamespace_NamedElements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.NamedElementImpl
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getNamedElement()
     * @generated
     */
    EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.TypeImpl
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.EntityImpl
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__PROPERTIES = eINSTANCE.getEntity_Properties();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.DatatypeImpl <em>Datatype</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.DatatypeImpl
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getDatatype()
     * @generated
     */
    EClass DATATYPE = eINSTANCE.getDatatype();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.index.indexTestLanguage.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.PropertyImpl
     * @see org.eclipse.xtext.index.indexTestLanguage.impl.IndexTestLanguagePackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

  }

} //IndexTestLanguagePackage
