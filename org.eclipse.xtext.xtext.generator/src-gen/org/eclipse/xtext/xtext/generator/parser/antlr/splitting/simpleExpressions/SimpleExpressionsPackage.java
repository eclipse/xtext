/**
 */
package org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions;

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
 * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.SimpleExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface SimpleExpressionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "simpleExpressions";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/xtext/generator/parser/antlr/simpleExpressions";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "simpleExpressions";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SimpleExpressionsPackage eINSTANCE = org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.IfConditionImpl <em>If Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.IfConditionImpl
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getIfCondition()
   * @generated
   */
  int IF_CONDITION = 0;

  /**
   * The feature id for the '<em><b>Elseif</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONDITION__ELSEIF = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONDITION__CONDITION = 1;

  /**
   * The number of structural features of the '<em>If Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONDITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.ExpressionImpl
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.NumberLiteralImpl
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getNumberLiteral()
   * @generated
   */
  int NUMBER_LITERAL = 2;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Number Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.BooleanLiteralImpl
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 3;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.MethodCallImpl <em>Method Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.MethodCallImpl
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getMethodCall()
   * @generated
   */
  int METHOD_CALL = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CALL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Method Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.OrExpressionImpl <em>Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.OrExpressionImpl
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getOrExpression()
   * @generated
   */
  int OR_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.AndExpressionImpl <em>And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.AndExpressionImpl
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getAndExpression()
   * @generated
   */
  int AND_EXPRESSION = 6;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION__RIGHT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.ComparisonImpl <em>Comparison</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.ComparisonImpl
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getComparison()
   * @generated
   */
  int COMPARISON = 7;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Comparison</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPARISON_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.NotExpressionImpl <em>Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.NotExpressionImpl
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getNotExpression()
   * @generated
   */
  int NOT_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Not Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition <em>If Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Condition</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition
   * @generated
   */
  EClass getIfCondition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition#isElseif <em>Elseif</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Elseif</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition#isElseif()
   * @see #getIfCondition()
   * @generated
   */
  EAttribute getIfCondition_Elseif();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.IfCondition#getCondition()
   * @see #getIfCondition()
   * @generated
   */
  EReference getIfCondition_Condition();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NumberLiteral <em>Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NumberLiteral
   * @generated
   */
  EClass getNumberLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NumberLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NumberLiteral#getValue()
   * @see #getNumberLiteral()
   * @generated
   */
  EAttribute getNumberLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.BooleanLiteral#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.BooleanLiteral#isValue()
   * @see #getBooleanLiteral()
   * @generated
   */
  EAttribute getBooleanLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.MethodCall <em>Method Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Call</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.MethodCall
   * @generated
   */
  EClass getMethodCall();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.MethodCall#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.MethodCall#getValue()
   * @see #getMethodCall()
   * @generated
   */
  EAttribute getMethodCall_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression <em>Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or Expression</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression
   * @generated
   */
  EClass getOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression#getLeft()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.OrExpression#getRight()
   * @see #getOrExpression()
   * @generated
   */
  EReference getOrExpression_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.AndExpression <em>And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Expression</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.AndExpression
   * @generated
   */
  EClass getAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.AndExpression#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.AndExpression#getLeft()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.AndExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.AndExpression#getRight()
   * @see #getAndExpression()
   * @generated
   */
  EReference getAndExpression_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison <em>Comparison</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comparison</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison
   * @generated
   */
  EClass getComparison();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison#getLeft()
   * @see #getComparison()
   * @generated
   */
  EReference getComparison_Left();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison#getOperator()
   * @see #getComparison()
   * @generated
   */
  EAttribute getComparison_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.Comparison#getRight()
   * @see #getComparison()
   * @generated
   */
  EReference getComparison_Right();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NotExpression <em>Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Expression</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NotExpression
   * @generated
   */
  EClass getNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NotExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.NotExpression#getExpression()
   * @see #getNotExpression()
   * @generated
   */
  EReference getNotExpression_Expression();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SimpleExpressionsFactory getSimpleExpressionsFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.IfConditionImpl <em>If Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.IfConditionImpl
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getIfCondition()
     * @generated
     */
    EClass IF_CONDITION = eINSTANCE.getIfCondition();

    /**
     * The meta object literal for the '<em><b>Elseif</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF_CONDITION__ELSEIF = eINSTANCE.getIfCondition_Elseif();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CONDITION__CONDITION = eINSTANCE.getIfCondition_Condition();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.ExpressionImpl
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.NumberLiteralImpl
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getNumberLiteral()
     * @generated
     */
    EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMBER_LITERAL__VALUE = eINSTANCE.getNumberLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.BooleanLiteralImpl
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.MethodCallImpl <em>Method Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.MethodCallImpl
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getMethodCall()
     * @generated
     */
    EClass METHOD_CALL = eINSTANCE.getMethodCall();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD_CALL__VALUE = eINSTANCE.getMethodCall_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.OrExpressionImpl <em>Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.OrExpressionImpl
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getOrExpression()
     * @generated
     */
    EClass OR_EXPRESSION = eINSTANCE.getOrExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__LEFT = eINSTANCE.getOrExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OR_EXPRESSION__RIGHT = eINSTANCE.getOrExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.AndExpressionImpl <em>And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.AndExpressionImpl
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getAndExpression()
     * @generated
     */
    EClass AND_EXPRESSION = eINSTANCE.getAndExpression();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__LEFT = eINSTANCE.getAndExpression_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_EXPRESSION__RIGHT = eINSTANCE.getAndExpression_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.ComparisonImpl <em>Comparison</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.ComparisonImpl
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getComparison()
     * @generated
     */
    EClass COMPARISON = eINSTANCE.getComparison();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARISON__LEFT = eINSTANCE.getComparison_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPARISON__OPERATOR = eINSTANCE.getComparison_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPARISON__RIGHT = eINSTANCE.getComparison_Right();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.NotExpressionImpl <em>Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.NotExpressionImpl
     * @see org.eclipse.xtext.xtext.generator.parser.antlr.splitting.simpleExpressions.impl.SimpleExpressionsPackageImpl#getNotExpression()
     * @generated
     */
    EClass NOT_EXPRESSION = eINSTANCE.getNotExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NOT_EXPRESSION__EXPRESSION = eINSTANCE.getNotExpression_Expression();

  }

} //SimpleExpressionsPackage
