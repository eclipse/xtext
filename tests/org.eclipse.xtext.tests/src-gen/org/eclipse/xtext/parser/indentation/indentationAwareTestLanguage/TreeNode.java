/**
 */
package org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage#getTreeNode()
 * @model
 * @generated
 */
public interface TreeNode extends EObject
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
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage#getTreeNode_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage#getTreeNode_Children()
   * @model containment="true"
   * @generated
   */
  EList<TreeNode> getChildren();

} // TreeNode
