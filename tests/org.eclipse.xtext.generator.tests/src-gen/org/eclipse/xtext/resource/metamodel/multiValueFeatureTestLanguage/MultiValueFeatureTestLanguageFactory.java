/**
 * <copyright>
 * </copyright>
 *
 * $Id: MultiValueFeatureTestLanguageFactory.java,v 1.5 2009/02/19 21:09:57 sefftinge Exp $
 */
package org.eclipse.xtext.resource.metamodel.multiValueFeatureTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.resource.metamodel.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguagePackage
 * @generated
 */
public interface MultiValueFeatureTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MultiValueFeatureTestLanguageFactory eINSTANCE = org.eclipse.xtext.resource.metamodel.multiValueFeatureTestLanguage.impl.MultiValueFeatureTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Start</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Start</em>'.
   * @generated
   */
  Start createStart();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MultiValueFeatureTestLanguagePackage getMultiValueFeatureTestLanguagePackage();

} //MultiValueFeatureTestLanguageFactory
