/**
 */
package org.eclipse.xtext.linking.bug289059Test;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.linking.bug289059Test.Bug289059TestPackage
 * @generated
 */
public interface Bug289059TestFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug289059TestFactory eINSTANCE = org.eclipse.xtext.linking.bug289059Test.impl.Bug289059TestFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Unassigned Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unassigned Action</em>'.
   * @generated
   */
  UnassignedAction createUnassignedAction();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug289059TestPackage getBug289059TestPackage();

} //Bug289059TestFactory
