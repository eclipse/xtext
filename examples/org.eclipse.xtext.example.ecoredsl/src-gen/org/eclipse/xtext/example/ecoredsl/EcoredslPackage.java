/**
 * <copyright>
 * </copyright>
 *
 * $Id: EcoredslPackage.java,v 1.1 2009/02/18 19:38:47 sefftinge Exp $
 */
package org.eclipse.xtext.example.ecoredsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

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
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ECORE_DSL__IMPORTS = 0;

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
   * The meta object id for the '{@link org.eclipse.xtext.example.ecoredsl.impl.ImportStatementDeclImpl <em>Import Statement Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.ecoredsl.impl.ImportStatementDeclImpl
   * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getImportStatementDecl()
   * @generated
   */
  int IMPORT_STATEMENT_DECL = 1;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STATEMENT_DECL__ALIAS = 0;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STATEMENT_DECL__IMPORT_URI = 1;

  /**
   * The number of structural features of the '<em>Import Statement Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_STATEMENT_DECL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.ecoredsl.impl.MapEntryImpl <em>Map Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.ecoredsl.impl.MapEntryImpl
   * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getMapEntry()
   * @generated
   */
  int MAP_ENTRY = 2;

  /**
   * The feature id for the '<em><b>Detail Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_ENTRY__DETAIL_KEY = EcorePackage.EOBJECT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Detail Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_ENTRY__DETAIL_VALUE = EcorePackage.EOBJECT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Map Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_ENTRY_FEATURE_COUNT = EcorePackage.EOBJECT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.example.ecoredsl.impl.MultiplicityExprImpl <em>Multiplicity Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.example.ecoredsl.impl.MultiplicityExprImpl
   * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getMultiplicityExpr()
   * @generated
   */
  int MULTIPLICITY_EXPR = 3;

  /**
   * The number of structural features of the '<em>Multiplicity Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_EXPR_FEATURE_COUNT = 0;


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
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.example.ecoredsl.EcoreDsl#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.EcoreDsl#getImports()
   * @see #getEcoreDsl()
   * @generated
   */
  EReference getEcoreDsl_Imports();

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
   * Returns the meta object for class '{@link org.eclipse.xtext.example.ecoredsl.ImportStatementDecl <em>Import Statement Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import Statement Decl</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.ImportStatementDecl
   * @generated
   */
  EClass getImportStatementDecl();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.ecoredsl.ImportStatementDecl#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Alias</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.ImportStatementDecl#getAlias()
   * @see #getImportStatementDecl()
   * @generated
   */
  EAttribute getImportStatementDecl_Alias();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.ecoredsl.ImportStatementDecl#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.ImportStatementDecl#getImportURI()
   * @see #getImportStatementDecl()
   * @generated
   */
  EAttribute getImportStatementDecl_ImportURI();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.ecoredsl.MapEntry <em>Map Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Map Entry</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.MapEntry
   * @generated
   */
  EClass getMapEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.ecoredsl.MapEntry#getDetailKey <em>Detail Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Detail Key</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.MapEntry#getDetailKey()
   * @see #getMapEntry()
   * @generated
   */
  EAttribute getMapEntry_DetailKey();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.example.ecoredsl.MapEntry#getDetailValue <em>Detail Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Detail Value</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.MapEntry#getDetailValue()
   * @see #getMapEntry()
   * @generated
   */
  EAttribute getMapEntry_DetailValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.example.ecoredsl.MultiplicityExpr <em>Multiplicity Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity Expr</em>'.
   * @see org.eclipse.xtext.example.ecoredsl.MultiplicityExpr
   * @generated
   */
  EClass getMultiplicityExpr();

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
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ECORE_DSL__IMPORTS = eINSTANCE.getEcoreDsl_Imports();

    /**
     * The meta object literal for the '<em><b>Package</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ECORE_DSL__PACKAGE = eINSTANCE.getEcoreDsl_Package();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.ecoredsl.impl.ImportStatementDeclImpl <em>Import Statement Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.ecoredsl.impl.ImportStatementDeclImpl
     * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getImportStatementDecl()
     * @generated
     */
    EClass IMPORT_STATEMENT_DECL = eINSTANCE.getImportStatementDecl();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_STATEMENT_DECL__ALIAS = eINSTANCE.getImportStatementDecl_Alias();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT_STATEMENT_DECL__IMPORT_URI = eINSTANCE.getImportStatementDecl_ImportURI();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.ecoredsl.impl.MapEntryImpl <em>Map Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.ecoredsl.impl.MapEntryImpl
     * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getMapEntry()
     * @generated
     */
    EClass MAP_ENTRY = eINSTANCE.getMapEntry();

    /**
     * The meta object literal for the '<em><b>Detail Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAP_ENTRY__DETAIL_KEY = eINSTANCE.getMapEntry_DetailKey();

    /**
     * The meta object literal for the '<em><b>Detail Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MAP_ENTRY__DETAIL_VALUE = eINSTANCE.getMapEntry_DetailValue();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.example.ecoredsl.impl.MultiplicityExprImpl <em>Multiplicity Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.example.ecoredsl.impl.MultiplicityExprImpl
     * @see org.eclipse.xtext.example.ecoredsl.impl.EcoredslPackageImpl#getMultiplicityExpr()
     * @generated
     */
    EClass MULTIPLICITY_EXPR = eINSTANCE.getMultiplicityExpr();

  }

} //EcoredslPackage
