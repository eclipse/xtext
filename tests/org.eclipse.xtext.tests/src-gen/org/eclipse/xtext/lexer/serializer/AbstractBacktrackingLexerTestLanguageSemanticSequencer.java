package org.eclipse.xtext.lexer.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.Ab;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.BacktrackingTestLanguagePackage;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.Model;
import org.eclipse.xtext.lexer.backtrackingTestLanguage.Xb;
import org.eclipse.xtext.lexer.services.BacktrackingLexerTestLanguageGrammarAccess;
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
public class AbstractBacktrackingLexerTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected BacktrackingLexerTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == BacktrackingTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case BacktrackingTestLanguagePackage.AB:
				if(context == grammarAccess.getAbRule()) {
					sequence_Ab(context, (Ab) semanticObject); 
					return; 
				}
				else break;
			case BacktrackingTestLanguagePackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case BacktrackingTestLanguagePackage.XB:
				if(context == grammarAccess.getXbRule()) {
					sequence_Xb(context, (Xb) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (x=CharA y=Charb)
	 */
	protected void sequence_Ab(EObject context, Ab semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, BacktrackingTestLanguagePackage.Literals.AB__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BacktrackingTestLanguagePackage.Literals.AB__X));
			if(transientValues.isValueTransient(semanticObject, BacktrackingTestLanguagePackage.Literals.AB__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BacktrackingTestLanguagePackage.Literals.AB__Y));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAbAccess().getXCharATerminalRuleCall_0_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getAbAccess().getYCharbTerminalRuleCall_1_0(), semanticObject.getY());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         enums+=EnumName* 
	 *         ycs+=Yc* 
	 *         abs+=Ab* 
	 *         xbs+=Xb* 
	 *         ys+=CharY* 
	 *         as+=CharA*
	 *     )
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (x=CharX y=Charb)
	 */
	protected void sequence_Xb(EObject context, Xb semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, BacktrackingTestLanguagePackage.Literals.XB__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BacktrackingTestLanguagePackage.Literals.XB__X));
			if(transientValues.isValueTransient(semanticObject, BacktrackingTestLanguagePackage.Literals.XB__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, BacktrackingTestLanguagePackage.Literals.XB__Y));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getXbAccess().getXCharXTerminalRuleCall_0_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getXbAccess().getYCharbTerminalRuleCall_1_0(), semanticObject.getY());
		feeder.finish();
	}
}
