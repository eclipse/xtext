/**
 */
package org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.AnotherSimpleTestFactory
 * @model kind="package"
 * @generated
 */
public interface AnotherSimpleTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "anotherSimpleTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://eclipse.org/xtext/tests/AnotherSimpleTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "anotherSimpleTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AnotherSimpleTestPackage eINSTANCE = org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl.AnotherSimpleTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl.FooImpl <em>Foo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl.FooImpl
   * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl.AnotherSimpleTestPackageImpl#getFoo()
   * @generated
   */
  int FOO = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO__NAME = 0;

  /**
   * The feature id for the '<em><b>Name Refs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO__NAME_REFS = 1;

  /**
   * The number of structural features of the '<em>Foo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foo</em>'.
   * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo
   * @generated
   */
  EClass getFoo();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo#getName()
   * @see #getFoo()
   * @generated
   */
  EAttribute getFoo_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo#getNameRefs <em>Name Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Name Refs</em>'.
   * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.Foo#getNameRefs()
   * @see #getFoo()
   * @generated
   */
  EReference getFoo_NameRefs();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AnotherSimpleTestFactory getAnotherSimpleTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl.FooImpl <em>Foo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl.FooImpl
     * @see org.eclipse.xtext.metamodelreferencing.tests.anotherSimpleTest.impl.AnotherSimpleTestPackageImpl#getFoo()
     * @generated
     */
    EClass FOO = eINSTANCE.getFoo();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOO__NAME = eINSTANCE.getFoo_Name();

    /**
     * The meta object literal for the '<em><b>Name Refs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOO__NAME_REFS = eINSTANCE.getFoo_NameRefs();

  }

} //AnotherSimpleTestPackage
