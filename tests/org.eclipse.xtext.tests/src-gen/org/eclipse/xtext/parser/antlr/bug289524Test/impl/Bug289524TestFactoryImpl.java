/**
 */
package org.eclipse.xtext.parser.antlr.bug289524Test.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.antlr.bug289524Test.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug289524TestFactoryImpl extends EFactoryImpl implements Bug289524TestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug289524TestFactory init()
  {
    try
    {
      Bug289524TestFactory theBug289524TestFactory = (Bug289524TestFactory)EPackage.Registry.INSTANCE.getEFactory(Bug289524TestPackage.eNS_URI);
      if (theBug289524TestFactory != null)
      {
        return theBug289524TestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug289524TestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug289524TestFactoryImpl()
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
      case Bug289524TestPackage.MODEL: return createModel();
      case Bug289524TestPackage.MODEL_ELEMENT: return createModelElement();
      case Bug289524TestPackage.CONTAINED: return createContained();
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
  public Bug289524TestPackage getBug289524TestPackage()
  {
    return (Bug289524TestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug289524TestPackage getPackage()
  {
    return Bug289524TestPackage.eINSTANCE;
  }

} //Bug289524TestFactoryImpl
