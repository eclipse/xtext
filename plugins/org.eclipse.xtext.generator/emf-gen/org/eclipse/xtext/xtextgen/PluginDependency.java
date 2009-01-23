/**
 * <copyright>
 * </copyright>
 *
 * $Id: PluginDependency.java,v 1.1 2009/01/23 14:12:00 jkohnlein Exp $
 */
package org.eclipse.xtext.xtextgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtextgen.PluginDependency#getBundleID <em>Bundle ID</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.PluginDependency#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.PluginDependency#isReexport <em>Reexport</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtextgen.PluginDependency#isOptional <em>Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getPluginDependency()
 * @model
 * @generated
 */
public interface PluginDependency extends EObject {
	/**
	 * Returns the value of the '<em><b>Bundle ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle ID</em>' attribute.
	 * @see #setBundleID(String)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getPluginDependency_BundleID()
	 * @model
	 * @generated
	 */
	String getBundleID();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.PluginDependency#getBundleID <em>Bundle ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle ID</em>' attribute.
	 * @see #getBundleID()
	 * @generated
	 */
	void setBundleID(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getPluginDependency_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.PluginDependency#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Reexport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reexport</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reexport</em>' attribute.
	 * @see #setReexport(boolean)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getPluginDependency_Reexport()
	 * @model
	 * @generated
	 */
	boolean isReexport();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.PluginDependency#isReexport <em>Reexport</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reexport</em>' attribute.
	 * @see #isReexport()
	 * @generated
	 */
	void setReexport(boolean value);

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see org.eclipse.xtext.xtextgen.XtextgenPackage#getPluginDependency_Optional()
	 * @model
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtextgen.PluginDependency#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

} // PluginDependency
