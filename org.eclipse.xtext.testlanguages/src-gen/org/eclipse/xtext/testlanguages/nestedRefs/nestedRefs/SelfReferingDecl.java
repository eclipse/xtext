/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Self Refering Decl</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.SelfReferingDecl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.SelfReferingDecl#getSelfRef <em>Self Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.NestedRefsPackage#getSelfReferingDecl()
 * @model
 * @generated
 */
public interface SelfReferingDecl extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.NestedRefsPackage#getSelfReferingDecl_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.SelfReferingDecl#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Self Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Self Ref</em>' reference.
   * @see #setSelfRef(SelfReferingDecl)
   * @see org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.NestedRefsPackage#getSelfReferingDecl_SelfRef()
   * @model
   * @generated
   */
  SelfReferingDecl getSelfRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.nestedRefs.nestedRefs.SelfReferingDecl#getSelfRef <em>Self Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Self Ref</em>' reference.
   * @see #getSelfRef()
   * @generated
   */
  void setSelfRef(SelfReferingDecl value);

} // SelfReferingDecl
