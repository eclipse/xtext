/**
 */
package org.eclipse.xtext.linking.bug287988Test;

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
 *   <li>{@link org.eclipse.xtext.linking.bug287988Test.Model#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.bug287988Test.Bug287988TestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see org.eclipse.xtext.linking.bug287988Test.Bug287988TestPackage#getModel_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<BaseAttribute> getAttributes();

} // Model
