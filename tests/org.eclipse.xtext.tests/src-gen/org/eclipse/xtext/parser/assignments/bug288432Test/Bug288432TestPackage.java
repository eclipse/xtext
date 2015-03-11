/**
 */
package org.eclipse.xtext.parser.assignments.bug288432Test;

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
 * @see org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestFactory
 * @model kind="package"
 * @generated
 */
public interface Bug288432TestPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug288432Test";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/Bug288432Test";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug288432Test";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug288432TestPackage eINSTANCE = org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.BodyImpl <em>Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.BodyImpl
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getBody()
   * @generated
   */
  int BODY = 0;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__PARAMETER = 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__CONTENT = 1;

  /**
   * The feature id for the '<em><b>Foo</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__FOO = 2;

  /**
   * The number of structural features of the '<em>Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.FooImpl <em>Foo</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.FooImpl
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getFoo()
   * @generated
   */
  int FOO = 1;

  /**
   * The feature id for the '<em><b>Foo Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO__FOO_VALUE = 0;

  /**
   * The number of structural features of the '<em>Foo</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOO_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterObjectImpl <em>Parameter Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterObjectImpl
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getParameterObject()
   * @generated
   */
  int PARAMETER_OBJECT = 4;

  /**
   * The number of structural features of the '<em>Parameter Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_OBJECT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.ContentImpl <em>Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.ContentImpl
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getContent()
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
  int CONTENT_FEATURE_COUNT = PARAMETER_OBJECT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.MyElementImpl <em>My Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.MyElementImpl
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getMyElement()
   * @generated
   */
  int MY_ELEMENT = 3;

  /**
   * The feature id for the '<em><b>Bar</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_ELEMENT__BAR = CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>My Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_ELEMENT_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterImpl
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__VALUE = 1;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterRefImpl <em>Parameter Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterRefImpl
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getParameterRef()
   * @generated
   */
  int PARAMETER_REF = 6;

  /**
   * The feature id for the '<em><b>Parameter</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_REF__PARAMETER = PARAMETER_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Parameter Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_REF_FEATURE_COUNT = PARAMETER_OBJECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.MyIntImpl <em>My Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.MyIntImpl
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getMyInt()
   * @generated
   */
  int MY_INT = 7;

  /**
   * The feature id for the '<em><b>Int</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_INT__INT = PARAMETER_OBJECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>My Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_INT_FEATURE_COUNT = PARAMETER_OBJECT_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Body <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Body</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Body
   * @generated
   */
  EClass getBody();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Body#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Body#getParameter()
   * @see #getBody()
   * @generated
   */
  EReference getBody_Parameter();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Body#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Body#getContent()
   * @see #getBody()
   * @generated
   */
  EReference getBody_Content();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Body#getFoo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Foo</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Body#getFoo()
   * @see #getBody()
   * @generated
   */
  EReference getBody_Foo();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Foo <em>Foo</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foo</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Foo
   * @generated
   */
  EClass getFoo();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Foo#getFooValue <em>Foo Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Foo Value</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Foo#getFooValue()
   * @see #getFoo()
   * @generated
   */
  EAttribute getFoo_FooValue();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Content <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Content</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Content
   * @generated
   */
  EClass getContent();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug288432Test.MyElement <em>My Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Element</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.MyElement
   * @generated
   */
  EClass getMyElement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.assignments.bug288432Test.MyElement#getBar <em>Bar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bar</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.MyElement#getBar()
   * @see #getMyElement()
   * @generated
   */
  EReference getMyElement_Bar();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug288432Test.ParameterObject <em>Parameter Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Object</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.ParameterObject
   * @generated
   */
  EClass getParameterObject();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.assignments.bug288432Test.Parameter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.Parameter#getValue()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug288432Test.ParameterRef <em>Parameter Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Ref</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.ParameterRef
   * @generated
   */
  EClass getParameterRef();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.xtext.parser.assignments.bug288432Test.ParameterRef#getParameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parameter</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.ParameterRef#getParameter()
   * @see #getParameterRef()
   * @generated
   */
  EReference getParameterRef_Parameter();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.assignments.bug288432Test.MyInt <em>My Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Int</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.MyInt
   * @generated
   */
  EClass getMyInt();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.assignments.bug288432Test.MyInt#getInt <em>Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Int</em>'.
   * @see org.eclipse.xtext.parser.assignments.bug288432Test.MyInt#getInt()
   * @see #getMyInt()
   * @generated
   */
  EAttribute getMyInt_Int();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug288432TestFactory getBug288432TestFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.BodyImpl <em>Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.BodyImpl
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getBody()
     * @generated
     */
    EClass BODY = eINSTANCE.getBody();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BODY__PARAMETER = eINSTANCE.getBody_Parameter();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BODY__CONTENT = eINSTANCE.getBody_Content();

    /**
     * The meta object literal for the '<em><b>Foo</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BODY__FOO = eINSTANCE.getBody_Foo();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.FooImpl <em>Foo</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.FooImpl
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getFoo()
     * @generated
     */
    EClass FOO = eINSTANCE.getFoo();

    /**
     * The meta object literal for the '<em><b>Foo Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOO__FOO_VALUE = eINSTANCE.getFoo_FooValue();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.ContentImpl <em>Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.ContentImpl
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getContent()
     * @generated
     */
    EClass CONTENT = eINSTANCE.getContent();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.MyElementImpl <em>My Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.MyElementImpl
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getMyElement()
     * @generated
     */
    EClass MY_ELEMENT = eINSTANCE.getMyElement();

    /**
     * The meta object literal for the '<em><b>Bar</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MY_ELEMENT__BAR = eINSTANCE.getMyElement_Bar();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterObjectImpl <em>Parameter Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterObjectImpl
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getParameterObject()
     * @generated
     */
    EClass PARAMETER_OBJECT = eINSTANCE.getParameterObject();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterImpl
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__VALUE = eINSTANCE.getParameter_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterRefImpl <em>Parameter Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.ParameterRefImpl
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getParameterRef()
     * @generated
     */
    EClass PARAMETER_REF = eINSTANCE.getParameterRef();

    /**
     * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_REF__PARAMETER = eINSTANCE.getParameterRef_Parameter();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.assignments.bug288432Test.impl.MyIntImpl <em>My Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.MyIntImpl
     * @see org.eclipse.xtext.parser.assignments.bug288432Test.impl.Bug288432TestPackageImpl#getMyInt()
     * @generated
     */
    EClass MY_INT = eINSTANCE.getMyInt();

    /**
     * The meta object literal for the '<em><b>Int</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_INT__INT = eINSTANCE.getMyInt_Int();

  }

} //Bug288432TestPackage
