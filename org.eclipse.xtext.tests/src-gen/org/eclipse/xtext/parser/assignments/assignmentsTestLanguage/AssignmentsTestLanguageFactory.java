/**
 */
package org.eclipse.xtext.parser.assignments.assignmentsTestLanguage;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguagePackage
 * @generated
 */
public interface AssignmentsTestLanguageFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AssignmentsTestLanguageFactory eINSTANCE = org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.AssignmentsTestLanguageFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Single Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Single Value</em>'.
   * @generated
   */
  SingleValue createSingleValue();

  /**
   * Returns a new object of class '<em>Multi Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multi Value</em>'.
   * @generated
   */
  MultiValue createMultiValue();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  AssignmentsTestLanguagePackage getAssignmentsTestLanguagePackage();

} //AssignmentsTestLanguageFactory
