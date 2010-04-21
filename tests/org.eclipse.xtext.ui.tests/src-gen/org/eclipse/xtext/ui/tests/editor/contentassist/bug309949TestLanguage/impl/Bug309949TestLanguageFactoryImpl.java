/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Annotation;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Bug309949TestLanguageFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Bug309949TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Model;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Operation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug309949TestLanguageFactoryImpl extends EFactoryImpl implements Bug309949TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug309949TestLanguageFactory init()
  {
    try
    {
      Bug309949TestLanguageFactory theBug309949TestLanguageFactory = (Bug309949TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/ui/common/tests/2010/bug309949TestLanguage"); 
      if (theBug309949TestLanguageFactory != null)
      {
        return theBug309949TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug309949TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug309949TestLanguageFactoryImpl()
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
      case Bug309949TestLanguagePackage.MODEL: return createModel();
      case Bug309949TestLanguagePackage.ERROR: return createError();
      case Bug309949TestLanguagePackage.OPERATION: return createOperation();
      case Bug309949TestLanguagePackage.ANNOTATION: return createAnnotation();
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
  public org.eclipse.xtext.ui.tests.editor.contentassist.bug309949TestLanguage.Error createError()
  {
    ErrorImpl error = new ErrorImpl();
    return error;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Annotation createAnnotation()
  {
    AnnotationImpl annotation = new AnnotationImpl();
    return annotation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug309949TestLanguagePackage getBug309949TestLanguagePackage()
  {
    return (Bug309949TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug309949TestLanguagePackage getPackage()
  {
    return Bug309949TestLanguagePackage.eINSTANCE;
  }

} //Bug309949TestLanguageFactoryImpl
