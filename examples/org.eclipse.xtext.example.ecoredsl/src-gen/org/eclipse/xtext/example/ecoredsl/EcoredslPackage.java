/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.ecoredsl;

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
 * @see org.eclipse.xtext.example.ecoredsl.EcoredslFactory
 * @model kind="package"
 * @generated
 */
public interface EcoredslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "ecoredsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://example.xtext.org/EcoreDsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "ecoredsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EcoredslPackage eINSTANCE = org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.ecoredsl.impl.EcoreDslImpl <em>Ecore Dsl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.ecoredsl.impl.EcoreDslImpl
   * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getEcoreDsl()
   * @generated
   */
  int ECORE_DSL = 0;

  /**
   * The feature id for the '<em><b>Metamodel Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECORE_DSL__METAMODEL_DECLARATIONS = 0;

  /**
   * The feature id for the '<em><b>Package</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECORE_DSL__PACKAGE = 1;

  /**
   * The number of structural features of the '<em>Ecore Dsl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECORE_DSL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.ecoredsl.impl.ReferencedMetamodelImpl <em>Referenced Metamodel</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.ecoredsl.impl.ReferencedMetamodelImpl
   * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getReferencedMetamodel()
   * @generated
   */
  int REFERENCED_METAMODEL = 1;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_METAMODEL__ALIAS = 0;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_METAMODEL__EPACKAGE = 1;

  /**
   * The number of structural features of the '<em>Referenced Metamodel</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_METAMODEL_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.ecoredsl.EcoreDsl <em>Ecore Dsl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ecore Dsl</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.EcoreDsl
   * @generated
   */
  EClass getEcoreDsl();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.ecoredsl.EcoreDsl#getMetamodelDeclarations <em>Metamodel Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Metamodel Declarations</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.EcoreDsl#getMetamodelDeclarations()
   * @see #getEcoreDsl()
   * @generated
   */
  EReference getEcoreDsl_MetamodelDeclarations();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.example.ecoredsl.EcoreDsl#getPackage <em>Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Package</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.EcoreDsl#getPackage()
   * @see #getEcoreDsl()
   * @generated
   */
  EReference getEcoreDsl_Package();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.ecoredsl.ReferencedMetamodel <em>Referenced Metamodel</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Referenced Metamodel</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.ReferencedMetamodel
   * @generated
   */
  EClass getReferencedMetamodel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.ecoredsl.ReferencedMetamodel#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alias</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.ReferencedMetamodel#getAlias()
   * @see #getReferencedMetamodel()
   * @generated
   */
  EAttribute getReferencedMetamodel_Alias();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.example.ecoredsl.ReferencedMetamodel#getEPackage <em>EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EPackage</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.ReferencedMetamodel#getEPackage()
   * @see #getReferencedMetamodel()
   * @generated
   */
  EReference getReferencedMetamodel_EPackage();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EcoredslFactory getEcoredslFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.example.ecoredsl.impl.EcoreDslImpl <em>Ecore Dsl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.ecoredsl.impl.EcoreDslImpl
     * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getEcoreDsl()
     * @generated
     */
    EClass ECORE_DSL = eINSTANCE.getEcoreDsl();

    /**
     * The meta object literal for the '<em><b>Metamodel Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ECORE_DSL__METAMODEL_DECLARATIONS = eINSTANCE.getEcoreDsl_MetamodelDeclarations();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ECORE_DSL__PACKAGE = eINSTANCE.getEcoreDsl_Package();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.ecoredsl.impl.ReferencedMetamodelImpl <em>Referenced Metamodel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.ecoredsl.impl.ReferencedMetamodelImpl
     * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getReferencedMetamodel()
     * @generated
     */
    EClass REFERENCED_METAMODEL = eINSTANCE.getReferencedMetamodel();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCED_METAMODEL__ALIAS = eINSTANCE.getReferencedMetamodel_Alias();

    /**
     * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCED_METAMODEL__EPACKAGE = eINSTANCE.getReferencedMetamodel_EPackage();

  }

} //EcoredslPackage
