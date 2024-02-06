/**
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.refactoring.referring;

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
 * @see org.eclipse.xtext.ui.tests.refactoring.referring.ReferringFactory
 * @model kind="package"
 * @generated
 */
public interface ReferringPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "referring";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/referringTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "referring";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReferringPackage eINSTANCE = org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.MainImpl <em>Main</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.MainImpl
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getMain()
   * @generated
   */
  int MAIN = 0;

  /**
   * The feature id for the '<em><b>Referenced</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN__REFERENCED = 0;

  /**
   * The number of structural features of the '<em>Main</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAIN_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.AbstractReferenceImpl <em>Abstract Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.AbstractReferenceImpl
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getAbstractReference()
   * @generated
   */
  int ABSTRACT_REFERENCE = 1;

  /**
   * The number of structural features of the '<em>Abstract Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_REFERENCE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferenceImpl <em>Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferenceImpl
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getReference()
   * @generated
   */
  int REFERENCE = 2;

  /**
   * The feature id for the '<em><b>Referenced</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE__REFERENCED = ABSTRACT_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_FEATURE_COUNT = ABSTRACT_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.Reference2Impl <em>Reference2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.Reference2Impl
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getReference2()
   * @generated
   */
  int REFERENCE2 = 3;

  /**
   * The number of structural features of the '<em>Reference2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE2_FEATURE_COUNT = ABSTRACT_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.NamedImpl <em>Named</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.NamedImpl
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getNamed()
   * @generated
   */
  int NAMED = 4;

  /**
   * The feature id for the '<em><b>Referenced</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED__REFERENCED = REFERENCE2_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED__NAME = REFERENCE2_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Named</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_FEATURE_COUNT = REFERENCE2_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.refactoring.referring.Main <em>Main</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Main</em>'.
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.Main
   * @generated
   */
  EClass getMain();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.refactoring.referring.Main#getReferenced <em>Referenced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Referenced</em>'.
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.Main#getReferenced()
   * @see #getMain()
   * @generated
   */
  EReference getMain_Referenced();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.refactoring.referring.AbstractReference <em>Abstract Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Reference</em>'.
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.AbstractReference
   * @generated
   */
  EClass getAbstractReference();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.refactoring.referring.Reference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference</em>'.
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.Reference
   * @generated
   */
  EClass getReference();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.refactoring.referring.Reference#getReferenced <em>Referenced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referenced</em>'.
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.Reference#getReferenced()
   * @see #getReference()
   * @generated
   */
  EReference getReference_Referenced();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.refactoring.referring.Reference2 <em>Reference2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference2</em>'.
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.Reference2
   * @generated
   */
  EClass getReference2();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.refactoring.referring.Named <em>Named</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named</em>'.
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.Named
   * @generated
   */
  EClass getNamed();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.refactoring.referring.Named#getReferenced <em>Referenced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referenced</em>'.
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.Named#getReferenced()
   * @see #getNamed()
   * @generated
   */
  EReference getNamed_Referenced();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.refactoring.referring.Named#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.refactoring.referring.Named#getName()
   * @see #getNamed()
   * @generated
   */
  EAttribute getNamed_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ReferringFactory getReferringFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.MainImpl <em>Main</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.MainImpl
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getMain()
     * @generated
     */
    EClass MAIN = eINSTANCE.getMain();

    /**
     * The meta object literal for the '<em><b>Referenced</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAIN__REFERENCED = eINSTANCE.getMain_Referenced();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.AbstractReferenceImpl <em>Abstract Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.AbstractReferenceImpl
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getAbstractReference()
     * @generated
     */
    EClass ABSTRACT_REFERENCE = eINSTANCE.getAbstractReference();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferenceImpl <em>Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferenceImpl
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getReference()
     * @generated
     */
    EClass REFERENCE = eINSTANCE.getReference();

    /**
     * The meta object literal for the '<em><b>Referenced</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE__REFERENCED = eINSTANCE.getReference_Referenced();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.Reference2Impl <em>Reference2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.Reference2Impl
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getReference2()
     * @generated
     */
    EClass REFERENCE2 = eINSTANCE.getReference2();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.refactoring.referring.impl.NamedImpl <em>Named</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.NamedImpl
     * @see org.eclipse.xtext.ui.tests.refactoring.referring.impl.ReferringPackageImpl#getNamed()
     * @generated
     */
    EClass NAMED = eINSTANCE.getNamed();

    /**
     * The meta object literal for the '<em><b>Referenced</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED__REFERENCED = eINSTANCE.getNamed_Referenced();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

  }

} //ReferringPackage
