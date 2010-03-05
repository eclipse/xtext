/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.quickfix.importUriUi;

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
 * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.ImportUriUiFactory
 * @model kind="package"
 * @generated
 */
public interface ImportUriUiPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "importUriUi";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://eclipse.org/xtext/quickfixCrossrefTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "importUriUi";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ImportUriUiPackage eINSTANCE = org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.ImportUriUiPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.MainImpl <em>Main</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.MainImpl
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.ImportUriUiPackageImpl#getMain()
   * @generated
   */
  int MAIN = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Main</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.ElementImpl
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.ImportUriUiPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Contained</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__CONTAINED = 1;

  /**
   * The feature id for the '<em><b>Referenced</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT__REFERENCED = 2;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.Main <em>Main</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Main</em>'.
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.Main
   * @generated
   */
  EClass getMain();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.Main#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.Main#getElements()
   * @see #getMain()
   * @generated
   */
  EReference getMain_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element#getName()
   * @see #getElement()
   * @generated
   */
  EAttribute getElement_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element#getContained <em>Contained</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contained</em>'.
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element#getContained()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Contained();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element#getReferenced <em>Referenced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Referenced</em>'.
   * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.Element#getReferenced()
   * @see #getElement()
   * @generated
   */
  EReference getElement_Referenced();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ImportUriUiFactory getImportUriUiFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.MainImpl <em>Main</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.MainImpl
     * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.ImportUriUiPackageImpl#getMain()
     * @generated
     */
    EClass MAIN = eINSTANCE.getMain();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAIN__ELEMENTS = eINSTANCE.getMain_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.ElementImpl
     * @see org.eclipse.xtext.ui.tests.quickfix.importUriUi.impl.ImportUriUiPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

    /**
     * The meta object literal for the '<em><b>Contained</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__CONTAINED = eINSTANCE.getElement_Contained();

    /**
     * The meta object literal for the '<em><b>Referenced</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT__REFERENCED = eINSTANCE.getElement_Referenced();

  }

} //ImportUriUiPackage
