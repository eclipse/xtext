/**
 */
package org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
  String eNS_URI = "http://formatter2/regionaccesstestlanguage";

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
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__MIXED = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 1;

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
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE__MIXED = ROOT__MIXED;

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
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELEGATION__MIXED = ROOT__MIXED;

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
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNASSIGNED__MIXED = ROOT__MIXED;

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
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIXED_UNASSIGNED__MIXED = ROOT__MIXED;

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
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DELEGATE__MIXED = UNASSIGNED__MIXED;

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
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.ExpressionImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 7;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__MIXED = ROOT__MIXED;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = ROOT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.MixedImpl <em>Mixed</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.MixedImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getMixed()
   * @generated
   */
  int MIXED = 8;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED__MIXED = ROOT__MIXED;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED__NAME = ROOT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Eobj</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED__EOBJ = ROOT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED__DATATYPE = ROOT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED__REF = ROOT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Lit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED__LIT = ROOT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Mixed</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MIXED_FEATURE_COUNT = ROOT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AddImpl <em>Add</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AddImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getAdd()
   * @generated
   */
  int ADD = 9;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__MIXED = EXPRESSION__MIXED;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Add</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.NamedImpl <em>Named</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.NamedImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getNamed()
   * @generated
   */
  int NAMED = 10;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED__MIXED = EXPRESSION__MIXED;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED__NAME = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.ActionImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getAction()
   * @generated
   */
  int ACTION = 11;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__MIXED = MIXED__MIXED;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__NAME = MIXED__NAME;

  /**
   * The feature id for the '<em><b>Eobj</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__EOBJ = MIXED__EOBJ;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__DATATYPE = MIXED__DATATYPE;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__REF = MIXED__REF;

  /**
   * The feature id for the '<em><b>Lit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__LIT = MIXED__LIT;

  /**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FEATURE_COUNT = MIXED_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AssignedActionImpl <em>Assigned Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AssignedActionImpl
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getAssignedAction()
   * @generated
   */
  int ASSIGNED_ACTION = 12;

  /**
   * The feature id for the '<em><b>Mixed</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_ACTION__MIXED = MIXED__MIXED;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_ACTION__NAME = MIXED__NAME;

  /**
   * The feature id for the '<em><b>Eobj</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_ACTION__EOBJ = MIXED__EOBJ;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_ACTION__DATATYPE = MIXED__DATATYPE;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_ACTION__REF = MIXED__REF;

  /**
   * The feature id for the '<em><b>Lit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_ACTION__LIT = MIXED__LIT;

  /**
   * The feature id for the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_ACTION__CHILD = MIXED_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_ACTION__BODY = MIXED_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Assigned Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNED_ACTION_FEATURE_COUNT = MIXED_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum <em>Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getEnum()
   * @generated
   */
  int ENUM = 13;


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
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root#getMixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mixed</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root#getMixed()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_Mixed();

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
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed <em>Mixed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mixed</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed
   * @generated
   */
  EClass getMixed();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getName()
   * @see #getMixed()
   * @generated
   */
  EAttribute getMixed_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getEobj <em>Eobj</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Eobj</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getEobj()
   * @see #getMixed()
   * @generated
   */
  EReference getMixed_Eobj();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getDatatype <em>Datatype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Datatype</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getDatatype()
   * @see #getMixed()
   * @generated
   */
  EAttribute getMixed_Datatype();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getRef()
   * @see #getMixed()
   * @generated
   */
  EReference getMixed_Ref();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getLit <em>Lit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lit</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed#getLit()
   * @see #getMixed()
   * @generated
   */
  EAttribute getMixed_Lit();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add <em>Add</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Add</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add
   * @generated
   */
  EClass getAdd();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add#getLeft()
   * @see #getAdd()
   * @generated
   */
  EReference getAdd_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Add#getRight()
   * @see #getAdd()
   * @generated
   */
  EReference getAdd_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Named <em>Named</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Named
   * @generated
   */
  EClass getNamed();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Named#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Named#getName()
   * @see #getNamed()
   * @generated
   */
  EAttribute getNamed_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction <em>Assigned Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assigned Action</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction
   * @generated
   */
  EClass getAssignedAction();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction#getChild()
   * @see #getAssignedAction()
   * @generated
   */
  EReference getAssignedAction_Child();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction#getBody()
   * @see #getAssignedAction()
   * @generated
   */
  EReference getAssignedAction_Body();

  /**
   * Returns the meta object for enum '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum <em>Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Enum</em>'.
   * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum
   * @generated
   */
  EEnum getEnum();

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
     * The meta object literal for the '<em><b>Mixed</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__MIXED = eINSTANCE.getRoot_Mixed();

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

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.ExpressionImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.MixedImpl <em>Mixed</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.MixedImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getMixed()
     * @generated
     */
    EClass MIXED = eINSTANCE.getMixed();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MIXED__NAME = eINSTANCE.getMixed_Name();

    /**
     * The meta object literal for the '<em><b>Eobj</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MIXED__EOBJ = eINSTANCE.getMixed_Eobj();

    /**
     * The meta object literal for the '<em><b>Datatype</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MIXED__DATATYPE = eINSTANCE.getMixed_Datatype();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MIXED__REF = eINSTANCE.getMixed_Ref();

    /**
     * The meta object literal for the '<em><b>Lit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MIXED__LIT = eINSTANCE.getMixed_Lit();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AddImpl <em>Add</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AddImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getAdd()
     * @generated
     */
    EClass ADD = eINSTANCE.getAdd();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD__LEFT = eINSTANCE.getAdd_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD__RIGHT = eINSTANCE.getAdd_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.NamedImpl <em>Named</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.NamedImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getNamed()
     * @generated
     */
    EClass NAMED = eINSTANCE.getNamed();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.ActionImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getAction()
     * @generated
     */
    EClass ACTION = eINSTANCE.getAction();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AssignedActionImpl <em>Assigned Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.AssignedActionImpl
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getAssignedAction()
     * @generated
     */
    EClass ASSIGNED_ACTION = eINSTANCE.getAssignedAction();

    /**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNED_ACTION__CHILD = eINSTANCE.getAssignedAction_Child();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNED_ACTION__BODY = eINSTANCE.getAssignedAction_Body();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum <em>Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Enum
     * @see org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.impl.RegionaccesstestlanguagePackageImpl#getEnum()
     * @generated
     */
    EEnum ENUM = eINSTANCE.getEnum();

  }

} //RegionaccesstestlanguagePackage
