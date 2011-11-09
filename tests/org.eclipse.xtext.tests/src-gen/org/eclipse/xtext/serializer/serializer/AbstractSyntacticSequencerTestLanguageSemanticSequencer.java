package org.eclipse.xtext.serializer.serializer;

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
import org.eclipse.xtext.serializer.services.SyntacticSequencerTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.syntacticsequencertest.Add0;
import org.eclipse.xtext.serializer.syntacticsequencertest.Add1;
import org.eclipse.xtext.serializer.syntacticsequencertest.Add2;
import org.eclipse.xtext.serializer.syntacticsequencertest.AlternativeTransition;
import org.eclipse.xtext.serializer.syntacticsequencertest.BooleanAlternative;
import org.eclipse.xtext.serializer.syntacticsequencertest.BooleanAlternativeLiteral;
import org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryKeywords;
import org.eclipse.xtext.serializer.syntacticsequencertest.MandatoryManyTransition;
import org.eclipse.xtext.serializer.syntacticsequencertest.Model;
import org.eclipse.xtext.serializer.syntacticsequencertest.Mult2;
import org.eclipse.xtext.serializer.syntacticsequencertest.OptionalManyTransition;
import org.eclipse.xtext.serializer.syntacticsequencertest.OptionalSingleTransition;
import org.eclipse.xtext.serializer.syntacticsequencertest.SingleCrossReference;
import org.eclipse.xtext.serializer.syntacticsequencertest.SyntacticsequencertestPackage;
import org.eclipse.xtext.serializer.syntacticsequencertest.UnassignedDatatype;
import org.eclipse.xtext.serializer.syntacticsequencertest.Val0;
import org.eclipse.xtext.serializer.syntacticsequencertest.Val1;
import org.eclipse.xtext.serializer.syntacticsequencertest.Val2;

@SuppressWarnings("restriction")
public class AbstractSyntacticSequencerTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected SyntacticSequencerTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == SyntacticsequencertestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case SyntacticsequencertestPackage.ADD0:
				if(context == grammarAccess.getAddition0Rule() ||
				   context == grammarAccess.getAddition0Access().getAdd0LeftAction_1_0() ||
				   context == grammarAccess.getExp0Rule()) {
					sequence_Addition0(context, (Add0) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.ADD1:
				if(context == grammarAccess.getAddition1Rule() ||
				   context == grammarAccess.getAddition1Access().getAdd1LeftAction_1_0() ||
				   context == grammarAccess.getExp1Rule() ||
				   context == grammarAccess.getPrim1Rule()) {
					sequence_Addition1(context, (Add1) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.ADD2:
				if(context == grammarAccess.getAddition2Rule() ||
				   context == grammarAccess.getAddition2Access().getAdd2LeftAction_1_0() ||
				   context == grammarAccess.getExp2Rule() ||
				   context == grammarAccess.getMultiplication2Rule() ||
				   context == grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0() ||
				   context == grammarAccess.getPrim2Rule()) {
					sequence_Addition2(context, (Add2) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.ALTERNATIVE_TRANSITION:
				if(context == grammarAccess.getAlternativeTransitionRule()) {
					sequence_AlternativeTransition(context, (AlternativeTransition) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE:
				if(context == grammarAccess.getBooleanAlternativeRule()) {
					sequence_BooleanAlternative(context, (BooleanAlternative) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.BOOLEAN_ALTERNATIVE_LITERAL:
				if(context == grammarAccess.getBooleanAlternativeLiteralRule()) {
					sequence_BooleanAlternativeLiteral(context, (BooleanAlternativeLiteral) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.MANDATORY_KEYWORDS:
				if(context == grammarAccess.getMandatoryKeywordsRule()) {
					sequence_MandatoryKeywords(context, (MandatoryKeywords) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.MANDATORY_MANY_TRANSITION:
				if(context == grammarAccess.getMandatoryManyTransitionRule()) {
					sequence_MandatoryManyTransition(context, (MandatoryManyTransition) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.MULT2:
				if(context == grammarAccess.getAddition2Rule() ||
				   context == grammarAccess.getAddition2Access().getAdd2LeftAction_1_0() ||
				   context == grammarAccess.getExp2Rule() ||
				   context == grammarAccess.getMultiplication2Rule() ||
				   context == grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0() ||
				   context == grammarAccess.getPrim2Rule()) {
					sequence_Multiplication2(context, (Mult2) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.OPTIONAL_MANY_TRANSITION:
				if(context == grammarAccess.getOptionalManyTransitionRule()) {
					sequence_OptionalManyTransition(context, (OptionalManyTransition) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.OPTIONAL_SINGLE_TRANSITION:
				if(context == grammarAccess.getOptionalSingleTransitionRule()) {
					sequence_OptionalSingleTransition(context, (OptionalSingleTransition) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.SINGLE_CROSS_REFERENCE:
				if(context == grammarAccess.getSingleCrossReferenceRule()) {
					sequence_SingleCrossReference(context, (SingleCrossReference) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.UNASSIGNED_DATATYPE:
				if(context == grammarAccess.getUnassignedDatatypeRule()) {
					sequence_UnassignedDatatype(context, (UnassignedDatatype) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.VAL0:
				if(context == grammarAccess.getAddition0Rule() ||
				   context == grammarAccess.getAddition0Access().getAdd0LeftAction_1_0() ||
				   context == grammarAccess.getExp0Rule() ||
				   context == grammarAccess.getPrim0Rule()) {
					sequence_Prim0(context, (Val0) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.VAL1:
				if(context == grammarAccess.getAddition1Rule() ||
				   context == grammarAccess.getAddition1Access().getAdd1LeftAction_1_0() ||
				   context == grammarAccess.getExp1Rule() ||
				   context == grammarAccess.getPrim1Rule()) {
					sequence_Prim1(context, (Val1) semanticObject); 
					return; 
				}
				else break;
			case SyntacticsequencertestPackage.VAL2:
				if(context == grammarAccess.getAddition2Rule() ||
				   context == grammarAccess.getAddition2Access().getAdd2LeftAction_1_0() ||
				   context == grammarAccess.getExp2Rule() ||
				   context == grammarAccess.getMultiplication2Rule() ||
				   context == grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0() ||
				   context == grammarAccess.getPrim2Rule()) {
					sequence_Prim2(context, (Val2) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (left=Addition0_Add0_1_0 right=Prim0)
	 */
	protected void sequence_Addition0(EObject context, Add0 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD0__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD0__LEFT));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD0__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD0__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAddition0Access().getAdd0LeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAddition0Access().getRightPrim0ParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=Addition1_Add1_1_0 right=Prim1)
	 */
	protected void sequence_Addition1(EObject context, Add1 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD1__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD1__LEFT));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD1__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD1__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAddition1Access().getAdd1LeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAddition1Access().getRightPrim1ParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (left=Addition2_Add2_1_0 right=Multiplication2)
	 */
	protected void sequence_Addition2(EObject context, Add2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD2__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD2__LEFT));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ADD2__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ADD2__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAddition2Access().getAdd2LeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAddition2Access().getRightMultiplication2ParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_AlternativeTransition(EObject context, AlternativeTransition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.ALTERNATIVE_TRANSITION__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.ALTERNATIVE_TRANSITION__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAlternativeTransitionAccess().getValIDTerminalRuleCall_2_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (isTrue?='kw2'?)
	 */
	protected void sequence_BooleanAlternativeLiteral(EObject context, BooleanAlternativeLiteral semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     bool=BooleanAlternativeLiteral
	 */
	protected void sequence_BooleanAlternative(EObject context, BooleanAlternative semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.BOOLEAN_ALTERNATIVE__BOOL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.BOOLEAN_ALTERNATIVE__BOOL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBooleanAlternativeAccess().getBoolBooleanAlternativeLiteralParserRuleCall_1_0(), semanticObject.getBool());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (val1=ID val2=ID val3=ID)
	 */
	protected void sequence_MandatoryKeywords(EObject context, MandatoryKeywords semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL1));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL2));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL3) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_KEYWORDS__VAL3));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMandatoryKeywordsAccess().getVal1IDTerminalRuleCall_1_0(), semanticObject.getVal1());
		feeder.accept(grammarAccess.getMandatoryKeywordsAccess().getVal2IDTerminalRuleCall_3_0(), semanticObject.getVal2());
		feeder.accept(grammarAccess.getMandatoryKeywordsAccess().getVal3IDTerminalRuleCall_6_0(), semanticObject.getVal3());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_MandatoryManyTransition(EObject context, MandatoryManyTransition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_MANY_TRANSITION__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MANDATORY_MANY_TRANSITION__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMandatoryManyTransitionAccess().getValIDTerminalRuleCall_2_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         x1=MandatoryKeywords | 
	 *         x2=Exp0 | 
	 *         x3=Exp1 | 
	 *         x4=Exp2 | 
	 *         x5=SingleCrossReference | 
	 *         x6=BooleanAlternative | 
	 *         x7=UnassignedDatatype | 
	 *         x8=OptionalSingleTransition | 
	 *         x9=OptionalManyTransition | 
	 *         x10=MandatoryManyTransition | 
	 *         x11=AlternativeTransition
	 *     )
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Multiplication2_Mult2_1_0 right=Prim2)
	 */
	protected void sequence_Multiplication2(EObject context, Mult2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MULT2__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MULT2__LEFT));
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.MULT2__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.MULT2__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMultiplication2Access().getMult2LeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplication2Access().getRightPrim2ParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_OptionalManyTransition(EObject context, OptionalManyTransition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.OPTIONAL_MANY_TRANSITION__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.OPTIONAL_MANY_TRANSITION__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOptionalManyTransitionAccess().getValIDTerminalRuleCall_2_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_OptionalSingleTransition(EObject context, OptionalSingleTransition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.OPTIONAL_SINGLE_TRANSITION__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.OPTIONAL_SINGLE_TRANSITION__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOptionalSingleTransitionAccess().getValIDTerminalRuleCall_2_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Prim0(EObject context, Val0 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.VAL0__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.VAL0__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrim0Access().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Prim1(EObject context, Val1 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.VAL1__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.VAL1__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrim1Access().getNameIDTerminalRuleCall_0_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Prim2(EObject context, Val2 semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.VAL2__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.VAL2__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrim2Access().getNameIDTerminalRuleCall_0_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (name=TerminalID | name=ID) 
	 *         ref1=[SingleCrossReference|TerminalID]? 
	 *         ref2=[SingleCrossReference|DatatypeID]? 
	 *         ref3=[SingleCrossReference|ID]? 
	 *         ref4=[SingleCrossReference|ID]?
	 *     )
	 */
	protected void sequence_SingleCrossReference(EObject context, SingleCrossReference semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     val=ID
	 */
	protected void sequence_UnassignedDatatype(EObject context, UnassignedDatatype semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, SyntacticsequencertestPackage.Literals.UNASSIGNED_DATATYPE__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, SyntacticsequencertestPackage.Literals.UNASSIGNED_DATATYPE__VAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUnassignedDatatypeAccess().getValIDTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
}
