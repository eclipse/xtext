/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage;

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
 * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Bug303200TestLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface Bug303200TestLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "bug303200TestLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/xtext/ui/common/tests/2010/bug303200TestLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "bug303200TestLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Bug303200TestLanguagePackage eINSTANCE = org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ProgramImpl <em>Program</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ProgramImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getProgram()
   * @generated
   */
  int PROGRAM = 0;

  /**
   * The feature id for the '<em><b>Directives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM__DIRECTIVES = 0;

  /**
   * The number of structural features of the '<em>Program</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ProgramDirectiveImpl <em>Program Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ProgramDirectiveImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getProgramDirective()
   * @generated
   */
  int PROGRAM_DIRECTIVE = 1;

  /**
   * The number of structural features of the '<em>Program Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM_DIRECTIVE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.FunctionDefinitionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getFunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 2;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__ATTRIBUTES = PROGRAM_DIRECTIVE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__NAME = PROGRAM_DIRECTIVE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__PARAMS = PROGRAM_DIRECTIVE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__BODY = PROGRAM_DIRECTIVE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION_FEATURE_COUNT = PROGRAM_DIRECTIVE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.AttributeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 3;

  /**
   * The feature id for the '<em><b>Ident</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__IDENT = 0;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ParametersImpl <em>Parameters</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ParametersImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getParameters()
   * @generated
   */
  int PARAMETERS = 4;

  /**
   * The feature id for the '<em><b>Params</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETERS__PARAMS = 0;

  /**
   * The number of structural features of the '<em>Parameters</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETERS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.StatementImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 6;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = PROGRAM_DIRECTIVE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.BlockImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 5;

  /**
   * The feature id for the '<em><b>Directives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__DIRECTIVES = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PostfixExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getPostfixExpression()
   * @generated
   */
  int POSTFIX_EXPRESSION = 7;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__PROPERTY = 1;

  /**
   * The number of structural features of the '<em>Postfix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ListExpressionImpl <em>List Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ListExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getListExpression()
   * @generated
   */
  int LIST_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_EXPRESSION__EXPRESSIONS = 0;

  /**
   * The number of structural features of the '<em>List Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PropertyOperatorImpl <em>Property Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PropertyOperatorImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getPropertyOperator()
   * @generated
   */
  int PROPERTY_OPERATOR = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_OPERATOR__NAME = 0;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_OPERATOR__EXPRESSIONS = 1;

  /**
   * The number of structural features of the '<em>Property Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_OPERATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PrimaryExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getPrimaryExpression()
   * @generated
   */
  int PRIMARY_EXPRESSION = 10;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__EXPRESSION = POSTFIX_EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION__PROPERTY = POSTFIX_EXPRESSION__PROPERTY;

  /**
   * The number of structural features of the '<em>Primary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXPRESSION_FEATURE_COUNT = POSTFIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.BracketAttributeImpl <em>Bracket Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.BracketAttributeImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getBracketAttribute()
   * @generated
   */
  int BRACKET_ATTRIBUTE = 11;

  /**
   * The feature id for the '<em><b>Ident</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRACKET_ATTRIBUTE__IDENT = ATTRIBUTE__IDENT;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRACKET_ATTRIBUTE__EXPRESSION = ATTRIBUTE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bracket Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BRACKET_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ExpressionStatementImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getExpressionStatement()
   * @generated
   */
  int EXPRESSION_STATEMENT = 12;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.InvocationImpl <em>Invocation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.InvocationImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getInvocation()
   * @generated
   */
  int INVOCATION = 13;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__EXPRESSION = POSTFIX_EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__PROPERTY = POSTFIX_EXPRESSION__PROPERTY;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION__ARGUMENTS = POSTFIX_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Invocation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_FEATURE_COUNT = POSTFIX_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.IdentifierImpl <em>Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.IdentifierImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getIdentifier()
   * @generated
   */
  int IDENTIFIER = 14;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__EXPRESSION = PRIMARY_EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__PROPERTY = PRIMARY_EXPRESSION__PROPERTY;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER__NAME = PRIMARY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIER_FEATURE_COUNT = PRIMARY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.FunctionExpressionImpl <em>Function Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.FunctionExpressionImpl
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getFunctionExpression()
   * @generated
   */
  int FUNCTION_EXPRESSION = 15;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_EXPRESSION__EXPRESSION = PRIMARY_EXPRESSION__EXPRESSION;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_EXPRESSION__PROPERTY = PRIMARY_EXPRESSION__PROPERTY;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_EXPRESSION__PARAMS = PRIMARY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_EXPRESSION__BODY = PRIMARY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_EXPRESSION_FEATURE_COUNT = PRIMARY_EXPRESSION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Program
   * @generated
   */
  EClass getProgram();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Program#getDirectives <em>Directives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Directives</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Program#getDirectives()
   * @see #getProgram()
   * @generated
   */
  EReference getProgram_Directives();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ProgramDirective <em>Program Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program Directive</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ProgramDirective
   * @generated
   */
  EClass getProgramDirective();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Definition</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition
   * @generated
   */
  EClass getFunctionDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition#getAttributes()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Attributes();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition#getName()
   * @see #getFunctionDefinition()
   * @generated
   */
  EAttribute getFunctionDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Params</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition#getParams()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Params();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionDefinition#getBody()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Body();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Attribute#getIdent <em>Ident</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ident</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Attribute#getIdent()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Ident();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Parameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameters</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Parameters
   * @generated
   */
  EClass getParameters();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Parameters#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Params</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Parameters#getParams()
   * @see #getParameters()
   * @generated
   */
  EAttribute getParameters_Params();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Block#getDirectives <em>Directives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Directives</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Block#getDirectives()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Directives();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postfix Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression
   * @generated
   */
  EClass getPostfixExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression#getExpression()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Expression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PostfixExpression#getProperty()
   * @see #getPostfixExpression()
   * @generated
   */
  EReference getPostfixExpression_Property();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ListExpression <em>List Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ListExpression
   * @generated
   */
  EClass getListExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ListExpression#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ListExpression#getExpressions()
   * @see #getListExpression()
   * @generated
   */
  EReference getListExpression_Expressions();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PropertyOperator <em>Property Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Operator</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PropertyOperator
   * @generated
   */
  EClass getPropertyOperator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PropertyOperator#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PropertyOperator#getName()
   * @see #getPropertyOperator()
   * @generated
   */
  EAttribute getPropertyOperator_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PropertyOperator#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expressions</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PropertyOperator#getExpressions()
   * @see #getPropertyOperator()
   * @generated
   */
  EReference getPropertyOperator_Expressions();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PrimaryExpression <em>Primary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.PrimaryExpression
   * @generated
   */
  EClass getPrimaryExpression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.BracketAttribute <em>Bracket Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bracket Attribute</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.BracketAttribute
   * @generated
   */
  EClass getBracketAttribute();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.BracketAttribute#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.BracketAttribute#getExpression()
   * @see #getBracketAttribute()
   * @generated
   */
  EReference getBracketAttribute_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ExpressionStatement <em>Expression Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Statement</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ExpressionStatement
   * @generated
   */
  EClass getExpressionStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ExpressionStatement#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.ExpressionStatement#getExpression()
   * @see #getExpressionStatement()
   * @generated
   */
  EReference getExpressionStatement_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Invocation <em>Invocation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Invocation
   * @generated
   */
  EClass getInvocation();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Invocation#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Arguments</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Invocation#getArguments()
   * @see #getInvocation()
   * @generated
   */
  EReference getInvocation_Arguments();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Identifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifier</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Identifier
   * @generated
   */
  EClass getIdentifier();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Identifier#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.Identifier#getName()
   * @see #getIdentifier()
   * @generated
   */
  EAttribute getIdentifier_Name();

  /**
   * Returns the meta object for class '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionExpression <em>Function Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Expression</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionExpression
   * @generated
   */
  EClass getFunctionExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionExpression#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Params</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionExpression#getParams()
   * @see #getFunctionExpression()
   * @generated
   */
  EReference getFunctionExpression_Params();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionExpression#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.FunctionExpression#getBody()
   * @see #getFunctionExpression()
   * @generated
   */
  EReference getFunctionExpression_Body();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  Bug303200TestLanguageFactory getBug303200TestLanguageFactory();

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
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ProgramImpl <em>Program</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ProgramImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getProgram()
     * @generated
     */
    EClass PROGRAM = eINSTANCE.getProgram();

    /**
     * The meta object literal for the '<em><b>Directives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROGRAM__DIRECTIVES = eINSTANCE.getProgram_Directives();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ProgramDirectiveImpl <em>Program Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ProgramDirectiveImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getProgramDirective()
     * @generated
     */
    EClass PROGRAM_DIRECTIVE = eINSTANCE.getProgramDirective();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.FunctionDefinitionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getFunctionDefinition()
     * @generated
     */
    EClass FUNCTION_DEFINITION = eINSTANCE.getFunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__ATTRIBUTES = eINSTANCE.getFunctionDefinition_Attributes();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DEFINITION__NAME = eINSTANCE.getFunctionDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__PARAMS = eINSTANCE.getFunctionDefinition_Params();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__BODY = eINSTANCE.getFunctionDefinition_Body();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.AttributeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Ident</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__IDENT = eINSTANCE.getAttribute_Ident();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ParametersImpl <em>Parameters</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ParametersImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getParameters()
     * @generated
     */
    EClass PARAMETERS = eINSTANCE.getParameters();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETERS__PARAMS = eINSTANCE.getParameters_Params();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.BlockImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '<em><b>Directives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__DIRECTIVES = eINSTANCE.getBlock_Directives();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.StatementImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PostfixExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getPostfixExpression()
     * @generated
     */
    EClass POSTFIX_EXPRESSION = eINSTANCE.getPostfixExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__EXPRESSION = eINSTANCE.getPostfixExpression_Expression();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSTFIX_EXPRESSION__PROPERTY = eINSTANCE.getPostfixExpression_Property();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ListExpressionImpl <em>List Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ListExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getListExpression()
     * @generated
     */
    EClass LIST_EXPRESSION = eINSTANCE.getListExpression();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_EXPRESSION__EXPRESSIONS = eINSTANCE.getListExpression_Expressions();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PropertyOperatorImpl <em>Property Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PropertyOperatorImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getPropertyOperator()
     * @generated
     */
    EClass PROPERTY_OPERATOR = eINSTANCE.getPropertyOperator();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY_OPERATOR__NAME = eINSTANCE.getPropertyOperator_Name();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_OPERATOR__EXPRESSIONS = eINSTANCE.getPropertyOperator_Expressions();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PrimaryExpressionImpl <em>Primary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.PrimaryExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getPrimaryExpression()
     * @generated
     */
    EClass PRIMARY_EXPRESSION = eINSTANCE.getPrimaryExpression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.BracketAttributeImpl <em>Bracket Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.BracketAttributeImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getBracketAttribute()
     * @generated
     */
    EClass BRACKET_ATTRIBUTE = eINSTANCE.getBracketAttribute();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BRACKET_ATTRIBUTE__EXPRESSION = eINSTANCE.getBracketAttribute_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.ExpressionStatementImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getExpressionStatement()
     * @generated
     */
    EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getExpressionStatement_Expression();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.InvocationImpl <em>Invocation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.InvocationImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getInvocation()
     * @generated
     */
    EClass INVOCATION = eINSTANCE.getInvocation();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION__ARGUMENTS = eINSTANCE.getInvocation_Arguments();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.IdentifierImpl <em>Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.IdentifierImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getIdentifier()
     * @generated
     */
    EClass IDENTIFIER = eINSTANCE.getIdentifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IDENTIFIER__NAME = eINSTANCE.getIdentifier_Name();

    /**
     * The meta object literal for the '{@link org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.FunctionExpressionImpl <em>Function Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.FunctionExpressionImpl
     * @see org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl.Bug303200TestLanguagePackageImpl#getFunctionExpression()
     * @generated
     */
    EClass FUNCTION_EXPRESSION = eINSTANCE.getFunctionExpression();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_EXPRESSION__PARAMS = eINSTANCE.getFunctionExpression_Params();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_EXPRESSION__BODY = eINSTANCE.getFunctionExpression_Body();

  }

} //Bug303200TestLanguagePackage
