/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.example.arithmetics.arithmetics.ArithmeticsPackage;
import org.eclipse.xtext.example.arithmetics.arithmetics.DeclaredParameter;
import org.eclipse.xtext.example.arithmetics.arithmetics.Definition;
import org.eclipse.xtext.example.arithmetics.arithmetics.Div;
import org.eclipse.xtext.example.arithmetics.arithmetics.Evaluation;
import org.eclipse.xtext.example.arithmetics.arithmetics.FunctionCall;
import org.eclipse.xtext.example.arithmetics.arithmetics.Import;
import org.eclipse.xtext.example.arithmetics.arithmetics.Minus;
import org.eclipse.xtext.example.arithmetics.arithmetics.Module;
import org.eclipse.xtext.example.arithmetics.arithmetics.Multi;
import org.eclipse.xtext.example.arithmetics.arithmetics.NumberLiteral;
import org.eclipse.xtext.example.arithmetics.arithmetics.Plus;
import org.eclipse.xtext.example.arithmetics.services.ArithmeticsGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ArithmeticsSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ArithmeticsGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ArithmeticsPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ArithmeticsPackage.DECLARED_PARAMETER:
				sequence_DeclaredParameter(context, (DeclaredParameter) semanticObject); 
				return; 
			case ArithmeticsPackage.DEFINITION:
				sequence_Definition(context, (Definition) semanticObject); 
				return; 
			case ArithmeticsPackage.DIV:
				sequence_Multiplication(context, (Div) semanticObject); 
				return; 
			case ArithmeticsPackage.EVALUATION:
				sequence_Evaluation(context, (Evaluation) semanticObject); 
				return; 
			case ArithmeticsPackage.FUNCTION_CALL:
				sequence_PrimaryExpression(context, (FunctionCall) semanticObject); 
				return; 
			case ArithmeticsPackage.IMPORT:
				sequence_Import(context, (Import) semanticObject); 
				return; 
			case ArithmeticsPackage.MINUS:
				sequence_Addition(context, (Minus) semanticObject); 
				return; 
			case ArithmeticsPackage.MODULE:
				sequence_Module(context, (Module) semanticObject); 
				return; 
			case ArithmeticsPackage.MULTI:
				sequence_Multiplication(context, (Multi) semanticObject); 
				return; 
			case ArithmeticsPackage.NUMBER_LITERAL:
				sequence_PrimaryExpression(context, (NumberLiteral) semanticObject); 
				return; 
			case ArithmeticsPackage.PLUS:
				sequence_Addition(context, (Plus) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Expression returns Minus
	 *     Addition returns Minus
	 *     Addition.Plus_1_0_0_0 returns Minus
	 *     Addition.Minus_1_0_1_0 returns Minus
	 *     Multiplication returns Minus
	 *     Multiplication.Multi_1_0_0_0 returns Minus
	 *     Multiplication.Div_1_0_1_0 returns Minus
	 *     PrimaryExpression returns Minus
	 *
	 * Constraint:
	 *     (left=Addition_Minus_1_0_1_0 right=Multiplication)
	 */
	protected void sequence_Addition(ISerializationContext context, Minus semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.MINUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.MINUS__LEFT));
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.MINUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.MINUS__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAdditionAccess().getMinusLeftAction_1_0_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Plus
	 *     Addition returns Plus
	 *     Addition.Plus_1_0_0_0 returns Plus
	 *     Addition.Minus_1_0_1_0 returns Plus
	 *     Multiplication returns Plus
	 *     Multiplication.Multi_1_0_0_0 returns Plus
	 *     Multiplication.Div_1_0_1_0 returns Plus
	 *     PrimaryExpression returns Plus
	 *
	 * Constraint:
	 *     (left=Addition_Plus_1_0_0_0 right=Multiplication)
	 */
	protected void sequence_Addition(ISerializationContext context, Plus semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.PLUS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.PLUS__LEFT));
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.PLUS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.PLUS__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAdditionAccess().getPlusLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditionAccess().getRightMultiplicationParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     DeclaredParameter returns DeclaredParameter
	 *     AbstractDefinition returns DeclaredParameter
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_DeclaredParameter(ISerializationContext context, DeclaredParameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.ABSTRACT_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.ABSTRACT_DEFINITION__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDeclaredParameterAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns Definition
	 *     Definition returns Definition
	 *     AbstractDefinition returns Definition
	 *
	 * Constraint:
	 *     (name=ID (args+=DeclaredParameter args+=DeclaredParameter*)? expr=Expression)
	 */
	protected void sequence_Definition(ISerializationContext context, Definition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Statement returns Evaluation
	 *     Evaluation returns Evaluation
	 *
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_Evaluation(ISerializationContext context, Evaluation semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.EVALUATION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.EVALUATION__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEvaluationAccess().getExpressionExpressionParserRuleCall_0_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Import returns Import
	 *
	 * Constraint:
	 *     module=[Module|ID]
	 */
	protected void sequence_Import(ISerializationContext context, Import semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.IMPORT__MODULE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.IMPORT__MODULE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getImportAccess().getModuleModuleIDTerminalRuleCall_1_0_1(), semanticObject.getModule());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Module returns Module
	 *
	 * Constraint:
	 *     (name=ID imports+=Import* statements+=Statement*)
	 */
	protected void sequence_Module(ISerializationContext context, Module semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Div
	 *     Addition returns Div
	 *     Addition.Plus_1_0_0_0 returns Div
	 *     Addition.Minus_1_0_1_0 returns Div
	 *     Multiplication returns Div
	 *     Multiplication.Multi_1_0_0_0 returns Div
	 *     Multiplication.Div_1_0_1_0 returns Div
	 *     PrimaryExpression returns Div
	 *
	 * Constraint:
	 *     (left=Multiplication_Div_1_0_1_0 right=PrimaryExpression)
	 */
	protected void sequence_Multiplication(ISerializationContext context, Div semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.DIV__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.DIV__LEFT));
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.DIV__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.DIV__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMultiplicationAccess().getDivLeftAction_1_0_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns Multi
	 *     Addition returns Multi
	 *     Addition.Plus_1_0_0_0 returns Multi
	 *     Addition.Minus_1_0_1_0 returns Multi
	 *     Multiplication returns Multi
	 *     Multiplication.Multi_1_0_0_0 returns Multi
	 *     Multiplication.Div_1_0_1_0 returns Multi
	 *     PrimaryExpression returns Multi
	 *
	 * Constraint:
	 *     (left=Multiplication_Multi_1_0_0_0 right=PrimaryExpression)
	 */
	protected void sequence_Multiplication(ISerializationContext context, Multi semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.MULTI__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.MULTI__LEFT));
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.MULTI__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.MULTI__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMultiplicationAccess().getMultiLeftAction_1_0_0_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplicationAccess().getRightPrimaryExpressionParserRuleCall_1_1_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns FunctionCall
	 *     Addition returns FunctionCall
	 *     Addition.Plus_1_0_0_0 returns FunctionCall
	 *     Addition.Minus_1_0_1_0 returns FunctionCall
	 *     Multiplication returns FunctionCall
	 *     Multiplication.Multi_1_0_0_0 returns FunctionCall
	 *     Multiplication.Div_1_0_1_0 returns FunctionCall
	 *     PrimaryExpression returns FunctionCall
	 *
	 * Constraint:
	 *     (func=[AbstractDefinition|ID] (args+=Expression args+=Expression*)?)
	 */
	protected void sequence_PrimaryExpression(ISerializationContext context, FunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Expression returns NumberLiteral
	 *     Addition returns NumberLiteral
	 *     Addition.Plus_1_0_0_0 returns NumberLiteral
	 *     Addition.Minus_1_0_1_0 returns NumberLiteral
	 *     Multiplication returns NumberLiteral
	 *     Multiplication.Multi_1_0_0_0 returns NumberLiteral
	 *     Multiplication.Div_1_0_1_0 returns NumberLiteral
	 *     PrimaryExpression returns NumberLiteral
	 *
	 * Constraint:
	 *     value=NUMBER
	 */
	protected void sequence_PrimaryExpression(ISerializationContext context, NumberLiteral semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ArithmeticsPackage.Literals.NUMBER_LITERAL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArithmeticsPackage.Literals.NUMBER_LITERAL__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrimaryExpressionAccess().getValueNUMBERTerminalRuleCall_1_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
}
