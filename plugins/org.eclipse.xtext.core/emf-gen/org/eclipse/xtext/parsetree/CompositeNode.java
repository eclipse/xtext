/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositeNode.java,v 1.2 2008/05/15 09:22:48 jkohnlein Exp $
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
