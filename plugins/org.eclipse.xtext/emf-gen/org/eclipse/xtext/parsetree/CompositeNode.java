/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositeNode.java,v 1.2 2008/06/02 13:20:56 sefftinge Exp $
 */
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.util.EList;

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
public interface CompositeNode extends AbstractNode
{
  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parsetree.AbstractNode}.
   * It is bidirectional and its opposite is '{@link org.eclipse.xtext.parsetree.AbstractNode#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see org.eclipse.xtext.parsetree.ParsetreePackage#getCompositeNode_Children()
   * @see org.eclipse.xtext.parsetree.AbstractNode#getParent
   * @model opposite="parent" containment="true"
   * @generated
   */
  EList<AbstractNode> getChildren();

} // CompositeNode
