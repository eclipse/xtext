/**
 */
package org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage;

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
 * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedGroupsTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface UnorderedGroupsTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "unorderedGroupsTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2010/tmf/xtext/UnorderedGroupsTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "unorderedGroupsTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UnorderedGroupsTestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedGroupsTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedGroupsTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>First</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FIRST = 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SECOND = 1;

  /**
   * The feature id for the '<em><b>Third</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__THIRD = 2;

  /**
   * The feature id for the '<em><b>Forth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FORTH = 3;

  /**
   * The feature id for the '<em><b>First As List</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FIRST_AS_LIST = 4;

  /**
   * The feature id for the '<em><b>Second As List</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SECOND_AS_LIST = 5;

  /**
   * The feature id for the '<em><b>Third As List</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__THIRD_AS_LIST = 6;

  /**
   * The feature id for the '<em><b>Forth As List</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FORTH_AS_LIST = 7;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__VALUE = 8;

  /**
   * The feature id for the '<em><b>Serialized</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__SERIALIZED = 9;

  /**
   * The feature id for the '<em><b>Nested Model</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__NESTED_MODEL = 10;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 11;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.NestedModelImpl <em>Nested Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.NestedModelImpl
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedGroupsTestLanguagePackageImpl#getNestedModel()
   * @generated
   */
  int NESTED_MODEL = 1;

  /**
   * The feature id for the '<em><b>First</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_MODEL__FIRST = 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_MODEL__SECOND = 1;

  /**
   * The number of structural features of the '<em>Nested Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl <em>Unordered Serialization</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedGroupsTestLanguagePackageImpl#getUnorderedSerialization()
   * @generated
   */
  int UNORDERED_SERIALIZATION = 2;

  /**
   * The feature id for the '<em><b>First</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_SERIALIZATION__FIRST = 0;

  /**
   * The feature id for the '<em><b>Second</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_SERIALIZATION__SECOND = 1;

  /**
   * The feature id for the '<em><b>Third</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_SERIALIZATION__THIRD = 2;

  /**
   * The feature id for the '<em><b>Forth</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_SERIALIZATION__FORTH = 3;

  /**
   * The feature id for the '<em><b>First As List</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_SERIALIZATION__FIRST_AS_LIST = 4;

  /**
   * The feature id for the '<em><b>Second As List</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_SERIALIZATION__SECOND_AS_LIST = 5;

  /**
   * The number of structural features of the '<em>Unordered Serialization</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNORDERED_SERIALIZATION_FEATURE_COUNT = 6;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#isFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#isFirst()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_First();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#isSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Second</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#isSecond()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Second();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#isThird <em>Third</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Third</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#isThird()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Third();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#isForth <em>Forth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Forth</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#isForth()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Forth();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getFirstAsList <em>First As List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>First As List</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getFirstAsList()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_FirstAsList();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getSecondAsList <em>Second As List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Second As List</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getSecondAsList()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_SecondAsList();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getThirdAsList <em>Third As List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Third As List</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getThirdAsList()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_ThirdAsList();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getForthAsList <em>Forth As List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Forth As List</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getForthAsList()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_ForthAsList();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getValue()
   * @see #getModel()
   * @generated
   */
  EAttribute getModel_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getSerialized <em>Serialized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Serialized</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getSerialized()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Serialized();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getNestedModel <em>Nested Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested Model</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.Model#getNestedModel()
   * @see #getModel()
   * @generated
   */
  EReference getModel_NestedModel();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel <em>Nested Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Model</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel
   * @generated
   */
  EClass getNestedModel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel#isFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel#isFirst()
   * @see #getNestedModel()
   * @generated
   */
  EAttribute getNestedModel_First();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel#isSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Second</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.NestedModel#isSecond()
   * @see #getNestedModel()
   * @generated
   */
  EAttribute getNestedModel_Second();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization <em>Unordered Serialization</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unordered Serialization</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization
   * @generated
   */
  EClass getUnorderedSerialization();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isFirst <em>First</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>First</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isFirst()
   * @see #getUnorderedSerialization()
   * @generated
   */
  EAttribute getUnorderedSerialization_First();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isSecond <em>Second</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Second</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isSecond()
   * @see #getUnorderedSerialization()
   * @generated
   */
  EAttribute getUnorderedSerialization_Second();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isThird <em>Third</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Third</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isThird()
   * @see #getUnorderedSerialization()
   * @generated
   */
  EAttribute getUnorderedSerialization_Third();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isForth <em>Forth</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Forth</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#isForth()
   * @see #getUnorderedSerialization()
   * @generated
   */
  EAttribute getUnorderedSerialization_Forth();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#getFirstAsList <em>First As List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>First As List</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#getFirstAsList()
   * @see #getUnorderedSerialization()
   * @generated
   */
  EAttribute getUnorderedSerialization_FirstAsList();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#getSecondAsList <em>Second As List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Second As List</em>'.
   * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.UnorderedSerialization#getSecondAsList()
   * @see #getUnorderedSerialization()
   * @generated
   */
  EAttribute getUnorderedSerialization_SecondAsList();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UnorderedGroupsTestLanguageFactory getUnorderedGroupsTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedGroupsTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>First</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__FIRST = eINSTANCE.getModel_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__SECOND = eINSTANCE.getModel_Second();

    /**
     * The meta object literal for the '<em><b>Third</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__THIRD = eINSTANCE.getModel_Third();

    /**
     * The meta object literal for the '<em><b>Forth</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__FORTH = eINSTANCE.getModel_Forth();

    /**
     * The meta object literal for the '<em><b>First As List</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__FIRST_AS_LIST = eINSTANCE.getModel_FirstAsList();

    /**
     * The meta object literal for the '<em><b>Second As List</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__SECOND_AS_LIST = eINSTANCE.getModel_SecondAsList();

    /**
     * The meta object literal for the '<em><b>Third As List</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__THIRD_AS_LIST = eINSTANCE.getModel_ThirdAsList();

    /**
     * The meta object literal for the '<em><b>Forth As List</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__FORTH_AS_LIST = eINSTANCE.getModel_ForthAsList();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL__VALUE = eINSTANCE.getModel_Value();

    /**
     * The meta object literal for the '<em><b>Serialized</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__SERIALIZED = eINSTANCE.getModel_Serialized();

    /**
     * The meta object literal for the '<em><b>Nested Model</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__NESTED_MODEL = eINSTANCE.getModel_NestedModel();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.NestedModelImpl <em>Nested Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.NestedModelImpl
     * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedGroupsTestLanguagePackageImpl#getNestedModel()
     * @generated
     */
    EClass NESTED_MODEL = eINSTANCE.getNestedModel();

    /**
     * The meta object literal for the '<em><b>First</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NESTED_MODEL__FIRST = eINSTANCE.getNestedModel_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NESTED_MODEL__SECOND = eINSTANCE.getNestedModel_Second();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl <em>Unordered Serialization</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedSerializationImpl
     * @see org.eclipse.xtext.parser.unorderedGroups.unorderedGroupsTestLanguage.impl.UnorderedGroupsTestLanguagePackageImpl#getUnorderedSerialization()
     * @generated
     */
    EClass UNORDERED_SERIALIZATION = eINSTANCE.getUnorderedSerialization();

    /**
     * The meta object literal for the '<em><b>First</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNORDERED_SERIALIZATION__FIRST = eINSTANCE.getUnorderedSerialization_First();

    /**
     * The meta object literal for the '<em><b>Second</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNORDERED_SERIALIZATION__SECOND = eINSTANCE.getUnorderedSerialization_Second();

    /**
     * The meta object literal for the '<em><b>Third</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNORDERED_SERIALIZATION__THIRD = eINSTANCE.getUnorderedSerialization_Third();

    /**
     * The meta object literal for the '<em><b>Forth</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNORDERED_SERIALIZATION__FORTH = eINSTANCE.getUnorderedSerialization_Forth();

    /**
     * The meta object literal for the '<em><b>First As List</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNORDERED_SERIALIZATION__FIRST_AS_LIST = eINSTANCE.getUnorderedSerialization_FirstAsList();

    /**
     * The meta object literal for the '<em><b>Second As List</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNORDERED_SERIALIZATION__SECOND_AS_LIST = eINSTANCE.getUnorderedSerialization_SecondAsList();

  }

} //UnorderedGroupsTestLanguagePackage
