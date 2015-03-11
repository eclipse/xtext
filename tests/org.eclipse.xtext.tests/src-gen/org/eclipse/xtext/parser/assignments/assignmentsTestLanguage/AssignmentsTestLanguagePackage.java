/**
 */
package org.eclipse.xtext.parser.assignments.assignmentsTestLanguage;

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
 * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.AssignmentsTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface AssignmentsTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "assignmentsTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/AssignmentsTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "assignmentsTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AssignmentsTestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.AssignmentsTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.AssignmentsTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Single</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SINGLE = 0;

  /**
   * The feature id for the '<em><b>Multi</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MULTI = 1;

  /**
   * The feature id for the '<em><b>Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__OBJECT = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.SingleValueImpl <em>Single Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.SingleValueImpl
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.AssignmentsTestLanguagePackageImpl#getSingleValue()
   * @generated
   */
  int SINGLE_VALUE = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VALUE__VALUE = 0;

  /**
   * The number of structural features of the '<em>Single Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_VALUE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.MultiValueImpl <em>Multi Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.MultiValueImpl
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.AssignmentsTestLanguagePackageImpl#getMultiValue()
   * @generated
   */
  int MULTI_VALUE = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_VALUE__VALUE = 0;

  /**
   * The number of structural features of the '<em>Multi Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_VALUE_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getSingle <em>Single</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Single</em>'.
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getSingle()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Single();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getMulti <em>Multi</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multi</em>'.
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getMulti()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Multi();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Object</em>'.
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.Model#getObject()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Object();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue <em>Single Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Value</em>'.
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue
   * @generated
   */
  EClass getSingleValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.SingleValue#getValue()
   * @see #getSingleValue()
   * @generated
   */
  EAttribute getSingleValue_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.MultiValue <em>Multi Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multi Value</em>'.
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.MultiValue
   * @generated
   */
  EClass getMultiValue();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.MultiValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.MultiValue#getValue()
   * @see #getMultiValue()
   * @generated
   */
  EAttribute getMultiValue_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AssignmentsTestLanguageFactory getAssignmentsTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.AssignmentsTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Single</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__SINGLE = eINSTANCE.getModel_Single();

    /**
     * The meta object literal for the '<em><b>Multi</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MULTI = eINSTANCE.getModel_Multi();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__OBJECT = eINSTANCE.getModel_Object();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.SingleValueImpl <em>Single Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.SingleValueImpl
     * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.AssignmentsTestLanguagePackageImpl#getSingleValue()
     * @generated
     */
    EClass SINGLE_VALUE = eINSTANCE.getSingleValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_VALUE__VALUE = eINSTANCE.getSingleValue_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.MultiValueImpl <em>Multi Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.MultiValueImpl
     * @see org.eclipse.xtext.parser.assignments.assignmentsTestLanguage.impl.AssignmentsTestLanguagePackageImpl#getMultiValue()
     * @generated
     */
    EClass MULTI_VALUE = eINSTANCE.getMultiValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTI_VALUE__VALUE = eINSTANCE.getMultiValue_Value();

  }

} //AssignmentsTestLanguagePackage
