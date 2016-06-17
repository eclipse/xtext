/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug377311;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug377311.Root#getChilds <em>Childs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug377311.Bug377311Package#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject
{
  /**
   * Returns the value of the '<em><b>Childs</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.ui.tests.editor.contentassist.bug377311.Child}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Childs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Childs</em>' containment reference list.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug377311.Bug377311Package#getRoot_Childs()
   * @model containment="true"
   * @generated
   */
  EList<Child> getChilds();

} // Root
