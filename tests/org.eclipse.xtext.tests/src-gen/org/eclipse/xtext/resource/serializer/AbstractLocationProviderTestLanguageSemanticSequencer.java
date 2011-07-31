package org.eclipse.xtext.resource.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.locationprovidertest.Element;
import org.eclipse.xtext.resource.locationprovidertest.LocationprovidertestPackage;
import org.eclipse.xtext.resource.locationprovidertest.Model;
import org.eclipse.xtext.resource.services.LocationProviderTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("restriction")
public class AbstractLocationProviderTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected LocationProviderTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == LocationprovidertestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case LocationprovidertestPackage.ELEMENT:
				if(context == grammarAccess.getElementRule()) {
					sequence_Element(context, (Element) semanticObject); 
					return; 
				}
				else break;
			case LocationprovidertestPackage.MODEL:
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
	 *     (name=ID singleref=[Element|ID]? multirefs+=[Element|ID]*)
	 *
	 * Features:
	 *    name[1, 1]
	 *    singleref[0, 1]
	 *    multirefs[0, *]
	 */
	protected void sequence_Element(EObject context, Element semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     elements+=Element*
	 *
	 * Features:
	 *    elements[0, *]
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
