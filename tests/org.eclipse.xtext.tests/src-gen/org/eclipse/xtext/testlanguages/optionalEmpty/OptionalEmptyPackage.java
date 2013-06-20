/**
 */
package org.eclipse.xtext.testlanguages.optionalEmpty;

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
 * @see org.eclipse.xtext.testlanguages.optionalEmpty.OptionalEmptyFactory
 * @model kind="package"
 * @generated
 */
public interface OptionalEmptyPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "optionalEmpty";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/OptionalEmpty";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "optionalEmpty";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  OptionalEmptyPackage eINSTANCE = org.eclipse.xtext.testlanguages.optionalEmpty.impl.OptionalEmptyPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.optionalEmpty.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.optionalEmpty.impl.ModelImpl
   * @see org.eclipse.xtext.testlanguages.optionalEmpty.impl.OptionalEmptyPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CHILD = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.optionalEmpty.impl.GreetingImpl <em>Greeting</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.optionalEmpty.impl.GreetingImpl
   * @see org.eclipse.xtext.testlanguages.optionalEmpty.impl.OptionalEmptyPackageImpl#getGreeting()
   * @generated
   */
  int GREETING = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREETING__NAME = 0;

  /**
   * The number of structural features of the '<em>Greeting</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREETING_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.optionalEmpty.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.testlanguages.optionalEmpty.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.testlanguages.optionalEmpty.Model#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child</em>'.
   * @see org.eclipse.xtext.testlanguages.optionalEmpty.Model#getChild()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Child();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.optionalEmpty.Greeting <em>Greeting</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greeting</em>'.
   * @see org.eclipse.xtext.testlanguages.optionalEmpty.Greeting
   * @generated
   */
  EClass getGreeting();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.optionalEmpty.Greeting#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.testlanguages.optionalEmpty.Greeting#getName()
   * @see #getGreeting()
   * @generated
   */
  EAttribute getGreeting_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  OptionalEmptyFactory getOptionalEmptyFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.optionalEmpty.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.optionalEmpty.impl.ModelImpl
     * @see org.eclipse.xtext.testlanguages.optionalEmpty.impl.OptionalEmptyPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CHILD = eINSTANCE.getModel_Child();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.optionalEmpty.impl.GreetingImpl <em>Greeting</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.optionalEmpty.impl.GreetingImpl
     * @see org.eclipse.xtext.testlanguages.optionalEmpty.impl.OptionalEmptyPackageImpl#getGreeting()
     * @generated
     */
    EClass GREETING = eINSTANCE.getGreeting();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GREETING__NAME = eINSTANCE.getGreeting_Name();

  }

} //OptionalEmptyPackage
