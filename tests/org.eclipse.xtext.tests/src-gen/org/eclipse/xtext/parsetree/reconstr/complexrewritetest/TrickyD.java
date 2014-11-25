/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tricky D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getFoo <em>Foo</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyD()
 * @model
 * @generated
 */
public interface TrickyD extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyD_Name()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getName();

  /**
   * Returns the value of the '<em><b>Foo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Foo</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foo</em>' attribute.
   * @see #setFoo(String)
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyD_Foo()
   * @model
   * @generated
   */
  String getFoo();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD#getFoo <em>Foo</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Foo</em>' attribute.
   * @see #getFoo()
   * @generated
   */
  void setFoo(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyD_Type()
   * @model unique="false"
   * @generated
   */
  EList<String> getType();

} // TrickyD
