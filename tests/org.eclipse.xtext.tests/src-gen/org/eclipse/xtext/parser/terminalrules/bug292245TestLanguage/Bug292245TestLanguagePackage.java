/**
 */
package org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage;

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
 * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Bug292245TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug292245TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug292245TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/Bug292245TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug292245TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug292245TestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.Bug292245TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.Bug292245TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Fix</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FIX = 0;

  /**
   * The feature id for the '<em><b>Error</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ERROR = 1;

  /**
   * The feature id for the '<em><b>Tick</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__TICK = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model#getFix <em>Fix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Fix</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model#getFix()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Fix();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model#getError <em>Error</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Error</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model#getError()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Error();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model#getTick <em>Tick</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Tick</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.Model#getTick()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Tick();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug292245TestLanguageFactory getBug292245TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parser.terminalrules.bug292245TestLanguage.impl.Bug292245TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Fix</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__FIX = eINSTANCE.getModel_Fix();

    /**
     * The meta object literal for the '<em><b>Error</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__ERROR = eINSTANCE.getModel_Error();

    /**
     * The meta object literal for the '<em><b>Tick</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__TICK = eINSTANCE.getModel_Tick();

  }

} //Bug292245TestLanguagePackage
