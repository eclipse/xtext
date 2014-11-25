/**
 */
package org.eclipse.xtext.linking.lazy.bug311337;

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
 *   <li>{@link org.eclipse.xtext.linking.lazy.bug311337.Model#getDef <em>Def</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Def</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.lazy.bug311337.Definition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Def</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Def</em>' containment reference list.
   * @see org.eclipse.xtext.linking.lazy.bug311337.Bug311337Package#getModel_Def()
   * @model containment="true"
   * @generated
   */
  EList<Definition> getDef();

} // Model
