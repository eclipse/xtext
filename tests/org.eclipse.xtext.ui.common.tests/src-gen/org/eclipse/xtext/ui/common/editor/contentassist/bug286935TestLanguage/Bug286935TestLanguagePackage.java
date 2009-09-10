/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage;

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
 * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.Bug286935TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug286935TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug286935TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2009/bug286935TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug286935TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug286935TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.Bug286935TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.StateImpl
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.Bug286935TestLanguagePackageImpl#getState()
   * @generated
   */
  int STATE = 0;

  /**
   * The feature id for the '<em><b>Is Initial</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__IS_INITIAL = 0;

  /**
   * The feature id for the '<em><b>Is Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__IS_FINAL = 1;

  /**
   * The feature id for the '<em><b>State Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__STATE_KIND = 2;

  /**
   * The feature id for the '<em><b>State Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__STATE_NAME = 3;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__LABEL = 4;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.StateType <em>State Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.StateType
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.Bug286935TestLanguagePackageImpl#getStateType()
   * @generated
   */
  int STATE_TYPE = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#isIsInitial <em>Is Initial</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Initial</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#isIsInitial()
   * @see #getState()
   * @generated
   */
  EAttribute getState_IsInitial();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#isIsFinal <em>Is Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Final</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#isIsFinal()
   * @see #getState()
   * @generated
   */
  EAttribute getState_IsFinal();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#getStateKind <em>State Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Kind</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#getStateKind()
   * @see #getState()
   * @generated
   */
  EAttribute getState_StateKind();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#getStateName <em>State Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Name</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#getStateName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_StateName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.State#getLabel()
   * @see #getState()
   * @generated
   */
  EAttribute getState_Label();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.StateType <em>State Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>State Type</em>'.
   * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.StateType
   * @generated
   */
  EEnum getStateType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug286935TestLanguageFactory getBug286935TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.StateImpl
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.Bug286935TestLanguagePackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>Is Initial</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__IS_INITIAL = eINSTANCE.getState_IsInitial();

    /**
     * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__IS_FINAL = eINSTANCE.getState_IsFinal();

    /**
     * The meta object literal for the '<em><b>State Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__STATE_KIND = eINSTANCE.getState_StateKind();

    /**
     * The meta object literal for the '<em><b>State Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__STATE_NAME = eINSTANCE.getState_StateName();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__LABEL = eINSTANCE.getState_Label();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.StateType <em>State Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.StateType
     * @see org.eclipse.xtext.ui.common.editor.contentassist.bug286935TestLanguage.impl.Bug286935TestLanguagePackageImpl#getStateType()
     * @generated
     */
    EEnum STATE_TYPE = eINSTANCE.getStateType();

  }

} //Bug286935TestLanguagePackage
