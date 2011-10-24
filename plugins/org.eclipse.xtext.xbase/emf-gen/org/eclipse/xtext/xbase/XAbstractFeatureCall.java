/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xbase;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XAbstract Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitReceiver <em>Implicit Receiver</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#isValidFeature <em>Valid Feature</em>}</li>
 *   <li>{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitFirstArgument <em>Implicit First Argument</em>}</li>
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
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(JvmIdentifiableElement)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_Feature()
	 * @model
	 * @generated
	 */
	JvmIdentifiableElement getFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(JvmIdentifiableElement value);

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
	 * Returns the value of the '<em><b>Implicit Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implicit Receiver</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implicit Receiver</em>' containment reference.
	 * @see #setImplicitReceiver(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_ImplicitReceiver()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	XExpression getImplicitReceiver();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitReceiver <em>Implicit Receiver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit Receiver</em>' containment reference.
	 * @see #getImplicitReceiver()
	 * @generated
	 */
	void setImplicitReceiver(XExpression value);

	/**
	 * Returns the value of the '<em><b>Invalid Feature Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invalid Feature Issue Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalid Feature Issue Code</em>' attribute.
	 * @see #setInvalidFeatureIssueCode(String)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_InvalidFeatureIssueCode()
	 * @model transient="true"
	 * @generated
	 */
	String getInvalidFeatureIssueCode();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getInvalidFeatureIssueCode <em>Invalid Feature Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invalid Feature Issue Code</em>' attribute.
	 * @see #getInvalidFeatureIssueCode()
	 * @generated
	 */
	void setInvalidFeatureIssueCode(String value);

	/**
	 * Returns the value of the '<em><b>Valid Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Feature</em>' attribute.
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_ValidFeature()
	 * @model transient="true" changeable="false" derived="true"
	 * @generated
	 */
	boolean isValidFeature();

	/**
	 * Returns the value of the '<em><b>Implicit First Argument</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implicit First Argument</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implicit First Argument</em>' containment reference.
	 * @see #setImplicitFirstArgument(XExpression)
	 * @see org.eclipse.xtext.xbase.XbasePackage#getXAbstractFeatureCall_ImplicitFirstArgument()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	XExpression getImplicitFirstArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xbase.XAbstractFeatureCall#getImplicitFirstArgument <em>Implicit First Argument</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implicit First Argument</em>' containment reference.
	 * @see #getImplicitFirstArgument()
	 * @generated
	 */
	void setImplicitFirstArgument(XExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	String getConcreteSyntaxFeatureName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<XExpression> getExplicitArguments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isExplicitOperationCallOrBuilderSyntax();

} // XAbstractFeatureCall
