/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testlanguages.actionLang3;

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
 * @see org.eclipse.xtext.testlanguages.actionLang3.ActionLang3Factory
 * @model kind="package"
 * @generated
 */
public interface ActionLang3Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "actionLang3";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/ActionLang3";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "actionLang3";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ActionLang3Package eINSTANCE = org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRulesImpl <em>Production Rules</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRulesImpl
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getProductionRules()
   * @generated
   */
  int PRODUCTION_RULES = 0;

  /**
   * The number of structural features of the '<em>Production Rules</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_RULES_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRule1Impl <em>Production Rule1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRule1Impl
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getProductionRule1()
   * @generated
   */
  int PRODUCTION_RULE1 = 1;

  /**
   * The number of structural features of the '<em>Production Rule1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_RULE1_FEATURE_COUNT = PRODUCTION_RULES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRule2Impl <em>Production Rule2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRule2Impl
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getProductionRule2()
   * @generated
   */
  int PRODUCTION_RULE2 = 2;

  /**
   * The number of structural features of the '<em>Production Rule2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_RULE2_FEATURE_COUNT = PRODUCTION_RULES_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.P1Impl <em>P1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.P1Impl
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getP1()
   * @generated
   */
  int P1 = 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int P1__ID = PRODUCTION_RULE1_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>P1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int P1_FEATURE_COUNT = PRODUCTION_RULE1_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.P2Impl <em>P2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.P2Impl
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getP2()
   * @generated
   */
  int P2 = 4;

  /**
   * The feature id for the '<em><b>P</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int P2__P = PRODUCTION_RULE1_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int P2__STRING = PRODUCTION_RULE1_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>P2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int P2_FEATURE_COUNT = PRODUCTION_RULE1_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.P3Impl <em>P3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.P3Impl
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getP3()
   * @generated
   */
  int P3 = 5;

  /**
   * The feature id for the '<em><b>P</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int P3__P = PRODUCTION_RULE1_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>I</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int P3__I = PRODUCTION_RULE1_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>P3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int P3_FEATURE_COUNT = PRODUCTION_RULE1_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.EntryImpl <em>Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.EntryImpl
   * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getEntry()
   * @generated
   */
  int ENTRY = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY__NAME = PRODUCTION_RULE2_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_FEATURE_COUNT = PRODUCTION_RULE2_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang3.ProductionRules <em>Production Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Rules</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.ProductionRules
   * @generated
   */
  EClass getProductionRules();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang3.ProductionRule1 <em>Production Rule1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Rule1</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.ProductionRule1
   * @generated
   */
  EClass getProductionRule1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang3.ProductionRule2 <em>Production Rule2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Rule2</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.ProductionRule2
   * @generated
   */
  EClass getProductionRule2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang3.P1 <em>P1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>P1</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.P1
   * @generated
   */
  EClass getP1();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.actionLang3.P1#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.P1#getId()
   * @see #getP1()
   * @generated
   */
  EAttribute getP1_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang3.P2 <em>P2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>P2</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.P2
   * @generated
   */
  EClass getP2();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.testlanguages.actionLang3.P2#getP <em>P</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>P</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.P2#getP()
   * @see #getP2()
   * @generated
   */
  EReference getP2_P();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.actionLang3.P2#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.P2#getString()
   * @see #getP2()
   * @generated
   */
  EAttribute getP2_String();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang3.P3 <em>P3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>P3</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.P3
   * @generated
   */
  EClass getP3();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.testlanguages.actionLang3.P3#getP <em>P</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>P</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.P3#getP()
   * @see #getP3()
   * @generated
   */
  EReference getP3_P();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.actionLang3.P3#getI <em>I</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>I</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.P3#getI()
   * @see #getP3()
   * @generated
   */
  EAttribute getP3_I();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang3.Entry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.Entry
   * @generated
   */
  EClass getEntry();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.actionLang3.Entry#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang3.Entry#getName()
   * @see #getEntry()
   * @generated
   */
  EAttribute getEntry_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ActionLang3Factory getActionLang3Factory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRulesImpl <em>Production Rules</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRulesImpl
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getProductionRules()
     * @generated
     */
    EClass PRODUCTION_RULES = eINSTANCE.getProductionRules();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRule1Impl <em>Production Rule1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRule1Impl
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getProductionRule1()
     * @generated
     */
    EClass PRODUCTION_RULE1 = eINSTANCE.getProductionRule1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRule2Impl <em>Production Rule2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ProductionRule2Impl
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getProductionRule2()
     * @generated
     */
    EClass PRODUCTION_RULE2 = eINSTANCE.getProductionRule2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.P1Impl <em>P1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.P1Impl
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getP1()
     * @generated
     */
    EClass P1 = eINSTANCE.getP1();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute P1__ID = eINSTANCE.getP1_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.P2Impl <em>P2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.P2Impl
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getP2()
     * @generated
     */
    EClass P2 = eINSTANCE.getP2();

    /**
     * The meta object literal for the '<em><b>P</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference P2__P = eINSTANCE.getP2_P();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute P2__STRING = eINSTANCE.getP2_String();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.P3Impl <em>P3</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.P3Impl
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getP3()
     * @generated
     */
    EClass P3 = eINSTANCE.getP3();

    /**
     * The meta object literal for the '<em><b>P</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference P3__P = eINSTANCE.getP3_P();

    /**
     * The meta object literal for the '<em><b>I</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute P3__I = eINSTANCE.getP3_I();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang3.impl.EntryImpl <em>Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.EntryImpl
     * @see org.eclipse.xtext.testlanguages.actionLang3.impl.ActionLang3PackageImpl#getEntry()
     * @generated
     */
    EClass ENTRY = eINSTANCE.getEntry();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTRY__NAME = eINSTANCE.getEntry_Name();

  }

} //ActionLang3Package
