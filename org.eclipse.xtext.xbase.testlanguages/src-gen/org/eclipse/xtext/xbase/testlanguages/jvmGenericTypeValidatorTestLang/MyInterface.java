/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.MyInterface#getExtends <em>Extends</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage#getMyInterface()
 * @model
 * @generated
 */
public interface MyInterface extends MyType
{
  /**
   * Returns the value of the '<em><b>Type Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Parameters</em>' containment reference list.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage#getMyInterface_TypeParameters()
   * @model containment="true"
   * @generated
   */
  EList<JvmTypeParameter> getTypeParameters();

  /**
   * Returns the value of the '<em><b>Extends</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.common.types.JvmParameterizedTypeReference}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' containment reference list.
   * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage#getMyInterface_Extends()
   * @model containment="true"
   * @generated
   */
  EList<JvmParameterizedTypeReference> getExtends();

} // MyInterface
