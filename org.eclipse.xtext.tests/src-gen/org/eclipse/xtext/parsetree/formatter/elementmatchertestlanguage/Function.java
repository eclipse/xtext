/**
 */
package org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function#getFunc <em>Func</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function#getParam <em>Param</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends Expression
{
  /**
   * Returns the value of the '<em><b>Func</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Func</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Func</em>' attribute.
   * @see #setFunc(String)
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getFunction_Func()
   * @model
   * @generated
   */
  String getFunc();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function#getFunc <em>Func</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Func</em>' attribute.
   * @see #getFunc()
   * @generated
   */
  void setFunc(String value);

  /**
   * Returns the value of the '<em><b>Param</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage#getFunction_Param()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getParam();

} // Function
