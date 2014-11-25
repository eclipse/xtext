/**
 */
package org.eclipse.xtext.testlanguages.indent.indentLang;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.testlanguages.indent.indentLang.Node#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.testlanguages.indent.indentLang.Node#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.testlanguages.indent.indentLang.IndentLangPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.testlanguages.indent.indentLang.IndentLangPackage#getNode_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.indent.indentLang.Node#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference.
   * @see #setChildren(NodeList)
   * @see org.eclipse.xtext.testlanguages.indent.indentLang.IndentLangPackage#getNode_Children()
   * @model containment="true"
   * @generated
   */
  NodeList getChildren();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.testlanguages.indent.indentLang.Node#getChildren <em>Children</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Children</em>' containment reference.
   * @see #getChildren()
   * @generated
   */
  void setChildren(NodeList value);

} // Node
