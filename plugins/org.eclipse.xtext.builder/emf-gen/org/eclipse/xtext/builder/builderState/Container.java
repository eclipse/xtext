/**
 * <copyright>
 * </copyright>
 *
 * $Id: Container.java,v 1.3 2009/11/25 16:24:23 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.Container#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.Container#getResourceDescriptions <em>Resource Descriptions</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.Container#getProject <em>Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
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
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getContainer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.builderState.Container#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Resource Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.resource.IResourceDescription}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.resource.IResourceDescription#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Descriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Descriptions</em>' containment reference list.
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getContainer_ResourceDescriptions()
	 * @see org.eclipse.xtext.resource.IResourceDescription#getContainer
	 * @model type="org.eclipse.xtext.builder.builderState.ResourceDescription" opposite="container" containment="true"
	 * @generated
	 */
	EList<IResourceDescription> getResourceDescriptions();

	/**
	 * Returns the value of the '<em><b>Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' attribute.
	 * @see #setProject(String)
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getContainer_Project()
	 * @model
	 * @generated
	 */
	String getProject();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.builderState.Container#getProject <em>Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' attribute.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="org.eclipse.xtext.builder.builderState.ResourceDescription" uriDataType="org.eclipse.xtext.builder.builderState.EURI"
	 * @generated
	 */
	IResourceDescription getResourceDescription(URI uri);

} // Container
