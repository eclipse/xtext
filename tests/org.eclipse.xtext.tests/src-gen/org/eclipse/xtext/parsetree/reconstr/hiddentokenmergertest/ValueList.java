/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.ValueList#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getValueList()
 * @model
 * @generated
 */
public interface ValueList extends Model
{
  /**
   * Returns the value of the '<em><b>Ids</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ids</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ids</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getValueList_Ids()
   * @model unique="false"
   * @generated
   */
  EList<String> getIds();

} // ValueList
