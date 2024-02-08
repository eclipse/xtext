/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.NoTerminalExtensionPackage
 * @generated
 */
public interface NoTerminalExtensionFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  NoTerminalExtensionFactory eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.impl.NoTerminalExtensionFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Polygon Based Shape</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Polygon Based Shape</em>'.
   * @generated
   */
  PolygonBasedShape createPolygonBasedShape();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  NoTerminalExtensionPackage getNoTerminalExtensionPackage();

} //NoTerminalExtensionFactory
