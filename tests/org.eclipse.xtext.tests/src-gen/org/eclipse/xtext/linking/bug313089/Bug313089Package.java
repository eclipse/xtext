/**
 */
package org.eclipse.xtext.linking.bug313089;

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
 * @see org.eclipse.xtext.linking.bug313089.Bug313089Factory
 * @model kind="package"
 * @generated
 */
public interface Bug313089Package extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug313089";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/test/Bug313089TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug313089";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug313089Package eINSTANCE = org.eclipse.xtext.linking.bug313089.impl.Bug313089PackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.bug313089.impl.FooImpl <em>Foo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.bug313089.impl.FooImpl
   * @see org.eclipse.xtext.linking.bug313089.impl.Bug313089PackageImpl#getFoo()
   * @generated
   */
  int FOO = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO__NAME = 0;

  /**
   * The feature id for the '<em><b>Bar</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO__BAR = 1;

  /**
   * The feature id for the '<em><b>Baz</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO__BAZ = 2;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO__REF = 3;

  /**
   * The number of structural features of the '<em>Foo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.bug313089.impl.BarImpl <em>Bar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.bug313089.impl.BarImpl
   * @see org.eclipse.xtext.linking.bug313089.impl.Bug313089PackageImpl#getBar()
   * @generated
   */
  int BAR = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAR__NAME = 0;

  /**
   * The number of structural features of the '<em>Bar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.linking.bug313089.impl.BazImpl <em>Baz</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.linking.bug313089.impl.BazImpl
   * @see org.eclipse.xtext.linking.bug313089.impl.Bug313089PackageImpl#getBaz()
   * @generated
   */
  int BAZ = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAZ__NAME = 0;

  /**
   * The feature id for the '<em><b>Child</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAZ__CHILD = 1;

  /**
   * The number of structural features of the '<em>Baz</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAZ_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.bug313089.Foo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foo</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Foo
   * @generated
   */
  EClass getFoo();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.linking.bug313089.Foo#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Foo#getName()
   * @see #getFoo()
   * @generated
   */
  EAttribute getFoo_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.linking.bug313089.Foo#getBar <em>Bar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bar</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Foo#getBar()
   * @see #getFoo()
   * @generated
   */
  EReference getFoo_Bar();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.linking.bug313089.Foo#getBaz <em>Baz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Baz</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Foo#getBaz()
   * @see #getFoo()
   * @generated
   */
  EReference getFoo_Baz();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.linking.bug313089.Foo#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Foo#getRef()
   * @see #getFoo()
   * @generated
   */
  EReference getFoo_Ref();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.bug313089.Bar <em>Bar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bar</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Bar
   * @generated
   */
  EClass getBar();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.linking.bug313089.Bar#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Bar#getName()
   * @see #getBar()
   * @generated
   */
  EAttribute getBar_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.linking.bug313089.Baz <em>Baz</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Baz</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Baz
   * @generated
   */
  EClass getBaz();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.linking.bug313089.Baz#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Baz#getName()
   * @see #getBaz()
   * @generated
   */
  EAttribute getBaz_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.linking.bug313089.Baz#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Child</em>'.
   * @see org.eclipse.xtext.linking.bug313089.Baz#getChild()
   * @see #getBaz()
   * @generated
   */
  EReference getBaz_Child();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug313089Factory getBug313089Factory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.linking.bug313089.impl.FooImpl <em>Foo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.bug313089.impl.FooImpl
     * @see org.eclipse.xtext.linking.bug313089.impl.Bug313089PackageImpl#getFoo()
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
     * The meta object literal for the '<em><b>Bar</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOO__BAR = eINSTANCE.getFoo_Bar();

    /**
     * The meta object literal for the '<em><b>Baz</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOO__BAZ = eINSTANCE.getFoo_Baz();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOO__REF = eINSTANCE.getFoo_Ref();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.linking.bug313089.impl.BarImpl <em>Bar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.bug313089.impl.BarImpl
     * @see org.eclipse.xtext.linking.bug313089.impl.Bug313089PackageImpl#getBar()
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
     * The meta object literal for the '{@link org.eclipse.xtext.linking.bug313089.impl.BazImpl <em>Baz</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.linking.bug313089.impl.BazImpl
     * @see org.eclipse.xtext.linking.bug313089.impl.Bug313089PackageImpl#getBaz()
     * @generated
     */
    EClass BAZ = eINSTANCE.getBaz();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BAZ__NAME = eINSTANCE.getBaz_Name();

    /**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BAZ__CHILD = eINSTANCE.getBaz_Child();

  }

} //Bug313089Package
