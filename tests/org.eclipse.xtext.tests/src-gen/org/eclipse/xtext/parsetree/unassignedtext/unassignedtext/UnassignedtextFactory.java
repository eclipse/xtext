/**
 */
package org.eclipse.xtext.parsetree.unassignedtext.unassignedtext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextPackage
 * @generated
 */
public interface UnassignedtextFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnassignedtextFactory eINSTANCE = org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.impl.UnassignedtextFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Case Insensitive Keyword Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Case Insensitive Keyword Rule</em>'.
   * @generated
   */
  CaseInsensitiveKeywordRule createCaseInsensitiveKeywordRule();

  /**
   * Returns a new object of class '<em>Plural Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plural Rule</em>'.
   * @generated
   */
  PluralRule createPluralRule();

  /**
   * Returns a new object of class '<em>Multi Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multi Rule</em>'.
   * @generated
   */
  MultiRule createMultiRule();

  /**
   * Returns a new object of class '<em>Datatype Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Datatype Rule</em>'.
   * @generated
   */
  DatatypeRule createDatatypeRule();

  /**
   * Returns a new object of class '<em>Common Terminals Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Common Terminals Rule</em>'.
   * @generated
   */
  CommonTerminalsRule createCommonTerminalsRule();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UnassignedtextPackage getUnassignedtextPackage();

} //UnassignedtextFactory
