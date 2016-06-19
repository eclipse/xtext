/**
 */
package org.eclipse.xtext.xtextTest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextTest.AbstractRule#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.AbstractRule#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextTest.AbstractRule#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getAbstractRule()
 * @model
 * @generated
 */
public interface AbstractRule extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeRef)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getAbstractRule_Type()
   * @model containment="true"
   * @generated
   */
  TypeRef getType();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.AbstractRule#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeRef value);

  /**
   * Returns the value of the '<em><b>Alternatives</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alternatives</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alternatives</em>' containment reference.
   * @see #setAlternatives(AbstractElement)
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getAbstractRule_Alternatives()
   * @model containment="true"
   * @generated
   */
  AbstractElement getAlternatives();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.AbstractRule#getAlternatives <em>Alternatives</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alternatives</em>' containment reference.
   * @see #getAlternatives()
   * @generated
   */
  void setAlternatives(AbstractElement value);

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
   * @see org.eclipse.xtext.xtextTest.XtextTestPackage#getAbstractRule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtextTest.AbstractRule#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // AbstractRule
