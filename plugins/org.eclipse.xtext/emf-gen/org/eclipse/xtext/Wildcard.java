/**
 * <copyright>
 * </copyright>
 *
 * $Id: Wildcard.java,v 1.1 2009/01/19 14:39:52 szarnekow Exp $
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wildcard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.Wildcard#isIsWildcard <em>Is Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.XtextPackage#getWildcard()
 * @model
 * @generated
 */
public interface Wildcard extends AbstractElement {

	/**
	 * Returns the value of the '<em><b>Is Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Wildcard</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Wildcard</em>' attribute.
	 * @see #setIsWildcard(boolean)
	 * @see org.eclipse.xtext.XtextPackage#getWildcard_IsWildcard()
	 * @model
	 * @generated
	 */
	boolean isIsWildcard();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.Wildcard#isIsWildcard <em>Is Wildcard</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Wildcard</em>' attribute.
	 * @see #isIsWildcard()
	 * @generated
	 */
	void setIsWildcard(boolean value);
} // Wildcard
