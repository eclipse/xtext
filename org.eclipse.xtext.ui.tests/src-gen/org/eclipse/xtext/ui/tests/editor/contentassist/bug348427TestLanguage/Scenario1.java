/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Scenario1#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#getScenario1()
 * @model
 * @generated
 */
public interface Scenario1 extends EObject
{
  /**
   * Returns the value of the '<em><b>Child</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Child1}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348427TestLanguage.Bug348427TestLanguagePackage#getScenario1_Child()
   * @model containment="true"
   * @generated
   */
  EList<Child1> getChild();

} // Scenario1
