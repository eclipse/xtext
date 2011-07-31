package org.eclipse.xtext.parser.keywords.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.keywords.keywordsTestLanguage.KeywordsTestLanguagePackage;
import org.eclipse.xtext.parser.keywords.keywordsTestLanguage.Model;
import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("restriction")
public class AbstractKeywordsTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected KeywordsTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == KeywordsTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case KeywordsTestLanguagePackage.MODEL:
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
	 *     (
	 *         first?='foo\bar' | 
	 *         second?='foo\' | 
	 *         third?='\bar' | 
	 *         forth?='\' | 
	 *         fifth?='"a"' | 
	 *         sixth?=''b'' | 
	 *         seventh?=''c'' | 
	 *         eighth?='"d"'
	 *     )
	 *
	 * Features:
	 *    first[0, 1]
	 *         EXCLUDE_IF_SET second
	 *         EXCLUDE_IF_SET third
	 *         EXCLUDE_IF_SET forth
	 *         EXCLUDE_IF_SET fifth
	 *         EXCLUDE_IF_SET sixth
	 *         EXCLUDE_IF_SET seventh
	 *         EXCLUDE_IF_SET eighth
	 *    second[0, 1]
	 *         EXCLUDE_IF_SET first
	 *         EXCLUDE_IF_SET third
	 *         EXCLUDE_IF_SET forth
	 *         EXCLUDE_IF_SET fifth
	 *         EXCLUDE_IF_SET sixth
	 *         EXCLUDE_IF_SET seventh
	 *         EXCLUDE_IF_SET eighth
	 *    third[0, 1]
	 *         EXCLUDE_IF_SET first
	 *         EXCLUDE_IF_SET second
	 *         EXCLUDE_IF_SET forth
	 *         EXCLUDE_IF_SET fifth
	 *         EXCLUDE_IF_SET sixth
	 *         EXCLUDE_IF_SET seventh
	 *         EXCLUDE_IF_SET eighth
	 *    forth[0, 1]
	 *         EXCLUDE_IF_SET first
	 *         EXCLUDE_IF_SET second
	 *         EXCLUDE_IF_SET third
	 *         EXCLUDE_IF_SET fifth
	 *         EXCLUDE_IF_SET sixth
	 *         EXCLUDE_IF_SET seventh
	 *         EXCLUDE_IF_SET eighth
	 *    fifth[0, 1]
	 *         EXCLUDE_IF_SET first
	 *         EXCLUDE_IF_SET second
	 *         EXCLUDE_IF_SET third
	 *         EXCLUDE_IF_SET forth
	 *         EXCLUDE_IF_SET sixth
	 *         EXCLUDE_IF_SET seventh
	 *         EXCLUDE_IF_SET eighth
	 *    sixth[0, 1]
	 *         EXCLUDE_IF_SET first
	 *         EXCLUDE_IF_SET second
	 *         EXCLUDE_IF_SET third
	 *         EXCLUDE_IF_SET forth
	 *         EXCLUDE_IF_SET fifth
	 *         EXCLUDE_IF_SET seventh
	 *         EXCLUDE_IF_SET eighth
	 *    seventh[0, 1]
	 *         EXCLUDE_IF_SET first
	 *         EXCLUDE_IF_SET second
	 *         EXCLUDE_IF_SET third
	 *         EXCLUDE_IF_SET forth
	 *         EXCLUDE_IF_SET fifth
	 *         EXCLUDE_IF_SET sixth
	 *         EXCLUDE_IF_SET eighth
	 *    eighth[0, 1]
	 *         EXCLUDE_IF_SET first
	 *         EXCLUDE_IF_SET second
	 *         EXCLUDE_IF_SET third
	 *         EXCLUDE_IF_SET forth
	 *         EXCLUDE_IF_SET fifth
	 *         EXCLUDE_IF_SET sixth
	 *         EXCLUDE_IF_SET seventh
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
