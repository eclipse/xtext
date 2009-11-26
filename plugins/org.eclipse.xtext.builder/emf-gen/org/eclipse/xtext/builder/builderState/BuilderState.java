/**
 * <copyright>
 * </copyright>
 *
 * $Id: BuilderState.java,v 1.2 2009/11/26 09:56:28 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Builder State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.BuilderState#getResourceDescriptions <em>Resource Descriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getBuilderState()
 * @model
 * @generated
 */
public interface BuilderState extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.resource.IResourceDescription}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Descriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Descriptions</em>' containment reference list.
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getBuilderState_ResourceDescriptions()
	 * @model type="org.eclipse.xtext.builder.builderState.ResourceDescription" containment="true"
	 * @generated
	 */
	EList<IResourceDescription> getResourceDescriptions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="org.eclipse.xtext.builder.builderState.ResourceDescription" uriDataType="org.eclipse.xtext.builder.builderState.EURI"
	 * @generated
	 */
	IResourceDescription getResourceDescription(URI uri);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="org.eclipse.xtext.builder.builderState.ResourceDescription"
	 * @generated
	 */
	IResourceDescription getResourceDescriptionForStorage(String externalStorageForm);

} // BuilderState
