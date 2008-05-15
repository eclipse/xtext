/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositeNode.java,v 1.1 2008/05/15 11:39:43 sefftinge Exp $
 */
package org.eclipse.xtext.core.parsetree;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.core.parsetree.CompositeNode#getChildren <em>Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.core.parsetree.ParsetreePackage#getCompositeNode()
 * @model
 * @generated
 */
public interface CompositeNode extends AbstractNode {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtext.core.parsetree.AbstractNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.core.parsetree.AbstractNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.xtext.core.parsetree.ParsetreePackage#getCompositeNode_Children()
	 * @see org.eclipse.xtext.core.parsetree.AbstractNode#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<AbstractNode> getChildren();

} // CompositeNode
