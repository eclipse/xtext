/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtype;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XWildcard Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.XWildcardParam#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XWildcardParam#getSuper <em>Super</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getXWildcardParam()
 * @model
 * @generated
 */
public interface XWildcardParam extends XTypeRef
{
  /**
   * Returns the value of the '<em><b>Extends</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extends</em>' containment reference.
   * @see #setExtends(XTypeRef)
   * @see org.eclipse.xtext.xtype.XtypePackage#getXWildcardParam_Extends()
   * @model containment="true"
   * @generated
   */
  XTypeRef getExtends();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtype.XWildcardParam#getExtends <em>Extends</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extends</em>' containment reference.
   * @see #getExtends()
   * @generated
   */
  void setExtends(XTypeRef value);

  /**
   * Returns the value of the '<em><b>Super</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Super</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Super</em>' containment reference.
   * @see #setSuper(XTypeRef)
   * @see org.eclipse.xtext.xtype.XtypePackage#getXWildcardParam_Super()
   * @model containment="true"
   * @generated
   */
  XTypeRef getSuper();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.xtype.XWildcardParam#getSuper <em>Super</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Super</em>' containment reference.
   * @see #getSuper()
   * @generated
   */
  void setSuper(XTypeRef value);

} // XWildcardParam
