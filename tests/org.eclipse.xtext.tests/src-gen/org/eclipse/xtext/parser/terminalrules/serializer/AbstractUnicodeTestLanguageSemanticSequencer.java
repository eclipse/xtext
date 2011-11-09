package org.eclipse.xtext.parser.terminalrules.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.terminalrules.services.UnicodeTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.unicode.GString;
import org.eclipse.xtext.parser.terminalrules.unicode.Model;
import org.eclipse.xtext.parser.terminalrules.unicode.QuotedString;
import org.eclipse.xtext.parser.terminalrules.unicode.UnicodePackage;
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
public class AbstractUnicodeTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected UnicodeTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == UnicodePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UnicodePackage.GSTRING:
				if(context == grammarAccess.getAbstractStringRule() ||
				   context == grammarAccess.getGStringRule()) {
					sequence_GString(context, (GString) semanticObject); 
					return; 
				}
				else break;
			case UnicodePackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case UnicodePackage.QUOTED_STRING:
				if(context == grammarAccess.getAbstractStringRule() ||
				   context == grammarAccess.getQuotedStringRule()) {
					sequence_QuotedString(context, (QuotedString) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     name=GERMAN_STRING
	 */
	protected void sequence_GString(EObject context, GString semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UnicodePackage.Literals.ABSTRACT_STRING__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnicodePackage.Literals.ABSTRACT_STRING__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getGStringAccess().getNameGERMAN_STRINGTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     strings+=AbstractString*
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=STRING
	 */
	protected void sequence_QuotedString(EObject context, QuotedString semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UnicodePackage.Literals.ABSTRACT_STRING__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnicodePackage.Literals.ABSTRACT_STRING__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getQuotedStringAccess().getNameSTRINGTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
}
