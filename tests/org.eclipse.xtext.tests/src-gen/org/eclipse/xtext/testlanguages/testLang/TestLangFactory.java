/**
 */
package org.eclipse.xtext.testlanguages.testLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.testLang.TestLangPackage
 * @generated
 */
public interface TestLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TestLangFactory eINSTANCE = org.eclipse.xtext.testlanguages.testLang.impl.TestLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Abstract Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Element</em>'.
   * @generated
   */
  AbstractElement createAbstractElement();

  /**
   * Returns a new object of class '<em>Choice Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choice Element</em>'.
   * @generated
   */
  ChoiceElement createChoiceElement();

  /**
   * Returns a new object of class '<em>Reducible Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reducible Element</em>'.
   * @generated
   */
  ReducibleElement createReducibleElement();

  /**
   * Returns a new object of class '<em>Terminal Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Terminal Element</em>'.
   * @generated
   */
  TerminalElement createTerminalElement();

  /**
   * Returns a new object of class '<em>Reducible Composite</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Reducible Composite</em>'.
   * @generated
   */
  ReducibleComposite createReducibleComposite();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TestLangPackage getTestLangPackage();

} //TestLangFactory
