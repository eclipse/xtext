/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.xtextUiTest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternatives</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.xtextUiTest.Alternatives#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.ui.tests.xtextUiTest.XtextUiTestPackage#getAlternatives()
 * @model
 * @generated
 */
public interface Alternatives extends AbstractElement
{
  /**
   * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.xtextUiTest.AbstractElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Groups</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.xtextUiTest.XtextUiTestPackage#getAlternatives_Groups()
   * @model containment="true"
   * @generated
   */
  EList<AbstractElement> getGroups();

} // Alternatives
