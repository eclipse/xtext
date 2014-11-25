/**
 */
package org.eclipse.xtext.valueconverter.bug250313;

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
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.Model#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.Model#getMultiValue <em>Multi Value</em>}</li>
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.Model#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.xtext.valueconverter.bug250313.Model#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Package#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Package#getModel_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.valueconverter.bug250313.Model#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Multi Value</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multi Value</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multi Value</em>' attribute list.
   * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Package#getModel_MultiValue()
   * @model unique="false"
   * @generated
   */
  EList<String> getMultiValue();

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference.
   * @see #setChildren(Child)
   * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Package#getModel_Children()
   * @model containment="true"
   * @generated
   */
  Child getChildren();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.valueconverter.bug250313.Model#getChildren <em>Children</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Children</em>' containment reference.
   * @see #getChildren()
   * @generated
   */
  void setChildren(Child value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Child)
   * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Package#getModel_Ref()
   * @model
   * @generated
   */
  Child getRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.valueconverter.bug250313.Model#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Child value);

} // Model
