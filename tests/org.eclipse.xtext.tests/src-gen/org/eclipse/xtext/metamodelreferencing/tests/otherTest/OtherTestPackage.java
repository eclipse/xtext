/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.otherTest;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.xtext.metamodelreferencing.tests.otherTest.OtherTestFactory
 * @model kind="package"
 * @generated
 */
public interface OtherTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "otherTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://eclipse.org/xtext/tests/OtherTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "otherTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  OtherTestPackage eINSTANCE = org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl.OtherTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl.FooBarImpl <em>Foo Bar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl.FooBarImpl
   * @see org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl.OtherTestPackageImpl#getFooBar()
   * @generated
   */
  int FOO_BAR = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_BAR__NAME = 0;

  /**
   * The number of structural features of the '<em>Foo Bar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_BAR_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.metamodelreferencing.tests.otherTest.FooBar <em>Foo Bar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foo Bar</em>'.
   * @see org.eclipse.xtext.metamodelreferencing.tests.otherTest.FooBar
   * @generated
   */
  EClass getFooBar();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.metamodelreferencing.tests.otherTest.FooBar#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.metamodelreferencing.tests.otherTest.FooBar#getName()
   * @see #getFooBar()
   * @generated
   */
  EAttribute getFooBar_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  OtherTestFactory getOtherTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl.FooBarImpl <em>Foo Bar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl.FooBarImpl
     * @see org.eclipse.xtext.metamodelreferencing.tests.otherTest.impl.OtherTestPackageImpl#getFooBar()
     * @generated
     */
    EClass FOO_BAR = eINSTANCE.getFooBar();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOO_BAR__NAME = eINSTANCE.getFooBar_Name();

  }

} //OtherTestPackage
