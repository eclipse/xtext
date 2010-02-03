/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.TwoContextsFactory
 * @model kind="package"
 * @generated
 */
public interface TwoContextsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "twoContexts";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2009/twoContexts";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "twoContexts";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TwoContextsPackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.TwoContextsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.MainModelImpl <em>Main Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.MainModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.TwoContextsPackageImpl#getMainModel()
   * @generated
   */
  int MAIN_MODEL = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_MODEL__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Main Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.AnElementImpl <em>An Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.AnElementImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.TwoContextsPackageImpl#getAnElement()
   * @generated
   */
  int AN_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AN_ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Referred</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AN_ELEMENT__REFERRED = 1;

  /**
   * The number of structural features of the '<em>An Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AN_ELEMENT_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.MainModel <em>Main Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Main Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.MainModel
   * @generated
   */
  EClass getMainModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.MainModel#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.MainModel#getElements()
   * @see #getMainModel()
   * @generated
   */
  EReference getMainModel_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.AnElement <em>An Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>An Element</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.AnElement
   * @generated
   */
  EClass getAnElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.AnElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.AnElement#getName()
   * @see #getAnElement()
   * @generated
   */
  EAttribute getAnElement_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.AnElement#getReferred <em>Referred</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referred</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.AnElement#getReferred()
   * @see #getAnElement()
   * @generated
   */
  EReference getAnElement_Referred();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TwoContextsFactory getTwoContextsFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.MainModelImpl <em>Main Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.MainModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.TwoContextsPackageImpl#getMainModel()
     * @generated
     */
    EClass MAIN_MODEL = eINSTANCE.getMainModel();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAIN_MODEL__ELEMENTS = eINSTANCE.getMainModel_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.AnElementImpl <em>An Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.AnElementImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.twoContexts.impl.TwoContextsPackageImpl#getAnElement()
     * @generated
     */
    EClass AN_ELEMENT = eINSTANCE.getAnElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AN_ELEMENT__NAME = eINSTANCE.getAnElement_Name();

    /**
     * The meta object literal for the '<em><b>Referred</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AN_ELEMENT__REFERRED = eINSTANCE.getAnElement_Referred();

  }

} //TwoContextsPackage
