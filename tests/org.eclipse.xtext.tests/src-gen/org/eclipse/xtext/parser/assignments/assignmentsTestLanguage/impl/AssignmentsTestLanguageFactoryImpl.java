/**
 */
package org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssignmentsTestLanguageFactoryImpl extends EFactoryImpl implements AssignmentsTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AssignmentsTestLanguageFactory init()
  {
    try
    {
      AssignmentsTestLanguageFactory theAssignmentsTestLanguageFactory = (AssignmentsTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(AssignmentsTestLanguagePackage.eNS_URI);
      if (theAssignmentsTestLanguageFactory != null)
      {
        return theAssignmentsTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AssignmentsTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentsTestLanguageFactoryImpl()
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
      case AssignmentsTestLanguagePackage.MODEL: return createModel();
      case AssignmentsTestLanguagePackage.SINGLE_VALUE: return createSingleValue();
      case AssignmentsTestLanguagePackage.MULTI_VALUE: return createMultiValue();
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
  public SingleValue createSingleValue()
  {
    SingleValueImpl singleValue = new SingleValueImpl();
    return singleValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiValue createMultiValue()
  {
    MultiValueImpl multiValue = new MultiValueImpl();
    return multiValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentsTestLanguagePackage getAssignmentsTestLanguagePackage()
  {
    return (AssignmentsTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AssignmentsTestLanguagePackage getPackage()
  {
    return AssignmentsTestLanguagePackage.eINSTANCE;
  }

} //AssignmentsTestLanguageFactoryImpl
