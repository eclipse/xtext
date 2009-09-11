/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest;

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
 * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestFactory
 * @model kind="package"
 * @generated
 */
public interface HiddentokenmergertestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "hiddentokenmergertest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/hiddentokensmerger";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "hiddentokenmergertest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  HiddentokenmergertestPackage eINSTANCE = org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ModelImpl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.DatatypeBug286557Impl <em>Datatype Bug286557</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.DatatypeBug286557Impl
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getDatatypeBug286557()
   * @generated
   */
  int DATATYPE_BUG286557 = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_BUG286557__NAME = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_BUG286557__REF = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Datatype Bug286557</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATATYPE_BUG286557_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557 <em>Datatype Bug286557</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Datatype Bug286557</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557
   * @generated
   */
  EClass getDatatypeBug286557();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557#getName()
   * @see #getDatatypeBug286557()
   * @generated
   */
  EAttribute getDatatypeBug286557_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.DatatypeBug286557#getRef()
   * @see #getDatatypeBug286557()
   * @generated
   */
  EReference getDatatypeBug286557_Ref();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  HiddentokenmergertestFactory getHiddentokenmergertestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.ModelImpl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.DatatypeBug286557Impl <em>Datatype Bug286557</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.DatatypeBug286557Impl
     * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.impl.HiddentokenmergertestPackageImpl#getDatatypeBug286557()
     * @generated
     */
    EClass DATATYPE_BUG286557 = eINSTANCE.getDatatypeBug286557();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATATYPE_BUG286557__NAME = eINSTANCE.getDatatypeBug286557_Name();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATATYPE_BUG286557__REF = eINSTANCE.getDatatypeBug286557_Ref();

  }

} //HiddentokenmergertestPackage
