/**
 */
package org.eclipse.xtext.purexbase.pureXbase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.xbase.XbasePackage;

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
 * @see org.eclipse.xtext.purexbase.pureXbase.PureXbaseFactory
 * @model kind="package"
 * @generated
 */
public interface PureXbasePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "pureXbase";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/purexbase/PureXbase";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "pureXbase";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PureXbasePackage eINSTANCE = org.eclipse.xtext.purexbase.pureXbase.impl.PureXbasePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.purexbase.pureXbase.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.purexbase.pureXbase.impl.ModelImpl
   * @see org.eclipse.xtext.purexbase.pureXbase.impl.PureXbasePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__BLOCK = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.purexbase.pureXbase.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.purexbase.pureXbase.impl.ImportImpl
   * @see org.eclipse.xtext.purexbase.pureXbase.impl.PureXbasePackageImpl#getImport()
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
   * The meta object id for the '{@link org.eclipse.xtext.purexbase.pureXbase.impl.SpecialBlockExpressionImpl <em>Special Block Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.purexbase.pureXbase.impl.SpecialBlockExpressionImpl
   * @see org.eclipse.xtext.purexbase.pureXbase.impl.PureXbasePackageImpl#getSpecialBlockExpression()
   * @generated
   */
  int SPECIAL_BLOCK_EXPRESSION = 2;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIAL_BLOCK_EXPRESSION__EXPRESSIONS = XbasePackage.XBLOCK_EXPRESSION__EXPRESSIONS;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIAL_BLOCK_EXPRESSION__IMPORTS = XbasePackage.XBLOCK_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Special Block Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIAL_BLOCK_EXPRESSION_FEATURE_COUNT = XbasePackage.XBLOCK_EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.purexbase.pureXbase.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.purexbase.pureXbase.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.purexbase.pureXbase.Model#getBlock <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Block</em>'.
   * @see org.eclipse.xtext.purexbase.pureXbase.Model#getBlock()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Block();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.purexbase.pureXbase.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see org.eclipse.xtext.purexbase.pureXbase.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.purexbase.pureXbase.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see org.eclipse.xtext.purexbase.pureXbase.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.purexbase.pureXbase.SpecialBlockExpression <em>Special Block Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Special Block Expression</em>'.
   * @see org.eclipse.xtext.purexbase.pureXbase.SpecialBlockExpression
   * @generated
   */
  EClass getSpecialBlockExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.purexbase.pureXbase.SpecialBlockExpression#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see org.eclipse.xtext.purexbase.pureXbase.SpecialBlockExpression#getImports()
   * @see #getSpecialBlockExpression()
   * @generated
   */
  EReference getSpecialBlockExpression_Imports();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PureXbaseFactory getPureXbaseFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.purexbase.pureXbase.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.purexbase.pureXbase.impl.ModelImpl
     * @see org.eclipse.xtext.purexbase.pureXbase.impl.PureXbasePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__BLOCK = eINSTANCE.getModel_Block();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.purexbase.pureXbase.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.purexbase.pureXbase.impl.ImportImpl
     * @see org.eclipse.xtext.purexbase.pureXbase.impl.PureXbasePackageImpl#getImport()
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
     * The meta object literal for the '{@link org.eclipse.xtext.purexbase.pureXbase.impl.SpecialBlockExpressionImpl <em>Special Block Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.purexbase.pureXbase.impl.SpecialBlockExpressionImpl
     * @see org.eclipse.xtext.purexbase.pureXbase.impl.PureXbasePackageImpl#getSpecialBlockExpression()
     * @generated
     */
    EClass SPECIAL_BLOCK_EXPRESSION = eINSTANCE.getSpecialBlockExpression();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIAL_BLOCK_EXPRESSION__IMPORTS = eINSTANCE.getSpecialBlockExpression_Imports();

  }

} //PureXbasePackage
