/**
 */
package org.eclipse.xtext.serializer.assignmentFinderTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cross Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef#getCrossRef <em>Cross Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage#getCrossRef()
 * @model
 * @generated
 */
public interface CrossRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage#getCrossRef_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Cross Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cross Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cross Ref</em>' reference.
   * @see #setCrossRef(CrossRef)
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage#getCrossRef_CrossRef()
   * @model
   * @generated
   */
  CrossRef getCrossRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef#getCrossRef <em>Cross Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cross Ref</em>' reference.
   * @see #getCrossRef()
   * @generated
   */
  void setCrossRef(CrossRef value);

} // CrossRef
