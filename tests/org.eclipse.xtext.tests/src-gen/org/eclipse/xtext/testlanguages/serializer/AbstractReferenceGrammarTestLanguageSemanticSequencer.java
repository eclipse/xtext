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
import org.eclipse.xtext.testlanguages.referenceGrammar.Erwachsener;
import org.eclipse.xtext.testlanguages.referenceGrammar.Familie;
import org.eclipse.xtext.testlanguages.referenceGrammar.Farbe;
import org.eclipse.xtext.testlanguages.referenceGrammar.Kind;
import org.eclipse.xtext.testlanguages.referenceGrammar.ReferenceGrammarPackage;
import org.eclipse.xtext.testlanguages.referenceGrammar.Spielplatz;
import org.eclipse.xtext.testlanguages.referenceGrammar.Spielzeug;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractReferenceGrammarTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected ReferenceGrammarTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == ReferenceGrammarPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ReferenceGrammarPackage.ERWACHSENER:
				if(context == grammarAccess.getErwachsenerRule() ||
				   context == grammarAccess.getPersonRule()) {
					sequence_Erwachsener(context, (Erwachsener) semanticObject); 
					return; 
				}
				else break;
			case ReferenceGrammarPackage.FAMILIE:
				if(context == grammarAccess.getFamilieRule()) {
					sequence_Familie(context, (Familie) semanticObject); 
					return; 
				}
				else break;
			case ReferenceGrammarPackage.FARBE:
				if(context == grammarAccess.getFarbeRule()) {
					sequence_Farbe(context, (Farbe) semanticObject); 
					return; 
				}
				else break;
			case ReferenceGrammarPackage.KIND:
				if(context == grammarAccess.getKindRule() ||
				   context == grammarAccess.getPersonRule()) {
					sequence_Kind(context, (Kind) semanticObject); 
					return; 
				}
				else break;
			case ReferenceGrammarPackage.SPIELPLATZ:
				if(context == grammarAccess.getSpielplatzRule()) {
					sequence_Spielplatz(context, (Spielplatz) semanticObject); 
					return; 
				}
				else break;
			case ReferenceGrammarPackage.SPIELZEUG:
				if(context == grammarAccess.getSpielzeugRule()) {
					sequence_Spielzeug(context, (Spielzeug) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID age=INT)
	 */
	protected void sequence_Erwachsener(EObject context, Erwachsener semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReferenceGrammarPackage.Literals.PERSON__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferenceGrammarPackage.Literals.PERSON__NAME));
			if(transientValues.isValueTransient(semanticObject, ReferenceGrammarPackage.Literals.PERSON__AGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferenceGrammarPackage.Literals.PERSON__AGE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0(), semanticObject.getAge());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((name='keyword' | name=STRING | name=ID) mutter=[Erwachsener|ID] vater=[Erwachsener|ID] kinder+=[Kind|ID] kinder+=[Kind|ID]*)
	 */
	protected void sequence_Familie(EObject context, Familie semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (wert='ROT' | wert='BLAU' | wert='GELB' | wert='GRÜN')
	 */
	protected void sequence_Farbe(EObject context, Farbe semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID age=INT)
	 */
	protected void sequence_Kind(EObject context, Kind semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReferenceGrammarPackage.Literals.PERSON__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferenceGrammarPackage.Literals.PERSON__NAME));
			if(transientValues.isValueTransient(semanticObject, ReferenceGrammarPackage.Literals.PERSON__AGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferenceGrammarPackage.Literals.PERSON__AGE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getKindAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getKindAccess().getAgeINTTerminalRuleCall_3_0(), semanticObject.getAge());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (groesse=INT beschreibung=STRING? (kinder+=Kind | erzieher+=Erwachsener | spielzeuge+=Spielzeug | familie+=Familie)*)?
	 */
	protected void sequence_Spielplatz(EObject context, Spielplatz semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID farbe=Farbe)
	 */
	protected void sequence_Spielzeug(EObject context, Spielzeug semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ReferenceGrammarPackage.Literals.SPIELZEUG__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferenceGrammarPackage.Literals.SPIELZEUG__NAME));
			if(transientValues.isValueTransient(semanticObject, ReferenceGrammarPackage.Literals.SPIELZEUG__FARBE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ReferenceGrammarPackage.Literals.SPIELZEUG__FARBE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0(), semanticObject.getFarbe());
		feeder.finish();
	}
}
