/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.DatatypeRuleTestPackage
 * @generated
 */
public interface DatatypeRuleTestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DatatypeRuleTestFactory eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Types</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Types</em>'.
   * @generated
   */
  Types createTypes();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  Type createType();

  /**
   * Returns a new object of class '<em>Simple Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Type</em>'.
   * @generated
   */
  SimpleType createSimpleType();

  /**
   * Returns a new object of class '<em>Composite Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Composite Type</em>'.
   * @generated
   */
  CompositeType createCompositeType();

  /**
   * Returns a new object of class '<em>Composite Type Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Composite Type Entry</em>'.
   * @generated
   */
  CompositeTypeEntry createCompositeTypeEntry();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DatatypeRuleTestPackage getDatatypeRuleTestPackage();

} //DatatypeRuleTestFactory
