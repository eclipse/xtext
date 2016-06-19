/**
 */
package org.eclipse.xtext.serializer.contextFinderTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parent Ref Test Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getParentRefTestChild()
 * @model
 * @generated
 */
public interface ParentRefTestChild extends EObject
{
  /**
   * Returns the value of the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference.
   * @see #setChild(ParentRefTestChild)
   * @see org.eclipse.xtext.serializer.contextFinderTest.ContextFinderTestPackage#getParentRefTestChild_Child()
   * @model containment="true"
   * @generated
   */
  ParentRefTestChild getChild();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.contextFinderTest.ParentRefTestChild#getChild <em>Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child</em>' containment reference.
   * @see #getChild()
   * @generated
   */
  void setChild(ParentRefTestChild value);

} // ParentRefTestChild
