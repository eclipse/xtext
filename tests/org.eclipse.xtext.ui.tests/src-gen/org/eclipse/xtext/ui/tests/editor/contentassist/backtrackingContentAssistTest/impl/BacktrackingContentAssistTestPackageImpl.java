/**
 */
package org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestFactory;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Body;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BooleanLiteralExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierContextDecl;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ClassifierRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionLiteralPart;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.CollectionType;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.ContextDecl;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Definition;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Der;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Document;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Expression;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.IfExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InfixExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Init;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.InvalidLiteralExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Invariant;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.LetVariable;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NameExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NavigatingExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NestedExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NullLiteralExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.NumberLiteralExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessage;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OclMessageArg;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationContextDecl;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.OperationRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageDeclaration;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PackageRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Parameter;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PathNameExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Post;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.Pre;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PreExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrefixExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveLiteralExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PrimitiveType;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyContextDecl;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.PropertyRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedClassifierRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedOperationRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPackageRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.QualifiedPropertyRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.RoundBracketExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SelfExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleClassifierRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleNameExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimpleOperationRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePackageRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SimplePropertyRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.SquareBracketExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.StringLiteralExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleLiteralPart;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TupleType;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.TypeExp;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorAccumulator;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.iteratorVariable;
import org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.tuplePart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BacktrackingContentAssistTestPackageImpl extends EPackageImpl implements BacktrackingContentAssistTestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bodyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierContextDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass definitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass derEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invariantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationContextDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyContextDeclEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass propertyRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedClassifierRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedOperationRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedPropertyRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass qualifiedPackageRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleClassifierRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleOperationRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simplePackageRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simplePropertyRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass navigatingExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oclMessageArgEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitiveTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tuplePartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionLiteralExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionLiteralPartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitiveLiteralExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleLiteralExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleLiteralPartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numberLiteralExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringLiteralExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanLiteralExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invalidLiteralExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullLiteralExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iteratorVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iteratorAccumulatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass roundBracketExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass squareBracketExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selfExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pathNameExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleNameExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass letExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass letVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass infixExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oclMessageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prefixExpEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedExpEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.xtext.ui.tests.editor.contentassist.backtrackingContentAssistTest.BacktrackingContentAssistTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private BacktrackingContentAssistTestPackageImpl()
  {
    super(eNS_URI, BacktrackingContentAssistTestFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link BacktrackingContentAssistTestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static BacktrackingContentAssistTestPackage init()
  {
    if (isInited) return (BacktrackingContentAssistTestPackage)EPackage.Registry.INSTANCE.getEPackage(BacktrackingContentAssistTestPackage.eNS_URI);

    // Obtain or create and register package
    BacktrackingContentAssistTestPackageImpl theBacktrackingContentAssistTestPackage = (BacktrackingContentAssistTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BacktrackingContentAssistTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BacktrackingContentAssistTestPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theBacktrackingContentAssistTestPackage.createPackageContents();

    // Initialize created meta-data
    theBacktrackingContentAssistTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBacktrackingContentAssistTestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(BacktrackingContentAssistTestPackage.eNS_URI, theBacktrackingContentAssistTestPackage);
    return theBacktrackingContentAssistTestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocument()
  {
    return documentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocument_Packages()
  {
    return (EReference)documentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocument_Contexts()
  {
    return (EReference)documentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBody()
  {
    return bodyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBody_ConstraintName()
  {
    return (EAttribute)bodyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBody_Expression()
  {
    return (EReference)bodyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifierContextDecl()
  {
    return classifierContextDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassifierContextDecl_SelfName()
  {
    return (EAttribute)classifierContextDeclEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierContextDecl_Classifier()
  {
    return (EReference)classifierContextDeclEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierContextDecl_Invariants()
  {
    return (EReference)classifierContextDeclEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierContextDecl_Definitions()
  {
    return (EReference)classifierContextDeclEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifierRef()
  {
    return classifierRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContextDecl()
  {
    return contextDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefinition()
  {
    return definitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefinition_Static()
  {
    return (EAttribute)definitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefinition_ConstraintName()
  {
    return (EAttribute)definitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefinition_ConstrainedName()
  {
    return (EAttribute)definitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefinition_Parameters()
  {
    return (EReference)definitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefinition_Type()
  {
    return (EReference)definitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefinition_Expression()
  {
    return (EReference)definitionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDer()
  {
    return derEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDer_Expression()
  {
    return (EReference)derEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInit()
  {
    return initEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInit_Expression()
  {
    return (EReference)initEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvariant()
  {
    return invariantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInvariant_ConstraintName()
  {
    return (EAttribute)invariantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvariant_Expression()
  {
    return (EReference)invariantEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationContextDecl()
  {
    return operationContextDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDecl_Operation()
  {
    return (EReference)operationContextDeclEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDecl_Parameters()
  {
    return (EReference)operationContextDeclEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDecl_Type()
  {
    return (EReference)operationContextDeclEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDecl_Pres()
  {
    return (EReference)operationContextDeclEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDecl_Posts()
  {
    return (EReference)operationContextDeclEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDecl_Bodies()
  {
    return (EReference)operationContextDeclEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationRef()
  {
    return operationRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDeclaration()
  {
    return packageDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_Package()
  {
    return (EReference)packageDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDeclaration_Contexts()
  {
    return (EReference)packageDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageRef()
  {
    return packageRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameter()
  {
    return parameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameter_Name()
  {
    return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameter_Type()
  {
    return (EReference)parameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPost()
  {
    return postEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPost_ConstraintName()
  {
    return (EAttribute)postEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPost_Expression()
  {
    return (EReference)postEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPre()
  {
    return preEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPre_ConstraintName()
  {
    return (EAttribute)preEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPre_Expression()
  {
    return (EReference)preEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyContextDecl()
  {
    return propertyContextDeclEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyContextDecl_Property()
  {
    return (EReference)propertyContextDeclEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyContextDecl_Type()
  {
    return (EReference)propertyContextDeclEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyContextDecl_Init()
  {
    return (EReference)propertyContextDeclEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPropertyContextDecl_Der()
  {
    return (EReference)propertyContextDeclEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPropertyRef()
  {
    return propertyRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedClassifierRef()
  {
    return qualifiedClassifierRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQualifiedClassifierRef_Namespace()
  {
    return (EAttribute)qualifiedClassifierRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedClassifierRef_Element()
  {
    return (EReference)qualifiedClassifierRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedOperationRef()
  {
    return qualifiedOperationRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQualifiedOperationRef_Namespace()
  {
    return (EAttribute)qualifiedOperationRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedOperationRef_Element()
  {
    return (EReference)qualifiedOperationRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedPropertyRef()
  {
    return qualifiedPropertyRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQualifiedPropertyRef_Namespace()
  {
    return (EAttribute)qualifiedPropertyRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedPropertyRef_Element()
  {
    return (EReference)qualifiedPropertyRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQualifiedPackageRef()
  {
    return qualifiedPackageRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQualifiedPackageRef_Namespace()
  {
    return (EAttribute)qualifiedPackageRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getQualifiedPackageRef_Element()
  {
    return (EReference)qualifiedPackageRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleClassifierRef()
  {
    return simpleClassifierRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleClassifierRef_Classifier()
  {
    return (EAttribute)simpleClassifierRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleOperationRef()
  {
    return simpleOperationRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleOperationRef_Operation()
  {
    return (EAttribute)simpleOperationRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimplePackageRef()
  {
    return simplePackageRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimplePackageRef_Package()
  {
    return (EAttribute)simplePackageRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimplePropertyRef()
  {
    return simplePropertyRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimplePropertyRef_Feature()
  {
    return (EAttribute)simplePropertyRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNavigatingExp()
  {
    return navigatingExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOclMessageArg()
  {
    return oclMessageArgEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOclMessageArg_Type()
  {
    return (EReference)oclMessageArgEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimitiveType()
  {
    return primitiveTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrimitiveType_Name()
  {
    return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeExp()
  {
    return typeExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionType()
  {
    return collectionTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCollectionType_TypeIdentifier()
  {
    return (EAttribute)collectionTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleType()
  {
    return tupleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTupleType_Name()
  {
    return (EAttribute)tupleTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleType_Part()
  {
    return (EReference)tupleTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass gettuplePart()
  {
    return tuplePartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute gettuplePart_Name()
  {
    return (EAttribute)tuplePartEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference gettuplePart_Type()
  {
    return (EReference)tuplePartEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionLiteralExp()
  {
    return collectionLiteralExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionLiteralExp_CollectionLiteralParts()
  {
    return (EReference)collectionLiteralExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionLiteralPart()
  {
    return collectionLiteralPartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionLiteralPart_Expression()
  {
    return (EReference)collectionLiteralPartEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionLiteralPart_LastExpression()
  {
    return (EReference)collectionLiteralPartEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimitiveLiteralExp()
  {
    return primitiveLiteralExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleLiteralExp()
  {
    return tupleLiteralExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleLiteralExp_Part()
  {
    return (EReference)tupleLiteralExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleLiteralPart()
  {
    return tupleLiteralPartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTupleLiteralPart_Name()
  {
    return (EAttribute)tupleLiteralPartEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleLiteralPart_Type()
  {
    return (EReference)tupleLiteralPartEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleLiteralPart_InitExpression()
  {
    return (EReference)tupleLiteralPartEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumberLiteralExp()
  {
    return numberLiteralExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumberLiteralExp_Name()
  {
    return (EAttribute)numberLiteralExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringLiteralExp()
  {
    return stringLiteralExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringLiteralExp_Values()
  {
    return (EAttribute)stringLiteralExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanLiteralExp()
  {
    return booleanLiteralExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanLiteralExp_IsTrue()
  {
    return (EAttribute)booleanLiteralExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvalidLiteralExp()
  {
    return invalidLiteralExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullLiteralExp()
  {
    return nullLiteralExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getiteratorVariable()
  {
    return iteratorVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getiteratorVariable_Name()
  {
    return (EAttribute)iteratorVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getiteratorVariable_Type()
  {
    return (EReference)iteratorVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getiteratorAccumulator()
  {
    return iteratorAccumulatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getiteratorAccumulator_Name()
  {
    return (EAttribute)iteratorAccumulatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getiteratorAccumulator_Type()
  {
    return (EReference)iteratorAccumulatorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getiteratorAccumulator_InitExpression()
  {
    return (EReference)iteratorAccumulatorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoundBracketExp()
  {
    return roundBracketExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoundBracketExp_Name()
  {
    return (EReference)roundBracketExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRoundBracketExp_Pre()
  {
    return (EAttribute)roundBracketExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoundBracketExp_Variable1()
  {
    return (EReference)roundBracketExpEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoundBracketExp_Variable2()
  {
    return (EReference)roundBracketExpEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoundBracketExp_Arguments()
  {
    return (EReference)roundBracketExpEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSquareBracketExp()
  {
    return squareBracketExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSquareBracketExp_Name()
  {
    return (EReference)squareBracketExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSquareBracketExp_Arguments()
  {
    return (EReference)squareBracketExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSquareBracketExp_Pre()
  {
    return (EAttribute)squareBracketExpEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreExp()
  {
    return preExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreExp_Name()
  {
    return (EReference)preExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelfExp()
  {
    return selfExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameExp()
  {
    return nameExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPathNameExp()
  {
    return pathNameExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPathNameExp_Namespace()
  {
    return (EAttribute)pathNameExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPathNameExp_Element()
  {
    return (EReference)pathNameExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleNameExp()
  {
    return simpleNameExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleNameExp_Element()
  {
    return (EAttribute)simpleNameExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfExp()
  {
    return ifExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfExp_Condition()
  {
    return (EReference)ifExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfExp_ThenExpression()
  {
    return (EReference)ifExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfExp_ElseExpression()
  {
    return (EReference)ifExpEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLetExp()
  {
    return letExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetExp_Variable()
  {
    return (EReference)letExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetExp_In()
  {
    return (EReference)letExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLetVariable()
  {
    return letVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLetVariable_Name()
  {
    return (EAttribute)letVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetVariable_Type()
  {
    return (EReference)letVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetVariable_InitExpression()
  {
    return (EReference)letVariableEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInfixExp()
  {
    return infixExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInfixExp_Source()
  {
    return (EReference)infixExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInfixExp_Op()
  {
    return (EAttribute)infixExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInfixExp_Argument()
  {
    return (EReference)infixExpEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOclMessage()
  {
    return oclMessageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOclMessage_Source()
  {
    return (EReference)oclMessageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOclMessage_Op()
  {
    return (EAttribute)oclMessageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOclMessage_MessageName()
  {
    return (EAttribute)oclMessageEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOclMessage_Arguments()
  {
    return (EReference)oclMessageEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrefixExp()
  {
    return prefixExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrefixExp_Op()
  {
    return (EAttribute)prefixExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrefixExp_Source()
  {
    return (EReference)prefixExpEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedExp()
  {
    return nestedExpEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNestedExp_Source()
  {
    return (EReference)nestedExpEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BacktrackingContentAssistTestFactory getBacktrackingContentAssistTestFactory()
  {
    return (BacktrackingContentAssistTestFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    documentEClass = createEClass(DOCUMENT);
    createEReference(documentEClass, DOCUMENT__PACKAGES);
    createEReference(documentEClass, DOCUMENT__CONTEXTS);

    bodyEClass = createEClass(BODY);
    createEAttribute(bodyEClass, BODY__CONSTRAINT_NAME);
    createEReference(bodyEClass, BODY__EXPRESSION);

    classifierContextDeclEClass = createEClass(CLASSIFIER_CONTEXT_DECL);
    createEAttribute(classifierContextDeclEClass, CLASSIFIER_CONTEXT_DECL__SELF_NAME);
    createEReference(classifierContextDeclEClass, CLASSIFIER_CONTEXT_DECL__CLASSIFIER);
    createEReference(classifierContextDeclEClass, CLASSIFIER_CONTEXT_DECL__INVARIANTS);
    createEReference(classifierContextDeclEClass, CLASSIFIER_CONTEXT_DECL__DEFINITIONS);

    classifierRefEClass = createEClass(CLASSIFIER_REF);

    contextDeclEClass = createEClass(CONTEXT_DECL);

    definitionEClass = createEClass(DEFINITION);
    createEAttribute(definitionEClass, DEFINITION__STATIC);
    createEAttribute(definitionEClass, DEFINITION__CONSTRAINT_NAME);
    createEAttribute(definitionEClass, DEFINITION__CONSTRAINED_NAME);
    createEReference(definitionEClass, DEFINITION__PARAMETERS);
    createEReference(definitionEClass, DEFINITION__TYPE);
    createEReference(definitionEClass, DEFINITION__EXPRESSION);

    derEClass = createEClass(DER);
    createEReference(derEClass, DER__EXPRESSION);

    initEClass = createEClass(INIT);
    createEReference(initEClass, INIT__EXPRESSION);

    invariantEClass = createEClass(INVARIANT);
    createEAttribute(invariantEClass, INVARIANT__CONSTRAINT_NAME);
    createEReference(invariantEClass, INVARIANT__EXPRESSION);

    operationContextDeclEClass = createEClass(OPERATION_CONTEXT_DECL);
    createEReference(operationContextDeclEClass, OPERATION_CONTEXT_DECL__OPERATION);
    createEReference(operationContextDeclEClass, OPERATION_CONTEXT_DECL__PARAMETERS);
    createEReference(operationContextDeclEClass, OPERATION_CONTEXT_DECL__TYPE);
    createEReference(operationContextDeclEClass, OPERATION_CONTEXT_DECL__PRES);
    createEReference(operationContextDeclEClass, OPERATION_CONTEXT_DECL__POSTS);
    createEReference(operationContextDeclEClass, OPERATION_CONTEXT_DECL__BODIES);

    operationRefEClass = createEClass(OPERATION_REF);

    packageDeclarationEClass = createEClass(PACKAGE_DECLARATION);
    createEReference(packageDeclarationEClass, PACKAGE_DECLARATION__PACKAGE);
    createEReference(packageDeclarationEClass, PACKAGE_DECLARATION__CONTEXTS);

    packageRefEClass = createEClass(PACKAGE_REF);

    parameterEClass = createEClass(PARAMETER);
    createEAttribute(parameterEClass, PARAMETER__NAME);
    createEReference(parameterEClass, PARAMETER__TYPE);

    postEClass = createEClass(POST);
    createEAttribute(postEClass, POST__CONSTRAINT_NAME);
    createEReference(postEClass, POST__EXPRESSION);

    preEClass = createEClass(PRE);
    createEAttribute(preEClass, PRE__CONSTRAINT_NAME);
    createEReference(preEClass, PRE__EXPRESSION);

    propertyContextDeclEClass = createEClass(PROPERTY_CONTEXT_DECL);
    createEReference(propertyContextDeclEClass, PROPERTY_CONTEXT_DECL__PROPERTY);
    createEReference(propertyContextDeclEClass, PROPERTY_CONTEXT_DECL__TYPE);
    createEReference(propertyContextDeclEClass, PROPERTY_CONTEXT_DECL__INIT);
    createEReference(propertyContextDeclEClass, PROPERTY_CONTEXT_DECL__DER);

    propertyRefEClass = createEClass(PROPERTY_REF);

    qualifiedClassifierRefEClass = createEClass(QUALIFIED_CLASSIFIER_REF);
    createEAttribute(qualifiedClassifierRefEClass, QUALIFIED_CLASSIFIER_REF__NAMESPACE);
    createEReference(qualifiedClassifierRefEClass, QUALIFIED_CLASSIFIER_REF__ELEMENT);

    qualifiedOperationRefEClass = createEClass(QUALIFIED_OPERATION_REF);
    createEAttribute(qualifiedOperationRefEClass, QUALIFIED_OPERATION_REF__NAMESPACE);
    createEReference(qualifiedOperationRefEClass, QUALIFIED_OPERATION_REF__ELEMENT);

    qualifiedPropertyRefEClass = createEClass(QUALIFIED_PROPERTY_REF);
    createEAttribute(qualifiedPropertyRefEClass, QUALIFIED_PROPERTY_REF__NAMESPACE);
    createEReference(qualifiedPropertyRefEClass, QUALIFIED_PROPERTY_REF__ELEMENT);

    qualifiedPackageRefEClass = createEClass(QUALIFIED_PACKAGE_REF);
    createEAttribute(qualifiedPackageRefEClass, QUALIFIED_PACKAGE_REF__NAMESPACE);
    createEReference(qualifiedPackageRefEClass, QUALIFIED_PACKAGE_REF__ELEMENT);

    simpleClassifierRefEClass = createEClass(SIMPLE_CLASSIFIER_REF);
    createEAttribute(simpleClassifierRefEClass, SIMPLE_CLASSIFIER_REF__CLASSIFIER);

    simpleOperationRefEClass = createEClass(SIMPLE_OPERATION_REF);
    createEAttribute(simpleOperationRefEClass, SIMPLE_OPERATION_REF__OPERATION);

    simplePackageRefEClass = createEClass(SIMPLE_PACKAGE_REF);
    createEAttribute(simplePackageRefEClass, SIMPLE_PACKAGE_REF__PACKAGE);

    simplePropertyRefEClass = createEClass(SIMPLE_PROPERTY_REF);
    createEAttribute(simplePropertyRefEClass, SIMPLE_PROPERTY_REF__FEATURE);

    expressionEClass = createEClass(EXPRESSION);

    navigatingExpEClass = createEClass(NAVIGATING_EXP);

    oclMessageArgEClass = createEClass(OCL_MESSAGE_ARG);
    createEReference(oclMessageArgEClass, OCL_MESSAGE_ARG__TYPE);

    primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);
    createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__NAME);

    typeExpEClass = createEClass(TYPE_EXP);

    collectionTypeEClass = createEClass(COLLECTION_TYPE);
    createEAttribute(collectionTypeEClass, COLLECTION_TYPE__TYPE_IDENTIFIER);

    tupleTypeEClass = createEClass(TUPLE_TYPE);
    createEAttribute(tupleTypeEClass, TUPLE_TYPE__NAME);
    createEReference(tupleTypeEClass, TUPLE_TYPE__PART);

    tuplePartEClass = createEClass(TUPLE_PART);
    createEAttribute(tuplePartEClass, TUPLE_PART__NAME);
    createEReference(tuplePartEClass, TUPLE_PART__TYPE);

    collectionLiteralExpEClass = createEClass(COLLECTION_LITERAL_EXP);
    createEReference(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__COLLECTION_LITERAL_PARTS);

    collectionLiteralPartEClass = createEClass(COLLECTION_LITERAL_PART);
    createEReference(collectionLiteralPartEClass, COLLECTION_LITERAL_PART__EXPRESSION);
    createEReference(collectionLiteralPartEClass, COLLECTION_LITERAL_PART__LAST_EXPRESSION);

    primitiveLiteralExpEClass = createEClass(PRIMITIVE_LITERAL_EXP);

    tupleLiteralExpEClass = createEClass(TUPLE_LITERAL_EXP);
    createEReference(tupleLiteralExpEClass, TUPLE_LITERAL_EXP__PART);

    tupleLiteralPartEClass = createEClass(TUPLE_LITERAL_PART);
    createEAttribute(tupleLiteralPartEClass, TUPLE_LITERAL_PART__NAME);
    createEReference(tupleLiteralPartEClass, TUPLE_LITERAL_PART__TYPE);
    createEReference(tupleLiteralPartEClass, TUPLE_LITERAL_PART__INIT_EXPRESSION);

    numberLiteralExpEClass = createEClass(NUMBER_LITERAL_EXP);
    createEAttribute(numberLiteralExpEClass, NUMBER_LITERAL_EXP__NAME);

    stringLiteralExpEClass = createEClass(STRING_LITERAL_EXP);
    createEAttribute(stringLiteralExpEClass, STRING_LITERAL_EXP__VALUES);

    booleanLiteralExpEClass = createEClass(BOOLEAN_LITERAL_EXP);
    createEAttribute(booleanLiteralExpEClass, BOOLEAN_LITERAL_EXP__IS_TRUE);

    invalidLiteralExpEClass = createEClass(INVALID_LITERAL_EXP);

    nullLiteralExpEClass = createEClass(NULL_LITERAL_EXP);

    iteratorVariableEClass = createEClass(ITERATOR_VARIABLE);
    createEAttribute(iteratorVariableEClass, ITERATOR_VARIABLE__NAME);
    createEReference(iteratorVariableEClass, ITERATOR_VARIABLE__TYPE);

    iteratorAccumulatorEClass = createEClass(ITERATOR_ACCUMULATOR);
    createEAttribute(iteratorAccumulatorEClass, ITERATOR_ACCUMULATOR__NAME);
    createEReference(iteratorAccumulatorEClass, ITERATOR_ACCUMULATOR__TYPE);
    createEReference(iteratorAccumulatorEClass, ITERATOR_ACCUMULATOR__INIT_EXPRESSION);

    roundBracketExpEClass = createEClass(ROUND_BRACKET_EXP);
    createEReference(roundBracketExpEClass, ROUND_BRACKET_EXP__NAME);
    createEAttribute(roundBracketExpEClass, ROUND_BRACKET_EXP__PRE);
    createEReference(roundBracketExpEClass, ROUND_BRACKET_EXP__VARIABLE1);
    createEReference(roundBracketExpEClass, ROUND_BRACKET_EXP__VARIABLE2);
    createEReference(roundBracketExpEClass, ROUND_BRACKET_EXP__ARGUMENTS);

    squareBracketExpEClass = createEClass(SQUARE_BRACKET_EXP);
    createEReference(squareBracketExpEClass, SQUARE_BRACKET_EXP__NAME);
    createEReference(squareBracketExpEClass, SQUARE_BRACKET_EXP__ARGUMENTS);
    createEAttribute(squareBracketExpEClass, SQUARE_BRACKET_EXP__PRE);

    preExpEClass = createEClass(PRE_EXP);
    createEReference(preExpEClass, PRE_EXP__NAME);

    selfExpEClass = createEClass(SELF_EXP);

    nameExpEClass = createEClass(NAME_EXP);

    pathNameExpEClass = createEClass(PATH_NAME_EXP);
    createEAttribute(pathNameExpEClass, PATH_NAME_EXP__NAMESPACE);
    createEReference(pathNameExpEClass, PATH_NAME_EXP__ELEMENT);

    simpleNameExpEClass = createEClass(SIMPLE_NAME_EXP);
    createEAttribute(simpleNameExpEClass, SIMPLE_NAME_EXP__ELEMENT);

    ifExpEClass = createEClass(IF_EXP);
    createEReference(ifExpEClass, IF_EXP__CONDITION);
    createEReference(ifExpEClass, IF_EXP__THEN_EXPRESSION);
    createEReference(ifExpEClass, IF_EXP__ELSE_EXPRESSION);

    letExpEClass = createEClass(LET_EXP);
    createEReference(letExpEClass, LET_EXP__VARIABLE);
    createEReference(letExpEClass, LET_EXP__IN);

    letVariableEClass = createEClass(LET_VARIABLE);
    createEAttribute(letVariableEClass, LET_VARIABLE__NAME);
    createEReference(letVariableEClass, LET_VARIABLE__TYPE);
    createEReference(letVariableEClass, LET_VARIABLE__INIT_EXPRESSION);

    infixExpEClass = createEClass(INFIX_EXP);
    createEReference(infixExpEClass, INFIX_EXP__SOURCE);
    createEAttribute(infixExpEClass, INFIX_EXP__OP);
    createEReference(infixExpEClass, INFIX_EXP__ARGUMENT);

    oclMessageEClass = createEClass(OCL_MESSAGE);
    createEReference(oclMessageEClass, OCL_MESSAGE__SOURCE);
    createEAttribute(oclMessageEClass, OCL_MESSAGE__OP);
    createEAttribute(oclMessageEClass, OCL_MESSAGE__MESSAGE_NAME);
    createEReference(oclMessageEClass, OCL_MESSAGE__ARGUMENTS);

    prefixExpEClass = createEClass(PREFIX_EXP);
    createEAttribute(prefixExpEClass, PREFIX_EXP__OP);
    createEReference(prefixExpEClass, PREFIX_EXP__SOURCE);

    nestedExpEClass = createEClass(NESTED_EXP);
    createEReference(nestedExpEClass, NESTED_EXP__SOURCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    classifierContextDeclEClass.getESuperTypes().add(this.getContextDecl());
    operationContextDeclEClass.getESuperTypes().add(this.getContextDecl());
    propertyContextDeclEClass.getESuperTypes().add(this.getContextDecl());
    qualifiedClassifierRefEClass.getESuperTypes().add(this.getClassifierRef());
    qualifiedOperationRefEClass.getESuperTypes().add(this.getOperationRef());
    qualifiedPropertyRefEClass.getESuperTypes().add(this.getPropertyRef());
    qualifiedPackageRefEClass.getESuperTypes().add(this.getPackageRef());
    simpleClassifierRefEClass.getESuperTypes().add(this.getClassifierRef());
    simpleOperationRefEClass.getESuperTypes().add(this.getOperationRef());
    simplePackageRefEClass.getESuperTypes().add(this.getPackageRef());
    simplePropertyRefEClass.getESuperTypes().add(this.getPropertyRef());
    expressionEClass.getESuperTypes().add(this.getNavigatingExp());
    expressionEClass.getESuperTypes().add(this.getOclMessageArg());
    primitiveTypeEClass.getESuperTypes().add(this.getTypeExp());
    typeExpEClass.getESuperTypes().add(this.getExpression());
    collectionTypeEClass.getESuperTypes().add(this.getTypeExp());
    collectionTypeEClass.getESuperTypes().add(this.getCollectionLiteralExp());
    tupleTypeEClass.getESuperTypes().add(this.getTypeExp());
    collectionLiteralExpEClass.getESuperTypes().add(this.getExpression());
    primitiveLiteralExpEClass.getESuperTypes().add(this.getExpression());
    tupleLiteralExpEClass.getESuperTypes().add(this.getExpression());
    numberLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
    stringLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
    booleanLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
    invalidLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
    nullLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
    roundBracketExpEClass.getESuperTypes().add(this.getExpression());
    squareBracketExpEClass.getESuperTypes().add(this.getExpression());
    preExpEClass.getESuperTypes().add(this.getExpression());
    selfExpEClass.getESuperTypes().add(this.getExpression());
    nameExpEClass.getESuperTypes().add(this.getTypeExp());
    pathNameExpEClass.getESuperTypes().add(this.getNameExp());
    simpleNameExpEClass.getESuperTypes().add(this.getNameExp());
    ifExpEClass.getESuperTypes().add(this.getExpression());
    letExpEClass.getESuperTypes().add(this.getExpression());
    infixExpEClass.getESuperTypes().add(this.getExpression());
    oclMessageEClass.getESuperTypes().add(this.getExpression());
    prefixExpEClass.getESuperTypes().add(this.getExpression());
    nestedExpEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(documentEClass, Document.class, "Document", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDocument_Packages(), this.getPackageDeclaration(), null, "packages", null, 0, -1, Document.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocument_Contexts(), this.getContextDecl(), null, "contexts", null, 0, -1, Document.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bodyEClass, Body.class, "Body", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBody_ConstraintName(), ecorePackage.getEString(), "constraintName", null, 0, 1, Body.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBody_Expression(), this.getExpression(), null, "expression", null, 0, 1, Body.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classifierContextDeclEClass, ClassifierContextDecl.class, "ClassifierContextDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClassifierContextDecl_SelfName(), ecorePackage.getEString(), "selfName", null, 0, 1, ClassifierContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifierContextDecl_Classifier(), this.getClassifierRef(), null, "classifier", null, 0, 1, ClassifierContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifierContextDecl_Invariants(), this.getInvariant(), null, "invariants", null, 0, -1, ClassifierContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifierContextDecl_Definitions(), this.getDefinition(), null, "definitions", null, 0, -1, ClassifierContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(classifierRefEClass, ClassifierRef.class, "ClassifierRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(contextDeclEClass, ContextDecl.class, "ContextDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(definitionEClass, Definition.class, "Definition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDefinition_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDefinition_ConstraintName(), ecorePackage.getEString(), "constraintName", null, 0, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDefinition_ConstrainedName(), ecorePackage.getEString(), "constrainedName", null, 0, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDefinition_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDefinition_Type(), this.getTypeExp(), null, "type", null, 0, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDefinition_Expression(), this.getExpression(), null, "expression", null, 0, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(derEClass, Der.class, "Der", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDer_Expression(), this.getExpression(), null, "expression", null, 0, 1, Der.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initEClass, Init.class, "Init", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInit_Expression(), this.getExpression(), null, "expression", null, 0, 1, Init.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invariantEClass, Invariant.class, "Invariant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInvariant_ConstraintName(), ecorePackage.getEString(), "constraintName", null, 0, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInvariant_Expression(), this.getExpression(), null, "expression", null, 0, 1, Invariant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationContextDeclEClass, OperationContextDecl.class, "OperationContextDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperationContextDecl_Operation(), this.getOperationRef(), null, "operation", null, 0, 1, OperationContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDecl_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, OperationContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDecl_Type(), this.getTypeExp(), null, "type", null, 0, 1, OperationContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDecl_Pres(), this.getPre(), null, "pres", null, 0, -1, OperationContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDecl_Posts(), this.getPost(), null, "posts", null, 0, -1, OperationContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDecl_Bodies(), this.getBody(), null, "bodies", null, 0, -1, OperationContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationRefEClass, OperationRef.class, "OperationRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(packageDeclarationEClass, PackageDeclaration.class, "PackageDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPackageDeclaration_Package(), this.getPackageRef(), null, "package", null, 0, 1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDeclaration_Contexts(), this.getContextDecl(), null, "contexts", null, 0, -1, PackageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packageRefEClass, PackageRef.class, "PackageRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParameter_Type(), this.getTypeExp(), null, "type", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postEClass, Post.class, "Post", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPost_ConstraintName(), ecorePackage.getEString(), "constraintName", null, 0, 1, Post.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPost_Expression(), this.getExpression(), null, "expression", null, 0, 1, Post.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(preEClass, Pre.class, "Pre", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPre_ConstraintName(), ecorePackage.getEString(), "constraintName", null, 0, 1, Pre.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPre_Expression(), this.getExpression(), null, "expression", null, 0, 1, Pre.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyContextDeclEClass, PropertyContextDecl.class, "PropertyContextDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPropertyContextDecl_Property(), this.getPropertyRef(), null, "property", null, 0, 1, PropertyContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyContextDecl_Type(), this.getTypeExp(), null, "type", null, 0, 1, PropertyContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyContextDecl_Init(), this.getInit(), null, "init", null, 0, 1, PropertyContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPropertyContextDecl_Der(), this.getDer(), null, "der", null, 0, 1, PropertyContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(propertyRefEClass, PropertyRef.class, "PropertyRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(qualifiedClassifierRefEClass, QualifiedClassifierRef.class, "QualifiedClassifierRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQualifiedClassifierRef_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, QualifiedClassifierRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedClassifierRef_Element(), this.getClassifierRef(), null, "element", null, 0, 1, QualifiedClassifierRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedOperationRefEClass, QualifiedOperationRef.class, "QualifiedOperationRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQualifiedOperationRef_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, QualifiedOperationRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedOperationRef_Element(), this.getOperationRef(), null, "element", null, 0, 1, QualifiedOperationRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedPropertyRefEClass, QualifiedPropertyRef.class, "QualifiedPropertyRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQualifiedPropertyRef_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, QualifiedPropertyRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedPropertyRef_Element(), this.getPropertyRef(), null, "element", null, 0, 1, QualifiedPropertyRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedPackageRefEClass, QualifiedPackageRef.class, "QualifiedPackageRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQualifiedPackageRef_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, QualifiedPackageRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getQualifiedPackageRef_Element(), this.getPackageRef(), null, "element", null, 0, 1, QualifiedPackageRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleClassifierRefEClass, SimpleClassifierRef.class, "SimpleClassifierRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleClassifierRef_Classifier(), ecorePackage.getEString(), "classifier", null, 0, 1, SimpleClassifierRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleOperationRefEClass, SimpleOperationRef.class, "SimpleOperationRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleOperationRef_Operation(), ecorePackage.getEString(), "operation", null, 0, 1, SimpleOperationRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simplePackageRefEClass, SimplePackageRef.class, "SimplePackageRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimplePackageRef_Package(), ecorePackage.getEString(), "package", null, 0, 1, SimplePackageRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simplePropertyRefEClass, SimplePropertyRef.class, "SimplePropertyRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimplePropertyRef_Feature(), ecorePackage.getEString(), "feature", null, 0, 1, SimplePropertyRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(navigatingExpEClass, NavigatingExp.class, "NavigatingExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(oclMessageArgEClass, OclMessageArg.class, "OclMessageArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOclMessageArg_Type(), this.getTypeExp(), null, "type", null, 0, 1, OclMessageArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPrimitiveType_Name(), ecorePackage.getEString(), "name", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeExpEClass, TypeExp.class, "TypeExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(collectionTypeEClass, CollectionType.class, "CollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCollectionType_TypeIdentifier(), ecorePackage.getEString(), "typeIdentifier", null, 0, 1, CollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleTypeEClass, TupleType.class, "TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTupleType_Name(), ecorePackage.getEString(), "name", null, 0, 1, TupleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTupleType_Part(), this.gettuplePart(), null, "part", null, 0, -1, TupleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tuplePartEClass, tuplePart.class, "tuplePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(gettuplePart_Name(), ecorePackage.getEString(), "name", null, 0, 1, tuplePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(gettuplePart_Type(), this.getTypeExp(), null, "type", null, 0, 1, tuplePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(collectionLiteralExpEClass, CollectionLiteralExp.class, "CollectionLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCollectionLiteralExp_CollectionLiteralParts(), this.getCollectionLiteralPart(), null, "collectionLiteralParts", null, 0, -1, CollectionLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(collectionLiteralPartEClass, CollectionLiteralPart.class, "CollectionLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCollectionLiteralPart_Expression(), this.getExpression(), null, "expression", null, 0, 1, CollectionLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCollectionLiteralPart_LastExpression(), this.getExpression(), null, "lastExpression", null, 0, 1, CollectionLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primitiveLiteralExpEClass, PrimitiveLiteralExp.class, "PrimitiveLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tupleLiteralExpEClass, TupleLiteralExp.class, "TupleLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTupleLiteralExp_Part(), this.getTupleLiteralPart(), null, "part", null, 0, -1, TupleLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleLiteralPartEClass, TupleLiteralPart.class, "TupleLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTupleLiteralPart_Name(), ecorePackage.getEString(), "name", null, 0, 1, TupleLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTupleLiteralPart_Type(), this.getTypeExp(), null, "type", null, 0, 1, TupleLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTupleLiteralPart_InitExpression(), this.getExpression(), null, "initExpression", null, 0, 1, TupleLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numberLiteralExpEClass, NumberLiteralExp.class, "NumberLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumberLiteralExp_Name(), ecorePackage.getEString(), "name", null, 0, 1, NumberLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringLiteralExpEClass, StringLiteralExp.class, "StringLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringLiteralExp_Values(), ecorePackage.getEString(), "values", null, 0, -1, StringLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanLiteralExpEClass, BooleanLiteralExp.class, "BooleanLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanLiteralExp_IsTrue(), ecorePackage.getEBoolean(), "isTrue", null, 0, 1, BooleanLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invalidLiteralExpEClass, InvalidLiteralExp.class, "InvalidLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nullLiteralExpEClass, NullLiteralExp.class, "NullLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(iteratorVariableEClass, iteratorVariable.class, "iteratorVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getiteratorVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, iteratorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getiteratorVariable_Type(), this.getTypeExp(), null, "type", null, 0, 1, iteratorVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(iteratorAccumulatorEClass, iteratorAccumulator.class, "iteratorAccumulator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getiteratorAccumulator_Name(), ecorePackage.getEString(), "name", null, 0, 1, iteratorAccumulator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getiteratorAccumulator_Type(), this.getTypeExp(), null, "type", null, 0, 1, iteratorAccumulator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getiteratorAccumulator_InitExpression(), this.getExpression(), null, "initExpression", null, 0, 1, iteratorAccumulator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(roundBracketExpEClass, RoundBracketExp.class, "RoundBracketExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoundBracketExp_Name(), this.getNameExp(), null, "name", null, 0, 1, RoundBracketExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRoundBracketExp_Pre(), ecorePackage.getEBoolean(), "pre", null, 0, 1, RoundBracketExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoundBracketExp_Variable1(), this.getiteratorVariable(), null, "variable1", null, 0, 1, RoundBracketExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoundBracketExp_Variable2(), ecorePackage.getEObject(), null, "variable2", null, 0, 1, RoundBracketExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRoundBracketExp_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, RoundBracketExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(squareBracketExpEClass, SquareBracketExp.class, "SquareBracketExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSquareBracketExp_Name(), this.getNameExp(), null, "name", null, 0, 1, SquareBracketExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSquareBracketExp_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, SquareBracketExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSquareBracketExp_Pre(), ecorePackage.getEBoolean(), "pre", null, 0, 1, SquareBracketExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(preExpEClass, PreExp.class, "PreExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPreExp_Name(), this.getNameExp(), null, "name", null, 0, 1, PreExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selfExpEClass, SelfExp.class, "SelfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nameExpEClass, NameExp.class, "NameExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(pathNameExpEClass, PathNameExp.class, "PathNameExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPathNameExp_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, PathNameExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPathNameExp_Element(), this.getNameExp(), null, "element", null, 0, 1, PathNameExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleNameExpEClass, SimpleNameExp.class, "SimpleNameExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSimpleNameExp_Element(), ecorePackage.getEString(), "element", null, 0, 1, SimpleNameExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifExpEClass, IfExp.class, "IfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfExp_Condition(), this.getExpression(), null, "condition", null, 0, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfExp_ThenExpression(), this.getExpression(), null, "thenExpression", null, 0, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfExp_ElseExpression(), this.getExpression(), null, "elseExpression", null, 0, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(letExpEClass, LetExp.class, "LetExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLetExp_Variable(), this.getLetVariable(), null, "variable", null, 0, -1, LetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLetExp_In(), this.getExpression(), null, "in", null, 0, 1, LetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(letVariableEClass, LetVariable.class, "LetVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLetVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, LetVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLetVariable_Type(), this.getTypeExp(), null, "type", null, 0, 1, LetVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLetVariable_InitExpression(), this.getExpression(), null, "initExpression", null, 0, 1, LetVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(infixExpEClass, InfixExp.class, "InfixExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInfixExp_Source(), this.getExpression(), null, "source", null, 0, 1, InfixExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInfixExp_Op(), ecorePackage.getEString(), "op", null, 0, 1, InfixExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInfixExp_Argument(), this.getNavigatingExp(), null, "argument", null, 0, 1, InfixExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oclMessageEClass, OclMessage.class, "OclMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOclMessage_Source(), this.getExpression(), null, "source", null, 0, 1, OclMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOclMessage_Op(), ecorePackage.getEString(), "op", null, 0, 1, OclMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOclMessage_MessageName(), ecorePackage.getEString(), "messageName", null, 0, 1, OclMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOclMessage_Arguments(), this.getOclMessageArg(), null, "arguments", null, 0, -1, OclMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(prefixExpEClass, PrefixExp.class, "PrefixExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPrefixExp_Op(), ecorePackage.getEString(), "op", null, 0, 1, PrefixExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrefixExp_Source(), this.getExpression(), null, "source", null, 0, 1, PrefixExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedExpEClass, NestedExp.class, "NestedExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNestedExp_Source(), this.getExpression(), null, "source", null, 0, 1, NestedExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //BacktrackingContentAssistTestPackageImpl
