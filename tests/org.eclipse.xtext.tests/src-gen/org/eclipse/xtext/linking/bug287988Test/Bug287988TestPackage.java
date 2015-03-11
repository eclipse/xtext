/**
 */
package org.eclipse.xtext.linking.bug287988Test;

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
 * @see org.eclipse.xtext.linking.bug287988Test.Bug287988TestFactory
 * @model kind="package"
 * @generated
 */
public interface Bug287988TestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug287988Test";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://eclipse.org/xtext/Bug287988TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug287988Test";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug287988TestPackage eINSTANCE = org.eclipse.xtext.linking.bug287988Test.impl.Bug287988TestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.bug287988Test.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.bug287988Test.impl.ModelImpl
   * @see org.eclipse.xtext.linking.bug287988Test.impl.Bug287988TestPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ATTRIBUTES = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.bug287988Test.impl.BaseAttributeImpl <em>Base Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.bug287988Test.impl.BaseAttributeImpl
   * @see org.eclipse.xtext.linking.bug287988Test.impl.Bug287988TestPackageImpl#getBaseAttribute()
   * @generated
   */
  int BASE_ATTRIBUTE = 1;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_ATTRIBUTE__TYPE_REF = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_ATTRIBUTE__TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_ATTRIBUTE__NAME = 2;

  /**
   * The number of structural features of the '<em>Base Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_ATTRIBUTE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.bug287988Test.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.bug287988Test.impl.AttributeImpl
   * @see org.eclipse.xtext.linking.bug287988Test.impl.Bug287988TestPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 2;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE_REF = BASE_ATTRIBUTE__TYPE_REF;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE = BASE_ATTRIBUTE__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = BASE_ATTRIBUTE__NAME;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = BASE_ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.bug287988Test.impl.MasterImpl <em>Master</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.bug287988Test.impl.MasterImpl
   * @see org.eclipse.xtext.linking.bug287988Test.impl.Bug287988TestPackageImpl#getMaster()
   * @generated
   */
  int MASTER = 3;

  /**
   * The feature id for the '<em><b>Type Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASTER__TYPE_REF = BASE_ATTRIBUTE__TYPE_REF;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASTER__TYPE = BASE_ATTRIBUTE__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASTER__NAME = BASE_ATTRIBUTE__NAME;

  /**
   * The number of structural features of the '<em>Master</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASTER_FEATURE_COUNT = BASE_ATTRIBUTE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.bug287988Test.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.linking.bug287988Test.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.linking.bug287988Test.Model#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.xtext.linking.bug287988Test.Model#getAttributes()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Attributes();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute <em>Base Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Base Attribute</em>'.
   * @see org.eclipse.xtext.linking.bug287988Test.BaseAttribute
   * @generated
   */
  EClass getBaseAttribute();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getTypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type Ref</em>'.
   * @see org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getTypeRef()
   * @see #getBaseAttribute()
   * @generated
   */
  EReference getBaseAttribute_TypeRef();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getType()
   * @see #getBaseAttribute()
   * @generated
   */
  EAttribute getBaseAttribute_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.linking.bug287988Test.BaseAttribute#getName()
   * @see #getBaseAttribute()
   * @generated
   */
  EAttribute getBaseAttribute_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.bug287988Test.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.eclipse.xtext.linking.bug287988Test.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.bug287988Test.Master <em>Master</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Master</em>'.
   * @see org.eclipse.xtext.linking.bug287988Test.Master
   * @generated
   */
  EClass getMaster();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug287988TestFactory getBug287988TestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.linking.bug287988Test.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.bug287988Test.impl.ModelImpl
     * @see org.eclipse.xtext.linking.bug287988Test.impl.Bug287988TestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ATTRIBUTES = eINSTANCE.getModel_Attributes();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.bug287988Test.impl.BaseAttributeImpl <em>Base Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.bug287988Test.impl.BaseAttributeImpl
     * @see org.eclipse.xtext.linking.bug287988Test.impl.Bug287988TestPackageImpl#getBaseAttribute()
     * @generated
     */
    EClass BASE_ATTRIBUTE = eINSTANCE.getBaseAttribute();

    /**
     * The meta object literal for the '<em><b>Type Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_ATTRIBUTE__TYPE_REF = eINSTANCE.getBaseAttribute_TypeRef();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_ATTRIBUTE__TYPE = eINSTANCE.getBaseAttribute_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_ATTRIBUTE__NAME = eINSTANCE.getBaseAttribute_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.bug287988Test.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.bug287988Test.impl.AttributeImpl
     * @see org.eclipse.xtext.linking.bug287988Test.impl.Bug287988TestPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.bug287988Test.impl.MasterImpl <em>Master</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.bug287988Test.impl.MasterImpl
     * @see org.eclipse.xtext.linking.bug287988Test.impl.Bug287988TestPackageImpl#getMaster()
     * @generated
     */
    EClass MASTER = eINSTANCE.getMaster();

  }

} //Bug287988TestPackage
