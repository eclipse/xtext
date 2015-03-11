/**
 */
package org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage;

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
 * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.EObjectAtOffsetTestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface EObjectAtOffsetTestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "eObjectAtOffsetTestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/EObjectAtOffsetTestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "eObjectAtOffsetTestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EObjectAtOffsetTestLanguagePackage eINSTANCE = org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Foos</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__FOOS = 0;

  /**
   * The feature id for the '<em><b>Bars</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__BARS = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.AbstractBarImpl <em>Abstract Bar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.AbstractBarImpl
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getAbstractBar()
   * @generated
   */
  int ABSTRACT_BAR = 1;

  /**
   * The feature id for the '<em><b>Foo</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_BAR__FOO = 0;

  /**
   * The number of structural features of the '<em>Abstract Bar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_BAR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.BarImpl <em>Bar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.BarImpl
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getBar()
   * @generated
   */
  int BAR = 2;

  /**
   * The feature id for the '<em><b>Foo</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAR__FOO = ABSTRACT_BAR__FOO;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAR__NAME = ABSTRACT_BAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAR_FEATURE_COUNT = ABSTRACT_BAR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.FooImpl <em>Foo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.FooImpl
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getFoo()
   * @generated
   */
  int FOO = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO__NAME = 0;

  /**
   * The number of structural features of the '<em>Foo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.FooBarImpl <em>Foo Bar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.FooBarImpl
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getFooBar()
   * @generated
   */
  int FOO_BAR = 4;

  /**
   * The feature id for the '<em><b>Foo</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_BAR__FOO = ABSTRACT_BAR__FOO;

  /**
   * The feature id for the '<em><b>Bar</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_BAR__BAR = ABSTRACT_BAR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Foo Bar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_BAR_FEATURE_COUNT = ABSTRACT_BAR_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model#getFoos <em>Foos</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Foos</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model#getFoos()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Foos();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model#getBars <em>Bars</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bars</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Model#getBars()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Bars();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.AbstractBar <em>Abstract Bar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Bar</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.AbstractBar
   * @generated
   */
  EClass getAbstractBar();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.AbstractBar#getFoo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Foo</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.AbstractBar#getFoo()
   * @see #getAbstractBar()
   * @generated
   */
  EReference getAbstractBar_Foo();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Bar <em>Bar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bar</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Bar
   * @generated
   */
  EClass getBar();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Bar#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Bar#getName()
   * @see #getBar()
   * @generated
   */
  EAttribute getBar_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foo</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo
   * @generated
   */
  EClass getFoo();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.Foo#getName()
   * @see #getFoo()
   * @generated
   */
  EAttribute getFoo_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.FooBar <em>Foo Bar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foo Bar</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.FooBar
   * @generated
   */
  EClass getFooBar();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.FooBar#getBar <em>Bar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bar</em>'.
   * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.FooBar#getBar()
   * @see #getFooBar()
   * @generated
   */
  EReference getFooBar_Bar();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EObjectAtOffsetTestLanguageFactory getEObjectAtOffsetTestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Foos</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__FOOS = eINSTANCE.getModel_Foos();

    /**
     * The meta object literal for the '<em><b>Bars</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__BARS = eINSTANCE.getModel_Bars();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.AbstractBarImpl <em>Abstract Bar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.AbstractBarImpl
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getAbstractBar()
     * @generated
     */
    EClass ABSTRACT_BAR = eINSTANCE.getAbstractBar();

    /**
     * The meta object literal for the '<em><b>Foo</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABSTRACT_BAR__FOO = eINSTANCE.getAbstractBar_Foo();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.BarImpl <em>Bar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.BarImpl
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getBar()
     * @generated
     */
    EClass BAR = eINSTANCE.getBar();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BAR__NAME = eINSTANCE.getBar_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.FooImpl <em>Foo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.FooImpl
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getFoo()
     * @generated
     */
    EClass FOO = eINSTANCE.getFoo();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOO__NAME = eINSTANCE.getFoo_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.FooBarImpl <em>Foo Bar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.FooBarImpl
     * @see org.eclipse.xtext.resource.eObjectAtOffsetTestLanguage.impl.EObjectAtOffsetTestLanguagePackageImpl#getFooBar()
     * @generated
     */
    EClass FOO_BAR = eINSTANCE.getFooBar();

    /**
     * The meta object literal for the '<em><b>Bar</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOO_BAR__BAR = eINSTANCE.getFooBar_Bar();

  }

} //EObjectAtOffsetTestLanguagePackage
