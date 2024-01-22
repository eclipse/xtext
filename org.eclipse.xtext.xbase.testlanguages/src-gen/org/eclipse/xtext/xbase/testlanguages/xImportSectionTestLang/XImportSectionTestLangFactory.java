/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.XImportSectionTestLangPackage
 * @generated
 */
public interface XImportSectionTestLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  XImportSectionTestLangFactory eINSTANCE = org.eclipse.xtext.xbase.testlanguages.xImportSectionTestLang.impl.XImportSectionTestLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Import Section Test Language Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import Section Test Language Root</em>'.
   * @generated
   */
  ImportSectionTestLanguageRoot createImportSectionTestLanguageRoot();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  XImportSectionTestLangPackage getXImportSectionTestLangPackage();

} //XImportSectionTestLangFactory
