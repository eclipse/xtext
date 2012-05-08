/**
 */
package org.eclipse.xtext.purexbase.pureXbase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.purexbase.pureXbase.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PureXbaseFactoryImpl extends EFactoryImpl implements PureXbaseFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PureXbaseFactory init()
  {
    try
    {
      PureXbaseFactory thePureXbaseFactory = (PureXbaseFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/purexbase/PureXbase"); 
      if (thePureXbaseFactory != null)
      {
        return thePureXbaseFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PureXbaseFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PureXbaseFactoryImpl()
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
      case PureXbasePackage.MODEL: return createModel();
      case PureXbasePackage.IMPORT: return createImport();
      case PureXbasePackage.SPECIAL_BLOCK_EXPRESSION: return createSpecialBlockExpression();
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
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecialBlockExpression createSpecialBlockExpression()
  {
    SpecialBlockExpressionImpl specialBlockExpression = new SpecialBlockExpressionImpl();
    return specialBlockExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PureXbasePackage getPureXbasePackage()
  {
    return (PureXbasePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PureXbasePackage getPackage()
  {
    return PureXbasePackage.eINSTANCE;
  }

} //PureXbaseFactoryImpl
