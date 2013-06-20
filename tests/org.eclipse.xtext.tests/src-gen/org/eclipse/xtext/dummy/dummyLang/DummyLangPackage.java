/**
 */
package org.eclipse.xtext.dummy.dummyLang;

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
 * @see org.eclipse.xtext.dummy.dummyLang.DummyLangFactory
 * @model kind="package"
 * @generated
 */
public interface DummyLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dummyLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/xtext/DummyLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dummyLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DummyLangPackage eINSTANCE = org.eclipse.xtext.dummy.dummyLang.impl.DummyLangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.dummy.dummyLang.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.dummy.dummyLang.impl.ModelImpl
   * @see org.eclipse.xtext.dummy.dummyLang.impl.DummyLangPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.dummy.dummyLang.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.dummy.dummyLang.impl.ElementImpl
   * @see org.eclipse.xtext.dummy.dummyLang.impl.DummyLangPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__OPTIONAL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__NAME = 1;

  /**
   * The feature id for the '<em><b>Descriptions</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__DESCRIPTIONS = 2;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.dummy.dummyLang.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.dummy.dummyLang.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.dummy.dummyLang.Model#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.dummy.dummyLang.Model#getElements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.dummy.dummyLang.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see org.eclipse.xtext.dummy.dummyLang.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.dummy.dummyLang.Element#isOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see org.eclipse.xtext.dummy.dummyLang.Element#isOptional()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Optional();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.dummy.dummyLang.Element#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.dummy.dummyLang.Element#getName()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.dummy.dummyLang.Element#getDescriptions <em>Descriptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Descriptions</em>'.
   * @see org.eclipse.xtext.dummy.dummyLang.Element#getDescriptions()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Descriptions();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DummyLangFactory getDummyLangFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.dummy.dummyLang.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.dummy.dummyLang.impl.ModelImpl
     * @see org.eclipse.xtext.dummy.dummyLang.impl.DummyLangPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENTS = eINSTANCE.getModel_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.dummy.dummyLang.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.dummy.dummyLang.impl.ElementImpl
     * @see org.eclipse.xtext.dummy.dummyLang.impl.DummyLangPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__OPTIONAL = eINSTANCE.getElement_Optional();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

    /**
     * The meta object literal for the '<em><b>Descriptions</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__DESCRIPTIONS = eINSTANCE.getElement_Descriptions();

  }

} //DummyLangPackage
