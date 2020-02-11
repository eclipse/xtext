/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Two Childs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds#getDirectChild <em>Direct Child</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds#getOptChild <em>Opt Child</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage#getTwoChilds()
 * @model
 * @generated
 */
public interface TwoChilds extends Model
{
  /**
   * Returns the value of the '<em><b>Direct Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direct Child</em>' containment reference.
   * @see #setDirectChild(MandatoryValue)
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage#getTwoChilds_DirectChild()
   * @model containment="true"
   * @generated
   */
  MandatoryValue getDirectChild();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds#getDirectChild <em>Direct Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direct Child</em>' containment reference.
   * @see #getDirectChild()
   * @generated
   */
  void setDirectChild(MandatoryValue value);

  /**
   * Returns the value of the '<em><b>Opt Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opt Child</em>' containment reference.
   * @see #setOptChild(OptionalChild)
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage#getTwoChilds_OptChild()
   * @model containment="true"
   * @generated
   */
  OptionalChild getOptChild();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChilds#getOptChild <em>Opt Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opt Child</em>' containment reference.
   * @see #getOptChild()
   * @generated
   */
  void setOptChild(OptionalChild value);

} // TwoChilds
