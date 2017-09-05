/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage
 * @generated
 */
public interface PartialSerializationTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PartialSerializationTestLanguageFactory eINSTANCE = org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.impl.PartialSerializationTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Mandatory Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mandatory Value</em>'.
   * @generated
   */
  MandatoryValue createMandatoryValue();

  /**
   * Returns a new object of class '<em>Optional Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Optional Value</em>'.
   * @generated
   */
  OptionalValue createOptionalValue();

  /**
   * Returns a new object of class '<em>Many Optional Values</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Many Optional Values</em>'.
   * @generated
   */
  ManyOptionalValues createManyOptionalValues();

  /**
   * Returns a new object of class '<em>Many Mandatory Values</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Many Mandatory Values</em>'.
   * @generated
   */
  ManyMandatoryValues createManyMandatoryValues();

  /**
   * Returns a new object of class '<em>Mandatory Child</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mandatory Child</em>'.
   * @generated
   */
  MandatoryChild createMandatoryChild();

  /**
   * Returns a new object of class '<em>Optional Child</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Optional Child</em>'.
   * @generated
   */
  OptionalChild createOptionalChild();

  /**
   * Returns a new object of class '<em>Mandatory Child List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mandatory Child List</em>'.
   * @generated
   */
  MandatoryChildList createMandatoryChildList();

  /**
   * Returns a new object of class '<em>Optional Child List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Optional Child List</em>'.
   * @generated
   */
  OptionalChildList createOptionalChildList();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node</em>'.
   * @generated
   */
  Node createNode();

  /**
   * Returns a new object of class '<em>EClass Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EClass Ref</em>'.
   * @generated
   */
  EClassRef createEClassRef();

  /**
   * Returns a new object of class '<em>Many Values</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Many Values</em>'.
   * @generated
   */
  ManyValues createManyValues();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PartialSerializationTestLanguagePackage getPartialSerializationTestLanguagePackage();

} //PartialSerializationTestLanguageFactory
