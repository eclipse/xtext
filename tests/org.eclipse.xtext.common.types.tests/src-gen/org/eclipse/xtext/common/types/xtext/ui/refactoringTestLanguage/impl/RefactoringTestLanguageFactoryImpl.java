/**
 */
package org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.common.types.xtext.ui.refactoringTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RefactoringTestLanguageFactoryImpl extends EFactoryImpl implements RefactoringTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RefactoringTestLanguageFactory init()
  {
    try
    {
      RefactoringTestLanguageFactory theRefactoringTestLanguageFactory = (RefactoringTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(RefactoringTestLanguagePackage.eNS_URI);
      if (theRefactoringTestLanguageFactory != null)
      {
        return theRefactoringTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RefactoringTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefactoringTestLanguageFactoryImpl()
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
      case RefactoringTestLanguagePackage.MODEL: return createModel();
      case RefactoringTestLanguagePackage.REFERENCE_HOLDER: return createReferenceHolder();
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
  public ReferenceHolder createReferenceHolder()
  {
    ReferenceHolderImpl referenceHolder = new ReferenceHolderImpl();
    return referenceHolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RefactoringTestLanguagePackage getRefactoringTestLanguagePackage()
  {
    return (RefactoringTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static RefactoringTestLanguagePackage getPackage()
  {
    return RefactoringTestLanguagePackage.eINSTANCE;
  }

} //RefactoringTestLanguageFactoryImpl
