/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.Bug381381TestLanguagePackage
 * @generated
 */
public interface Bug381381TestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug381381TestLanguageFactory eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug381381TestLanguage.impl.Bug381381TestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Copy Field Name To Variable Stmt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Copy Field Name To Variable Stmt</em>'.
   * @generated
   */
  CopyFieldNameToVariableStmt createCopyFieldNameToVariableStmt();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug381381TestLanguagePackage getBug381381TestLanguagePackage();

} //Bug381381TestLanguageFactory
