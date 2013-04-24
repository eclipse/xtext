/**
 */
package org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage;

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
 * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Bug297105TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug297105TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug297105TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/2008/tmf/xtext/Bug297105TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug297105TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug297105TestLanguagePackage eINSTANCE = org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.ModelImpl
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__EXPRESSIONS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.ExpressionImpl
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__LEFT = 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__RIGHT = 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.LiteralImpl
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__VALUE = 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.IntLiteralImpl <em>Int Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.IntLiteralImpl
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getIntLiteral()
   * @generated
   */
  int INT_LITERAL = 3;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__VALUE = LITERAL__VALUE;

  /**
   * The number of structural features of the '<em>Int Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.RealLiteralImpl <em>Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.RealLiteralImpl
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getRealLiteral()
   * @generated
   */
  int REAL_LITERAL = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__VALUE = LITERAL__VALUE;

  /**
   * The number of structural features of the '<em>Real Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Model#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Model#getExpressions()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Expressions();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression#getLeft()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Expression#getRight()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Literal#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.Literal#getValue()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Literal</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.IntLiteral
   * @generated
   */
  EClass getIntLiteral();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal</em>'.
   * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.RealLiteral
   * @generated
   */
  EClass getRealLiteral();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug297105TestLanguageFactory getBug297105TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.ModelImpl
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__EXPRESSIONS = eINSTANCE.getModel_Expressions();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.ExpressionImpl
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__LEFT = eINSTANCE.getExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__RIGHT = eINSTANCE.getExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.LiteralImpl
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__VALUE = eINSTANCE.getLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.IntLiteralImpl <em>Int Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.IntLiteralImpl
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getIntLiteral()
     * @generated
     */
    EClass INT_LITERAL = eINSTANCE.getIntLiteral();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.RealLiteralImpl <em>Real Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.RealLiteralImpl
     * @see org.eclipse.xtext.parser.terminalrules.bug297105TestLanguage.impl.Bug297105TestLanguagePackageImpl#getRealLiteral()
     * @generated
     */
    EClass REAL_LITERAL = eINSTANCE.getRealLiteral();

  }

} //Bug297105TestLanguagePackage
