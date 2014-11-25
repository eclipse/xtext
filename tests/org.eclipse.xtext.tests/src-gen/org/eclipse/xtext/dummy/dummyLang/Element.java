/**
 */
package org.eclipse.xtext.dummy.dummyLang;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.dummy.dummyLang.Element#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.eclipse.xtext.dummy.dummyLang.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.dummy.dummyLang.Element#getDescriptions <em>Descriptions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.dummy.dummyLang.DummyLangPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject
{
  /**
   * Returns the value of the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Optional</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Optional</em>' attribute.
   * @see #setOptional(boolean)
   * @see org.eclipse.xtext.dummy.dummyLang.DummyLangPackage#getElement_Optional()
   * @model
   * @generated
   */
  boolean isOptional();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.dummy.dummyLang.Element#isOptional <em>Optional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Optional</em>' attribute.
   * @see #isOptional()
   * @generated
   */
  void setOptional(boolean value);

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
   * @see org.eclipse.xtext.dummy.dummyLang.DummyLangPackage#getElement_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.dummy.dummyLang.Element#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Descriptions</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Descriptions</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Descriptions</em>' attribute list.
   * @see org.eclipse.xtext.dummy.dummyLang.DummyLangPackage#getElement_Descriptions()
   * @model unique="false"
   * @generated
   */
  EList<String> getDescriptions();

} // Element
