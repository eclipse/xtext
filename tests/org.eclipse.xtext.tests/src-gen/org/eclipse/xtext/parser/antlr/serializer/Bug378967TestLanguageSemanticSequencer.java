package org.eclipse.xtext.parser.antlr.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.bug378967Test.AfterObj;
import org.eclipse.xtext.parser.antlr.bug378967Test.Bug378967TestPackage;
import org.eclipse.xtext.parser.antlr.bug378967Test.Root;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule1;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule2;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule3;
import org.eclipse.xtext.parser.antlr.bug378967Test.Rule4;
import org.eclipse.xtext.parser.antlr.bug378967Test.SObj;
import org.eclipse.xtext.parser.antlr.services.Bug378967TestLanguageGrammarAccess;
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
public class Bug378967TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Bug378967TestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Bug378967TestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug378967TestPackage.AFTER_OBJ:
				if(context == grammarAccess.getAfterObjRule()) {
					sequence_AfterObj(context, (AfterObj) semanticObject); 
					return; 
				}
				else break;
			case Bug378967TestPackage.ROOT:
				if(context == grammarAccess.getRootRule()) {
					sequence_Root(context, (Root) semanticObject); 
					return; 
				}
				else break;
			case Bug378967TestPackage.RULE1:
				if(context == grammarAccess.getRule1Rule()) {
					sequence_Rule1(context, (Rule1) semanticObject); 
					return; 
				}
				else break;
			case Bug378967TestPackage.RULE2:
				if(context == grammarAccess.getRule2Rule()) {
					sequence_Rule2(context, (Rule2) semanticObject); 
					return; 
				}
				else break;
			case Bug378967TestPackage.RULE3:
				if(context == grammarAccess.getRule3Rule()) {
					sequence_Rule3(context, (Rule3) semanticObject); 
					return; 
				}
				else break;
			case Bug378967TestPackage.RULE4:
				if(context == grammarAccess.getRule4Rule()) {
					sequence_Rule4(context, (Rule4) semanticObject); 
					return; 
				}
				else break;
			case Bug378967TestPackage.SOBJ:
				if(context == grammarAccess.getSObjRule()) {
					sequence_SObj(context, (SObj) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     value='after'
	 */
	protected void sequence_AfterObj(EObject context, AfterObj semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.AFTER_OBJ__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.AFTER_OBJ__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAfterObjAccess().getValueAfterKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (element=Rule1 | element=Rule2 | element=Rule3 | element=Rule4)
	 */
	protected void sequence_Root(EObject context, Root semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (type=FirstEnum value=INT unit=SecondEnum)
	 */
	protected void sequence_Rule1(EObject context, Rule1 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE1__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE1__TYPE));
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE1__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE1__VALUE));
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE1__UNIT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE1__UNIT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRule1Access().getTypeFirstEnumEnumRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getRule1Access().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.accept(grammarAccess.getRule1Access().getUnitSecondEnumEnumRuleCall_2_0(), semanticObject.getUnit());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_Rule2(EObject context, Rule2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE2__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE2__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRule2Access().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=INT
	 */
	protected void sequence_Rule3(EObject context, Rule3 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE3__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE3__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRule3Access().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (after=AfterObj value=INT s=SObj)
	 */
	protected void sequence_Rule4(EObject context, Rule4 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE4__AFTER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE4__AFTER));
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE4__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE4__VALUE));
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.RULE4__S) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.RULE4__S));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRule4Access().getAfterAfterObjParserRuleCall_0_0(), semanticObject.getAfter());
		feeder.accept(grammarAccess.getRule4Access().getValueINTTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.accept(grammarAccess.getRule4Access().getSSObjParserRuleCall_2_0(), semanticObject.getS());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value='s'
	 */
	protected void sequence_SObj(EObject context, SObj semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug378967TestPackage.Literals.SOBJ__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug378967TestPackage.Literals.SOBJ__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSObjAccess().getValueSKeyword_0(), semanticObject.getValue());
		feeder.finish();
	}
}
