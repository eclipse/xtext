/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.ecoreReference;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.Model#getExtends <em>Extends</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferencePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Extends</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' containment reference list.
   * @see org.eclipse.xtext.metamodelreferencing.tests.ecoreReference.EcoreReferencePackage#getModel_Extends()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getExtends();

} // Model
