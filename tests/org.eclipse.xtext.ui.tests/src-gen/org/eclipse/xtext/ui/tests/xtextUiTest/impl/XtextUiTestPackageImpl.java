/**
 */
package org.eclipse.xtext.ui.tests.xtextUiTest.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.ui.tests.xtextUiTest.AbstractElement;
import org.eclipse.xtext.ui.tests.xtextUiTest.AbstractMetamodelDeclaration;
import org.eclipse.xtext.ui.tests.xtextUiTest.AbstractNegatedToken;
import org.eclipse.xtext.ui.tests.xtextUiTest.AbstractRule;
import org.eclipse.xtext.ui.tests.xtextUiTest.Action;
import org.eclipse.xtext.ui.tests.xtextUiTest.Alternatives;
import org.eclipse.xtext.ui.tests.xtextUiTest.Assignment;
import org.eclipse.xtext.ui.tests.xtextUiTest.CharacterRange;
import org.eclipse.xtext.ui.tests.xtextUiTest.CrossReference;
import org.eclipse.xtext.ui.tests.xtextUiTest.EnumLiteralDeclaration;
import org.eclipse.xtext.ui.tests.xtextUiTest.EnumRule;
import org.eclipse.xtext.ui.tests.xtextUiTest.GeneratedMetamodel;
import org.eclipse.xtext.ui.tests.xtextUiTest.Grammar;
import org.eclipse.xtext.ui.tests.xtextUiTest.Group;
import org.eclipse.xtext.ui.tests.xtextUiTest.Keyword;
import org.eclipse.xtext.ui.tests.xtextUiTest.NegatedToken;
import org.eclipse.xtext.ui.tests.xtextUiTest.ParserRule;
import org.eclipse.xtext.ui.tests.xtextUiTest.ReferencedMetamodel;
import org.eclipse.xtext.ui.tests.xtextUiTest.RuleCall;
import org.eclipse.xtext.ui.tests.xtextUiTest.TerminalRule;
import org.eclipse.xtext.ui.tests.xtextUiTest.TypeRef;
import org.eclipse.xtext.ui.tests.xtextUiTest.UntilToken;
import org.eclipse.xtext.ui.tests.xtextUiTest.Wildcard;
import org.eclipse.xtext.ui.tests.xtextUiTest.XtextUiTestFactory;
import org.eclipse.xtext.ui.tests.xtextUiTest.XtextUiTestPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XtextUiTestPackageImpl extends EPackageImpl implements XtextUiTestPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass grammarEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractMetamodelDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass generatedMetamodelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referencedMetamodelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parserRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keywordEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass crossReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass terminalRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractNegatedTokenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass negatedTokenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass untilTokenEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass wildcardEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumLiteralDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alternativesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass groupEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass characterRangeEClass = null;

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
   * @see org.eclipse.xtext.ui.tests.xtextUiTest.XtextUiTestPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private XtextUiTestPackageImpl()
  {
    super(eNS_URI, XtextUiTestFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link XtextUiTestPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static XtextUiTestPackage init()
  {
    if (isInited) return (XtextUiTestPackage)EPackage.Registry.INSTANCE.getEPackage(XtextUiTestPackage.eNS_URI);

    // Obtain or create and register package
    XtextUiTestPackageImpl theXtextUiTestPackage = (XtextUiTestPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XtextUiTestPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XtextUiTestPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theXtextUiTestPackage.createPackageContents();

    // Initialize created meta-data
    theXtextUiTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theXtextUiTestPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(XtextUiTestPackage.eNS_URI, theXtextUiTestPackage);
    return theXtextUiTestPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGrammar()
  {
    return grammarEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGrammar_Name()
  {
    return (EAttribute)grammarEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGrammar_UsedGrammars()
  {
    return (EReference)grammarEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGrammar_DefinesHiddenTokens()
  {
    return (EAttribute)grammarEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGrammar_HiddenTokens()
  {
    return (EReference)grammarEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGrammar_MetamodelDeclarations()
  {
    return (EReference)grammarEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGrammar_Rules()
  {
    return (EReference)grammarEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractRule()
  {
    return abstractRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractRule_Name()
  {
    return (EAttribute)abstractRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractRule_Type()
  {
    return (EReference)abstractRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractRule_Alternatives()
  {
    return (EReference)abstractRuleEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractMetamodelDeclaration()
  {
    return abstractMetamodelDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractMetamodelDeclaration_EPackage()
  {
    return (EReference)abstractMetamodelDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractMetamodelDeclaration_Alias()
  {
    return (EAttribute)abstractMetamodelDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGeneratedMetamodel()
  {
    return generatedMetamodelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGeneratedMetamodel_Name()
  {
    return (EAttribute)generatedMetamodelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReferencedMetamodel()
  {
    return referencedMetamodelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParserRule()
  {
    return parserRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParserRule_DefinesHiddenTokens()
  {
    return (EAttribute)parserRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParserRule_HiddenTokens()
  {
    return (EReference)parserRuleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeRef()
  {
    return typeRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeRef_Metamodel()
  {
    return (EReference)typeRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeRef_Classifier()
  {
    return (EReference)typeRefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractElement()
  {
    return abstractElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractElement_Cardinality()
  {
    return (EAttribute)abstractElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAction()
  {
    return actionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAction_Type()
  {
    return (EReference)actionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAction_Feature()
  {
    return (EAttribute)actionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAction_Operator()
  {
    return (EAttribute)actionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeyword()
  {
    return keywordEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyword_Value()
  {
    return (EAttribute)keywordEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleCall()
  {
    return ruleCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleCall_Rule()
  {
    return (EReference)ruleCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignment()
  {
    return assignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignment_Feature()
  {
    return (EAttribute)assignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignment_Operator()
  {
    return (EAttribute)assignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignment_Terminal()
  {
    return (EReference)assignmentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCrossReference()
  {
    return crossReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCrossReference_Type()
  {
    return (EReference)crossReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCrossReference_Terminal()
  {
    return (EReference)crossReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTerminalRule()
  {
    return terminalRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractNegatedToken()
  {
    return abstractNegatedTokenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractNegatedToken_Terminal()
  {
    return (EReference)abstractNegatedTokenEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNegatedToken()
  {
    return negatedTokenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUntilToken()
  {
    return untilTokenEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWildcard()
  {
    return wildcardEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumRule()
  {
    return enumRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumLiteralDeclaration()
  {
    return enumLiteralDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumLiteralDeclaration_EnumLiteral()
  {
    return (EReference)enumLiteralDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumLiteralDeclaration_Literal()
  {
    return (EReference)enumLiteralDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlternatives()
  {
    return alternativesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlternatives_Groups()
  {
    return (EReference)alternativesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGroup()
  {
    return groupEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGroup_Tokens()
  {
    return (EReference)groupEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCharacterRange()
  {
    return characterRangeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCharacterRange_Left()
  {
    return (EReference)characterRangeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCharacterRange_Right()
  {
    return (EReference)characterRangeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XtextUiTestFactory getXtextUiTestFactory()
  {
    return (XtextUiTestFactory)getEFactoryInstance();
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
    grammarEClass = createEClass(GRAMMAR);
    createEAttribute(grammarEClass, GRAMMAR__NAME);
    createEReference(grammarEClass, GRAMMAR__USED_GRAMMARS);
    createEAttribute(grammarEClass, GRAMMAR__DEFINES_HIDDEN_TOKENS);
    createEReference(grammarEClass, GRAMMAR__HIDDEN_TOKENS);
    createEReference(grammarEClass, GRAMMAR__METAMODEL_DECLARATIONS);
    createEReference(grammarEClass, GRAMMAR__RULES);

    abstractRuleEClass = createEClass(ABSTRACT_RULE);
    createEAttribute(abstractRuleEClass, ABSTRACT_RULE__NAME);
    createEReference(abstractRuleEClass, ABSTRACT_RULE__TYPE);
    createEReference(abstractRuleEClass, ABSTRACT_RULE__ALTERNATIVES);

    abstractMetamodelDeclarationEClass = createEClass(ABSTRACT_METAMODEL_DECLARATION);
    createEReference(abstractMetamodelDeclarationEClass, ABSTRACT_METAMODEL_DECLARATION__EPACKAGE);
    createEAttribute(abstractMetamodelDeclarationEClass, ABSTRACT_METAMODEL_DECLARATION__ALIAS);

    generatedMetamodelEClass = createEClass(GENERATED_METAMODEL);
    createEAttribute(generatedMetamodelEClass, GENERATED_METAMODEL__NAME);

    referencedMetamodelEClass = createEClass(REFERENCED_METAMODEL);

    parserRuleEClass = createEClass(PARSER_RULE);
    createEAttribute(parserRuleEClass, PARSER_RULE__DEFINES_HIDDEN_TOKENS);
    createEReference(parserRuleEClass, PARSER_RULE__HIDDEN_TOKENS);

    typeRefEClass = createEClass(TYPE_REF);
    createEReference(typeRefEClass, TYPE_REF__METAMODEL);
    createEReference(typeRefEClass, TYPE_REF__CLASSIFIER);

    abstractElementEClass = createEClass(ABSTRACT_ELEMENT);
    createEAttribute(abstractElementEClass, ABSTRACT_ELEMENT__CARDINALITY);

    actionEClass = createEClass(ACTION);
    createEReference(actionEClass, ACTION__TYPE);
    createEAttribute(actionEClass, ACTION__FEATURE);
    createEAttribute(actionEClass, ACTION__OPERATOR);

    keywordEClass = createEClass(KEYWORD);
    createEAttribute(keywordEClass, KEYWORD__VALUE);

    ruleCallEClass = createEClass(RULE_CALL);
    createEReference(ruleCallEClass, RULE_CALL__RULE);

    assignmentEClass = createEClass(ASSIGNMENT);
    createEAttribute(assignmentEClass, ASSIGNMENT__FEATURE);
    createEAttribute(assignmentEClass, ASSIGNMENT__OPERATOR);
    createEReference(assignmentEClass, ASSIGNMENT__TERMINAL);

    crossReferenceEClass = createEClass(CROSS_REFERENCE);
    createEReference(crossReferenceEClass, CROSS_REFERENCE__TYPE);
    createEReference(crossReferenceEClass, CROSS_REFERENCE__TERMINAL);

    terminalRuleEClass = createEClass(TERMINAL_RULE);

    abstractNegatedTokenEClass = createEClass(ABSTRACT_NEGATED_TOKEN);
    createEReference(abstractNegatedTokenEClass, ABSTRACT_NEGATED_TOKEN__TERMINAL);

    negatedTokenEClass = createEClass(NEGATED_TOKEN);

    untilTokenEClass = createEClass(UNTIL_TOKEN);

    wildcardEClass = createEClass(WILDCARD);

    enumRuleEClass = createEClass(ENUM_RULE);

    enumLiteralDeclarationEClass = createEClass(ENUM_LITERAL_DECLARATION);
    createEReference(enumLiteralDeclarationEClass, ENUM_LITERAL_DECLARATION__ENUM_LITERAL);
    createEReference(enumLiteralDeclarationEClass, ENUM_LITERAL_DECLARATION__LITERAL);

    alternativesEClass = createEClass(ALTERNATIVES);
    createEReference(alternativesEClass, ALTERNATIVES__GROUPS);

    groupEClass = createEClass(GROUP);
    createEReference(groupEClass, GROUP__TOKENS);

    characterRangeEClass = createEClass(CHARACTER_RANGE);
    createEReference(characterRangeEClass, CHARACTER_RANGE__LEFT);
    createEReference(characterRangeEClass, CHARACTER_RANGE__RIGHT);
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
    generatedMetamodelEClass.getESuperTypes().add(this.getAbstractMetamodelDeclaration());
    referencedMetamodelEClass.getESuperTypes().add(this.getAbstractMetamodelDeclaration());
    parserRuleEClass.getESuperTypes().add(this.getAbstractRule());
    actionEClass.getESuperTypes().add(this.getAbstractElement());
    keywordEClass.getESuperTypes().add(this.getAbstractElement());
    ruleCallEClass.getESuperTypes().add(this.getAbstractElement());
    assignmentEClass.getESuperTypes().add(this.getAbstractElement());
    crossReferenceEClass.getESuperTypes().add(this.getAbstractElement());
    terminalRuleEClass.getESuperTypes().add(this.getAbstractRule());
    abstractNegatedTokenEClass.getESuperTypes().add(this.getAbstractElement());
    negatedTokenEClass.getESuperTypes().add(this.getAbstractNegatedToken());
    untilTokenEClass.getESuperTypes().add(this.getAbstractNegatedToken());
    wildcardEClass.getESuperTypes().add(this.getAbstractElement());
    enumRuleEClass.getESuperTypes().add(this.getAbstractRule());
    enumLiteralDeclarationEClass.getESuperTypes().add(this.getAbstractElement());
    alternativesEClass.getESuperTypes().add(this.getAbstractElement());
    groupEClass.getESuperTypes().add(this.getAbstractElement());
    characterRangeEClass.getESuperTypes().add(this.getAbstractElement());

    // Initialize classes and features; add operations and parameters
    initEClass(grammarEClass, Grammar.class, "Grammar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGrammar_Name(), ecorePackage.getEString(), "name", null, 0, 1, Grammar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGrammar_UsedGrammars(), this.getGrammar(), null, "usedGrammars", null, 0, -1, Grammar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGrammar_DefinesHiddenTokens(), ecorePackage.getEBoolean(), "definesHiddenTokens", null, 0, 1, Grammar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGrammar_HiddenTokens(), this.getAbstractRule(), null, "hiddenTokens", null, 0, -1, Grammar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGrammar_MetamodelDeclarations(), this.getAbstractMetamodelDeclaration(), null, "metamodelDeclarations", null, 0, -1, Grammar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGrammar_Rules(), this.getAbstractRule(), null, "rules", null, 0, -1, Grammar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractRuleEClass, AbstractRule.class, "AbstractRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractRule_Name(), ecorePackage.getEString(), "name", null, 0, 1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractRule_Type(), this.getTypeRef(), null, "type", null, 0, 1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractRule_Alternatives(), this.getAbstractElement(), null, "alternatives", null, 0, 1, AbstractRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractMetamodelDeclarationEClass, AbstractMetamodelDeclaration.class, "AbstractMetamodelDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractMetamodelDeclaration_EPackage(), ecorePackage.getEPackage(), null, "ePackage", null, 0, 1, AbstractMetamodelDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractMetamodelDeclaration_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, AbstractMetamodelDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(generatedMetamodelEClass, GeneratedMetamodel.class, "GeneratedMetamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGeneratedMetamodel_Name(), ecorePackage.getEString(), "name", null, 0, 1, GeneratedMetamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(referencedMetamodelEClass, ReferencedMetamodel.class, "ReferencedMetamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(parserRuleEClass, ParserRule.class, "ParserRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParserRule_DefinesHiddenTokens(), ecorePackage.getEBoolean(), "definesHiddenTokens", null, 0, 1, ParserRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParserRule_HiddenTokens(), this.getAbstractRule(), null, "hiddenTokens", null, 0, -1, ParserRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeRefEClass, TypeRef.class, "TypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeRef_Metamodel(), this.getAbstractMetamodelDeclaration(), null, "metamodel", null, 0, 1, TypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeRef_Classifier(), ecorePackage.getEClassifier(), null, "classifier", null, 0, 1, TypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractElementEClass, AbstractElement.class, "AbstractElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractElement_Cardinality(), ecorePackage.getEString(), "cardinality", null, 0, 1, AbstractElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAction_Type(), this.getTypeRef(), null, "type", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAction_Feature(), ecorePackage.getEString(), "feature", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAction_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keywordEClass, Keyword.class, "Keyword", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKeyword_Value(), ecorePackage.getEString(), "value", null, 0, 1, Keyword.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleCallEClass, RuleCall.class, "RuleCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleCall_Rule(), this.getAbstractRule(), null, "rule", null, 0, 1, RuleCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssignment_Feature(), ecorePackage.getEString(), "feature", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignment_Operator(), ecorePackage.getEString(), "operator", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignment_Terminal(), this.getAbstractElement(), null, "terminal", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(crossReferenceEClass, CrossReference.class, "CrossReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCrossReference_Type(), this.getTypeRef(), null, "type", null, 0, 1, CrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCrossReference_Terminal(), this.getAbstractElement(), null, "terminal", null, 0, 1, CrossReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(terminalRuleEClass, TerminalRule.class, "TerminalRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractNegatedTokenEClass, AbstractNegatedToken.class, "AbstractNegatedToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractNegatedToken_Terminal(), this.getAbstractElement(), null, "terminal", null, 0, 1, AbstractNegatedToken.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(negatedTokenEClass, NegatedToken.class, "NegatedToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(untilTokenEClass, UntilToken.class, "UntilToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(wildcardEClass, Wildcard.class, "Wildcard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumRuleEClass, EnumRule.class, "EnumRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumLiteralDeclarationEClass, EnumLiteralDeclaration.class, "EnumLiteralDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumLiteralDeclaration_EnumLiteral(), ecorePackage.getEEnumLiteral(), null, "enumLiteral", null, 0, 1, EnumLiteralDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumLiteralDeclaration_Literal(), this.getKeyword(), null, "literal", null, 0, 1, EnumLiteralDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(alternativesEClass, Alternatives.class, "Alternatives", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAlternatives_Groups(), this.getAbstractElement(), null, "groups", null, 0, -1, Alternatives.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGroup_Tokens(), this.getAbstractElement(), null, "tokens", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(characterRangeEClass, CharacterRange.class, "CharacterRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCharacterRange_Left(), this.getKeyword(), null, "left", null, 0, 1, CharacterRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCharacterRange_Right(), this.getKeyword(), null, "right", null, 0, 1, CharacterRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //XtextUiTestPackageImpl
