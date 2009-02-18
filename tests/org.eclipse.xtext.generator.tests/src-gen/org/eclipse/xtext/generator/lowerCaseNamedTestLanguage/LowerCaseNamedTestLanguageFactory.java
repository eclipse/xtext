/**
 * <copyright>
 * </copyright>
 *
 * $Id: LowerCaseNamedTestLanguageFactory.java,v 1.1 2009/02/18 19:45:29 sefftinge Exp $
 */
package org.eclipse.xtext.generator.lowerCaseNamedTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.generator.lowerCaseNamedTestLanguage.LowerCaseNamedTestLanguagePackage
 * @generated
 */
public interface LowerCaseNamedTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LowerCaseNamedTestLanguageFactory eINSTANCE = org.eclipse.xtext.generator.lowerCaseNamedTestLanguage.impl.LowerCaseNamedTestLanguageFactoryImpl.init();

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
  LowerCaseNamedTestLanguagePackage getLowerCaseNamedTestLanguagePackage();

} //LowerCaseNamedTestLanguageFactory
