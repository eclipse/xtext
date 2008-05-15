/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractNode.java,v 1.2 2008/05/15 12:46:48 jkohnlein Exp $
 */
package org.eclipse.xtext.core.parsetree;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.core.parsetree.AbstractNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.xtext.core.parsetree.AbstractNode#getGrammarElement <em>Grammar Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.core.parsetree.AbstractNode#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.core.parsetree.ParsetreePackage#getAbstractNode()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.core.parsetree.CompositeNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(CompositeNode)
	 * @see org.eclipse.xtext.core.parsetree.ParsetreePackage#getAbstractNode_Parent()
	 * @see org.eclipse.xtext.core.parsetree.CompositeNode#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	CompositeNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.core.parsetree.AbstractNode#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(CompositeNode value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(EObject)
	 * @see org.eclipse.xtext.core.parsetree.ParsetreePackage#getAbstractNode_Element()
	 * @model
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.core.parsetree.AbstractNode#getElement <em>Element</em>}' reference.
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
	 * @see org.eclipse.xtext.core.parsetree.ParsetreePackage#getAbstractNode_GrammarElement()
	 * @model
	 * @generated
	 */
	EObject getGrammarElement();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.core.parsetree.AbstractNode#getGrammarElement <em>Grammar Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammar Element</em>' reference.
	 * @see #getGrammarElement()
	 * @generated
	 */
	void setGrammarElement(EObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.length((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.length((LeafNodeImpl) this);} else {return ParsetreeUtil.length((AbstractNodeImpl) this);}'"
	 * @generated
	 */
	int length();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.offset((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.offset((LeafNodeImpl) this);} else {return ParsetreeUtil.offset((AbstractNodeImpl) this);}'"
	 * @generated
	 */
	int offset();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.line((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.line((LeafNodeImpl) this);} else {return ParsetreeUtil.line((AbstractNodeImpl) this);}'"
	 * @generated
	 */
	int line();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.serialize((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.serialize((LeafNodeImpl) this);} else {return ParsetreeUtil.serialize((AbstractNodeImpl) this);}'"
	 * @generated
	 */
	String serialize();

} // AbstractNode
