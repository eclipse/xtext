/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.codetemplates.templates;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dollar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.codetemplates.templates.Dollar#isEscaped <em>Escaped</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getDollar()
 * @model
 * @generated
 */
public interface Dollar extends TemplatePart
{
  /**
   * Returns the value of the '<em><b>Escaped</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Escaped</em>' attribute.
   * @see #setEscaped(boolean)
   * @see org.eclipse.xtext.ui.codetemplates.templates.TemplatesPackage#getDollar_Escaped()
   * @model
   * @generated
   */
  boolean isEscaped();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.codetemplates.templates.Dollar#isEscaped <em>Escaped</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escaped</em>' attribute.
   * @see #isEscaped()
   * @generated
   */
  void setEscaped(boolean value);

} // Dollar
