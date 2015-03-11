/**
 */
package org.eclipse.xtext.generator.ecore.second;

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
 * @see org.eclipse.xtext.generator.ecore.second.SecondFactory
 * @model kind="package"
 * @generated
 */
public interface SecondPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "second";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/EcoreFragmentTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "second";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SecondPackage eINSTANCE = org.eclipse.xtext.generator.ecore.second.impl.SecondPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.generator.ecore.second.impl.SecondImpl <em>Second</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.generator.ecore.second.impl.SecondImpl
   * @see org.eclipse.xtext.generator.ecore.second.impl.SecondPackageImpl#getSecond()
   * @generated
   */
  int SECOND = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND__NAME = 0;

  /**
   * The feature id for the '<em><b>First</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND__FIRST = 1;

  /**
   * The number of structural features of the '<em>Second</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.generator.ecore.second.Second <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Second</em>'.
   * @see org.eclipse.xtext.generator.ecore.second.Second
   * @generated
   */
  EClass getSecond();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.generator.ecore.second.Second#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.generator.ecore.second.Second#getName()
   * @see #getSecond()
   * @generated
   */
  EAttribute getSecond_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.generator.ecore.second.Second#getFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>First</em>'.
   * @see org.eclipse.xtext.generator.ecore.second.Second#getFirst()
   * @see #getSecond()
   * @generated
   */
  EReference getSecond_First();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SecondFactory getSecondFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.generator.ecore.second.impl.SecondImpl <em>Second</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.generator.ecore.second.impl.SecondImpl
     * @see org.eclipse.xtext.generator.ecore.second.impl.SecondPackageImpl#getSecond()
     * @generated
     */
    EClass SECOND = eINSTANCE.getSecond();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SECOND__NAME = eINSTANCE.getSecond_Name();

    /**
     * The meta object literal for the '<em><b>First</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECOND__FIRST = eINSTANCE.getSecond_First();

  }

} //SecondPackage
