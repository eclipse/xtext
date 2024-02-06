/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
   * The feature id for the '<em><b>More Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE__MORE_NODES = 1;

  /**
   * The number of structural features of the '<em>Tree</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_FEATURE_COUNT = 2;

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
   * The meta object id for the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.OtherTreeNodeImpl <em>Other Tree Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.OtherTreeNodeImpl
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguagePackageImpl#getOtherTreeNode()
   * @generated
   */
  int OTHER_TREE_NODE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHER_TREE_NODE__NAME = 0;

  /**
   * The feature id for the '<em><b>Child List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHER_TREE_NODE__CHILD_LIST = 1;

  /**
   * The number of structural features of the '<em>Other Tree Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OTHER_TREE_NODE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.ChildListImpl <em>Child List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.ChildListImpl
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguagePackageImpl#getChildList()
   * @generated
   */
  int CHILD_LIST = 3;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD_LIST__CHILDREN = 0;

  /**
   * The number of structural features of the '<em>Child List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD_LIST_FEATURE_COUNT = 1;


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
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree#getMoreNodes <em>More Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Nodes</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree#getMoreNodes()
   * @see #getTree()
   * @generated
   */
  EReference getTree_MoreNodes();

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
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode <em>Other Tree Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Other Tree Node</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode
   * @generated
   */
  EClass getOtherTreeNode();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode#getName()
   * @see #getOtherTreeNode()
   * @generated
   */
  EAttribute getOtherTreeNode_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode#getChildList <em>Child List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child List</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.OtherTreeNode#getChildList()
   * @see #getOtherTreeNode()
   * @generated
   */
  EReference getOtherTreeNode_ChildList();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.ChildList <em>Child List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Child List</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.ChildList
   * @generated
   */
  EClass getChildList();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.ChildList#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.ChildList#getChildren()
   * @see #getChildList()
   * @generated
   */
  EReference getChildList_Children();

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
     * The meta object literal for the '<em><b>More Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREE__MORE_NODES = eINSTANCE.getTree_MoreNodes();

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

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.OtherTreeNodeImpl <em>Other Tree Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.OtherTreeNodeImpl
     * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguagePackageImpl#getOtherTreeNode()
     * @generated
     */
    EClass OTHER_TREE_NODE = eINSTANCE.getOtherTreeNode();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OTHER_TREE_NODE__NAME = eINSTANCE.getOtherTreeNode_Name();

    /**
     * The meta object literal for the '<em><b>Child List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OTHER_TREE_NODE__CHILD_LIST = eINSTANCE.getOtherTreeNode_ChildList();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.ChildListImpl <em>Child List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.ChildListImpl
     * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguagePackageImpl#getChildList()
     * @generated
     */
    EClass CHILD_LIST = eINSTANCE.getChildList();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHILD_LIST__CHILDREN = eINSTANCE.getChildList_Children();

  }

} //IndentationAwareTestLanguagePackage
