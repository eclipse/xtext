/**
 */
package org.eclipse.xtext.generator.ecore.first;

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
 * @see org.eclipse.xtext.generator.ecore.first.FirstFactory
 * @model kind="package"
 * @generated
 */
public interface FirstPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "first";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://first";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "first";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  FirstPackage eINSTANCE = org.eclipse.xtext.generator.ecore.first.impl.FirstPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.ecore.first.impl.FirstImpl <em>First</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.ecore.first.impl.FirstImpl
   * @see org.eclipse.xtext.generator.ecore.first.impl.FirstPackageImpl#getFirst()
   * @generated
   */
  int FIRST = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST__NAME = 0;

  /**
   * The number of structural features of the '<em>First</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.ecore.first.First <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>First</em>'.
   * @see org.eclipse.xtext.generator.ecore.first.First
   * @generated
   */
  EClass getFirst();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.ecore.first.First#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.generator.ecore.first.First#getName()
   * @see #getFirst()
   * @generated
   */
  EAttribute getFirst_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  FirstFactory getFirstFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.generator.ecore.first.impl.FirstImpl <em>First</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.ecore.first.impl.FirstImpl
     * @see org.eclipse.xtext.generator.ecore.first.impl.FirstPackageImpl#getFirst()
     * @generated
     */
    EClass FIRST = eINSTANCE.getFirst();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIRST__NAME = eINSTANCE.getFirst_Name();

  }

} //FirstPackage
