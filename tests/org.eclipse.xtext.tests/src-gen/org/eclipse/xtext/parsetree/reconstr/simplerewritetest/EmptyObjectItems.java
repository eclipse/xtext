/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Empty Object Items</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItems#getList <em>List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getEmptyObjectItems()
 * @model
 * @generated
 */
public interface EmptyObjectItems extends EObject
{
  /**
   * Returns the value of the '<em><b>List</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EmptyObjectItem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getEmptyObjectItems_List()
   * @model containment="true"
   * @generated
   */
  EList<EmptyObjectItem> getList();

} // EmptyObjectItems
