/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.ReferenceGrammarUiPackage
 * @generated
 */
public interface ReferenceGrammarUiFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReferenceGrammarUiFactory eINSTANCE = org.eclipse.xtext.ui.tests.testlanguages.referenceGrammarUi.impl.ReferenceGrammarUiFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Spielplatz</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Spielplatz</em>'.
   * @generated
   */
  Spielplatz createSpielplatz();

  /**
   * Returns a new object of class '<em>Person</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Person</em>'.
   * @generated
   */
  Person createPerson();

  /**
   * Returns a new object of class '<em>Kind</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Kind</em>'.
   * @generated
   */
  Kind createKind();

  /**
   * Returns a new object of class '<em>Erwachsener</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Erwachsener</em>'.
   * @generated
   */
  Erwachsener createErwachsener();

  /**
   * Returns a new object of class '<em>Spielzeug</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Spielzeug</em>'.
   * @generated
   */
  Spielzeug createSpielzeug();

  /**
   * Returns a new object of class '<em>Farbe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Farbe</em>'.
   * @generated
   */
  Farbe createFarbe();

  /**
   * Returns a new object of class '<em>Familie</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Familie</em>'.
   * @generated
   */
  Familie createFamilie();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ReferenceGrammarUiPackage getReferenceGrammarUiPackage();

} //ReferenceGrammarUiFactory
