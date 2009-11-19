/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResourceDescriptor.java,v 1.1 2009/11/19 08:39:59 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.ResourceDescriptor#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.ResourceDescriptor#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.ResourceDescriptor#getEObjectDescriptions <em>EObject Descriptions</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.ResourceDescriptor#getImportedNames <em>Imported Names</em>}</li>
 *   <li>{@link org.eclipse.xtext.builder.builderState.ResourceDescriptor#getPathToStorage <em>Path To Storage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getResourceDescriptor()
 * @model
 * @generated
 */
public interface ResourceDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URI</em>' attribute.
	 * @see #setURI(URI)
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getResourceDescriptor_URI()
	 * @model dataType="org.eclipse.xtext.builder.builderState.EURI" required="true"
	 * @generated
	 */
	URI getURI();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.builderState.ResourceDescriptor#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(URI value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.builder.builderState.Container#getResourceDescriptors <em>Resource Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Container)
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getResourceDescriptor_Container()
	 * @see org.eclipse.xtext.builder.builderState.Container#getResourceDescriptors
	 * @model opposite="resourceDescriptors" transient="false"
	 * @generated
	 */
	Container getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.builderState.ResourceDescriptor#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Container value);

	/**
	 * Returns the value of the '<em><b>EObject Descriptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.resource.IEObjectDescription}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.resource.IEObjectDescription#getResourceDescriptor <em>Resource Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EObject Descriptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EObject Descriptions</em>' containment reference list.
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getResourceDescriptor_EObjectDescriptions()
	 * @see org.eclipse.xtext.resource.IEObjectDescription#getResourceDescriptor
	 * @model type="org.eclipse.xtext.builder.builderState.EObjectDescription" opposite="resourceDescriptor" containment="true"
	 * @generated
	 */
	EList<IEObjectDescription> getEObjectDescriptions();

	/**
	 * Returns the value of the '<em><b>Imported Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imported Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imported Names</em>' attribute list.
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getResourceDescriptor_ImportedNames()
	 * @model
	 * @generated
	 */
	EList<String> getImportedNames();

	/**
	 * Returns the value of the '<em><b>Path To Storage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path To Storage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path To Storage</em>' attribute.
	 * @see #setPathToStorage(String)
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getResourceDescriptor_PathToStorage()
	 * @model
	 * @generated
	 */
	String getPathToStorage();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.builder.builderState.ResourceDescriptor#getPathToStorage <em>Path To Storage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path To Storage</em>' attribute.
	 * @see #getPathToStorage()
	 * @generated
	 */
	void setPathToStorage(String value);

} // ResourceDescriptor
