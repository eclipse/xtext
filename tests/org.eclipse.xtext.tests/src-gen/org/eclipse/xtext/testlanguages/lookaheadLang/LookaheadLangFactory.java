/**
 */
package org.eclipse.xtext.testlanguages.lookaheadLang;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.testlanguages.lookaheadLang.LookaheadLangPackage
 * @generated
 */
public interface LookaheadLangFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LookaheadLangFactory eINSTANCE = org.eclipse.xtext.testlanguages.lookaheadLang.impl.LookaheadLangFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Entry</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry</em>'.
   * @generated
   */
  Entry createEntry();

  /**
   * Returns a new object of class '<em>Alts</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alts</em>'.
   * @generated
   */
  Alts createAlts();

  /**
   * Returns a new object of class '<em>Look Ahead0</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Look Ahead0</em>'.
   * @generated
   */
  LookAhead0 createLookAhead0();

  /**
   * Returns a new object of class '<em>Look Ahead1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Look Ahead1</em>'.
   * @generated
   */
  LookAhead1 createLookAhead1();

  /**
   * Returns a new object of class '<em>Look Ahead2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Look Ahead2</em>'.
   * @generated
   */
  LookAhead2 createLookAhead2();

  /**
   * Returns a new object of class '<em>Look Ahead3</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Look Ahead3</em>'.
   * @generated
   */
  LookAhead3 createLookAhead3();

  /**
   * Returns a new object of class '<em>Look Ahead4</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Look Ahead4</em>'.
   * @generated
   */
  LookAhead4 createLookAhead4();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  LookaheadLangPackage getLookaheadLangPackage();

} //LookaheadLangFactory
