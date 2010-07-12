/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BacktrackingContentAssistTestFactoryImpl extends EFactoryImpl implements BacktrackingContentAssistTestFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BacktrackingContentAssistTestFactory init()
  {
    try
    {
      BacktrackingContentAssistTestFactory theBacktrackingContentAssistTestFactory = (BacktrackingContentAssistTestFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/xtext/ui/common/tests/2010/backtrackingContentAssistTest"); 
      if (theBacktrackingContentAssistTestFactory != null)
      {
        return theBacktrackingContentAssistTestFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BacktrackingContentAssistTestFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingContentAssistTestFactoryImpl()
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
      case BacktrackingContentAssistTestPackage.DOCUMENT: return createDocument();
      case BacktrackingContentAssistTestPackage.BODY: return createBody();
      case BacktrackingContentAssistTestPackage.CLASSIFIER_CONTEXT_DECL: return createClassifierContextDecl();
      case BacktrackingContentAssistTestPackage.CLASSIFIER_REF: return createClassifierRef();
      case BacktrackingContentAssistTestPackage.CONTEXT_DECL: return createContextDecl();
      case BacktrackingContentAssistTestPackage.DEFINITION: return createDefinition();
      case BacktrackingContentAssistTestPackage.DER: return createDer();
      case BacktrackingContentAssistTestPackage.INIT: return createInit();
      case BacktrackingContentAssistTestPackage.INVARIANT: return createInvariant();
      case BacktrackingContentAssistTestPackage.OPERATION_CONTEXT_DECL: return createOperationContextDecl();
      case BacktrackingContentAssistTestPackage.OPERATION_REF: return createOperationRef();
      case BacktrackingContentAssistTestPackage.PACKAGE_DECLARATION: return createPackageDeclaration();
      case BacktrackingContentAssistTestPackage.PACKAGE_REF: return createPackageRef();
      case BacktrackingContentAssistTestPackage.PARAMETER: return createParameter();
      case BacktrackingContentAssistTestPackage.POST: return createPost();
      case BacktrackingContentAssistTestPackage.PRE: return createPre();
      case BacktrackingContentAssistTestPackage.PROPERTY_CONTEXT_DECL: return createPropertyContextDecl();
      case BacktrackingContentAssistTestPackage.PROPERTY_REF: return createPropertyRef();
      case BacktrackingContentAssistTestPackage.QUALIFIED_CLASSIFIER_REF: return createQualifiedClassifierRef();
      case BacktrackingContentAssistTestPackage.QUALIFIED_OPERATION_REF: return createQualifiedOperationRef();
      case BacktrackingContentAssistTestPackage.QUALIFIED_PROPERTY_REF: return createQualifiedPropertyRef();
      case BacktrackingContentAssistTestPackage.QUALIFIED_PACKAGE_REF: return createQualifiedPackageRef();
      case BacktrackingContentAssistTestPackage.SIMPLE_CLASSIFIER_REF: return createSimpleClassifierRef();
      case BacktrackingContentAssistTestPackage.SIMPLE_OPERATION_REF: return createSimpleOperationRef();
      case BacktrackingContentAssistTestPackage.SIMPLE_PACKAGE_REF: return createSimplePackageRef();
      case BacktrackingContentAssistTestPackage.SIMPLE_PROPERTY_REF: return createSimplePropertyRef();
      case BacktrackingContentAssistTestPackage.EXPRESSION: return createExpression();
      case BacktrackingContentAssistTestPackage.NAVIGATING_EXP: return createNavigatingExp();
      case BacktrackingContentAssistTestPackage.OCL_MESSAGE_ARG: return createOclMessageArg();
      case BacktrackingContentAssistTestPackage.PRIMITIVE_TYPE: return createPrimitiveType();
      case BacktrackingContentAssistTestPackage.TYPE_EXP: return createTypeExp();
      case BacktrackingContentAssistTestPackage.COLLECTION_TYPE: return createCollectionType();
      case BacktrackingContentAssistTestPackage.TUPLE_TYPE: return createTupleType();
      case BacktrackingContentAssistTestPackage.TUPLE_PART: return createtuplePart();
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_EXP: return createCollectionLiteralExp();
      case BacktrackingContentAssistTestPackage.COLLECTION_LITERAL_PART: return createCollectionLiteralPart();
      case BacktrackingContentAssistTestPackage.PRIMITIVE_LITERAL_EXP: return createPrimitiveLiteralExp();
      case BacktrackingContentAssistTestPackage.TUPLE_LITERAL_EXP: return createTupleLiteralExp();
      case BacktrackingContentAssistTestPackage.TUPLE_LITERAL_PART: return createTupleLiteralPart();
      case BacktrackingContentAssistTestPackage.NUMBER_LITERAL_EXP: return createNumberLiteralExp();
      case BacktrackingContentAssistTestPackage.STRING_LITERAL_EXP: return createStringLiteralExp();
      case BacktrackingContentAssistTestPackage.BOOLEAN_LITERAL_EXP: return createBooleanLiteralExp();
      case BacktrackingContentAssistTestPackage.INVALID_LITERAL_EXP: return createInvalidLiteralExp();
      case BacktrackingContentAssistTestPackage.NULL_LITERAL_EXP: return createNullLiteralExp();
      case BacktrackingContentAssistTestPackage.ITERATOR_VARIABLE: return createiteratorVariable();
      case BacktrackingContentAssistTestPackage.ITERATOR_ACCUMULATOR: return createiteratorAccumulator();
      case BacktrackingContentAssistTestPackage.ROUND_BRACKET_EXP: return createRoundBracketExp();
      case BacktrackingContentAssistTestPackage.SQUARE_BRACKET_EXP: return createSquareBracketExp();
      case BacktrackingContentAssistTestPackage.PRE_EXP: return createPreExp();
      case BacktrackingContentAssistTestPackage.SELF_EXP: return createSelfExp();
      case BacktrackingContentAssistTestPackage.NAME_EXP: return createNameExp();
      case BacktrackingContentAssistTestPackage.PATH_NAME_EXP: return createPathNameExp();
      case BacktrackingContentAssistTestPackage.SIMPLE_NAME_EXP: return createSimpleNameExp();
      case BacktrackingContentAssistTestPackage.IF_EXP: return createIfExp();
      case BacktrackingContentAssistTestPackage.LET_EXP: return createLetExp();
      case BacktrackingContentAssistTestPackage.LET_VARIABLE: return createLetVariable();
      case BacktrackingContentAssistTestPackage.INFIX_EXP: return createInfixExp();
      case BacktrackingContentAssistTestPackage.OCL_MESSAGE: return createOclMessage();
      case BacktrackingContentAssistTestPackage.PREFIX_EXP: return createPrefixExp();
      case BacktrackingContentAssistTestPackage.NESTED_EXP: return createNestedExp();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Document createDocument()
  {
    DocumentImpl document = new DocumentImpl();
    return document;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Body createBody()
  {
    BodyImpl body = new BodyImpl();
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierContextDecl createClassifierContextDecl()
  {
    ClassifierContextDeclImpl classifierContextDecl = new ClassifierContextDeclImpl();
    return classifierContextDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierRef createClassifierRef()
  {
    ClassifierRefImpl classifierRef = new ClassifierRefImpl();
    return classifierRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextDecl createContextDecl()
  {
    ContextDeclImpl contextDecl = new ContextDeclImpl();
    return contextDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition createDefinition()
  {
    DefinitionImpl definition = new DefinitionImpl();
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Der createDer()
  {
    DerImpl der = new DerImpl();
    return der;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Init createInit()
  {
    InitImpl init = new InitImpl();
    return init;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Invariant createInvariant()
  {
    InvariantImpl invariant = new InvariantImpl();
    return invariant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationContextDecl createOperationContextDecl()
  {
    OperationContextDeclImpl operationContextDecl = new OperationContextDeclImpl();
    return operationContextDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationRef createOperationRef()
  {
    OperationRefImpl operationRef = new OperationRefImpl();
    return operationRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDeclaration createPackageDeclaration()
  {
    PackageDeclarationImpl packageDeclaration = new PackageDeclarationImpl();
    return packageDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageRef createPackageRef()
  {
    PackageRefImpl packageRef = new PackageRefImpl();
    return packageRef;
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
  public Post createPost()
  {
    PostImpl post = new PostImpl();
    return post;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pre createPre()
  {
    PreImpl pre = new PreImpl();
    return pre;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyContextDecl createPropertyContextDecl()
  {
    PropertyContextDeclImpl propertyContextDecl = new PropertyContextDeclImpl();
    return propertyContextDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropertyRef createPropertyRef()
  {
    PropertyRefImpl propertyRef = new PropertyRefImpl();
    return propertyRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedClassifierRef createQualifiedClassifierRef()
  {
    QualifiedClassifierRefImpl qualifiedClassifierRef = new QualifiedClassifierRefImpl();
    return qualifiedClassifierRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedOperationRef createQualifiedOperationRef()
  {
    QualifiedOperationRefImpl qualifiedOperationRef = new QualifiedOperationRefImpl();
    return qualifiedOperationRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedPropertyRef createQualifiedPropertyRef()
  {
    QualifiedPropertyRefImpl qualifiedPropertyRef = new QualifiedPropertyRefImpl();
    return qualifiedPropertyRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedPackageRef createQualifiedPackageRef()
  {
    QualifiedPackageRefImpl qualifiedPackageRef = new QualifiedPackageRefImpl();
    return qualifiedPackageRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleClassifierRef createSimpleClassifierRef()
  {
    SimpleClassifierRefImpl simpleClassifierRef = new SimpleClassifierRefImpl();
    return simpleClassifierRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleOperationRef createSimpleOperationRef()
  {
    SimpleOperationRefImpl simpleOperationRef = new SimpleOperationRefImpl();
    return simpleOperationRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimplePackageRef createSimplePackageRef()
  {
    SimplePackageRefImpl simplePackageRef = new SimplePackageRefImpl();
    return simplePackageRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimplePropertyRef createSimplePropertyRef()
  {
    SimplePropertyRefImpl simplePropertyRef = new SimplePropertyRefImpl();
    return simplePropertyRef;
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
  public NavigatingExp createNavigatingExp()
  {
    NavigatingExpImpl navigatingExp = new NavigatingExpImpl();
    return navigatingExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OclMessageArg createOclMessageArg()
  {
    OclMessageArgImpl oclMessageArg = new OclMessageArgImpl();
    return oclMessageArg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveType createPrimitiveType()
  {
    PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
    return primitiveType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeExp createTypeExp()
  {
    TypeExpImpl typeExp = new TypeExpImpl();
    return typeExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionType createCollectionType()
  {
    CollectionTypeImpl collectionType = new CollectionTypeImpl();
    return collectionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleType createTupleType()
  {
    TupleTypeImpl tupleType = new TupleTypeImpl();
    return tupleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public tuplePart createtuplePart()
  {
    tuplePartImpl tuplePart = new tuplePartImpl();
    return tuplePart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionLiteralExp createCollectionLiteralExp()
  {
    CollectionLiteralExpImpl collectionLiteralExp = new CollectionLiteralExpImpl();
    return collectionLiteralExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionLiteralPart createCollectionLiteralPart()
  {
    CollectionLiteralPartImpl collectionLiteralPart = new CollectionLiteralPartImpl();
    return collectionLiteralPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveLiteralExp createPrimitiveLiteralExp()
  {
    PrimitiveLiteralExpImpl primitiveLiteralExp = new PrimitiveLiteralExpImpl();
    return primitiveLiteralExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleLiteralExp createTupleLiteralExp()
  {
    TupleLiteralExpImpl tupleLiteralExp = new TupleLiteralExpImpl();
    return tupleLiteralExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleLiteralPart createTupleLiteralPart()
  {
    TupleLiteralPartImpl tupleLiteralPart = new TupleLiteralPartImpl();
    return tupleLiteralPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberLiteralExp createNumberLiteralExp()
  {
    NumberLiteralExpImpl numberLiteralExp = new NumberLiteralExpImpl();
    return numberLiteralExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteralExp createStringLiteralExp()
  {
    StringLiteralExpImpl stringLiteralExp = new StringLiteralExpImpl();
    return stringLiteralExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteralExp createBooleanLiteralExp()
  {
    BooleanLiteralExpImpl booleanLiteralExp = new BooleanLiteralExpImpl();
    return booleanLiteralExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvalidLiteralExp createInvalidLiteralExp()
  {
    InvalidLiteralExpImpl invalidLiteralExp = new InvalidLiteralExpImpl();
    return invalidLiteralExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullLiteralExp createNullLiteralExp()
  {
    NullLiteralExpImpl nullLiteralExp = new NullLiteralExpImpl();
    return nullLiteralExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public iteratorVariable createiteratorVariable()
  {
    iteratorVariableImpl iteratorVariable = new iteratorVariableImpl();
    return iteratorVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public iteratorAccumulator createiteratorAccumulator()
  {
    iteratorAccumulatorImpl iteratorAccumulator = new iteratorAccumulatorImpl();
    return iteratorAccumulator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RoundBracketExp createRoundBracketExp()
  {
    RoundBracketExpImpl roundBracketExp = new RoundBracketExpImpl();
    return roundBracketExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SquareBracketExp createSquareBracketExp()
  {
    SquareBracketExpImpl squareBracketExp = new SquareBracketExpImpl();
    return squareBracketExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreExp createPreExp()
  {
    PreExpImpl preExp = new PreExpImpl();
    return preExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelfExp createSelfExp()
  {
    SelfExpImpl selfExp = new SelfExpImpl();
    return selfExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameExp createNameExp()
  {
    NameExpImpl nameExp = new NameExpImpl();
    return nameExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathNameExp createPathNameExp()
  {
    PathNameExpImpl pathNameExp = new PathNameExpImpl();
    return pathNameExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleNameExp createSimpleNameExp()
  {
    SimpleNameExpImpl simpleNameExp = new SimpleNameExpImpl();
    return simpleNameExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfExp createIfExp()
  {
    IfExpImpl ifExp = new IfExpImpl();
    return ifExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LetExp createLetExp()
  {
    LetExpImpl letExp = new LetExpImpl();
    return letExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LetVariable createLetVariable()
  {
    LetVariableImpl letVariable = new LetVariableImpl();
    return letVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfixExp createInfixExp()
  {
    InfixExpImpl infixExp = new InfixExpImpl();
    return infixExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OclMessage createOclMessage()
  {
    OclMessageImpl oclMessage = new OclMessageImpl();
    return oclMessage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrefixExp createPrefixExp()
  {
    PrefixExpImpl prefixExp = new PrefixExpImpl();
    return prefixExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedExp createNestedExp()
  {
    NestedExpImpl nestedExp = new NestedExpImpl();
    return nestedExp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingContentAssistTestPackage getBacktrackingContentAssistTestPackage()
  {
    return (BacktrackingContentAssistTestPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BacktrackingContentAssistTestPackage getPackage()
  {
    return BacktrackingContentAssistTestPackage.eINSTANCE;
  }

} //BacktrackingContentAssistTestFactoryImpl
