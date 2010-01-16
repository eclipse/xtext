/**
 * <copyright>
 * </copyright>
 *
 * $Id: XTypeParamDeclaration.java,v 1.1 2010/01/16 08:50:52 sefftinge Exp $
 */
package org.eclipse.xtext.xtype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XType Param Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtype.XTypeParamDeclaration#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XTypeParamDeclaration#getSuper <em>Super</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtype.XTypeParamDeclaration#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtype.XtypePackage#getXTypeParamDeclaration()
 * @model
 * @generated
 */
public interface XTypeParamDeclaration extends Type {
	/**
	 * Returns the value of the '<em><b>Extends</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xtype.XTypeRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' containment reference list.
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXTypeParamDeclaration_Extends()
	 * @model containment="true"
	 * @generated
	 */
	EList<XTypeRef> getExtends();

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
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXTypeParamDeclaration_Super()
	 * @model containment="true"
	 * @generated
	 */
	XTypeRef getSuper();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XTypeParamDeclaration#getSuper <em>Super</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super</em>' containment reference.
	 * @see #getSuper()
	 * @generated
	 */
	void setSuper(XTypeRef value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtext.xtype.XtypePackage#getXTypeParamDeclaration_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtype.XTypeParamDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // XTypeParamDeclaration
