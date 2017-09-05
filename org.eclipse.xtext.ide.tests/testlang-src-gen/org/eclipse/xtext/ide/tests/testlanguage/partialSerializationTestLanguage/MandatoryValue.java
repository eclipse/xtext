/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mandatory Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage#getMandatoryValue()
 * @model
 * @generated
 */
public interface MandatoryValue extends Model
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
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage#getMandatoryValue_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // MandatoryValue
