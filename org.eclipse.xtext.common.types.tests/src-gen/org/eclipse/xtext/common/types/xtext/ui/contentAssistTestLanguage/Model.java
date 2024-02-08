/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getGenerateDirective <em>Generate Directive</em>}</li>
 *   <li>{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getReferenceHolder <em>Reference Holder</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Import}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getModel_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Generate Directive</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Generate Directive</em>' containment reference.
   * @see #setGenerateDirective(GenerateDirective)
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getModel_GenerateDirective()
   * @model containment="true"
   * @generated
   */
  GenerateDirective getGenerateDirective();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getGenerateDirective <em>Generate Directive</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Generate Directive</em>' containment reference.
   * @see #getGenerateDirective()
   * @generated
   */
  void setGenerateDirective(GenerateDirective value);

  /**
   * Returns the value of the '<em><b>Reference Holder</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference Holder</em>' containment reference.
   * @see #setReferenceHolder(ReferenceHolder)
   * @see org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.ContentAssistTestLanguagePackage#getModel_ReferenceHolder()
   * @model containment="true"
   * @generated
   */
  ReferenceHolder getReferenceHolder();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.common.types.xtext.ui.contentAssistTestLanguage.Model#getReferenceHolder <em>Reference Holder</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference Holder</em>' containment reference.
   * @see #getReferenceHolder()
   * @generated
   */
  void setReferenceHolder(ReferenceHolder value);

} // Model
