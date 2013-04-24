/**
 */
package org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage;

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
 * @see org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface MultiValueFeatureTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "multiValueFeatureTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/xtext/MultiValueFeatureTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "multiValueFeatureTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MultiValueFeatureTestLanguagePackage eINSTANCE = org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl.MultiValueFeatureTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl.StartImpl <em>Start</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl.StartImpl
   * @see org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl.MultiValueFeatureTestLanguagePackageImpl#getStart()
   * @generated
   */
  int START = 0;

  /**
   * The feature id for the '<em><b>Feature A</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START__FEATURE_A = 0;

  /**
   * The number of structural features of the '<em>Start</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int START_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.Start <em>Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Start</em>'.
   * @see org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.Start
   * @generated
   */
  EClass getStart();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.Start#getFeatureA <em>Feature A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Feature A</em>'.
   * @see org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.Start#getFeatureA()
   * @see #getStart()
   * @generated
   */
  EAttribute getStart_FeatureA();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MultiValueFeatureTestLanguageFactory getMultiValueFeatureTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl.StartImpl <em>Start</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl.StartImpl
     * @see org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.impl.MultiValueFeatureTestLanguagePackageImpl#getStart()
     * @generated
     */
    EClass START = eINSTANCE.getStart();

    /**
     * The meta object literal for the '<em><b>Feature A</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute START__FEATURE_A = eINSTANCE.getStart_FeatureA();

  }

} //MultiValueFeatureTestLanguagePackage
