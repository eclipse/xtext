/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.Bug291022TestLanguagePackage
 * @generated
 */
public interface Bug291022TestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug291022TestLanguageFactory eINSTANCE = org.eclipse.xtext.ui.common.editor.contentassist.bug291022TestLanguage.impl.Bug291022TestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Element</em>'.
   * @generated
   */
  ModelElement createModelElement();

  /**
   * Returns a new object of class '<em>Model Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Attribute</em>'.
   * @generated
   */
  ModelAttribute createModelAttribute();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>Root Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Root Model</em>'.
   * @generated
   */
  RootModel createRootModel();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug291022TestLanguagePackage getBug291022TestLanguagePackage();

} //Bug291022TestLanguageFactory
