/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.terminalrules.unicode.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.xtext.parser.terminalrules.unicode.QuotedString;
import org.eclipse.xtext.parser.terminalrules.unicode.UnicodePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quoted String</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class QuotedStringImpl extends AbstractStringImpl implements QuotedString
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected QuotedStringImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return UnicodePackage.Literals.QUOTED_STRING;
  }

} //QuotedStringImpl
