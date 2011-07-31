package org.eclipse.xtext.parser.terminalrules.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.Model;
import org.eclipse.xtext.parser.terminalrules.terminalRulesTestLanguage.TerminalRulesTestLanguagePackage;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("restriction")
public class AbstractTerminalRulesTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected TerminalRulesTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == TerminalRulesTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TerminalRulesTestLanguagePackage.MODEL:
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
	 *         idValue=ID | 
	 *         intValue=INT | 
	 *         stringValue=STRING | 
	 *         richStringValue=RICH_STRING | 
	 *         mlCommentValue=ML_COMMENT | 
	 *         slCommentValue=SL_COMMENT | 
	 *         wsValue=WS | 
	 *         anyValue=ANY_OTHER
	 *     )
	 *
	 * Features:
	 *    idValue[0, 1]
	 *         EXCLUDE_IF_SET intValue
	 *         EXCLUDE_IF_SET stringValue
	 *         EXCLUDE_IF_SET richStringValue
	 *         EXCLUDE_IF_SET mlCommentValue
	 *         EXCLUDE_IF_SET slCommentValue
	 *         EXCLUDE_IF_SET wsValue
	 *         EXCLUDE_IF_SET anyValue
	 *    intValue[0, 1]
	 *         EXCLUDE_IF_SET idValue
	 *         EXCLUDE_IF_SET stringValue
	 *         EXCLUDE_IF_SET richStringValue
	 *         EXCLUDE_IF_SET mlCommentValue
	 *         EXCLUDE_IF_SET slCommentValue
	 *         EXCLUDE_IF_SET wsValue
	 *         EXCLUDE_IF_SET anyValue
	 *    stringValue[0, 1]
	 *         EXCLUDE_IF_SET idValue
	 *         EXCLUDE_IF_SET intValue
	 *         EXCLUDE_IF_SET richStringValue
	 *         EXCLUDE_IF_SET mlCommentValue
	 *         EXCLUDE_IF_SET slCommentValue
	 *         EXCLUDE_IF_SET wsValue
	 *         EXCLUDE_IF_SET anyValue
	 *    richStringValue[0, 1]
	 *         EXCLUDE_IF_SET idValue
	 *         EXCLUDE_IF_SET intValue
	 *         EXCLUDE_IF_SET stringValue
	 *         EXCLUDE_IF_SET mlCommentValue
	 *         EXCLUDE_IF_SET slCommentValue
	 *         EXCLUDE_IF_SET wsValue
	 *         EXCLUDE_IF_SET anyValue
	 *    mlCommentValue[0, 1]
	 *         EXCLUDE_IF_SET idValue
	 *         EXCLUDE_IF_SET intValue
	 *         EXCLUDE_IF_SET stringValue
	 *         EXCLUDE_IF_SET richStringValue
	 *         EXCLUDE_IF_SET slCommentValue
	 *         EXCLUDE_IF_SET wsValue
	 *         EXCLUDE_IF_SET anyValue
	 *    slCommentValue[0, 1]
	 *         EXCLUDE_IF_SET idValue
	 *         EXCLUDE_IF_SET intValue
	 *         EXCLUDE_IF_SET stringValue
	 *         EXCLUDE_IF_SET richStringValue
	 *         EXCLUDE_IF_SET mlCommentValue
	 *         EXCLUDE_IF_SET wsValue
	 *         EXCLUDE_IF_SET anyValue
	 *    wsValue[0, 1]
	 *         EXCLUDE_IF_SET idValue
	 *         EXCLUDE_IF_SET intValue
	 *         EXCLUDE_IF_SET stringValue
	 *         EXCLUDE_IF_SET richStringValue
	 *         EXCLUDE_IF_SET mlCommentValue
	 *         EXCLUDE_IF_SET slCommentValue
	 *         EXCLUDE_IF_SET anyValue
	 *    anyValue[0, 1]
	 *         EXCLUDE_IF_SET idValue
	 *         EXCLUDE_IF_SET intValue
	 *         EXCLUDE_IF_SET stringValue
	 *         EXCLUDE_IF_SET richStringValue
	 *         EXCLUDE_IF_SET mlCommentValue
	 *         EXCLUDE_IF_SET slCommentValue
	 *         EXCLUDE_IF_SET wsValue
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
