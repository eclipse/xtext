/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Condition;
import org.eclipse.xtext.web.example.statemachine.statemachine.Event;
import org.eclipse.xtext.web.example.statemachine.statemachine.InputSignal;
import org.eclipse.xtext.web.example.statemachine.statemachine.OutputSignal;
import org.eclipse.xtext.web.example.statemachine.statemachine.State;
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine;
import org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage;
import org.eclipse.xtext.web.example.statemachine.statemachine.Transition;

@SuppressWarnings("all")
public class StatemachineSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private StatemachineGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		if (epackage == StatemachinePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case StatemachinePackage.COMMAND:
				sequence_Command(context, (Command) semanticObject); 
				return; 
			case StatemachinePackage.CONDITION:
				sequence_Condition(context, (Condition) semanticObject); 
				return; 
			case StatemachinePackage.EVENT:
				sequence_Event(context, (Event) semanticObject); 
				return; 
			case StatemachinePackage.INPUT_SIGNAL:
				if (context == grammarAccess.getInputSignalRule()) {
					sequence_InputSignal(context, (InputSignal) semanticObject); 
					return; 
				}
				else if (context == grammarAccess.getSignalRule()) {
					sequence_Signal(context, (InputSignal) semanticObject); 
					return; 
				}
				else break;
			case StatemachinePackage.OUTPUT_SIGNAL:
				if (context == grammarAccess.getOutputSignalRule()) {
					sequence_OutputSignal(context, (OutputSignal) semanticObject); 
					return; 
				}
				else if (context == grammarAccess.getSignalRule()) {
					sequence_Signal(context, (OutputSignal) semanticObject); 
					return; 
				}
				else break;
			case StatemachinePackage.STATE:
				sequence_State(context, (State) semanticObject); 
				return; 
			case StatemachinePackage.STATEMACHINE:
				sequence_Statemachine(context, (Statemachine) semanticObject); 
				return; 
			case StatemachinePackage.TRANSITION:
				sequence_Transition(context, (Transition) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (signal=[Signal|ID] newValue=BOOLEAN)
	 */
	protected void sequence_Command(EObject context, Command semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.COMMAND__SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.COMMAND__SIGNAL));
			if (transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.COMMAND__NEW_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.COMMAND__NEW_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCommandAccess().getSignalSignalIDTerminalRuleCall_1_0_1(), semanticObject.getSignal());
		feeder.accept(grammarAccess.getCommandAccess().getNewValueBOOLEANTerminalRuleCall_3_0(), semanticObject.isNewValue());
		feeder.finish();
	}
	
	/**
	 * Constraint:
	 *     (events+=Event events+=Event*)
	 */
	protected void sequence_Condition(EObject context, Condition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (signal=[Signal|ID] value=BOOLEAN)
	 */
	protected void sequence_Event(EObject context, Event semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.EVENT__SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.EVENT__SIGNAL));
			if (transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.EVENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.EVENT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEventAccess().getSignalSignalIDTerminalRuleCall_0_0_1(), semanticObject.getSignal());
		feeder.accept(grammarAccess.getEventAccess().getValueBOOLEANTerminalRuleCall_2_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	/**
	 * Constraint:
	 *     {InputSignal}
	 */
	protected void sequence_InputSignal(EObject context, InputSignal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	/**
	 * Constraint:
	 *     {OutputSignal}
	 */
	protected void sequence_OutputSignal(EObject context, OutputSignal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Signal(EObject context, InputSignal semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.SIGNAL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.SIGNAL__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Signal(EObject context, OutputSignal semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.SIGNAL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.SIGNAL__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSignalAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.finish();
	}
	
	/**
	 * Constraint:
	 *     (name=ID commands+=Command* transitions+=Transition*)
	 */
	protected void sequence_State(EObject context, State semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (signals+=Signal* states+=State*)
	 */
	protected void sequence_Statemachine(EObject context, Statemachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	/**
	 * Constraint:
	 *     (condition=Condition state=[State|ID])
	 */
	protected void sequence_Transition(EObject context, Transition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.TRANSITION__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.TRANSITION__CONDITION));
			if (transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.TRANSITION__STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.TRANSITION__STATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_3_0_1(), semanticObject.getState());
		feeder.finish();
	}
	
}
