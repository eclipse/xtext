/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TypeB#getX <em>X</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTypeB()
 * @model
 * @generated
 */
public interface TypeB extends TypeA1
{
  /**
   * Returns the value of the '<em><b>X</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>X</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>X</em>' containment reference.
   * @see #setX(TypeD)
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTypeB_X()
   * @model containment="true"
   * @generated
   */
  TypeD getX();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TypeB#getX <em>X</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>X</em>' containment reference.
   * @see #getX()
   * @generated
   */
  void setX(TypeD value);

} // TypeB
