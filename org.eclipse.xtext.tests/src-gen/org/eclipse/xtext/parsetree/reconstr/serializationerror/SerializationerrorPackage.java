/**
 */
package org.eclipse.xtext.parsetree.reconstr.serializationerror;

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
 * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.SerializationerrorFactory
 * @model kind="package"
 * @generated
 */
public interface SerializationerrorPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "serializationerror";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2009/tmf/xtext/serializationerror";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "serializationerror";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SerializationerrorPackage eINSTANCE = org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.ModelImpl
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Test</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__TEST = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TestImpl <em>Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TestImpl
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getTest()
   * @generated
   */
  int TEST = 1;

  /**
   * The number of structural features of the '<em>Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoRequiredImpl <em>Two Required</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoRequiredImpl
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getTwoRequired()
   * @generated
   */
  int TWO_REQUIRED = 2;

  /**
   * The feature id for the '<em><b>One</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_REQUIRED__ONE = TEST_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Two</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_REQUIRED__TWO = TEST_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Two Required</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_REQUIRED_FEATURE_COUNT = TEST_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoOptionsImpl <em>Two Options</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoOptionsImpl
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getTwoOptions()
   * @generated
   */
  int TWO_OPTIONS = 3;

  /**
   * The feature id for the '<em><b>One</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_OPTIONS__ONE = TEST_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Two</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_OPTIONS__TWO = TEST_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Two Options</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TWO_OPTIONS_FEATURE_COUNT = TEST_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.IndentImpl <em>Indent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.IndentImpl
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getIndent()
   * @generated
   */
  int INDENT = 4;

  /**
   * The feature id for the '<em><b>Req</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDENT__REQ = TEST_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Opt</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDENT__OPT = TEST_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Indent</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDENT__INDENT = TEST_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Indent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDENT_FEATURE_COUNT = TEST_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Model#getTest <em>Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Test</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.Model#getTest()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Test();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Test <em>Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.Test
   * @generated
   */
  EClass getTest();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired <em>Two Required</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Two Required</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired
   * @generated
   */
  EClass getTwoRequired();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired#getOne <em>One</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>One</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired#getOne()
   * @see #getTwoRequired()
   * @generated
   */
  EAttribute getTwoRequired_One();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired#getTwo <em>Two</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Two</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoRequired#getTwo()
   * @see #getTwoRequired()
   * @generated
   */
  EAttribute getTwoRequired_Two();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions <em>Two Options</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Two Options</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions
   * @generated
   */
  EClass getTwoOptions();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions#getOne <em>One</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>One</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions#getOne()
   * @see #getTwoOptions()
   * @generated
   */
  EAttribute getTwoOptions_One();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions#getTwo <em>Two</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Two</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.TwoOptions#getTwo()
   * @see #getTwoOptions()
   * @generated
   */
  EAttribute getTwoOptions_Two();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent <em>Indent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Indent</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent
   * @generated
   */
  EClass getIndent();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getReq <em>Req</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Req</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getReq()
   * @see #getIndent()
   * @generated
   */
  EReference getIndent_Req();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getOpt <em>Opt</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Opt</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getOpt()
   * @see #getIndent()
   * @generated
   */
  EReference getIndent_Opt();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getIndent <em>Indent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Indent</em>'.
   * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.Indent#getIndent()
   * @see #getIndent()
   * @generated
   */
  EReference getIndent_Indent();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SerializationerrorFactory getSerializationerrorFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.ModelImpl
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Test</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__TEST = eINSTANCE.getModel_Test();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TestImpl <em>Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TestImpl
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getTest()
     * @generated
     */
    EClass TEST = eINSTANCE.getTest();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoRequiredImpl <em>Two Required</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoRequiredImpl
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getTwoRequired()
     * @generated
     */
    EClass TWO_REQUIRED = eINSTANCE.getTwoRequired();

    /**
     * The meta object literal for the '<em><b>One</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TWO_REQUIRED__ONE = eINSTANCE.getTwoRequired_One();

    /**
     * The meta object literal for the '<em><b>Two</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TWO_REQUIRED__TWO = eINSTANCE.getTwoRequired_Two();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoOptionsImpl <em>Two Options</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.TwoOptionsImpl
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getTwoOptions()
     * @generated
     */
    EClass TWO_OPTIONS = eINSTANCE.getTwoOptions();

    /**
     * The meta object literal for the '<em><b>One</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TWO_OPTIONS__ONE = eINSTANCE.getTwoOptions_One();

    /**
     * The meta object literal for the '<em><b>Two</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TWO_OPTIONS__TWO = eINSTANCE.getTwoOptions_Two();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.IndentImpl <em>Indent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.IndentImpl
     * @see org.eclipse.xtext.parsetree.reconstr.serializationerror.impl.SerializationerrorPackageImpl#getIndent()
     * @generated
     */
    EClass INDENT = eINSTANCE.getIndent();

    /**
     * The meta object literal for the '<em><b>Req</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INDENT__REQ = eINSTANCE.getIndent_Req();

    /**
     * The meta object literal for the '<em><b>Opt</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INDENT__OPT = eINSTANCE.getIndent_Opt();

    /**
     * The meta object literal for the '<em><b>Indent</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INDENT__INDENT = eINSTANCE.getIndent_Indent();

  }

} //SerializationerrorPackage
