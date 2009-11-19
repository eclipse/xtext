/**
 * <copyright>
 * </copyright>
 *
 * $Id: BuilderState.java,v 1.1 2009/11/19 08:39:59 sefftinge Exp $
 */
package org.eclipse.xtext.builder.builderState;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Builder State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.builder.builderState.BuilderState#getContainers <em>Containers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getBuilderState()
 * @model
 * @generated
 */
public interface BuilderState extends EObject {
	/**
	 * Returns the value of the '<em><b>Containers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.builder.builderState.Container}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containers</em>' containment reference list.
	 * @see org.eclipse.xtext.builder.builderState.BuilderStatePackage#getBuilderState_Containers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Container> getContainers();

} // BuilderState
