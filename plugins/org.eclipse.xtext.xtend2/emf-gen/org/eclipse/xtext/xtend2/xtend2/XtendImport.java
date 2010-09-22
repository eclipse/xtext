/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtend Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendImport#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendImport#isWildcard <em>Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendImport()
 * @model
 * @generated
 */
public interface XtendImport extends EObject
{
	/**
	 * Returns the value of the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Namespace</em>' attribute.
	 * @see #setImportedNamespace(String)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendImport_ImportedNamespace()
	 * @model
	 * @generated
	 */
	String getImportedNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendImport#getImportedNamespace <em>Imported Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Imported Namespace</em>' attribute.
	 * @see #getImportedNamespace()
	 * @generated
	 */
	void setImportedNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wildcard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wildcard</em>' attribute.
	 * @see #setWildcard(boolean)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendImport_Wildcard()
	 * @model
	 * @generated
	 */
	boolean isWildcard();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendImport#isWildcard <em>Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wildcard</em>' attribute.
	 * @see #isWildcard()
	 * @generated
	 */
	void setWildcard(boolean value);

} // XtendImport
