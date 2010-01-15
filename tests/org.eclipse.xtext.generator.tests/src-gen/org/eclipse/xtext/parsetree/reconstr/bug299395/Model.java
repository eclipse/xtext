/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.bug299395;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getUnused <em>Unused</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Unused</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unused</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unused</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getModel_Unused()
   * @model unique="false"
   * @generated
   */
  EList<String> getUnused();

  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getModel_Key()
   * @model unique="false"
   * @generated
   */
  EList<String> getKey();

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Package#getModel_Value()
   * @model unique="false"
   * @generated
   */
  EList<String> getValue();

} // Model
