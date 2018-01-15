/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmInnerTypeReference;
import org.eclipse.xtext.common.types.JvmLowerBound;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XCastedExpression;
import org.eclipse.xtext.xbase.XCatchClause;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XDoWhileExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XForLoopExpression;
import org.eclipse.xtext.xbase.XIfExpression;
import org.eclipse.xtext.xbase.XInstanceOfExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XReturnExpression;
import org.eclipse.xtext.xbase.XSetLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.XSynchronizedExpression;
import org.eclipse.xtext.xbase.XThrowExpression;
import org.eclipse.xtext.xbase.XTryCatchFinallyExpression;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.services.XbaseWithAnnotationsGrammarAccess;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.serializer.XbaseSemanticSequencer;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public abstract class AbstractXbaseWithAnnotationsSemanticSequencer extends XbaseSemanticSequencer {

	@Inject
	private XbaseWithAnnotationsGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TypesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_FORMAL_PARAMETER:
				if (rule == grammarAccess.getFullJvmFormalParameterRule()) {
					sequence_FullJvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter(context, (JvmFormalParameter) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
				sequence_JvmParameterizedTypeReference(context, (JvmInnerTypeReference) semanticObject); 
				return; 
			case TypesPackage.JVM_LOWER_BOUND:
				if (rule == grammarAccess.getJvmLowerBoundAndedRule()) {
					sequence_JvmLowerBoundAnded(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmLowerBoundRule()) {
					sequence_JvmLowerBound(context, (JvmLowerBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_PARAMETERIZED_TYPE_REFERENCE:
				if (action == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()) {
					sequence_JvmParameterizedTypeReference_JvmInnerTypeReference_1_4_0_0_0(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmTypeReferenceRule()
						|| action == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getJvmParameterizedTypeReferenceRule()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_TYPE_PARAMETER:
				sequence_JvmTypeParameter(context, (JvmTypeParameter) semanticObject); 
				return; 
			case TypesPackage.JVM_UPPER_BOUND:
				if (rule == grammarAccess.getJvmUpperBoundAndedRule()) {
					sequence_JvmUpperBoundAnded(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmUpperBoundRule()) {
					sequence_JvmUpperBound(context, (JvmUpperBound) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_WILDCARD_TYPE_REFERENCE:
				sequence_JvmWildcardTypeReference(context, (JvmWildcardTypeReference) semanticObject); 
				return; 
			}
		else if (epackage == XAnnotationsPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XAnnotationsPackage.XANNOTATION:
				sequence_XAnnotation(context, (XAnnotation) semanticObject); 
				return; 
			case XAnnotationsPackage.XANNOTATION_ELEMENT_VALUE_PAIR:
				sequence_XAnnotationElementValuePair(context, (XAnnotationElementValuePair) semanticObject); 
				return; 
			}
		else if (epackage == XbasePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XbasePackage.XASSIGNMENT:
				sequence_XAssignment_XMemberFeatureCall(context, (XAssignment) semanticObject); 
				return; 
			case XbasePackage.XBASIC_FOR_LOOP_EXPRESSION:
				sequence_XBasicForLoopExpression(context, (XBasicForLoopExpression) semanticObject); 
				return; 
			case XbasePackage.XBINARY_OPERATION:
				sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(context, (XBinaryOperation) semanticObject); 
				return; 
			case XbasePackage.XBLOCK_EXPRESSION:
				if (rule == grammarAccess.getXAnnotationElementValueOrCommaListRule()
						|| action == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0()
						|| rule == grammarAccess.getXAnnotationElementValueRule()
						|| rule == grammarAccess.getXAnnotationOrExpressionRule()
						|| rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXBlockExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XBlockExpression(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXExpressionInClosureRule()) {
					sequence_XExpressionInClosure(context, (XBlockExpression) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XBOOLEAN_LITERAL:
				sequence_XBooleanLiteral(context, (XBooleanLiteral) semanticObject); 
				return; 
			case XbasePackage.XCASE_PART:
				sequence_XCasePart(context, (XCasePart) semanticObject); 
				return; 
			case XbasePackage.XCASTED_EXPRESSION:
				sequence_XCastedExpression(context, (XCastedExpression) semanticObject); 
				return; 
			case XbasePackage.XCATCH_CLAUSE:
				sequence_XCatchClause(context, (XCatchClause) semanticObject); 
				return; 
			case XbasePackage.XCLOSURE:
				if (rule == grammarAccess.getXAnnotationElementValueOrCommaListRule()
						|| action == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0()
						|| rule == grammarAccess.getXAnnotationElementValueRule()
						|| rule == grammarAccess.getXAnnotationOrExpressionRule()
						|| rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXLiteralRule()
						|| rule == grammarAccess.getXClosureRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXShortClosureRule()) {
					sequence_XShortClosure(context, (XClosure) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XCONSTRUCTOR_CALL:
				sequence_XConstructorCall(context, (XConstructorCall) semanticObject); 
				return; 
			case XbasePackage.XDO_WHILE_EXPRESSION:
				sequence_XDoWhileExpression(context, (XDoWhileExpression) semanticObject); 
				return; 
			case XbasePackage.XFEATURE_CALL:
				sequence_XFeatureCall(context, (XFeatureCall) semanticObject); 
				return; 
			case XbasePackage.XFOR_LOOP_EXPRESSION:
				sequence_XForLoopExpression(context, (XForLoopExpression) semanticObject); 
				return; 
			case XbasePackage.XIF_EXPRESSION:
				sequence_XIfExpression(context, (XIfExpression) semanticObject); 
				return; 
			case XbasePackage.XINSTANCE_OF_EXPRESSION:
				sequence_XRelationalExpression(context, (XInstanceOfExpression) semanticObject); 
				return; 
			case XbasePackage.XLIST_LITERAL:
				if (rule == grammarAccess.getXAnnotationElementValueOrCommaListRule()) {
					sequence_XAnnotationElementValueOrCommaList_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXAnnotationElementValueRule()) {
					sequence_XAnnotationElementValue_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0()
						|| rule == grammarAccess.getXAnnotationOrExpressionRule()
						|| rule == grammarAccess.getXExpressionRule()
						|| rule == grammarAccess.getXAssignmentRule()
						|| action == grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOrExpressionRule()
						|| action == grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAndExpressionRule()
						|| action == grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXEqualityExpressionRule()
						|| action == grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXRelationalExpressionRule()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0()
						|| action == grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0()
						|| rule == grammarAccess.getXOtherOperatorExpressionRule()
						|| action == grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXAdditiveExpressionRule()
						|| action == grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXMultiplicativeExpressionRule()
						|| action == grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0()
						|| rule == grammarAccess.getXUnaryOperationRule()
						|| rule == grammarAccess.getXCastedExpressionRule()
						|| action == grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0()
						|| rule == grammarAccess.getXPostfixOperationRule()
						|| action == grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0()
						|| rule == grammarAccess.getXMemberFeatureCallRule()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0()
						|| action == grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0()
						|| rule == grammarAccess.getXPrimaryExpressionRule()
						|| rule == grammarAccess.getXLiteralRule()
						|| rule == grammarAccess.getXCollectionLiteralRule()
						|| rule == grammarAccess.getXListLiteralRule()
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_XListLiteral(context, (XListLiteral) semanticObject); 
					return; 
				}
				else break;
			case XbasePackage.XMEMBER_FEATURE_CALL:
				sequence_XMemberFeatureCall(context, (XMemberFeatureCall) semanticObject); 
				return; 
			case XbasePackage.XNULL_LITERAL:
				sequence_XNullLiteral(context, (XNullLiteral) semanticObject); 
				return; 
			case XbasePackage.XNUMBER_LITERAL:
				sequence_XNumberLiteral(context, (XNumberLiteral) semanticObject); 
				return; 
			case XbasePackage.XPOSTFIX_OPERATION:
				sequence_XPostfixOperation(context, (XPostfixOperation) semanticObject); 
				return; 
			case XbasePackage.XRETURN_EXPRESSION:
				sequence_XReturnExpression(context, (XReturnExpression) semanticObject); 
				return; 
			case XbasePackage.XSET_LITERAL:
				sequence_XSetLiteral(context, (XSetLiteral) semanticObject); 
				return; 
			case XbasePackage.XSTRING_LITERAL:
				sequence_XStringLiteral(context, (XStringLiteral) semanticObject); 
				return; 
			case XbasePackage.XSWITCH_EXPRESSION:
				sequence_XSwitchExpression(context, (XSwitchExpression) semanticObject); 
				return; 
			case XbasePackage.XSYNCHRONIZED_EXPRESSION:
				sequence_XSynchronizedExpression(context, (XSynchronizedExpression) semanticObject); 
				return; 
			case XbasePackage.XTHROW_EXPRESSION:
				sequence_XThrowExpression(context, (XThrowExpression) semanticObject); 
				return; 
			case XbasePackage.XTRY_CATCH_FINALLY_EXPRESSION:
				sequence_XTryCatchFinallyExpression(context, (XTryCatchFinallyExpression) semanticObject); 
				return; 
			case XbasePackage.XTYPE_LITERAL:
				sequence_XTypeLiteral(context, (XTypeLiteral) semanticObject); 
				return; 
			case XbasePackage.XUNARY_OPERATION:
				sequence_XUnaryOperation(context, (XUnaryOperation) semanticObject); 
				return; 
			case XbasePackage.XVARIABLE_DECLARATION:
				sequence_XVariableDeclaration(context, (XVariableDeclaration) semanticObject); 
				return; 
			case XbasePackage.XWHILE_EXPRESSION:
				sequence_XWhileExpression(context, (XWhileExpression) semanticObject); 
				return; 
			}
		else if (epackage == XtypePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_DECLARATION:
				sequence_XImportDeclaration(context, (XImportDeclaration) semanticObject); 
				return; 
			case XtypePackage.XIMPORT_SECTION:
				sequence_XImportSection(context, (XImportSection) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     XAnnotationElementValueOrCommaList returns XListLiteral
	 *
	 * Constraint:
	 *     (
	 *         (elements+=XAnnotationOrExpression elements+=XAnnotationOrExpression*) | 
	 *         (elements+=XAnnotationElementValueOrCommaList_XListLiteral_1_1_0 elements+=XAnnotationOrExpression+) | 
	 *         (elements+=XExpression elements+=XExpression*)
	 *     )?
	 */
	protected void sequence_XAnnotationElementValueOrCommaList_XListLiteral(ISerializationContext context, XListLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XAnnotationElementValueOrCommaList_XListLiteral(EObject context, XListLiteral semanticObject) {
		sequence_XAnnotationElementValueOrCommaList_XListLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XAnnotationElementValuePair returns XAnnotationElementValuePair
	 *
	 * Constraint:
	 *     (element=[JvmOperation|ValidID] value=XAnnotationElementValue)
	 */
	protected void sequence_XAnnotationElementValuePair(ISerializationContext context, XAnnotationElementValuePair semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT));
			if (transientValues.isValueTransient(semanticObject, XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXAnnotationElementValuePairAccess().getElementJvmOperationValidIDParserRuleCall_0_0_0_0_1(), semanticObject.eGet(XAnnotationsPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT, false));
		feeder.accept(grammarAccess.getXAnnotationElementValuePairAccess().getValueXAnnotationElementValueParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XAnnotationElementValuePair(EObject context, XAnnotationElementValuePair semanticObject) {
		sequence_XAnnotationElementValuePair(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XAnnotationElementValue returns XListLiteral
	 *
	 * Constraint:
	 *     ((elements+=XAnnotationOrExpression elements+=XAnnotationOrExpression*) | (elements+=XExpression elements+=XExpression*))?
	 */
	protected void sequence_XAnnotationElementValue_XListLiteral(ISerializationContext context, XListLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XAnnotationElementValue_XListLiteral(EObject context, XListLiteral semanticObject) {
		sequence_XAnnotationElementValue_XListLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XAnnotation returns XAnnotation
	 *     XAnnotationElementValueOrCommaList returns XAnnotation
	 *     XAnnotationElementValueOrCommaList.XListLiteral_1_1_0 returns XAnnotation
	 *     XAnnotationElementValue returns XAnnotation
	 *     XAnnotationOrExpression returns XAnnotation
	 *
	 * Constraint:
	 *     (
	 *         annotationType=[JvmAnnotationType|QualifiedName] 
	 *         ((elementValuePairs+=XAnnotationElementValuePair elementValuePairs+=XAnnotationElementValuePair*) | value=XAnnotationElementValueOrCommaList)?
	 *     )
	 */
	protected void sequence_XAnnotation(ISerializationContext context, XAnnotation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XAnnotation(EObject context, XAnnotation semanticObject) {
		sequence_XAnnotation(createContext(context, semanticObject), semanticObject);
	}
	
}
