/**
 */
package org.eclipse.xtext.parsetree.reconstr.complexrewritetest;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tricky G1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG1#getVals <em>Vals</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyG1()
 * @model
 * @generated
 */
public interface TrickyG1 extends TrickyG2
{
  /**
   * Returns the value of the '<em><b>Vals</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG2}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vals</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vals</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage#getTrickyG1_Vals()
   * @model containment="true"
   * @generated
   */
  EList<TrickyG2> getVals();

} // TrickyG1
