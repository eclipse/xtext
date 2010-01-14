/**
 * <copyright>
 * </copyright>
 *
 * $Id: WildcardParam.java,v 1.1 2010/01/14 14:40:17 sefftinge Exp $
 */
package org.eclipse.xtext.xtype;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wildcard Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.WildcardParam#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.WildcardParam#getSuper <em>Super</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getWildcardParam()
 * @model
 * @generated
 */
public interface WildcardParam extends TypeRef {
	/**
	 * Returns the value of the '<em><b>Extends</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' containment reference.
	 * @see #setExtends(TypeRef)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getWildcardParam_Extends()
	 * @model containment="true"
	 * @generated
	 */
	TypeRef getExtends();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.WildcardParam#getExtends <em>Extends</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' containment reference.
	 * @see #getExtends()
	 * @generated
	 */
	void setExtends(TypeRef value);

	/**
	 * Returns the value of the '<em><b>Super</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' containment reference.
	 * @see #setSuper(TypeRef)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getWildcardParam_Super()
	 * @model containment="true"
	 * @generated
	 */
	TypeRef getSuper();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.WildcardParam#getSuper <em>Super</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super</em>' containment reference.
	 * @see #getSuper()
	 * @generated
	 */
	void setSuper(TypeRef value);

} // WildcardParam
