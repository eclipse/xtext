/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.lexer.backtrackingTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.BacktrackingTestLanguagePackage
 * @generated
 */
public interface BacktrackingTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BacktrackingTestLanguageFactory eINSTANCE = org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Ab</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ab</em>'.
   * @generated
   */
  Ab createAb();

  /**
   * Returns a new object of class '<em>Xb</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Xb</em>'.
   * @generated
   */
  Xb createXb();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  BacktrackingTestLanguagePackage getBacktrackingTestLanguagePackage();

} //BacktrackingTestLanguageFactory
