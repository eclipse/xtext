package org.eclipse.xtext.parsetree.unassignedtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.unassignedtext.services.UnassignedTextTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CaseInsensitiveKeywordRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.CommonTerminalsRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.DatatypeRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.MultiRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.PluralRule;
import org.eclipse.xtext.parsetree.unassignedtext.unassignedtext.UnassignedtextPackage;
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
public class AbstractUnassignedTextTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected UnassignedTextTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == UnassignedtextPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UnassignedtextPackage.CASE_INSENSITIVE_KEYWORD_RULE:
				if(context == grammarAccess.getCaseInsensitiveKeywordRuleRule() ||
				   context == grammarAccess.getModelRule()) {
					sequence_CaseInsensitiveKeywordRule(context, (CaseInsensitiveKeywordRule) semanticObject); 
					return; 
				}
				else break;
			case UnassignedtextPackage.COMMON_TERMINALS_RULE:
				if(context == grammarAccess.getCommonTerminalsRuleRule() ||
				   context == grammarAccess.getModelRule()) {
					sequence_CommonTerminalsRule(context, (CommonTerminalsRule) semanticObject); 
					return; 
				}
				else break;
			case UnassignedtextPackage.DATATYPE_RULE:
				if(context == grammarAccess.getDatatypeRuleRule() ||
				   context == grammarAccess.getModelRule()) {
					sequence_DatatypeRule(context, (DatatypeRule) semanticObject); 
					return; 
				}
				else break;
			case UnassignedtextPackage.MULTI_RULE:
				if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getMultiRuleRule()) {
					sequence_MultiRule(context, (MultiRule) semanticObject); 
					return; 
				}
				else break;
			case UnassignedtextPackage.PLURAL_RULE:
				if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getPluralRuleRule()) {
					sequence_PluralRule(context, (PluralRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     val=INT
	 */
	protected void sequence_CaseInsensitiveKeywordRule(EObject context, CaseInsensitiveKeywordRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UnassignedtextPackage.Literals.CASE_INSENSITIVE_KEYWORD_RULE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnassignedtextPackage.Literals.CASE_INSENSITIVE_KEYWORD_RULE__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCaseInsensitiveKeywordRuleAccess().getValINTTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_CommonTerminalsRule(EObject context, CommonTerminalsRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UnassignedtextPackage.Literals.COMMON_TERMINALS_RULE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnassignedtextPackage.Literals.COMMON_TERMINALS_RULE__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCommonTerminalsRuleAccess().getValIDTerminalRuleCall_4_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=INT
	 */
	protected void sequence_DatatypeRule(EObject context, DatatypeRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UnassignedtextPackage.Literals.DATATYPE_RULE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnassignedtextPackage.Literals.DATATYPE_RULE__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDatatypeRuleAccess().getValINTTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=INT
	 */
	protected void sequence_MultiRule(EObject context, MultiRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UnassignedtextPackage.Literals.MULTI_RULE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnassignedtextPackage.Literals.MULTI_RULE__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMultiRuleAccess().getValINTTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     count=INT
	 */
	protected void sequence_PluralRule(EObject context, PluralRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UnassignedtextPackage.Literals.PLURAL_RULE__COUNT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UnassignedtextPackage.Literals.PLURAL_RULE__COUNT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPluralRuleAccess().getCountINTTerminalRuleCall_1_0(), semanticObject.getCount());
		feeder.finish();
	}
}
