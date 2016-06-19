/**
 */
package org.eclipse.xtext.linking.bug289059Test;

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
 * @see org.eclipse.xtext.linking.bug289059Test.Bug289059TestFactory
 * @model kind="package"
 * @generated
 */
public interface Bug289059TestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug289059Test";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://eclipse.org/xtext/Bug289059TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug289059Test";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug289059TestPackage eINSTANCE = org.eclipse.xtext.linking.bug289059Test.impl.Bug289059TestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.bug289059Test.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.bug289059Test.impl.ModelImpl
   * @see org.eclipse.xtext.linking.bug289059Test.impl.Bug289059TestPackageImpl#getModel()
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
   * The feature id for the '<em><b>Enabled</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ENABLED = 1;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__REFERENCE = 2;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.bug289059Test.impl.UnassignedActionImpl <em>Unassigned Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.bug289059Test.impl.UnassignedActionImpl
   * @see org.eclipse.xtext.linking.bug289059Test.impl.Bug289059TestPackageImpl#getUnassignedAction()
   * @generated
   */
  int UNASSIGNED_ACTION = 1;

  /**
   * The number of structural features of the '<em>Unassigned Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNASSIGNED_ACTION_FEATURE_COUNT = 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.bug289059Test.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.linking.bug289059Test.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.linking.bug289059Test.Model#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.linking.bug289059Test.Model#getName()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.linking.bug289059Test.Model#getEnabled <em>Enabled</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Enabled</em>'.
   * @see org.eclipse.xtext.linking.bug289059Test.Model#getEnabled()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Enabled();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.linking.bug289059Test.Model#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reference</em>'.
   * @see org.eclipse.xtext.linking.bug289059Test.Model#getReference()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Reference();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.bug289059Test.UnassignedAction <em>Unassigned Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unassigned Action</em>'.
   * @see org.eclipse.xtext.linking.bug289059Test.UnassignedAction
   * @generated
   */
  EClass getUnassignedAction();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug289059TestFactory getBug289059TestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.linking.bug289059Test.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.bug289059Test.impl.ModelImpl
     * @see org.eclipse.xtext.linking.bug289059Test.impl.Bug289059TestPackageImpl#getModel()
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
     * The meta object literal for the '<em><b>Enabled</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ENABLED = eINSTANCE.getModel_Enabled();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__REFERENCE = eINSTANCE.getModel_Reference();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.bug289059Test.impl.UnassignedActionImpl <em>Unassigned Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.bug289059Test.impl.UnassignedActionImpl
     * @see org.eclipse.xtext.linking.bug289059Test.impl.Bug289059TestPackageImpl#getUnassignedAction()
     * @generated
     */
    EClass UNASSIGNED_ACTION = eINSTANCE.getUnassignedAction();

  }

} //Bug289059TestPackage
