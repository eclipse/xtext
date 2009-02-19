/**
 * <copyright>
 * </copyright>
 *
 * $Id: FormattertestlanguagePackage.java,v 1.4 2009/02/19 16:27:05 sefftinge Exp $
 */
package org.eclipse.xtext.parsetree.formatter.formattertestlanguage;

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
 * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.FormattertestlanguageFactory
 * @model kind="package"
 * @generated
 */
public interface FormattertestlanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "formattertestlanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://simple/formattertestlanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "formattertestlanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FormattertestlanguagePackage eINSTANCE = org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.RootImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getRoot()
   * @generated
   */
  int ROOT = 0;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__ITEMS = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.LineImpl <em>Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.LineImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getLine()
   * @generated
   */
  int LINE = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE__NAME = 1;

  /**
   * The number of structural features of the '<em>Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl <em>Test Linewrap</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestLinewrap()
   * @generated
   */
  int TEST_LINEWRAP = 2;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LINEWRAP__ITEMS = ROOT__ITEMS;

  /**
   * The number of structural features of the '<em>Test Linewrap</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_LINEWRAP_FEATURE_COUNT = ROOT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl <em>Test Indentation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestIndentation()
   * @generated
   */
  int TEST_INDENTATION = 3;

  /**
   * The feature id for the '<em><b>Items</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_INDENTATION__ITEMS = ROOT__ITEMS;

  /**
   * The feature id for the '<em><b>Sub</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_INDENTATION__SUB = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Test Indentation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_INDENTATION_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root#getItems <em>Items</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Items</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Root#getItems()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_Items();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line <em>Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Line</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line
   * @generated
   */
  EClass getLine();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Type</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line#getType()
   * @see #getLine()
   * @generated
   */
  EAttribute getLine_Type();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.Line#getName()
   * @see #getLine()
   * @generated
   */
  EAttribute getLine_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap <em>Test Linewrap</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Linewrap</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestLinewrap
   * @generated
   */
  EClass getTestLinewrap();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation <em>Test Indentation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Indentation</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation
   * @generated
   */
  EClass getTestIndentation();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation#getSub <em>Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sub</em>'.
   * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.TestIndentation#getSub()
   * @see #getTestIndentation()
   * @generated
   */
  EReference getTestIndentation_Sub();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FormattertestlanguageFactory getFormattertestlanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.RootImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__ITEMS = eINSTANCE.getRoot_Items();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.LineImpl <em>Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.LineImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getLine()
     * @generated
     */
    EClass LINE = eINSTANCE.getLine();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINE__TYPE = eINSTANCE.getLine_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINE__NAME = eINSTANCE.getLine_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl <em>Test Linewrap</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestLinewrapImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestLinewrap()
     * @generated
     */
    EClass TEST_LINEWRAP = eINSTANCE.getTestLinewrap();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl <em>Test Indentation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.TestIndentationImpl
     * @see org.eclipse.xtext.parsetree.formatter.formattertestlanguage.impl.FormattertestlanguagePackageImpl#getTestIndentation()
     * @generated
     */
    EClass TEST_INDENTATION = eINSTANCE.getTestIndentation();

    /**
     * The meta object literal for the '<em><b>Sub</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_INDENTATION__SUB = eINSTANCE.getTestIndentation_Sub();

  }

} //FormattertestlanguagePackage
