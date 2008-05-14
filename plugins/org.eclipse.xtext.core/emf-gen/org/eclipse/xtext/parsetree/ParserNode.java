/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParserNode.java,v 1.1 2008/05/14 13:29:32 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parser Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.ParserNode#getText <em>Text</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.ParserNode#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.ParserNode#getGrammarElement <em>Grammar Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getParserNode()
 * @model
 * @generated
 */
public interface ParserNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getParserNode_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.ParserNode#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getParserNode_Element()
	 * @model
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.ParserNode#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Grammar Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grammar Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grammar Element</em>' reference.
	 * @see #setGrammarElement(EObject)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getParserNode_GrammarElement()
	 * @model
	 * @generated
	 */
	EObject getGrammarElement();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.ParserNode#getGrammarElement <em>Grammar Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammar Element</em>' reference.
	 * @see #getGrammarElement()
	 * @generated
	 */
	void setGrammarElement(EObject value);

} // ParserNode
