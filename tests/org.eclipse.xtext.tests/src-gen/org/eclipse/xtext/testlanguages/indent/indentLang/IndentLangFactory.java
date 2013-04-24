/**
 */
package org.eclipse.xtext.testlanguages.indent.indentLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.indent.indentLang.IndentLangPackage
 * @generated
 */
public interface IndentLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  IndentLangFactory eINSTANCE = org.eclipse.xtext.testlanguages.indent.indentLang.impl.IndentLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Node List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node List</em>'.
   * @generated
   */
  NodeList createNodeList();

  /**
   * Returns a new object of class '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node</em>'.
   * @generated
   */
  Node createNode();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  IndentLangPackage getIndentLangPackage();

} //IndentLangFactory
