/**
 */
package org.eclipse.xtext.parser.assignments.bug288432Test;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>My Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.assignments.bug288432Test.MyElement#getBar <em>Bar</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getMyElement()
 * @model
 * @generated
 */
public interface MyElement extends Content
{
  /**
   * Returns the value of the '<em><b>Bar</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bar</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bar</em>' containment reference.
   * @see #setBar(ParameterObject)
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage#getMyElement_Bar()
   * @model containment="true"
   * @generated
   */
  ParameterObject getBar();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.MyElement#getBar <em>Bar</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bar</em>' containment reference.
   * @see #getBar()
   * @generated
   */
  void setBar(ParameterObject value);

} // MyElement
