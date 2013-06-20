/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage;

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
 * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.SerializationBug269362TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface SerializationBug269362TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "serializationBug269362TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/SerializationBugTest/269362";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "serializationBug269362TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SerializationBug269362TestLanguagePackage eINSTANCE = org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl.SerializationBug269362TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl.SerializationBug269362TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Foo</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FOO = 0;

  /**
   * The feature id for the '<em><b>Bar</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__BAR = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getFoo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Foo</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getFoo()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Foo();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getBar <em>Bar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bar</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.Model#getBar()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Bar();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SerializationBug269362TestLanguageFactory getSerializationBug269362TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parsetree.reconstr.serializationBug269362TestLanguage.impl.SerializationBug269362TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Foo</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__FOO = eINSTANCE.getModel_Foo();

    /**
     * The meta object literal for the '<em><b>Bar</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__BAR = eINSTANCE.getModel_Bar();

  }

} //SerializationBug269362TestLanguagePackage
