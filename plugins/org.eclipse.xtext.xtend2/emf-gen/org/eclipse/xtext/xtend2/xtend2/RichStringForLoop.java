/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.xtend2.xtend2;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XForLoopExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rich String For Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.RichStringForLoop#getSeparator <em>Separator</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.RichStringForLoop#getBefore <em>Before</em>}</li>
 *   <li>{@link org.eclipse.xtext.xtend2.xtend2.RichStringForLoop#getAfter <em>After</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getRichStringForLoop()
 * @model
 * @generated
 */
public interface RichStringForLoop extends XForLoopExpression
{
	/**
	 * Returns the value of the '<em><b>Separator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Separator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Separator</em>' containment reference.
	 * @see #setSeparator(XExpression)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getRichStringForLoop_Separator()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getSeparator();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.RichStringForLoop#getSeparator <em>Separator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Separator</em>' containment reference.
	 * @see #getSeparator()
	 * @generated
	 */
	void setSeparator(XExpression value);

	/**
	 * Returns the value of the '<em><b>Before</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Before</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Before</em>' containment reference.
	 * @see #setBefore(XExpression)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getRichStringForLoop_Before()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getBefore();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.RichStringForLoop#getBefore <em>Before</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Before</em>' containment reference.
	 * @see #getBefore()
	 * @generated
	 */
	void setBefore(XExpression value);

	/**
	 * Returns the value of the '<em><b>After</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>After</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>After</em>' containment reference.
	 * @see #setAfter(XExpression)
	 * @see org.eclipse.xtext.xtend2.xtend2.Xtend2Package#getRichStringForLoop_After()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getAfter();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.xtend2.xtend2.RichStringForLoop#getAfter <em>After</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>After</em>' containment reference.
	 * @see #getAfter()
	 * @generated
	 */
	void setAfter(XExpression value);

} // RichStringForLoop
