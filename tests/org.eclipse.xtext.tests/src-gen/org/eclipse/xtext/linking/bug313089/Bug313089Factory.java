/**
 */
package org.eclipse.xtext.linking.bug313089;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.linking.bug313089.Bug313089Package
 * @generated
 */
public interface Bug313089Factory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug313089Factory eINSTANCE = org.eclipse.xtext.linking.bug313089.impl.Bug313089FactoryImpl.init();

  /**
   * Returns a new object of class '<em>Foo</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Foo</em>'.
   * @generated
   */
  Foo createFoo();

  /**
   * Returns a new object of class '<em>Bar</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bar</em>'.
   * @generated
   */
  Bar createBar();

  /**
   * Returns a new object of class '<em>Baz</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Baz</em>'.
   * @generated
   */
  Baz createBaz();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Bug313089Package getBug313089Package();

} //Bug313089Factory
