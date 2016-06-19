/**
 */
package org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage;

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
 * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypeRulesTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "datatypeRulesTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/DatatypeRulesTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "datatypeRulesTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DatatypeRulesTestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.DatatypeRulesTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.CompositeModelImpl <em>Composite Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.CompositeModelImpl
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.DatatypeRulesTestLanguagePackageImpl#getCompositeModel()
   * @generated
   */
  int COMPOSITE_MODEL = 0;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_MODEL__MODEL = 0;

  /**
   * The number of structural features of the '<em>Composite Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.DatatypeRulesTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ID = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__VALUE = 1;

  /**
   * The feature id for the '<em><b>Vector</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__VECTOR = 2;

  /**
   * The feature id for the '<em><b>Dots</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DOTS = 3;

  /**
   * The feature id for the '<em><b>Double</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DOUBLE = 4;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 5;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.CompositeModel <em>Composite Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composite Model</em>'.
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.CompositeModel
   * @generated
   */
  EClass getCompositeModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.CompositeModel#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.CompositeModel#getModel()
   * @see #getCompositeModel()
   * @generated
   */
  EReference getCompositeModel_Model();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getId()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Id();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getValue()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Value();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getVector <em>Vector</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Vector</em>'.
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getVector()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Vector();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getDots <em>Dots</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dots</em>'.
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getDots()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Dots();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getDouble <em>Double</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Double</em>'.
   * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model#getDouble()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Double();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DatatypeRulesTestLanguageFactory getDatatypeRulesTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.CompositeModelImpl <em>Composite Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.CompositeModelImpl
     * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.DatatypeRulesTestLanguagePackageImpl#getCompositeModel()
     * @generated
     */
    EClass COMPOSITE_MODEL = eINSTANCE.getCompositeModel();

    /**
     * The meta object literal for the '<em><b>Model</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_MODEL__MODEL = eINSTANCE.getCompositeModel_Model();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.impl.DatatypeRulesTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__ID = eINSTANCE.getModel_Id();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__VALUE = eINSTANCE.getModel_Value();

    /**
     * The meta object literal for the '<em><b>Vector</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__VECTOR = eINSTANCE.getModel_Vector();

    /**
     * The meta object literal for the '<em><b>Dots</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__DOTS = eINSTANCE.getModel_Dots();

    /**
     * The meta object literal for the '<em><b>Double</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__DOUBLE = eINSTANCE.getModel_Double();

  }

} //DatatypeRulesTestLanguagePackage
