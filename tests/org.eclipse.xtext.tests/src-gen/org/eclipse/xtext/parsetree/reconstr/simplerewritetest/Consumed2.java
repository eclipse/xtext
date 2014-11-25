/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consumed2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getConsumed2()
 * @model
 * @generated
 */
public interface Consumed2 extends Expression
{
  /**
   * Returns the value of the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Child</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference.
   * @see #setChild(Consumed1)
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getConsumed2_Child()
   * @model containment="true"
   * @generated
   */
  Consumed1 getChild();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.Consumed2#getChild <em>Child</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Child</em>' containment reference.
   * @see #getChild()
   * @generated
   */
  void setChild(Consumed1 value);

} // Consumed2
