/**
 * <copyright>
 * </copyright>
 *
 * $Id: Model.java,v 1.2 2009/02/18 21:22:39 sefftinge Exp $
 */
package org.eclipse.xtext.testlanguages.actionLang;

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
 *   <li>{@link org.eclipse.xtext.testlanguages.actionLang.Model#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.actionLang.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangPackage#getModel_Children()
   * @model containment="true"
   * @generated
   */
  EList<Type> getChildren();

} // Model
