/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend.treeXtendTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xtend.treeXtendTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TreeXtendTestLanguageFactoryImpl extends EFactoryImpl implements TreeXtendTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TreeXtendTestLanguageFactory init()
  {
    try
    {
      TreeXtendTestLanguageFactory theTreeXtendTestLanguageFactory = (TreeXtendTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2008/xtext/xtendtests/TreeTestLanguage"); 
      if (theTreeXtendTestLanguageFactory != null)
      {
        return theTreeXtendTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TreeXtendTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TreeXtendTestLanguageFactoryImpl()
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
      case TreeXtendTestLanguagePackage.MODEL: return createModel();
      case TreeXtendTestLanguagePackage.NODE: return createNode();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Node createNode()
  {
    NodeImpl node = new NodeImpl();
    return node;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TreeXtendTestLanguagePackage getTreeXtendTestLanguagePackage()
  {
    return (TreeXtendTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TreeXtendTestLanguagePackage getPackage()
  {
    return TreeXtendTestLanguagePackage.eINSTANCE;
  }

} //TreeXtendTestLanguageFactoryImpl
