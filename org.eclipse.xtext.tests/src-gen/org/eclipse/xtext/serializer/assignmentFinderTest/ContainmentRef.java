/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containment Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef#getCtx <em>Ctx</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage#getContainmentRef()
 * @model
 * @generated
 */
public interface ContainmentRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Ctx</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ctx</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ctx</em>' containment reference.
   * @see #setCtx(ContainmentRefN)
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage#getContainmentRef_Ctx()
   * @model containment="true"
   * @generated
   */
  ContainmentRefN getCtx();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef#getCtx <em>Ctx</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ctx</em>' containment reference.
   * @see #getCtx()
   * @generated
   */
  void setCtx(ContainmentRefN value);

} // ContainmentRef
