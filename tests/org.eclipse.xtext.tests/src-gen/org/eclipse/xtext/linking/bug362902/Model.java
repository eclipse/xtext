/**
 */
package org.eclipse.xtext.linking.bug362902;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.bug362902.Model#getGreetings <em>Greetings</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug362902.Model#getFavourite <em>Favourite</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.bug362902.Bug362902Package#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Greetings</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.bug362902.Greeting}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Greetings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Greetings</em>' containment reference list.
   * @see org.eclipse.xtext.linking.bug362902.Bug362902Package#getModel_Greetings()
   * @model containment="true"
   * @generated
   */
  EList<Greeting> getGreetings();

  /**
   * Returns the value of the '<em><b>Favourite</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Favourite</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Favourite</em>' reference.
   * @see #setFavourite(Greeting)
   * @see org.eclipse.xtext.linking.bug362902.Bug362902Package#getModel_Favourite()
   * @model
   * @generated
   */
  Greeting getFavourite();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug362902.Model#getFavourite <em>Favourite</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Favourite</em>' reference.
   * @see #getFavourite()
   * @generated
   */
  void setFavourite(Greeting value);

} // Model
