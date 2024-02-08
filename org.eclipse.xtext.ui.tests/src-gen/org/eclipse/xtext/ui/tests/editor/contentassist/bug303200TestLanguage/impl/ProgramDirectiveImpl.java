/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Bug303200TestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ProgramDirective;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Program Directive</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ProgramDirectiveImpl extends MinimalEObjectImpl.Container implements ProgramDirective
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProgramDirectiveImpl()
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
    return Bug303200TestLanguagePackage.Literals.PROGRAM_DIRECTIVE;
  }

} //ProgramDirectiveImpl
