/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.testLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getTypeDeclaration()
 * @model
 * @generated
 */
public interface TypeDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getTypeDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' reference.
   * @see #setSuperType(TypeDeclaration)
   * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getTypeDeclaration_SuperType()
   * @model
   * @generated
   */
  TypeDeclaration getSuperType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration#getSuperType <em>Super Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(TypeDeclaration value);

  /**
   * Returns the value of the '<em><b>Members</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Member}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Members</em>' containment reference list.
   * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getTypeDeclaration_Members()
   * @model containment="true"
   * @generated
   */
  EList<Member> getMembers();

} // TypeDeclaration
