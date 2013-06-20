package org.eclipse.xtext.parser.antlr.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.bug301935Test.Bug301935TestPackage;
import org.eclipse.xtext.parser.antlr.bug301935Test.Model;
import org.eclipse.xtext.parser.antlr.serializer.Bug301935TestLanguageSemanticSequencer;
import org.eclipse.xtext.parser.antlr.services.Bug301935ExTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class Bug301935ExTestLanguageSemanticSequencer extends Bug301935TestLanguageSemanticSequencer {

	@Inject
	private Bug301935ExTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Bug301935TestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug301935TestPackage.MODEL:
				if(context == grammarAccess.getDelegateModelRule() ||
				   context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
}
