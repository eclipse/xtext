/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Overriding Hiddens</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens#getCalled <em>Called</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getOverridingHiddens()
 * @model
 * @generated
 */
public interface OverridingHiddens extends Model
{
  /**
   * Returns the value of the '<em><b>Called</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Called</em>' containment reference.
   * @see #setCalled(OverridingHiddensCall)
   * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage#getOverridingHiddens_Called()
   * @model containment="true"
   * @generated
   */
  OverridingHiddensCall getCalled();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens#getCalled <em>Called</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Called</em>' containment reference.
   * @see #getCalled()
   * @generated
   */
  void setCalled(OverridingHiddensCall value);

} // OverridingHiddens
