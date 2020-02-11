/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ide.tests.testlanguage.indentationAwareUiTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IndentationAwareUiTestLanguageFactoryImpl extends EFactoryImpl implements IndentationAwareUiTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static IndentationAwareUiTestLanguageFactory init()
  {
    try
    {
      IndentationAwareUiTestLanguageFactory theIndentationAwareUiTestLanguageFactory = (IndentationAwareUiTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(IndentationAwareUiTestLanguagePackage.eNS_URI);
      if (theIndentationAwareUiTestLanguageFactory != null)
      {
        return theIndentationAwareUiTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new IndentationAwareUiTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndentationAwareUiTestLanguageFactoryImpl()
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
      case IndentationAwareUiTestLanguagePackage.TREE: return createTree();
      case IndentationAwareUiTestLanguagePackage.TREE_NODE: return createTreeNode();
      case IndentationAwareUiTestLanguagePackage.OTHER_TREE_NODE: return createOtherTreeNode();
      case IndentationAwareUiTestLanguagePackage.CHILD_LIST: return createChildList();
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
  public IndentationAwareUiTestLanguagePackage getIndentationAwareUiTestLanguagePackage()
  {
    return (IndentationAwareUiTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static IndentationAwareUiTestLanguagePackage getPackage()
  {
    return IndentationAwareUiTestLanguagePackage.eINSTANCE;
  }

} //IndentationAwareUiTestLanguageFactoryImpl
