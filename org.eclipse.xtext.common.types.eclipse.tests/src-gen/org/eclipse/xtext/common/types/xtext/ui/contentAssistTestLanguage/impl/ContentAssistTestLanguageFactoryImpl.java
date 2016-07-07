/**
 */
package org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContentAssistTestLanguageFactoryImpl extends EFactoryImpl implements ContentAssistTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ContentAssistTestLanguageFactory init()
  {
    try
    {
      ContentAssistTestLanguageFactory theContentAssistTestLanguageFactory = (ContentAssistTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(ContentAssistTestLanguagePackage.eNS_URI);
      if (theContentAssistTestLanguageFactory != null)
      {
        return theContentAssistTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ContentAssistTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContentAssistTestLanguageFactoryImpl()
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
      case ContentAssistTestLanguagePackage.MODEL: return createModel();
      case ContentAssistTestLanguagePackage.REFERENCE_HOLDER: return createReferenceHolder();
      case ContentAssistTestLanguagePackage.GENERATE_DIRECTIVE: return createGenerateDirective();
      case ContentAssistTestLanguagePackage.IMPORT: return createImport();
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
  public GenerateDirective createGenerateDirective()
  {
    GenerateDirectiveImpl generateDirective = new GenerateDirectiveImpl();
    return generateDirective;
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
  public ContentAssistTestLanguagePackage getContentAssistTestLanguagePackage()
  {
    return (ContentAssistTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ContentAssistTestLanguagePackage getPackage()
  {
    return ContentAssistTestLanguagePackage.eINSTANCE;
  }

} //ContentAssistTestLanguageFactoryImpl
