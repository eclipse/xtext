/**
 */
package org.eclipse.xtext.parser.assignments.bug287184Test;

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
 * @see org.eclipse.xtext.parser.assignments.bug287184Test.Bug287184TestFactory
 * @model kind="package"
 * @generated
 */
public interface Bug287184TestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug287184Test";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/Bug287184Test";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug287184Test";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug287184TestPackage eINSTANCE = org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.ModelImpl
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NAME = 0;

  /**
   * The feature id for the '<em><b>Detail</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__DETAIL = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.impl.AbstractDetailImpl <em>Abstract Detail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.AbstractDetailImpl
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestPackageImpl#getAbstractDetail()
   * @generated
   */
  int ABSTRACT_DETAIL = 1;

  /**
   * The feature id for the '<em><b>Detail Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DETAIL__DETAIL_CLASS = 0;

  /**
   * The number of structural features of the '<em>Abstract Detail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_DETAIL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.impl.DetailImpl <em>Detail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.DetailImpl
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestPackageImpl#getDetail()
   * @generated
   */
  int DETAIL = 2;

  /**
   * The feature id for the '<em><b>Detail Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETAIL__DETAIL_CLASS = ABSTRACT_DETAIL__DETAIL_CLASS;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETAIL__VISIBILITY = ABSTRACT_DETAIL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Detail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DETAIL_FEATURE_COUNT = ABSTRACT_DETAIL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.impl.AssociatedDetailImpl <em>Associated Detail</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.AssociatedDetailImpl
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestPackageImpl#getAssociatedDetail()
   * @generated
   */
  int ASSOCIATED_DETAIL = 3;

  /**
   * The feature id for the '<em><b>Detail Class</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATED_DETAIL__DETAIL_CLASS = ABSTRACT_DETAIL__DETAIL_CLASS;

  /**
   * The number of structural features of the '<em>Associated Detail</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATED_DETAIL_FEATURE_COUNT = ABSTRACT_DETAIL_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug287184Test.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.assignments.bug287184Test.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.assignments.bug287184Test.Model#getDetail <em>Detail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Detail</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.Model#getDetail()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Detail();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug287184Test.AbstractDetail <em>Abstract Detail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Detail</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.AbstractDetail
   * @generated
   */
  EClass getAbstractDetail();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.assignments.bug287184Test.AbstractDetail#getDetailClass <em>Detail Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Detail Class</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.AbstractDetail#getDetailClass()
   * @see #getAbstractDetail()
   * @generated
   */
  EReference getAbstractDetail_DetailClass();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug287184Test.Detail <em>Detail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Detail</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.Detail
   * @generated
   */
  EClass getDetail();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.assignments.bug287184Test.Detail#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.Detail#getVisibility()
   * @see #getDetail()
   * @generated
   */
  EAttribute getDetail_Visibility();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug287184Test.AssociatedDetail <em>Associated Detail</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Associated Detail</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug287184Test.AssociatedDetail
   * @generated
   */
  EClass getAssociatedDetail();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug287184TestFactory getBug287184TestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.ModelImpl
     * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__NAME = eINSTANCE.getModel_Name();

    /**
     * The meta object literal for the '<em><b>Detail</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__DETAIL = eINSTANCE.getModel_Detail();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.impl.AbstractDetailImpl <em>Abstract Detail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.AbstractDetailImpl
     * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestPackageImpl#getAbstractDetail()
     * @generated
     */
    EClass ABSTRACT_DETAIL = eINSTANCE.getAbstractDetail();

    /**
     * The meta object literal for the '<em><b>Detail Class</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_DETAIL__DETAIL_CLASS = eINSTANCE.getAbstractDetail_DetailClass();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.impl.DetailImpl <em>Detail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.DetailImpl
     * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestPackageImpl#getDetail()
     * @generated
     */
    EClass DETAIL = eINSTANCE.getDetail();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DETAIL__VISIBILITY = eINSTANCE.getDetail_Visibility();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug287184Test.impl.AssociatedDetailImpl <em>Associated Detail</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.AssociatedDetailImpl
     * @see org.eclipse.xtext.parser.assignments.bug287184Test.impl.Bug287184TestPackageImpl#getAssociatedDetail()
     * @generated
     */
    EClass ASSOCIATED_DETAIL = eINSTANCE.getAssociatedDetail();

  }

} //Bug287184TestPackage
