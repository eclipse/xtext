package org.eclipse.xtext.example.fowlerdsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Command;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Event;
import org.eclipse.xtext.example.fowlerdsl.statemachine.State;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine;
import org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Transition;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractStatemachineSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected StatemachineGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == StatemachinePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case StatemachinePackage.COMMAND:
				if(context == grammarAccess.getCommandRule()) {
					sequence_Command_Command(context, (Command) semanticObject); 
					return; 
				}
				else break;
			case StatemachinePackage.EVENT:
				if(context == grammarAccess.getEventRule()) {
					sequence_Event_Event(context, (Event) semanticObject); 
					return; 
				}
				else break;
			case StatemachinePackage.STATE:
				if(context == grammarAccess.getStateRule()) {
					sequence_State_State(context, (State) semanticObject); 
					return; 
				}
				else break;
			case StatemachinePackage.STATEMACHINE:
				if(context == grammarAccess.getStatemachineRule()) {
					sequence_Statemachine_Statemachine(context, (Statemachine) semanticObject); 
					return; 
				}
				else break;
			case StatemachinePackage.TRANSITION:
				if(context == grammarAccess.getTransitionRule()) {
					sequence_Transition_Transition(context, (Transition) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID code=ID)
	 *
	 * Features:
	 *    name[1, 1]
	 *    code[1, 1]
	 */
	protected void sequence_Command_Command(EObject context, Command semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.COMMAND__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.COMMAND__NAME));
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.COMMAND__CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.COMMAND__CODE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCommandAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getCommandAccess().getCodeIDTerminalRuleCall_1_0(), semanticObject.getCode());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID code=ID)
	 *
	 * Features:
	 *    name[1, 1]
	 *    code[1, 1]
	 */
	protected void sequence_Event_Event(EObject context, Event semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.EVENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.EVENT__NAME));
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.EVENT__CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.EVENT__CODE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getEventAccess().getCodeIDTerminalRuleCall_1_0(), semanticObject.getCode());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID actions+=[Command|ID]* transitions+=Transition*)
	 *
	 * Features:
	 *    name[1, 1]
	 *    actions[0, *]
	 *    transitions[0, *]
	 */
	protected void sequence_State_State(EObject context, State semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (events+=Event* resetEvents+=[Event|ID]* commands+=Command* states+=State*)
	 *
	 * Features:
	 *    events[0, *]
	 *    resetEvents[0, *]
	 *    commands[0, *]
	 *    states[0, *]
	 */
	protected void sequence_Statemachine_Statemachine(EObject context, Statemachine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (event=[Event|ID] state=[State|ID])
	 *
	 * Features:
	 *    event[1, 1]
	 *    state[1, 1]
	 */
	protected void sequence_Transition_Transition(EObject context, Transition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.TRANSITION__EVENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.TRANSITION__EVENT));
			if(transientValues.isValueTransient(semanticObject, StatemachinePackage.Literals.TRANSITION__STATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, StatemachinePackage.Literals.TRANSITION__STATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTransitionAccess().getEventEventIDTerminalRuleCall_0_0_1(), semanticObject.getEvent());
		feeder.accept(grammarAccess.getTransitionAccess().getStateStateIDTerminalRuleCall_2_0_1(), semanticObject.getState());
		feeder.finish();
	}
}
