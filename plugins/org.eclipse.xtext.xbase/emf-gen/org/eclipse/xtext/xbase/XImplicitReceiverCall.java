/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmIdentifyableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XImplicit Receiver Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XImplicitReceiverCall#getImplicitReceiver <em>Implicit Receiver</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXImplicitReceiverCall()
 * @model
 * @generated
 */
public interface XImplicitReceiverCall extends EObject
{
	/**
	 * Returns the value of the '<em><b>Implicit Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implicit Receiver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implicit Receiver</em>' reference.
	 * @see #setImplicitReceiver(JvmIdentifyableElement)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXImplicitReceiverCall_ImplicitReceiver()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	JvmIdentifyableElement getImplicitReceiver();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XImplicitReceiverCall#getImplicitReceiver <em>Implicit Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit Receiver</em>' reference.
	 * @see #getImplicitReceiver()
	 * @generated
	 */
	void setImplicitReceiver(JvmIdentifyableElement value);

} // XImplicitReceiverCall
