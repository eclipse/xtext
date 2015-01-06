/**
 */
package org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage#getTree()
 * @model
 * @generated
 */
public interface Tree extends EObject
{
  /**
   * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.TreeNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodes</em>' containment reference list.
   * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage#getTree_Nodes()
   * @model containment="true"
   * @generated
   */
  EList<TreeNode> getNodes();

} // Tree
