/**
 */
package org.eclipse.xtext.resource.locationprovidertest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.resource.locationprovidertest.Processor#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getProcessor()
 * @model
 * @generated
 */
public interface Processor extends Component
{
  /**
   * Returns the value of the '<em><b>Data</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.resource.locationprovidertest.Data}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data</em>' containment reference list.
   * @see org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage#getProcessor_Data()
   * @model containment="true"
   * @generated
   */
  EList<Data> getData();

} // Processor
