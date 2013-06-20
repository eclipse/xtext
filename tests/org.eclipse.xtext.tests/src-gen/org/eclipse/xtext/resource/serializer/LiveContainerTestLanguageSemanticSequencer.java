package org.eclipse.xtext.resource.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.liveContainerTestLanguage.LiveContainerTestLanguagePackage;
import org.eclipse.xtext.resource.liveContainerTestLanguage.Model;
import org.eclipse.xtext.resource.services.LiveContainerTestLanguageGrammarAccess;
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

@SuppressWarnings("all")
public class LiveContainerTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private LiveContainerTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == LiveContainerTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case LiveContainerTestLanguagePackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
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
	protected void sequence_Model(EObject context, Model semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, LiveContainerTestLanguagePackage.Literals.MODEL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, LiveContainerTestLanguagePackage.Literals.MODEL__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
}
