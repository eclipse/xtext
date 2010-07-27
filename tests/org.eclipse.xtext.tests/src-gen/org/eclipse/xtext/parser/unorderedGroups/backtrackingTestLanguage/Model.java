/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage;

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
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Model#getUnits <em>Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Units</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Unit}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Units</em>' containment reference list.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getModel_Units()
   * @model containment="true"
   * @generated
   */
  EList<Unit> getUnits();

} // Model
