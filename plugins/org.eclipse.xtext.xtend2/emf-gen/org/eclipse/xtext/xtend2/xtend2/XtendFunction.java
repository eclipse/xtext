/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xtend Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#isOverride <em>Override</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#isDispatch <em>Dispatch</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getCreateExtensionInfo <em>Create Extension Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendFunction()
 * @model
 * @generated
 */
public interface XtendFunction extends XtendMember, JvmTypeParameterDeclarator
{
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(XExpression)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendFunction_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JvmTypeReference)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendFunction_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	JvmTypeReference getReturnType();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JvmTypeReference value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmFormalParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendFunction_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmFormalParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Override</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Override</em>' attribute.
	 * @see #setOverride(boolean)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendFunction_Override()
	 * @model
	 * @generated
	 */
	boolean isOverride();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#isOverride <em>Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Override</em>' attribute.
	 * @see #isOverride()
	 * @generated
	 */
	void setOverride(boolean value);

	/**
	 * Returns the value of the '<em><b>Dispatch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dispatch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dispatch</em>' attribute.
	 * @see #setDispatch(boolean)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendFunction_Dispatch()
	 * @model
	 * @generated
	 */
	boolean isDispatch();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#isDispatch <em>Dispatch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dispatch</em>' attribute.
	 * @see #isDispatch()
	 * @generated
	 */
	void setDispatch(boolean value);

	/**
	 * Returns the value of the '<em><b>Create Extension Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Extension Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Extension Info</em>' containment reference.
	 * @see #setCreateExtensionInfo(CreateExtensionInfo)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getXtendFunction_CreateExtensionInfo()
	 * @model containment="true"
	 * @generated
	 */
	CreateExtensionInfo getCreateExtensionInfo();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.XtendFunction#getCreateExtensionInfo <em>Create Extension Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Extension Info</em>' containment reference.
	 * @see #getCreateExtensionInfo()
	 * @generated
	 */
	void setCreateExtensionInfo(CreateExtensionInfo value);

} // XtendFunction
