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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.TemplateBody#getParts <em>Parts</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getTemplateBody()
 * @model
 * @generated
 */
public interface TemplateBody extends EObject
{
  /**
   * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.codetemplates.templates.TemplatePart}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parts</em>' containment reference list.
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getTemplateBody_Parts()
   * @model containment="true"
   * @generated
   */
  EList<TemplatePart> getParts();

} // TemplateBody
