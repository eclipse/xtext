/**
 */
package org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage;

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
 * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.UnassignedRuleCallTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface UnassignedRuleCallTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "unassignedRuleCallTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/UnassignedRuleCallTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "unassignedRuleCallTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnassignedRuleCallTestLanguagePackage eINSTANCE = org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.UnassignedRuleCallTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.UnassignedRuleCallTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Model Features</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MODEL_FEATURES = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.ModelFeaturesImpl <em>Model Features</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.ModelFeaturesImpl
   * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.UnassignedRuleCallTestLanguagePackageImpl#getModelFeatures()
   * @generated
   */
  int MODEL_FEATURES = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURES__NAME = 0;

  /**
   * The number of structural features of the '<em>Model Features</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURES_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.Model#getModelFeatures <em>Model Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model Features</em>'.
   * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.Model#getModelFeatures()
   * @see #getModel()
   * @generated
   */
  EReference getModel_ModelFeatures();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.ModelFeatures <em>Model Features</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Features</em>'.
   * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.ModelFeatures
   * @generated
   */
  EClass getModelFeatures();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.ModelFeatures#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.ModelFeatures#getName()
   * @see #getModelFeatures()
   * @generated
   */
  EAttribute getModelFeatures_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UnassignedRuleCallTestLanguageFactory getUnassignedRuleCallTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.UnassignedRuleCallTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Model Features</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__MODEL_FEATURES = eINSTANCE.getModel_ModelFeatures();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.ModelFeaturesImpl <em>Model Features</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.ModelFeaturesImpl
     * @see org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.impl.UnassignedRuleCallTestLanguagePackageImpl#getModelFeatures()
     * @generated
     */
    EClass MODEL_FEATURES = eINSTANCE.getModelFeatures();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_FEATURES__NAME = eINSTANCE.getModelFeatures_Name();

  }

} //UnassignedRuleCallTestLanguagePackage
