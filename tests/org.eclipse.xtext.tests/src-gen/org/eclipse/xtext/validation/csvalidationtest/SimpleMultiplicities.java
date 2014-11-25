/**
 */
package org.eclipse.xtext.validation.csvalidationtest;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Multiplicities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities#getVal1 <em>Val1</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities#getVal2 <em>Val2</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities#getVal3 <em>Val3</em>}</li>
 *   <li>{@link org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities#getVal4 <em>Val4</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getSimpleMultiplicities()
 * @model
 * @generated
 */
public interface SimpleMultiplicities extends EObject
{
  /**
   * Returns the value of the '<em><b>Val1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val1</em>' attribute.
   * @see #setVal1(String)
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getSimpleMultiplicities_Val1()
   * @model
   * @generated
   */
  String getVal1();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities#getVal1 <em>Val1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val1</em>' attribute.
   * @see #getVal1()
   * @generated
   */
  void setVal1(String value);

  /**
   * Returns the value of the '<em><b>Val2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val2</em>' attribute.
   * @see #setVal2(String)
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getSimpleMultiplicities_Val2()
   * @model
   * @generated
   */
  String getVal2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.validation.csvalidationtest.SimpleMultiplicities#getVal2 <em>Val2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val2</em>' attribute.
   * @see #getVal2()
   * @generated
   */
  void setVal2(String value);

  /**
   * Returns the value of the '<em><b>Val3</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val3</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val3</em>' attribute list.
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getSimpleMultiplicities_Val3()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal3();

  /**
   * Returns the value of the '<em><b>Val4</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val4</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val4</em>' attribute list.
   * @see org.eclipse.xtext.validation.csvalidationtest.CsvalidationtestPackage#getSimpleMultiplicities_Val4()
   * @model unique="false"
   * @generated
   */
  EList<String> getVal4();

} // SimpleMultiplicities
