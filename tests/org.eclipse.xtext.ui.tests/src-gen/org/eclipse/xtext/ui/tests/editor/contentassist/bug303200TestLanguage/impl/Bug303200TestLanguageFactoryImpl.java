/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.editor.contentassist.bug303200TestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Bug303200TestLanguageFactoryImpl extends EFactoryImpl implements Bug303200TestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Bug303200TestLanguageFactory init()
  {
    try
    {
      Bug303200TestLanguageFactory theBug303200TestLanguageFactory = (Bug303200TestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/ui/common/tests/2010/bug303200TestLanguage"); 
      if (theBug303200TestLanguageFactory != null)
      {
        return theBug303200TestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new Bug303200TestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug303200TestLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case Bug303200TestLanguagePackage.PROGRAM: return createProgram();
      case Bug303200TestLanguagePackage.PROGRAM_DIRECTIVE: return createProgramDirective();
      case Bug303200TestLanguagePackage.FUNCTION_DEFINITION: return createFunctionDefinition();
      case Bug303200TestLanguagePackage.ATTRIBUTE: return createAttribute();
      case Bug303200TestLanguagePackage.PARAMETERS: return createParameters();
      case Bug303200TestLanguagePackage.BLOCK: return createBlock();
      case Bug303200TestLanguagePackage.STATEMENT: return createStatement();
      case Bug303200TestLanguagePackage.POSTFIX_EXPRESSION: return createPostfixExpression();
      case Bug303200TestLanguagePackage.LIST_EXPRESSION: return createListExpression();
      case Bug303200TestLanguagePackage.PROPERTY_OPERATOR: return createPropertyOperator();
      case Bug303200TestLanguagePackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
      case Bug303200TestLanguagePackage.BRACKET_ATTRIBUTE: return createBracketAttribute();
      case Bug303200TestLanguagePackage.EXPRESSION_STATEMENT: return createExpressionStatement();
      case Bug303200TestLanguagePackage.INVOCATION: return createInvocation();
      case Bug303200TestLanguagePackage.IDENTIFIER: return createIdentifier();
      case Bug303200TestLanguagePackage.FUNCTION_EXPRESSION: return createFunctionExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Program createProgram()
  {
    ProgramImpl program = new ProgramImpl();
    return program;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProgramDirective createProgramDirective()
  {
    ProgramDirectiveImpl programDirective = new ProgramDirectiveImpl();
    return programDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition createFunctionDefinition()
  {
    FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
    return functionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameters createParameters()
  {
    ParametersImpl parameters = new ParametersImpl();
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixExpression createPostfixExpression()
  {
    PostfixExpressionImpl postfixExpression = new PostfixExpressionImpl();
    return postfixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListExpression createListExpression()
  {
    ListExpressionImpl listExpression = new ListExpressionImpl();
    return listExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyOperator createPropertyOperator()
  {
    PropertyOperatorImpl propertyOperator = new PropertyOperatorImpl();
    return propertyOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpression createPrimaryExpression()
  {
    PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
    return primaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BracketAttribute createBracketAttribute()
  {
    BracketAttributeImpl bracketAttribute = new BracketAttributeImpl();
    return bracketAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionStatement createExpressionStatement()
  {
    ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
    return expressionStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Invocation createInvocation()
  {
    InvocationImpl invocation = new InvocationImpl();
    return invocation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Identifier createIdentifier()
  {
    IdentifierImpl identifier = new IdentifierImpl();
    return identifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionExpression createFunctionExpression()
  {
    FunctionExpressionImpl functionExpression = new FunctionExpressionImpl();
    return functionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Bug303200TestLanguagePackage getBug303200TestLanguagePackage()
  {
    return (Bug303200TestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static Bug303200TestLanguagePackage getPackage()
  {
    return Bug303200TestLanguagePackage.eINSTANCE;
  }

} //Bug303200TestLanguageFactoryImpl
