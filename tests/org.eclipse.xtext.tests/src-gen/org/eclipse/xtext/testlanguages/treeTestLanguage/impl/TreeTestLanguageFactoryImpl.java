/**
 */
package org.eclipse.xtext.testlanguages.treeTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.testlanguages.treeTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TreeTestLanguageFactoryImpl extends EFactoryImpl implements TreeTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TreeTestLanguageFactory init()
  {
    try
    {
      TreeTestLanguageFactory theTreeTestLanguageFactory = (TreeTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(TreeTestLanguagePackage.eNS_URI);
      if (theTreeTestLanguageFactory != null)
      {
        return theTreeTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TreeTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TreeTestLanguageFactoryImpl()
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
      case TreeTestLanguagePackage.MODEL: return createModel();
      case TreeTestLanguagePackage.NODE: return createNode();
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
  public TreeTestLanguagePackage getTreeTestLanguagePackage()
  {
    return (TreeTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TreeTestLanguagePackage getPackage()
  {
    return TreeTestLanguagePackage.eINSTANCE;
  }

} //TreeTestLanguageFactoryImpl
