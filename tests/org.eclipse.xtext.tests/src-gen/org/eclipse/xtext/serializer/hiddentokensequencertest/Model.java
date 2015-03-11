/**
 */
package org.eclipse.xtext.serializer.hiddentokensequencertest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.hiddentokensequencertest.Model#getDomainModel <em>Domain Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.hiddentokensequencertest.HiddentokensequencertestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Domain Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Domain Model</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Domain Model</em>' containment reference.
   * @see #setDomainModel(DomainModel)
   * @see org.eclipse.xtext.serializer.hiddentokensequencertest.HiddentokensequencertestPackage#getModel_DomainModel()
   * @model containment="true"
   * @generated
   */
  DomainModel getDomainModel();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.serializer.hiddentokensequencertest.Model#getDomainModel <em>Domain Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Domain Model</em>' containment reference.
   * @see #getDomainModel()
   * @generated
   */
  void setDomainModel(DomainModel value);

} // Model
