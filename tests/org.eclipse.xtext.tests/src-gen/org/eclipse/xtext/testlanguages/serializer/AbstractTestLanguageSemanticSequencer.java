package org.eclipse.xtext.testlanguages.serializer;

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
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.testLang.ChoiceElement;
import org.eclipse.xtext.testlanguages.testLang.Model;
import org.eclipse.xtext.testlanguages.testLang.ReducibleComposite;
import org.eclipse.xtext.testlanguages.testLang.TerminalElement;
import org.eclipse.xtext.testlanguages.testLang.TestLangPackage;

@SuppressWarnings("restriction")
public class AbstractTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected TestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == TestLangPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TestLangPackage.CHOICE_ELEMENT:
				if(context == grammarAccess.getAbstractRuleRule() ||
				   context == grammarAccess.getChoiceRuleRule()) {
					sequence_ChoiceRule(context, (ChoiceElement) semanticObject); 
					return; 
				}
				else break;
			case TestLangPackage.MODEL:
				if(context == grammarAccess.getEntryRuleRule()) {
					sequence_EntryRule(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case TestLangPackage.REDUCIBLE_COMPOSITE:
				if(context == grammarAccess.getAbstractRuleRule() ||
				   context == grammarAccess.getReducibleRuleRule()) {
					sequence_ReducibleRule(context, (ReducibleComposite) semanticObject); 
					return; 
				}
				else break;
			case TestLangPackage.TERMINAL_ELEMENT:
				if(context == grammarAccess.getAbstractRuleRule() ||
				   context == grammarAccess.getReducibleRuleRule() ||
				   context == grammarAccess.getReducibleRuleAccess().getReducibleCompositeActionFeatureAction_2_0() ||
				   context == grammarAccess.getTerminalRuleRule()) {
					sequence_TerminalRule(context, (TerminalElement) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (optionalKeyword?='optional'? name=ID)
	 */
	protected void sequence_ChoiceRule(EObject context, ChoiceElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     multiFeature+=AbstractRule*
	 */
	protected void sequence_EntryRule(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (actionFeature+=ReducibleRule_ReducibleComposite_2_0 actionFeature+=TerminalRule)
	 */
	protected void sequence_ReducibleRule(EObject context, ReducibleComposite semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     stringFeature=STRING
	 */
	protected void sequence_TerminalRule(EObject context, TerminalElement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TestLangPackage.Literals.TERMINAL_ELEMENT__STRING_FEATURE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TestLangPackage.Literals.TERMINAL_ELEMENT__STRING_FEATURE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTerminalRuleAccess().getStringFeatureSTRINGTerminalRuleCall_0(), semanticObject.getStringFeature());
		feeder.finish();
	}
}
