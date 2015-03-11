/**
 */
package org.eclipse.xtext.parsetree.reconstr.bug299395;

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
 * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Bug299395Factory
 * @model kind="package"
 * @generated
 */
public interface Bug299395Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug299395";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2010/tmf/xtext/Bug299395";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug299395";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug299395Package eINSTANCE = org.eclipse.xtext.parsetree.reconstr.bug299395.impl.Bug299395PackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.impl.Bug299395PackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Strings</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__STRINGS = 0;

  /**
   * The feature id for the '<em><b>Keys</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__KEYS = 1;

  /**
   * The feature id for the '<em><b>Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__VALUES = 2;

  /**
   * The feature id for the '<em><b>Sub Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SUB_MODEL = 3;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.SubModelImpl <em>Sub Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.impl.SubModelImpl
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.impl.Bug299395PackageImpl#getSubModel()
   * @generated
   */
  int SUB_MODEL = 1;

  /**
   * The feature id for the '<em><b>Strings</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_MODEL__STRINGS = 0;

  /**
   * The number of structural features of the '<em>Sub Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUB_MODEL_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getStrings <em>Strings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Strings</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getStrings()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Strings();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getKeys <em>Keys</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Keys</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getKeys()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Keys();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Values</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getValues()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Values();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getSubModel <em>Sub Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub Model</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.Model#getSubModel()
   * @see #getModel()
   * @generated
   */
  EReference getModel_SubModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.SubModel <em>Sub Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sub Model</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.SubModel
   * @generated
   */
  EClass getSubModel();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.SubModel#getStrings <em>Strings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Strings</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.bug299395.SubModel#getStrings()
   * @see #getSubModel()
   * @generated
   */
  EAttribute getSubModel_Strings();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug299395Factory getBug299395Factory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.bug299395.impl.ModelImpl
     * @see org.eclipse.xtext.parsetree.reconstr.bug299395.impl.Bug299395PackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Strings</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__STRINGS = eINSTANCE.getModel_Strings();

    /**
     * The meta object literal for the '<em><b>Keys</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__KEYS = eINSTANCE.getModel_Keys();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__VALUES = eINSTANCE.getModel_Values();

    /**
     * The meta object literal for the '<em><b>Sub Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__SUB_MODEL = eINSTANCE.getModel_SubModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.bug299395.impl.SubModelImpl <em>Sub Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.bug299395.impl.SubModelImpl
     * @see org.eclipse.xtext.parsetree.reconstr.bug299395.impl.Bug299395PackageImpl#getSubModel()
     * @generated
     */
    EClass SUB_MODEL = eINSTANCE.getSubModel();

    /**
     * The meta object literal for the '<em><b>Strings</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUB_MODEL__STRINGS = eINSTANCE.getSubModel_Strings();

  }

} //Bug299395Package
