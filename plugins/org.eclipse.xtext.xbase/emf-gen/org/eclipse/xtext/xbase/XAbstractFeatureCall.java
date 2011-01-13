/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAbstract Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitReceiver <em>Implicit Receiver</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#isTargetsMemberSyntaxCall <em>Targets Member Syntax Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall()
 * @model abstract="true"
 * @generated
 */
public interface XAbstractFeatureCall extends XExpression
{
	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_FeatureName()
	 * @model changeable="false" derived="true"
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_Arguments()
	 * @model changeable="false" derived="true"
	 * @generated
	 */
	EList<XExpression> getArguments();

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(JvmIdentifyableElement)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_Feature()
	 * @model
	 * @generated
	 */
	JvmIdentifyableElement getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(JvmIdentifyableElement value);

	/**
	 * Returns the value of the '<em><b>Type Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_TypeArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getTypeArguments();

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
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_ImplicitReceiver()
	 * @model transient="true" derived="true"
	 * @generated
	 */
	JvmIdentifyableElement getImplicitReceiver();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitReceiver <em>Implicit Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit Receiver</em>' reference.
	 * @see #getImplicitReceiver()
	 * @generated
	 */
	void setImplicitReceiver(JvmIdentifyableElement value);

	/**
	 * Returns the value of the '<em><b>Targets Member Syntax Call</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets Member Syntax Call</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets Member Syntax Call</em>' attribute.
	 * @see #setTargetsMemberSyntaxCall(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_TargetsMemberSyntaxCall()
	 * @model default="true" transient="true"
	 * @generated
	 */
	boolean isTargetsMemberSyntaxCall();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#isTargetsMemberSyntaxCall <em>Targets Member Syntax Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Targets Member Syntax Call</em>' attribute.
	 * @see #isTargetsMemberSyntaxCall()
	 * @generated
	 */
	void setTargetsMemberSyntaxCall(boolean value);

} // XAbstractFeatureCall
