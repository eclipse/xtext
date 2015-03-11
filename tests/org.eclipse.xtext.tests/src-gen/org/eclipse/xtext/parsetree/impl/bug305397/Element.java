/**
 */
package org.eclipse.xtext.parsetree.impl.bug305397;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.bug305397.Element#isA <em>A</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.bug305397.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.impl.bug305397.Element#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.impl.bug305397.Bug305397Package#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject
{
  /**
   * Returns the value of the '<em><b>A</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>A</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>A</em>' attribute.
   * @see #setA(boolean)
   * @see org.eclipse.xtext.parsetree.impl.bug305397.Bug305397Package#getElement_A()
   * @model
   * @generated
   */
  boolean isA();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.impl.bug305397.Element#isA <em>A</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>A</em>' attribute.
   * @see #isA()
   * @generated
   */
  void setA(boolean value);

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
   * @see org.eclipse.xtext.parsetree.impl.bug305397.Bug305397Package#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.impl.bug305397.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.impl.bug305397.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.impl.bug305397.Bug305397Package#getElement_Elements()
   * @model containment="true"
   * @generated
   */
  EList<Element> getElements();

} // Element
