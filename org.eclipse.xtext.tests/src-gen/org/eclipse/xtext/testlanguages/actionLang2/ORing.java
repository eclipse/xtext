/**
 */
package org.eclipse.xtext.testlanguages.actionLang2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ORing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.actionLang2.ORing#getDisjuncts <em>Disjuncts</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.actionLang2.ActionLang2Package#getORing()
 * @model
 * @generated
 */
public interface ORing extends EObject
{
  /**
   * Returns the value of the '<em><b>Disjuncts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.testlanguages.actionLang2.ORing}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Disjuncts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Disjuncts</em>' containment reference list.
   * @see org.eclipse.xtext.testlanguages.actionLang2.ActionLang2Package#getORing_Disjuncts()
   * @model containment="true"
   * @generated
   */
  EList<ORing> getDisjuncts();

} // ORing
