/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getFoo <em>Foo</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getBar <em>Bar</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Foo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foo</em>' attribute.
   * @see #setFoo(String)
   * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguagePackage#getModel_Foo()
   * @model
   * @generated
   */
  String getFoo();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getFoo <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Foo</em>' attribute.
   * @see #getFoo()
   * @generated
   */
  void setFoo(String value);

  /**
   * Returns the value of the '<em><b>Bar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bar</em>' attribute.
   * @see #setBar(String)
   * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguagePackage#getModel_Bar()
   * @model
   * @generated
   */
  String getBar();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getBar <em>Bar</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bar</em>' attribute.
   * @see #getBar()
   * @generated
   */
  void setBar(String value);

} // Model
