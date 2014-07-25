/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage;

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
 * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguageFactory
 * @model kind="package"
 * @generated
 */
public interface RegionaccesstestlanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "regionaccesstestlanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://simple/regionaccesstestlanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "regionaccesstestlanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RegionaccesstestlanguagePackage eINSTANCE = org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RootImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getRoot()
   * @generated
   */
  int ROOT = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.SimpleImpl <em>Simple</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.SimpleImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getSimple()
   * @generated
   */
  int SIMPLE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE__NAME = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.DelegationImpl <em>Delegation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.DelegationImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getDelegation()
   * @generated
   */
  int DELEGATION = 2;

  /**
   * The feature id for the '<em><b>Delegate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELEGATION__DELEGATE = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Delegation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELEGATION_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.UnassignedImpl <em>Unassigned</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.UnassignedImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getUnassigned()
   * @generated
   */
  int UNASSIGNED = 3;

  /**
   * The number of structural features of the '<em>Unassigned</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNASSIGNED_FEATURE_COUNT = ROOT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.PrefixedUnassignedImpl <em>Prefixed Unassigned</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.PrefixedUnassignedImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getPrefixedUnassigned()
   * @generated
   */
  int PREFIXED_UNASSIGNED = 4;

  /**
   * The feature id for the '<em><b>Delegate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIXED_UNASSIGNED__DELEGATE = ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Prefixed Unassigned</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIXED_UNASSIGNED_FEATURE_COUNT = ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.PrefixedDelegateImpl <em>Prefixed Delegate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.PrefixedDelegateImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getPrefixedDelegate()
   * @generated
   */
  int PREFIXED_DELEGATE = 5;

  /**
   * The number of structural features of the '<em>Prefixed Delegate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIXED_DELEGATE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.DelegateImpl <em>Delegate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.DelegateImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getDelegate()
   * @generated
   */
  int DELEGATE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELEGATE__NAME = UNASSIGNED_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Delegate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELEGATE_FEATURE_COUNT = UNASSIGNED_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Simple <em>Simple</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Simple
   * @generated
   */
  EClass getSimple();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Simple#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Simple#getName()
   * @see #getSimple()
   * @generated
   */
  EAttribute getSimple_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation <em>Delegation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Delegation</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation
   * @generated
   */
  EClass getDelegation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation#getDelegate <em>Delegate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Delegate</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegation#getDelegate()
   * @see #getDelegation()
   * @generated
   */
  EReference getDelegation_Delegate();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Unassigned <em>Unassigned</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unassigned</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Unassigned
   * @generated
   */
  EClass getUnassigned();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned <em>Prefixed Unassigned</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prefixed Unassigned</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned
   * @generated
   */
  EClass getPrefixedUnassigned();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned#getDelegate <em>Delegate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Delegate</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedUnassigned#getDelegate()
   * @see #getPrefixedUnassigned()
   * @generated
   */
  EReference getPrefixedUnassigned_Delegate();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedDelegate <em>Prefixed Delegate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prefixed Delegate</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.PrefixedDelegate
   * @generated
   */
  EClass getPrefixedDelegate();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate <em>Delegate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Delegate</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate
   * @generated
   */
  EClass getDelegate();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Delegate#getName()
   * @see #getDelegate()
   * @generated
   */
  EAttribute getDelegate_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RegionaccesstestlanguageFactory getRegionaccesstestlanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RootImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.SimpleImpl <em>Simple</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.SimpleImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getSimple()
     * @generated
     */
    EClass SIMPLE = eINSTANCE.getSimple();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE__NAME = eINSTANCE.getSimple_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.DelegationImpl <em>Delegation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.DelegationImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getDelegation()
     * @generated
     */
    EClass DELEGATION = eINSTANCE.getDelegation();

    /**
     * The meta object literal for the '<em><b>Delegate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DELEGATION__DELEGATE = eINSTANCE.getDelegation_Delegate();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.UnassignedImpl <em>Unassigned</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.UnassignedImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getUnassigned()
     * @generated
     */
    EClass UNASSIGNED = eINSTANCE.getUnassigned();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.PrefixedUnassignedImpl <em>Prefixed Unassigned</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.PrefixedUnassignedImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getPrefixedUnassigned()
     * @generated
     */
    EClass PREFIXED_UNASSIGNED = eINSTANCE.getPrefixedUnassigned();

    /**
     * The meta object literal for the '<em><b>Delegate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREFIXED_UNASSIGNED__DELEGATE = eINSTANCE.getPrefixedUnassigned_Delegate();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.PrefixedDelegateImpl <em>Prefixed Delegate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.PrefixedDelegateImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getPrefixedDelegate()
     * @generated
     */
    EClass PREFIXED_DELEGATE = eINSTANCE.getPrefixedDelegate();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.DelegateImpl <em>Delegate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.DelegateImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getDelegate()
     * @generated
     */
    EClass DELEGATE = eINSTANCE.getDelegate();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DELEGATE__NAME = eINSTANCE.getDelegate_Name();

  }

} //RegionaccesstestlanguagePackage
