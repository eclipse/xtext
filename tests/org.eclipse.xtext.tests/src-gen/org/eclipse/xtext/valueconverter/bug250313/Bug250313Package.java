/**
 */
package org.eclipse.xtext.valueconverter.bug250313;

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
 * @see org.eclipse.xtext.valueconverter.bug250313.Bug250313Factory
 * @model kind="package"
 * @generated
 */
public interface Bug250313Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug250313";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://org.eclipse.xtext.valueconverter.Bug250313";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug250313";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug250313Package eINSTANCE = org.eclipse.xtext.valueconverter.bug250313.impl.Bug250313PackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.valueconverter.bug250313.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.valueconverter.bug250313.impl.ModelImpl
   * @see org.eclipse.xtext.valueconverter.bug250313.impl.Bug250313PackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__VALUE = 0;

  /**
   * The feature id for the '<em><b>Multi Value</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MULTI_VALUE = 1;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CHILDREN = 2;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__REF = 3;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.valueconverter.bug250313.impl.ChildImpl <em>Child</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.valueconverter.bug250313.impl.ChildImpl
   * @see org.eclipse.xtext.valueconverter.bug250313.impl.Bug250313PackageImpl#getChild()
   * @generated
   */
  int CHILD = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD__NAME = 0;

  /**
   * The number of structural features of the '<em>Child</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.valueconverter.bug250313.impl.Child1Impl <em>Child1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.valueconverter.bug250313.impl.Child1Impl
   * @see org.eclipse.xtext.valueconverter.bug250313.impl.Bug250313PackageImpl#getChild1()
   * @generated
   */
  int CHILD1 = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD1__NAME = CHILD__NAME;

  /**
   * The number of structural features of the '<em>Child1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD1_FEATURE_COUNT = CHILD_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.valueconverter.bug250313.impl.Child2Impl <em>Child2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.valueconverter.bug250313.impl.Child2Impl
   * @see org.eclipse.xtext.valueconverter.bug250313.impl.Bug250313PackageImpl#getChild2()
   * @generated
   */
  int CHILD2 = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD2__NAME = CHILD__NAME;

  /**
   * The number of structural features of the '<em>Child2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD2_FEATURE_COUNT = CHILD_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.valueconverter.bug250313.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.valueconverter.bug250313.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.valueconverter.bug250313.Model#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.valueconverter.bug250313.Model#getValue()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Value();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.valueconverter.bug250313.Model#getMultiValue <em>Multi Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Multi Value</em>'.
   * @see org.eclipse.xtext.valueconverter.bug250313.Model#getMultiValue()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_MultiValue();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.valueconverter.bug250313.Model#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Children</em>'.
   * @see org.eclipse.xtext.valueconverter.bug250313.Model#getChildren()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Children();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.valueconverter.bug250313.Model#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.valueconverter.bug250313.Model#getRef()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.valueconverter.bug250313.Child <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Child</em>'.
   * @see org.eclipse.xtext.valueconverter.bug250313.Child
   * @generated
   */
  EClass getChild();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.valueconverter.bug250313.Child#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.valueconverter.bug250313.Child#getName()
   * @see #getChild()
   * @generated
   */
  EAttribute getChild_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.valueconverter.bug250313.Child1 <em>Child1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Child1</em>'.
   * @see org.eclipse.xtext.valueconverter.bug250313.Child1
   * @generated
   */
  EClass getChild1();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.valueconverter.bug250313.Child2 <em>Child2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Child2</em>'.
   * @see org.eclipse.xtext.valueconverter.bug250313.Child2
   * @generated
   */
  EClass getChild2();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug250313Factory getBug250313Factory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.valueconverter.bug250313.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.valueconverter.bug250313.impl.ModelImpl
     * @see org.eclipse.xtext.valueconverter.bug250313.impl.Bug250313PackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__VALUE = eINSTANCE.getModel_Value();

    /**
     * The meta object literal for the '<em><b>Multi Value</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__MULTI_VALUE = eINSTANCE.getModel_MultiValue();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CHILDREN = eINSTANCE.getModel_Children();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__REF = eINSTANCE.getModel_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.valueconverter.bug250313.impl.ChildImpl <em>Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.valueconverter.bug250313.impl.ChildImpl
     * @see org.eclipse.xtext.valueconverter.bug250313.impl.Bug250313PackageImpl#getChild()
     * @generated
     */
    EClass CHILD = eINSTANCE.getChild();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHILD__NAME = eINSTANCE.getChild_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.valueconverter.bug250313.impl.Child1Impl <em>Child1</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.valueconverter.bug250313.impl.Child1Impl
     * @see org.eclipse.xtext.valueconverter.bug250313.impl.Bug250313PackageImpl#getChild1()
     * @generated
     */
    EClass CHILD1 = eINSTANCE.getChild1();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.valueconverter.bug250313.impl.Child2Impl <em>Child2</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.valueconverter.bug250313.impl.Child2Impl
     * @see org.eclipse.xtext.valueconverter.bug250313.impl.Bug250313PackageImpl#getChild2()
     * @generated
     */
    EClass CHILD2 = eINSTANCE.getChild2();

  }

} //Bug250313Package
