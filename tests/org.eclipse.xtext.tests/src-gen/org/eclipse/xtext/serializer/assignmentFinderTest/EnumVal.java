/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.serializer.assignmentFinderTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Val</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal#getEn <em>En</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage#getEnumVal()
 * @model
 * @generated
 */
public interface EnumVal extends EObject
{
  /**
   * Returns the value of the '<em><b>En</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.serializer.assignmentFinderTest.EnumN}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>En</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>En</em>' attribute.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.EnumN
   * @see #setEn(EnumN)
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.AssignmentFinderTestPackage#getEnumVal_En()
   * @model
   * @generated
   */
  EnumN getEn();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal#getEn <em>En</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>En</em>' attribute.
   * @see org.eclipse.xtext.serializer.assignmentFinderTest.EnumN
   * @see #getEn()
   * @generated
   */
  void setEn(EnumN value);

} // EnumVal
