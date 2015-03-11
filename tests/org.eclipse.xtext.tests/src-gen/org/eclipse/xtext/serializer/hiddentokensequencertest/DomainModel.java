/**
 */
package org.eclipse.xtext.serializer.hiddentokensequencertest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.serializer.hiddentokensequencertest.DomainModel#getEntities <em>Entities</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.serializer.hiddentokensequencertest.HiddentokensequencertestPackage#getDomainModel()
 * @model
 * @generated
 */
public interface DomainModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.serializer.hiddentokensequencertest.Entity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entities</em>' containment reference list.
   * @see org.eclipse.xtext.serializer.hiddentokensequencertest.HiddentokensequencertestPackage#getDomainModel_Entities()
   * @model containment="true"
   * @generated
   */
  EList<Entity> getEntities();

} // DomainModel
