/*******************************************************************************
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.serializer;

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
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xtype.XFunctionTypeRef;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public abstract class AbstractXbaseSemanticSequencer extends XtypeSemanticSequencer {

	@Inject
	private XbaseGrammarAccess grammarAccess;
	
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
				if (rule == grammarAccess.getXExpressionRule()
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
				if (rule == grammarAccess.getXExpressionRule()
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
				sequence_XListLiteral(context, (XListLiteral) semanticObject); 
				return; 
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
	 *     FullJvmFormalParameter returns JvmFormalParameter
	 *
	 * Constraint:
	 *     (parameterType=JvmTypeReference name=ValidID)
	 */
	protected void sequence_FullJvmFormalParameter(ISerializationContext context, JvmFormalParameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_FORMAL_PARAMETER__PARAMETER_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_FORMAL_PARAMETER__PARAMETER_TYPE));
			if (transientValues.isValueTransient(semanticObject, TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TypesPackage.Literals.JVM_FORMAL_PARAMETER__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0(), semanticObject.getParameterType());
		feeder.accept(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_FullJvmFormalParameter(EObject context, JvmFormalParameter semanticObject) {
		sequence_FullJvmFormalParameter(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     JvmFormalParameter returns JvmFormalParameter
	 *
	 * Constraint:
	 *     (parameterType=JvmTypeReference? name=ValidID)
	 */
	protected void sequence_JvmFormalParameter(ISerializationContext context, JvmFormalParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_JvmFormalParameter(EObject context, JvmFormalParameter semanticObject) {
		sequence_JvmFormalParameter(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XBinaryOperation
	 *     XAssignment returns XBinaryOperation
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XBinaryOperation
	 *     XOrExpression returns XBinaryOperation
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XAndExpression returns XBinaryOperation
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XEqualityExpression returns XBinaryOperation
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XRelationalExpression returns XBinaryOperation
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XBinaryOperation
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XBinaryOperation
	 *     XOtherOperatorExpression returns XBinaryOperation
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XAdditiveExpression returns XBinaryOperation
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XMultiplicativeExpression returns XBinaryOperation
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XBinaryOperation
	 *     XUnaryOperation returns XBinaryOperation
	 *     XCastedExpression returns XBinaryOperation
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XBinaryOperation
	 *     XPostfixOperation returns XBinaryOperation
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XBinaryOperation
	 *     XMemberFeatureCall returns XBinaryOperation
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XBinaryOperation
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XBinaryOperation
	 *     XPrimaryExpression returns XBinaryOperation
	 *     XParenthesizedExpression returns XBinaryOperation
	 *     XExpressionOrVarDeclaration returns XBinaryOperation
	 *
	 * Constraint:
	 *     (
	 *         (leftOperand=XAssignment_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpMultiAssign] rightOperand=XAssignment) | 
	 *         (leftOperand=XOrExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpOr] rightOperand=XAndExpression) | 
	 *         (leftOperand=XAndExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAnd] rightOperand=XEqualityExpression) | 
	 *         (leftOperand=XEqualityExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpEquality] rightOperand=XRelationalExpression) | 
	 *         (leftOperand=XRelationalExpression_XBinaryOperation_1_1_0_0_0 feature=[JvmIdentifiableElement|OpCompare] rightOperand=XOtherOperatorExpression) | 
	 *         (leftOperand=XOtherOperatorExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpOther] rightOperand=XAdditiveExpression) | 
	 *         (leftOperand=XAdditiveExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpAdd] rightOperand=XMultiplicativeExpression) | 
	 *         (leftOperand=XMultiplicativeExpression_XBinaryOperation_1_0_0_0 feature=[JvmIdentifiableElement|OpMulti] rightOperand=XUnaryOperation)
	 *     )
	 */
	protected void sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(ISerializationContext context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(EObject context, XBinaryOperation semanticObject) {
		sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XAssignment
	 *     XAssignment returns XAssignment
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XAssignment
	 *     XOrExpression returns XAssignment
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XAndExpression returns XAssignment
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XEqualityExpression returns XAssignment
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XRelationalExpression returns XAssignment
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XAssignment
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XAssignment
	 *     XOtherOperatorExpression returns XAssignment
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XAdditiveExpression returns XAssignment
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XMultiplicativeExpression returns XAssignment
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XAssignment
	 *     XUnaryOperation returns XAssignment
	 *     XCastedExpression returns XAssignment
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XAssignment
	 *     XPostfixOperation returns XAssignment
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XAssignment
	 *     XMemberFeatureCall returns XAssignment
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XAssignment
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XAssignment
	 *     XPrimaryExpression returns XAssignment
	 *     XParenthesizedExpression returns XAssignment
	 *     XExpressionOrVarDeclaration returns XAssignment
	 *
	 * Constraint:
	 *     (
	 *         (feature=[JvmIdentifiableElement|FeatureCallID] value=XAssignment) | 
	 *         (assignable=XMemberFeatureCall_XAssignment_1_0_0_0_0 explicitStatic?='::'? feature=[JvmIdentifiableElement|FeatureCallID] value=XAssignment)
	 *     )
	 */
	protected void sequence_XAssignment_XMemberFeatureCall(ISerializationContext context, XAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XAssignment_XMemberFeatureCall(EObject context, XAssignment semanticObject) {
		sequence_XAssignment_XMemberFeatureCall(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XBasicForLoopExpression
	 *     XAssignment returns XBasicForLoopExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XBasicForLoopExpression
	 *     XOrExpression returns XBasicForLoopExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XBasicForLoopExpression
	 *     XAndExpression returns XBasicForLoopExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XBasicForLoopExpression
	 *     XEqualityExpression returns XBasicForLoopExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XBasicForLoopExpression
	 *     XRelationalExpression returns XBasicForLoopExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XBasicForLoopExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XBasicForLoopExpression
	 *     XOtherOperatorExpression returns XBasicForLoopExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XBasicForLoopExpression
	 *     XAdditiveExpression returns XBasicForLoopExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XBasicForLoopExpression
	 *     XMultiplicativeExpression returns XBasicForLoopExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XBasicForLoopExpression
	 *     XUnaryOperation returns XBasicForLoopExpression
	 *     XCastedExpression returns XBasicForLoopExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XBasicForLoopExpression
	 *     XPostfixOperation returns XBasicForLoopExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XBasicForLoopExpression
	 *     XMemberFeatureCall returns XBasicForLoopExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XBasicForLoopExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XBasicForLoopExpression
	 *     XPrimaryExpression returns XBasicForLoopExpression
	 *     XParenthesizedExpression returns XBasicForLoopExpression
	 *     XBasicForLoopExpression returns XBasicForLoopExpression
	 *     XExpressionOrVarDeclaration returns XBasicForLoopExpression
	 *
	 * Constraint:
	 *     (
	 *         (initExpressions+=XExpressionOrVarDeclaration initExpressions+=XExpressionOrVarDeclaration*)? 
	 *         expression=XExpression? 
	 *         (updateExpressions+=XExpression updateExpressions+=XExpression*)? 
	 *         eachExpression=XExpression
	 *     )
	 */
	protected void sequence_XBasicForLoopExpression(ISerializationContext context, XBasicForLoopExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XBasicForLoopExpression(EObject context, XBasicForLoopExpression semanticObject) {
		sequence_XBasicForLoopExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XBlockExpression
	 *     XAssignment returns XBlockExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XBlockExpression
	 *     XOrExpression returns XBlockExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XBlockExpression
	 *     XAndExpression returns XBlockExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XBlockExpression
	 *     XEqualityExpression returns XBlockExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XBlockExpression
	 *     XRelationalExpression returns XBlockExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XBlockExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XBlockExpression
	 *     XOtherOperatorExpression returns XBlockExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XBlockExpression
	 *     XAdditiveExpression returns XBlockExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XBlockExpression
	 *     XMultiplicativeExpression returns XBlockExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XBlockExpression
	 *     XUnaryOperation returns XBlockExpression
	 *     XCastedExpression returns XBlockExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XBlockExpression
	 *     XPostfixOperation returns XBlockExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XBlockExpression
	 *     XMemberFeatureCall returns XBlockExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XBlockExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XBlockExpression
	 *     XPrimaryExpression returns XBlockExpression
	 *     XParenthesizedExpression returns XBlockExpression
	 *     XBlockExpression returns XBlockExpression
	 *     XExpressionOrVarDeclaration returns XBlockExpression
	 *
	 * Constraint:
	 *     expressions+=XExpressionOrVarDeclaration*
	 */
	protected void sequence_XBlockExpression(ISerializationContext context, XBlockExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XBlockExpression(EObject context, XBlockExpression semanticObject) {
		sequence_XBlockExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XBooleanLiteral
	 *     XAssignment returns XBooleanLiteral
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XBooleanLiteral
	 *     XOrExpression returns XBooleanLiteral
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XBooleanLiteral
	 *     XAndExpression returns XBooleanLiteral
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XBooleanLiteral
	 *     XEqualityExpression returns XBooleanLiteral
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XBooleanLiteral
	 *     XRelationalExpression returns XBooleanLiteral
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XBooleanLiteral
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XBooleanLiteral
	 *     XOtherOperatorExpression returns XBooleanLiteral
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XBooleanLiteral
	 *     XAdditiveExpression returns XBooleanLiteral
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XBooleanLiteral
	 *     XMultiplicativeExpression returns XBooleanLiteral
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XBooleanLiteral
	 *     XUnaryOperation returns XBooleanLiteral
	 *     XCastedExpression returns XBooleanLiteral
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XBooleanLiteral
	 *     XPostfixOperation returns XBooleanLiteral
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XBooleanLiteral
	 *     XMemberFeatureCall returns XBooleanLiteral
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XBooleanLiteral
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XBooleanLiteral
	 *     XPrimaryExpression returns XBooleanLiteral
	 *     XLiteral returns XBooleanLiteral
	 *     XParenthesizedExpression returns XBooleanLiteral
	 *     XExpressionOrVarDeclaration returns XBooleanLiteral
	 *     XBooleanLiteral returns XBooleanLiteral
	 *
	 * Constraint:
	 *     isTrue?='true'?
	 */
	protected void sequence_XBooleanLiteral(ISerializationContext context, XBooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XBooleanLiteral(EObject context, XBooleanLiteral semanticObject) {
		sequence_XBooleanLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XCasePart returns XCasePart
	 *
	 * Constraint:
	 *     (typeGuard=JvmTypeReference? case=XExpression? (then=XExpression | fallThrough?=','))
	 */
	protected void sequence_XCasePart(ISerializationContext context, XCasePart semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XCasePart(EObject context, XCasePart semanticObject) {
		sequence_XCasePart(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XCastedExpression
	 *     XAssignment returns XCastedExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XCastedExpression
	 *     XOrExpression returns XCastedExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XCastedExpression
	 *     XAndExpression returns XCastedExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XCastedExpression
	 *     XEqualityExpression returns XCastedExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XCastedExpression
	 *     XRelationalExpression returns XCastedExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XCastedExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XCastedExpression
	 *     XOtherOperatorExpression returns XCastedExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XCastedExpression
	 *     XAdditiveExpression returns XCastedExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XCastedExpression
	 *     XMultiplicativeExpression returns XCastedExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XCastedExpression
	 *     XUnaryOperation returns XCastedExpression
	 *     XCastedExpression returns XCastedExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XCastedExpression
	 *     XPostfixOperation returns XCastedExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XCastedExpression
	 *     XMemberFeatureCall returns XCastedExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XCastedExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XCastedExpression
	 *     XPrimaryExpression returns XCastedExpression
	 *     XParenthesizedExpression returns XCastedExpression
	 *     XExpressionOrVarDeclaration returns XCastedExpression
	 *
	 * Constraint:
	 *     (target=XCastedExpression_XCastedExpression_1_0_0_0 type=JvmTypeReference)
	 */
	protected void sequence_XCastedExpression(ISerializationContext context, XCastedExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XCASTED_EXPRESSION__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XCASTED_EXPRESSION__TARGET));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XCASTED_EXPRESSION__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XCASTED_EXPRESSION__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(), semanticObject.getTarget());
		feeder.accept(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0(), semanticObject.getType());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XCastedExpression(EObject context, XCastedExpression semanticObject) {
		sequence_XCastedExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XCatchClause returns XCatchClause
	 *
	 * Constraint:
	 *     (declaredParam=FullJvmFormalParameter expression=XExpression)
	 */
	protected void sequence_XCatchClause(ISerializationContext context, XCatchClause semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XCATCH_CLAUSE__DECLARED_PARAM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XCATCH_CLAUSE__DECLARED_PARAM));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XCATCH_CLAUSE__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XCATCH_CLAUSE__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0(), semanticObject.getDeclaredParam());
		feeder.accept(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XCatchClause(EObject context, XCatchClause semanticObject) {
		sequence_XCatchClause(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XClosure
	 *     XAssignment returns XClosure
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XClosure
	 *     XOrExpression returns XClosure
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XClosure
	 *     XAndExpression returns XClosure
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XClosure
	 *     XEqualityExpression returns XClosure
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XClosure
	 *     XRelationalExpression returns XClosure
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XClosure
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XClosure
	 *     XOtherOperatorExpression returns XClosure
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XClosure
	 *     XAdditiveExpression returns XClosure
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XClosure
	 *     XMultiplicativeExpression returns XClosure
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XClosure
	 *     XUnaryOperation returns XClosure
	 *     XCastedExpression returns XClosure
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XClosure
	 *     XPostfixOperation returns XClosure
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XClosure
	 *     XMemberFeatureCall returns XClosure
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XClosure
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XClosure
	 *     XPrimaryExpression returns XClosure
	 *     XLiteral returns XClosure
	 *     XClosure returns XClosure
	 *     XParenthesizedExpression returns XClosure
	 *     XExpressionOrVarDeclaration returns XClosure
	 *
	 * Constraint:
	 *     (
	 *         ((declaredFormalParameters+=JvmFormalParameter declaredFormalParameters+=JvmFormalParameter*)? explicitSyntax?='|')? 
	 *         expression=XExpressionInClosure
	 *     )
	 */
	protected void sequence_XClosure(ISerializationContext context, XClosure semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XClosure(EObject context, XClosure semanticObject) {
		sequence_XClosure(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XConstructorCall
	 *     XAssignment returns XConstructorCall
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XConstructorCall
	 *     XOrExpression returns XConstructorCall
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XConstructorCall
	 *     XAndExpression returns XConstructorCall
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XConstructorCall
	 *     XEqualityExpression returns XConstructorCall
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XConstructorCall
	 *     XRelationalExpression returns XConstructorCall
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XConstructorCall
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XConstructorCall
	 *     XOtherOperatorExpression returns XConstructorCall
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XConstructorCall
	 *     XAdditiveExpression returns XConstructorCall
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XConstructorCall
	 *     XMultiplicativeExpression returns XConstructorCall
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XConstructorCall
	 *     XUnaryOperation returns XConstructorCall
	 *     XCastedExpression returns XConstructorCall
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XConstructorCall
	 *     XPostfixOperation returns XConstructorCall
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XConstructorCall
	 *     XMemberFeatureCall returns XConstructorCall
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XConstructorCall
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XConstructorCall
	 *     XPrimaryExpression returns XConstructorCall
	 *     XParenthesizedExpression returns XConstructorCall
	 *     XExpressionOrVarDeclaration returns XConstructorCall
	 *     XConstructorCall returns XConstructorCall
	 *
	 * Constraint:
	 *     (
	 *         constructor=[JvmConstructor|QualifiedName] 
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)? 
	 *         (explicitConstructorCall?='(' (arguments+=XShortClosure | (arguments+=XExpression arguments+=XExpression*))?)? 
	 *         arguments+=XClosure?
	 *     )
	 */
	protected void sequence_XConstructorCall(ISerializationContext context, XConstructorCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XConstructorCall(EObject context, XConstructorCall semanticObject) {
		sequence_XConstructorCall(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XDoWhileExpression
	 *     XAssignment returns XDoWhileExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XDoWhileExpression
	 *     XOrExpression returns XDoWhileExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XDoWhileExpression
	 *     XAndExpression returns XDoWhileExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XDoWhileExpression
	 *     XEqualityExpression returns XDoWhileExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XDoWhileExpression
	 *     XRelationalExpression returns XDoWhileExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XDoWhileExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XDoWhileExpression
	 *     XOtherOperatorExpression returns XDoWhileExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XDoWhileExpression
	 *     XAdditiveExpression returns XDoWhileExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XDoWhileExpression
	 *     XMultiplicativeExpression returns XDoWhileExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XDoWhileExpression
	 *     XUnaryOperation returns XDoWhileExpression
	 *     XCastedExpression returns XDoWhileExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XDoWhileExpression
	 *     XPostfixOperation returns XDoWhileExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XDoWhileExpression
	 *     XMemberFeatureCall returns XDoWhileExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XDoWhileExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XDoWhileExpression
	 *     XPrimaryExpression returns XDoWhileExpression
	 *     XParenthesizedExpression returns XDoWhileExpression
	 *     XDoWhileExpression returns XDoWhileExpression
	 *     XExpressionOrVarDeclaration returns XDoWhileExpression
	 *
	 * Constraint:
	 *     (body=XExpression predicate=XExpression)
	 */
	protected void sequence_XDoWhileExpression(ISerializationContext context, XDoWhileExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__BODY));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0(), semanticObject.getBody());
		feeder.accept(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0(), semanticObject.getPredicate());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XDoWhileExpression(EObject context, XDoWhileExpression semanticObject) {
		sequence_XDoWhileExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpressionInClosure returns XBlockExpression
	 *
	 * Constraint:
	 *     expressions+=XExpressionOrVarDeclaration*
	 */
	protected void sequence_XExpressionInClosure(ISerializationContext context, XBlockExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XExpressionInClosure(EObject context, XBlockExpression semanticObject) {
		sequence_XExpressionInClosure(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XFeatureCall
	 *     XAssignment returns XFeatureCall
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XFeatureCall
	 *     XOrExpression returns XFeatureCall
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XFeatureCall
	 *     XAndExpression returns XFeatureCall
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XFeatureCall
	 *     XEqualityExpression returns XFeatureCall
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XFeatureCall
	 *     XRelationalExpression returns XFeatureCall
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XFeatureCall
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XFeatureCall
	 *     XOtherOperatorExpression returns XFeatureCall
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XFeatureCall
	 *     XAdditiveExpression returns XFeatureCall
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XFeatureCall
	 *     XMultiplicativeExpression returns XFeatureCall
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XFeatureCall
	 *     XUnaryOperation returns XFeatureCall
	 *     XCastedExpression returns XFeatureCall
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XFeatureCall
	 *     XPostfixOperation returns XFeatureCall
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XFeatureCall
	 *     XMemberFeatureCall returns XFeatureCall
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XFeatureCall
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XFeatureCall
	 *     XPrimaryExpression returns XFeatureCall
	 *     XParenthesizedExpression returns XFeatureCall
	 *     XExpressionOrVarDeclaration returns XFeatureCall
	 *     XFeatureCall returns XFeatureCall
	 *
	 * Constraint:
	 *     (
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)? 
	 *         feature=[JvmIdentifiableElement|IdOrSuper] 
	 *         (explicitOperationCall?='(' (featureCallArguments+=XShortClosure | (featureCallArguments+=XExpression featureCallArguments+=XExpression*))?)? 
	 *         featureCallArguments+=XClosure?
	 *     )
	 */
	protected void sequence_XFeatureCall(ISerializationContext context, XFeatureCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XFeatureCall(EObject context, XFeatureCall semanticObject) {
		sequence_XFeatureCall(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XForLoopExpression
	 *     XAssignment returns XForLoopExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XForLoopExpression
	 *     XOrExpression returns XForLoopExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XForLoopExpression
	 *     XAndExpression returns XForLoopExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XForLoopExpression
	 *     XEqualityExpression returns XForLoopExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XForLoopExpression
	 *     XRelationalExpression returns XForLoopExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XForLoopExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XForLoopExpression
	 *     XOtherOperatorExpression returns XForLoopExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XForLoopExpression
	 *     XAdditiveExpression returns XForLoopExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XForLoopExpression
	 *     XMultiplicativeExpression returns XForLoopExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XForLoopExpression
	 *     XUnaryOperation returns XForLoopExpression
	 *     XCastedExpression returns XForLoopExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XForLoopExpression
	 *     XPostfixOperation returns XForLoopExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XForLoopExpression
	 *     XMemberFeatureCall returns XForLoopExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XForLoopExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XForLoopExpression
	 *     XPrimaryExpression returns XForLoopExpression
	 *     XParenthesizedExpression returns XForLoopExpression
	 *     XForLoopExpression returns XForLoopExpression
	 *     XExpressionOrVarDeclaration returns XForLoopExpression
	 *
	 * Constraint:
	 *     (declaredParam=JvmFormalParameter forExpression=XExpression eachExpression=XExpression)
	 */
	protected void sequence_XForLoopExpression(ISerializationContext context, XForLoopExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XFOR_LOOP_EXPRESSION__DECLARED_PARAM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XFOR_LOOP_EXPRESSION__DECLARED_PARAM));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XFOR_LOOP_EXPRESSION__FOR_EXPRESSION));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XFOR_LOOP_EXPRESSION__EACH_EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0(), semanticObject.getDeclaredParam());
		feeder.accept(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0(), semanticObject.getForExpression());
		feeder.accept(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_3_0(), semanticObject.getEachExpression());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XForLoopExpression(EObject context, XForLoopExpression semanticObject) {
		sequence_XForLoopExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XIfExpression
	 *     XAssignment returns XIfExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XIfExpression
	 *     XOrExpression returns XIfExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XAndExpression returns XIfExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XEqualityExpression returns XIfExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XRelationalExpression returns XIfExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XIfExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XIfExpression
	 *     XOtherOperatorExpression returns XIfExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XAdditiveExpression returns XIfExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XMultiplicativeExpression returns XIfExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XIfExpression
	 *     XUnaryOperation returns XIfExpression
	 *     XCastedExpression returns XIfExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XIfExpression
	 *     XPostfixOperation returns XIfExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XIfExpression
	 *     XMemberFeatureCall returns XIfExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XIfExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XIfExpression
	 *     XPrimaryExpression returns XIfExpression
	 *     XParenthesizedExpression returns XIfExpression
	 *     XIfExpression returns XIfExpression
	 *     XExpressionOrVarDeclaration returns XIfExpression
	 *
	 * Constraint:
	 *     (if=XExpression then=XExpression else=XExpression?)
	 */
	protected void sequence_XIfExpression(ISerializationContext context, XIfExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XIfExpression(EObject context, XIfExpression semanticObject) {
		sequence_XIfExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XListLiteral
	 *     XAssignment returns XListLiteral
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XListLiteral
	 *     XOrExpression returns XListLiteral
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XListLiteral
	 *     XAndExpression returns XListLiteral
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XListLiteral
	 *     XEqualityExpression returns XListLiteral
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XListLiteral
	 *     XRelationalExpression returns XListLiteral
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XListLiteral
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XListLiteral
	 *     XOtherOperatorExpression returns XListLiteral
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XListLiteral
	 *     XAdditiveExpression returns XListLiteral
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XListLiteral
	 *     XMultiplicativeExpression returns XListLiteral
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XListLiteral
	 *     XUnaryOperation returns XListLiteral
	 *     XCastedExpression returns XListLiteral
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XListLiteral
	 *     XPostfixOperation returns XListLiteral
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XListLiteral
	 *     XMemberFeatureCall returns XListLiteral
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XListLiteral
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XListLiteral
	 *     XPrimaryExpression returns XListLiteral
	 *     XLiteral returns XListLiteral
	 *     XCollectionLiteral returns XListLiteral
	 *     XListLiteral returns XListLiteral
	 *     XParenthesizedExpression returns XListLiteral
	 *     XExpressionOrVarDeclaration returns XListLiteral
	 *
	 * Constraint:
	 *     (elements+=XExpression elements+=XExpression*)?
	 */
	protected void sequence_XListLiteral(ISerializationContext context, XListLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XListLiteral(EObject context, XListLiteral semanticObject) {
		sequence_XListLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XMemberFeatureCall
	 *     XAssignment returns XMemberFeatureCall
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XMemberFeatureCall
	 *     XOrExpression returns XMemberFeatureCall
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XMemberFeatureCall
	 *     XAndExpression returns XMemberFeatureCall
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XMemberFeatureCall
	 *     XEqualityExpression returns XMemberFeatureCall
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XMemberFeatureCall
	 *     XRelationalExpression returns XMemberFeatureCall
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XMemberFeatureCall
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XMemberFeatureCall
	 *     XOtherOperatorExpression returns XMemberFeatureCall
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XMemberFeatureCall
	 *     XAdditiveExpression returns XMemberFeatureCall
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XMemberFeatureCall
	 *     XMultiplicativeExpression returns XMemberFeatureCall
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XMemberFeatureCall
	 *     XUnaryOperation returns XMemberFeatureCall
	 *     XCastedExpression returns XMemberFeatureCall
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XMemberFeatureCall
	 *     XPostfixOperation returns XMemberFeatureCall
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XMemberFeatureCall
	 *     XMemberFeatureCall returns XMemberFeatureCall
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XMemberFeatureCall
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XMemberFeatureCall
	 *     XPrimaryExpression returns XMemberFeatureCall
	 *     XParenthesizedExpression returns XMemberFeatureCall
	 *     XExpressionOrVarDeclaration returns XMemberFeatureCall
	 *
	 * Constraint:
	 *     (
	 *         memberCallTarget=XMemberFeatureCall_XMemberFeatureCall_1_1_0_0_0 
	 *         (nullSafe?='?.' | explicitStatic?='::')? 
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)? 
	 *         feature=[JvmIdentifiableElement|IdOrSuper] 
	 *         (explicitOperationCall?='(' (memberCallArguments+=XShortClosure | (memberCallArguments+=XExpression memberCallArguments+=XExpression*))?)? 
	 *         memberCallArguments+=XClosure?
	 *     )
	 */
	protected void sequence_XMemberFeatureCall(ISerializationContext context, XMemberFeatureCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XMemberFeatureCall(EObject context, XMemberFeatureCall semanticObject) {
		sequence_XMemberFeatureCall(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XNullLiteral
	 *     XAssignment returns XNullLiteral
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XNullLiteral
	 *     XOrExpression returns XNullLiteral
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XNullLiteral
	 *     XAndExpression returns XNullLiteral
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XNullLiteral
	 *     XEqualityExpression returns XNullLiteral
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XNullLiteral
	 *     XRelationalExpression returns XNullLiteral
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XNullLiteral
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XNullLiteral
	 *     XOtherOperatorExpression returns XNullLiteral
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XNullLiteral
	 *     XAdditiveExpression returns XNullLiteral
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XNullLiteral
	 *     XMultiplicativeExpression returns XNullLiteral
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XNullLiteral
	 *     XUnaryOperation returns XNullLiteral
	 *     XCastedExpression returns XNullLiteral
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XNullLiteral
	 *     XPostfixOperation returns XNullLiteral
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XNullLiteral
	 *     XMemberFeatureCall returns XNullLiteral
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XNullLiteral
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XNullLiteral
	 *     XPrimaryExpression returns XNullLiteral
	 *     XLiteral returns XNullLiteral
	 *     XParenthesizedExpression returns XNullLiteral
	 *     XExpressionOrVarDeclaration returns XNullLiteral
	 *     XNullLiteral returns XNullLiteral
	 *
	 * Constraint:
	 *     {XNullLiteral}
	 */
	protected void sequence_XNullLiteral(ISerializationContext context, XNullLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XNullLiteral(EObject context, XNullLiteral semanticObject) {
		sequence_XNullLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XNumberLiteral
	 *     XAssignment returns XNumberLiteral
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XNumberLiteral
	 *     XOrExpression returns XNumberLiteral
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XNumberLiteral
	 *     XAndExpression returns XNumberLiteral
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XNumberLiteral
	 *     XEqualityExpression returns XNumberLiteral
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XNumberLiteral
	 *     XRelationalExpression returns XNumberLiteral
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XNumberLiteral
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XNumberLiteral
	 *     XOtherOperatorExpression returns XNumberLiteral
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XNumberLiteral
	 *     XAdditiveExpression returns XNumberLiteral
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XNumberLiteral
	 *     XMultiplicativeExpression returns XNumberLiteral
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XNumberLiteral
	 *     XUnaryOperation returns XNumberLiteral
	 *     XCastedExpression returns XNumberLiteral
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XNumberLiteral
	 *     XPostfixOperation returns XNumberLiteral
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XNumberLiteral
	 *     XMemberFeatureCall returns XNumberLiteral
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XNumberLiteral
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XNumberLiteral
	 *     XPrimaryExpression returns XNumberLiteral
	 *     XLiteral returns XNumberLiteral
	 *     XParenthesizedExpression returns XNumberLiteral
	 *     XExpressionOrVarDeclaration returns XNumberLiteral
	 *     XNumberLiteral returns XNumberLiteral
	 *
	 * Constraint:
	 *     value=Number
	 */
	protected void sequence_XNumberLiteral(ISerializationContext context, XNumberLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XNUMBER_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XNUMBER_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XNumberLiteral(EObject context, XNumberLiteral semanticObject) {
		sequence_XNumberLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XPostfixOperation
	 *     XAssignment returns XPostfixOperation
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XPostfixOperation
	 *     XOrExpression returns XPostfixOperation
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XPostfixOperation
	 *     XAndExpression returns XPostfixOperation
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XPostfixOperation
	 *     XEqualityExpression returns XPostfixOperation
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XPostfixOperation
	 *     XRelationalExpression returns XPostfixOperation
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XPostfixOperation
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XPostfixOperation
	 *     XOtherOperatorExpression returns XPostfixOperation
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XPostfixOperation
	 *     XAdditiveExpression returns XPostfixOperation
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XPostfixOperation
	 *     XMultiplicativeExpression returns XPostfixOperation
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XPostfixOperation
	 *     XUnaryOperation returns XPostfixOperation
	 *     XCastedExpression returns XPostfixOperation
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XPostfixOperation
	 *     XPostfixOperation returns XPostfixOperation
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XPostfixOperation
	 *     XMemberFeatureCall returns XPostfixOperation
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XPostfixOperation
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XPostfixOperation
	 *     XPrimaryExpression returns XPostfixOperation
	 *     XParenthesizedExpression returns XPostfixOperation
	 *     XExpressionOrVarDeclaration returns XPostfixOperation
	 *
	 * Constraint:
	 *     (operand=XPostfixOperation_XPostfixOperation_1_0_0 feature=[JvmIdentifiableElement|OpPostfix])
	 */
	protected void sequence_XPostfixOperation(ISerializationContext context, XPostfixOperation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XPOSTFIX_OPERATION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XPOSTFIX_OPERATION__OPERAND));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0(), semanticObject.getOperand());
		feeder.accept(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1(), semanticObject.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false));
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XPostfixOperation(EObject context, XPostfixOperation semanticObject) {
		sequence_XPostfixOperation(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XInstanceOfExpression
	 *     XAssignment returns XInstanceOfExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XInstanceOfExpression
	 *     XOrExpression returns XInstanceOfExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XInstanceOfExpression
	 *     XAndExpression returns XInstanceOfExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XInstanceOfExpression
	 *     XEqualityExpression returns XInstanceOfExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XInstanceOfExpression
	 *     XRelationalExpression returns XInstanceOfExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XInstanceOfExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XInstanceOfExpression
	 *     XOtherOperatorExpression returns XInstanceOfExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XInstanceOfExpression
	 *     XAdditiveExpression returns XInstanceOfExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XInstanceOfExpression
	 *     XMultiplicativeExpression returns XInstanceOfExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XInstanceOfExpression
	 *     XUnaryOperation returns XInstanceOfExpression
	 *     XCastedExpression returns XInstanceOfExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XInstanceOfExpression
	 *     XPostfixOperation returns XInstanceOfExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XInstanceOfExpression
	 *     XMemberFeatureCall returns XInstanceOfExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XInstanceOfExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XInstanceOfExpression
	 *     XPrimaryExpression returns XInstanceOfExpression
	 *     XParenthesizedExpression returns XInstanceOfExpression
	 *     XExpressionOrVarDeclaration returns XInstanceOfExpression
	 *
	 * Constraint:
	 *     (expression=XRelationalExpression_XInstanceOfExpression_1_0_0_0_0 type=JvmTypeReference)
	 */
	protected void sequence_XRelationalExpression(ISerializationContext context, XInstanceOfExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION__EXPRESSION));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XINSTANCE_OF_EXPRESSION__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(), semanticObject.getExpression());
		feeder.accept(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0(), semanticObject.getType());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XRelationalExpression(EObject context, XInstanceOfExpression semanticObject) {
		sequence_XRelationalExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XReturnExpression
	 *     XAssignment returns XReturnExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XReturnExpression
	 *     XOrExpression returns XReturnExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XReturnExpression
	 *     XAndExpression returns XReturnExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XReturnExpression
	 *     XEqualityExpression returns XReturnExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XReturnExpression
	 *     XRelationalExpression returns XReturnExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XReturnExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XReturnExpression
	 *     XOtherOperatorExpression returns XReturnExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XReturnExpression
	 *     XAdditiveExpression returns XReturnExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XReturnExpression
	 *     XMultiplicativeExpression returns XReturnExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XReturnExpression
	 *     XUnaryOperation returns XReturnExpression
	 *     XCastedExpression returns XReturnExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XReturnExpression
	 *     XPostfixOperation returns XReturnExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XReturnExpression
	 *     XMemberFeatureCall returns XReturnExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XReturnExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XReturnExpression
	 *     XPrimaryExpression returns XReturnExpression
	 *     XParenthesizedExpression returns XReturnExpression
	 *     XExpressionOrVarDeclaration returns XReturnExpression
	 *     XReturnExpression returns XReturnExpression
	 *
	 * Constraint:
	 *     expression=XExpression?
	 */
	protected void sequence_XReturnExpression(ISerializationContext context, XReturnExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XReturnExpression(EObject context, XReturnExpression semanticObject) {
		sequence_XReturnExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XSetLiteral
	 *     XAssignment returns XSetLiteral
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XSetLiteral
	 *     XOrExpression returns XSetLiteral
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XSetLiteral
	 *     XAndExpression returns XSetLiteral
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XSetLiteral
	 *     XEqualityExpression returns XSetLiteral
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XSetLiteral
	 *     XRelationalExpression returns XSetLiteral
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XSetLiteral
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XSetLiteral
	 *     XOtherOperatorExpression returns XSetLiteral
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XSetLiteral
	 *     XAdditiveExpression returns XSetLiteral
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XSetLiteral
	 *     XMultiplicativeExpression returns XSetLiteral
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XSetLiteral
	 *     XUnaryOperation returns XSetLiteral
	 *     XCastedExpression returns XSetLiteral
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XSetLiteral
	 *     XPostfixOperation returns XSetLiteral
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XSetLiteral
	 *     XMemberFeatureCall returns XSetLiteral
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XSetLiteral
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XSetLiteral
	 *     XPrimaryExpression returns XSetLiteral
	 *     XLiteral returns XSetLiteral
	 *     XCollectionLiteral returns XSetLiteral
	 *     XSetLiteral returns XSetLiteral
	 *     XParenthesizedExpression returns XSetLiteral
	 *     XExpressionOrVarDeclaration returns XSetLiteral
	 *
	 * Constraint:
	 *     (elements+=XExpression elements+=XExpression*)?
	 */
	protected void sequence_XSetLiteral(ISerializationContext context, XSetLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XSetLiteral(EObject context, XSetLiteral semanticObject) {
		sequence_XSetLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XShortClosure returns XClosure
	 *
	 * Constraint:
	 *     ((declaredFormalParameters+=JvmFormalParameter declaredFormalParameters+=JvmFormalParameter*)? explicitSyntax?='|' expression=XExpression)
	 */
	protected void sequence_XShortClosure(ISerializationContext context, XClosure semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XShortClosure(EObject context, XClosure semanticObject) {
		sequence_XShortClosure(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XStringLiteral
	 *     XAssignment returns XStringLiteral
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XStringLiteral
	 *     XOrExpression returns XStringLiteral
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XStringLiteral
	 *     XAndExpression returns XStringLiteral
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XStringLiteral
	 *     XEqualityExpression returns XStringLiteral
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XStringLiteral
	 *     XRelationalExpression returns XStringLiteral
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XStringLiteral
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XStringLiteral
	 *     XOtherOperatorExpression returns XStringLiteral
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XStringLiteral
	 *     XAdditiveExpression returns XStringLiteral
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XStringLiteral
	 *     XMultiplicativeExpression returns XStringLiteral
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XStringLiteral
	 *     XUnaryOperation returns XStringLiteral
	 *     XCastedExpression returns XStringLiteral
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XStringLiteral
	 *     XPostfixOperation returns XStringLiteral
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XStringLiteral
	 *     XMemberFeatureCall returns XStringLiteral
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XStringLiteral
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XStringLiteral
	 *     XPrimaryExpression returns XStringLiteral
	 *     XLiteral returns XStringLiteral
	 *     XParenthesizedExpression returns XStringLiteral
	 *     XExpressionOrVarDeclaration returns XStringLiteral
	 *     XStringLiteral returns XStringLiteral
	 *
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_XStringLiteral(ISerializationContext context, XStringLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSTRING_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XStringLiteral(EObject context, XStringLiteral semanticObject) {
		sequence_XStringLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XSwitchExpression
	 *     XAssignment returns XSwitchExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XSwitchExpression
	 *     XOrExpression returns XSwitchExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XSwitchExpression
	 *     XAndExpression returns XSwitchExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XSwitchExpression
	 *     XEqualityExpression returns XSwitchExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XSwitchExpression
	 *     XRelationalExpression returns XSwitchExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XSwitchExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XSwitchExpression
	 *     XOtherOperatorExpression returns XSwitchExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XSwitchExpression
	 *     XAdditiveExpression returns XSwitchExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XSwitchExpression
	 *     XMultiplicativeExpression returns XSwitchExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XSwitchExpression
	 *     XUnaryOperation returns XSwitchExpression
	 *     XCastedExpression returns XSwitchExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XSwitchExpression
	 *     XPostfixOperation returns XSwitchExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XSwitchExpression
	 *     XMemberFeatureCall returns XSwitchExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XSwitchExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XSwitchExpression
	 *     XPrimaryExpression returns XSwitchExpression
	 *     XParenthesizedExpression returns XSwitchExpression
	 *     XSwitchExpression returns XSwitchExpression
	 *     XExpressionOrVarDeclaration returns XSwitchExpression
	 *
	 * Constraint:
	 *     (
	 *         ((declaredParam=JvmFormalParameter switch=XExpression) | (declaredParam=JvmFormalParameter? switch=XExpression)) 
	 *         cases+=XCasePart* 
	 *         default=XExpression?
	 *     )
	 */
	protected void sequence_XSwitchExpression(ISerializationContext context, XSwitchExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XSwitchExpression(EObject context, XSwitchExpression semanticObject) {
		sequence_XSwitchExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XSynchronizedExpression
	 *     XAssignment returns XSynchronizedExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XSynchronizedExpression
	 *     XOrExpression returns XSynchronizedExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XSynchronizedExpression
	 *     XAndExpression returns XSynchronizedExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XSynchronizedExpression
	 *     XEqualityExpression returns XSynchronizedExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XSynchronizedExpression
	 *     XRelationalExpression returns XSynchronizedExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XSynchronizedExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XSynchronizedExpression
	 *     XOtherOperatorExpression returns XSynchronizedExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XSynchronizedExpression
	 *     XAdditiveExpression returns XSynchronizedExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XSynchronizedExpression
	 *     XMultiplicativeExpression returns XSynchronizedExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XSynchronizedExpression
	 *     XUnaryOperation returns XSynchronizedExpression
	 *     XCastedExpression returns XSynchronizedExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XSynchronizedExpression
	 *     XPostfixOperation returns XSynchronizedExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XSynchronizedExpression
	 *     XMemberFeatureCall returns XSynchronizedExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XSynchronizedExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XSynchronizedExpression
	 *     XPrimaryExpression returns XSynchronizedExpression
	 *     XParenthesizedExpression returns XSynchronizedExpression
	 *     XExpressionOrVarDeclaration returns XSynchronizedExpression
	 *     XSynchronizedExpression returns XSynchronizedExpression
	 *
	 * Constraint:
	 *     (param=XExpression expression=XExpression)
	 */
	protected void sequence_XSynchronizedExpression(ISerializationContext context, XSynchronizedExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSYNCHRONIZED_EXPRESSION__PARAM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSYNCHRONIZED_EXPRESSION__PARAM));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XSYNCHRONIZED_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XSYNCHRONIZED_EXPRESSION__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0(), semanticObject.getParam());
		feeder.accept(grammarAccess.getXSynchronizedExpressionAccess().getExpressionXExpressionParserRuleCall_3_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XSynchronizedExpression(EObject context, XSynchronizedExpression semanticObject) {
		sequence_XSynchronizedExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XThrowExpression
	 *     XAssignment returns XThrowExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XThrowExpression
	 *     XOrExpression returns XThrowExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XThrowExpression
	 *     XAndExpression returns XThrowExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XThrowExpression
	 *     XEqualityExpression returns XThrowExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XThrowExpression
	 *     XRelationalExpression returns XThrowExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XThrowExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XThrowExpression
	 *     XOtherOperatorExpression returns XThrowExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XThrowExpression
	 *     XAdditiveExpression returns XThrowExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XThrowExpression
	 *     XMultiplicativeExpression returns XThrowExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XThrowExpression
	 *     XUnaryOperation returns XThrowExpression
	 *     XCastedExpression returns XThrowExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XThrowExpression
	 *     XPostfixOperation returns XThrowExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XThrowExpression
	 *     XMemberFeatureCall returns XThrowExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XThrowExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XThrowExpression
	 *     XPrimaryExpression returns XThrowExpression
	 *     XParenthesizedExpression returns XThrowExpression
	 *     XExpressionOrVarDeclaration returns XThrowExpression
	 *     XThrowExpression returns XThrowExpression
	 *
	 * Constraint:
	 *     expression=XExpression
	 */
	protected void sequence_XThrowExpression(ISerializationContext context, XThrowExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XTHROW_EXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XTHROW_EXPRESSION__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XThrowExpression(EObject context, XThrowExpression semanticObject) {
		sequence_XThrowExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XTryCatchFinallyExpression
	 *     XAssignment returns XTryCatchFinallyExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XOrExpression returns XTryCatchFinallyExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XAndExpression returns XTryCatchFinallyExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XEqualityExpression returns XTryCatchFinallyExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XRelationalExpression returns XTryCatchFinallyExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XTryCatchFinallyExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XOtherOperatorExpression returns XTryCatchFinallyExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XAdditiveExpression returns XTryCatchFinallyExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XMultiplicativeExpression returns XTryCatchFinallyExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XUnaryOperation returns XTryCatchFinallyExpression
	 *     XCastedExpression returns XTryCatchFinallyExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XPostfixOperation returns XTryCatchFinallyExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XTryCatchFinallyExpression
	 *     XMemberFeatureCall returns XTryCatchFinallyExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XTryCatchFinallyExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XTryCatchFinallyExpression
	 *     XPrimaryExpression returns XTryCatchFinallyExpression
	 *     XParenthesizedExpression returns XTryCatchFinallyExpression
	 *     XExpressionOrVarDeclaration returns XTryCatchFinallyExpression
	 *     XTryCatchFinallyExpression returns XTryCatchFinallyExpression
	 *
	 * Constraint:
	 *     (expression=XExpression ((catchClauses+=XCatchClause+ finallyExpression=XExpression?) | finallyExpression=XExpression))
	 */
	protected void sequence_XTryCatchFinallyExpression(ISerializationContext context, XTryCatchFinallyExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XTryCatchFinallyExpression(EObject context, XTryCatchFinallyExpression semanticObject) {
		sequence_XTryCatchFinallyExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XTypeLiteral
	 *     XAssignment returns XTypeLiteral
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XTypeLiteral
	 *     XOrExpression returns XTypeLiteral
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XTypeLiteral
	 *     XAndExpression returns XTypeLiteral
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XTypeLiteral
	 *     XEqualityExpression returns XTypeLiteral
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XTypeLiteral
	 *     XRelationalExpression returns XTypeLiteral
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XTypeLiteral
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XTypeLiteral
	 *     XOtherOperatorExpression returns XTypeLiteral
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XTypeLiteral
	 *     XAdditiveExpression returns XTypeLiteral
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XTypeLiteral
	 *     XMultiplicativeExpression returns XTypeLiteral
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XTypeLiteral
	 *     XUnaryOperation returns XTypeLiteral
	 *     XCastedExpression returns XTypeLiteral
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XTypeLiteral
	 *     XPostfixOperation returns XTypeLiteral
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XTypeLiteral
	 *     XMemberFeatureCall returns XTypeLiteral
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XTypeLiteral
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XTypeLiteral
	 *     XPrimaryExpression returns XTypeLiteral
	 *     XLiteral returns XTypeLiteral
	 *     XParenthesizedExpression returns XTypeLiteral
	 *     XExpressionOrVarDeclaration returns XTypeLiteral
	 *     XTypeLiteral returns XTypeLiteral
	 *
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] arrayDimensions+=ArrayBrackets*)
	 */
	protected void sequence_XTypeLiteral(ISerializationContext context, XTypeLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XTypeLiteral(EObject context, XTypeLiteral semanticObject) {
		sequence_XTypeLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XUnaryOperation
	 *     XAssignment returns XUnaryOperation
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XUnaryOperation
	 *     XOrExpression returns XUnaryOperation
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XUnaryOperation
	 *     XAndExpression returns XUnaryOperation
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XUnaryOperation
	 *     XEqualityExpression returns XUnaryOperation
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XUnaryOperation
	 *     XRelationalExpression returns XUnaryOperation
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XUnaryOperation
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XUnaryOperation
	 *     XOtherOperatorExpression returns XUnaryOperation
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XUnaryOperation
	 *     XAdditiveExpression returns XUnaryOperation
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XUnaryOperation
	 *     XMultiplicativeExpression returns XUnaryOperation
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XUnaryOperation
	 *     XUnaryOperation returns XUnaryOperation
	 *     XCastedExpression returns XUnaryOperation
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XUnaryOperation
	 *     XPostfixOperation returns XUnaryOperation
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XUnaryOperation
	 *     XMemberFeatureCall returns XUnaryOperation
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XUnaryOperation
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XUnaryOperation
	 *     XPrimaryExpression returns XUnaryOperation
	 *     XParenthesizedExpression returns XUnaryOperation
	 *     XExpressionOrVarDeclaration returns XUnaryOperation
	 *
	 * Constraint:
	 *     (feature=[JvmIdentifiableElement|OpUnary] operand=XUnaryOperation)
	 */
	protected void sequence_XUnaryOperation(ISerializationContext context, XUnaryOperation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XUNARY_OPERATION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XUNARY_OPERATION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1(), semanticObject.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false));
		feeder.accept(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XUnaryOperation(EObject context, XUnaryOperation semanticObject) {
		sequence_XUnaryOperation(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpressionOrVarDeclaration returns XVariableDeclaration
	 *     XVariableDeclaration returns XVariableDeclaration
	 *
	 * Constraint:
	 *     (writeable?='var'? ((type=JvmTypeReference name=ValidID) | name=ValidID) right=XExpression?)
	 */
	protected void sequence_XVariableDeclaration(ISerializationContext context, XVariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XVariableDeclaration(EObject context, XVariableDeclaration semanticObject) {
		sequence_XVariableDeclaration(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Contexts:
	 *     XExpression returns XWhileExpression
	 *     XAssignment returns XWhileExpression
	 *     XAssignment.XBinaryOperation_1_1_0_0_0 returns XWhileExpression
	 *     XOrExpression returns XWhileExpression
	 *     XOrExpression.XBinaryOperation_1_0_0_0 returns XWhileExpression
	 *     XAndExpression returns XWhileExpression
	 *     XAndExpression.XBinaryOperation_1_0_0_0 returns XWhileExpression
	 *     XEqualityExpression returns XWhileExpression
	 *     XEqualityExpression.XBinaryOperation_1_0_0_0 returns XWhileExpression
	 *     XRelationalExpression returns XWhileExpression
	 *     XRelationalExpression.XInstanceOfExpression_1_0_0_0_0 returns XWhileExpression
	 *     XRelationalExpression.XBinaryOperation_1_1_0_0_0 returns XWhileExpression
	 *     XOtherOperatorExpression returns XWhileExpression
	 *     XOtherOperatorExpression.XBinaryOperation_1_0_0_0 returns XWhileExpression
	 *     XAdditiveExpression returns XWhileExpression
	 *     XAdditiveExpression.XBinaryOperation_1_0_0_0 returns XWhileExpression
	 *     XMultiplicativeExpression returns XWhileExpression
	 *     XMultiplicativeExpression.XBinaryOperation_1_0_0_0 returns XWhileExpression
	 *     XUnaryOperation returns XWhileExpression
	 *     XCastedExpression returns XWhileExpression
	 *     XCastedExpression.XCastedExpression_1_0_0_0 returns XWhileExpression
	 *     XPostfixOperation returns XWhileExpression
	 *     XPostfixOperation.XPostfixOperation_1_0_0 returns XWhileExpression
	 *     XMemberFeatureCall returns XWhileExpression
	 *     XMemberFeatureCall.XAssignment_1_0_0_0_0 returns XWhileExpression
	 *     XMemberFeatureCall.XMemberFeatureCall_1_1_0_0_0 returns XWhileExpression
	 *     XPrimaryExpression returns XWhileExpression
	 *     XParenthesizedExpression returns XWhileExpression
	 *     XWhileExpression returns XWhileExpression
	 *     XExpressionOrVarDeclaration returns XWhileExpression
	 *
	 * Constraint:
	 *     (predicate=XExpression body=XExpression)
	 */
	protected void sequence_XWhileExpression(ISerializationContext context, XWhileExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__PREDICATE));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__BODY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XABSTRACT_WHILE_EXPRESSION__BODY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0(), semanticObject.getPredicate());
		feeder.accept(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0(), semanticObject.getBody());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XWhileExpression(EObject context, XWhileExpression semanticObject) {
		sequence_XWhileExpression(createContext(context, semanticObject), semanticObject);
	}
	
}
