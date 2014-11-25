/**
 */
package org.eclipse.xtext.resource.locationprovidertest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Bus#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getBus()
 * @model
 * @generated
 */
public interface Bus extends Component
{
  /**
   * Returns the value of the '<em><b>Port</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.locationprovidertest.Port}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port</em>' containment reference list.
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getBus_Port()
   * @model containment="true"
   * @generated
   */
  EList<Port> getPort();

} // Bus
