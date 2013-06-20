/**
 */
package org.eclipse.xtext.example.tutorial.tutorial;

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
 * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialFactory
 * @model kind="package"
 * @generated
 */
public interface TutorialPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tutorial";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/example/tutorial/Tutorial";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "tutorial";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TutorialPackage eINSTANCE = org.eclipse.xtext.example.tutorial.tutorial.impl.TutorialPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.tutorial.tutorial.impl.DomainModelFileImpl <em>Domain Model File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.tutorial.tutorial.impl.DomainModelFileImpl
   * @see org.eclipse.xtext.example.tutorial.tutorial.impl.TutorialPackageImpl#getDomainModelFile()
   * @generated
   */
  int DOMAIN_MODEL_FILE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_MODEL_FILE__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_MODEL_FILE__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Entities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_MODEL_FILE__ENTITIES = 2;

  /**
   * The number of structural features of the '<em>Domain Model File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_MODEL_FILE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.tutorial.tutorial.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.tutorial.tutorial.impl.ImportImpl
   * @see org.eclipse.xtext.example.tutorial.tutorial.impl.TutorialPackageImpl#getImport()
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
   * The meta object id for the '{@link org.eclipse.xtext.example.tutorial.tutorial.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.tutorial.tutorial.impl.EntityImpl
   * @see org.eclipse.xtext.example.tutorial.tutorial.impl.TutorialPackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = 0;

  /**
   * The feature id for the '<em><b>Super Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__SUPER_TYPE = 1;

  /**
   * The feature id for the '<em><b>Features</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__FEATURES = 2;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.tutorial.tutorial.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.tutorial.tutorial.impl.PropertyImpl
   * @see org.eclipse.xtext.example.tutorial.tutorial.impl.TutorialPackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__TYPE = 1;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile <em>Domain Model File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Model File</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile
   * @generated
   */
  EClass getDomainModelFile();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getName()
   * @see #getDomainModelFile()
   * @generated
   */
  EAttribute getDomainModelFile_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getImports()
   * @see #getDomainModelFile()
   * @generated
   */
  EReference getDomainModelFile_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getEntities <em>Entities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entities</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.DomainModelFile#getEntities()
   * @see #getDomainModelFile()
   * @generated
   */
  EReference getDomainModelFile_Entities();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.tutorial.tutorial.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.tutorial.tutorial.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.tutorial.tutorial.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.tutorial.tutorial.Entity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.Entity#getName()
   * @see #getEntity()
   * @generated
   */
  EAttribute getEntity_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.example.tutorial.tutorial.Entity#getSuperType <em>Super Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Super Type</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.Entity#getSuperType()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_SuperType();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.tutorial.tutorial.Entity#getFeatures <em>Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Features</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.Entity#getFeatures()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Features();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.tutorial.tutorial.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.tutorial.tutorial.Property#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.Property#getName()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.example.tutorial.tutorial.Property#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.xtext.example.tutorial.tutorial.Property#getType()
   * @see #getProperty()
   * @generated
   */
  EReference getProperty_Type();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TutorialFactory getTutorialFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.example.tutorial.tutorial.impl.DomainModelFileImpl <em>Domain Model File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.tutorial.tutorial.impl.DomainModelFileImpl
     * @see org.eclipse.xtext.example.tutorial.tutorial.impl.TutorialPackageImpl#getDomainModelFile()
     * @generated
     */
    EClass DOMAIN_MODEL_FILE = eINSTANCE.getDomainModelFile();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOMAIN_MODEL_FILE__NAME = eINSTANCE.getDomainModelFile_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_MODEL_FILE__IMPORTS = eINSTANCE.getDomainModelFile_Imports();

    /**
     * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_MODEL_FILE__ENTITIES = eINSTANCE.getDomainModelFile_Entities();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.tutorial.tutorial.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.tutorial.tutorial.impl.ImportImpl
     * @see org.eclipse.xtext.example.tutorial.tutorial.impl.TutorialPackageImpl#getImport()
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
     * The meta object literal for the '{@link org.eclipse.xtext.example.tutorial.tutorial.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.tutorial.tutorial.impl.EntityImpl
     * @see org.eclipse.xtext.example.tutorial.tutorial.impl.TutorialPackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

    /**
     * The meta object literal for the '<em><b>Super Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__SUPER_TYPE = eINSTANCE.getEntity_SuperType();

    /**
     * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__FEATURES = eINSTANCE.getEntity_Features();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.tutorial.tutorial.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.tutorial.tutorial.impl.PropertyImpl
     * @see org.eclipse.xtext.example.tutorial.tutorial.impl.TutorialPackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

  }

} //TutorialPackage
