/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.SingleRef#getObj <em>Obj</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.SingleRef#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getSingleRef()
 * @model
 * @generated
 */
public interface SingleRef extends Model
{
  /**
   * Returns the value of the '<em><b>Obj</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Obj</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Obj</em>' containment reference.
   * @see #setObj(RefObj)
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getSingleRef_Obj()
   * @model containment="true"
   * @generated
   */
  RefObj getObj();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.SingleRef#getObj <em>Obj</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Obj</em>' containment reference.
   * @see #getObj()
   * @generated
   */
  void setObj(RefObj value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(RefObj)
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getSingleRef_Ref()
   * @model
   * @generated
   */
  RefObj getRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.SingleRef#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(RefObj value);

} // SingleRef
