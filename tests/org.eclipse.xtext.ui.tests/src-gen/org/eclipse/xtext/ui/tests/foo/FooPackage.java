/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.foo;

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
 * @see org.eclipse.xtext.ui.tests.foo.FooFactory
 * @model kind="package"
 * @generated
 */
public interface FooPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "foo";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://foo";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "foo";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FooPackage eINSTANCE = org.eclipse.xtext.ui.tests.foo.impl.FooPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.foo.impl.FileImpl <em>File</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.foo.impl.FileImpl
   * @see org.eclipse.xtext.ui.tests.foo.impl.FooPackageImpl#getFile()
   * @generated
   */
  int FILE = 0;

  /**
   * The feature id for the '<em><b>Stuff</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE__STUFF = 0;

  /**
   * The number of structural features of the '<em>File</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.foo.impl.StuffImpl <em>Stuff</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.foo.impl.StuffImpl
   * @see org.eclipse.xtext.ui.tests.foo.impl.FooPackageImpl#getStuff()
   * @generated
   */
  int STUFF = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUFF__NAME = 0;

  /**
   * The feature id for the '<em><b>Refs</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUFF__REFS = 1;

  /**
   * The number of structural features of the '<em>Stuff</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STUFF_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.foo.File <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>File</em>'.
   * @see org.eclipse.xtext.ui.tests.foo.File
   * @generated
   */
  EClass getFile();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.foo.File#getStuff <em>Stuff</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Stuff</em>'.
   * @see org.eclipse.xtext.ui.tests.foo.File#getStuff()
   * @see #getFile()
   * @generated
   */
  EReference getFile_Stuff();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.foo.Stuff <em>Stuff</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stuff</em>'.
   * @see org.eclipse.xtext.ui.tests.foo.Stuff
   * @generated
   */
  EClass getStuff();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.foo.Stuff#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.foo.Stuff#getName()
   * @see #getStuff()
   * @generated
   */
  EAttribute getStuff_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.foo.Stuff#getRefs <em>Refs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Refs</em>'.
   * @see org.eclipse.xtext.ui.tests.foo.Stuff#getRefs()
   * @see #getStuff()
   * @generated
   */
  EReference getStuff_Refs();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FooFactory getFooFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.foo.impl.FileImpl <em>File</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.foo.impl.FileImpl
     * @see org.eclipse.xtext.ui.tests.foo.impl.FooPackageImpl#getFile()
     * @generated
     */
    EClass FILE = eINSTANCE.getFile();

    /**
     * The meta object literal for the '<em><b>Stuff</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FILE__STUFF = eINSTANCE.getFile_Stuff();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.foo.impl.StuffImpl <em>Stuff</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.foo.impl.StuffImpl
     * @see org.eclipse.xtext.ui.tests.foo.impl.FooPackageImpl#getStuff()
     * @generated
     */
    EClass STUFF = eINSTANCE.getStuff();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STUFF__NAME = eINSTANCE.getStuff_Name();

    /**
     * The meta object literal for the '<em><b>Refs</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STUFF__REFS = eINSTANCE.getStuff_Refs();

  }

} //FooPackage
