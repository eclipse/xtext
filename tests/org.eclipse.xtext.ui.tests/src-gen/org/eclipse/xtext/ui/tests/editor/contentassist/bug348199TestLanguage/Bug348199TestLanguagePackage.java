/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Bug348199TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug348199TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug348199TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2011/bug348199TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug348199TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug348199TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.Bug348199TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeperiodImpl <em>Timeperiod</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeperiodImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.Bug348199TestLanguagePackageImpl#getTimeperiod()
   * @generated
   */
  int TIMEPERIOD = 0;

  /**
   * The feature id for the '<em><b>Time</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMEPERIOD__TIME = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMEPERIOD__NAME = 1;

  /**
   * The feature id for the '<em><b>Alias</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMEPERIOD__ALIAS = 2;

  /**
   * The number of structural features of the '<em>Timeperiod</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIMEPERIOD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeDefImpl <em>Time Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeDefImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.Bug348199TestLanguagePackageImpl#getTimeDef()
   * @generated
   */
  int TIME_DEF = 1;

  /**
   * The feature id for the '<em><b>Day</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_DEF__DAY = 0;

  /**
   * The number of structural features of the '<em>Time Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_DEF_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod <em>Timeperiod</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Timeperiod</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod
   * @generated
   */
  EClass getTimeperiod();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod#getTime <em>Time</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Time</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod#getTime()
   * @see #getTimeperiod()
   * @generated
   */
  EReference getTimeperiod_Time();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod#getName()
   * @see #getTimeperiod()
   * @generated
   */
  EAttribute getTimeperiod_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod#getAlias <em>Alias</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Alias</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.Timeperiod#getAlias()
   * @see #getTimeperiod()
   * @generated
   */
  EAttribute getTimeperiod_Alias();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.TimeDef <em>Time Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Def</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.TimeDef
   * @generated
   */
  EClass getTimeDef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.TimeDef#getDay <em>Day</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Day</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.TimeDef#getDay()
   * @see #getTimeDef()
   * @generated
   */
  EAttribute getTimeDef_Day();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug348199TestLanguageFactory getBug348199TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeperiodImpl <em>Timeperiod</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeperiodImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.Bug348199TestLanguagePackageImpl#getTimeperiod()
     * @generated
     */
    EClass TIMEPERIOD = eINSTANCE.getTimeperiod();

    /**
     * The meta object literal for the '<em><b>Time</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIMEPERIOD__TIME = eINSTANCE.getTimeperiod_Time();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMEPERIOD__NAME = eINSTANCE.getTimeperiod_Name();

    /**
     * The meta object literal for the '<em><b>Alias</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIMEPERIOD__ALIAS = eINSTANCE.getTimeperiod_Alias();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeDefImpl <em>Time Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.TimeDefImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug348199TestLanguage.impl.Bug348199TestLanguagePackageImpl#getTimeDef()
     * @generated
     */
    EClass TIME_DEF = eINSTANCE.getTimeDef();

    /**
     * The meta object literal for the '<em><b>Day</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_DEF__DAY = eINSTANCE.getTimeDef_Day();

  }

} //Bug348199TestLanguagePackage
