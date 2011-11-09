package org.eclipse.xtext.xtext.ecoreInference.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.MultiValueFeatureTestLanguagePackage;
import org.eclipse.xtext.xtext.ecoreInference.multiValueFeatureTestLanguage.Start;
import org.eclipse.xtext.xtext.ecoreInference.services.MultiValueFeatureTestLanguageGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractMultiValueFeatureTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected MultiValueFeatureTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == MultiValueFeatureTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MultiValueFeatureTestLanguagePackage.START:
				if(context == grammarAccess.getStartRule()) {
					sequence_Start(context, (Start) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     featureA+=ID+
	 */
	protected void sequence_Start(EObject context, Start semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
