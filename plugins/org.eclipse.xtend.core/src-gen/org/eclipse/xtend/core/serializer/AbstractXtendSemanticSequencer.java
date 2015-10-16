/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.xtend.AnonymousClass;
import org.eclipse.xtend.core.xtend.CreateExtensionInfo;
import org.eclipse.xtend.core.xtend.RichString;
import org.eclipse.xtend.core.xtend.RichStringElseIf;
import org.eclipse.xtend.core.xtend.RichStringForLoop;
import org.eclipse.xtend.core.xtend.RichStringIf;
import org.eclipse.xtend.core.xtend.RichStringLiteral;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendEnumLiteral;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFormalParameter;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.core.xtend.XtendVariableDeclaration;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
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
import org.eclipse.xtext.xbase.XWhileExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.serializer.XbaseWithAnnotationsSemanticSequencer;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public abstract class AbstractXtendSemanticSequencer extends XbaseWithAnnotationsSemanticSequencer {

	@Inject
	private XtendGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == TypesPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case TypesPackage.JVM_GENERIC_ARRAY_TYPE_REFERENCE:
				if (rule == grammarAccess.getJvmTypeReferenceRule()
						|| action == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmTypeReference(context, (JvmGenericArrayTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeReferenceWithTypeArgsRule()) {
					sequence_TypeReferenceWithTypeArgs(context, (JvmGenericArrayTypeReference) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()) {
					sequence_TypeReferenceWithTypeArgs_JvmGenericArrayTypeReference_0_1_0_0(context, (JvmGenericArrayTypeReference) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0()) {
					sequence_TypeReferenceWithTypeArgs_JvmGenericArrayTypeReference_1_1_0_0(context, (JvmGenericArrayTypeReference) semanticObject); 
					return; 
				}
				else break;
			case TypesPackage.JVM_INNER_TYPE_REFERENCE:
				if (rule == grammarAccess.getJvmSuperTypeReferenceRule()
						|| rule == grammarAccess.getJvmTypeReferenceRule()
						|| action == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getJvmParameterizedTypeReferenceRule()
						|| action == grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference(context, (JvmInnerTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeReferenceWithTypeArgsRule()
						|| action == grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule()
						|| action == grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()) {
					sequence_ParameterizedTypeReferenceWithTypeArgs(context, (JvmInnerTypeReference) semanticObject); 
					return; 
				}
				else break;
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
				else if (rule == grammarAccess.getJvmSuperTypeReferenceRule()
						|| rule == grammarAccess.getJvmTypeReferenceRule()
						|| action == grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getJvmParameterizedTypeReferenceRule()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_JvmParameterizedTypeReference(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeReferenceWithTypeArgsRule()
						|| action == grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()
						|| rule == grammarAccess.getParameterizedTypeReferenceWithTypeArgsRule()
						|| action == grammarAccess.getParameterizedTypeReferenceWithTypeArgsAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0()) {
					sequence_ParameterizedTypeReferenceWithTypeArgs(context, (JvmParameterizedTypeReference) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeReferenceNoTypeArgsRule()
						|| action == grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0()) {
					sequence_TypeReferenceNoTypeArgs(context, (JvmParameterizedTypeReference) semanticObject); 
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
				if (rule == grammarAccess.getXExpressionOrSimpleConstructorCallRule()
						|| rule == grammarAccess.getRichStringPartRule()
						|| rule == grammarAccess.getXAnnotationElementValueOrCommaListRule()
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
				if (rule == grammarAccess.getXExpressionOrSimpleConstructorCallRule()
						|| rule == grammarAccess.getRichStringPartRule()
						|| rule == grammarAccess.getXAnnotationElementValueOrCommaListRule()
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
				sequence_XbaseConstructorCall(context, (XConstructorCall) semanticObject); 
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
				else if (rule == grammarAccess.getXExpressionOrSimpleConstructorCallRule()
						|| rule == grammarAccess.getRichStringPartRule()
						|| action == grammarAccess.getXAnnotationElementValueOrCommaListAccess().getXListLiteralElementsAction_1_1_0()
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
				sequence_SimpleStringLiteral(context, (XStringLiteral) semanticObject); 
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
			case XbasePackage.XWHILE_EXPRESSION:
				sequence_XWhileExpression(context, (XWhileExpression) semanticObject); 
				return; 
			}
		else if (epackage == XtendPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XtendPackage.ANONYMOUS_CLASS:
				sequence_XConstructorCall(context, (AnonymousClass) semanticObject); 
				return; 
			case XtendPackage.CREATE_EXTENSION_INFO:
				sequence_CreateExtensionInfo(context, (CreateExtensionInfo) semanticObject); 
				return; 
			case XtendPackage.RICH_STRING:
				if (rule == grammarAccess.getInternalRichStringRule()) {
					sequence_InternalRichString(context, (RichString) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getXStringLiteralRule()
						|| rule == grammarAccess.getXExpressionOrSimpleConstructorCallRule()
						|| rule == grammarAccess.getRichStringRule()
						|| rule == grammarAccess.getRichStringPartRule()
						|| rule == grammarAccess.getXAnnotationElementValueOrCommaListRule()
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
						|| rule == grammarAccess.getXParenthesizedExpressionRule()
						|| rule == grammarAccess.getXExpressionOrVarDeclarationRule()) {
					sequence_RichString(context, (RichString) semanticObject); 
					return; 
				}
				else break;
			case XtendPackage.RICH_STRING_ELSE_IF:
				sequence_RichStringElseIf(context, (RichStringElseIf) semanticObject); 
				return; 
			case XtendPackage.RICH_STRING_FOR_LOOP:
				sequence_RichStringForLoop(context, (RichStringForLoop) semanticObject); 
				return; 
			case XtendPackage.RICH_STRING_IF:
				sequence_RichStringIf(context, (RichStringIf) semanticObject); 
				return; 
			case XtendPackage.RICH_STRING_LITERAL:
				if (rule == grammarAccess.getRichStringLiteralEndRule()) {
					sequence_RichStringLiteralEnd(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRichStringLiteralInbetweenRule()) {
					sequence_RichStringLiteralInbetween(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRichStringLiteralStartRule()) {
					sequence_RichStringLiteralStart(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRichStringLiteralRule()) {
					sequence_RichStringLiteral(context, (RichStringLiteral) semanticObject); 
					return; 
				}
				else break;
			case XtendPackage.XTEND_ANNOTATION_TYPE:
				if (rule == grammarAccess.getAnnotationFieldRule()) {
					sequence_AnnotationField(context, (XtendAnnotationType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMemberRule()) {
					sequence_Member(context, (XtendAnnotationType) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeRule()) {
					sequence_Type(context, (XtendAnnotationType) semanticObject); 
					return; 
				}
				else break;
			case XtendPackage.XTEND_CLASS:
				if (rule == grammarAccess.getAnnotationFieldRule()) {
					sequence_AnnotationField(context, (XtendClass) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMemberRule()) {
					sequence_Member(context, (XtendClass) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeRule()) {
					sequence_Type(context, (XtendClass) semanticObject); 
					return; 
				}
				else break;
			case XtendPackage.XTEND_CONSTRUCTOR:
				sequence_Member(context, (XtendConstructor) semanticObject); 
				return; 
			case XtendPackage.XTEND_ENUM:
				if (rule == grammarAccess.getAnnotationFieldRule()) {
					sequence_AnnotationField(context, (XtendEnum) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMemberRule()) {
					sequence_Member(context, (XtendEnum) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeRule()) {
					sequence_Type(context, (XtendEnum) semanticObject); 
					return; 
				}
				else break;
			case XtendPackage.XTEND_ENUM_LITERAL:
				sequence_XtendEnumLiteral(context, (XtendEnumLiteral) semanticObject); 
				return; 
			case XtendPackage.XTEND_FIELD:
				if (rule == grammarAccess.getAnnotationFieldRule()) {
					sequence_AnnotationField(context, (XtendField) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMemberRule()) {
					sequence_Member(context, (XtendField) semanticObject); 
					return; 
				}
				else break;
			case XtendPackage.XTEND_FILE:
				sequence_File(context, (XtendFile) semanticObject); 
				return; 
			case XtendPackage.XTEND_FORMAL_PARAMETER:
				if (rule == grammarAccess.getFullJvmFormalParameterRule()) {
					sequence_FullJvmFormalParameter(context, (XtendFormalParameter) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getJvmFormalParameterRule()) {
					sequence_JvmFormalParameter(context, (XtendFormalParameter) semanticObject); 
					return; 
				}
				else break;
			case XtendPackage.XTEND_FUNCTION:
				sequence_Member(context, (XtendFunction) semanticObject); 
				return; 
			case XtendPackage.XTEND_INTERFACE:
				if (rule == grammarAccess.getAnnotationFieldRule()) {
					sequence_AnnotationField(context, (XtendInterface) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMemberRule()) {
					sequence_Member(context, (XtendInterface) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeRule()) {
					sequence_Type(context, (XtendInterface) semanticObject); 
					return; 
				}
				else break;
			case XtendPackage.XTEND_MEMBER:
				if (action == grammarAccess.getAnnotationFieldAccess().getXtendFieldAnnotationInfoAction_2_0_0_0_0()
						|| action == grammarAccess.getAnnotationFieldAccess().getXtendFieldAnnotationInfoAction_2_0_0_1_0()
						|| action == grammarAccess.getAnnotationFieldAccess().getXtendClassAnnotationInfoAction_2_1_0()
						|| action == grammarAccess.getAnnotationFieldAccess().getXtendInterfaceAnnotationInfoAction_2_2_0()
						|| action == grammarAccess.getAnnotationFieldAccess().getXtendEnumAnnotationInfoAction_2_3_0()
						|| action == grammarAccess.getAnnotationFieldAccess().getXtendAnnotationTypeAnnotationInfoAction_2_4_0()) {
					sequence_AnnotationField_XtendAnnotationType_2_4_0_XtendClass_2_1_0_XtendEnum_2_3_0_XtendField_2_0_0_0_0_XtendField_2_0_0_1_0_XtendInterface_2_2_0(context, (XtendMember) semanticObject); 
					return; 
				}
				else if (action == grammarAccess.getMemberAccess().getXtendFieldAnnotationInfoAction_2_0_0()
						|| action == grammarAccess.getMemberAccess().getXtendFunctionAnnotationInfoAction_2_1_0()
						|| action == grammarAccess.getMemberAccess().getXtendConstructorAnnotationInfoAction_2_2_0()
						|| action == grammarAccess.getMemberAccess().getXtendClassAnnotationInfoAction_2_3_0()
						|| action == grammarAccess.getMemberAccess().getXtendInterfaceAnnotationInfoAction_2_4_0()
						|| action == grammarAccess.getMemberAccess().getXtendEnumAnnotationInfoAction_2_5_0()
						|| action == grammarAccess.getMemberAccess().getXtendAnnotationTypeAnnotationInfoAction_2_6_0()) {
					sequence_Member_XtendAnnotationType_2_6_0_XtendClass_2_3_0_XtendConstructor_2_2_0_XtendEnum_2_5_0_XtendField_2_0_0_XtendFunction_2_1_0_XtendInterface_2_4_0(context, (XtendMember) semanticObject); 
					return; 
				}
				else break;
			case XtendPackage.XTEND_PARAMETER:
				sequence_Parameter(context, (XtendParameter) semanticObject); 
				return; 
			case XtendPackage.XTEND_TYPE_DECLARATION:
				sequence_Type_XtendAnnotationType_2_3_0_XtendClass_2_0_0_XtendEnum_2_2_0_XtendInterface_2_1_0(context, (XtendTypeDeclaration) semanticObject); 
				return; 
			case XtendPackage.XTEND_VARIABLE_DECLARATION:
				sequence_XVariableDeclaration(context, (XtendVariableDeclaration) semanticObject); 
				return; 
			}
		else if (epackage == XtypePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case XtypePackage.XFUNCTION_TYPE_REF:
				if (rule == grammarAccess.getJvmSuperTypeReferenceRule()
						|| rule == grammarAccess.getXFunctionSuperTypeRefRule()) {
					sequence_XFunctionSuperTypeRef(context, (XFunctionTypeRef) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTypeReferenceWithTypeArgsRule()
						|| rule == grammarAccess.getJvmTypeReferenceRule()
						|| rule == grammarAccess.getXFunctionTypeRefRule()
						|| rule == grammarAccess.getJvmArgumentTypeReferenceRule()) {
					sequence_XFunctionTypeRef(context, (XFunctionTypeRef) semanticObject); 
					return; 
				}
				else break;
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
	 * Constraint:
	 *     (annotationInfo=AnnotationField_XtendAnnotationType_2_4_0 modifiers+=CommonModifier* name=ValidID members+=AnnotationField*)
	 */
	protected void sequence_AnnotationField(ISerializationContext context, XtendAnnotationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     annotations+=XAnnotation*
	 */
	protected void sequence_AnnotationField_XtendAnnotationType_2_4_0_XtendClass_2_1_0_XtendEnum_2_3_0_XtendField_2_0_0_0_0_XtendField_2_0_0_1_0_XtendInterface_2_2_0(ISerializationContext context, XtendMember semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotationInfo=AnnotationField_XtendClass_2_1_0 
	 *         modifiers+=CommonModifier* 
	 *         name=ValidID 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         extends=JvmParameterizedTypeReference? 
	 *         (implements+=JvmParameterizedTypeReference implements+=JvmParameterizedTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_AnnotationField(ISerializationContext context, XtendClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotationInfo=AnnotationField_XtendEnum_2_3_0 modifiers+=CommonModifier* name=ValidID (members+=XtendEnumLiteral members+=XtendEnumLiteral*)?)
	 */
	protected void sequence_AnnotationField(ISerializationContext context, XtendEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (
	 *                 annotationInfo=AnnotationField_XtendField_2_0_0_0_0 
	 *                 modifiers+=CommonModifier* 
	 *                 modifiers+=FieldModifier 
	 *                 modifiers+=CommonModifier* 
	 *                 type=JvmTypeReference? 
	 *                 name=ValidID
	 *             ) | 
	 *             (annotationInfo=AnnotationField_XtendField_2_0_0_1_0 modifiers+=CommonModifier* type=JvmTypeReference name=ValidID)
	 *         ) 
	 *         initialValue=XAnnotationElementValue?
	 *     )
	 */
	protected void sequence_AnnotationField(ISerializationContext context, XtendField semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotationInfo=AnnotationField_XtendInterface_2_2_0 
	 *         modifiers+=CommonModifier* 
	 *         name=ValidID 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         (extends+=JvmParameterizedTypeReference extends+=JvmParameterizedTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_AnnotationField(ISerializationContext context, XtendInterface semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ValidID? createExpression=XExpression)
	 */
	protected void sequence_CreateExtensionInfo(ISerializationContext context, CreateExtensionInfo semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((package=QualifiedName? importSection=XImportSection xtendTypes+=Type+) | (package=QualifiedName? xtendTypes+=Type+) | xtendTypes+=Type+)?
	 */
	protected void sequence_File(ISerializationContext context, XtendFile semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (extension?='extension'? parameterType=JvmTypeReference name=InnerVarID)
	 */
	protected void sequence_FullJvmFormalParameter(ISerializationContext context, XtendFormalParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expressions+=RichStringLiteralInbetween (expressions+=RichStringPart? expressions+=RichStringLiteralInbetween)*)
	 */
	protected void sequence_InternalRichString(ISerializationContext context, RichString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (extension?='extension'? parameterType=JvmTypeReference? name=InnerVarID)
	 */
	protected void sequence_JvmFormalParameter(ISerializationContext context, XtendFormalParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotationInfo=Member_XtendAnnotationType_2_6_0 modifiers+=CommonModifier* name=ValidID members+=AnnotationField*)
	 */
	protected void sequence_Member(ISerializationContext context, XtendAnnotationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     annotations+=XAnnotation*
	 */
	protected void sequence_Member_XtendAnnotationType_2_6_0_XtendClass_2_3_0_XtendConstructor_2_2_0_XtendEnum_2_5_0_XtendField_2_0_0_XtendFunction_2_1_0_XtendInterface_2_4_0(ISerializationContext context, XtendMember semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotationInfo=Member_XtendClass_2_3_0 
	 *         modifiers+=CommonModifier* 
	 *         name=ValidID 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         extends=JvmParameterizedTypeReference? 
	 *         (implements+=JvmParameterizedTypeReference implements+=JvmParameterizedTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_Member(ISerializationContext context, XtendClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotationInfo=Member_XtendConstructor_2_2_0 
	 *         modifiers+=CommonModifier* 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         (parameters+=Parameter parameters+=Parameter*)? 
	 *         (exceptions+=JvmTypeReference exceptions+=JvmTypeReference*)? 
	 *         expression=XBlockExpression
	 *     )
	 */
	protected void sequence_Member(ISerializationContext context, XtendConstructor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotationInfo=Member_XtendEnum_2_5_0 modifiers+=CommonModifier* name=ValidID (members+=XtendEnumLiteral members+=XtendEnumLiteral*)?)
	 */
	protected void sequence_Member(ISerializationContext context, XtendEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotationInfo=Member_XtendField_2_0_0 
	 *         modifiers+=CommonModifier* 
	 *         (
	 *             (modifiers+=FieldModifier modifiers+=CommonModifier* type=JvmTypeReference? name=ValidID) | 
	 *             (modifiers+='extension' (modifiers+=FieldModifier | modifiers+=CommonModifier)* type=JvmTypeReference name=ValidID?) | 
	 *             (
	 *                 modifiers+=FieldModifier 
	 *                 modifiers+=CommonModifier* 
	 *                 modifiers+='extension' 
	 *                 modifiers+=CommonModifier* 
	 *                 type=JvmTypeReference 
	 *                 name=ValidID?
	 *             ) | 
	 *             (type=JvmTypeReference name=ValidID)
	 *         ) 
	 *         initialValue=XExpression?
	 *     )
	 */
	protected void sequence_Member(ISerializationContext context, XtendField semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotationInfo=Member_XtendFunction_2_1_0 
	 *         modifiers+=CommonModifier* 
	 *         modifiers+=MethodModifier 
	 *         (modifiers+=CommonModifier | modifiers+=MethodModifier)* 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         (
	 *             (returnType=JvmTypeReference createExtensionInfo=CreateExtensionInfo name=ValidID) | 
	 *             (returnType=TypeReferenceWithTypeArgs name=FunctionID) | 
	 *             (returnType=TypeReferenceNoTypeArgs name=FunctionID) | 
	 *             (createExtensionInfo=CreateExtensionInfo name=ValidID) | 
	 *             name=FunctionID
	 *         ) 
	 *         (parameters+=Parameter parameters+=Parameter*)? 
	 *         (exceptions+=JvmTypeReference exceptions+=JvmTypeReference*)? 
	 *         (expression=XBlockExpression | expression=RichString)?
	 *     )
	 */
	protected void sequence_Member(ISerializationContext context, XtendFunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotationInfo=Member_XtendInterface_2_4_0 
	 *         modifiers+=CommonModifier* 
	 *         name=ValidID 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         (extends+=JvmParameterizedTypeReference extends+=JvmParameterizedTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_Member(ISerializationContext context, XtendInterface semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotations+=XAnnotation* (extension?='extension' annotations+=XAnnotation*)? parameterType=JvmTypeReference varArg?='...'? name=ValidID)
	 */
	protected void sequence_Parameter(ISerializationContext context, XtendParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         outer=ParameterizedTypeReferenceWithTypeArgs_JvmInnerTypeReference_1_4_0_0_0 
	 *         type=[JvmType|ValidID] 
	 *         (arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)?
	 *     )
	 */
	protected void sequence_ParameterizedTypeReferenceWithTypeArgs(ISerializationContext context, JvmInnerTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] arguments+=JvmArgumentTypeReference arguments+=JvmArgumentTypeReference*)
	 */
	protected void sequence_ParameterizedTypeReferenceWithTypeArgs(ISerializationContext context, JvmParameterizedTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (if=XExpression then=InternalRichString)
	 */
	protected void sequence_RichStringElseIf(ISerializationContext context, RichStringElseIf semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtendPackage.Literals.RICH_STRING_ELSE_IF__IF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtendPackage.Literals.RICH_STRING_ELSE_IF__IF));
			if (transientValues.isValueTransient(semanticObject, XtendPackage.Literals.RICH_STRING_ELSE_IF__THEN) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtendPackage.Literals.RICH_STRING_ELSE_IF__THEN));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRichStringElseIfAccess().getIfXExpressionParserRuleCall_1_0(), semanticObject.getIf());
		feeder.accept(grammarAccess.getRichStringElseIfAccess().getThenInternalRichStringParserRuleCall_2_0(), semanticObject.getThen());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         declaredParam=JvmFormalParameter 
	 *         forExpression=XExpression 
	 *         before=XExpression? 
	 *         separator=XExpression? 
	 *         after=XExpression? 
	 *         eachExpression=InternalRichString
	 *     )
	 */
	protected void sequence_RichStringForLoop(ISerializationContext context, RichStringForLoop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (if=XExpression then=InternalRichString elseIfs+=RichStringElseIf* else=InternalRichString?)
	 */
	protected void sequence_RichStringIf(ISerializationContext context, RichStringIf semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=RICH_TEXT_END | value=COMMENT_RICH_TEXT_END)
	 */
	protected void sequence_RichStringLiteralEnd(ISerializationContext context, RichStringLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=RICH_TEXT_INBETWEEN | value=COMMENT_RICH_TEXT_INBETWEEN)
	 */
	protected void sequence_RichStringLiteralInbetween(ISerializationContext context, RichStringLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=RICH_TEXT_START
	 */
	protected void sequence_RichStringLiteralStart(ISerializationContext context, RichStringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRichStringLiteralStartAccess().getValueRICH_TEXT_STARTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=RICH_TEXT
	 */
	protected void sequence_RichStringLiteral(ISerializationContext context, RichStringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRichStringLiteralAccess().getValueRICH_TEXTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         expressions+=RichStringLiteral | 
	 *         (
	 *             expressions+=RichStringLiteralStart 
	 *             expressions+=RichStringPart? 
	 *             (expressions+=RichStringLiteralInbetween expressions+=RichStringPart?)* 
	 *             expressions+=RichStringLiteralEnd
	 *         )
	 *     )
	 */
	protected void sequence_RichString(ISerializationContext context, RichString semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_SimpleStringLiteral(ISerializationContext context, XStringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSimpleStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     type=[JvmType|QualifiedName]
	 */
	protected void sequence_TypeReferenceNoTypeArgs(ISerializationContext context, JvmParameterizedTypeReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeReferenceNoTypeArgsAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_1(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         componentType=TypeReferenceWithTypeArgs_JvmGenericArrayTypeReference_0_1_0_0 | 
	 *         componentType=TypeReferenceWithTypeArgs_JvmGenericArrayTypeReference_1_1_0_0
	 *     )
	 */
	protected void sequence_TypeReferenceWithTypeArgs(ISerializationContext context, JvmGenericArrayTypeReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     componentType=TypeReferenceWithTypeArgs_JvmGenericArrayTypeReference_0_1_0_0
	 */
	protected void sequence_TypeReferenceWithTypeArgs_JvmGenericArrayTypeReference_0_1_0_0(ISerializationContext context, JvmGenericArrayTypeReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(), semanticObject.getComponentType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     componentType=TypeReferenceWithTypeArgs_JvmGenericArrayTypeReference_1_1_0_0
	 */
	protected void sequence_TypeReferenceWithTypeArgs_JvmGenericArrayTypeReference_1_1_0_0(ISerializationContext context, JvmGenericArrayTypeReference semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_GENERIC_ARRAY_TYPE_REFERENCE__COMPONENT_TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTypeReferenceWithTypeArgsAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_1_0_0(), semanticObject.getComponentType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (annotationInfo=Type_XtendAnnotationType_2_3_0 modifiers+=CommonModifier* name=ValidID members+=AnnotationField*)
	 */
	protected void sequence_Type(ISerializationContext context, XtendAnnotationType semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     annotations+=XAnnotation*
	 */
	protected void sequence_Type_XtendAnnotationType_2_3_0_XtendClass_2_0_0_XtendEnum_2_2_0_XtendInterface_2_1_0(ISerializationContext context, XtendTypeDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotationInfo=Type_XtendClass_2_0_0 
	 *         modifiers+=CommonModifier* 
	 *         name=ValidID 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         extends=JvmParameterizedTypeReference? 
	 *         (implements+=JvmSuperTypeReference implements+=JvmSuperTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_Type(ISerializationContext context, XtendClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (annotationInfo=Type_XtendEnum_2_2_0 modifiers+=CommonModifier* name=ValidID (members+=XtendEnumLiteral members+=XtendEnumLiteral*)?)
	 */
	protected void sequence_Type(ISerializationContext context, XtendEnum semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         annotationInfo=Type_XtendInterface_2_1_0 
	 *         modifiers+=CommonModifier* 
	 *         name=ValidID 
	 *         (typeParameters+=JvmTypeParameter typeParameters+=JvmTypeParameter*)? 
	 *         (extends+=JvmSuperTypeReference extends+=JvmSuperTypeReference*)? 
	 *         members+=Member*
	 *     )
	 */
	protected void sequence_Type(ISerializationContext context, XtendInterface semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (constructorCall=XConstructorCall_AnonymousClass_1_0_0_0 members+=Member*)
	 */
	protected void sequence_XConstructorCall(ISerializationContext context, AnonymousClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((instanceContext?='(' (paramTypes+=JvmTypeReference paramTypes+=JvmTypeReference*)?)? returnType=JvmTypeReference)
	 */
	protected void sequence_XFunctionSuperTypeRef(ISerializationContext context, XFunctionTypeRef semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((declaredParam=JvmFormalParameter switch=XExpression) | (declaredParam=JvmFormalParameter? switch=XExpressionOrSimpleConstructorCall)) 
	 *         cases+=XCasePart* 
	 *         default=XExpression?
	 *     )
	 */
	protected void sequence_XSwitchExpression(ISerializationContext context, XSwitchExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((writeable?='var'? extension?='extension'?) | (extension?='extension' writeable?='var'?)) 
	 *         ((type=JvmTypeReference name=InnerVarID) | name=InnerVarID) 
	 *         right=XExpression?
	 *     )
	 */
	protected void sequence_XVariableDeclaration(ISerializationContext context, XtendVariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         constructor=[JvmConstructor|QualifiedName] 
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)? 
	 *         (explicitConstructorCall?='(' (arguments+=XShortClosure | (arguments+=XExpression arguments+=XExpression*))?)? 
	 *         arguments+=XClosure?
	 *     )
	 */
	protected void sequence_XbaseConstructorCall(ISerializationContext context, XConstructorCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ValidID
	 */
	protected void sequence_XtendEnumLiteral(ISerializationContext context, XtendEnumLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XtendPackage.Literals.XTEND_ENUM_LITERAL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XtendPackage.Literals.XTEND_ENUM_LITERAL__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXtendEnumLiteralAccess().getNameValidIDParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
}
