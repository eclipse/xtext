/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Two Child Lists</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChildLists#getDirectChildren <em>Direct Children</em>}</li>
 *   <li>{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChildLists#getChildsList <em>Childs List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage#getTwoChildLists()
 * @model
 * @generated
 */
public interface TwoChildLists extends Model
{
  /**
   * Returns the value of the '<em><b>Direct Children</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.MandatoryValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direct Children</em>' containment reference list.
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage#getTwoChildLists_DirectChildren()
   * @model containment="true"
   * @generated
   */
  EList<MandatoryValue> getDirectChildren();

  /**
   * Returns the value of the '<em><b>Childs List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Childs List</em>' containment reference.
   * @see #setChildsList(MandatoryChildList)
   * @see org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.PartialSerializationTestLanguagePackage#getTwoChildLists_ChildsList()
   * @model containment="true"
   * @generated
   */
  MandatoryChildList getChildsList();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.TwoChildLists#getChildsList <em>Childs List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Childs List</em>' containment reference.
   * @see #getChildsList()
   * @generated
   */
  void setChildsList(MandatoryChildList value);

} // TwoChildLists
