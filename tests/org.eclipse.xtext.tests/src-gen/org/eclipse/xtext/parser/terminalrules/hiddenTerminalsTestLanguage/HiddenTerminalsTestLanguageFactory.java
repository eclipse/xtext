/**
 */
package org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage
 * @generated
 */
public interface HiddenTerminalsTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HiddenTerminalsTestLanguageFactory eINSTANCE = org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.impl.HiddenTerminalsTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Without Hiddens</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Without Hiddens</em>'.
   * @generated
   */
  WithoutHiddens createWithoutHiddens();

  /**
   * Returns a new object of class '<em>With Hiddens</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>With Hiddens</em>'.
   * @generated
   */
  WithHiddens createWithHiddens();

  /**
   * Returns a new object of class '<em>Overriding Hiddens</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Overriding Hiddens</em>'.
   * @generated
   */
  OverridingHiddens createOverridingHiddens();

  /**
   * Returns a new object of class '<em>Overriding Hiddens Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Overriding Hiddens Call</em>'.
   * @generated
   */
  OverridingHiddensCall createOverridingHiddensCall();

  /**
   * Returns a new object of class '<em>Inheriting Hiddens</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inheriting Hiddens</em>'.
   * @generated
   */
  InheritingHiddens createInheritingHiddens();

  /**
   * Returns a new object of class '<em>Datatype Hiddens</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Datatype Hiddens</em>'.
   * @generated
   */
  DatatypeHiddens createDatatypeHiddens();

  /**
   * Returns a new object of class '<em>Hiding Hiddens</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Hiding Hiddens</em>'.
   * @generated
   */
  HidingHiddens createHidingHiddens();

  /**
   * Returns a new object of class '<em>Inheriting Hiddens Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inheriting Hiddens Call</em>'.
   * @generated
   */
  InheritingHiddensCall createInheritingHiddensCall();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  HiddenTerminalsTestLanguagePackage getHiddenTerminalsTestLanguagePackage();

} //HiddenTerminalsTestLanguageFactory
