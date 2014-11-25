/**
 */
package org.eclipse.xtext.parsetree.reconstr.simplerewritetest;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef#getObj <em>Obj</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef#getRef <em>Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getEObjectRef()
 * @model
 * @generated
 */
public interface EObjectRef extends Expression
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
   * @see #setObj(EObjectElement)
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getEObjectRef_Obj()
   * @model containment="true"
   * @generated
   */
  EObjectElement getObj();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef#getObj <em>Obj</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Obj</em>' containment reference.
   * @see #getObj()
   * @generated
   */
  void setObj(EObjectElement value);

  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(EObject)
   * @see org.eclipse.xtext.parsetree.reconstr.simplerewritetest.SimplerewritetestPackage#getEObjectRef_Ref()
   * @model
   * @generated
   */
  EObject getRef();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.simplerewritetest.EObjectRef#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(EObject value);

} // EObjectRef
