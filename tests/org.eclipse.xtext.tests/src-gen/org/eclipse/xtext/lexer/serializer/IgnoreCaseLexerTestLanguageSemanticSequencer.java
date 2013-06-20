package org.eclipse.xtext.lexer.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.lexer.ignoreCaseTestLanguage.IgnoreCaseTestLanguagePackage;
import org.eclipse.xtext.lexer.ignoreCaseTestLanguage.Model;
import org.eclipse.xtext.lexer.services.IgnoreCaseLexerTestLanguageGrammarAccess;
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
public class IgnoreCaseLexerTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private IgnoreCaseLexerTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == IgnoreCaseTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case IgnoreCaseTestLanguagePackage.MODEL:
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
	 *     value='CaSe'
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, IgnoreCaseTestLanguagePackage.Literals.MODEL__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, IgnoreCaseTestLanguagePackage.Literals.MODEL__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModelAccess().getValueCaSeKeyword_2_0(), semanticObject.getValue());
		feeder.finish();
	}
}
