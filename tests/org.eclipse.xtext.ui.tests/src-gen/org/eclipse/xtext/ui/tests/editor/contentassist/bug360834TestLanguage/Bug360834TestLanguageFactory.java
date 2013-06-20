/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.Bug360834TestLanguagePackage
 * @generated
 */
public interface Bug360834TestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug360834TestLanguageFactory eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug360834TestLanguage.impl.Bug360834TestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Alternative</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alternative</em>'.
   * @generated
   */
  Alternative createAlternative();

  /**
   * Returns a new object of class '<em>Recursive Class Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Recursive Class Declaration</em>'.
   * @generated
   */
  RecursiveClassDeclaration createRecursiveClassDeclaration();

  /**
   * Returns a new object of class '<em>Modifiers</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Modifiers</em>'.
   * @generated
   */
  Modifiers createModifiers();

  /**
   * Returns a new object of class '<em>Unordered</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unordered</em>'.
   * @generated
   */
  Unordered createUnordered();

  /**
   * Returns a new object of class '<em>Simple Class Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Class Declaration</em>'.
   * @generated
   */
  SimpleClassDeclaration createSimpleClassDeclaration();

  /**
   * Returns a new object of class '<em>Class Member</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Member</em>'.
   * @generated
   */
  ClassMember createClassMember();

  /**
   * Returns a new object of class '<em>Unordered Modifiers</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unordered Modifiers</em>'.
   * @generated
   */
  UnorderedModifiers createUnorderedModifiers();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug360834TestLanguagePackage getBug360834TestLanguagePackage();

} //Bug360834TestLanguageFactory
