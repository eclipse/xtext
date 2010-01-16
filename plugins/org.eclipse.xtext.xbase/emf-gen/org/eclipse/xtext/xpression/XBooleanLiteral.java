/**
 * <copyright>
 * </copyright>
 *
 * $Id: XBooleanLiteral.java,v 1.1 2010/01/16 08:50:52 sefftinge Exp $
 */
package org.eclipse.xtext.xpression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XBoolean Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xpression.XBooleanLiteral#isIsTrue <em>Is True</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xpression.XpressionPackage#getXBooleanLiteral()
 * @model
 * @generated
 */
public interface XBooleanLiteral extends XExpression {
	/**
	 * Returns the value of the '<em><b>Is True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is True</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is True</em>' attribute.
	 * @see #setIsTrue(boolean)
	 * @see org.eclipse.xtext.xpression.XpressionPackage#getXBooleanLiteral_IsTrue()
	 * @model
	 * @generated
	 */
	boolean isIsTrue();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xpression.XBooleanLiteral#isIsTrue <em>Is True</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is True</em>' attribute.
	 * @see #isIsTrue()
	 * @generated
	 */
	void setIsTrue(boolean value);

} // XBooleanLiteral
