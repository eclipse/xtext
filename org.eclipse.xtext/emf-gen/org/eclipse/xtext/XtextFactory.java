/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.XtextPackage
 * @generated
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface XtextFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	XtextFactory eINSTANCE = org.eclipse.xtext.impl.XtextFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Grammar</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Grammar</em>'.
	 * @generated
	 */
	Grammar createGrammar();

	/**
	 * Returns a new object of class '<em>Abstract Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Rule</em>'.
	 * @generated
	 */
	AbstractRule createAbstractRule();

	/**
	 * Returns a new object of class '<em>Abstract Metamodel Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Metamodel Declaration</em>'.
	 * @generated
	 */
	AbstractMetamodelDeclaration createAbstractMetamodelDeclaration();

	/**
	 * Returns a new object of class '<em>Generated Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generated Metamodel</em>'.
	 * @generated
	 */
	GeneratedMetamodel createGeneratedMetamodel();

	/**
	 * Returns a new object of class '<em>Referenced Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Referenced Metamodel</em>'.
	 * @generated
	 */
	ReferencedMetamodel createReferencedMetamodel();

	/**
	 * Returns a new object of class '<em>Parser Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parser Rule</em>'.
	 * @generated
	 */
	ParserRule createParserRule();

	/**
	 * Returns a new object of class '<em>Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Ref</em>'.
	 * @generated
	 */
	TypeRef createTypeRef();

	/**
	 * Returns a new object of class '<em>Abstract Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Element</em>'.
	 * @generated
	 */
	AbstractElement createAbstractElement();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

	/**
	 * Returns a new object of class '<em>Keyword</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Keyword</em>'.
	 * @generated
	 */
	Keyword createKeyword();

	/**
	 * Returns a new object of class '<em>Rule Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Call</em>'.
	 * @generated
	 */
	RuleCall createRuleCall();

	/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

	/**
	 * Returns a new object of class '<em>Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cross Reference</em>'.
	 * @generated
	 */
	CrossReference createCrossReference();

	/**
	 * Returns a new object of class '<em>Terminal Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Terminal Rule</em>'.
	 * @generated
	 */
	TerminalRule createTerminalRule();

	/**
	 * Returns a new object of class '<em>Abstract Negated Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Abstract Negated Token</em>'.
	 * @generated
	 */
	AbstractNegatedToken createAbstractNegatedToken();

	/**
	 * Returns a new object of class '<em>Negated Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Negated Token</em>'.
	 * @generated
	 */
	NegatedToken createNegatedToken();

	/**
	 * Returns a new object of class '<em>Until Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Until Token</em>'.
	 * @generated
	 */
	UntilToken createUntilToken();

	/**
	 * Returns a new object of class '<em>Wildcard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wildcard</em>'.
	 * @generated
	 */
	Wildcard createWildcard();

	/**
	 * Returns a new object of class '<em>Enum Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Rule</em>'.
	 * @generated
	 */
	EnumRule createEnumRule();

	/**
	 * Returns a new object of class '<em>Enum Literal Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Declaration</em>'.
	 * @generated
	 */
	EnumLiteralDeclaration createEnumLiteralDeclaration();

	/**
	 * Returns a new object of class '<em>Alternatives</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alternatives</em>'.
	 * @generated
	 */
	Alternatives createAlternatives();

	/**
	 * Returns a new object of class '<em>Unordered Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unordered Group</em>'.
	 * @generated
	 */
	UnorderedGroup createUnorderedGroup();

	/**
	 * Returns a new object of class '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group</em>'.
	 * @generated
	 */
	Group createGroup();

	/**
	 * Returns a new object of class '<em>Character Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Character Range</em>'.
	 * @generated
	 */
	CharacterRange createCharacterRange();

	/**
	 * Returns a new object of class '<em>Compound Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound Element</em>'.
	 * @generated
	 */
	CompoundElement createCompoundElement();

	/**
	 * Returns a new object of class '<em>EOF</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EOF</em>'.
	 * @generated
	 */
	EOF createEOF();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Named Argument</em>'.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Argument</em>'.
	 * @generated
	 */
	NamedArgument createNamedArgument();

	/**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated
	 */
	Condition createCondition();

	/**
	 * Returns a new object of class '<em>Conjunction</em>'.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conjunction</em>'.
	 * @generated
	 */
	Conjunction createConjunction();

	/**
	 * Returns a new object of class '<em>Negation</em>'.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Negation</em>'.
	 * @generated
	 */
	Negation createNegation();

	/**
	 * Returns a new object of class '<em>Disjunction</em>'.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Disjunction</em>'.
	 * @generated
	 */
	Disjunction createDisjunction();

	/**
	 * Returns a new object of class '<em>Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite Condition</em>'.
	 * @generated
	 */
	CompositeCondition createCompositeCondition();

	/**
	 * Returns a new object of class '<em>Parameter Reference</em>'.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Reference</em>'.
	 * @generated
	 */
	ParameterReference createParameterReference();

	/**
	 * Returns a new object of class '<em>Literal Condition</em>'.
	 * <!-- begin-user-doc -->
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Condition</em>'.
	 * @generated
	 */
	LiteralCondition createLiteralCondition();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	XtextPackage getXtextPackage();

} //XtextFactory
