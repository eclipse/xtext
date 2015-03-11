/**
 */
package org.eclipse.xtext.parser.assignments.bug288432Test;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.Body#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.Body#getContent <em>Content</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.Body#getFoo <em>Foo</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getBody()
 * @model
 * @generated
 */
public interface Body extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.assignments.bug288432Test.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter</em>' containment reference list.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getBody_Parameter()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameter();

  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference.
   * @see #setContent(ParameterObject)
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getBody_Content()
   * @model containment="true"
   * @generated
   */
  ParameterObject getContent();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Body#getContent <em>Content</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Content</em>' containment reference.
   * @see #getContent()
   * @generated
   */
  void setContent(ParameterObject value);

  /**
   * Returns the value of the '<em><b>Foo</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.assignments.bug288432Test.Foo}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Foo</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Foo</em>' containment reference list.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getBody_Foo()
   * @model containment="true"
   * @generated
   */
  EList<Foo> getFoo();

} // Body
