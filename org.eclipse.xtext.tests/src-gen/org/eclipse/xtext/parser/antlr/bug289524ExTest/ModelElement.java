/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.antlr.bug289524ExTest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement#getContainments <em>Containments</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug289524ExTest.ModelElement#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Bug289524ExTestPackage#getModelElement()
 * @model
 * @generated
 */
public interface ModelElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Containments</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.antlr.bug289524ExTest.Contained}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Containments</em>' containment reference list.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Bug289524ExTestPackage#getModelElement_Containments()
   * @model containment="true"
   * @generated
   */
  EList<Contained> getContainments();

  /**
   * Returns the value of the '<em><b>Refs</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.antlr.bug289524ExTest.Contained}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Refs</em>' reference list.
   * @see org.eclipse.xtext.parser.antlr.bug289524ExTest.Bug289524ExTestPackage#getModelElement_Refs()
   * @model
   * @generated
   */
  EList<Contained> getRefs();

} // ModelElement
