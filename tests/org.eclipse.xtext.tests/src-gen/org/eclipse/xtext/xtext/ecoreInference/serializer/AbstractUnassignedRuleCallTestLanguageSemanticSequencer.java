package org.eclipse.xtext.xtext.ecoreInference.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.xtext.ecoreInference.services.UnassignedRuleCallTestLanguageGrammarAccess;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.Model;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.ModelFeatures;
import org.eclipse.xtext.xtext.ecoreInference.unassignedRuleCallTestLanguage.UnassignedRuleCallTestLanguagePackage;

@SuppressWarnings("restriction")
public class AbstractUnassignedRuleCallTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected UnassignedRuleCallTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == UnassignedRuleCallTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UnassignedRuleCallTestLanguagePackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case UnassignedRuleCallTestLanguagePackage.MODEL_FEATURES:
				if(context == grammarAccess.getModelFeaturesRule()) {
					sequence_ModelFeatures(context, (ModelFeatures) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_ModelFeatures(EObject context, ModelFeatures semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UnassignedRuleCallTestLanguagePackage.Literals.MODEL_FEATURES__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnassignedRuleCallTestLanguagePackage.Literals.MODEL_FEATURES__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModelFeaturesAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     modelFeatures=ModelFeatures
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UnassignedRuleCallTestLanguagePackage.Literals.MODEL__MODEL_FEATURES) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnassignedRuleCallTestLanguagePackage.Literals.MODEL__MODEL_FEATURES));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModelAccess().getModelFeaturesModelFeaturesParserRuleCall_2_0(), semanticObject.getModelFeatures());
		feeder.finish();
	}
}
