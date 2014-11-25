/**
 */
package org.eclipse.xtext.testlanguages.lookaheadLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.lookaheadLang.Entry#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage#getEntry()
 * @model
 * @generated
 */
public interface Entry extends EObject
{
  /**
   * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.lookaheadLang.Alts}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contents</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage#getEntry_Contents()
   * @model containment="true"
   * @generated
   */
  EList<Alts> getContents();

} // Entry
