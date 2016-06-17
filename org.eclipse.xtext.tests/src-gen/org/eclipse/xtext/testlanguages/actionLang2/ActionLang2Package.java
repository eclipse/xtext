/**
 */
package org.eclipse.xtext.testlanguages.actionLang2;

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
 * @see org.eclipse.xtext.testlanguages.actionLang2.ActionLang2Factory
 * @model kind="package"
 * @generated
 */
public interface ActionLang2Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "actionLang2";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/ActionLang2";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "actionLang2";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ActionLang2Package eINSTANCE = org.eclipse.xtext.testlanguages.actionLang2.impl.ActionLang2PackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang2.impl.ORingImpl <em>ORing</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang2.impl.ORingImpl
   * @see org.eclipse.xtext.testlanguages.actionLang2.impl.ActionLang2PackageImpl#getORing()
   * @generated
   */
  int ORING = 0;

  /**
   * The feature id for the '<em><b>Disjuncts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORING__DISJUNCTS = 0;

  /**
   * The number of structural features of the '<em>ORing</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORING_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang2.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang2.impl.ValueImpl
   * @see org.eclipse.xtext.testlanguages.actionLang2.impl.ActionLang2PackageImpl#getValue()
   * @generated
   */
  int VALUE = 1;

  /**
   * The feature id for the '<em><b>Disjuncts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__DISJUNCTS = ORING__DISJUNCTS;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE__VALUE = ORING_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = ORING_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang2.ORing <em>ORing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ORing</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang2.ORing
   * @generated
   */
  EClass getORing();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.actionLang2.ORing#getDisjuncts <em>Disjuncts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Disjuncts</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang2.ORing#getDisjuncts()
   * @see #getORing()
   * @generated
   */
  EReference getORing_Disjuncts();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang2.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang2.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.actionLang2.Value#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang2.Value#getValue()
   * @see #getValue()
   * @generated
   */
  EAttribute getValue_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ActionLang2Factory getActionLang2Factory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang2.impl.ORingImpl <em>ORing</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang2.impl.ORingImpl
     * @see org.eclipse.xtext.testlanguages.actionLang2.impl.ActionLang2PackageImpl#getORing()
     * @generated
     */
    EClass ORING = eINSTANCE.getORing();

    /**
     * The meta object literal for the '<em><b>Disjuncts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ORING__DISJUNCTS = eINSTANCE.getORing_Disjuncts();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang2.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang2.impl.ValueImpl
     * @see org.eclipse.xtext.testlanguages.actionLang2.impl.ActionLang2PackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VALUE__VALUE = eINSTANCE.getValue_Value();

  }

} //ActionLang2Package
