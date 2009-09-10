/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest;

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
 * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.LookAheadContentAssistTestFactory
 * @model kind="package"
 * @generated
 */
public interface LookAheadContentAssistTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "lookAheadContentAssistTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2009/lookAheadContentAssistTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "lookAheadContentAssistTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  LookAheadContentAssistTestPackage eINSTANCE = org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.LookAheadContentAssistTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.ModelImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.LookAheadContentAssistTestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ATTRIBUTE = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.AttributeImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.LookAheadContentAssistTestPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = 0;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.PairImpl <em>Pair</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.PairImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.LookAheadContentAssistTestPackageImpl#getPair()
   * @generated
   */
  int PAIR = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAIR__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAIR__VALUE = 1;

  /**
   * The number of structural features of the '<em>Pair</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAIR_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Model#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Model#getAttribute()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Attribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Pair <em>Pair</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pair</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Pair
   * @generated
   */
  EClass getPair();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Pair#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Pair#getName()
   * @see #getPair()
   * @generated
   */
  EAttribute getPair_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Pair#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.Pair#getValue()
   * @see #getPair()
   * @generated
   */
  EAttribute getPair_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  LookAheadContentAssistTestFactory getLookAheadContentAssistTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.ModelImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.LookAheadContentAssistTestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ATTRIBUTE = eINSTANCE.getModel_Attribute();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.AttributeImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.LookAheadContentAssistTestPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.PairImpl <em>Pair</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.PairImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.lookAheadContentAssistTest.impl.LookAheadContentAssistTestPackageImpl#getPair()
     * @generated
     */
    EClass PAIR = eINSTANCE.getPair();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PAIR__NAME = eINSTANCE.getPair_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PAIR__VALUE = eINSTANCE.getPair_Value();

  }

} //LookAheadContentAssistTestPackage
