/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.domainmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.domainmodel.TypeRef#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.domainmodel.DomainmodelPackage#getTypeRef()
 * @model
 * @generated
 */
public interface TypeRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Referenced</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Referenced</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Referenced</em>' reference.
   * @see #setReferenced(Type)
   * @see org.eclipse.xtext.example.domainmodel.DomainmodelPackage#getTypeRef_Referenced()
   * @model
   * @generated
   */
  Type getReferenced();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.domainmodel.TypeRef#getReferenced <em>Referenced</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Referenced</em>' reference.
   * @see #getReferenced()
   * @generated
   */
  void setReferenced(Type value);

} // TypeRef
