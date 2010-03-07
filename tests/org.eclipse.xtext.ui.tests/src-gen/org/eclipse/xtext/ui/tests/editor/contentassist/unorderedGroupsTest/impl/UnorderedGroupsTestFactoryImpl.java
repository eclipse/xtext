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
      case UnorderedGroupsTestPackage.BUG304681_MODEL: return createBug304681Model();
      case UnorderedGroupsTestPackage.BUG304681_FEATURE: return createBug304681Feature();
      case UnorderedGroupsTestPackage.BUG304681_ATTRIBUTE: return createBug304681Attribute();
      case UnorderedGroupsTestPackage.BUG304681_REFERENCE: return createBug304681Reference();
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
  public Bug304681Model createBug304681Model()
  {
    Bug304681ModelImpl bug304681Model = new Bug304681ModelImpl();
    return bug304681Model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug304681Feature createBug304681Feature()
  {
    Bug304681FeatureImpl bug304681Feature = new Bug304681FeatureImpl();
    return bug304681Feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug304681Attribute createBug304681Attribute()
  {
    Bug304681AttributeImpl bug304681Attribute = new Bug304681AttributeImpl();
    return bug304681Attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug304681Reference createBug304681Reference()
  {
    Bug304681ReferenceImpl bug304681Reference = new Bug304681ReferenceImpl();
    return bug304681Reference;
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
