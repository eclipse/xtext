/**
 */
package org.eclipse.xtext.parsetree.reconstr.partialserializationtest;

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
 * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.PartialserializationtestFactory
 * @model kind="package"
 * @generated
 */
public interface PartialserializationtestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "partialserializationtest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/partialserializationtest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "partialserializationtest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PartialserializationtestPackage eINSTANCE = org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.PartialserializationtestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.ModelImpl
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.PartialserializationtestPackageImpl#getModel()
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
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.NodeRootImpl <em>Node Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.NodeRootImpl
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.PartialserializationtestPackageImpl#getNodeRoot()
   * @generated
   */
  int NODE_ROOT = 1;

  /**
   * The feature id for the '<em><b>Node</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_ROOT__NODE = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Node Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_ROOT_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.NodeImpl <em>Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.NodeImpl
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.PartialserializationtestPackageImpl#getNode()
   * @generated
   */
  int NODE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__NAME = 0;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE__CHILDREN = 1;

  /**
   * The number of structural features of the '<em>Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NODE_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.NodeRoot <em>Node Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node Root</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.NodeRoot
   * @generated
   */
  EClass getNodeRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.NodeRoot#getNode <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Node</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.NodeRoot#getNode()
   * @see #getNodeRoot()
   * @generated
   */
  EReference getNodeRoot_Node();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.Node <em>Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Node</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.Node
   * @generated
   */
  EClass getNode();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.Node#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.Node#getName()
   * @see #getNode()
   * @generated
   */
  EAttribute getNode_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.Node#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.Node#getChildren()
   * @see #getNode()
   * @generated
   */
  EReference getNode_Children();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PartialserializationtestFactory getPartialserializationtestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.ModelImpl
     * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.PartialserializationtestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.NodeRootImpl <em>Node Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.NodeRootImpl
     * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.PartialserializationtestPackageImpl#getNodeRoot()
     * @generated
     */
    EClass NODE_ROOT = eINSTANCE.getNodeRoot();

    /**
     * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE_ROOT__NODE = eINSTANCE.getNodeRoot_Node();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.NodeImpl
     * @see org.eclipse.xtext.parsetree.reconstr.partialserializationtest.impl.PartialserializationtestPackageImpl#getNode()
     * @generated
     */
    EClass NODE = eINSTANCE.getNode();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NODE__NAME = eINSTANCE.getNode_Name();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NODE__CHILDREN = eINSTANCE.getNode_Children();

  }

} //PartialserializationtestPackage
