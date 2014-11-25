/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1#getActions2 <em>Actions2</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getAction1()
 * @model
 * @generated
 */
public interface Action1 extends Model
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
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getAction1_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Action1#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Actions2</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Actions2</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actions2</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getAction1_Actions2()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getActions2();

} // Action1
