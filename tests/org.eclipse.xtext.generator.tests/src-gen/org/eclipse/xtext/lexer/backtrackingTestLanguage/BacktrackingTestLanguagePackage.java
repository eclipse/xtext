/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.lexer.backtrackingTestLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.BacktrackingTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface BacktrackingTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "backtrackingTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/BacktrackingLexerTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "backtrackingTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BacktrackingTestLanguagePackage eINSTANCE = org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Enums</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ENUMS = 0;

  /**
   * The feature id for the '<em><b>Abs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ABS = 1;

  /**
   * The feature id for the '<em><b>Xbs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__XBS = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.AbImpl <em>Ab</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.AbImpl
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguagePackageImpl#getAb()
   * @generated
   */
  int AB = 1;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AB__X = 0;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AB__Y = 1;

  /**
   * The number of structural features of the '<em>Ab</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AB_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.XbImpl <em>Xb</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.XbImpl
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguagePackageImpl#getXb()
   * @generated
   */
  int XB = 2;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XB__X = 0;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XB__Y = 1;

  /**
   * The number of structural features of the '<em>Xb</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XB_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.EnumName <em>Enum Name</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.EnumName
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguagePackageImpl#getEnumName()
   * @generated
   */
  int ENUM_NAME = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Model#getEnums <em>Enums</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Enums</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Model#getEnums()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Enums();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Model#getAbs <em>Abs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Abs</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Model#getAbs()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Abs();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Model#getXbs <em>Xbs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Xbs</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Model#getXbs()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Xbs();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Ab <em>Ab</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ab</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Ab
   * @generated
   */
  EClass getAb();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Ab#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Ab#getX()
   * @see #getAb()
   * @generated
   */
  EAttribute getAb_X();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Ab#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Ab#getY()
   * @see #getAb()
   * @generated
   */
  EAttribute getAb_Y();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb <em>Xb</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Xb</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb
   * @generated
   */
  EClass getXb();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb#getX()
   * @see #getXb()
   * @generated
   */
  EAttribute getXb_X();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb#getY()
   * @see #getXb()
   * @generated
   */
  EAttribute getXb_Y();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.EnumName <em>Enum Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Enum Name</em>'.
   * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.EnumName
   * @generated
   */
  EEnum getEnumName();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  BacktrackingTestLanguageFactory getBacktrackingTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Enums</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__ENUMS = eINSTANCE.getModel_Enums();

    /**
     * The meta object literal for the '<em><b>Abs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ABS = eINSTANCE.getModel_Abs();

    /**
     * The meta object literal for the '<em><b>Xbs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__XBS = eINSTANCE.getModel_Xbs();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.AbImpl <em>Ab</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.AbImpl
     * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguagePackageImpl#getAb()
     * @generated
     */
    EClass AB = eINSTANCE.getAb();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AB__X = eINSTANCE.getAb_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AB__Y = eINSTANCE.getAb_Y();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.XbImpl <em>Xb</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.XbImpl
     * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguagePackageImpl#getXb()
     * @generated
     */
    EClass XB = eINSTANCE.getXb();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XB__X = eINSTANCE.getXb_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XB__Y = eINSTANCE.getXb_Y();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.lexer.backtrackingTestLanguage.EnumName <em>Enum Name</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.EnumName
     * @see org.eclipse.xtext.lexer.backtrackingTestLanguage.impl.BacktrackingTestLanguagePackageImpl#getEnumName()
     * @generated
     */
    EEnum ENUM_NAME = eINSTANCE.getEnumName();

  }

} //BacktrackingTestLanguagePackage
