/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.tutorial.tutorial;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Model Tutorial</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.DomainModelTutorial#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getDomainModelTutorial()
 * @model
 * @generated
 */
public interface DomainModelTutorial extends EObject
{
  /**
   * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.tutorial.tutorial.AbstractElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' containment reference list.
   * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getDomainModelTutorial_Elements()
   * @model containment="true"
   * @generated
   */
  EList<AbstractElement> getElements();

} // DomainModelTutorial
