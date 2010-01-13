/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.example.gmf.entities;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.example.gmf.entities.SimpleProperty#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.example.gmf.entities.EntitiesPackage#getSimpleProperty()
 * @model
 * @generated
 */
public interface SimpleProperty extends Property
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(SimpleType)
   * @see org.eclipse.xtext.example.gmf.entities.EntitiesPackage#getSimpleProperty_Type()
   * @model
   * @generated
   */
  SimpleType getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.example.gmf.entities.SimpleProperty#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(SimpleType value);

} // SimpleProperty
