/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polygon Based Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedShape#getShape <em>Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.NoTerminalExtensionPackage#getPolygonBasedShape()
 * @model
 * @generated
 */
public interface PolygonBasedShape extends EObject
{
  /**
   * Returns the value of the '<em><b>Shape</b></em>' attribute list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedNodeShape}.
   * The literals are from the enumeration {@link org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedNodeShape}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Shape</em>' attribute list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.PolygonBasedNodeShape
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.noTerminalExtension.NoTerminalExtensionPackage#getPolygonBasedShape_Shape()
   * @model unique="false"
   * @generated
   */
  EList<PolygonBasedNodeShape> getShape();

} // PolygonBasedShape
