/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XImportSectionTestLangFactoryImpl extends EFactoryImpl implements XImportSectionTestLangFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static XImportSectionTestLangFactory init()
  {
    try
    {
      XImportSectionTestLangFactory theXImportSectionTestLangFactory = (XImportSectionTestLangFactory)EPackage.Registry.INSTANCE.getEFactory(XImportSectionTestLangPackage.eNS_URI);
      if (theXImportSectionTestLangFactory != null)
      {
        return theXImportSectionTestLangFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new XImportSectionTestLangFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XImportSectionTestLangFactoryImpl()
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
      case XImportSectionTestLangPackage.IMPORT_SECTION_TEST_LANGUAGE_ROOT: return createImportSectionTestLanguageRoot();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImportSectionTestLanguageRoot createImportSectionTestLanguageRoot()
  {
    ImportSectionTestLanguageRootImpl importSectionTestLanguageRoot = new ImportSectionTestLanguageRootImpl();
    return importSectionTestLanguageRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public XImportSectionTestLangPackage getXImportSectionTestLangPackage()
  {
    return (XImportSectionTestLangPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static XImportSectionTestLangPackage getPackage()
  {
    return XImportSectionTestLangPackage.eINSTANCE;
  }

} //XImportSectionTestLangFactoryImpl
