/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.parser.unorderedGroups.backtrackingTestLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BacktrackingTestLanguageFactoryImpl extends EFactoryImpl implements BacktrackingTestLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BacktrackingTestLanguageFactory init()
  {
    try
    {
      BacktrackingTestLanguageFactory theBacktrackingTestLanguageFactory = (BacktrackingTestLanguageFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/2010/tmf/xtext/backtrackingTestLanguage"); 
      if (theBacktrackingTestLanguageFactory != null)
      {
        return theBacktrackingTestLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BacktrackingTestLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingTestLanguageFactoryImpl()
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
      case BacktrackingTestLanguagePackage.MODEL: return createModel();
      case BacktrackingTestLanguagePackage.UNIT: return createUnit();
      case BacktrackingTestLanguagePackage.PROVIDED_CAPABILITY: return createProvidedCapability();
      case BacktrackingTestLanguagePackage.ALIASED_REQUIRED_CAPABILITY: return createAliasedRequiredCapability();
      case BacktrackingTestLanguagePackage.REQUIRED_CAPABILITY: return createRequiredCapability();
      case BacktrackingTestLanguagePackage.PARAMETER_LIST: return createParameterList();
      case BacktrackingTestLanguagePackage.PARAMETER: return createParameter();
      case BacktrackingTestLanguagePackage.CLOSURE_PARAMETER: return createClosureParameter();
      case BacktrackingTestLanguagePackage.PARAMETER_DECLARATION: return createParameterDeclaration();
      case BacktrackingTestLanguagePackage.FUNCTION: return createFunction();
      case BacktrackingTestLanguagePackage.GUARD_EXPRESSION: return createGuardExpression();
      case BacktrackingTestLanguagePackage.EXPRESSION: return createExpression();
      case BacktrackingTestLanguagePackage.TYPE_REF: return createTypeRef();
      case BacktrackingTestLanguagePackage.SIMPLE_TYPE_REF: return createSimpleTypeRef();
      case BacktrackingTestLanguagePackage.CLOSURE_TYPE_REF: return createClosureTypeRef();
      case BacktrackingTestLanguagePackage.WITH_EXPRESSION: return createWithExpression();
      case BacktrackingTestLanguagePackage.WITH_CONTEXT_EXPRESSION: return createWithContextExpression();
      case BacktrackingTestLanguagePackage.CALL_EXPRESSION: return createCallExpression();
      case BacktrackingTestLanguagePackage.VALUE_LITERAL: return createValueLiteral();
      case BacktrackingTestLanguagePackage.ASSIGNMENT_EXPRESSION: return createAssignmentExpression();
      case BacktrackingTestLanguagePackage.DEF_VALUE: return createDefValue();
      case BacktrackingTestLanguagePackage.CACHED_EXPRESSION: return createCachedExpression();
      case BacktrackingTestLanguagePackage.OR_EXPRESSION: return createOrExpression();
      case BacktrackingTestLanguagePackage.AND_EXPRESSION: return createAndExpression();
      case BacktrackingTestLanguagePackage.BINARY_OP_EXPRESSION: return createBinaryOpExpression();
      case BacktrackingTestLanguagePackage.UNARY_OP_EXPRESSION: return createUnaryOpExpression();
      case BacktrackingTestLanguagePackage.UNARY_PRE_OP_EXPRESSION: return createUnaryPreOpExpression();
      case BacktrackingTestLanguagePackage.UNARY_POST_OP_EXPRESSION: return createUnaryPostOpExpression();
      case BacktrackingTestLanguagePackage.CALL_FEATURE: return createCallFeature();
      case BacktrackingTestLanguagePackage.AT_EXPRESSION: return createAtExpression();
      case BacktrackingTestLanguagePackage.FEATURE_EXPRESSION: return createFeatureExpression();
      case BacktrackingTestLanguagePackage.CALL_FUNCTION: return createCallFunction();
      case BacktrackingTestLanguagePackage.CHAINED_EXPRESSION: return createChainedExpression();
      case BacktrackingTestLanguagePackage.VARIABLE_EXPRESSION: return createVariableExpression();
      case BacktrackingTestLanguagePackage.CALL_NAMED_FUNCTION: return createCallNamedFunction();
      case BacktrackingTestLanguagePackage.CREATE_EXPRESSION: return createCreateExpression();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Unit createUnit()
  {
    UnitImpl unit = new UnitImpl();
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProvidedCapability createProvidedCapability()
  {
    ProvidedCapabilityImpl providedCapability = new ProvidedCapabilityImpl();
    return providedCapability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AliasedRequiredCapability createAliasedRequiredCapability()
  {
    AliasedRequiredCapabilityImpl aliasedRequiredCapability = new AliasedRequiredCapabilityImpl();
    return aliasedRequiredCapability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RequiredCapability createRequiredCapability()
  {
    RequiredCapabilityImpl requiredCapability = new RequiredCapabilityImpl();
    return requiredCapability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterList createParameterList()
  {
    ParameterListImpl parameterList = new ParameterListImpl();
    return parameterList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClosureParameter createClosureParameter()
  {
    ClosureParameterImpl closureParameter = new ClosureParameterImpl();
    return closureParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterDeclaration createParameterDeclaration()
  {
    ParameterDeclarationImpl parameterDeclaration = new ParameterDeclarationImpl();
    return parameterDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GuardExpression createGuardExpression()
  {
    GuardExpressionImpl guardExpression = new GuardExpressionImpl();
    return guardExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeRef createTypeRef()
  {
    TypeRefImpl typeRef = new TypeRefImpl();
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleTypeRef createSimpleTypeRef()
  {
    SimpleTypeRefImpl simpleTypeRef = new SimpleTypeRefImpl();
    return simpleTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClosureTypeRef createClosureTypeRef()
  {
    ClosureTypeRefImpl closureTypeRef = new ClosureTypeRefImpl();
    return closureTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WithExpression createWithExpression()
  {
    WithExpressionImpl withExpression = new WithExpressionImpl();
    return withExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WithContextExpression createWithContextExpression()
  {
    WithContextExpressionImpl withContextExpression = new WithContextExpressionImpl();
    return withContextExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CallExpression createCallExpression()
  {
    CallExpressionImpl callExpression = new CallExpressionImpl();
    return callExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueLiteral createValueLiteral()
  {
    ValueLiteralImpl valueLiteral = new ValueLiteralImpl();
    return valueLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentExpression createAssignmentExpression()
  {
    AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
    return assignmentExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefValue createDefValue()
  {
    DefValueImpl defValue = new DefValueImpl();
    return defValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CachedExpression createCachedExpression()
  {
    CachedExpressionImpl cachedExpression = new CachedExpressionImpl();
    return cachedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrExpression createOrExpression()
  {
    OrExpressionImpl orExpression = new OrExpressionImpl();
    return orExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndExpression createAndExpression()
  {
    AndExpressionImpl andExpression = new AndExpressionImpl();
    return andExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryOpExpression createBinaryOpExpression()
  {
    BinaryOpExpressionImpl binaryOpExpression = new BinaryOpExpressionImpl();
    return binaryOpExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOpExpression createUnaryOpExpression()
  {
    UnaryOpExpressionImpl unaryOpExpression = new UnaryOpExpressionImpl();
    return unaryOpExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryPreOpExpression createUnaryPreOpExpression()
  {
    UnaryPreOpExpressionImpl unaryPreOpExpression = new UnaryPreOpExpressionImpl();
    return unaryPreOpExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryPostOpExpression createUnaryPostOpExpression()
  {
    UnaryPostOpExpressionImpl unaryPostOpExpression = new UnaryPostOpExpressionImpl();
    return unaryPostOpExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CallFeature createCallFeature()
  {
    CallFeatureImpl callFeature = new CallFeatureImpl();
    return callFeature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtExpression createAtExpression()
  {
    AtExpressionImpl atExpression = new AtExpressionImpl();
    return atExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureExpression createFeatureExpression()
  {
    FeatureExpressionImpl featureExpression = new FeatureExpressionImpl();
    return featureExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CallFunction createCallFunction()
  {
    CallFunctionImpl callFunction = new CallFunctionImpl();
    return callFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChainedExpression createChainedExpression()
  {
    ChainedExpressionImpl chainedExpression = new ChainedExpressionImpl();
    return chainedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableExpression createVariableExpression()
  {
    VariableExpressionImpl variableExpression = new VariableExpressionImpl();
    return variableExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CallNamedFunction createCallNamedFunction()
  {
    CallNamedFunctionImpl callNamedFunction = new CallNamedFunctionImpl();
    return callNamedFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CreateExpression createCreateExpression()
  {
    CreateExpressionImpl createExpression = new CreateExpressionImpl();
    return createExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingTestLanguagePackage getBacktrackingTestLanguagePackage()
  {
    return (BacktrackingTestLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BacktrackingTestLanguagePackage getPackage()
  {
    return BacktrackingTestLanguagePackage.eINSTANCE;
  }

} //BacktrackingTestLanguageFactoryImpl
