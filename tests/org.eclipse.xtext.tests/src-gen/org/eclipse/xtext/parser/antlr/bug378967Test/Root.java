/**
 */
package org.eclipse.xtext.parser.antlr.bug378967Test;

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
 *   <li>{@link org.eclipse.xtext.parser.antlr.bug378967Test.Root#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject
{
  /**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Element</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(EObject)
   * @see org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage#getRoot_Element()
   * @model containment="true"
   * @generated
   */
  EObject getElement();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.antlr.bug378967Test.Root#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
  void setElement(EObject value);

} // Root
