/**
 */
package org.eclipse.xtext.parser.antlr.bug289524ExTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.antlr.bug289524ExTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug289524ExTestFactoryImpl extends EFactoryImpl implements Bug289524ExTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug289524ExTestFactory init()
  {
    try
    {
      Bug289524ExTestFactory theBug289524ExTestFactory = (Bug289524ExTestFactory)EPackage.Registry.INSTANCE.getEFactory(Bug289524ExTestPackage.eNS_URI);
      if (theBug289524ExTestFactory != null)
      {
        return theBug289524ExTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug289524ExTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug289524ExTestFactoryImpl()
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
      case Bug289524ExTestPackage.MODEL: return createModel();
      case Bug289524ExTestPackage.MODEL_ELEMENT: return createModelElement();
      case Bug289524ExTestPackage.CONTAINED: return createContained();
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
  public ModelElement createModelElement()
  {
    ModelElementImpl modelElement = new ModelElementImpl();
    return modelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contained createContained()
  {
    ContainedImpl contained = new ContainedImpl();
    return contained;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug289524ExTestPackage getBug289524ExTestPackage()
  {
    return (Bug289524ExTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug289524ExTestPackage getPackage()
  {
    return Bug289524ExTestPackage.eINSTANCE;
  }

} //Bug289524ExTestFactoryImpl
