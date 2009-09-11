/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend.treeXtendTestLanguage;

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
 * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.TreeXtendTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface TreeXtendTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "treeXtendTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/xtext/xtendtests/TreeTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "treeXtendTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TreeXtendTestLanguagePackage eINSTANCE = org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.TreeXtendTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.TreeXtendTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CHILDREN = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.NodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.NodeImpl
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.TreeXtendTestLanguagePackageImpl#getNode()
   * @generated
   */
  int NODE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__NAME = 0;

  /**
   * The feature id for the '<em><b>Attrib</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__ATTRIB = 1;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__CHILDREN = 2;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.Model#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.Model#getChildren()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Children();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.Node
   * @generated
   */
  EClass getNode();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.Node#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.Node#getName()
   * @see #getNode()
   * @generated
   */
  EAttribute getNode_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.Node#getAttrib <em>Attrib</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attrib</em>'.
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.Node#getAttrib()
   * @see #getNode()
   * @generated
   */
  EAttribute getNode_Attrib();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.Node#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.Node#getChildren()
   * @see #getNode()
   * @generated
   */
  EReference getNode_Children();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TreeXtendTestLanguageFactory getTreeXtendTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.TreeXtendTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CHILDREN = eINSTANCE.getModel_Children();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.NodeImpl
     * @see org.eclipse.xtext.xtend.treeXtendTestLanguage.impl.TreeXtendTestLanguagePackageImpl#getNode()
     * @generated
     */
    EClass NODE = eINSTANCE.getNode();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE__NAME = eINSTANCE.getNode_Name();

    /**
     * The meta object literal for the '<em><b>Attrib</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE__ATTRIB = eINSTANCE.getNode_Attrib();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE__CHILDREN = eINSTANCE.getNode_Children();

  }

} //TreeXtendTestLanguagePackage
