/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug288760TestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug288760TestLanguage.Bug288760TestLanguagePackage
 * @generated
 */
public interface Bug288760TestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug288760TestLanguageFactory eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug288760TestLanguage.impl.Bug288760TestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Workflow Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Workflow Element</em>'.
   * @generated
   */
  WorkflowElement createWorkflowElement();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug288760TestLanguagePackage getBug288760TestLanguagePackage();

} //Bug288760TestLanguageFactory
