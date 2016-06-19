/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationerror;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getReq <em>Req</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getOpt <em>Opt</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getIndent <em>Indent</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage#getIndent()
 * @model
 * @generated
 */
public interface Indent extends Test
{
  /**
   * Returns the value of the '<em><b>Req</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Req</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Req</em>' containment reference.
   * @see #setReq(TwoRequired)
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage#getIndent_Req()
   * @model containment="true"
   * @generated
   */
  TwoRequired getReq();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getReq <em>Req</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Req</em>' containment reference.
   * @see #getReq()
   * @generated
   */
  void setReq(TwoRequired value);

  /**
   * Returns the value of the '<em><b>Opt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Opt</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opt</em>' containment reference.
   * @see #setOpt(TwoOptions)
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage#getIndent_Opt()
   * @model containment="true"
   * @generated
   */
  TwoOptions getOpt();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getOpt <em>Opt</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opt</em>' containment reference.
   * @see #getOpt()
   * @generated
   */
  void setOpt(TwoOptions value);

  /**
   * Returns the value of the '<em><b>Indent</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Indent</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Indent</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorPackage#getIndent_Indent()
   * @model containment="true"
   * @generated
   */
  EList<Indent> getIndent();

} // Indent
