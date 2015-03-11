/**
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
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
