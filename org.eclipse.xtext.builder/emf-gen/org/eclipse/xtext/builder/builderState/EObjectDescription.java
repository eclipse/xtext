/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EObject Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.EObjectDescription#getFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.EObjectDescription#getUserData <em>User Data</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getEObjectDescription()
 * @model superTypes="org.eclipse.xtext.builder.builderState.IEObjectDescription"
 * @generated
 */
public interface EObjectDescription extends EObject, IEObjectDescription {
	/**
	 * Returns the value of the '<em><b>Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment</em>' attribute.
	 * @see #setFragment(String)
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getEObjectDescription_Fragment()
	 * @model required="true"
	 * @generated
	 */
	String getFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.builderState.EObjectDescription#getFragment <em>Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fragment</em>' attribute.
	 * @see #getFragment()
	 * @generated
	 */
	void setFragment(String value);

	/**
	 * Returns the value of the '<em><b>User Data</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Data</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Data</em>' map.
	 * @see #isSetUserData()
	 * @see #unsetUserData()
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getEObjectDescription_UserData()
	 * @model mapType="org.eclipse.xtext.builder.builderState.UserDataEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getUserData();

	/**
	 * Unsets the value of the '{@link org.eclipse.xtext.builder.builderState.EObjectDescription#getUserData <em>User Data</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUserData()
	 * @see #getUserData()
	 * @generated
	 */
	void unsetUserData();

	/**
	 * Returns whether the value of the '{@link org.eclipse.xtext.builder.builderState.EObjectDescription#getUserData <em>User Data</em>}' map is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>User Data</em>' map is set.
	 * @see #unsetUserData()
	 * @see #getUserData()
	 * @generated
	 */
	boolean isSetUserData();

} // EObjectDescription
