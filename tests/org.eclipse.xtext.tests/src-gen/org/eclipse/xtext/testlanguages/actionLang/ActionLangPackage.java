/**
 */
package org.eclipse.xtext.testlanguages.actionLang;

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
 * @see org.eclipse.xtext.testlanguages.actionLang.ActionLangFactory
 * @model kind="package"
 * @generated
 */
public interface ActionLangPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "actionLang";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/ActionLang";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "actionLang";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ActionLangPackage eINSTANCE = org.eclipse.xtext.testlanguages.actionLang.impl.ActionLangPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang.impl.ModelImpl
   * @see org.eclipse.xtext.testlanguages.actionLang.impl.ActionLangPackageImpl#getModel()
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
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang.impl.ChildImpl <em>Child</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang.impl.ChildImpl
   * @see org.eclipse.xtext.testlanguages.actionLang.impl.ActionLangPackageImpl#getChild()
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
  int CHILD__NAME = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Child</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.actionLang.impl.ParentImpl <em>Parent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.actionLang.impl.ParentImpl
   * @see org.eclipse.xtext.testlanguages.actionLang.impl.ActionLangPackageImpl#getParent()
   * @generated
   */
  int PARENT = 2;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENT__LEFT = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENT__RIGHT = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Parent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENT_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang.Child <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Child</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang.Child
   * @generated
   */
  EClass getChild();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.actionLang.Child#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang.Child#getName()
   * @see #getChild()
   * @generated
   */
  EAttribute getChild_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.actionLang.Parent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parent</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang.Parent
   * @generated
   */
  EClass getParent();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.testlanguages.actionLang.Parent#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang.Parent#getLeft()
   * @see #getParent()
   * @generated
   */
  EReference getParent_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.testlanguages.actionLang.Parent#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.testlanguages.actionLang.Parent#getRight()
   * @see #getParent()
   * @generated
   */
  EReference getParent_Right();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ActionLangFactory getActionLangFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang.impl.ModelImpl
     * @see org.eclipse.xtext.testlanguages.actionLang.impl.ActionLangPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang.impl.ChildImpl <em>Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang.impl.ChildImpl
     * @see org.eclipse.xtext.testlanguages.actionLang.impl.ActionLangPackageImpl#getChild()
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
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.actionLang.impl.ParentImpl <em>Parent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.actionLang.impl.ParentImpl
     * @see org.eclipse.xtext.testlanguages.actionLang.impl.ActionLangPackageImpl#getParent()
     * @generated
     */
    EClass PARENT = eINSTANCE.getParent();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARENT__LEFT = eINSTANCE.getParent_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARENT__RIGHT = eINSTANCE.getParent_Right();

  }

} //ActionLangPackage
