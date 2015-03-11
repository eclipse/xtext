/**
 */
package org.eclipse.xtext.parser.assignments.bug287184Test;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.parser.assignments.bug287184Test.Bug287184TestPackage
 * @generated
 */
public interface Bug287184TestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug287184TestFactory eINSTANCE = org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Abstract Detail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Detail</em>'.
   * @generated
   */
  AbstractDetail createAbstractDetail();

  /**
   * Returns a new object of class '<em>Detail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Detail</em>'.
   * @generated
   */
  Detail createDetail();

  /**
   * Returns a new object of class '<em>Associated Detail</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Associated Detail</em>'.
   * @generated
   */
  AssociatedDetail createAssociatedDetail();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug287184TestPackage getBug287184TestPackage();

} //Bug287184TestFactory
