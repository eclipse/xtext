/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.codetemplates.templates;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.Grammar;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Codetemplates</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplates#getLanguage <em>Language</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplates#getTemplates <em>Templates</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplates()
 * @model
 * @generated
 */
public interface Codetemplates extends EObject
{
  /**
   * Returns the value of the '<em><b>Language</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Language</em>' reference.
   * @see #setLanguage(Grammar)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplates_Language()
   * @model
   * @generated
   */
  Grammar getLanguage();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplates#getLanguage <em>Language</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Language</em>' reference.
   * @see #getLanguage()
   * @generated
   */
  void setLanguage(Grammar value);

  /**
   * Returns the value of the '<em><b>Templates</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.codetemplates.templates.Codetemplate}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Templates</em>' containment reference list.
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getCodetemplates_Templates()
   * @model containment="true"
   * @generated
   */
  EList<Codetemplate> getTemplates();

} // Codetemplates
