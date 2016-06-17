/**
 */
package org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.UnassignedRuleCallTestLanguagePackage
 * @generated
 */
public interface UnassignedRuleCallTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnassignedRuleCallTestLanguageFactory eINSTANCE = org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.UnassignedRuleCallTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Model Features</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Features</em>'.
   * @generated
   */
  ModelFeatures createModelFeatures();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UnassignedRuleCallTestLanguagePackage getUnassignedRuleCallTestLanguagePackage();

} //UnassignedRuleCallTestLanguageFactory
