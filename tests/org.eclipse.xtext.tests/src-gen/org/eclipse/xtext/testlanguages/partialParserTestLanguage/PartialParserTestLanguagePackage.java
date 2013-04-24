/**
 */
package org.eclipse.xtext.testlanguages.partialParserTestLanguage;

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
 * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface PartialParserTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "partialParserTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://example.xtext.org/PartialParserTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "partialParserTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PartialParserTestLanguagePackage eINSTANCE = org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.SomeContainerImpl <em>Some Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.SomeContainerImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getSomeContainer()
   * @generated
   */
  int SOME_CONTAINER = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOME_CONTAINER__NAME = 0;

  /**
   * The feature id for the '<em><b>Nested</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOME_CONTAINER__NESTED = 1;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOME_CONTAINER__CONTENT = 2;

  /**
   * The number of structural features of the '<em>Some Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOME_CONTAINER_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.NestedImpl <em>Nested</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.NestedImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getNested()
   * @generated
   */
  int NESTED = 1;

  /**
   * The feature id for the '<em><b>Nested</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED__NESTED = 0;

  /**
   * The number of structural features of the '<em>Nested</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ContentImpl <em>Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ContentImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getContent()
   * @generated
   */
  int CONTENT = 2;

  /**
   * The number of structural features of the '<em>Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ChildrenImpl <em>Children</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ChildrenImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getChildren()
   * @generated
   */
  int CHILDREN = 3;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILDREN__CHILDREN = CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Children</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILDREN_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ChildImpl <em>Child</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ChildImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getChild()
   * @generated
   */
  int CHILD = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD__VALUE = 0;

  /**
   * The number of structural features of the '<em>Child</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHILD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.AbstractChildrenImpl <em>Abstract Children</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.AbstractChildrenImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getAbstractChildren()
   * @generated
   */
  int ABSTRACT_CHILDREN = 5;

  /**
   * The feature id for the '<em><b>Abstract Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_CHILDREN__ABSTRACT_CHILDREN = CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Abstract Children</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_CHILDREN_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.AbstractChildImpl <em>Abstract Child</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.AbstractChildImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getAbstractChild()
   * @generated
   */
  int ABSTRACT_CHILD = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_CHILD__VALUE = 0;

  /**
   * The number of structural features of the '<em>Abstract Child</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_CHILD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.FirstConcreteImpl <em>First Concrete</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.FirstConcreteImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getFirstConcrete()
   * @generated
   */
  int FIRST_CONCRETE = 7;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_CONCRETE__VALUE = ABSTRACT_CHILD__VALUE;

  /**
   * The feature id for the '<em><b>Referenced Container</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_CONCRETE__REFERENCED_CONTAINER = ABSTRACT_CHILD_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>First Concrete</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_CONCRETE_FEATURE_COUNT = ABSTRACT_CHILD_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.SecondConcreteImpl <em>Second Concrete</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.SecondConcreteImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getSecondConcrete()
   * @generated
   */
  int SECOND_CONCRETE = 8;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_CONCRETE__VALUE = ABSTRACT_CHILD__VALUE;

  /**
   * The feature id for the '<em><b>Referenced Children</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_CONCRETE__REFERENCED_CHILDREN = ABSTRACT_CHILD_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Second Concrete</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_CONCRETE_FEATURE_COUNT = ABSTRACT_CHILD_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.NamedImpl <em>Named</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.NamedImpl
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getNamed()
   * @generated
   */
  int NAMED = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED__NAME = 0;

  /**
   * The number of structural features of the '<em>Named</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer <em>Some Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Some Container</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer
   * @generated
   */
  EClass getSomeContainer();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer#getName()
   * @see #getSomeContainer()
   * @generated
   */
  EAttribute getSomeContainer_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer#getNested <em>Nested</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer#getNested()
   * @see #getSomeContainer()
   * @generated
   */
  EReference getSomeContainer_Nested();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer#getContent()
   * @see #getSomeContainer()
   * @generated
   */
  EReference getSomeContainer_Content();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested <em>Nested</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested
   * @generated
   */
  EClass getNested();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested#getNested <em>Nested</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nested</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested#getNested()
   * @see #getNested()
   * @generated
   */
  EReference getNested_Nested();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Content <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Content</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Content
   * @generated
   */
  EClass getContent();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Children</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children
   * @generated
   */
  EClass getChildren();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children#getChildren()
   * @see #getChildren()
   * @generated
   */
  EReference getChildren_Children();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Child</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child
   * @generated
   */
  EClass getChild();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child#getValue()
   * @see #getChild()
   * @generated
   */
  EReference getChild_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren <em>Abstract Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Children</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren
   * @generated
   */
  EClass getAbstractChildren();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren#getAbstractChildren <em>Abstract Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Abstract Children</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren#getAbstractChildren()
   * @see #getAbstractChildren()
   * @generated
   */
  EReference getAbstractChildren_AbstractChildren();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChild <em>Abstract Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Child</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChild
   * @generated
   */
  EClass getAbstractChild();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChild#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChild#getValue()
   * @see #getAbstractChild()
   * @generated
   */
  EReference getAbstractChild_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete <em>First Concrete</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>First Concrete</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete
   * @generated
   */
  EClass getFirstConcrete();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete#getReferencedContainer <em>Referenced Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Referenced Container</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete#getReferencedContainer()
   * @see #getFirstConcrete()
   * @generated
   */
  EReference getFirstConcrete_ReferencedContainer();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete <em>Second Concrete</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Second Concrete</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete
   * @generated
   */
  EClass getSecondConcrete();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete#getReferencedChildren <em>Referenced Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Referenced Children</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete#getReferencedChildren()
   * @see #getSecondConcrete()
   * @generated
   */
  EReference getSecondConcrete_ReferencedChildren();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Named <em>Named</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Named
   * @generated
   */
  EClass getNamed();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.Named#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.Named#getName()
   * @see #getNamed()
   * @generated
   */
  EAttribute getNamed_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PartialParserTestLanguageFactory getPartialParserTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.SomeContainerImpl <em>Some Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.SomeContainerImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getSomeContainer()
     * @generated
     */
    EClass SOME_CONTAINER = eINSTANCE.getSomeContainer();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SOME_CONTAINER__NAME = eINSTANCE.getSomeContainer_Name();

    /**
     * The meta object literal for the '<em><b>Nested</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOME_CONTAINER__NESTED = eINSTANCE.getSomeContainer_Nested();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SOME_CONTAINER__CONTENT = eINSTANCE.getSomeContainer_Content();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.NestedImpl <em>Nested</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.NestedImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getNested()
     * @generated
     */
    EClass NESTED = eINSTANCE.getNested();

    /**
     * The meta object literal for the '<em><b>Nested</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED__NESTED = eINSTANCE.getNested_Nested();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ContentImpl <em>Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ContentImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getContent()
     * @generated
     */
    EClass CONTENT = eINSTANCE.getContent();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ChildrenImpl <em>Children</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ChildrenImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getChildren()
     * @generated
     */
    EClass CHILDREN = eINSTANCE.getChildren();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHILDREN__CHILDREN = eINSTANCE.getChildren_Children();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ChildImpl <em>Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.ChildImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getChild()
     * @generated
     */
    EClass CHILD = eINSTANCE.getChild();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHILD__VALUE = eINSTANCE.getChild_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.AbstractChildrenImpl <em>Abstract Children</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.AbstractChildrenImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getAbstractChildren()
     * @generated
     */
    EClass ABSTRACT_CHILDREN = eINSTANCE.getAbstractChildren();

    /**
     * The meta object literal for the '<em><b>Abstract Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_CHILDREN__ABSTRACT_CHILDREN = eINSTANCE.getAbstractChildren_AbstractChildren();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.AbstractChildImpl <em>Abstract Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.AbstractChildImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getAbstractChild()
     * @generated
     */
    EClass ABSTRACT_CHILD = eINSTANCE.getAbstractChild();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_CHILD__VALUE = eINSTANCE.getAbstractChild_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.FirstConcreteImpl <em>First Concrete</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.FirstConcreteImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getFirstConcrete()
     * @generated
     */
    EClass FIRST_CONCRETE = eINSTANCE.getFirstConcrete();

    /**
     * The meta object literal for the '<em><b>Referenced Container</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIRST_CONCRETE__REFERENCED_CONTAINER = eINSTANCE.getFirstConcrete_ReferencedContainer();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.SecondConcreteImpl <em>Second Concrete</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.SecondConcreteImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getSecondConcrete()
     * @generated
     */
    EClass SECOND_CONCRETE = eINSTANCE.getSecondConcrete();

    /**
     * The meta object literal for the '<em><b>Referenced Children</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECOND_CONCRETE__REFERENCED_CHILDREN = eINSTANCE.getSecondConcrete_ReferencedChildren();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.NamedImpl <em>Named</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.NamedImpl
     * @see org.eclipse.xtext.testlanguages.partialParserTestLanguage.impl.PartialParserTestLanguagePackageImpl#getNamed()
     * @generated
     */
    EClass NAMED = eINSTANCE.getNamed();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED__NAME = eINSTANCE.getNamed_Name();

  }

} //PartialParserTestLanguagePackage
