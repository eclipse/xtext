/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractNode.java,v 1.9 2008/08/07 15:05:36 sefftinge Exp $
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
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getLine <em>Line</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.AbstractNode#getLength <em>Length</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode()
 * @model abstract="true"
 * @generated
 */
public interface AbstractNode extends EObject
{
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
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_Offset()
	 * @model
	 * @generated
	 */
	int getOffset();

		/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

		/**
	 * Returns the value of the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line</em>' attribute.
	 * @see #setLine(int)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_Line()
	 * @model
	 * @generated
	 */
	int getLine();

		/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getLine <em>Line</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' attribute.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(int value);

		/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(int)
	 * @see org.eclipse.xtext.parsetree.ParsetreePackage#getAbstractNode_Length()
	 * @model default="-1" ordered="false"
	 * @generated
	 */
	int getLength();

		/**
	 * Sets the value of the '{@link org.eclipse.xtext.parsetree.AbstractNode#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(int value);

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
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='if (this instanceof CompositeNodeImpl) { return ParsetreeUtil.endLine((CompositeNodeImpl) this);} else if (this instanceof LeafNodeImpl) { return ParsetreeUtil.endLine((LeafNodeImpl) this);} else {return ParsetreeUtil.endLine((AbstractNodeImpl) this);}'"
	 * @generated
	 */
	int endLine();

} // AbstractNode
