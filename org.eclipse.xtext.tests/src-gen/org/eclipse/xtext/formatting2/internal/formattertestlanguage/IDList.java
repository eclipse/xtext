/**
 */
package org.eclipse.xtext.formatting2.internal.formattertestlanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ID List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.formatting2.internal.formattertestlanguage.IDList#getIds <em>Ids</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguagePackage#getIDList()
 * @model
 * @generated
 */
public interface IDList extends Root
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
   * @see org.eclipse.xtext.formatting2.internal.formattertestlanguage.FormattertestlanguagePackage#getIDList_Ids()
   * @model unique="false"
   * @generated
   */
  EList<String> getIds();

} // IDList
