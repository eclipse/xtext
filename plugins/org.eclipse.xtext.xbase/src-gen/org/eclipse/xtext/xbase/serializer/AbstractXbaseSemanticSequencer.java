/*******************************************************************************
 * Copyright (c) 2010-2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
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
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.analysis.IContext;
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
	public void sequence(IContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
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
	 * Constraint:
	 *     (parameterType=JvmTypeReference name=ValidID)
	 */
	protected void sequence_FullJvmFormalParameter(IContext context, JvmFormalParameter semanticObject) {
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
	 * Constraint:
	 *     (parameterType=JvmTypeReference? name=ValidID)
	 */
	protected void sequence_JvmFormalParameter(IContext context, JvmFormalParameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_JvmFormalParameter(EObject context, JvmFormalParameter semanticObject) {
		sequence_JvmFormalParameter(createContext(context, semanticObject), semanticObject);
	}
	
	/**
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
	protected void sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(IContext context, XBinaryOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(EObject context, XBinaryOperation semanticObject) {
		sequence_XAdditiveExpression_XAndExpression_XAssignment_XEqualityExpression_XMultiplicativeExpression_XOrExpression_XOtherOperatorExpression_XRelationalExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (feature=[JvmIdentifiableElement|FeatureCallID] value=XAssignment) | 
	 *         (assignable=XMemberFeatureCall_XAssignment_1_0_0_0_0 explicitStatic?='::'? feature=[JvmIdentifiableElement|FeatureCallID] value=XAssignment)
	 *     )
	 */
	protected void sequence_XAssignment_XMemberFeatureCall(IContext context, XAssignment semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XAssignment_XMemberFeatureCall(EObject context, XAssignment semanticObject) {
		sequence_XAssignment_XMemberFeatureCall(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (initExpressions+=XExpressionOrVarDeclaration initExpressions+=XExpressionOrVarDeclaration*)? 
	 *         expression=XExpression? 
	 *         (updateExpressions+=XExpression updateExpressions+=XExpression*)? 
	 *         eachExpression=XExpression
	 *     )
	 */
	protected void sequence_XBasicForLoopExpression(IContext context, XBasicForLoopExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XBasicForLoopExpression(EObject context, XBasicForLoopExpression semanticObject) {
		sequence_XBasicForLoopExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     expressions+=XExpressionOrVarDeclaration*
	 */
	protected void sequence_XBlockExpression(IContext context, XBlockExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XBlockExpression(EObject context, XBlockExpression semanticObject) {
		sequence_XBlockExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     isTrue?='true'?
	 */
	protected void sequence_XBooleanLiteral(IContext context, XBooleanLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XBooleanLiteral(EObject context, XBooleanLiteral semanticObject) {
		sequence_XBooleanLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (typeGuard=JvmTypeReference? case=XExpression? (then=XExpression | fallThrough?=','))
	 */
	protected void sequence_XCasePart(IContext context, XCasePart semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XCasePart(EObject context, XCasePart semanticObject) {
		sequence_XCasePart(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (target=XCastedExpression_XCastedExpression_1_0_0_0 type=JvmTypeReference)
	 */
	protected void sequence_XCastedExpression(IContext context, XCastedExpression semanticObject) {
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
	 * Constraint:
	 *     (declaredParam=FullJvmFormalParameter expression=XExpression)
	 */
	protected void sequence_XCatchClause(IContext context, XCatchClause semanticObject) {
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
	 * Constraint:
	 *     (
	 *         ((declaredFormalParameters+=JvmFormalParameter declaredFormalParameters+=JvmFormalParameter*)? explicitSyntax?='|')? 
	 *         expression=XExpressionInClosure
	 *     )
	 */
	protected void sequence_XClosure(IContext context, XClosure semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XClosure(EObject context, XClosure semanticObject) {
		sequence_XClosure(createContext(context, semanticObject), semanticObject);
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
	protected void sequence_XConstructorCall(IContext context, XConstructorCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XConstructorCall(EObject context, XConstructorCall semanticObject) {
		sequence_XConstructorCall(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (body=XExpression predicate=XExpression)
	 */
	protected void sequence_XDoWhileExpression(IContext context, XDoWhileExpression semanticObject) {
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
	 * Constraint:
	 *     expressions+=XExpressionOrVarDeclaration*
	 */
	protected void sequence_XExpressionInClosure(IContext context, XBlockExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XExpressionInClosure(EObject context, XBlockExpression semanticObject) {
		sequence_XExpressionInClosure(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (
	 *         (typeArguments+=JvmArgumentTypeReference typeArguments+=JvmArgumentTypeReference*)? 
	 *         feature=[JvmIdentifiableElement|IdOrSuper] 
	 *         (explicitOperationCall?='(' (featureCallArguments+=XShortClosure | (featureCallArguments+=XExpression featureCallArguments+=XExpression*))?)? 
	 *         featureCallArguments+=XClosure?
	 *     )
	 */
	protected void sequence_XFeatureCall(IContext context, XFeatureCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XFeatureCall(EObject context, XFeatureCall semanticObject) {
		sequence_XFeatureCall(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (declaredParam=JvmFormalParameter forExpression=XExpression eachExpression=XExpression)
	 */
	protected void sequence_XForLoopExpression(IContext context, XForLoopExpression semanticObject) {
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
	 * Constraint:
	 *     (if=XExpression then=XExpression else=XExpression?)
	 */
	protected void sequence_XIfExpression(IContext context, XIfExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XIfExpression(EObject context, XIfExpression semanticObject) {
		sequence_XIfExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (elements+=XExpression elements+=XExpression*)?
	 */
	protected void sequence_XListLiteral(IContext context, XListLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XListLiteral(EObject context, XListLiteral semanticObject) {
		sequence_XListLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
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
	protected void sequence_XMemberFeatureCall(IContext context, XMemberFeatureCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XMemberFeatureCall(EObject context, XMemberFeatureCall semanticObject) {
		sequence_XMemberFeatureCall(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     {XNullLiteral}
	 */
	protected void sequence_XNullLiteral(IContext context, XNullLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XNullLiteral(EObject context, XNullLiteral semanticObject) {
		sequence_XNullLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     value=Number
	 */
	protected void sequence_XNumberLiteral(IContext context, XNumberLiteral semanticObject) {
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
	 * Constraint:
	 *     (operand=XPostfixOperation_XPostfixOperation_1_0_0 feature=[JvmIdentifiableElement|OpPostfix])
	 */
	protected void sequence_XPostfixOperation(IContext context, XPostfixOperation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XPOSTFIX_OPERATION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XPOSTFIX_OPERATION__OPERAND));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0(), semanticObject.getOperand());
		feeder.accept(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementOpPostfixParserRuleCall_1_0_1_0_1(), semanticObject.getFeature());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XPostfixOperation(EObject context, XPostfixOperation semanticObject) {
		sequence_XPostfixOperation(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (expression=XRelationalExpression_XInstanceOfExpression_1_0_0_0_0 type=JvmTypeReference)
	 */
	protected void sequence_XRelationalExpression(IContext context, XInstanceOfExpression semanticObject) {
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
	 * Constraint:
	 *     expression=XExpression?
	 */
	protected void sequence_XReturnExpression(IContext context, XReturnExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XReturnExpression(EObject context, XReturnExpression semanticObject) {
		sequence_XReturnExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (elements+=XExpression elements+=XExpression*)?
	 */
	protected void sequence_XSetLiteral(IContext context, XSetLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XSetLiteral(EObject context, XSetLiteral semanticObject) {
		sequence_XSetLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     ((declaredFormalParameters+=JvmFormalParameter declaredFormalParameters+=JvmFormalParameter*)? explicitSyntax?='|' expression=XExpression)
	 */
	protected void sequence_XShortClosure(IContext context, XClosure semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XShortClosure(EObject context, XClosure semanticObject) {
		sequence_XShortClosure(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_XStringLiteral(IContext context, XStringLiteral semanticObject) {
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
	 * Constraint:
	 *     (
	 *         ((declaredParam=JvmFormalParameter switch=XExpression) | (declaredParam=JvmFormalParameter? switch=XExpression)) 
	 *         cases+=XCasePart* 
	 *         default=XExpression?
	 *     )
	 */
	protected void sequence_XSwitchExpression(IContext context, XSwitchExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XSwitchExpression(EObject context, XSwitchExpression semanticObject) {
		sequence_XSwitchExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (param=XExpression expression=XExpression)
	 */
	protected void sequence_XSynchronizedExpression(IContext context, XSynchronizedExpression semanticObject) {
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
	 * Constraint:
	 *     expression=XExpression
	 */
	protected void sequence_XThrowExpression(IContext context, XThrowExpression semanticObject) {
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
	 * Constraint:
	 *     (expression=XExpression ((catchClauses+=XCatchClause+ finallyExpression=XExpression?) | finallyExpression=XExpression))
	 */
	protected void sequence_XTryCatchFinallyExpression(IContext context, XTryCatchFinallyExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XTryCatchFinallyExpression(EObject context, XTryCatchFinallyExpression semanticObject) {
		sequence_XTryCatchFinallyExpression(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedName] arrayDimensions+=ArrayBrackets*)
	 */
	protected void sequence_XTypeLiteral(IContext context, XTypeLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XTypeLiteral(EObject context, XTypeLiteral semanticObject) {
		sequence_XTypeLiteral(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (feature=[JvmIdentifiableElement|OpUnary] operand=XUnaryOperation)
	 */
	protected void sequence_XUnaryOperation(IContext context, XUnaryOperation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE));
			if (transientValues.isValueTransient(semanticObject, XbasePackage.Literals.XUNARY_OPERATION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, XbasePackage.Literals.XUNARY_OPERATION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementOpUnaryParserRuleCall_0_1_0_1(), semanticObject.getFeature());
		feeder.accept(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	@Deprecated
	protected void sequence_XUnaryOperation(EObject context, XUnaryOperation semanticObject) {
		sequence_XUnaryOperation(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (writeable?='var'? ((type=JvmTypeReference name=ValidID) | name=ValidID) right=XExpression?)
	 */
	protected void sequence_XVariableDeclaration(IContext context, XVariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	@Deprecated
	protected void sequence_XVariableDeclaration(EObject context, XVariableDeclaration semanticObject) {
		sequence_XVariableDeclaration(createContext(context, semanticObject), semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (predicate=XExpression body=XExpression)
	 */
	protected void sequence_XWhileExpression(IContext context, XWhileExpression semanticObject) {
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
