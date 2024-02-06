/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.AssignmentExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.Block;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.CommaExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.ExpressionStatement;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.FunctionDeclaration;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.IdentifierRef;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.IndexedAccessExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.LabelledStatement;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.ParameterizedExpressionsTestLanguagePackage;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.ParameterizedPropertyAccessExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.RelationalExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.ShiftExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.parameterizedExpressionsTestLanguage.YieldExpression;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.ParameterizedExpressionsTestLanguageGrammarAccess;

@SuppressWarnings("all")
public class ParameterizedExpressionsTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ParameterizedExpressionsTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ParameterizedExpressionsTestLanguagePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ParameterizedExpressionsTestLanguagePackage.ASSIGNMENT_EXPRESSION:
				sequence_AssignmentExpression(context, (AssignmentExpression) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.BLOCK:
				sequence_Block(context, (Block) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.COMMA_EXPRESSION:
				sequence_Expression(context, (CommaExpression) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.EXPRESSION_STATEMENT:
				sequence_ExpressionStatement(context, (ExpressionStatement) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.FUNCTION_DECLARATION:
				sequence_FunctionBody_FunctionDeclaration_FunctionHeader_FunctionImpl(context, (FunctionDeclaration) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.IDENTIFIER_REF:
				sequence_IdentifierRef(context, (IdentifierRef) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.INDEXED_ACCESS_EXPRESSION:
				sequence_IndexedAccessExpressionTail_MemberExpression(context, (IndexedAccessExpression) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.LABELLED_STATEMENT:
				sequence_LabelledStatement(context, (LabelledStatement) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION:
				sequence_MemberExpression_ParameterizedPropertyAccessExpressionTail(context, (ParameterizedPropertyAccessExpression) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.RELATIONAL_EXPRESSION:
				sequence_RelationalExpression(context, (RelationalExpression) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.SHIFT_EXPRESSION:
				sequence_ShiftExpression(context, (ShiftExpression) semanticObject); 
				return; 
			case ParameterizedExpressionsTestLanguagePackage.YIELD_EXPRESSION:
				sequence_YieldExpression(context, (YieldExpression) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     AssignmentExpression<In,Yield> returns AssignmentExpression
	 *     AssignmentExpression<In> returns AssignmentExpression
	 *     AssignmentExpression<Yield> returns AssignmentExpression
	 *     AssignmentExpression returns AssignmentExpression
	 *     Expression<In,Yield> returns AssignmentExpression
	 *     Expression<In> returns AssignmentExpression
	 *     Expression<Yield> returns AssignmentExpression
	 *     Expression returns AssignmentExpression
	 *     Expression.CommaExpression_1_0<In,Yield> returns AssignmentExpression
	 *     Expression.CommaExpression_1_0<In> returns AssignmentExpression
	 *     Expression.CommaExpression_1_0<Yield> returns AssignmentExpression
	 *     Expression.CommaExpression_1_0 returns AssignmentExpression
	 *
	 * Constraint:
	 *     (lhs=AssignmentExpression_AssignmentExpression_1_1_0_0_0 op='=' rhs=AssignmentExpression)
	 * </pre>
	 */
	protected void sequence_AssignmentExpression(ISerializationContext context, AssignmentExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.ASSIGNMENT_EXPRESSION__LHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.ASSIGNMENT_EXPRESSION__LHS));
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.ASSIGNMENT_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.ASSIGNMENT_EXPRESSION__OP));
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.ASSIGNMENT_EXPRESSION__RHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.ASSIGNMENT_EXPRESSION__RHS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionLhsAction_1_1_0_0_0(), semanticObject.getLhs());
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getOpEqualsSignKeyword_1_1_0_0_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getAssignmentExpressionAccess().getRhsAssignmentExpressionParserRuleCall_1_1_1_0(), semanticObject.getRhs());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RootStatement<Yield> returns Block
	 *     RootStatement returns Block
	 *     Block<Yield> returns Block
	 *     Block returns Block
	 *     Statement<Yield> returns Block
	 *     Statement returns Block
	 *
	 * Constraint:
	 *     statements+=Statement*
	 * </pre>
	 */
	protected void sequence_Block(ISerializationContext context, Block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RootStatement<Yield> returns ExpressionStatement
	 *     RootStatement returns ExpressionStatement
	 *     Statement<Yield> returns ExpressionStatement
	 *     Statement returns ExpressionStatement
	 *     ExpressionStatement<Yield> returns ExpressionStatement
	 *     ExpressionStatement returns ExpressionStatement
	 *
	 * Constraint:
	 *     expression=Expression
	 * </pre>
	 */
	protected void sequence_ExpressionStatement(ISerializationContext context, ExpressionStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.EXPRESSION_STATEMENT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.EXPRESSION_STATEMENT__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression<In,Yield> returns CommaExpression
	 *     Expression<In> returns CommaExpression
	 *     Expression<Yield> returns CommaExpression
	 *     Expression returns CommaExpression
	 *
	 * Constraint:
	 *     (exprs+=Expression_CommaExpression_1_0 exprs+=AssignmentExpression exprs+=AssignmentExpression*)
	 * </pre>
	 */
	protected void sequence_Expression(ISerializationContext context, CommaExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RootStatement<Yield> returns FunctionDeclaration
	 *     RootStatement returns FunctionDeclaration
	 *     FunctionDeclaration<Yield> returns FunctionDeclaration
	 *     FunctionDeclaration returns FunctionDeclaration
	 *     Statement<Yield> returns FunctionDeclaration
	 *     Statement returns FunctionDeclaration
	 *
	 * Constraint:
	 *     (generator?='*'? name=Identifier? body=Block?)
	 * </pre>
	 */
	protected void sequence_FunctionBody_FunctionDeclaration_FunctionHeader_FunctionImpl(ISerializationContext context, FunctionDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     PrimaryExpression<Yield> returns IdentifierRef
	 *     PrimaryExpression returns IdentifierRef
	 *     IdentifierRef<Yield> returns IdentifierRef
	 *     IdentifierRef returns IdentifierRef
	 *     MemberExpression<Yield> returns IdentifierRef
	 *     MemberExpression returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Yield> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<ShiftExpression.Yield> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<RelationalExpression.In> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<RelationalExpression.Yield> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<RelationalExpression.In,RelationalExpression.Yield> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<AssignmentExpression.In> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<AssignmentExpression.Yield> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Expression.In> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Expression.Yield> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Expression.In,Expression.Yield> returns IdentifierRef
	 *     MemberExpression.IndexedAccessExpression_1_0_0 returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Yield> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<ShiftExpression.Yield> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<RelationalExpression.In> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<RelationalExpression.Yield> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<RelationalExpression.In,RelationalExpression.Yield> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<AssignmentExpression.In> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<AssignmentExpression.Yield> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<AssignmentExpression.In,AssignmentExpression.Yield> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Expression.In> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Expression.Yield> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Expression.In,Expression.Yield> returns IdentifierRef
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0 returns IdentifierRef
	 *     ShiftExpression<Yield> returns IdentifierRef
	 *     ShiftExpression returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<Yield> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.In> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.Yield> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.In,RelationalExpression.Yield> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.In> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.Yield> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.In> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.Yield> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.In,Expression.Yield> returns IdentifierRef
	 *     ShiftExpression.ShiftExpression_1_0_0 returns IdentifierRef
	 *     RelationalExpression<In,Yield> returns IdentifierRef
	 *     RelationalExpression<In> returns IdentifierRef
	 *     RelationalExpression<Yield> returns IdentifierRef
	 *     RelationalExpression returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0<In,Yield> returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0<In> returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0<Yield> returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In> returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.Yield> returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In> returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.Yield> returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In,Expression.Yield> returns IdentifierRef
	 *     RelationalExpression.RelationalExpression_1_0_0 returns IdentifierRef
	 *     AssignmentExpression<In,Yield> returns IdentifierRef
	 *     AssignmentExpression<In> returns IdentifierRef
	 *     AssignmentExpression<Yield> returns IdentifierRef
	 *     AssignmentExpression returns IdentifierRef
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In,Yield> returns IdentifierRef
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In> returns IdentifierRef
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Yield> returns IdentifierRef
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In> returns IdentifierRef
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.Yield> returns IdentifierRef
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In,Expression.Yield> returns IdentifierRef
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0 returns IdentifierRef
	 *     Expression<In,Yield> returns IdentifierRef
	 *     Expression<In> returns IdentifierRef
	 *     Expression<Yield> returns IdentifierRef
	 *     Expression returns IdentifierRef
	 *     Expression.CommaExpression_1_0<In,Yield> returns IdentifierRef
	 *     Expression.CommaExpression_1_0<In> returns IdentifierRef
	 *     Expression.CommaExpression_1_0<Yield> returns IdentifierRef
	 *     Expression.CommaExpression_1_0 returns IdentifierRef
	 *
	 * Constraint:
	 *     id=Identifier
	 * </pre>
	 */
	protected void sequence_IdentifierRef(ISerializationContext context, IdentifierRef semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.IDENTIFIER_REF__ID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.IDENTIFIER_REF__ID));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIdentifierRefAccess().getIdIdentifierParserRuleCall_0(), semanticObject.getId());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MemberExpression<Yield> returns IndexedAccessExpression
	 *     MemberExpression returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Yield> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<ShiftExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<RelationalExpression.In> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<RelationalExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<RelationalExpression.In,RelationalExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<AssignmentExpression.In> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<AssignmentExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Expression.In> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Expression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Expression.In,Expression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0 returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Yield> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<ShiftExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<RelationalExpression.In> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<RelationalExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<RelationalExpression.In,RelationalExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<AssignmentExpression.In> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<AssignmentExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<AssignmentExpression.In,AssignmentExpression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Expression.In> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Expression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Expression.In,Expression.Yield> returns IndexedAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0 returns IndexedAccessExpression
	 *     ShiftExpression<Yield> returns IndexedAccessExpression
	 *     ShiftExpression returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Yield> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.In> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.Yield> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.In,RelationalExpression.Yield> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.In> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.Yield> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.In> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.Yield> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.In,Expression.Yield> returns IndexedAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0 returns IndexedAccessExpression
	 *     RelationalExpression<In,Yield> returns IndexedAccessExpression
	 *     RelationalExpression<In> returns IndexedAccessExpression
	 *     RelationalExpression<Yield> returns IndexedAccessExpression
	 *     RelationalExpression returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<In,Yield> returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<In> returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Yield> returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In> returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.Yield> returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In> returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.Yield> returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In,Expression.Yield> returns IndexedAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0 returns IndexedAccessExpression
	 *     AssignmentExpression<In,Yield> returns IndexedAccessExpression
	 *     AssignmentExpression<In> returns IndexedAccessExpression
	 *     AssignmentExpression<Yield> returns IndexedAccessExpression
	 *     AssignmentExpression returns IndexedAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In,Yield> returns IndexedAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In> returns IndexedAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Yield> returns IndexedAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In> returns IndexedAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.Yield> returns IndexedAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In,Expression.Yield> returns IndexedAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0 returns IndexedAccessExpression
	 *     Expression<In,Yield> returns IndexedAccessExpression
	 *     Expression<In> returns IndexedAccessExpression
	 *     Expression<Yield> returns IndexedAccessExpression
	 *     Expression returns IndexedAccessExpression
	 *     Expression.CommaExpression_1_0<In,Yield> returns IndexedAccessExpression
	 *     Expression.CommaExpression_1_0<In> returns IndexedAccessExpression
	 *     Expression.CommaExpression_1_0<Yield> returns IndexedAccessExpression
	 *     Expression.CommaExpression_1_0 returns IndexedAccessExpression
	 *
	 * Constraint:
	 *     (target=MemberExpression_IndexedAccessExpression_1_0_0 index=Expression)
	 * </pre>
	 */
	protected void sequence_IndexedAccessExpressionTail_MemberExpression(ISerializationContext context, IndexedAccessExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.INDEXED_ACCESS_EXPRESSION__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.INDEXED_ACCESS_EXPRESSION__TARGET));
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.INDEXED_ACCESS_EXPRESSION__INDEX) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.INDEXED_ACCESS_EXPRESSION__INDEX));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMemberExpressionAccess().getIndexedAccessExpressionTargetAction_1_0_0(), semanticObject.getTarget());
		feeder.accept(grammarAccess.getIndexedAccessExpressionTailAccess().getIndexExpressionParserRuleCall_1_0(), semanticObject.getIndex());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RootStatement<Yield> returns LabelledStatement
	 *     RootStatement returns LabelledStatement
	 *     Statement<Yield> returns LabelledStatement
	 *     Statement returns LabelledStatement
	 *     LabelledStatement<Yield> returns LabelledStatement
	 *     LabelledStatement returns LabelledStatement
	 *
	 * Constraint:
	 *     (name=Identifier statement=Statement)
	 * </pre>
	 */
	protected void sequence_LabelledStatement(ISerializationContext context, LabelledStatement semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.LABELLED_STATEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.LABELLED_STATEMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.LABELLED_STATEMENT__STATEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.LABELLED_STATEMENT__STATEMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLabelledStatementAccess().getNameIdentifierParserRuleCall_0_0_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getLabelledStatementAccess().getStatementStatementParserRuleCall_1_0(), semanticObject.getStatement());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     MemberExpression<Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<ShiftExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<RelationalExpression.In> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<RelationalExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<RelationalExpression.In,RelationalExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<AssignmentExpression.In> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<AssignmentExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Expression.In> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0<Expression.In,Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.IndexedAccessExpression_1_0_0 returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<ShiftExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<RelationalExpression.In> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<RelationalExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<RelationalExpression.In,RelationalExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<AssignmentExpression.In> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<AssignmentExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<AssignmentExpression.In,AssignmentExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Expression.In> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0<Expression.In,Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     MemberExpression.ParameterizedPropertyAccessExpression_1_1_0 returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression<Yield> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Yield> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.In> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.In,RelationalExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.In> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.In> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.In,Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     ShiftExpression.ShiftExpression_1_0_0 returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression<In,Yield> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression<In> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression<Yield> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<In,Yield> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<In> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Yield> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In,Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     RelationalExpression.RelationalExpression_1_0_0 returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression<In,Yield> returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression<In> returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression<Yield> returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In,Yield> returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In> returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Yield> returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In> returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In,Expression.Yield> returns ParameterizedPropertyAccessExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0 returns ParameterizedPropertyAccessExpression
	 *     Expression<In,Yield> returns ParameterizedPropertyAccessExpression
	 *     Expression<In> returns ParameterizedPropertyAccessExpression
	 *     Expression<Yield> returns ParameterizedPropertyAccessExpression
	 *     Expression returns ParameterizedPropertyAccessExpression
	 *     Expression.CommaExpression_1_0<In,Yield> returns ParameterizedPropertyAccessExpression
	 *     Expression.CommaExpression_1_0<In> returns ParameterizedPropertyAccessExpression
	 *     Expression.CommaExpression_1_0<Yield> returns ParameterizedPropertyAccessExpression
	 *     Expression.CommaExpression_1_0 returns ParameterizedPropertyAccessExpression
	 *
	 * Constraint:
	 *     (target=MemberExpression_ParameterizedPropertyAccessExpression_1_1_0 property=Identifier)
	 * </pre>
	 */
	protected void sequence_MemberExpression_ParameterizedPropertyAccessExpressionTail(ISerializationContext context, ParameterizedPropertyAccessExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION__TARGET));
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION__PROPERTY));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMemberExpressionAccess().getParameterizedPropertyAccessExpressionTargetAction_1_1_0(), semanticObject.getTarget());
		feeder.accept(grammarAccess.getParameterizedPropertyAccessExpressionTailAccess().getPropertyIdentifierParserRuleCall_1_0(), semanticObject.getProperty());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RelationalExpression<In,Yield> returns RelationalExpression
	 *     RelationalExpression<In> returns RelationalExpression
	 *     RelationalExpression<Yield> returns RelationalExpression
	 *     RelationalExpression returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<In,Yield> returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<In> returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Yield> returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In> returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.Yield> returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In> returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.Yield> returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In,Expression.Yield> returns RelationalExpression
	 *     RelationalExpression.RelationalExpression_1_0_0 returns RelationalExpression
	 *     AssignmentExpression<In,Yield> returns RelationalExpression
	 *     AssignmentExpression<In> returns RelationalExpression
	 *     AssignmentExpression<Yield> returns RelationalExpression
	 *     AssignmentExpression returns RelationalExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In,Yield> returns RelationalExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In> returns RelationalExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Yield> returns RelationalExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In> returns RelationalExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.Yield> returns RelationalExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In,Expression.Yield> returns RelationalExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0 returns RelationalExpression
	 *     Expression<In,Yield> returns RelationalExpression
	 *     Expression<In> returns RelationalExpression
	 *     Expression<Yield> returns RelationalExpression
	 *     Expression returns RelationalExpression
	 *     Expression.CommaExpression_1_0<In,Yield> returns RelationalExpression
	 *     Expression.CommaExpression_1_0<In> returns RelationalExpression
	 *     Expression.CommaExpression_1_0<Yield> returns RelationalExpression
	 *     Expression.CommaExpression_1_0 returns RelationalExpression
	 *
	 * Constraint:
	 *     (lhs=RelationalExpression_RelationalExpression_1_0_0 op=RelationalOperator rhs=ShiftExpression)
	 * </pre>
	 */
	protected void sequence_RelationalExpression(ISerializationContext context, RelationalExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.RELATIONAL_EXPRESSION__LHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.RELATIONAL_EXPRESSION__LHS));
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.RELATIONAL_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.RELATIONAL_EXPRESSION__OP));
			if (transientValues.isValueTransient(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.RELATIONAL_EXPRESSION__RHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ParameterizedExpressionsTestLanguagePackage.Literals.RELATIONAL_EXPRESSION__RHS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRelationalExpressionAccess().getRelationalExpressionLhsAction_1_0_0(), semanticObject.getLhs());
		feeder.accept(grammarAccess.getRelationalExpressionAccess().getOpRelationalOperatorParserRuleCall_1_0_1_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getRelationalExpressionAccess().getRhsShiftExpressionParserRuleCall_1_0_2_0(), semanticObject.getRhs());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ShiftExpression<Yield> returns ShiftExpression
	 *     ShiftExpression returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Yield> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.In> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.Yield> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<RelationalExpression.In,RelationalExpression.Yield> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.In> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.Yield> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.In> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.Yield> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0<Expression.In,Expression.Yield> returns ShiftExpression
	 *     ShiftExpression.ShiftExpression_1_0_0 returns ShiftExpression
	 *     RelationalExpression<In,Yield> returns ShiftExpression
	 *     RelationalExpression<In> returns ShiftExpression
	 *     RelationalExpression<Yield> returns ShiftExpression
	 *     RelationalExpression returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<In,Yield> returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<In> returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Yield> returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In> returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.Yield> returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<AssignmentExpression.In,AssignmentExpression.Yield> returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In> returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.Yield> returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0<Expression.In,Expression.Yield> returns ShiftExpression
	 *     RelationalExpression.RelationalExpression_1_0_0 returns ShiftExpression
	 *     AssignmentExpression<In,Yield> returns ShiftExpression
	 *     AssignmentExpression<In> returns ShiftExpression
	 *     AssignmentExpression<Yield> returns ShiftExpression
	 *     AssignmentExpression returns ShiftExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In,Yield> returns ShiftExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<In> returns ShiftExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Yield> returns ShiftExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In> returns ShiftExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.Yield> returns ShiftExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0<Expression.In,Expression.Yield> returns ShiftExpression
	 *     AssignmentExpression.AssignmentExpression_1_1_0_0_0 returns ShiftExpression
	 *     Expression<In,Yield> returns ShiftExpression
	 *     Expression<In> returns ShiftExpression
	 *     Expression<Yield> returns ShiftExpression
	 *     Expression returns ShiftExpression
	 *     Expression.CommaExpression_1_0<In,Yield> returns ShiftExpression
	 *     Expression.CommaExpression_1_0<In> returns ShiftExpression
	 *     Expression.CommaExpression_1_0<Yield> returns ShiftExpression
	 *     Expression.CommaExpression_1_0 returns ShiftExpression
	 *
	 * Constraint:
	 *     (lhs=ShiftExpression_ShiftExpression_1_0_0 (op='&gt;&gt;' | op='&lt;&lt;') rhs=MemberExpression)
	 * </pre>
	 */
	protected void sequence_ShiftExpression(ISerializationContext context, ShiftExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     AssignmentExpression<In,Yield> returns YieldExpression
	 *     AssignmentExpression<Yield> returns YieldExpression
	 *     YieldExpression<In> returns YieldExpression
	 *     YieldExpression returns YieldExpression
	 *     Expression<In,Yield> returns YieldExpression
	 *     Expression<Yield> returns YieldExpression
	 *     Expression.CommaExpression_1_0<In,Yield> returns YieldExpression
	 *     Expression.CommaExpression_1_0<In> returns YieldExpression
	 *     Expression.CommaExpression_1_0<Yield> returns YieldExpression
	 *     Expression.CommaExpression_1_0 returns YieldExpression
	 *
	 * Constraint:
	 *     (many?='*'? expression=AssignmentExpression?)
	 * </pre>
	 */
	protected void sequence_YieldExpression(ISerializationContext context, YieldExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
