/**
 */
package org.eclipse.xtext.resource.locationprovidertest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Element#getSingleref <em>Singleref</em>}</li>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Element#getMultirefs <em>Multirefs</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject
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
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.locationprovidertest.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Singleref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Singleref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Singleref</em>' reference.
   * @see #setSingleref(Element)
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getElement_Singleref()
   * @model
   * @generated
   */
  Element getSingleref();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.resource.locationprovidertest.Element#getSingleref <em>Singleref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Singleref</em>' reference.
   * @see #getSingleref()
   * @generated
   */
  void setSingleref(Element value);

  /**
   * Returns the value of the '<em><b>Multirefs</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.locationprovidertest.Element}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multirefs</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multirefs</em>' reference list.
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getElement_Multirefs()
   * @model
   * @generated
   */
  EList<Element> getMultirefs();

} // Element
