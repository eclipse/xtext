/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmDeclaredType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XFeature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XFeatureCall#getFeatureCallArguments <em>Feature Call Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XFeatureCall#getDeclaringType <em>Declaring Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xbase.XbasePackage#getXFeatureCall()
 * @model
 * @generated
 */
public interface XFeatureCall extends XAbstractFeatureCall
{
	/**
	 * Returns the value of the '<em><b>Feature Call Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Call Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Call Arguments</em>' containment reference list.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFeatureCall_FeatureCallArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getFeatureCallArguments();

	/**
	 * Returns the value of the '<em><b>Explicit Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit Operation Call</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit Operation Call</em>' attribute.
	 * @see #setExplicitOperationCall(boolean)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFeatureCall_ExplicitOperationCall()
	 * @model
	 * @generated
	 */
	boolean isExplicitOperationCall();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XFeatureCall#isExplicitOperationCall <em>Explicit Operation Call</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit Operation Call</em>' attribute.
	 * @see #isExplicitOperationCall()
	 * @generated
	 */
	void setExplicitOperationCall(boolean value);

	/**
	 * Returns the value of the '<em><b>Declaring Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaring Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaring Type</em>' reference.
	 * @see #setDeclaringType(JvmDeclaredType)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXFeatureCall_DeclaringType()
	 * @model
	 * @generated
	 */
	JvmDeclaredType getDeclaringType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XFeatureCall#getDeclaringType <em>Declaring Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaring Type</em>' reference.
	 * @see #getDeclaringType()
	 * @generated
	 */
	void setDeclaringType(JvmDeclaredType value);

} // XFeatureCall
