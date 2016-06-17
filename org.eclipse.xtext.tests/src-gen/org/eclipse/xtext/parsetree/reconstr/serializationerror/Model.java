/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationerror;

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
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Model#getTest <em>Test</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Test</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Test</em>' containment reference.
   * @see #setTest(Test)
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage#getModel_Test()
   * @model containment="true"
   * @generated
   */
  Test getTest();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Model#getTest <em>Test</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Test</em>' containment reference.
   * @see #getTest()
   * @generated
   */
  void setTest(Test value);

} // Model
