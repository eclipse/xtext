/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.DatatypeRuleTestFactory
 * @model kind="package"
 * @generated
 */
public interface DatatypeRuleTestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "datatypeRuleTest";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2009/datatypeRuleTest";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "datatypeRuleTest";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DatatypeRuleTestPackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.ModelImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getModel()
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
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.TypesImpl <em>Types</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.TypesImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getTypes()
   * @generated
   */
  int TYPES = 1;

  /**
   * The feature id for the '<em><b>Types</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPES__TYPES = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Types</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPES_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.TypeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getType()
   * @generated
   */
  int TYPE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE__NAME = 0;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.SimpleTypeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getSimpleType()
   * @generated
   */
  int SIMPLE_TYPE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TYPE__NAME = TYPE__NAME;

  /**
   * The number of structural features of the '<em>Simple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.CompositeTypeImpl <em>Composite Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.CompositeTypeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getCompositeType()
   * @generated
   */
  int COMPOSITE_TYPE = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_TYPE__NAME = TYPE__NAME;

  /**
   * The feature id for the '<em><b>Base Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_TYPE__BASE_TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Composite Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.CompositeTypeEntryImpl <em>Composite Type Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.CompositeTypeEntryImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getCompositeTypeEntry()
   * @generated
   */
  int COMPOSITE_TYPE_ENTRY = 5;

  /**
   * The feature id for the '<em><b>Data Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_TYPE_ENTRY__DATA_TYPE = 0;

  /**
   * The number of structural features of the '<em>Composite Type Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOSITE_TYPE_ENTRY_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Types <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Types</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Types
   * @generated
   */
  EClass getTypes();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Types#getTypes <em>Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Types</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Types#getTypes()
   * @see #getTypes()
   * @generated
   */
  EReference getTypes_Types();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Type#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.Type#getName()
   * @see #getType()
   * @generated
   */
  EAttribute getType_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.SimpleType <em>Simple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.SimpleType
   * @generated
   */
  EClass getSimpleType();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeType <em>Composite Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composite Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeType
   * @generated
   */
  EClass getCompositeType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeType#getBaseType <em>Base Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeType#getBaseType()
   * @see #getCompositeType()
   * @generated
   */
  EReference getCompositeType_BaseType();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeTypeEntry <em>Composite Type Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Composite Type Entry</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeTypeEntry
   * @generated
   */
  EClass getCompositeTypeEntry();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeTypeEntry#getDataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Data Type</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.CompositeTypeEntry#getDataType()
   * @see #getCompositeTypeEntry()
   * @generated
   */
  EReference getCompositeTypeEntry_DataType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DatatypeRuleTestFactory getDatatypeRuleTestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.ModelImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.TypesImpl <em>Types</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.TypesImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getTypes()
     * @generated
     */
    EClass TYPES = eINSTANCE.getTypes();

    /**
     * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPES__TYPES = eINSTANCE.getTypes_Types();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.TypeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE__NAME = eINSTANCE.getType_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.SimpleTypeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getSimpleType()
     * @generated
     */
    EClass SIMPLE_TYPE = eINSTANCE.getSimpleType();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.CompositeTypeImpl <em>Composite Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.CompositeTypeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getCompositeType()
     * @generated
     */
    EClass COMPOSITE_TYPE = eINSTANCE.getCompositeType();

    /**
     * The meta object literal for the '<em><b>Base Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_TYPE__BASE_TYPE = eINSTANCE.getCompositeType_BaseType();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.CompositeTypeEntryImpl <em>Composite Type Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.CompositeTypeEntryImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.datatypeRuleTest.impl.DatatypeRuleTestPackageImpl#getCompositeTypeEntry()
     * @generated
     */
    EClass COMPOSITE_TYPE_ENTRY = eINSTANCE.getCompositeTypeEntry();

    /**
     * The meta object literal for the '<em><b>Data Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPOSITE_TYPE_ENTRY__DATA_TYPE = eINSTANCE.getCompositeTypeEntry_DataType();

  }

} //DatatypeRuleTestPackage
