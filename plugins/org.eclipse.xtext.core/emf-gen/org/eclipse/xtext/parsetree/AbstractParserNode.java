/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractParserNode.java,v 1.2 2008/05/15 08:15:23 jkohnlein Exp $
 */
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Parser Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractParserNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractParserNode#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractParserNode()
 * @model abstract="true"
 * @generated
 */
public interface AbstractParserNode extends EObject {

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.parsetree.CompositeNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(CompositeNode)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractParserNode_Parent()
	 * @see org.eclipse.xtext.parsetree.CompositeNode#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	CompositeNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractParserNode#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(CompositeNode value);

	/**
	 * Returns the value of the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' attribute.
	 * @see #setElement(Object)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractParserNode_Element()
	 * @model
	 * @generated
	 */
	Object getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractParserNode#getElement <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' attribute.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(Object value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.length((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.length((LeafNodeImpl) this);} else {return ParsetreeUtil.length((AbstractParserNodeImpl) this);}'"
	 * @generated
	 */
	int length();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.offset((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.offset((LeafNodeImpl) this);} else {return ParsetreeUtil.offset((AbstractParserNodeImpl) this);}'"
	 * @generated
	 */
	int offset();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.line((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.line((LeafNodeImpl) this);} else {return ParsetreeUtil.line((AbstractParserNodeImpl) this);}'"
	 * @generated
	 */
	int line();
} // AbstractParserNode
