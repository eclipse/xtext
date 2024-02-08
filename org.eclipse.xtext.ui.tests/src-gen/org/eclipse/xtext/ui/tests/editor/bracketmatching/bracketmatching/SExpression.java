/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SExpression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.SExpression#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.BracketmatchingPackage#getSExpression()
 * @model
 * @generated
 */
public interface SExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.bracketmatching.bracketmatching.BracketmatchingPackage#getSExpression_Element()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getElement();

} // SExpression
