/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.parser.keywords.keywordsUiTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.parser.keywords.keywordsUiTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class KeywordsUiTestLanguageFactoryImpl extends EFactoryImpl implements KeywordsUiTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static KeywordsUiTestLanguageFactory init()
  {
    try
    {
      KeywordsUiTestLanguageFactory theKeywordsUiTestLanguageFactory = (KeywordsUiTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2009/xtext/ui/common/tests/KeywordsTestLanguage"); 
      if (theKeywordsUiTestLanguageFactory != null)
      {
        return theKeywordsUiTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new KeywordsUiTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeywordsUiTestLanguageFactoryImpl()
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
      case KeywordsUiTestLanguagePackage.MODEL: return createModel();
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
  public KeywordsUiTestLanguagePackage getKeywordsUiTestLanguagePackage()
  {
    return (KeywordsUiTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static KeywordsUiTestLanguagePackage getPackage()
  {
    return KeywordsUiTestLanguagePackage.eINSTANCE;
  }

} //KeywordsUiTestLanguageFactoryImpl
