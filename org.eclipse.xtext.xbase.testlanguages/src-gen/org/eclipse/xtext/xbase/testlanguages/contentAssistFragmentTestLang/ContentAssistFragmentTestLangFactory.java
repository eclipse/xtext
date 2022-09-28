/**
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.ContentAssistFragmentTestLangPackage
 * @generated
 */
public interface ContentAssistFragmentTestLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContentAssistFragmentTestLangFactory eINSTANCE = org.eclipse.xtext.xbase.testlanguages.contentAssistFragmentTestLang.impl.ContentAssistFragmentTestLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Content Assist Fragment Test Language Root</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Content Assist Fragment Test Language Root</em>'.
   * @generated
   */
  ContentAssistFragmentTestLanguageRoot createContentAssistFragmentTestLanguageRoot();

  /**
   * Returns a new object of class '<em>Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entity</em>'.
   * @generated
   */
  Entity createEntity();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ContentAssistFragmentTestLangPackage getContentAssistFragmentTestLangPackage();

} //ContentAssistFragmentTestLangFactory
