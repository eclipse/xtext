/**
 */
package org.eclipse.xtext.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.xtext.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.xtext.XtextPackage
 * @generated
 */
public class XtextSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XtextPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XtextSwitch() {
		if (modelPackage == null) {
			modelPackage = XtextPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * @since 2.4
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case XtextPackage.GRAMMAR: {
				Grammar grammar = (Grammar)theEObject;
				T result = caseGrammar(grammar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ABSTRACT_RULE: {
				AbstractRule abstractRule = (AbstractRule)theEObject;
				T result = caseAbstractRule(abstractRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ABSTRACT_METAMODEL_DECLARATION: {
				AbstractMetamodelDeclaration abstractMetamodelDeclaration = (AbstractMetamodelDeclaration)theEObject;
				T result = caseAbstractMetamodelDeclaration(abstractMetamodelDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.GENERATED_METAMODEL: {
				GeneratedMetamodel generatedMetamodel = (GeneratedMetamodel)theEObject;
				T result = caseGeneratedMetamodel(generatedMetamodel);
				if (result == null) result = caseAbstractMetamodelDeclaration(generatedMetamodel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.REFERENCED_METAMODEL: {
				ReferencedMetamodel referencedMetamodel = (ReferencedMetamodel)theEObject;
				T result = caseReferencedMetamodel(referencedMetamodel);
				if (result == null) result = caseAbstractMetamodelDeclaration(referencedMetamodel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.PARSER_RULE: {
				ParserRule parserRule = (ParserRule)theEObject;
				T result = caseParserRule(parserRule);
				if (result == null) result = caseAbstractRule(parserRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.TYPE_REF: {
				TypeRef typeRef = (TypeRef)theEObject;
				T result = caseTypeRef(typeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ABSTRACT_ELEMENT: {
				AbstractElement abstractElement = (AbstractElement)theEObject;
				T result = caseAbstractElement(abstractElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseAbstractElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.KEYWORD: {
				Keyword keyword = (Keyword)theEObject;
				T result = caseKeyword(keyword);
				if (result == null) result = caseAbstractElement(keyword);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.RULE_CALL: {
				RuleCall ruleCall = (RuleCall)theEObject;
				T result = caseRuleCall(ruleCall);
				if (result == null) result = caseAbstractElement(ruleCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = caseAbstractElement(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.CROSS_REFERENCE: {
				CrossReference crossReference = (CrossReference)theEObject;
				T result = caseCrossReference(crossReference);
				if (result == null) result = caseAbstractElement(crossReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.TERMINAL_RULE: {
				TerminalRule terminalRule = (TerminalRule)theEObject;
				T result = caseTerminalRule(terminalRule);
				if (result == null) result = caseAbstractRule(terminalRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ABSTRACT_NEGATED_TOKEN: {
				AbstractNegatedToken abstractNegatedToken = (AbstractNegatedToken)theEObject;
				T result = caseAbstractNegatedToken(abstractNegatedToken);
				if (result == null) result = caseAbstractElement(abstractNegatedToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.NEGATED_TOKEN: {
				NegatedToken negatedToken = (NegatedToken)theEObject;
				T result = caseNegatedToken(negatedToken);
				if (result == null) result = caseAbstractNegatedToken(negatedToken);
				if (result == null) result = caseAbstractElement(negatedToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.UNTIL_TOKEN: {
				UntilToken untilToken = (UntilToken)theEObject;
				T result = caseUntilToken(untilToken);
				if (result == null) result = caseAbstractNegatedToken(untilToken);
				if (result == null) result = caseAbstractElement(untilToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.WILDCARD: {
				Wildcard wildcard = (Wildcard)theEObject;
				T result = caseWildcard(wildcard);
				if (result == null) result = caseAbstractElement(wildcard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ENUM_RULE: {
				EnumRule enumRule = (EnumRule)theEObject;
				T result = caseEnumRule(enumRule);
				if (result == null) result = caseAbstractRule(enumRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ENUM_LITERAL_DECLARATION: {
				EnumLiteralDeclaration enumLiteralDeclaration = (EnumLiteralDeclaration)theEObject;
				T result = caseEnumLiteralDeclaration(enumLiteralDeclaration);
				if (result == null) result = caseAbstractElement(enumLiteralDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ALTERNATIVES: {
				Alternatives alternatives = (Alternatives)theEObject;
				T result = caseAlternatives(alternatives);
				if (result == null) result = caseCompoundElement(alternatives);
				if (result == null) result = caseAbstractElement(alternatives);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.UNORDERED_GROUP: {
				UnorderedGroup unorderedGroup = (UnorderedGroup)theEObject;
				T result = caseUnorderedGroup(unorderedGroup);
				if (result == null) result = caseCompoundElement(unorderedGroup);
				if (result == null) result = caseAbstractElement(unorderedGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.GROUP: {
				Group group = (Group)theEObject;
				T result = caseGroup(group);
				if (result == null) result = caseCompoundElement(group);
				if (result == null) result = caseAbstractElement(group);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.CHARACTER_RANGE: {
				CharacterRange characterRange = (CharacterRange)theEObject;
				T result = caseCharacterRange(characterRange);
				if (result == null) result = caseAbstractElement(characterRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.COMPOUND_ELEMENT: {
				CompoundElement compoundElement = (CompoundElement)theEObject;
				T result = caseCompoundElement(compoundElement);
				if (result == null) result = caseAbstractElement(compoundElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.EOF: {
				EOF eof = (EOF)theEObject;
				T result = caseEOF(eof);
				if (result == null) result = caseAbstractElement(eof);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.NAMED_ARGUMENT: {
				NamedArgument namedArgument = (NamedArgument)theEObject;
				T result = caseNamedArgument(namedArgument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.CONJUNCTION: {
				Conjunction conjunction = (Conjunction)theEObject;
				T result = caseConjunction(conjunction);
				if (result == null) result = caseCompositeCondition(conjunction);
				if (result == null) result = caseCondition(conjunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.NEGATION: {
				Negation negation = (Negation)theEObject;
				T result = caseNegation(negation);
				if (result == null) result = caseCondition(negation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.DISJUNCTION: {
				Disjunction disjunction = (Disjunction)theEObject;
				T result = caseDisjunction(disjunction);
				if (result == null) result = caseCompositeCondition(disjunction);
				if (result == null) result = caseCondition(disjunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.COMPOSITE_CONDITION: {
				CompositeCondition compositeCondition = (CompositeCondition)theEObject;
				T result = caseCompositeCondition(compositeCondition);
				if (result == null) result = caseCondition(compositeCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.PARAMETER_REFERENCE: {
				ParameterReference parameterReference = (ParameterReference)theEObject;
				T result = caseParameterReference(parameterReference);
				if (result == null) result = caseCondition(parameterReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.LITERAL_CONDITION: {
				LiteralCondition literalCondition = (LiteralCondition)theEObject;
				T result = caseLiteralCondition(literalCondition);
				if (result == null) result = caseCondition(literalCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XtextPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Grammar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Grammar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGrammar(Grammar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractRule(AbstractRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Metamodel Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Metamodel Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractMetamodelDeclaration(AbstractMetamodelDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generated Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generated Metamodel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneratedMetamodel(GeneratedMetamodel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referenced Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referenced Metamodel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferencedMetamodel(ReferencedMetamodel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parser Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parser Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParserRule(ParserRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeRef(TypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractElement(AbstractElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Keyword</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Keyword</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyword(Keyword object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleCall(RuleCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cross Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cross Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCrossReference(CrossReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Terminal Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Terminal Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTerminalRule(TerminalRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Negated Token</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Negated Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractNegatedToken(AbstractNegatedToken object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Negated Token</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Negated Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNegatedToken(NegatedToken object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Until Token</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Until Token</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUntilToken(UntilToken object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Wildcard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wildcard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWildcard(Wildcard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumRule(EnumRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alternatives</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alternatives</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlternatives(Alternatives object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unordered Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unordered Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnorderedGroup(UnorderedGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGroup(Group object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Character Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Character Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCharacterRange(CharacterRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundElement(CompoundElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EOF</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EOF</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEOF(EOF object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedArgument(NamedArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conjunction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conjunction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConjunction(Conjunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Negation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Negation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNegation(Negation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disjunction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disjunction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisjunction(Disjunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeCondition(CompositeCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterReference(ParameterReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * @since 2.9
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralCondition(LiteralCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //XtextSwitch
