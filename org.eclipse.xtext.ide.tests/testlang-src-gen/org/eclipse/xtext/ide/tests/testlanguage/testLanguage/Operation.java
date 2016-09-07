/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.testlanguage.testLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation#getParams <em>Params</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation#getOperationCall <em>Operation Call</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Member
{
  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getOperation_Params()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParams();

  /**
   * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' containment reference.
   * @see #setReturnType(Type)
   * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getOperation_ReturnType()
   * @model containment="true"
   * @generated
   */
  Type getReturnType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation#getReturnType <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Type</em>' containment reference.
   * @see #getReturnType()
   * @generated
   */
  void setReturnType(Type value);

  /**
   * Returns the value of the '<em><b>Operation Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Call</em>' containment reference.
   * @see #setOperationCall(OperationCall)
   * @see org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage#getOperation_OperationCall()
   * @model containment="true"
   * @generated
   */
  OperationCall getOperationCall();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Operation#getOperationCall <em>Operation Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Call</em>' containment reference.
   * @see #getOperationCall()
   * @generated
   */
  void setOperationCall(OperationCall value);

} // Operation
