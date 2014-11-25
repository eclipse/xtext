/**
 */
package org.eclipse.xtext.generator.ecore.second;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.generator.ecore.first.First;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Second</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.generator.ecore.second.Second#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.generator.ecore.second.Second#getFirst <em>First</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.generator.ecore.second.SecondPackage#getSecond()
 * @model
 * @generated
 */
public interface Second extends EObject
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
   * @see org.eclipse.xtext.generator.ecore.second.SecondPackage#getSecond_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.ecore.second.Second#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>First</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' reference.
   * @see #setFirst(First)
   * @see org.eclipse.xtext.generator.ecore.second.SecondPackage#getSecond_First()
   * @model
   * @generated
   */
  First getFirst();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.generator.ecore.second.Second#getFirst <em>First</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' reference.
   * @see #getFirst()
   * @generated
   */
  void setFirst(First value);

} // Second
