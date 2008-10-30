/**
 * <copyright>
 * </copyright>
 *
 * $Id: TestPackage.java,v 1.1 2008/10/30 08:34:08 sefftinge Exp $
 */
package org.eclipse..test;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse..test.TestFactory
 * @model kind="package"
 * @generated
 */
public interface TestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "test";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://foo/bar/test";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "test";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TestPackage eINSTANCE = org.eclipse..test.impl.TestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse..test.impl.FooImpl <em>Foo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse..test.impl.FooImpl
   * @see org.eclipse..test.impl.TestPackageImpl#getFoo()
   * @generated
   */
  int FOO = 0;

  /**
   * The number of structural features of the '<em>Foo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_FEATURE_COUNT = 0;


  /**
   * Returns the meta object for class '{@link org.eclipse..test.Foo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foo</em>'.
   * @see org.eclipse..test.Foo
   * @generated
   */
  EClass getFoo();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TestFactory getTestFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse..test.impl.FooImpl <em>Foo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse..test.impl.FooImpl
     * @see org.eclipse..test.impl.TestPackageImpl#getFoo()
     * @generated
     */
    EClass FOO = eINSTANCE.getFoo();

  }

} //TestPackage
