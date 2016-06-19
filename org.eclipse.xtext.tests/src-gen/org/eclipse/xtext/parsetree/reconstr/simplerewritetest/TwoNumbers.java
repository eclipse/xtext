/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Two Numbers</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum1 <em>Num1</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum2 <em>Num2</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum3 <em>Num3</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getTwoNumbers()
 * @model
 * @generated
 */
public interface TwoNumbers extends Expression
{
  /**
   * Returns the value of the '<em><b>Num1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Num1</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num1</em>' attribute.
   * @see #setNum1(int)
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getTwoNumbers_Num1()
   * @model
   * @generated
   */
  int getNum1();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum1 <em>Num1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num1</em>' attribute.
   * @see #getNum1()
   * @generated
   */
  void setNum1(int value);

  /**
   * Returns the value of the '<em><b>Num2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Num2</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num2</em>' attribute.
   * @see #setNum2(int)
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getTwoNumbers_Num2()
   * @model
   * @generated
   */
  int getNum2();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.TwoNumbers#getNum2 <em>Num2</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Num2</em>' attribute.
   * @see #getNum2()
   * @generated
   */
  void setNum2(int value);

  /**
   * Returns the value of the '<em><b>Num3</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Num3</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Num3</em>' attribute list.
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getTwoNumbers_Num3()
   * @model unique="false"
   * @generated
   */
  EList<Integer> getNum3();

} // TwoNumbers
