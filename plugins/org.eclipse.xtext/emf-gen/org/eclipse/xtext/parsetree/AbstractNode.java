/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractNode.java,v 1.3 2008/06/05 08:58:46 sefftinge Exp $
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

} // AbstractNode
