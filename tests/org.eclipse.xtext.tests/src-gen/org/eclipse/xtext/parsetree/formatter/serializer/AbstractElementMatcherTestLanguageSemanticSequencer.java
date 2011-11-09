package org.eclipse.xtext.parsetree.formatter.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Add;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Constructor;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.ElementmatchertestlanguagePackage;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Function;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Loop;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Mult;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.NestedStartSub;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCalls;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub1;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub2;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.OptionalCallsSub3;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Parameter;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Pointer;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RecursionSub;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCalls12;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss1;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsAss2;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.RuleCallsSub;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Simple;
import org.eclipse.xtext.parsetree.formatter.elementmatchertestlanguage.Value;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess;
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
public class AbstractElementMatcherTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected ElementMatcherTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == ElementmatchertestlanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ElementmatchertestlanguagePackage.ADD:
				if(context == grammarAccess.getAddRule() ||
				   context == grammarAccess.getAddAccess().getAddLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getMultRule() ||
				   context == grammarAccess.getMultAccess().getMultLeftAction_1_0() ||
				   context == grammarAccess.getPrimRule()) {
					sequence_Add(context, (Add) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.CONSTRUCTOR:
				if(context == grammarAccess.getConstructorRule()) {
					sequence_Constructor(context, (Constructor) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.FUNCTION:
				if(context == grammarAccess.getAddRule() ||
				   context == grammarAccess.getAddAccess().getAddLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getMultRule() ||
				   context == grammarAccess.getMultAccess().getMultLeftAction_1_0() ||
				   context == grammarAccess.getPrimRule()) {
					sequence_Prim(context, (Function) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.LOOP:
				if(context == grammarAccess.getLoopRule() ||
				   context == grammarAccess.getModelRule()) {
					sequence_Loop(context, (Loop) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.MULT:
				if(context == grammarAccess.getAddRule() ||
				   context == grammarAccess.getAddAccess().getAddLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getMultRule() ||
				   context == grammarAccess.getMultAccess().getMultLeftAction_1_0() ||
				   context == grammarAccess.getPrimRule()) {
					sequence_Mult(context, (Mult) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.NESTED_START_SUB:
				if(context == grammarAccess.getNestedStartSubRule()) {
					sequence_NestedStartSub(context, (NestedStartSub) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getNestedStartRule()) {
					sequence_NestedStart(context, (NestedStartSub) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.OPTIONAL_CALLS:
				if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getOptionalCallsRule()) {
					sequence_OptionalCalls(context, (OptionalCalls) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB1:
				if(context == grammarAccess.getOptionalCallsSub1Rule()) {
					sequence_OptionalCallsSub1(context, (OptionalCallsSub1) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB2:
				if(context == grammarAccess.getOptionalCallsSub2Rule()) {
					sequence_OptionalCallsSub2(context, (OptionalCallsSub2) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.OPTIONAL_CALLS_SUB3:
				if(context == grammarAccess.getOptionalCallsSub3Rule()) {
					sequence_OptionalCallsSub3(context, (OptionalCallsSub3) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.PARAMETER:
				if(context == grammarAccess.getFieldRule() ||
				   context == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (Parameter) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.POINTER:
				if(context == grammarAccess.getAddRule() ||
				   context == grammarAccess.getAddAccess().getAddLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getMultRule() ||
				   context == grammarAccess.getMultAccess().getMultLeftAction_1_0() ||
				   context == grammarAccess.getPrimRule()) {
					sequence_Prim(context, (Pointer) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.RECURSION_SUB:
				if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getRecursionRule() ||
				   context == grammarAccess.getRecursionSubRule()) {
					sequence_RecursionSub(context, (RecursionSub) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.RULE_CALLS12:
				if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getRuleCalls12Rule()) {
					sequence_RuleCalls12(context, (RuleCalls12) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.RULE_CALLS_ASS1:
				if(context == grammarAccess.getRuleCallsAss1Rule()) {
					sequence_RuleCallsAss1(context, (RuleCallsAss1) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.RULE_CALLS_ASS2:
				if(context == grammarAccess.getRuleCallsAss2Rule()) {
					sequence_RuleCallsAss2(context, (RuleCallsAss2) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.RULE_CALLS_SUB:
				if(context == grammarAccess.getRuleCallsSubRule()) {
					sequence_RuleCallsSub(context, (RuleCallsSub) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getRuleCallsRule()) {
					sequence_RuleCalls(context, (RuleCallsSub) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.SIMPLE:
				if(context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getSimpleRule()) {
					sequence_Simple(context, (Simple) semanticObject); 
					return; 
				}
				else break;
			case ElementmatchertestlanguagePackage.VALUE:
				if(context == grammarAccess.getAddRule() ||
				   context == grammarAccess.getAddAccess().getAddLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getMultRule() ||
				   context == grammarAccess.getMultAccess().getMultLeftAction_1_0() ||
				   context == grammarAccess.getPrimRule()) {
					sequence_Prim(context, (Value) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (left=Add_Add_1_0 right=Mult)
	 */
	protected void sequence_Add(EObject context, Add semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.ADD__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.ADD__LEFT));
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.ADD__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.ADD__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAddAccess().getAddLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAddAccess().getRightMultParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (kw1?='kw1'?)
	 */
	protected void sequence_Constructor(EObject context, Constructor semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (names+=ID+ gr+=ID* (ints+=INT | strings+=STRING)*)
	 */
	protected void sequence_Loop(EObject context, Loop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Mult_Mult_1_0 right=Prim)
	 */
	protected void sequence_Mult(EObject context, Mult semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.MULT__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.MULT__LEFT));
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.MULT__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.MULT__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMultAccess().getMultLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultAccess().getRightPrimParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {NestedStartSub}
	 */
	protected void sequence_NestedStartSub(EObject context, NestedStartSub semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_NestedStart(EObject context, NestedStartSub semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.NESTED_START_SUB__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.NESTED_START_SUB__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNestedStartAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (opt2=OptionalCallsSub2? opt3=OptionalCallsSub3?)
	 */
	protected void sequence_OptionalCallsSub1(EObject context, OptionalCallsSub1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_OptionalCallsSub2(EObject context, OptionalCallsSub2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.OPTIONAL_CALLS_SUB2__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.OPTIONAL_CALLS_SUB2__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOptionalCallsSub2Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_OptionalCallsSub3(EObject context, OptionalCallsSub3 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.OPTIONAL_CALLS_SUB3__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.OPTIONAL_CALLS_SUB3__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOptionalCallsSub3Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (opt1=OptionalCallsSub1? name=ID)
	 */
	protected void sequence_OptionalCalls(EObject context, OptionalCalls semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (kw2?='kw2'?)
	 */
	protected void sequence_Parameter(EObject context, Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (func=ID param+=Add param+=Add*)
	 */
	protected void sequence_Prim(EObject context, Function semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     target=Prim
	 */
	protected void sequence_Prim(EObject context, Pointer semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.POINTER__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.POINTER__TARGET));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimAccess().getTargetPrimParserRuleCall_2_2_0(), semanticObject.getTarget());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=INT
	 */
	protected void sequence_Prim(EObject context, Value semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.VALUE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.VALUE__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrimAccess().getValINTTerminalRuleCall_0_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((sub+=RecursionSub | vals+=ID)* semi?=';'?)
	 */
	protected void sequence_RecursionSub(EObject context, RecursionSub semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (constructor=Constructor fields+=Field)
	 */
	protected void sequence_RuleCalls12(EObject context, RuleCalls12 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_RuleCallsAss1(EObject context, RuleCallsAss1 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.RULE_CALLS_ASS1__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.RULE_CALLS_ASS1__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRuleCallsAss1Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_RuleCallsAss2(EObject context, RuleCallsAss2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ElementmatchertestlanguagePackage.Literals.RULE_CALLS_ASS2__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ElementmatchertestlanguagePackage.Literals.RULE_CALLS_ASS2__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRuleCallsAss2Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     sub='sub'
	 */
	protected void sequence_RuleCallsSub(EObject context, RuleCallsSub semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (sub='sub' name=ID call1=RuleCallsAss1? call2=RuleCallsAss2?)
	 */
	protected void sequence_RuleCalls(EObject context, RuleCallsSub semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID optional=ID? datatype=FQN)
	 */
	protected void sequence_Simple(EObject context, Simple semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
