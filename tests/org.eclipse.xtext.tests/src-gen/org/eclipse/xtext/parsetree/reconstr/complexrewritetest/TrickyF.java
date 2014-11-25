/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tricky F</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyF()
 * @model
 * @generated
 */
public interface TrickyF extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyF_Name()
   * @model unique="false"
   * @generated
   */
  EList<String> getName();

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyF_Type()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getType();

} // TrickyF
