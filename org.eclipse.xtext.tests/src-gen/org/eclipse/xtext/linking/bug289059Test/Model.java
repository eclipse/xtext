/**
 */
package org.eclipse.xtext.linking.bug289059Test;

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
 *   <li>{@link org.eclipse.xtext.linking.bug289059Test.Model#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug289059Test.Model#getEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug289059Test.Model#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.bug289059Test.Bug289059TestPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
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
   * @see org.eclipse.xtext.linking.bug289059Test.Bug289059TestPackage#getModel_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug289059Test.Model#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enabled</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enabled</em>' containment reference.
   * @see #setEnabled(UnassignedAction)
   * @see org.eclipse.xtext.linking.bug289059Test.Bug289059TestPackage#getModel_Enabled()
   * @model containment="true"
   * @generated
   */
  UnassignedAction getEnabled();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug289059Test.Model#getEnabled <em>Enabled</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enabled</em>' containment reference.
   * @see #getEnabled()
   * @generated
   */
  void setEnabled(UnassignedAction value);

  /**
   * Returns the value of the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' reference.
   * @see #setReference(Model)
   * @see org.eclipse.xtext.linking.bug289059Test.Bug289059TestPackage#getModel_Reference()
   * @model
   * @generated
   */
  Model getReference();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug289059Test.Model#getReference <em>Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' reference.
   * @see #getReference()
   * @generated
   */
  void setReference(Model value);

} // Model
