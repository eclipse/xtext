/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.ContentAssistTestLanguagePackage
 * @generated
 */
public interface ContentAssistTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ContentAssistTestLanguageFactory eINSTANCE = org.eclipse.xtext.ui.tests.testlanguages.contentAssistTestLanguage.impl.ContentAssistTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Start</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Start</em>'.
   * @generated
   */
  Start createStart();

  /**
   * Returns a new object of class '<em>Abstract Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Rule</em>'.
   * @generated
   */
  AbstractRule createAbstractRule();

  /**
   * Returns a new object of class '<em>First Abstract Rule Child</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>First Abstract Rule Child</em>'.
   * @generated
   */
  FirstAbstractRuleChild createFirstAbstractRuleChild();

  /**
   * Returns a new object of class '<em>Second Abstract Rule Child</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Second Abstract Rule Child</em>'.
   * @generated
   */
  SecondAbstractRuleChild createSecondAbstractRuleChild();

  /**
   * Returns a new object of class '<em>Abstract Rule Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Rule Call</em>'.
   * @generated
   */
  AbstractRuleCall createAbstractRuleCall();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ContentAssistTestLanguagePackage getContentAssistTestLanguagePackage();

} //ContentAssistTestLanguageFactory
