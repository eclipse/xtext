/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IndentationAwareTestLanguageFactoryImpl extends EFactoryImpl implements IndentationAwareTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IndentationAwareTestLanguageFactory init()
  {
    try
    {
      IndentationAwareTestLanguageFactory theIndentationAwareTestLanguageFactory = (IndentationAwareTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(IndentationAwareTestLanguagePackage.eNS_URI);
      if (theIndentationAwareTestLanguageFactory != null)
      {
        return theIndentationAwareTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new IndentationAwareTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndentationAwareTestLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case IndentationAwareTestLanguagePackage.TREE: return createTree();
      case IndentationAwareTestLanguagePackage.TREE_NODE: return createTreeNode();
      case IndentationAwareTestLanguagePackage.OTHER_TREE_NODE: return createOtherTreeNode();
      case IndentationAwareTestLanguagePackage.CHILD_LIST: return createChildList();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Tree createTree()
  {
    TreeImpl tree = new TreeImpl();
    return tree;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TreeNode createTreeNode()
  {
    TreeNodeImpl treeNode = new TreeNodeImpl();
    return treeNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OtherTreeNode createOtherTreeNode()
  {
    OtherTreeNodeImpl otherTreeNode = new OtherTreeNodeImpl();
    return otherTreeNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ChildList createChildList()
  {
    ChildListImpl childList = new ChildListImpl();
    return childList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IndentationAwareTestLanguagePackage getIndentationAwareTestLanguagePackage()
  {
    return (IndentationAwareTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static IndentationAwareTestLanguagePackage getPackage()
  {
    return IndentationAwareTestLanguagePackage.eINSTANCE;
  }

} //IndentationAwareTestLanguageFactoryImpl
