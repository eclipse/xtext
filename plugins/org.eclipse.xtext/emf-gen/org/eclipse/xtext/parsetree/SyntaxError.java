/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Syntax Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.SyntaxError#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.SyntaxError#getNode <em>Node</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.SyntaxError#getIssueCode <em>Issue Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getSyntaxError()
 * @model
 * @generated
 */
public interface SyntaxError extends EObject {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getSyntaxError_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.SyntaxError#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.parsetree.AbstractNode#getSyntaxError <em>Syntax Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' container reference.
	 * @see #setNode(AbstractNode)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getSyntaxError_Node()
	 * @see org.eclipse.xtext.parsetree.AbstractNode#getSyntaxError
	 * @model opposite="syntaxError" transient="false"
	 * @generated
	 */
	AbstractNode getNode();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.SyntaxError#getNode <em>Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' container reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(AbstractNode value);

	/**
	 * Returns the value of the '<em><b>Issue Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issue Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Issue Code</em>' attribute.
	 * @see #setIssueCode(String)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getSyntaxError_IssueCode()
	 * @model
	 * @generated
	 */
	String getIssueCode();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.SyntaxError#getIssueCode <em>Issue Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Issue Code</em>' attribute.
	 * @see #getIssueCode()
	 * @generated
	 */
	void setIssueCode(String value);

} // SyntaxError
