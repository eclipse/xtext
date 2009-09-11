/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtextUiTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextUiTest.Group#getTokens <em>Tokens</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextUiTest.XtextUiTestPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Tokens</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.xtextUiTest.AbstractElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tokens</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tokens</em>' containment reference list.
   * @see org.eclipse.xtext.xtextUiTest.XtextUiTestPackage#getGroup_Tokens()
   * @model containment="true"
   * @generated
   */
  EList<AbstractElement> getTokens();

} // Group
