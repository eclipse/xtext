/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.CrossReferenceProposalTestFactory;
import org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.CrossReferenceProposalTestPackage;
import org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Model;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CrossReferenceProposalTestFactoryImpl extends EFactoryImpl implements CrossReferenceProposalTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static CrossReferenceProposalTestFactory init()
  {
    try
    {
      CrossReferenceProposalTestFactory theCrossReferenceProposalTestFactory = (CrossReferenceProposalTestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/ui/common/tests/2009/crossReferenceProposalTest"); 
      if (theCrossReferenceProposalTestFactory != null)
      {
        return theCrossReferenceProposalTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new CrossReferenceProposalTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrossReferenceProposalTestFactoryImpl()
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
      case CrossReferenceProposalTestPackage.MODEL: return createModel();
      case CrossReferenceProposalTestPackage.CLASS: return createClass();
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
  public org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.Class createClass()
  {
    ClassImpl class_ = new ClassImpl();
    return class_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CrossReferenceProposalTestPackage getCrossReferenceProposalTestPackage()
  {
    return (CrossReferenceProposalTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static CrossReferenceProposalTestPackage getPackage()
  {
    return CrossReferenceProposalTestPackage.eINSTANCE;
  }

} //CrossReferenceProposalTestFactoryImpl
