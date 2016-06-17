/**
 */
package org.eclipse.xtext.resource.locationprovidertest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Transition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Transition#getDestination <em>Destination</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends EObject
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
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getTransition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.locationprovidertest.Transition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(Mode)
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getTransition_Source()
   * @model
   * @generated
   */
  Mode getSource();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.locationprovidertest.Transition#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(Mode value);

  /**
   * Returns the value of the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Destination</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Destination</em>' reference.
   * @see #setDestination(Mode)
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getTransition_Destination()
   * @model
   * @generated
   */
  Mode getDestination();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.locationprovidertest.Transition#getDestination <em>Destination</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Destination</em>' reference.
   * @see #getDestination()
   * @generated
   */
  void setDestination(Mode value);

} // Transition
