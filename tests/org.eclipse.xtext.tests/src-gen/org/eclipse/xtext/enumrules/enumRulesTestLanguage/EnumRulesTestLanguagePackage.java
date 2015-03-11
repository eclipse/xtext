/**
 */
package org.eclipse.xtext.enumrules.enumRulesTestLanguage;

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
 * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.EnumRulesTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface EnumRulesTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "enumRulesTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/EnumRulesTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "enumRulesTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EnumRulesTestLanguagePackage eINSTANCE = org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.EnumRulesTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.EnumRulesTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Existing</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__EXISTING = 0;

  /**
   * The feature id for the '<em><b>Generated</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__GENERATED = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum <em>Generated Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum
   * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.EnumRulesTestLanguagePackageImpl#getGeneratedEnum()
   * @generated
   */
  int GENERATED_ENUM = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model#getExisting <em>Existing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Existing</em>'.
   * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model#getExisting()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Existing();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model#getGenerated <em>Generated</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Generated</em>'.
   * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.Model#getGenerated()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Generated();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum <em>Generated Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Generated Enum</em>'.
   * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum
   * @generated
   */
  EEnum getGeneratedEnum();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EnumRulesTestLanguageFactory getEnumRulesTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.EnumRulesTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Existing</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__EXISTING = eINSTANCE.getModel_Existing();

    /**
     * The meta object literal for the '<em><b>Generated</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__GENERATED = eINSTANCE.getModel_Generated();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum <em>Generated Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.GeneratedEnum
     * @see org.eclipse.xtext.enumrules.enumRulesTestLanguage.impl.EnumRulesTestLanguagePackageImpl#getGeneratedEnum()
     * @generated
     */
    EEnum GENERATED_ENUM = eINSTANCE.getGeneratedEnum();

  }

} //EnumRulesTestLanguagePackage
