/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getGrammarElement <em>Grammar Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getSyntaxError <em>Syntax Error</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getTotalOffset <em>Total Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getTotalLine <em>Total Line</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getTotalLength <em>Total Length</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.parsetree.CompositeNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(CompositeNode)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_Parent()
	 * @see org.eclipse.xtext.parsetree.CompositeNode#getChildren
	 * @model opposite="children" transient="false"
	 * @generated
	 */
	CompositeNode getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(CompositeNode value);

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
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_GrammarElement()
	 * @model
	 * @generated
	 */
	EObject getGrammarElement();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getGrammarElement <em>Grammar Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grammar Element</em>' reference.
	 * @see #getGrammarElement()
	 * @generated
	 */
	void setGrammarElement(EObject value);

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
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_Element()
	 * @model
	 * @generated
	 */
	EObject getElement();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Syntax Error</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.xtext.parsetree.SyntaxError#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Syntax Error</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Syntax Error</em>' containment reference.
	 * @see #setSyntaxError(SyntaxError)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_SyntaxError()
	 * @see org.eclipse.xtext.parsetree.SyntaxError#getNode
	 * @model opposite="node" containment="true"
	 * @generated
	 */
	SyntaxError getSyntaxError();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getSyntaxError <em>Syntax Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Syntax Error</em>' containment reference.
	 * @see #getSyntaxError()
	 * @generated
	 */
	void setSyntaxError(SyntaxError value);

	/**
	 * Returns the value of the '<em><b>Total Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Offset</em>' attribute.
	 * @see #setTotalOffset(int)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_TotalOffset()
	 * @model
	 * @generated
	 */
	int getTotalOffset();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getTotalOffset <em>Total Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Offset</em>' attribute.
	 * @see #getTotalOffset()
	 * @generated
	 */
	void setTotalOffset(int value);

	/**
	 * Returns the value of the '<em><b>Total Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Line</em>' attribute.
	 * @see #setTotalLine(int)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_TotalLine()
	 * @model
	 * @generated
	 */
	int getTotalLine();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getTotalLine <em>Total Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Line</em>' attribute.
	 * @see #getTotalLine()
	 * @generated
	 */
	void setTotalLine(int value);

	/**
	 * Returns the value of the '<em><b>Total Length</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Length</em>' attribute.
	 * @see #setTotalLength(int)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_TotalLength()
	 * @model default="-1" ordered="false"
	 * @generated
	 */
	int getTotalLength();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getTotalLength <em>Total Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Length</em>' attribute.
	 * @see #getTotalLength()
	 * @generated
	 */
	void setTotalLength(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.serialize((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.serialize((LeafNodeImpl) this);} else {return ParsetreeUtil.serialize((AbstractNodeImpl) this);}'"
	 * @generated
	 */
	String serialize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.getLeafNodes((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.getLeafNodes((LeafNodeImpl) this);} else {return ParsetreeUtil.getLeafNodes((AbstractNodeImpl) this);}'"
	 * @generated
	 */
	EList<LeafNode> getLeafNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model toRequired="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.getLeafNodes((CompositeNodeImpl) this, to);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.getLeafNodes((LeafNodeImpl) this, to);} else {return ParsetreeUtil.getLeafNodes((AbstractNodeImpl) this, to);}'"
	 * @generated
	 */
	EList<LeafNode> getLeafNodes(AbstractNode to);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.allSyntaxErrors((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.allSyntaxErrors((LeafNodeImpl) this);} else {return ParsetreeUtil.allSyntaxErrors((AbstractNodeImpl) this);}'"
	 * @generated
	 */
	EList<SyntaxError> allSyntaxErrors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.totalEndLine((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.totalEndLine((LeafNodeImpl) this);} else {return ParsetreeUtil.totalEndLine((AbstractNodeImpl) this);}'"
	 * @generated
	 */
	int totalEndLine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ParsetreeUtil.getOffset(this);'"
	 * @generated
	 */
	int getOffset();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ParsetreeUtil.getLine(this);'"
	 * @generated
	 */
	int getLine();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ParsetreeUtil.getLength(this);'"
	 * @generated
	 */
	int getLength();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return ParsetreeUtil.endLine(this);'"
	 * @generated
	 */
	int endLine();

} // AbstractNode
