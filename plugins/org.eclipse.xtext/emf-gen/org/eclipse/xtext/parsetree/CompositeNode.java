/**
 * <copyright>
 * </copyright>
 *
 * $Id: CompositeNode.java,v 1.4 2008/06/20 12:47:07 jkohnlein Exp $
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
 *   <li>{@link org.eclipse.xtext.parsetree.CompositeNode#getLookahead <em>Lookahead</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.CompositeNode#getLookaheadConsumed <em>Lookahead Consumed</em>}</li>
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
     * @model opposite="parent" containment="true" resolveProxies="true"
     * @generated
     */
  EList<AbstractNode> getChildren();

/**
     * Returns the value of the '<em><b>Lookahead</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lookahead</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Lookahead</em>' attribute.
     * @see #setLookahead(int)
     * @see org.eclipse.xtext.parsetree.ParsetreePackage#getCompositeNode_Lookahead()
     * @model
     * @generated
     */
    int getLookahead();

/**
     * Sets the value of the '{@link org.eclipse.xtext.parsetree.CompositeNode#getLookahead <em>Lookahead</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Lookahead</em>' attribute.
     * @see #getLookahead()
     * @generated
     */
    void setLookahead(int value);

/**
     * Returns the value of the '<em><b>Lookahead Consumed</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lookahead Consumed</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Lookahead Consumed</em>' attribute.
     * @see #setLookaheadConsumed(int)
     * @see org.eclipse.xtext.parsetree.ParsetreePackage#getCompositeNode_LookaheadConsumed()
     * @model
     * @generated
     */
    int getLookaheadConsumed();

/**
     * Sets the value of the '{@link org.eclipse.xtext.parsetree.CompositeNode#getLookaheadConsumed <em>Lookahead Consumed</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Lookahead Consumed</em>' attribute.
     * @see #getLookaheadConsumed()
     * @generated
     */
    void setLookaheadConsumed(int value);

} // CompositeNode
