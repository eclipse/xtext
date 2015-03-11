/**
 */
package org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage;

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
 * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.EcoreTerminalsTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface EcoreTerminalsTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "ecoreTerminalsTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/ECoreTerminalsTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "ecoreTerminalsTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EcoreTerminalsTestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.EcoreTerminalsTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.EcoreTerminalsTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Int Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__INT_VALUES = 0;

  /**
   * The feature id for the '<em><b>Double Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DOUBLE_VALUES = 1;

  /**
   * The feature id for the '<em><b>Date Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DATE_VALUES = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model#getIntValues <em>Int Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Int Values</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model#getIntValues()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_IntValues();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model#getDoubleValues <em>Double Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Double Values</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model#getDoubleValues()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_DoubleValues();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model#getDateValues <em>Date Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Date Values</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.Model#getDateValues()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_DateValues();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EcoreTerminalsTestLanguageFactory getEcoreTerminalsTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parser.terminalrules.ecoreTerminalsTestLanguage.impl.EcoreTerminalsTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Int Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__INT_VALUES = eINSTANCE.getModel_IntValues();

    /**
     * The meta object literal for the '<em><b>Double Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__DOUBLE_VALUES = eINSTANCE.getModel_DoubleValues();

    /**
     * The meta object literal for the '<em><b>Date Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__DATE_VALUES = eINSTANCE.getModel_DateValues();

  }

} //EcoreTerminalsTestLanguagePackage
