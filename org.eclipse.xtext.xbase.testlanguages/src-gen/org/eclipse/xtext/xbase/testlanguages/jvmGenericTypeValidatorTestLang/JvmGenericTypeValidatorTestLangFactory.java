/**
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.JvmGenericTypeValidatorTestLangPackage
 * @generated
 */
public interface JvmGenericTypeValidatorTestLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  JvmGenericTypeValidatorTestLangFactory eINSTANCE = org.eclipse.xtext.xbase.testlanguages.jvmGenericTypeValidatorTestLang.impl.JvmGenericTypeValidatorTestLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  JvmGenericTypeValidatorTestLangModel createJvmGenericTypeValidatorTestLangModel();

  /**
   * Returns a new object of class '<em>My Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Type</em>'.
   * @generated
   */
  MyType createMyType();

  /**
   * Returns a new object of class '<em>My Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Class</em>'.
   * @generated
   */
  MyClass createMyClass();

  /**
   * Returns a new object of class '<em>My Interface</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Interface</em>'.
   * @generated
   */
  MyInterface createMyInterface();

  /**
   * Returns a new object of class '<em>My Class With Super Types</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Class With Super Types</em>'.
   * @generated
   */
  MyClassWithSuperTypes createMyClassWithSuperTypes();

  /**
   * Returns a new object of class '<em>My Class With Wrong Additional Inferred Interface</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Class With Wrong Additional Inferred Interface</em>'.
   * @generated
   */
  MyClassWithWrongAdditionalInferredInterface createMyClassWithWrongAdditionalInferredInterface();

  /**
   * Returns a new object of class '<em>My Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Member</em>'.
   * @generated
   */
  MyMember createMyMember();

  /**
   * Returns a new object of class '<em>My Constructor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Constructor</em>'.
   * @generated
   */
  MyConstructor createMyConstructor();

  /**
   * Returns a new object of class '<em>My Field</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Field</em>'.
   * @generated
   */
  MyField createMyField();

  /**
   * Returns a new object of class '<em>My Method</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Method</em>'.
   * @generated
   */
  MyMethod createMyMethod();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  JvmGenericTypeValidatorTestLangPackage getJvmGenericTypeValidatorTestLangPackage();

} //JvmGenericTypeValidatorTestLangFactory
