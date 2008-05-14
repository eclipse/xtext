/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositeNode.java,v 1.1 2008/05/14 15:56:00 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.CompositeNode#getGrammarElement <em>Grammar Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.CompositeNode#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getCompositeNode()
 * @model
 * @generated
 */
public interface CompositeNode extends AbstractParserNode {
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
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getCompositeNode_GrammarElement()
	 * @model
	 * @generated
	 */
	EObject getGrammarElement();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.CompositeNode#getGrammarElement <em>Grammar Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammar Element</em>' reference.
	 * @see #getGrammarElement()
	 * @generated
	 */
	void setGrammarElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtext.parsetree.AbstractParserNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.parsetree.AbstractParserNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getCompositeNode_Children()
	 * @see org.eclipse.xtext.parsetree.AbstractParserNode#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<AbstractParserNode> getChildren();

} // CompositeNode
