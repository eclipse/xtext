/**
 */
package org.eclipse.xtext.enumrules.multiRuleenums;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.xtext.enumrules.multiRuleenums.MultiRuleenumsFactory
 * @model kind="package"
 * @generated
 */
public interface MultiRuleenumsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "multiRuleenums";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/MultiRuleEnums";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "multiRuleenums";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MultiRuleenumsPackage eINSTANCE = org.eclipse.xtext.enumrules.multiRuleenums.impl.MultiRuleenumsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.enumrules.multiRuleenums.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.enumrules.multiRuleenums.impl.ModelImpl
   * @see org.eclipse.xtext.enumrules.multiRuleenums.impl.MultiRuleenumsPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>A</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__A = 0;

  /**
   * The feature id for the '<em><b>B</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__B = 1;

  /**
   * The feature id for the '<em><b>C</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__C = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.enumrules.multiRuleenums.MyEnum <em>My Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
   * @see org.eclipse.xtext.enumrules.multiRuleenums.impl.MultiRuleenumsPackageImpl#getMyEnum()
   * @generated
   */
  int MY_ENUM = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.enumrules.multiRuleenums.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.enumrules.multiRuleenums.Model#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>A</em>'.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.Model#getA()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_A();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.enumrules.multiRuleenums.Model#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>B</em>'.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.Model#getB()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_B();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.enumrules.multiRuleenums.Model#getC <em>C</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>C</em>'.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.Model#getC()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_C();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.enumrules.multiRuleenums.MyEnum <em>My Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>My Enum</em>'.
   * @see org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
   * @generated
   */
  EEnum getMyEnum();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MultiRuleenumsFactory getMultiRuleenumsFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.enumrules.multiRuleenums.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.enumrules.multiRuleenums.impl.ModelImpl
     * @see org.eclipse.xtext.enumrules.multiRuleenums.impl.MultiRuleenumsPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>A</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__A = eINSTANCE.getModel_A();

    /**
     * The meta object literal for the '<em><b>B</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__B = eINSTANCE.getModel_B();

    /**
     * The meta object literal for the '<em><b>C</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__C = eINSTANCE.getModel_C();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.enumrules.multiRuleenums.MyEnum <em>My Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
     * @see org.eclipse.xtext.enumrules.multiRuleenums.impl.MultiRuleenumsPackageImpl#getMyEnum()
     * @generated
     */
    EEnum MY_ENUM = eINSTANCE.getMyEnum();

  }

} //MultiRuleenumsPackage
