/**
 * <copyright>
 * </copyright>
 *
 * $Id: Outlet.java,v 1.1 2008/07/14 08:15:32 sefftinge Exp $
 */
package org.eclipse.xtext.xtextgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outlet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.Outlet#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.Outlet#getTargetFolder <em>Target Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getOutlet()
 * @model
 * @generated
 */
public interface Outlet extends EObject {
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
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getOutlet_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.Outlet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Target Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Folder</em>' attribute.
	 * @see #setTargetFolder(String)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getOutlet_TargetFolder()
	 * @model
	 * @generated
	 */
	String getTargetFolder();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.Outlet#getTargetFolder <em>Target Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Folder</em>' attribute.
	 * @see #getTargetFolder()
	 * @generated
	 */
	void setTargetFolder(String value);

} // Outlet
