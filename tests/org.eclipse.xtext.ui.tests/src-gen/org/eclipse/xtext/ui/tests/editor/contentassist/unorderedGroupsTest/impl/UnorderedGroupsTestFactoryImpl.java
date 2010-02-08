/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.editor.contentassist.unorderedGroupsTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UnorderedGroupsTestFactoryImpl extends EFactoryImpl implements UnorderedGroupsTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UnorderedGroupsTestFactory init()
  {
    try
    {
      UnorderedGroupsTestFactory theUnorderedGroupsTestFactory = (UnorderedGroupsTestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/ui/tests/2010/UnorderedGroupsTest"); 
      if (theUnorderedGroupsTestFactory != null)
      {
        return theUnorderedGroupsTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UnorderedGroupsTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupsTestFactoryImpl()
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
      case UnorderedGroupsTestPackage.MODEL: return createModel();
      case UnorderedGroupsTestPackage.SIMPLE_MODEL: return createSimpleModel();
      case UnorderedGroupsTestPackage.MANDATORY_MODEL: return createMandatoryModel();
      case UnorderedGroupsTestPackage.LOOPED_MODEL: return createLoopedModel();
      case UnorderedGroupsTestPackage.GROUP_LOOPED_MODEL: return createGroupLoopedModel();
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
  public SimpleModel createSimpleModel()
  {
    SimpleModelImpl simpleModel = new SimpleModelImpl();
    return simpleModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MandatoryModel createMandatoryModel()
  {
    MandatoryModelImpl mandatoryModel = new MandatoryModelImpl();
    return mandatoryModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LoopedModel createLoopedModel()
  {
    LoopedModelImpl loopedModel = new LoopedModelImpl();
    return loopedModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GroupLoopedModel createGroupLoopedModel()
  {
    GroupLoopedModelImpl groupLoopedModel = new GroupLoopedModelImpl();
    return groupLoopedModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedGroupsTestPackage getUnorderedGroupsTestPackage()
  {
    return (UnorderedGroupsTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UnorderedGroupsTestPackage getPackage()
  {
    return UnorderedGroupsTestPackage.eINSTANCE;
  }

} //UnorderedGroupsTestFactoryImpl
