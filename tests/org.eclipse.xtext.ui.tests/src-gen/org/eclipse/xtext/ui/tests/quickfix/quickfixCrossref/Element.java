/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element#getContained <em>Contained</em>}</li>
 *   <li>{@link org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.QuickfixCrossrefPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject
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
   * @see org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.QuickfixCrossrefPackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Contained</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contained</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contained</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.QuickfixCrossrefPackage#getElement_Contained()
   * @model containment="true"
   * @generated
   */
  EList<Element> getContained();

  /**
   * Returns the value of the '<em><b>Referenced</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced</em>' reference list.
   * @see org.eclipse.xtext.ui.tests.quickfix.quickfixCrossref.QuickfixCrossrefPackage#getElement_Referenced()
   * @model
   * @generated
   */
  EList<Element> getReferenced();

} // Element
