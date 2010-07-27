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
 * A representation of the model object '<em><b>Parameter List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.ParameterList#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getParameterList()
 * @model
 * @generated
 */
public interface ParameterList extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.BacktrackingTestLanguagePackage#getParameterList_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

} // ParameterList
