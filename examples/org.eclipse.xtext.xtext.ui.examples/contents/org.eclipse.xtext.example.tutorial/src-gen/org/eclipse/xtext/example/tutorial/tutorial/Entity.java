/**
 */
package org.eclipse.xtext.example.tutorial.tutorial;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.Entity#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.Entity#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.example.tutorial.tutorial.Entity#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getEntity()
 * @model
 * @generated
 */
public interface Entity extends EObject
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
   * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getEntity_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.tutorial.tutorial.Entity#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Super Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super Type</em>' containment reference.
   * @see #setSuperType(JvmTypeReference)
   * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getEntity_SuperType()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getSuperType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.tutorial.tutorial.Entity#getSuperType <em>Super Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super Type</em>' containment reference.
   * @see #getSuperType()
   * @generated
   */
  void setSuperType(JvmTypeReference value);

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.example.tutorial.tutorial.Property}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.eclipse.xtext.example.tutorial.tutorial.TutorialPackage#getEntity_Features()
   * @model containment="true"
   * @generated
   */
  EList<Property> getFeatures();

} // Entity
