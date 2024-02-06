/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.lookaheadLang;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Look Ahead1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getZ <em>Z</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage#getLookAhead1()
 * @model
 * @generated
 */
public interface LookAhead1 extends Alts
{
  /**
   * Returns the value of the '<em><b>Y</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Y</em>' containment reference.
   * @see #setY(LookAhead2)
   * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage#getLookAhead1_Y()
   * @model containment="true"
   * @generated
   */
  LookAhead2 getY();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getY <em>Y</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Y</em>' containment reference.
   * @see #getY()
   * @generated
   */
  void setY(LookAhead2 value);

  /**
   * Returns the value of the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>X</em>' attribute.
   * @see #setX(String)
   * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage#getLookAhead1_X()
   * @model
   * @generated
   */
  String getX();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getX <em>X</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>X</em>' attribute.
   * @see #getX()
   * @generated
   */
  void setX(String value);

  /**
   * Returns the value of the '<em><b>Z</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Z</em>' attribute.
   * @see #setZ(String)
   * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage#getLookAhead1_Z()
   * @model
   * @generated
   */
  String getZ();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.lookaheadLang.LookAhead1#getZ <em>Z</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Z</em>' attribute.
   * @see #getZ()
   * @generated
   */
  void setZ(String value);

} // LookAhead1
