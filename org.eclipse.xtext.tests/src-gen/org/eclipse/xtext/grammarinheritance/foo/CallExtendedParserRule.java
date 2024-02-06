/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.grammarinheritance.foo;

import org.eclipse.xtext.grammarinheritance.ametamodel.AModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Extended Parser Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule#getCall <em>Call</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage#getCallExtendedParserRule()
 * @model
 * @generated
 */
public interface CallExtendedParserRule extends RootRule
{
  /**
   * Returns the value of the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' containment reference.
   * @see #setCall(AModel)
   * @see org.eclipse.xtext.grammarinheritance.foo.FooPackage#getCallExtendedParserRule_Call()
   * @model containment="true"
   * @generated
   */
  AModel getCall();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.grammarinheritance.foo.CallExtendedParserRule#getCall <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' containment reference.
   * @see #getCall()
   * @generated
   */
  void setCall(AModel value);

} // CallExtendedParserRule
