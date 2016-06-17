/**
 */
package org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.IndentationAwareTestLanguagePackage
 * @generated
 */
public interface IndentationAwareTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IndentationAwareTestLanguageFactory eINSTANCE = org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.impl.IndentationAwareTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Tree</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tree</em>'.
   * @generated
   */
  Tree createTree();

  /**
   * Returns a new object of class '<em>Tree Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tree Node</em>'.
   * @generated
   */
  TreeNode createTreeNode();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  IndentationAwareTestLanguagePackage getIndentationAwareTestLanguagePackage();

} //IndentationAwareTestLanguageFactory
