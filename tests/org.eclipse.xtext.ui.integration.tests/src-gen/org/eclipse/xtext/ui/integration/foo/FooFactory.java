/**
 * <copyright>
 * </copyright>
 *
 * $Id: FooFactory.java,v 1.5 2009/02/19 21:08:29 sefftinge Exp $
 */
package org.eclipse.xtext.ui.integration.foo;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.ui.integration.foo.FooPackage
 * @generated
 */
public interface FooFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FooFactory eINSTANCE = org.eclipse.xtext.ui.integration.foo.impl.FooFactoryImpl.init();

  /**
   * Returns a new object of class '<em>File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>File</em>'.
   * @generated
   */
  File createFile();

  /**
   * Returns a new object of class '<em>Stuff</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stuff</em>'.
   * @generated
   */
  Stuff createStuff();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  FooPackage getFooPackage();

} //FooFactory
