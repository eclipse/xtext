package org.eclipse.xtext.parser.datatyperules.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.CompositeModel;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.Model;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("restriction")
public class AbstractDatatypeRulesTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected DatatypeRulesTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == DatatypeRulesTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case DatatypeRulesTestLanguagePackage.COMPOSITE_MODEL:
				if(context == grammarAccess.getCompositeModelRule()) {
					sequence_CompositeModel(context, (CompositeModel) semanticObject); 
					return; 
				}
				else break;
			case DatatypeRulesTestLanguagePackage.MODEL:
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
	 *     model+=Model+
	 */
	protected void sequence_CompositeModel(EObject context, CompositeModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (id=NestedModelId value=Fraction? vector=Vector? dots=Dots? double=Double?)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
