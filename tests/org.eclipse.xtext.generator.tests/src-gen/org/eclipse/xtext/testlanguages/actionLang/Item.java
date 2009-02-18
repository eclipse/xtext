/**
 * <copyright>
 * </copyright>
 *
 * $Id: Item.java,v 1.1 2009/02/18 19:44:59 sefftinge Exp $
 */
package org.eclipse.xtext.testlanguages.actionLang;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.actionLang.Item#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getItem()
 * @model
 * @generated
 */
public interface Item extends Type
{
  /**
   * Returns the value of the '<em><b>Items</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.actionLang.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Items</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getItem_Items()
   * @model containment="true"
   * @generated
   */
  EList<Type> getItems();

} // Item
