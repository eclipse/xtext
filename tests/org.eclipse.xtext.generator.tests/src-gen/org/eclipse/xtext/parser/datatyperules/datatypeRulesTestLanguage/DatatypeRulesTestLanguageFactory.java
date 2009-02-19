/**
 * <copyright>
 * </copyright>
 *
 * $Id: DatatypeRulesTestLanguageFactory.java,v 1.4 2009/02/19 16:27:04 sefftinge Exp $
 */
package org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage
 * @generated
 */
public interface DatatypeRulesTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DatatypeRulesTestLanguageFactory eINSTANCE = org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.DatatypeRulesTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Composite Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Composite Model</em>'.
   * @generated
   */
  CompositeModel createCompositeModel();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DatatypeRulesTestLanguagePackage getDatatypeRulesTestLanguagePackage();

} //DatatypeRulesTestLanguageFactory
