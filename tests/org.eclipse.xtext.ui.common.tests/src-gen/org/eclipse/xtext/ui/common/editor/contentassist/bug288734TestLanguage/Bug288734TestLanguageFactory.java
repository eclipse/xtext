/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.Bug288734TestLanguagePackage
 * @generated
 */
public interface Bug288734TestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug288734TestLanguageFactory eINSTANCE = org.eclipse.xtext.ui.common.editor.contentassist.bug288734TestLanguage.impl.Bug288734TestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>TConstant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TConstant</em>'.
   * @generated
   */
  TConstant createTConstant();

  /**
   * Returns a new object of class '<em>TString Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TString Constant</em>'.
   * @generated
   */
  TStringConstant createTStringConstant();

  /**
   * Returns a new object of class '<em>TInteger Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TInteger Constant</em>'.
   * @generated
   */
  TIntegerConstant createTIntegerConstant();

  /**
   * Returns a new object of class '<em>TBoolean Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TBoolean Constant</em>'.
   * @generated
   */
  TBooleanConstant createTBooleanConstant();

  /**
   * Returns a new object of class '<em>TAnnotation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>TAnnotation</em>'.
   * @generated
   */
  TAnnotation createTAnnotation();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug288734TestLanguagePackage getBug288734TestLanguagePackage();

} //Bug288734TestLanguageFactory
