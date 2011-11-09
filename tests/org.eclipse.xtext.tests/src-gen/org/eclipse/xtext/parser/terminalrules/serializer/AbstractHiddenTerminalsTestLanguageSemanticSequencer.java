package org.eclipse.xtext.parser.terminalrules.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.DatatypeHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HidingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.InheritingHiddensCall;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.OverridingHiddensCall;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithHiddens;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.WithoutHiddens;
import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;
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
public class AbstractHiddenTerminalsTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected HiddenTerminalsTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == HiddenTerminalsTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case HiddenTerminalsTestLanguagePackage.DATATYPE_HIDDENS:
				if(context == grammarAccess.getDatatypeHiddensRule() ||
				   context == grammarAccess.getModelRule()) {
					sequence_DatatypeHiddens(context, (DatatypeHiddens) semanticObject); 
					return; 
				}
				else break;
			case HiddenTerminalsTestLanguagePackage.HIDING_HIDDENS:
				if(context == grammarAccess.getHidingHiddensRule()) {
					sequence_HidingHiddens(context, (HidingHiddens) semanticObject); 
					return; 
				}
				else break;
			case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS:
				if(context == grammarAccess.getInheritingHiddensRule() ||
				   context == grammarAccess.getModelRule()) {
					sequence_InheritingHiddens(context, (InheritingHiddens) semanticObject); 
					return; 
				}
				else break;
			case HiddenTerminalsTestLanguagePackage.INHERITING_HIDDENS_CALL:
				if(context == grammarAccess.getInheritingHiddensCallRule()) {
					sequence_InheritingHiddensCall(context, (InheritingHiddensCall) semanticObject); 
					return; 
				}
				else break;
			case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS:
				if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getOverridingHiddensRule()) {
					sequence_OverridingHiddens(context, (OverridingHiddens) semanticObject); 
					return; 
				}
				else break;
			case HiddenTerminalsTestLanguagePackage.OVERRIDING_HIDDENS_CALL:
				if(context == grammarAccess.getOverridingHiddensCallRule()) {
					sequence_OverridingHiddensCall(context, (OverridingHiddensCall) semanticObject); 
					return; 
				}
				else break;
			case HiddenTerminalsTestLanguagePackage.WITH_HIDDENS:
				if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getWithHiddensRule()) {
					sequence_WithHiddens(context, (WithHiddens) semanticObject); 
					return; 
				}
				else break;
			case HiddenTerminalsTestLanguagePackage.WITHOUT_HIDDENS:
				if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getWithoutHiddensRule()) {
					sequence_WithoutHiddens(context, (WithoutHiddens) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     valid?=DatatypeRule
	 */
	protected void sequence_DatatypeHiddens(EObject context, DatatypeHiddens semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.MODEL__VALID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.MODEL__VALID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatatypeHiddensAccess().getValidDatatypeRuleParserRuleCall_1_0(), semanticObject.isValid());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (space=WS called=InheritingHiddensCall)
	 */
	protected void sequence_HidingHiddens(EObject context, HidingHiddens semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.HIDING_HIDDENS__SPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.HIDING_HIDDENS__SPACE));
			if(transientValues.isValueTransient(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.HIDING_HIDDENS__CALLED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.HIDING_HIDDENS__CALLED));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getHidingHiddensAccess().getSpaceWSTerminalRuleCall_1_0(), semanticObject.getSpace());
		feeder.accept(grammarAccess.getHidingHiddensAccess().getCalledInheritingHiddensCallParserRuleCall_2_0(), semanticObject.getCalled());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     valid?=';'
	 */
	protected void sequence_InheritingHiddensCall(EObject context, InheritingHiddensCall semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.INHERITING_HIDDENS_CALL__VALID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.INHERITING_HIDDENS_CALL__VALID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInheritingHiddensCallAccess().getValidSemicolonKeyword_1_0(), semanticObject.isValid());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((called=InheritingHiddensCall | hidingCalled=HidingHiddens) valid?=';')
	 */
	protected void sequence_InheritingHiddens(EObject context, InheritingHiddens semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (spaces+=WS? valid?=';')
	 */
	protected void sequence_OverridingHiddensCall(EObject context, OverridingHiddensCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (called=OverridingHiddensCall valid?=';')
	 */
	protected void sequence_OverridingHiddens(EObject context, OverridingHiddens semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.MODEL__VALID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.MODEL__VALID));
			if(transientValues.isValueTransient(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.OVERRIDING_HIDDENS__CALLED) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.OVERRIDING_HIDDENS__CALLED));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOverridingHiddensAccess().getCalledOverridingHiddensCallParserRuleCall_3_0(), semanticObject.getCalled());
		feeder.accept(grammarAccess.getOverridingHiddensAccess().getValidSemicolonKeyword_5_0(), semanticObject.isValid());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     valid?=';'
	 */
	protected void sequence_WithHiddens(EObject context, WithHiddens semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.MODEL__VALID) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, HiddenTerminalsTestLanguagePackage.Literals.MODEL__VALID));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getWithHiddensAccess().getValidSemicolonKeyword_2_0(), semanticObject.isValid());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (spaces+=WS spaces+=WS? valid?=';')
	 */
	protected void sequence_WithoutHiddens(EObject context, WithoutHiddens semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
