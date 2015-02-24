/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug381381TestLanguageFactoryImpl extends EFactoryImpl implements Bug381381TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug381381TestLanguageFactory init()
  {
    try
    {
      Bug381381TestLanguageFactory theBug381381TestLanguageFactory = (Bug381381TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(Bug381381TestLanguagePackage.eNS_URI);
      if (theBug381381TestLanguageFactory != null)
      {
        return theBug381381TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug381381TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug381381TestLanguageFactoryImpl()
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
      case Bug381381TestLanguagePackage.MODEL: return createModel();
      case Bug381381TestLanguagePackage.COPY_FIELD_NAME_TO_VARIABLE_STMT: return createCopyFieldNameToVariableStmt();
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
  public CopyFieldNameToVariableStmt createCopyFieldNameToVariableStmt()
  {
    CopyFieldNameToVariableStmtImpl copyFieldNameToVariableStmt = new CopyFieldNameToVariableStmtImpl();
    return copyFieldNameToVariableStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug381381TestLanguagePackage getBug381381TestLanguagePackage()
  {
    return (Bug381381TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug381381TestLanguagePackage getPackage()
  {
    return Bug381381TestLanguagePackage.eINSTANCE;
  }

} //Bug381381TestLanguageFactoryImpl
