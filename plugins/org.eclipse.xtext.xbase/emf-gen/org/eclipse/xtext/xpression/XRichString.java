/**
 * <copyright>
 * </copyright>
 *
 * $Id: XRichString.java,v 1.1 2010/01/16 08:50:53 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XRich String</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XRichString#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXRichString()
 * @model
 * @generated
 */
public interface XRichString extends XExpression {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXRichString_Expressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getExpressions();

} // XRichString
