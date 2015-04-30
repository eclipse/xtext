/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Condition;
import org.eclipse.xtext.web.example.statemachine.statemachine.Event;
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
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
		if(semanticObject.eClass().getEPackage() == StatemachinePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case StatemachinePackage.COMMAND:
				sequence_Command(context, (Command) semanticObject); 
				return; 
			case StatemachinePackage.CONDITION:
				sequence_Condition(context, (Condition) semanticObject); 
				return; 
			case StatemachinePackage.EVENT:
				sequence_Event(context, (Event) semanticObject); 
				return; 
			case StatemachinePackage.SIGNAL:
				sequence_Signal(context, (Signal) semanticObject); 
				return; 
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
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (signal=[Signal|ID] newState=BOOLEAN)
	 */
	protected void sequence_Command(EObject context, Command semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.COMMAND__SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.COMMAND__SIGNAL));
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.COMMAND__NEW_STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.COMMAND__NEW_STATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCommandAccess().getSignalSignalIDTerminalRuleCall_1_0_1(), semanticObject.getSignal());
		feeder.accept(grammarAccess.getCommandAccess().getNewStateBOOLEANTerminalRuleCall_3_0(), semanticObject.isNewState());
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
	 *     (signal=[Signal|ID] state=BOOLEAN)
	 */
	protected void sequence_Event(EObject context, Event semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.EVENT__SIGNAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.EVENT__SIGNAL));
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.EVENT__STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.EVENT__STATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEventAccess().getSignalSignalIDTerminalRuleCall_0_0_1(), semanticObject.getSignal());
		feeder.accept(grammarAccess.getEventAccess().getStateBOOLEANTerminalRuleCall_2_0(), semanticObject.isState());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Signal(EObject context, Signal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.SIGNAL__NAME) == ValueTransient.YES)
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
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.TRANSITION__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.TRANSITION__CONDITION));
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.TRANSITION__STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.TRANSITION__STATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTransitionAccess().getConditionConditionParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_3_0_1(), semanticObject.getState());
		feeder.finish();
	}
}
