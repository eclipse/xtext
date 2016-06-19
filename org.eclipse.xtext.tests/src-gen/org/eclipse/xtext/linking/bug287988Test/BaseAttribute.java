/**
 */
package org.eclipse.xtext.linking.bug287988Test;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.linking.bug287988Test.Bug287988TestPackage#getBaseAttribute()
 * @model
 * @generated
 */
public interface BaseAttribute extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Ref</em>' reference.
   * @see #setTypeRef(BaseAttribute)
   * @see org.eclipse.xtext.linking.bug287988Test.Bug287988TestPackage#getBaseAttribute_TypeRef()
   * @model
   * @generated
   */
  BaseAttribute getTypeRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getTypeRef <em>Type Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Ref</em>' reference.
   * @see #getTypeRef()
   * @generated
   */
  void setTypeRef(BaseAttribute value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.eclipse.xtext.linking.bug287988Test.Bug287988TestPackage#getBaseAttribute_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

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
   * @see org.eclipse.xtext.linking.bug287988Test.Bug287988TestPackage#getBaseAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // BaseAttribute
