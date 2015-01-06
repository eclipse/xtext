/**
 */
package org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage;

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
 * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface IndentationAwareTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "indentationAwareTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2015/tmf/xtext/indentation";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "indentationAwareTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IndentationAwareTestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.TreeImpl <em>Tree</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.TreeImpl
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguagePackageImpl#getTree()
   * @generated
   */
  int TREE = 0;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE__NODES = 0;

  /**
   * The number of structural features of the '<em>Tree</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.TreeNodeImpl <em>Tree Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.TreeNodeImpl
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguagePackageImpl#getTreeNode()
   * @generated
   */
  int TREE_NODE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE__NAME = 0;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE__CHILDREN = 1;

  /**
   * The number of structural features of the '<em>Tree Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree <em>Tree</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tree</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree
   * @generated
   */
  EClass getTree();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nodes</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree#getNodes()
   * @see #getTree()
   * @generated
   */
  EReference getTree_Nodes();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode <em>Tree Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tree Node</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode
   * @generated
   */
  EClass getTreeNode();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode#getName()
   * @see #getTreeNode()
   * @generated
   */
  EAttribute getTreeNode_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode#getChildren()
   * @see #getTreeNode()
   * @generated
   */
  EReference getTreeNode_Children();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  IndentationAwareTestLanguageFactory getIndentationAwareTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.TreeImpl <em>Tree</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.TreeImpl
     * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguagePackageImpl#getTree()
     * @generated
     */
    EClass TREE = eINSTANCE.getTree();

    /**
     * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREE__NODES = eINSTANCE.getTree_Nodes();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.TreeNodeImpl <em>Tree Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.TreeNodeImpl
     * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguagePackageImpl#getTreeNode()
     * @generated
     */
    EClass TREE_NODE = eINSTANCE.getTreeNode();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_NODE__NAME = eINSTANCE.getTreeNode_Name();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREE_NODE__CHILDREN = eINSTANCE.getTreeNode_Children();

  }

} //IndentationAwareTestLanguagePackage
