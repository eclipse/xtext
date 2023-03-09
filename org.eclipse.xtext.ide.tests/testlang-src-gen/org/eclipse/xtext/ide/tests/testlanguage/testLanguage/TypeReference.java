/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.testLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference#getTypeRef <em>Type Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getTypeReference()
 * @model
 * @generated
 */
public interface TypeReference extends Type
{
  /**
   * Returns the value of the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Ref</em>' reference.
   * @see #setTypeRef(TypeDeclaration)
   * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getTypeReference_TypeRef()
   * @model
   * @generated
   */
  TypeDeclaration getTypeRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference#getTypeRef <em>Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Ref</em>' reference.
   * @see #getTypeRef()
   * @generated
   */
  void setTypeRef(TypeDeclaration value);

} // TypeReference
