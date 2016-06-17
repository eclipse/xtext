/**
 */
package org.eclipse.xtext.resource.locationprovidertest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Component#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Component#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Component#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends EObject
{
  /**
   * Returns the value of the '<em><b>Mode</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.locationprovidertest.Mode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mode</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mode</em>' containment reference list.
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getComponent_Mode()
   * @model containment="true"
   * @generated
   */
  EList<Mode> getMode();

  /**
   * Returns the value of the '<em><b>Transition</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.locationprovidertest.Transition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition</em>' containment reference list.
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getComponent_Transition()
   * @model containment="true"
   * @generated
   */
  EList<Transition> getTransition();

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
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getComponent_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.locationprovidertest.Component#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Component
